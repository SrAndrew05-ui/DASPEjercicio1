package ejercicio35;

import java.util.HashSet;
import java.util.Scanner;

public class Aplicacion {
	
    static Scanner sc = new Scanner(System.in);
    static HashSet<String> listaProfesores = new HashSet<>();
	
    public static void main(String[] args) {

        listaProfesores.add("Juan");
        listaProfesores.add("María");
        listaProfesores.add("Pedro");
        listaProfesores.add("Lucía");
        listaProfesores.add("Ana");

        boolean salir = false;
		
        while (!salir) {
            System.out.println(" MENU ");
            System.out.println(" 1 - Añadir Profesor ");
            System.out.println(" 2 - Borrar Profesor ");
            System.out.println(" 3 - Listar ");
            System.out.println(" 4 - Salir ");
		
            int opcion = sc.nextInt();	
            sc.nextLine();

            switch(opcion) {
                case 1:
                 aniadirElemento();
                 break;
                case 2: 
                	borrarElemento();
                	break;
                case 3:
                	listarElementos();
                	break;
                case 4:
                	salir = true;
                	break;
                default:
                	System.out.println("Solo acepto un numero de la lista");
                	break;
            }
        }
    }

    public static void aniadirElemento() {
        System.out.println("Has seleccionado Añadir Nuevo Profesor ");
        System.out.println("Escribe el nombre del Profesor que quieras añadir: ");
        String nuevoProfesor = sc.nextLine();
		
        listaProfesores.add(nuevoProfesor);
        listarElementos();
    }
	
    public static void borrarElemento() {
        System.out.println("Has seleccionado Borrar Profesor ");
        listarElementos();
        System.out.println("Escribe el nombre del profesor que quieras borrar:");
        String borrarProfesor = sc.nextLine();
		
        if (listaProfesores.remove(borrarProfesor)) {
            System.out.println("Se ha eliminado al profesor correctamente.");
        } else {
            System.out.println("El nombre del profesor que has escrito no se encuentra en la lista.");	
        }
        listarElementos();
    }

    public static void listarElementos() {
        System.out.println("Lista actual de profesores:");
        for (String profesor : listaProfesores) {
            System.out.println("- " + profesor);
        }
    }
}
