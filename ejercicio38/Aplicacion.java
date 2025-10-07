package ejercicio38;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Aplicacion {

	static Scanner sc=new Scanner(System.in);
	static LinkedHashSet<String> expedienteAlumno = new LinkedHashSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		expedienteAlumno.add("Expediente 1");
		expedienteAlumno.add("Expediente 2");
		expedienteAlumno.add("Expediente 3");
		expedienteAlumno.add("Expediente 4");
		expedienteAlumno.add("Expediente 5");
		expedienteAlumno.add("Expediente 6");
		expedienteAlumno.add("Expediente 7");
		expedienteAlumno.add("Expediente 8");
		expedienteAlumno.add("Expediente 9");
		expedienteAlumno.add("Expediente 10");
		
		System.out.println(expedienteAlumno);
		
		boolean salir=false;
		while(!salir) {
			
			System.out.println("MENU");
			System.out.println("1 Añadir Expediente");
			System.out.println("2 Buscar Expediente");
			System.out.println("3 Borrar Expediente");
			System.out.println("4 Listar Expedientes");
			System.out.println("5 Salir");
			
			int opcion=sc.nextInt();
			sc.nextLine();
			switch(opcion) {
			case 1:
				aniadirExpediente();
				break;
			case 2:
				buscarExpediente();
				break;
			case 3:
				eliminarExpediente();
				break;
			case 4:
				enlistarExpedientes();
				break;
			case 5:
				salir=true;
				break;
			default: 
				System.out.println("Solo leo los numeros que salen al lado de cada opcion.");
				break;
				
			}	
		}
						
	}
	
	public static void aniadirExpediente() {
		System.out.println("Has seleccionado Añadir Expediente");
		System.out.println("");
		System.out.println("Introduzca el expediente que quiera añadir: ");
		String nuevoExpediente=sc.nextLine();
		
		if(expedienteAlumno.contains(nuevoExpediente)) {
		    System.out.println("Ese expediente ya existe");
		} else {
		    expedienteAlumno.add(nuevoExpediente);
		}

	}
	
	public static void buscarExpediente() {
		System.out.println("Has seleccionado Buscar Expediente");
		System.out.println();
		System.out.println("Introduzca el expediente que este buscando: ");
		String expedienteBuscar=sc.nextLine();
		
		boolean encontrado=false;
		for(String expediente: expedienteAlumno) {
			
			if(expediente.equals(expedienteBuscar)) {
				System.out.println("Expediente encontrado " + expediente);
				encontrado=true;
				break;
			}
		}
		
		// Fuera del bucle porque si no se me repito por cada vez que no sea el expediente que busco
		if(!encontrado) {
			System.out.println("No se encontro el expediente qu7e esta buscando");
		}
	}
	
	public static void eliminarExpediente() {
		
		System.out.println("Has seleccionado Eliminar Expediente");
		System.out.println();
		System.out.println("Aqui esta la lista actual de expedientes");
		enlistarExpedientes();
		System.out.println("");
		System.out.println("");
		System.out.println("Introduzca el expediente que quiera eliminar: ");
		String expedienteEliminar=sc.nextLine();
		
		Iterator<String> it = expedienteAlumno.iterator();
		boolean encontrado = false;
		while(it.hasNext()) {
		    String expediente = it.next();
		    if(expediente.equals(expedienteEliminar)) {
		        it.remove();
		        System.out.println("Expediente eliminado correctamente");
		        encontrado = true;
		        break;
		    }
		}
		if(!encontrado) {
		    System.out.println("No se encontro el expediente");
		}

}
	
	public static void enlistarExpedientes() {
		
		System.out.println("Lista actual de expedientes");
		for(String expediente: expedienteAlumno) {
			System.out.println("-" + expediente);
		}
		
	}

}
