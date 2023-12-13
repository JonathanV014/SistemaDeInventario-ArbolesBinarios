/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesdelnegocio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Jonathan Vizcaino
 */
public class Cliente implements Comparable<Cliente>, Serializable{
    private String cedula;
    private String direccion;
    private String numeroDeTelefono;
    private String nombreCompleto;
    private String correoElectronico;
    private String pais;
    private int puntos = 0;
    private ArrayList<Integer> codigosFactura = new ArrayList<>();

    public Cliente(String cedula, String nombreCompleto, String correoElectronico) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
    }

    public Cliente(String cedula, String direccion, String numeroDeTelefono, String nombreCompleto, String correoElectronico, String pais) {
        this.cedula = cedula;
        this.direccion = direccion;
        this.numeroDeTelefono = numeroDeTelefono;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "\nCliente>\n-----------------------------------------\n"
            + "\n-Cedula del cliente: " + cedula
            + "\n-Direccion del cliente: " + direccion +""
            + "\n-Numero de telefono: " + numeroDeTelefono + "\n-Nombre Completo: " + nombreCompleto + ""
            + "\n-Correo Electronico: " + correoElectronico +"\n-Pais: " + pais + "\n\n";                                                             
    }


    
    public Cliente(String cedula) {
        this.cedula = cedula;
    }

    
    

    

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the numeroDeTelefono
     */
    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    /**
     * @param numeroDeTelefono the numeroDeTelefono to set
     */
    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.cedula.compareTo( o.getCedula());
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the codigosFactura
     */
    public ArrayList<Integer> getCodigosFactura() {
        return codigosFactura;
    }

    /**
     * @param codigosFactura the codigosFactura to set
     */
    public void setCodigosFactura(ArrayList<Integer> codigosFactura) {
        this.codigosFactura = codigosFactura;
    }
    
    
}
