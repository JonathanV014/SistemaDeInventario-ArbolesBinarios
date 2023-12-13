/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guardardatos;

import clasesdelnegocio.Cliente;
import clasesdelnegocio.Producto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import logicadelnegocio.Tienda;
import persistencia.SerializarTienda;

/**
 *
 * @author Jonathan Vizcaino
 */
public class GuardarDato {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Tienda t = new Tienda();
        t.agregarCategoria("Viveres");
        t.agregarCategoria("Lacteos, huevos y refrigerados");
        t.agregarCategoria("Carnes y pescado");
        t.agregarCategoria("Frutas y verduras");
        t.agregarCategoria("Panaderia y reposteria");
        t.agregarCategoria("Bebidas");
        t.agregarCategoria("Productos de limpieza e higiene");
        t.agregarCategoria("Electronica y electrodomesticos");
 
        t.agregarProducto(new Producto(202210,"Arroz", "Arroz blanco de 1kg", 100, 11661f, 10, 1.0f), "Viveres");
        t.agregarProducto(new Producto(202311,"Leche", "Leche desnatada 1L", 50, 7761f, 5, 1.0f), "Lacteos, huevos y refrigerados");
        t.agregarProducto(new Producto(202412,"Pollo", "Pechuga de pollo", 30, 15561f, 15, 0.5f), "Carnes y pescado");
        t.agregarProducto(new Producto(202513,"Manzanas", "Manzanas frescas", 80, 3081f, 3, 0.2f), "Frutas y verduras");
        t.agregarProducto(new Producto(202614,"Pan blanco", "Pan blanco fresco", 60, 5811f, 6, 0.5f), "Panaderia y reposteria");
        t.agregarProducto(new Producto(202715,"Refresco", "Refresco de cola 2L", 40, 7761f, 8, 2.0f), "Bebidas");
        t.agregarProducto(new Producto(202816,"Jabón", "Jabón líquido 500ml", 70, 8000f, 7, 0.5f), "Productos de limpieza e higiene");
        t.agregarProducto(new Producto(202917,"Smart TV Samsung", "Smart TV de 55 pulgadas", 20, 2339961f, 50, 30.0f), "Electronica y electrodomesticos");
        t.agregarProducto(new Producto(203118,"Aceite de oliva", "Aceite de oliva extra virgen 500ml", 40, 23361f, 15, 0.5f), "Viveres");
        t.agregarProducto(new Producto(203219,"Queso", "Queso cheddar 250g", 60, 17511f, 20, 0.25f), "Lacteos, huevos y refrigerados");
        t.agregarProducto(new Producto(203320,"Salmón", "Filete de salmón fresco", 25, 38961f, 30, 0.6f), "Carnes y pescado");
        t.agregarProducto(new Producto(203421,"Uvas", "Uvas rojas 500g", 70, 11661f, 10, 0.5f), "Frutas y verduras");
        t.agregarProducto(new Producto(203522,"Croissant", "Croissant recién horneado", 45, 4680f, 5, 0.1f), "Panaderia y reposteria");
        t.agregarProducto(new Producto(203623,"Agua mineral", "Agua mineral 1L", 90, 1000f, 3, 1.0f), "Bebidas");
        t.agregarProducto(new Producto(203724,"Detergente", "Detergente en polvo 2kg", 55, 27261f, 15, 2.0f), "Productos de limpieza e higiene");
        t.agregarProducto(new Producto(203825,"Lavadora", "Lavadora de carga frontal", 10, 1949961f, 10000, 70.0f), "Electronica y electrodomesticos");
        t.agregarProducto(new Producto(203926,"Leche condensada", "Lata de leche condensada, 400g", 80, 4587f, 8, 0.4f), "Panaderia y Reposteria");
        t.agregarProducto(new Producto(204027,"Papa", "Papa Clasificada", 1500, 1220f, 1, 0.25f), "Frutas y Verduras");
        t.agregarProducto(new Producto(204128,"Yuca", "Yuca Clasificada", 1500, 870f, 1, 0.44f), "Frutas y Verduras");
        t.agregarProducto(new Producto(204229,"Aguacate", "Aguacate Hass", 2500, 1315f, 2, 0.007f), "Frutas y Verduras");
        t.agregarProducto(new Producto(204330,"Platano", "Platano verde clasificado", 1200, 1980f, 3, 0.32f), "Frutas y Verduras");
        t.agregarProducto(new Producto(204431,"Huevos", "Huevos Kikes X30", 80, 23000f, 20, 0.30f), "Lacteos, huevos y refrigerados");
        t.agregarProducto(new Producto(204532,"Leche", "Leche Colanta Pasteurizada 1X1L", 90, 4050f, 20, 0.1f), "Lacteos, huevos y refrigerados");
// 
        t.agregarCliente(new Cliente("1234567890", "Calle 123, Ciudad A", "555-123-4567", "Juan Pérez", "juan@example.com", "México"));
        t.agregarCliente(new Cliente("2345678901", "Avenida 456, Ciudad B", "555-234-5678", "María López", "maria@example.com", "España"));
        t.agregarCliente(new Cliente("3456789012", "Carrera 789, Ciudad C", "555-345-6789", "Carlos González", "carlos@example.com", "Argentina"));
        t.agregarCliente(new Cliente("4567890123", "Calle 567, Ciudad D", "555-456-7890", "Ana Rodríguez", "ana@example.com", "Chile"));
        t.agregarCliente(new Cliente("5678901234", "Avenida 890, Ciudad E", "555-567-8901", "Pedro Martínez", "pedro@example.com", "Perú"));
        t.agregarCliente(new Cliente("6789012345", "Carrera 901, Ciudad F", "555-678-9012", "Laura Sánchez", "laura@example.com", "Colombia"));
        t.agregarCliente(new Cliente("7890123456", "Calle 123, Ciudad G", "555-789-0123", "Miguel Fernández", "miguel@example.com", "Brasil"));
        t.agregarCliente(new Cliente("8901234567", "Avenida 234, Ciudad H", "555-890-1234", "Luis Ramírez", "luis@example.com", "Ecuador"));
        t.agregarCliente(new Cliente("9012345678", "Carrera 567, Ciudad I", "555-901-2345", "Isabel Torres", "isabel@example.com", "Venezuela"));
        t.agregarCliente(new Cliente("0123456789", "Calle 678, Ciudad J", "555-012-3456", "Andrés Pérez", "andres@example.com", "Bolivia"));
        t.agregarCliente(new Cliente("1234567098", "Avenida 901, Ciudad K", "555-123-4567", "Elena González", "elena@example.com", "Uruguay"));
        t.agregarCliente(new Cliente("2345678109", "Carrera 234, Ciudad L", "555-234-5678", "Ricardo Sánchez", "ricardo@example.com", "Paraguay"));
        t.agregarCliente(new Cliente("3456789210", "Calle 456, Ciudad M", "555-345-6789", "Carmen Martínez", "carmen@example.com", "Costa Rica"));
        t.agregarCliente(new Cliente("4567890321", "Avenida 678, Ciudad N", "555-456-7890", "Hugo Ramírez", "hugo@example.com", "Panamá"));
        t.agregarCliente(new Cliente("5678901423", "Carrera 890, Ciudad O", "555-567-8901", "Sofía Fernández", "sofia@example.com", "Honduras"));
        
       
        
        SerializarTienda persistenciaTienda = new SerializarTienda();
        
        persistenciaTienda.guardar(t);
    }
}
