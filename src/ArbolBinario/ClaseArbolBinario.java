/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author USER
 */
public class ClaseArbolBinario <T extends Comparable<T> > implements IArbolBinario<T>{

    protected ClaseNodo<T> raiz;

    @Override
    public void insertarNodo(T dato) {
        this.raiz = insertarRecursivo(this.raiz, dato);
    }
    
    private ClaseNodo insertarRecursivo(ClaseNodo<T> raizAux, T dato ){
        //Caso Base
        if( raizAux == null){
            ClaseNodo<T> nuevoNodo = new ClaseNodo<T>(dato);
            raizAux = nuevoNodo;
            return raizAux;
        }else{//Caso General
            if(raizAux.getClave().compareTo(dato) > 0 ){
                
                //izquierdo
                raizAux.setHijoIzquierdo(insertarRecursivo(raizAux.getHijoIzquierdo(),dato));
            }else{
                raizAux.setHijoDerecho(insertarRecursivo(raizAux.getHijoDerecho(),dato));
            }
            return raizAux;
        }
        
    }

    @Override
    public int cantidadNodos() {
        return cantidadNodosPrivate(this.raiz);
    }
    
    private int cantidadNodosPrivate(ClaseNodo<T> raizAux){
        //1er Caso base
        if(raizAux == null){
            return 0;
        }
        //2do Caso base
        if(isHoja(raizAux)){
            return 1;
        }
        //Caso General
        int HI =  cantidadNodosPrivate(raizAux.getHijoIzquierdo()); //3
        int HD =  cantidadNodosPrivate(raizAux.getHijoDerecho()); //3
        return HI + HD + 1;
    }

    /**
     * Este metodo me sirve para verificar si mi arbol esta vacio 
     * @return 
     */
    @Override
    public boolean verificarVacio() {
        return this.raiz == null;
    }

    @Override
    public void recorridoInOrden() {
        recorridoInOrdenRecursivo(this.raiz);
        System.out.println("");
    }

     //Privado
    private void recorridoInOrdenRecursivo(ClaseNodo<T> raizAux){
        //Caso Base
        if(raizAux == null) return ;
        //Caso General
        
        //Hijo Izquierdo
        recorridoInOrdenRecursivo(raizAux.getHijoIzquierdo());
        //padre
        System.out.print(raizAux.getClave() + ", ");
        //Hijo Derecho
        recorridoInOrdenRecursivo(raizAux.getHijoDerecho());
        
    }
    
    @Override
    public boolean isHoja(ClaseNodo<T> nodo) {
        return nodo.getHijoIzquierdo() == null && nodo.getHijoDerecho() == null;
    }

    @Override
    public int contarNodosPares() {
        return contarNodosParesRecursivo(this.raiz);
    }
    
    private int contarNodosParesRecursivo(ClaseNodo<T> raizAux){
        //1er Caso Base
        if(raizAux == null){
            return 0;
        }
        //2do Caso Base
        if(isHoja(raizAux)){
            int datoDeLaRaiz = (Integer) raizAux.getClave();
            if( datoDeLaRaiz%2 ==0){
                return 1;
            }else{
                return 0;
            }
        }
        //Caso General 
        //Aqui analizo HI
        int HI = contarNodosParesRecursivo(raizAux.getHijoIzquierdo());
        //Aqui Anlizo HD
        int HD = contarNodosParesRecursivo(raizAux.getHijoDerecho());
        //Aqui analizo Padre
        int datoDeLaRaiz = (Integer) raizAux.getClave();
            if( datoDeLaRaiz%2 ==0){
               return HI + HD + 1;
            }else{
                return HI + HD;
            }
    } 

    @Override
    public void recorridoPreOrden() {
        recorridoPreOrdenRecursivo(this.raiz);
        System.out.println("");
    }
    
    private void recorridoPreOrdenRecursivo(ClaseNodo<T> raizAux){
        //Caso Base
        if(raizAux == null) return ;
        //Caso General
        //padre
        System.out.print(raizAux.getClave() + ", ");
        //Hijo Izquierdo
        recorridoInOrdenRecursivo(raizAux.getHijoIzquierdo());
        //Hijo Derecho
        recorridoInOrdenRecursivo(raizAux.getHijoDerecho());
    }
    

    @Override
    public void recorridoPostOrden() {
        recorridoPostOrdenRecursivo(this.raiz);
        System.out.println("");
    }
    
    private void recorridoPostOrdenRecursivo(ClaseNodo<T> raizAux){
        //Caso Base
        if(raizAux == null) return ;
        //Caso General
        
        //Hijo Izquierdo
        recorridoInOrdenRecursivo(raizAux.getHijoIzquierdo());
        
        //Hijo Derecho
        recorridoInOrdenRecursivo(raizAux.getHijoDerecho());
        
        //padre
        System.out.print(raizAux.getClave() + ", ");
    }

    @Override
    public int contarHojas() {
        return contarHojasPrivate(this.raiz);
    }
    
    private int contarHojasPrivate(ClaseNodo<T> raizAux){
        if(raizAux == null){
            return 0;
        }
        if(isHoja( raizAux)){
            return 1;
        }
        //HIjo Izquierdo
        int i = contarHojasPrivate(raizAux.getHijoIzquierdo());
        //HIjo Derecho
        int d = contarHojasPrivate(raizAux.getHijoDerecho());
        return i + d;
    }
    
  
    
   
    
}

/*
    public void RecorridoPorNivel(){
        Queue<ClaseNodo<T>> cola = new LinkedList<ClaseNodo<T>>();
        cola.add(raiz);
        while(cola.isEmpty()){
            
            ClaseNodo<T> nodoAux = cola.poll();
            if(nodoAux != null){
                System.out.println(nodoAux.getClave());
                if(nodoAux.getHijoIzquierdo() != null){
                    cola.add(nodoAux.getHijoIzquierdo());
                }
                if(nodoAux.getHijoDerecho()!= null){
                    cola.add(nodoAux.getHijoDerecho());
                }
            }
        }
    }

*/
