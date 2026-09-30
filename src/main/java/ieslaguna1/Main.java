package ieslaguna1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;


public class Main {

    public static void main(String[] args) {

// introducimos la clase Scanner para que pueda leer los datos introducidos por el ususario
        Scanner teclado = new Scanner(System.in);
// Creo una variable con un valor inicial de 0 donde guardamos la opción del menú
        int opcion = 0;
        //Creo un objeto de la clase Casos donde están las acciones que corresponden
        //a cada elección del menu
        Casos casos = new Casos();
// Mientras opcion sea diferente de 5, ejecuta lo que hay dentro.
        while (opcion != 5) {
            //Mostramos el menu principal
            System.out.println("========== MENÚ PRINCIPAL ==========");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Mostrar usuarios introducidos");
            System.out.println("3. Generar fichero de concordancias");
            System.out.println("5. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opción: ");
            //Guardamos la ocpión introducida por el usuario
            opcion = teclado.nextInt();
            //Enviamos la opcion seleccionada la clase Casos para ejecutarla
            casos.ejecutarOpcion(opcion, teclado);

        }
    }
}
