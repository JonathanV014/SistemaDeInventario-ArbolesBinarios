/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadelnegocio;

import arbolgenerico.Arbol;
import arbolgenerico.Nodo;
import clasesdelnegocio.Cliente;
import clasesdelnegocio.Factura;
import clasesdelnegocio.Producto;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Jonathan Vizcaino
 */
public class Tienda implements Serializable{
    private final Arbol<Producto> productos = new Arbol<>();
    private final Arbol<Factura> ventas = new Arbol<>();
    private final Arbol<Cliente> clientes = new Arbol<>();
    
    
    
    
//--------------------------------------------------------------METODOS DE PRODUCTOS-----------------------------------------//
    private final HashSet<String> categorias = new HashSet<>();
    public int totalCategorias(){
        return categorias.size();
    }     
    
    public void agregarCategoria(String c){
        String x = c.toLowerCase();
        getCategorias().add(x);
    }
    
    public void agregarProducto(Producto p, String categoria){
        //p.setCodigo(generarCodigoProducto());
        String x = categoria.toLowerCase();
        String n = p.getNombre();
        nombresProductos.add(n);
        String c = ""+ p.getCodigo();
        codigosProductos.add(c);
        p.setCategoria(x);
        productos.add(p);
    }
    
    private final ArrayList<String> codigosProductos = new ArrayList<>();
    private ArrayList<String> nombresProductos = new ArrayList<>();
    

    public String[] getNombresYCodigo(String cat) {
        ArrayList<String> union = new ArrayList<>();
        for (int i = 0; i < codigosProductos.size(); i++) {
            int codigo = Integer.parseInt(codigosProductos.get(i));
            Nodo<Producto> ne = buscarProductoN(codigo);

            if (ne != null && ne.dato.getCategoria().equalsIgnoreCase(cat)) {
                String nombre = nombresProductos.get(i);
                String codigo1 = codigosProductos.get(i);
                String union1 = codigo1+ " - " + nombre   ;
                union.add(union1);
            }
        }

        String[] nMc = union.toArray(new String[categorias.size()]);
        return nMc;
    }
    public Producto sacarParteNumerica(String nombreYCodigo){
        String cadenaNueva = nombreYCodigo;
        int inicio = 0;
        int fin = 6;
        String soloNumerico = cadenaNueva.substring(inicio, fin);
        int codigo = Integer.parseInt(soloNumerico);
        return buscarProductoN(codigo).dato;
    }
    
    
    public String[] getCategoriasA(){
        String[] categorias1 = categorias.toArray(new String[categorias.size()]);
        return categorias1;
    }
    
    public boolean modificarProducto(int codigo, String nombre, String descripcion, int stock, float precioUnitario, int precioPuntos, float peso){
        Nodo<Producto> p = productos.buscarN(new Producto(codigo));
        if (p != null) {
            p.dato.setNombre(nombre);
            p.dato.setDescripcion(descripcion);
            p.dato.setStock(stock);
            p.dato.setPrecioUnitario(precioUnitario);
            p.dato.setPrecioPuntos(precioPuntos);
            p.dato.setPeso(peso);
        
            return true;
            
        }else{
            return false;
        }
    }
    
    
    public String listarProductosDeLaCategoria(String categoria){
        return listarProductosDeLaCategoria(productos.getRaiz(),categoria.toLowerCase());
    }
    private String listarProductosDeLaCategoria(Nodo<Producto> r, String categoria) {
        if (r == null) {
            return "";
        }else{
            if (r.dato.getCategoria().compareToIgnoreCase(categoria) == 0) {
                return listarProductosDeLaCategoria(r.izq, categoria) + "\n"+ r.dato.toString() + listarProductosDeLaCategoria(r.der, categoria);
            }
            return listarProductosDeLaCategoria(r.izq, categoria) + listarProductosDeLaCategoria(r.der, categoria);
        }
    }
   
    
    
    public int totalProductosRegistrados(){
        return productos.peso();
    }
    
    public String listarTodosLosProductos(){
        return productos.toString();
    }
    public boolean buscarProductoB(int codigo){
        return productos.buscarB(new Producto(codigo));
    }
    
    public Nodo<Producto> buscarProductoN(int codigo){
        return productos.buscarN(new Producto(codigo));
    }
    
    public boolean eliminarProducto(int codigo){
        return productos.eliminar(new Producto(codigo));
    }
    
