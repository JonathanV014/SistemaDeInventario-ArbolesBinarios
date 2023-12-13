/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesdelnegocio;

import arbolgenerico.Arbol;
import arbolgenerico.Nodo;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Jonathan Vizcaino
 */
public class Factura implements Comparable<Factura>, Serializable {
    private String numeroDeFactura;
    private String fecha;
    private Cliente cliente;
    private arbolgenerico.Arbol<Producto> productosC = new Arbol<>();
    private int puntosTotales;
    private float total;
    private float cantidadADevolver = 0;
    private float cantidadPagada = 0;
   
    

    public Factura(Cliente cliente, int puntosUsados) {
        this.cliente = cliente;
        this.puntosTotales = puntosUsados;
    }

 

    public Factura(String numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }

    @Override
    public String toString() {
        return "Factura{" + "numeroDeFactura=" + numeroDeFactura + ", fecha=" + fecha + ", cliente=" + cliente.toString() + ", productosC=" + productosC.toString() + ", puntosUsados=" + puntosTotales + ", total=" + total + '}';
    }
    
    
    public String detalleFactura(){
        String detalle = "\nFactura>"
                + "\nFecha: " + fecha+"     "+"Codigo de factura: " + numeroDeFactura+""
                + "\nNombre de cliente: " + cliente.getNombreCompleto()+""
                + "\nCedula de cliente: " + cliente.getCedula()+""
                + "\nCorreo electronico cliente: " + cliente.getCorreoElectronico()
                + "\nPago de cliente: " + cantidadPagada +"$"
                + "\n--------------------------------------------------------------------------"
                + "\nNombre producto     Cantidad Comprada     Precio unitario     Precio total de producto\n\n"
                + detalleProducto(productosC.getRaiz())+""
                + "\n--------------------------------------------------------------------------"
                + "\nTotal a pagar---------------------------------------------->" + total+"$"
                + "\nTotal a pagar en puntos------------------------------------>" + puntosTotales+""
                + "\nDevolucion -----> " + cantidadADevolver + "$\n\n";
        return detalle;  
    }
    
    private String detalleProducto(Nodo<Producto> p){
        if (p == null) {
            return "";
        }else{
            return detalleProducto(p.izq) + p.dato.detalleProducto() + "\n" + detalleProducto(p.der);
        }
    }

   
   
    /**
     * @return the numeroDeFactura
     */
    public String getNumeroDeFactura() {
        return numeroDeFactura;
    }

    /**
     * @param numeroDeFactura the numeroDeFactura to set
     */
    public void setNumeroDeFactura(String numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the productosC
     */
    public arbolgenerico.Arbol<Producto> getProductosC() {
        return productosC;
    }

    /**
     * @param productosC the productosC to set
     */
    public void setProductosC(arbolgenerico.Arbol<Producto> productosC) {
        this.productosC = productosC;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public int compareTo(Factura o) {
        return this.numeroDeFactura.compareToIgnoreCase( o.numeroDeFactura);
    }

    /**
     * @return the puntosUsados
     */
    public int getPuntosTotales() {
        return puntosTotales;
    }

    /**
     * @param puntosUsados the puntosUsados to set
     */
    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    /**
     * @return the cantidadADevolver
     */
    public float getCantidadADevolver() {
        return cantidadADevolver;
    }

    /**
     * @param cantidadADevolver the cantidadADevolver to set
     */
    public void setCantidadADevolver(float cantidadADevolver) {
        this.cantidadADevolver = cantidadADevolver;
    }

    /**
     * @return the cantidadPagada
     */
    public float getCantidadPagada() {
        return cantidadPagada;
    }

    /**
     * @param cantidadPagada the cantidadPagada to set
     */
    public void setCantidadPagada(float cantidadPagada) {
        this.cantidadPagada = cantidadPagada;
    }

    /**
     * @return the codigosFactura
     */

    
    
    
}
