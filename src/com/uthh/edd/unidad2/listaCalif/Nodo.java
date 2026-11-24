/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listaCalif;

/**
 *
 * @author Lenovo_PC
 */
public class Nodo {
    
    private double dato;          // valor almacenado en el nodo
    private Nodo siguiente;     // referencia al siguiente nodo (null si es el último)
    
    //definimos osmconstrucotres especificos, uno para nsertar al inicio y otro
    //para incertar al final de la fila
    
    //constructor
    
    public Nodo(double dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
    public Nodo(double x, Nodo sig){
        dato= x;
        siguiente=sig;
    }
    //Definomos nuestras propiedades de acceso, getter y setters tanto para nodo como para dato
    public void setDato(double x ){
        dato=x;
    }
    public double getDato(){
        return dato;
    }
    public void setSiguiente(Nodo sig ){
        siguiente=sig;
    }
    public Nodo getSiguiente( ){
        return siguiente;
    }
    
}
