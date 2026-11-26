/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listasDobles;

/**
 *
 * @author Lenovo_PC
 */
public class listaDoble {
    
    private int tamanio;
    private NodoDoble cabeza;
    private NodoDoble cola;
    
    public listaDoble(){
    
        tamanio= 0;
        cabeza= null;
        cola = null;
    }
    
    public boolean estaVacia() {
        if(cabeza==null && cola == null){
            return true;
        }else{
            return false;
        }
       
    }

    /**
     * @return the tamanio
     */
    public int getTamanio() {
        return tamanio;
    }
    public boolean buscar(int dato){
        NodoDoble aux = cabeza;
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
        String res = "null";
        NodoDoble aux = cabeza;
        while(aux!=null){
            res= res+"<-["+aux.getDato()+"]->";
            aux=aux.getSiguiente();
        }
        res = res + "null";
        return res;
    }
    // Recorre la lista desde la cola hasta la cabeza usando el apuntador anterior
    public String imprimirReversa() {
        String res = "null";
        NodoDoble aux = cola;
        while (aux != null) {
            res = res + "<-[" + aux.getDato() + "]->";
            aux = aux.getAnterior();
        }
        res = res + "null";
        return res;
    }
    
    public NodoDoble obtenerNodo(int pos){
        // El primer casoseria que buscaran un Nodo uq este fuera del rango, 
        //es decir que sea menos de cero y mayor que el tamanño
        if(pos <=0 || pos>tamanio){
            //Debria marcar un error. Ahorita lo arreglo
            
            throw new IllegalStateException("El valor que estas insertando esta fuera de rango");
        }
        //Caso 2.
        NodoDoble aux = cabeza;
        for(int i=1;i < pos;i++){
            aux= aux.getSiguiente();
        }
        return aux;
         
    }
    
    public void actualizar(int pos, int valor){
        
        NodoDoble val = obtenerNodo(pos);
        val.setDato(valor);
    }
    
    public void insertarAlInicio(int valor){
        
        NodoDoble nuevo = new NodoDoble(valor);
        
        if(estaVacia()){
            cola = nuevo;   
        }else{
        
          cabeza.setAnterior(nuevo);
          nuevo.setSiguiente(cabeza);
        }
        cabeza = nuevo;
        tamanio++;  
    }
    public void insertarAlFinal(int valor){
        
        NodoDoble nuevo = new NodoDoble(valor);
        
        if(estaVacia()){
            cabeza = nuevo;   
        }else{
        
          cola.setSiguiente(nuevo);
          nuevo.setAnterior(cola);
        }
        cola = nuevo;
        tamanio++;  
    }
    public int eliminarInicio(){
        
        if(estaVacia()){
            throw new IllegalStateException("No se puede eliminar con la lista vacia");
        }
        
        int dato = cabeza.getDato();

        if(cabeza == cola){
            
            cabeza = null;
            cola = null;
        }else{
        
            cabeza = cabeza.getSiguiente();
            cabeza.getAnterior().setSiguiente(null);
            cabeza.setAnterior(null);
        }
        tamanio--;
        return dato;
        
    }
    
    public void  insertarEnPosicion(int pos, int dato){
        
        //Validamos 
        if(pos <=0 || pos >tamanio+1){
            throw new IllegalStateException("El valor que estas insertando esta fuera de rango");
        }
        if(pos==1){
            insertarAlInicio(dato);
            return;
            
        }else if(pos == tamanio + 1){
            insertarAlFinal(dato);
            return;
        }
        NodoDoble aux = obtenerNodo(pos-1);
        NodoDoble nuevo = new NodoDoble(dato);
        
        nuevo.setSiguiente(aux.getSiguiente()); //ya
        nuevo.setAnterior(aux);
        aux.getSiguiente().setAnterior(nuevo);
        aux.setSiguiente(nuevo); //ya
        
        tamanio++;        
    }
   
    public boolean  eliminarPorValor(int x){
        //Validamos si la lsta esta vacia
        if(estaVacia()){
            return false;
        }
        //Caso dso el dato esta justo en el inicio de la lista
        
        if(cabeza.getDato() == x){
            eliminarInicio();
            return true;
        }else if(cola.getDato() == x){
            eliminarUltimo();
            return true;
        }
        
        NodoDoble aux = cabeza;
        while(aux.getSiguiente()!=null){
            if(aux.getSiguiente().getDato() == x){
                NodoDoble aEliminar = aux.getSiguiente();
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                aEliminar.getSiguiente().setAnterior(aux);
                aEliminar.setSiguiente(null);
                aEliminar.setAnterior(null);        
                tamanio--;
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
    
    public int eliminarEnPosicion(int pos){
        
        if(pos <=0 || pos >tamanio){
            throw new IllegalStateException("La posicion a eliminar esta fuera de rango");
        }
        if(pos==1){
            
            int  datoEliminado = cabeza.getDato();
            eliminarInicio();
            return datoEliminado;
            
        }else if(pos == tamanio){
            int datoEliminado = cola.getDato();
            eliminarUltimo();
            return datoEliminado;
        }    
        NodoDoble aEliminar = obtenerNodo(pos);
        int  datoEliminado = aEliminar.getDato();
        
            aEliminar.getAnterior().setSiguiente(aEliminar.getSiguiente());
            aEliminar.getSiguiente().setAnterior(aEliminar.getAnterior());
            aEliminar.setSiguiente(null);
            aEliminar.setAnterior(null);        
        tamanio--;
        return datoEliminado;
    }
    public boolean eliminarUltimo(){
        
        if(estaVacia()){
            return false;
        }else if(cabeza == cola){
            
            cabeza = null;
            cola = null;
                    
        }else{
            cola = cola.getAnterior();
            cola.getSiguiente().setAnterior(null);
            cola.setSiguiente(null);
          
        }
        tamanio--;
        return true;

    }
    public void insertarOrdenado(int dato){
        if(estaVacia()) {
            insertarAlInicio(dato);
        }

        // Caso (b): El dato es menor o igual que el dato de la cabeza.
        else if(dato <= cabeza.getDato()) {
            insertarAlInicio(dato);
        }
        else if(dato >= cola.getDato()) {
            insertarAlFinal(dato);
        }

        else {
            NodoDoble aux = cabeza;

            // Se recorre la lista para encontrar la posición correcta.
            // Se utiliza getSiguienvte() para revisar el siguiente nodo
            // sin perder la referencia del nodo actual (aux).
            while(aux.getSiguiente() != null && aux.getSiguiente().getDato() < dato) {
                aux = aux.getSiguiente();
            }

            NodoDoble nuevo = new NodoDoble(dato);

            // Caso (c): El dato se inserta entre dos nodos.
            nuevo.setSiguiente(aux.getSiguiente()); //ya
            nuevo.setAnterior(aux);
            aux.getSiguiente().setAnterior(nuevo);
            aux.setSiguiente(nuevo); //ya
        

            // Caso (d): Si aux es el último nodo, el nuevo nodo
            // queda conectado al final de la lista.

            tamanio++;
        }
        
    }
    
}
