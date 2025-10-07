package ejercicio15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Aplicacion {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Escribe la ruta del fichero");
        String rutaFichero = sc.nextLine();

        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    String[] partes = linea.split(";");
                    if (partes.length == 3) {
                        String nombre = partes[0];
                        String apellidos = partes[1];
                        String telefono = partes[2];

                        System.out.println("Nombre: " + nombre +
                                ", Apellidos: " + apellidos +
                                ", Teléfono: " + telefono);

                        contador++;
                    }
                }
            }

            System.out.println("Número total de personas en el fichero: " + contador);

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        sc.close();
    }
}
