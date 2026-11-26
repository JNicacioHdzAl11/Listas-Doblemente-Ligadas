/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listasDobles;

/**
 *
 * @author Lenovo_PC
 */
import java.util.Scanner;

public class NodoDobleMain {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        listaDoble lista = new listaDoble();

        int opcion;
        int dato;
        int posicion;

        do {
            System.out.println("\n===== MENU LISTA DOBLEMENTE LIGADA =====");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en una posicion");
            System.out.println("4. Insertar ordenado");
            System.out.println("5. Eliminar al inicio");
            System.out.println("6. Eliminar al final");
            System.out.println("7. Eliminar por valor");
            System.out.println("8. Eliminar por posicion");
            System.out.println("9. Buscar un dato");
            System.out.println("10. Actualizar un dato");
            System.out.println("11. Obtener nodo por posicion");
            System.out.println("12. Mostrar tamanio");
            System.out.println("13. Mostrar lista");
            System.out.println("14. Mostrar lista al reves");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = sc.nextInt();

            try {

                switch (opcion) {

                    case 1:
                        System.out.print("Ingresa el dato: ");
                        dato = sc.nextInt();

                        lista.insertarAlInicio(dato);
                        System.out.println("Dato insertado al inicio.");
                        break;

                    case 2:
                        System.out.print("Ingresa el dato: ");
                        dato = sc.nextInt();

                        lista.insertarAlFinal(dato);
                        System.out.println("Dato insertado al final.");
                        break;

                    case 3:
                        System.out.print("Ingresa la posicion: ");
                        posicion = sc.nextInt();

                        System.out.print("Ingresa el dato: ");
                        dato = sc.nextInt();

                        lista.insertarEnPosicion(posicion, dato);
                        System.out.println("Dato insertado correctamente.");
                        break;

                    case 4:
                        System.out.print("Ingresa el dato: ");
                        dato = sc.nextInt();

                        lista.insertarOrdenado(dato);
                        System.out.println("Dato insertado de forma ordenada.");
                        break;

                    case 5:
                        dato = lista.eliminarInicio();
                        System.out.println("Dato eliminado: " + dato);
                        break;

                    case 6:
                        if (lista.eliminarUltimo()) {
                            System.out.println("Ultimo nodo eliminado.");
                        } else {
                            System.out.println("La lista esta vacia.");
                        }
                        break;

                    case 7:
                        System.out.print("Ingresa el dato a eliminar: ");
                        dato = sc.nextInt();

                        if (lista.eliminarPorValor(dato)) {
                            System.out.println("Dato eliminado correctamente.");
                        } else {
                            System.out.println("El dato no existe en la lista.");
                        }
                        break;

                    case 8:
                        System.out.print("Ingresa la posicion a eliminar: ");
                        posicion = sc.nextInt();

                        dato = lista.eliminarEnPosicion(posicion);
                        System.out.println("Dato eliminado: " + dato);
                        break;

                    case 9:
                        System.out.print("Ingresa el dato a buscar: ");
                        dato = sc.nextInt();

                        if (lista.buscar(dato)) {
                            System.out.println("El dato SI existe.");
                        } else {
                            System.out.println("El dato NO existe.");
                        }
                        break;

                    case 10:
                        System.out.print("Ingresa la posicion: ");
                        posicion = sc.nextInt();

                        System.out.print("Ingresa el nuevo valor: ");
                        dato = sc.nextInt();

                        lista.actualizar(posicion, dato);
                        System.out.println("Dato actualizado correctamente.");
                        break;

                    case 11:
                        System.out.print("Ingresa la posicion: ");
                        posicion = sc.nextInt();

                        System.out.println("Nodo encontrado: "
                                + lista.obtenerNodo(posicion).getDato());
                        break;

                    case 12:
                        System.out.println("Tamanio de la lista: "
                                + lista.getTamanio());
                        System.out.println("Lista vacia: "
                                + lista.estaVacia());
                        break;

                    case 13:
                        System.out.println("Lista actual:");
                        System.out.println(lista);
                        break;
                        

                    case 14:
                        System.out.println("Lista en sentido inverso:");
                        System.out.println(lista.imprimirReversa());
                        break;
                        
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 0);

        sc.close();
    }

    
}
