/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listaCalif;

/**
 *
 * @author Lenovo_PC
 */
import java.util.Scanner;

public class ListaCalificacionesMain {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ListaLigadaCalificaciones lista = new ListaLigadaCalificaciones();

        // Datos de prueba
        lista.insertarOrdenado(85);
        lista.insertarOrdenado(70);
        lista.insertarOrdenado(95);
        lista.insertarOrdenado(80);
        lista.insertarOrdenado(-5);
        lista.insertarOrdenado(105);

        int opcion;

        do {

            System.out.println("\n--- MENU DE CALIFICACIONES ---");
            System.out.println("1. Insertar calificacion de forma ordenada");
            System.out.println("2. Mostrar calificaciones y calcular mediana");
            System.out.println("3. Consultar calificacion minima y maxima");
            System.out.println("4. Eliminar calificaciones invalidas");
            System.out.println("5. Buscar una calificacion especifica");
            System.out.println("6. Mostrar total de estudiantes registrados");
            System.out.println("7. Consultar calificacion por posicion");
            System.out.println("8. Corregir calificacion");
            System.out.println("9. Eliminar calificacion por posicion");
            System.out.println("10. Mostrar lista ordenada");
            System.out.println("11. Salir del programa");

            System.out.print("\nSelecciona una opcion: ");
            opcion = entrada.nextInt();

            try {

                switch (opcion) {

                    case 1:
                        System.out.print("Ingresa la calificacion: ");
                        double cal = entrada.nextDouble();

                        lista.insertarOrdenado(cal);

                        System.out.println("Calificacion registrada.");
                        break;

                    case 2:
                        System.out.println("\n--- CALIFICACIONES ---");
                        System.out.println(lista);

                        System.out.println("\n--- MEDIANA ---");
                        System.out.println(lista.obtenerCalMediana());
                        break;

                    case 3:
                        System.out.println("\n--- CALIFICACION MINIMA ---");
                        System.out.println(lista.obtenerCalMinimia());

                        System.out.println("\n--- CALIFICACION MAXIMA ---");
                        System.out.println(lista.obtenerCalMaxima());
                        break;

                    case 4:
                        lista.eliminarCalInvalida();

                        System.out.println("Calificaciones invalidas eliminadas.");
                        break;

                    case 5:
                        System.out.print("Ingresa la calificacion a buscar: ");
                        double buscar = entrada.nextDouble();

                        if (lista.buscarCalEspecifica(buscar)) {
                            System.out.println("La calificacion existe.");
                        } else {
                            System.out.println("La calificacion no existe.");
                        }
                        break;

                    case 6:
                        System.out.println("Total de estudiantes registrados: "
                                + lista.totalEstudiantes());
                        break;

                    case 7:
                        System.out.print("Ingresa la posicion: ");
                        int pos = entrada.nextInt();

                        System.out.println("Calificacion: "
                                + lista.obtenerCalificacion(pos));
                        break;

                    case 8:
                        System.out.print("Ingresa la posicion a corregir: ");
                        int posicion = entrada.nextInt();

                        System.out.print("Ingresa la nueva calificacion: ");
                        double nuevoValor = entrada.nextDouble();

                        lista.corregirCalificaion(posicion, nuevoValor);

                        System.out.println("Calificacion corregida.");
                        break;

                    case 9:
                        System.out.print("Ingresa la posicion a eliminar: ");
                        int eliminarPos = entrada.nextInt();

                        double eliminado = lista.eliminar(eliminarPos);

                        System.out.println("Calificacion eliminada: " + eliminado);
                        break;

                    case 10:
                        System.out.println("\n--- LISTA DE CALIFICACIONES ORDENADAS ---");
                        System.out.println(lista);
                        break;

                    case 11:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opcion incorrecta.");
                        break;
                }

            } catch (IllegalStateException | IllegalArgumentException e) {

                System.out.println("Aviso: " + e.getMessage());

            }

        } while (opcion != 11);

        entrada.close();
    }

}
