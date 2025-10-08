import os
import shutil
import subprocess
from pathlib import Path
from datetime import datetime

# ==============================
# CONFIGURACIÓN
# ==============================
PROJECTS_DIR = (
    r"C:\Users\casit\OneDrive\Documentos\Exportacionjava"  # Carpeta de proyectos local
)
BACKUP_DEST = (
    r"C:\Users\casit\OneDrive\Documentos\CarpetaBackUps"  # Carpeta de red (NAS)
)
GITHUB_REMOTE_NAME = "origin"
GITHUB_REPO_SSH = "git@github.com:SrAndrew05-ui/DASPEjercicio1.git"
COMMIT_MSG = "Backup automático desde script"


# ==============================
# FUNCIONES
# ==============================
def log(msg):
    """Imprime mensaje con timestamp"""
    print(f"[{datetime.now().strftime('%Y-%m-%d %H:%M:%S')}] {msg}")


# --------- Backup hacia GitHub ----------
def backup_to_github(project_path):
    git_dir = os.path.join(project_path, ".git")
    if not os.path.exists(git_dir):
        log("⚠️ No es un repositorio Git válido.")
        return

    try:
        subprocess.run(
            [
                "git",
                "-C",
                project_path,
                "remote",
                "set-url",
                GITHUB_REMOTE_NAME,
                GITHUB_REPO_SSH,
            ],
            check=True,
        )
        result = subprocess.run(
            ["git", "-C", project_path, "status", "--porcelain"],
            capture_output=True,
            text=True,
        )
        if result.stdout.strip() == "":
            log("No hay cambios que subir a GitHub.")
            return
        subprocess.run(["git", "-C", project_path, "add", "."], check=True)
        subprocess.run(
            ["git", "-C", project_path, "commit", "-m", COMMIT_MSG], check=True
        )
        subprocess.run(
            ["git", "-C", project_path, "push", GITHUB_REMOTE_NAME, "main"], check=True
        )
        log("✅ Backup en GitHub completado en DASPEjercicio1.")
    except subprocess.CalledProcessError as e:
        log(f"❌ Error en el backup hacia GitHub: {e}")


# --------- Backup hacia NAS comprimido ----------
def backup_to_nas_zip(source, destination):
    source = Path(source)
    destination = Path(destination)
    if not destination.exists():
        destination.mkdir(parents=True)

    # Crear nombre de archivo con fecha y hora
    zip_name = f"backup_{datetime.now().strftime('%Y%m%d_%H%M%S')}"
    zip_path = destination / zip_name

    # Crear archivo zip
    shutil.make_archive(str(zip_path), "zip", source)
    log(f"📦 Backup NAS comprimido creado: {zip_path}.zip")


# ==============================
# MENÚ PRINCIPAL
# ==============================
if __name__ == "__main__":
    print("=== SISTEMA DE BACKUPS AUTOMÁTICOS ===")
    print("1. Backup hacia GitHub")
    print("2. Backup hacia NAS/Carpeta compartida (comprimido)")
    opcion = input("Selecciona una opción (1/2): ")

    if opcion == "1":
        backup_to_github(PROJECTS_DIR)
    elif opcion == "2":
        backup_to_nas_zip(PROJECTS_DIR, BACKUP_DEST)
    else:
        print("❌ Opción inválida.")

# By Andrei_Iordache
