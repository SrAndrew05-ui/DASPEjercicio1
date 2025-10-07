package ejercicio29;

import java.util.ArrayList;

public class Alumno {

	String Expediente;
	String Nombre;
	String Apellido;
	ArrayList<Double> notas;
	
	public Alumno(String expediente, String nombre, String apellido,ArrayList<Double> notas) {
        Expediente = expediente;
        Nombre = nombre;
        Apellido = apellido;
        this.notas = notas;
    }
	public String getExpediente() {
		return Expediente;
	}
	public void setExpediente(String expediente) {
		if(expediente.length()>8) {
			this.Expediente=expediente.substring(0, 8);
		}else {
			Expediente=expediente;
		}
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		
		if(nombre.length()>20) {
			this.Nombre=nombre.substring(0, 20);
		}else {
			Nombre = nombre;
		}
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		
		if(apellido.length()>40) {
			this.Apellido=apellido.substring(0, 40);
		}else {
			Apellido = apellido;
		}
	}
	public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }
	
	
	@Override
	public String toString() {
		return "Alumno [Expediente=" + Expediente + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Notas=" + notas + "]";
	}
	
	public void aniadirNota(double numero) {
        notas.add(numero);
    }
	
	public double calcularNota() {
	    if (notas.isEmpty()) {
	        return 0; // o quizás lanzar una excepción
	    }

	    double suma = 0;
	    for (double nota : notas) {
	        suma += nota;
	    }

	    return suma / notas.size();
	}

}
