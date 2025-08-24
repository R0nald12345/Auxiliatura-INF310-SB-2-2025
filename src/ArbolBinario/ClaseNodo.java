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
public class ClaseNodo<T> {
      
    //Dato
    private T clave;
    
    //HI
    private ClaseNodo<T> hijoIzquierdo;
            
    //HD
    private ClaseNodo<T> hijoDerecho;
    
    //Contructor
    public ClaseNodo(T clave){
        this.clave = clave;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    public T getClave() {
        return clave;
    }

    public void setClave(T clave) {
        this.clave = clave;
    }

    public ClaseNodo<T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(ClaseNodo<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public ClaseNodo<T> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(ClaseNodo<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
}
