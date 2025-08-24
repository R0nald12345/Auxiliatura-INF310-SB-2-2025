/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    
}
