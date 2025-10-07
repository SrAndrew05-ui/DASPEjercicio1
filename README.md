# Backup Automático de Proyectos Java

¡Hola! 👋 Este proyecto es un script en Python que hace copias de seguridad automáticas de mis proyectos Java, **tanto a GitHub como a una carpeta local/NAS**. Así nunca pierdo nada si pasa algo con mi ordenador.

---

## 📂 Qué hace este script

1. **Backup a GitHub**

   - Detecta si la carpeta que indiques es un repositorio Git.
   - Si hay cambios nuevos, los añade, hace commit y los sube automáticamente al repo de GitHub.
   - Solo sube lo que ha cambiado, así no se duplica nada.

2. **Backup a NAS / Carpeta local**
   - Copia los proyectos a otra carpeta de tu ordenador o red.
   - Solo copia archivos nuevos o modificados.
   - Evita duplicados innecesarios.

---

## ⚙️ Requisitos previos

Para que funcione correctamente necesitas:

- **Python 3** instalado.
- **Git** instalado y añadido al PATH.
- Tener un **repositorio GitHub** creado y acceso por **SSH** configurado.
- (Opcional) Una carpeta de red compartida o una carpeta local para el backup incremental.

---

## 🛠️ Cómo usarlo

1. Clona o descarga este proyecto en tu PC.
2. Abre el archivo `backup.py` y revisa la configuración:

```python
PROJECTS_DIR = r"C:\ruta\a\tu\proyecto"          # Carpeta de tus proyectos
BACKUP_DEST = r"C:\ruta\a\la\carpeta\backup"    # Carpeta para backup incremental
GITHUB_REPO_SSH = "git@github.com:usuario/repo.git"  # Tu repo de GitHub vía SSH
COMMIT_MSG = "Backup automático desde script"    # Mensaje que se usa al subir
```

3. Ejecuta el script desde tu terminal o Visual Studio Code:

```bash
python backup.py
```

4. Te aparecerá un menú:

```
=== SISTEMA DE BACKUPS AUTOMÁTICOS ===
1. Backup hacia GitHub
2. Backup hacia NAS/Carpeta compartida
Selecciona una opción (1/2):
```

- Pulsa `1` para subir cambios a GitHub.
- Pulsa `2` para hacer backup a la carpeta/NAS.

5. Listo, el script hará todo automáticamente y mostrará un log en pantalla de lo que se está copiando o subiendo.

---

## 💡 Ejemplo de ejecución

```
=== SISTEMA DE BACKUPS AUTOMÁTICOS ===
Selecciona una opción (1/2): 1
[2025-10-07 18:06:48] ✅ Backup en GitHub completado en DASPEjercicio1.
```

```
=== SISTEMA DE BACKUPS AUTOMÁTICOS ===
Selecciona una opción (1/2): 2
[2025-10-07 18:07:10] 📂 Copiado: C:\Users\...\Aplicacion.java → C:\Backup\Aplicacion.java
```

---

## ⚠️ Posibles problemas y soluciones

- **No es un repositorio Git válido**
  - Asegúrate de que la carpeta indicada en `PROJECTS_DIR` tenga un `.git`.
  - Si no, inicializa Git y conecta al remoto:

```bash
git init
git remote add origin git@github.com:usuario/repo.git
```

- **Errores al hacer push**

  - Si el remoto ya tiene commits, haz primero un `git pull` antes de usar el script.

- **Archivos duplicados en NAS**
  - El script compara contenido antes de copiar, así que no duplica nada.

---

## 🔹 Notas finales

- Este script **solo sube cambios que haya detectado**, por eso si ya subiste todo antes, te dirá que no hay cambios.
- Puedes modificar la ruta de `PROJECTS_DIR` y `BACKUP_DEST` para adaptarlo a tus carpetas y proyectos.
- Lo bueno de esto es que ahora **nunca perderé mis proyectos Java**, y todo está automatizado con un solo clic.

---

**By Andrei Iordache**  
Fecha de entrega: 8 de Octubre 2025
