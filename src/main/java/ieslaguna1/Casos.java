package ieslaguna1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Casos {
//Recibimos la opcion seleccionada en el menu y el Scanner creado en Main
    public void ejecutarOpcion(int opcion, Scanner teclado) {

        // Indicamos dependiendo de la opción, la acción a ejecutar
        switch (opcion) {

            case 1:
                System.out.println("Introduce el código de usuario");
                String codigo = teclado.next();
                //Variable para comprobar si el ususario ya existe
                boolean existe = false;
                try {
                    //abrimos el fichero de usuarios para leerlo
                    BufferedReader lector = new BufferedReader(new FileReader("usuarios.txt"));
                    String linea;
                    //Recorremos las lineas
                    while ((linea = lector.readLine()) != null) {

                        if (linea.startsWith(codigo + " ")) {
                            existe = true;
                        }
                    }
                    lector.close();
                    if (existe) {
                        System.out.println("ERROR:  el código de usuario ya existe");
                    } else {
                        teclado.nextLine();

                        System.out.println("Introduce las aficiones separadas por espacios");
                        String aficiones = teclado.nextLine();

                        FileWriter escritor = new FileWriter("usuarios.txt", true);
                        escritor.write(codigo + " " + aficiones + "\n");
                        escritor.close();
                        System.out.println("Usuario añadido correctamente");
                    }
                } catch (IOException e) {
                    System.out.println("Error al acceder al archivo");
                }
                break;

            case 2:
                try {
// Ejecutamos código de lectura
                    BufferedReader lector = new BufferedReader(new FileReader("usuarios.txt"));

                    String linea;
// va leyendo todos los usuarios del fichero, desde U100 hasta U109
                    while ((linea = lector.readLine()) != null) {

                        System.out.println(linea);

                    }

                    lector.close();

                } catch (IOException e) {

                    System.out.println("Error al leer el fichero");

                }

                break;

            case 3:
                //Pedimos el número de concordancias
                System.out.println("Introduce el número mínimo de concordancias");
                // creamos la variable para almacenar el número mínimo de concordancias
                int minimo = teclado.nextInt();

                // Mientras el número introducido sea menor que 1 seguimos pidiendo otro número
                while (minimo < 1) {
                    // Pedimos al usuario que introduzca de nuevo el número
                    System.out.println("ERROR: El número debe ser mayor o igual que 1");
                    System.out.println("Introduce de nuevo el número mínimo de concordancias ");
                    minimo = teclado.nextInt();
                }

                // Mostramos el número mínimo válido que ha seleccionado el usuario
                System.out.println("Número mínimo seleccionado" + minimo);

                //Creamos una lista donde guardaremos los usuarios
                ArrayList<String> usuarios = new ArrayList<>();

                try {
                    BufferedReader lector = new BufferedReader(new FileReader("usuarios.txt"));
                    String linea;
                    while ((linea = lector.readLine()) != null) {
                        usuarios.add(linea);
                    }
                    lector.close();
                } catch (IOException e) {
                    System.out.println("Error al leer el fichero");
                }
                // Comparamos cada usuario con los usuarios siguientes
                for (int i = 0; i < usuarios.size(); i++) {

                    for (int j = i + 1; j < usuarios.size(); j++) {

                        System.out.println(usuarios.get(i) + usuarios.get(j));

                    }
                }
                break;


            case 5:


            default:
                System.out.println("Opción incorrecta");
        }
    }
}
