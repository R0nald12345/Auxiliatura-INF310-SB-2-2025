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
public interface IArbolBinario<T extends Comparable<T>> {
    
    
    void insertarNodo(T dato);
    public int cantidadNodos();
    public boolean verificarVacio();
    public int contarNodosPares();
    
    public void recorridoInOrden();
    //public void recorridoPreOrden();
    //public void recorridoPostOrden();
    //public void recorridoPorNivel();
    public boolean isHoja(ClaseNodo<T> Nodo);
    
    //public int contarNodosPares();
    //public int contarNodosParesIterativo();
    //public int contarCantidadHijosVaciosInOrdenIterativo();
}