    //Funciones de ayuda rápida
    private final Set<Integer> codigosDeProductos = new HashSet<>();
    private int generarCodigoProducto() {
        Random random = new Random();
        int codigo;
        
        do {
            codigo = 10000 + random.nextInt(90000);
        } while (getCodigosDeProductos().contains(codigo));

        getCodigosDeProductos().add(codigo);
        return codigo;
    }
    
//--------------------------------------------------------------AQUI TERMINA PRODUCTOS-----------------------------------------//
    
//--------------------------------------------------------------METODOS CLIENTE-----------------------------------------//
    
    public int totalClientesRegistrados(){
        return clientes.peso();
    }
    
    public boolean buscarClienteB(String cedula){
        return clientes.buscarB(new Cliente(cedula));
    }
    
    public Nodo<Cliente> buscarClienteN(String cedula){
        return clientes.buscarN(new Cliente(cedula));
    }
    
    public void modificarCliente(String cedula, String direccion, String numeroDeTelefono, String nombreCompleto, String correoElectronico, String pais){
        Nodo<Cliente> c = buscarClienteN(cedula);
        if (c != null) {
            c.dato.setDireccion(direccion);
            c.dato.setNumeroDeTelefono(numeroDeTelefono);
            c.dato.setNombreCompleto(nombreCompleto);
            c.dato.setCorreoElectronico(correoElectronico);
            c.dato.setPais(pais);
        }
    }
    
    public void agregarCliente(Cliente c){
        clientes.add(c);
    }
    
    public boolean eliminarCliente(String cedula){
        return clientes.eliminar(new Cliente(cedula));
    }
    
    public String listarTodosLosClientes(){
        return clientes.toString();
    }

    
    

//-------------------------------------------------------------- AQUI TERMINA CLIENTE -----------------------------------------//
    //--------------------------------------------------------------METODOS FACTURA-----------------------------------------//
    
    //VENTA
    public String generarFactura(Cliente c, ArrayList<Producto> p, float cantidadPagada){
        
        String numeroDeFactura = generarCodigoFactura()+"";
        Factura f = new Factura(numeroDeFactura);
        String fecha = generarFecha();
        
        f.setNumeroDeFactura(numeroDeFactura);
        f.setFecha(fecha);
        
        
        float total = 0;
        int puntosTotales = 0; 
        for (Producto pro : p) {
            total += (pro.getPrecioUnitario() * pro.getStock());
            puntosTotales += (pro.getPrecioPuntos() * pro.getStock());
            
            f.getProductosC().add(pro);
        }
        if (total > cantidadPagada) {
            f.setCantidadADevolver(total - cantidadPagada);
        }else{
            f.setCantidadADevolver(cantidadPagada-total);
        }
        f.setCantidadPagada(cantidadPagada);
        f.setTotal(total);
        f.setPuntosTotales(puntosTotales);
        f.setCliente(c);
        
        ventas.add(f);
                
        return numeroDeFactura;
    }
    
    
    public void registrarCliente(Cliente c){
        clientes.add(c);
    }
    
    
    public int totalVentas(){
        return ventas.peso();
    }
    
    public String mostrarTodasLasFacturas(){
        String todasF = mostrarTodasLasFacturas(ventas.getRaiz());
        String totalVentas = "\nLa empresa ha hecho un total de " + ventas.peso() + " ventas\n\n";
        String salida = totalVentas + ""+ todasF;
        return salida;
    }
    
    private String mostrarTodasLasFacturas(Nodo<Factura> raiz) {
        if (raiz == null) {
            return "";
        }else{
            return mostrarTodasLasFacturas(raiz.izq) + raiz.dato.detalleFactura() + mostrarTodasLasFacturas(raiz.der);
        }
    }
    public Nodo<Factura> buscarFactura(String codigo){
        return ventas.buscarN(new Factura(codigo));
    }
    
    private String generarFecha(){
        
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaComoString = formatoFecha.format(fechaActual);
        
        return fechaComoString;
    }
    
    private final Set<Integer> codigosDeFactura = new HashSet<>();
    private int generarCodigoFactura() {
        Random random = new Random();
        int codigo;
        
        do {
            codigo = 1000000 + random.nextInt(9000000);
        } while (getCodigosDeFactura().contains(codigo));

        getCodigosDeFactura().add(codigo);
        return codigo;
    }
    
    

    /**
     * @return the categorias
     */
    public HashSet<String> getCategorias() {
        return categorias;
    }

    /**
     * @return the codigosDeFactura
     */
    public Set<Integer> getCodigosDeFactura() {
        return codigosDeFactura;
    }

    /**
     * @return the codigosDeProductos
     */
    public Set<Integer> getCodigosDeProductos() {
        return codigosDeProductos;
    }



    
    
    
    
}
