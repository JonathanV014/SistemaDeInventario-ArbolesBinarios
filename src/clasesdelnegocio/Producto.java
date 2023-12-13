/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesdelnegocio;

import java.io.Serializable;

/**
 *
 * @author Jonathan Vizcaino
 */
public class Producto implements Comparable<Producto>, Serializable{
    private int codigo;
    private String nombre;
    private String Descripcion;
    private String categoria;
    private int stock;
    private float precioUnitario;
    private int precioPuntos;
    private float peso;

    public Producto(int codigo, String nombre, String Descripcion, int stock, float precioUnitario, int precioPuntos, float peso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.stock = stock;
        this.precioUnitario = precioUnitario;
        this.precioPuntos = precioPuntos;
        this.peso = peso;
    }



    public Producto(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "\nProducto>\n-----------------------------------------\n"
            + "\n-Codigo del producto: " + codigo
            + "\n-Nombre del producto: " + nombre +""
            + "\n-Descripcion: " + Descripcion + "\n-Stock: " + stock + ""
            + "\n-Precio Unitario: " + precioUnitario +"\n-Precio Puntos: " + precioPuntos + ""
            + "\n-Peso: " + peso +" kg" + "\n-Categoria: "+categoria + "\n\n";
                                                                        
    }
    
    
    public String detalleProducto(){
        String detalleP = nombre+"                                             "+stock+"                                        "+precioUnitario+"                         "+stock*precioUnitario;
        return detalleP;
    }


    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the precioUnitario
     */
    public float getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public int compareTo(Producto o) {
        return this.codigo - o.getCodigo();
    }

    /**
     * @return the peso
     */
    public float getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * @return the precioPuntos
     */
    public int getPrecioPuntos() {
        return precioPuntos;
    }

    /**
     * @param precioPuntos the precioPuntos to set
     */
    public void setPrecioPuntos(int precioPuntos) {
        this.precioPuntos = precioPuntos;
    }

    
    
    
}
