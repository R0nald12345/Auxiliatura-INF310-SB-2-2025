/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVias;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author USER
 */
public class ClaseArbolMVias<T extends Comparable<T>> implements IArbolMVias<T> {

    //Atributos 
    protected ClaseNodoMVias<T> raiz;
    protected int orden; //Cantidad de Hijos
    protected int POSICION_INVALIDA = -1;

    //Constructor 
    public ClaseArbolMVias(int orden) {
        this.orden = orden;
    }

    //Metodos 
    @Override
    public void insertar(T ClaveInsertar) {
        //Si mi arbol esta vacio
        if (this.esArbolVacio() == true) {
            ClaseNodoMVias nuevoNodo = new ClaseNodoMVias(this.orden, ClaveInsertar);
            this.raiz = nuevoNodo;
        } else {
            this.insertarRecursivo(this.raiz, ClaveInsertar);
        }
    }

    private void insertarRecursivo(ClaseNodoMVias<T> raizAuxiliar, T ClaveInsertar) {
        int posicionClaveExistente = this.getPosicionDeClave(raizAuxiliar, ClaveInsertar);
        //Si mi arbol es Hoja
        if (raizAuxiliar.esHoja()) {
            //Verifico si mi arbol es hoja y ademas esa hoja esta lleno sus claves
            if (raizAuxiliar.estanClaveLlenas()) {
                int posicionPorDondeBajar = this.getPosicionPorDondeBajar(raizAuxiliar, ClaveInsertar);
                ClaseNodoMVias<T> nuevoHijo = new ClaseNodoMVias<>(this.orden, ClaveInsertar);
                raizAuxiliar.setHijo(posicionPorDondeBajar, nuevoHijo);
            } else {
                this.insertarClaveEnNodo(raizAuxiliar, ClaveInsertar);
            }
        } else {
            //Que pasa si mi arbol no es Hoja
            int posicionPorDondebajar = this.getPosicionPorDondeBajar(raizAuxiliar, ClaveInsertar);
            if (raizAuxiliar.esHijoVacio(posicionPorDondebajar)) {
                ClaseNodoMVias<T> nuevoHijo = new ClaseNodoMVias<>(this.orden, ClaveInsertar);
                raizAuxiliar.setHijo(posicionPorDondebajar, nuevoHijo);
            } else {
                this.insertarRecursivo(raizAuxiliar.getHijo(posicionPorDondebajar), ClaveInsertar);
            }
        }
    }

    private int getPosicionDeClave(ClaseNodoMVias<T> nodoActual, T claveInsertar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            T claveActual = nodoActual.getClave(i);
            if (claveInsertar.compareTo(claveActual) == 0) {
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    private int getPosicionPorDondeBajar(ClaseNodoMVias<T> nodoActual, T claveABuscar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            T claveActual = nodoActual.getClave(i);
            if (claveABuscar.compareTo(claveActual) < 0) {
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    private void insertarClaveEnNodo(ClaseNodoMVias<T> nodoActual, T claveAInsertar) {
//        int posicionClaveExistente = this.getPosicionDeClave(raizAuxiliar, ClaveInsertar);
        int posicionDondeInsertar = getPosicionDondeInsertar(nodoActual, claveAInsertar);
        int posicionActual = nodoActual.cantidadDeClavesNoVacias();
        while (posicionActual > posicionDondeInsertar) {
            T claveActual = nodoActual.getClave(posicionActual - 1);
            nodoActual.setClave(posicionActual, claveActual);
            posicionActual--;
        }
        nodoActual.setClave(posicionDondeInsertar, claveAInsertar);
    }

    private int getPosicionDondeInsertar(ClaseNodoMVias<T> nodoActual, T claveAInsertar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            T claveActual = nodoActual.getClave(i);
            if (claveAInsertar.compareTo(claveActual) < 0) {
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    @Override
    public int obtenerAltura() {
        return obtenerAlturaRecursivo(this.raiz);
    }

    private int obtenerAlturaRecursivo(ClaseNodoMVias<T> raizAux) {
        if (raizAux == null) {
            return 0;
        }
        if (raizAux.esHoja()) {
            return 1;
        }
        int alturaMaxima = 0;
        for (int i = 0; i < raizAux.cantidadDeClavesNoVacias(); i++) {
            int alturaHijo = obtenerAlturaRecursivo(raizAux.getHijo(i));
            if (alturaHijo > alturaMaxima) {
                alturaMaxima = alturaHijo;
            }
        }
        return alturaMaxima + 1;
    }

    @Override
    public int contarCantidadNodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> recorridoInOrden() {
        List<T> recorrido = new ArrayList<>();
        this.recorridoEnInOrden(this.raiz, recorrido);
        return recorrido;

    }

    private void recorridoEnInOrden(ClaseNodoMVias<T> nodoActual, List<T> recorrido) {
        //n == 0
        if (ClaseNodoMVias.esNodoVacio(nodoActual)) {
            return;
        }
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            recorridoEnInOrden(nodoActual.getHijo(i), recorrido);
            recorrido.add(nodoActual.getClave(i));
        }
        recorridoEnInOrden(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()), recorrido);
    }

    @Override
    public boolean esArbolVacio() {
        return this.raiz == null;
    }
//
//    @Override
//    public String recorridoPorNivel() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public int cantidadNodos() {
        return cantidadNodosRecursivo(this.raiz);
    }

    private int cantidadNodosRecursivo(ClaseNodoMVias<T> raizAux) {
        if (raizAux == null) {
            return 0;
        }
        if (raizAux.esHoja()) {
            return 1;
        }
        //Caso General
        int contador = 0;
        for (int i = 0; i < raizAux.cantidadDeClavesNoVacias(); i++) {
            contador = contador + cantidadNodosRecursivo(raizAux.getHijo(i));
        }
        return contador + 1;
    }

    @Override
    public boolean verificarExiste(T dato) {
        if (this.raiz == null) {
            return false;
        }
        Queue<ClaseNodoMVias<T>> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            ClaseNodoMVias nodoActual = cola.poll();
            for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
                if (nodoActual.getClave(i) == dato) {
                    return true;
                }
            }
            for (int i = 0; i <= nodoActual.cantidadDeClavesNoVacias(); i++) {
                if (!nodoActual.esHijoVacio(i)) {
                    cola.add(nodoActual.getHijo(i));
                }
            }
        }
        return false;
    }

    /**
     * Si retorna -1, el arbol esta vacio o el nivel es invalido
     *
     * @param nivel
     * @return
     */
    @Override
    public int verificarClavesVaciaPorNivel(int nivel) { //1
        if (raiz == null) {
            return -1;
        } else {
            int contador = 0; //Me cuenta la cantidad de Claves
            int controlador = 0; //Me controla si me encuentro en el nivel deseado  //1
            Queue<ClaseNodoMVias<T>> cola = new LinkedList<>();
            cola.add(raiz);
            while (!cola.isEmpty()) {
                ClaseNodoMVias nodoActual = cola.poll();
                if (nivel == controlador) {
                    contador = contador + nodoActual.cantidadDeClavesVacias();
                } else {
                    for (int i = 0; i <= nodoActual.cantidadDeClavesNoVacias(); i++) {
                        if (!nodoActual.esHijoVacio(i)) {
                            cola.add(nodoActual.getHijo(i));
                        }
                    }
                    controlador++;
                }
            }
            return contador;
        }

    }

}
