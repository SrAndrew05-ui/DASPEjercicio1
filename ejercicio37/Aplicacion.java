package ejercicio37;

import java.util.TreeSet;

public class Aplicacion {
    public static void main(String[] args) {
        TreeSet<String> clavesProfesores = new TreeSet<>();

        clavesProfesores.add("IFC02 - Juan");
        clavesProfesores.add("FOL01 - María");
        clavesProfesores.add("IFC08 - Pedro");
        clavesProfesores.add("ING06 - Lucía");
        clavesProfesores.add("FPIFC01 - Ana");

        System.out.println("Lista de claves y profesores:");
        for(String cp : clavesProfesores) {
            System.out.println(cp);
        }
    }
}
