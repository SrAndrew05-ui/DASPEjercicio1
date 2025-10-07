package ejercicio29;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Ejercicio 29
		
		ArrayList<Double> listaNotas=new ArrayList<>();
		
		listaNotas.add(5.2);
		listaNotas.add(7.3);
		listaNotas.add(8.1);
		
		Alumno a1=new Alumno("A1234567","Andrei","Iordache",listaNotas);
		
		System.out.println(a1);
		double media = a1.calcularNota();
		System.out.println("La nota media es " + String.format("%.2f", media));
		
		System.out.println();
		
		// Ejercicios 30
		
		ArrayList<String> listaAlumnos = new ArrayList<>();
		
		listaAlumnos.add("Abel");
		listaAlumnos.add("Andrei");
		listaAlumnos.add("Gregorio");
		listaAlumnos.add("Juan");
		listaAlumnos.add("Pepe");
		listaAlumnos.add("Gregorio"); // Reperido
		
		System.out.println(listaAlumnos);
		System.out.println();
		
		// Ejercicio 31
		
		HashSet<String> listaProfesores=new HashSet<>();
		
		listaProfesores.add("Juan");
        listaProfesores.add("María");
        listaProfesores.add("Pedro");
        listaProfesores.add("Lucía");
        listaProfesores.add("Ana");
        listaProfesores.add("Juan"); // Repetido
        listaProfesores.add("Pedro"); // Repetido
		
		System.out.println(listaProfesores);
		System.out.println();
		
		// Ejercicio 32
		
		LinkedHashSet<String> listaNivelesEducativos = new LinkedHashSet<>();
		
		listaNivelesEducativos.add("ESO");
		listaNivelesEducativos.add("GM-SMR");
		listaNivelesEducativos.add("GS-DAM");
		listaNivelesEducativos.add("GS-ASIR");
		listaNivelesEducativos.add("BACH");
		
		System.out.println(listaNivelesEducativos);
		
		// Ejercicio 33
		
		
		
	}

}
