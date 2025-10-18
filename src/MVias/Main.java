/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVias;

/**
 *
 * @author USER
 */
public class Main {
    
    public static void main(String[] args) {
        ClaseArbolMVias arbolMVias = new ClaseArbolMVias(3);
        arbolMVias.insertar(100);
        arbolMVias.insertar(90);
        arbolMVias.insertar(50);
        arbolMVias.insertar(80);
        arbolMVias.insertar(95);
        arbolMVias.insertar(96);
        arbolMVias.insertar(65);
        arbolMVias.insertar(101);
        
        System.out.println("La altura maxima es: " + arbolMVias.obtenerAltura());
        System.out.println("cantidad de Nodos MVias: " + arbolMVias.cantidadNodos());
        System.out.println("Verificar Existe: " + arbolMVias.verificarExiste(1000));
        
        System.out.println("Verificar cantidad Clave Vacia de nivel 1: " + arbolMVias.verificarClavesVaciaPorNivel(1));
        
    }
}
