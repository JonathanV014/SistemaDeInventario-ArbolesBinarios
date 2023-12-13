/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import arbolgenerico.Nodo;

/**
 *
 * @author Jonathan Vizcaino
 */
public class ConjuntoDeNumeros {
    private final arbolgenerico.Arbol<Integer> cn = new arbolgenerico.Arbol<>();
    
    public void agregar(int x){
        cn.add(x);
    }
    
    public boolean buscarBooleano(int x){
        return cn.buscarB(x);
    }
    
    public Nodo<Integer> buscarNodo(int x){
        return cn.buscarN(x);
    }
    
    public boolean eliminar(int x){
        return cn.eliminar(x);
    }
    
    
    public int mayor(){
        return cn.mayor();
    }
    
    public int menor(){
        return cn.menor();
    }

    @Override
    public String toString() {
        return "ConjuntoDeNumeros:\n" + cn.toString();
    }
    
    
    
}
