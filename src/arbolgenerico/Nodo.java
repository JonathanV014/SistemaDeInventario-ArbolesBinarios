/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolgenerico;

import java.io.Serializable;

/**
 *
 * @author Jonathan Vizcaino
 * @param <E>
 */
public class Nodo<E extends Comparable> implements Serializable{
    public E dato;
    public Nodo<E> izq;
    public Nodo<E> der;

    public Nodo(E dato) {
        this.dato = dato;
    }
    
    
    
}
