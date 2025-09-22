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
public class Main {
    
    public static void main(String[] args) {
        ClaseArbolBinario arbol1 = new ClaseArbolBinario();
        arbol1.insertarNodo(100);
        arbol1.insertarNodo(90);
        arbol1.insertarNodo(120);
        arbol1.insertarNodo(95);
        arbol1.insertarNodo(130);
        
        System.out.println("Cantidad de Nodos: " + arbol1.cantidadNodos());
        System.out.println("Cantidad de Nodos Pares: " + arbol1.contarNodosPares());
        System.out.println("Recorrido InOrden:");
        arbol1.recorridoInOrden();
        
        System.out.println("Recorrido preOrden:");
        arbol1.recorridoPreOrden();
        System.out.println("Recorrido postOrden:");
        arbol1.recorridoPostOrden();
        
        System.out.println("Contar Hojas: " + arbol1.contarHojas());
    }
}
