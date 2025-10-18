/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVias;

import java.util.List;

/**
 *
 * @author USER
 */
public interface IArbolMVias<T extends Comparable<T>> {
    
    void insertar(T claveInsetar);
    int obtenerAltura();
    int contarCantidadNodos();
    List<T> recorridoInOrden();
    boolean esArbolVacio();
    int cantidadNodos();
    boolean verificarExiste(T dato);
    int verificarClavesVaciaPorNivel(int nivel);
    //String recorridoPorNivel();
    
}
