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
public class Arbol <E extends Comparable> implements Serializable{
    private Nodo<E> raiz; 

    
    
   public int peso(){
        return peso(raiz);
    }

    private int peso(Nodo<E> r) {
        if (r == null) {
            return 0;
        }else{
            return peso(r.izq) + 1 + peso(r.der);
        }
    }

    public void add(E x){
        Nodo<E> neww=new Nodo<>(x);
        if(raiz==null){
            raiz=neww;
        }else{
            add(raiz, neww);
        }
    }
    
    private void add(Nodo<E> r, Nodo<E> neww) {
        if(neww.dato.compareTo(r.dato)<0){
            if(r.izq==null)
                r.izq=neww;
            else
                add(r.izq,neww);
        }else{
            if(neww.dato.compareTo(r.dato)>0){
                if(r.der==null)
                    r.der=neww;
                else
                    add(r.der, neww);
            }
            
        }
    }
    
    public Nodo<E> buscarN(E x){
        if (raiz == null) {
            return null;
        }else{
            return buscarN(raiz, x);
        }
            
        
    }
    
    private Nodo<E> buscarN(Nodo<E> r, E x) {
        if (r.dato.compareTo(x) == 0) {
            return r;
        }else{
            if (x.compareTo(r.dato) < 0) {
                if (r.izq == null) {
                    return null;
                }else{
                    return buscarN(r.izq, x);
                }
            }else{
                if (r.der == null) {
                    return null;
                }else{
                    return buscarN(r.der, x);
                }
            }
        
        }        
    }
    
    
    public boolean buscarB( E x){
        if (raiz == null) {
            return false;
        }else{
            return buscarB(raiz, x);
        }
    
    }
    
    private boolean buscarB(Nodo<E> r, E x) {
        if (r.dato.compareTo(x) == 0) {
            return true;
        }else{
            if (x.compareTo(r.dato) < 0) {
                if (r.izq == null) {
                    return false;
                }else{
                    return buscarB(r.izq, x);
                }
            }else{
                if (r.der == null) {
                    return false;
                }else{
                    return buscarB(r.der, x);
                }
            }
        
        }
    }
    
    private String inorden(Nodo<E> r){
        if (r == null) {
            return "";
        }else{
            return inorden(r.izq) + r.dato.toString()+ "\n" + inorden(r.der);
        }
    }

    @Override
    public String toString() {
        return inorden(raiz);
    }
    
    
    public boolean eliminar(E x){
        if(buscarB(x)){
            raiz = eliminar(raiz, x);
            return true;
        }
        return false;
    }

    private Nodo<E> eliminar(Nodo<E> r, E x) {
        if(r.dato.compareTo(x) == 0 ){
            return borrar(r,x);
        }else{
            if(x.compareTo(r.dato) < 0){
                r.izq = eliminar(r.izq, x);
            }else{
                r.der = eliminar(r.der, x);
            }
            return r;
        }
    }

    
    private Nodo<E> borrar(Nodo<E> r, E x) {
        if(r.izq==null && r.der==null){ //hoja
            return null;
        }else{
            if(r.der==null){ //no tiene derecho
                return r.izq;
            }else{
                if(r.izq==null){ //no tiene izq
                    return r.der;
                }else{ // tiene 2 hijos
                    E may = mayor(r.izq);
                    r.dato = may;
                    r.izq = eliminar(r.izq, may);
                    return r;
                }
            }
        }
    }
    
    
    public E mayor(){
        return mayor(raiz);
    }
    private E mayor(Nodo<E> r){
        if(r.der==null){
            return r.dato;
        }else{
            return mayor(r.der);
        }    
    }
    
    public E menor(){
        return menor(raiz);
    }
    
    private E menor(Nodo<E> r){
        if(r.izq==null){
            return r.dato;
        }else{
            return menor(r.izq);
        }    
    }
       
    
    
    
    /**
     * @return the raiz
     */
    public Nodo<E> getRaiz() {
        return raiz;
    }






    
    
}
