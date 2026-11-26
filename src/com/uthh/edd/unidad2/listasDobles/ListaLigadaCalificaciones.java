/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listaCalif;

/**
 *
 * @author Lenovo_PC
 */
public class ListaLigadaCalificaciones {
    private Nodo cabeza;   // primer nodo de la lista
    private int tamanio;   // cantidad de nodos almacenados

    public ListaLigadaCalificaciones() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        if(cabeza==null){
            return true;
        }else{
            return false;
        }
       
    }

    public int getTamanio() {
        return tamanio;
    }
    
    
    //Metodo para insertar un elemento al incio de la lista
    private void insertarAlInicio(double x){
        Nodo nuevo = new Nodo(x, cabeza); //crea un nodo
        cabeza=nuevo;
        tamanio++;
        
    }
    
    
    // Eliminar el inicio de la lista
    private double eliminarInicio(){
        //Validamos si la lista esta vacia
        if(estaVacia()){
            throw new IllegalStateException("No se puede eliminar con la lista vacia");
            
        }
        //Guardamos el dato antes de eliminar la cabeza
        double datoEliminado = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        tamanio--;
        return datoEliminado;
    }
    //Saber si la lista esta vacia
    //Saber si hay un solo nodo
    
    
    //Eliminar un nodo de acuerdo al valor que tenga
    
    
    //Metodo para buscar un Nodo
    public boolean buscarCalEspecifica(double dato){
        Nodo aux = cabeza;
        while(aux != null){
            if(aux.getDato() == dato){
                return true;
            }
            aux = aux.getSiguiente();
            
        }
        return false;
        
    }
    //Metodo toStrig
    @Override 
    public String toString(){
        String res = "";
        Nodo aux = cabeza;
        while(aux!=null){
            res= res+"["+aux.getDato()+"]->";
            aux=aux.getSiguiente();
        }
        res = res + "null";
        return res;
    }
    
    public Nodo obtenerNodo(int pos){
        // El primer casoseria que buscaran un Nodo uq este fuera del rango, 
        //es decir que sea menos de cero y mayor que el tamanño
        if(pos <=0 || pos>tamanio){
            //Debria marcar un error. Ahorita lo arreglo
            
            throw new IllegalStateException("El valor que estas insertando esta fuera de rango");
        }
        //Caso 2.
        Nodo aux = cabeza;
        for(int i=1;i < pos;i++){
            aux= aux.getSiguiente();
        }
        return aux;
         
    }
    public double obtenerCalificacion(int pos) {

        Nodo aux = obtenerNodo(pos); 

       double calificacion = aux.getDato();

        return calificacion;
    }
   
    
    
    public double eliminar (int pos){
        
         if(pos <=0 || pos >tamanio){
            throw new IllegalStateException("El valor que estas eliminando esta fuera de rango");
        }
         //Eliminar el primer nodo
         if(pos ==1){
             return eliminarInicio();
             
        }
         //Resto del ejercicio
        Nodo aux = obtenerNodo(pos-1);
        Nodo objetivo = aux.getSiguiente();
        double dato = objetivo.getDato();
         
        aux.setSiguiente(objetivo.getSiguiente());
        tamanio--;   
        return dato;
    }
    //Analizar 
    public void insertarOrdenado(double dato){
        
       
        // Caso (a): La lista está vacía.
        if(estaVacia()) {
            insertarAlInicio(dato);
        }

        // Caso (b): El dato es menor o igual que el dato de la cabeza.
        else if(dato <= cabeza.getDato()) {
            insertarAlInicio(dato);
        }

        else {
            Nodo aux = cabeza;

            while(aux.getSiguiente() != null && aux.getSiguiente().getDato() < dato) {
                aux = aux.getSiguiente();
            }

            Nodo nuevo = new Nodo(dato);

            // Caso (c): El dato se inserta entre dos nodos.
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);

            // Caso (d): Si aux es el último nodo, el nuevo nodo
            // queda conectado al final de la lista.

            tamanio++;
        }

    }
    
    public double obtenerCalMinimia(){
        
        if (estaVacia()) {
        throw new IllegalStateException("La lista está vacía");
        
        }

        return cabeza.getDato();

    }
    public double obtenerCalMaxima(){
        if (estaVacia()) {
        throw new IllegalStateException("La lista está vacía");
        }

        Nodo aux = cabeza;

        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }

        return aux.getDato();
    }
    public double obtenerCalMediana(){
        
        if (estaVacia()) {
        throw new IllegalStateException("La lista está vacía");
        }

        if (tamanio % 2 != 0) {

            // Caso impar
            int pos = (tamanio / 2) + 1;

            Nodo central = obtenerNodo(pos);

            return central.getDato();

        } else {

            // Caso par
            int pos = tamanio / 2;

            Nodo centralIzquierdo = obtenerNodo(pos);

            Nodo centralDerecho = centralIzquierdo.getSiguiente();

            return (centralIzquierdo.getDato() +
                    centralDerecho.getDato()) / 2.0;
        }
    }
    
    
    public void eliminarCalInvalida(){
        int pos = 1;

        while (pos <= tamanio) {

            double valor = obtenerNodo(pos).getDato();

            if (valor < 0 || valor > 100) {

                eliminar(pos);

            } else {

                pos++;
            }
        }
    }
    
    public void corregirCalificaion(int pos, double nuevoValor){
        
        
        if (pos <= 0 || pos > tamanio) {
            throw new IllegalStateException("Posición fuera de rango");
        }

       
        if (nuevoValor < 0 || nuevoValor > 100) {
            throw new IllegalArgumentException("Calificación inválida");
        }

        
        eliminar(pos);

       
        insertarOrdenado(nuevoValor);
    }
    
    public int totalEstudiantes(){
        return tamanio;
    }
    
}
