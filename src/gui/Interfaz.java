/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import arbolgenerico.Nodo;
import clasesdelnegocio.Cliente;
import clasesdelnegocio.Factura;
import clasesdelnegocio.Producto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import logicadelnegocio.Tienda;
import persistencia.SerializarTienda;

/**
 *
 * @author Jonathan Vizcaino
 */
public class Interfaz {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        menu();
    }

    private static void menu() throws IOException, FileNotFoundException, ClassNotFoundException {
        int opcionElegida1 = 0;
        SerializarTienda st = new SerializarTienda();

        do {      
            System.out.flush();
            String[] options = {"Salir", "Siguiente"};
            String mensajeBienvenida = """
                                       
                                       Bienvenido/a a la tienda los 3 hermanos, estamos encantados de recibirte en nuestro mundo de compras.
                                       
                                       Explora nuestras categorias de productos, descubre ofertas emocionantes y encuentra 
                                       los articulos que se adaptan a tus necesidades. Nuestro equipo esta listo para ayudarte en todo
                                       momento, asi que si tienes preguntas o necesitas asistencia, no dudes en contactarnos.
                                       
                                       Todos los derechos reservados 2023.
                                       
                                       """;
            int seleccion = JOptionPane.showOptionDialog(null, mensajeBienvenida, "Bienvenido", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
            System.out.println(seleccion);
            if (seleccion == 0 || seleccion == -1) {
                opcionElegida1 = -1;
            }else{
                int opcionElegida2 = 0;
                do { 
                    System.out.flush();
                    String menu1 = """
                                   
                                   Bienvenido al sistema los 3 hermanos
                                   ¿Que desea realizar?
                                   
                                   1. Iniciar como administrador.
                                   2. Iniciar como cliente.
                                   3. Salir.
                                   
                                   """;
                    
                    opcionElegida2 = Integer.parseInt(JOptionPane.showInputDialog(null, menu1, "Ingrese una opcion del menú", JOptionPane.DEFAULT_OPTION));
                    
                    switch (opcionElegida2) {
                        case 1: //INICIAR COMO ADMINISTRADOR
                            String usuario = "admin";
                            String contraseña = "password";
                            int opcionElegida3 = 3;
                            do {
                                System.out.flush();
                                String mensajeUsuario = """
                                                        
                                                        -Ingrese el usuario(admin).
                                                        -ingrese 1 para salir.
                                                        
                                                        """;
                                String usuarioIng = JOptionPane.showInputDialog(null, mensajeUsuario, "Ingrese una opcion del menú", JOptionPane.DEFAULT_OPTION);
                                if (usuarioIng.equalsIgnoreCase("1")) {
                                    opcionElegida3 = 1; 
                                }else{
                                    if (usuarioIng.equalsIgnoreCase(usuario)) {
                                        while (opcionElegida3 != 1) {                                            
                                            String mensajeContraseña = """

                                                                       -Ingrese su contraseña(password).
                                                                       -Ingrese 1 para salir.

                                                                       """ ;
                                            String contraseñaIng = JOptionPane.showInputDialog(null, mensajeContraseña, "Ingrese una opcion del menú", JOptionPane.DEFAULT_OPTION);
                                            if (contraseñaIng.equalsIgnoreCase("1")) {
                                                opcionElegida3 = 1;
                                            }else{
                                                if (contraseñaIng.equalsIgnoreCase(contraseña)) {
                                                    int opcionMenuAdmin = 0;
                                                    do {                                                        
                                                        System.out.flush();
                                                        String menuAdmin = """

                                                                           Bienvenido al menu del administrador
                                                                           ¿Que desea realizar?

                                                                           1. Registrar un producto nuevo.
                                                                           2. Modificar un producto existente.
                                                                           3. Eliminar un producto existente.
                                                                           4. Ver productos registrados.
                                                                           5. Definir las categorias de productos.
                                                                           6. Modificar un cliente registrado.
                                                                           7. Eliminar un cliente registrado.
                                                                           8. Ver todos los clientes registrados;
                                                                           9. Ver acerca de las ventas.
                                                                           10. Regresar al menu.
                                                                           
                                                                           """;
                                                        
                                                        opcionMenuAdmin = Integer.parseInt(JOptionPane.showInputDialog(null, menuAdmin, "Ingrese una opcion del menú", JOptionPane.DEFAULT_OPTION));
                                                        switch (opcionMenuAdmin) {
                                                            case 1: //Registrar un producto nuevo.
                                                                if (st.recuperar().totalCategorias() == 0) {
                                                                    JOptionPane.showMessageDialog(null, "  Primero debes definir las categorias de los productos  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                }else{
                                                                    int repetirRegistro = 0;
                                                                    String repetirRegristroS = "";
                                                                    do {
                                                                        boolean preguntarCodigo = true;
                                                                        int codigo = 0;
                                                                        while (preguntarCodigo) {
                                                                            try {
                                                                                int codigoP = Integer.parseInt(JOptionPane.showInputDialog(null, "\n- Digita el CODIGO del producto \n - Digita -1 para regresar al menu\n\n", "Registro de Producto", JOptionPane.QUESTION_MESSAGE));
                                                                                 
                                                                                if (codigoP != -1) {
                                                                                    if ( codigoP > 99999 && codigoP < 1000000) {
                                                                                        if (st.recuperar().buscarProductoB(codigoP)) {
                                                                                            JOptionPane.showMessageDialog(null, "El código del producto ingresado ya se encuentra en uso. Por favor, ingresa una codigo valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }else{
                                                                                            preguntarCodigo = false;
                                                                                            codigo = codigoP;
                                                                                        }
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "El codigo del producto debe tener 6 dígitos. Por favor, ingresa una codigo valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                    }
                                                                                }else{
                                                                                     JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                     preguntarCodigo = false;
                                                                                     repetirRegistro = -1;
                                                                                     
                                                                                }
                                                                            } catch (NumberFormatException e) {
                                                                                 JOptionPane.showMessageDialog(null, "El codigo ingresado no es valido. Por favor, ingresa un codigo valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                            }
                                                                        }
                                                                        String nombre = "";
                                                                        if (repetirRegistro != -1) {
                                                                            boolean preguntarNombre = true;
                                                                            while (preguntarNombre) {                                                                                
                                                                                String nombreP = JOptionPane.showInputDialog(null,"\n- Digita el NOMBRE del producto\n- Digita -1 para regresar al menu\n\n", "Registro de Producto", JOptionPane.QUESTION_MESSAGE);
                                                                                if (!nombreP.equalsIgnoreCase("-1")) {
                                                                                    if (nombreP.length() >= 4) {
                                                                                        preguntarNombre = false;
                                                                                        nombre = nombreP;
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "El nombre del producto debe tener mas de 3 caracteres. Por favor, ingresa un nombre valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                    }
                                                                                }else{
                                                                                    JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                    preguntarNombre = false;
                                                                                    repetirRegristroS = "-1";
                                                                                }     
                                                                            }
                                                                        }
                                                                        String descripcion = "";
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            boolean preguntarDescripcion = true;
                                                                            while (preguntarDescripcion) {                                                                                
                                                                                String descripcionP = JOptionPane.showInputDialog(null,"\n- Digita la DESCRIPCION del producto\n- Digita -1 para regresar al menu\n\n", "Registro de Producto", JOptionPane.QUESTION_MESSAGE);
                                                                                if (!descripcionP.equalsIgnoreCase("-1")) {
                                                                                    if (descripcionP.length() >= 10) {
                                                                                        preguntarDescripcion = false;
                                                                                        descripcion = descripcionP;
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "La descripcion del producto debe tener mas de 10 caracteres. Por favor, ingresa una descripcion valida.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                    }
                                                                                }else{
                                                                                    JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                    preguntarDescripcion = false;
                                                                                    repetirRegristroS = "-1";
                                                                                }     
                                                                            }
                                                                        }
                                                                        int stock = 0;
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            boolean preguntarStock = true;
                                                                            while (preguntarStock) {
                                                                                try {
                                                                                    int stockP = Integer.parseInt(JOptionPane.showInputDialog(null, "\n- Digita el STOCK del producto \n- Digita -1 para regresar al menu\n\n", "Registro de Producto", JOptionPane.QUESTION_MESSAGE));

                                                                                    if (stockP != -1) {
                                                                                        if ( stockP > 0) {
                                                                                            preguntarStock = false;
                                                                                            stock = stockP;
                                                                                        }else{
                                                                                            JOptionPane.showMessageDialog(null, "El stock del producto debe ser mayor a 0. Por favor, ingresa una stock valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                        preguntarStock = false;
                                                                                        repetirRegistro = -1;
                                                                                    }
                                                                                } catch (NumberFormatException e) {
                                                                                    JOptionPane.showMessageDialog(null, "El stock ingresado no es valido. Por favor, ingresa un stock valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                }
                                                                            }
                                                                        }
                                                                        float precioUnitario = 0;
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            boolean preguntarPrecioUnitario = true;
                                                                            while (preguntarPrecioUnitario) {
                                                                                try {
                                                                                    float precioUnitarioP = Float.parseFloat(JOptionPane.showInputDialog(null, "\n- Digita el PRECIO UNITARIO del producto \n- Digita -1 para regresar al menu\n\n", "Registro de Producto", JOptionPane.QUESTION_MESSAGE));

                                                                                    if (precioUnitarioP != -1) {
                                                                                        if ( precioUnitarioP > 0) {
                                                                                            preguntarPrecioUnitario = false;
                                                                                            precioUnitario = precioUnitarioP;
                                                                                        }else{
                                                                                            JOptionPane.showMessageDialog(null, "El precio unitario del producto debe ser mayor a 0. Por favor, ingresa una precio unitario valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                        preguntarPrecioUnitario = false;
                                                                                        repetirRegistro = -1;
                                                                                    }
                                                                                } catch (NumberFormatException e) {
                                                                                    JOptionPane.showMessageDialog(null, "El precio unitario ingresado no es valido. Por favor, ingresa un precio unitario valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                }
                                                                            }
                                                                        }
                                                                        int precioPuntos = 0;
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            boolean preguntarPrecioPuntos = true;
                                                                            while (preguntarPrecioPuntos) {
                                                                                try {
                                                                                    int precioPuntosP = Integer.parseInt(JOptionPane.showInputDialog(null, "\n- Digita el PRECIO EN PUNTOS del producto \n- Digita -1 para regresar al menu\n\n", "Registro de Producto", JOptionPane.QUESTION_MESSAGE));

                                                                                    if (precioPuntosP != -1) {
                                                                                        if ( precioPuntosP > 0) {
                                                                                            preguntarPrecioPuntos = false;
                                                                                            precioPuntos = precioPuntosP;
                                                                                        }else{
                                                                                            JOptionPane.showMessageDialog(null, "El precio de los puntos del producto debe ser mayor a 0. Por favor, ingresa una precio de puntos valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                        preguntarPrecioPuntos = false;
                                                                                        repetirRegistro = -1;
                                                                                    }
                                                                                } catch (NumberFormatException e) {
                                                                                    JOptionPane.showMessageDialog(null, "El precio de los puntos ingresado no es valido. Por favor, ingresa un precio de puntos valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                }
                                                                            }
                                                                        }
                                                                        float peso = 0;
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            boolean preguntarPeso = true;
                                                                            while (preguntarPeso) {
                                                                                try {
                                                                                    float pesoP = Float.parseFloat(JOptionPane.showInputDialog(null, "\n- Digita el PESO(kg) del producto \n- Digita -1 para regresar al menu\n\n", "Registro de Producto", JOptionPane.QUESTION_MESSAGE));

                                                                                    if (pesoP != -1) {
                                                                                        if ( pesoP > -1) {
                                                                                            preguntarPeso = false;
                                                                                            peso = pesoP;
                                                                                        }else{
                                                                                            JOptionPane.showMessageDialog(null, "El peso del producto debe ser mayor a 0. Por favor, ingresa una peso valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                        preguntarPeso = false;
                                                                                        repetirRegistro = -1;
                                                                                    }
                                                                                } catch (NumberFormatException e) {
                                                                                    JOptionPane.showMessageDialog(null, "El peso ingresado no es valido. Por favor, ingresa un peso valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                }
                                                                            }
                                                                        }
                                                                        String categoria = "";
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            String[] categorias = st.recuperar().getCategoriasA();
                                                                            String categoriaP = (String) JOptionPane.showInputDialog(null,"\n-Seleccione la categoria del producto\n-Presione cancelar para regresar al menu\n\n","Registrar Producto", JOptionPane.DEFAULT_OPTION, null, categorias, categorias[0]);
                                                                            if (categoriaP == null) {
                                                                                JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                repetirRegistro = -1;
                                                                            }
                                                                            categoria = categoriaP;
                                                                        }
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            String[] options2 = {"Salir sin guardar", "Guardar Producto"};
                                                                            String resumenProducto = "\nResumen del producto\n-----------------------------------------\n"
                                                                                + "\n-Codigo del producto: " + codigo + "\n-Nombre del producto: " + nombre +""
                                                                                + "\n-Descripcion: " + descripcion + "\n-Stock: " + stock + ""
                                                                                + "\n-Precio Unitario: " + precioUnitario +"\n-Precio Puntos: " + precioPuntos + ""
                                                                                + "\n-Peso: " + peso +" kg"+ "\n-Categoria: " + categoria + "\n\n";
                                                                        
                                                                            int seleccionResumen = JOptionPane.showOptionDialog(null, resumenProducto, "Resumen Producto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options2, options2[0]);
                                                                            System.out.println("mani: " + seleccionResumen);
                                                                            
                                                                            if (seleccionResumen == 0 || seleccionResumen == -1) {
                                                                                repetirRegistro = -1;
                                                                            }else{
                                                                                
                                                                                Tienda tn = st.recuperar();
                                                                                tn.agregarProducto(new Producto(codigo, nombre, descripcion, stock, precioUnitario, precioPuntos, peso), categoria);
                                                                                st.guardar(tn);
                                                                                
                                                                                JOptionPane.showMessageDialog(null, "El producto fue guardado con exito", "Guardado...",JOptionPane.INFORMATION_MESSAGE);   
                                                                                repetirRegistro = -1;
                                                                            }
                                                                        }
                                                                        
                                                                    } while (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1"));
                                                                }
                                                                break;
                                                            case 2: //Modificar un producto existente.
                                                                if (st.recuperar().totalProductosRegistrados() == 0) {
                                                                    JOptionPane.showMessageDialog(null, "   No hay productos registrados para modificar  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                }else{
                                                                    int repetirRegistro = 0;
                                                                    String repetirRegristroS = "";
                                                                    
                                                                    do {
                                                                        boolean preguntarCodigo = true;
                                                                        int codigo = 0;
                                                                        Nodo<Producto> np = null;
                                                                        while (preguntarCodigo) {
                                                                            try {
                                                                                int codigoP = Integer.parseInt(JOptionPane.showInputDialog(null, "\n- Digita el CODIGO del producto que deseas modificar \n - Digita -1 para regresar al menu\n\n", "Modificar Producto", JOptionPane.QUESTION_MESSAGE));
                                                                                 
                                                                                if (codigoP != -1) {
                                                                                    if ( codigoP > 99999 && codigoP < 1000000) {
                                                                                        if (st.recuperar().buscarProductoB(codigoP)) {
                                                                                            preguntarCodigo = false;
                                                                                            codigo = codigoP;
                                                                                            np = st.recuperar().buscarProductoN(codigo);
                                                                                        }else{
                                                                                            JOptionPane.showMessageDialog(null, "El código del producto no se encuentra en nuestra base de datos. Por favor, ingresa una codigo valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "El codigo del producto debe tener 6 dígitos. Por favor, ingresa una codigo valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                    }
                                                                                }else{
                                                                                     JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                     preguntarCodigo = false;
                                                                                     repetirRegistro = -1;  
                                                                                }
                                                                            } catch (NumberFormatException e) {
                                                                                 JOptionPane.showMessageDialog(null, "El codigo ingresado no es valido. Por favor, ingresa un codigo valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                            }
                                                                        }
                                                                      
                                                                       
                                                                        String nombre = "";
                                                                        String nombreActual = "";
                                                                        if (repetirRegistro != -1) {
                                                                            nombreActual = np.dato.getNombre();
                                                                            boolean preguntarNombre = true;
                                                                            while (preguntarNombre) {
                                                                                String mensaje = "\n-Nombre actual del producto con codigo("+codigo+"): \n" + nombreActual+""
                                                                                                + "\n------------------------------------------------\n";
                                                                                
                                                                                String nombreP = JOptionPane.showInputDialog(null, mensaje + "\n- Digita el NUEVO NOMBRE para el producto\n- Digita -2 para NO MODIFICAR el nombre del producto\n- Digita -1 para regresar al menu\n\n", "Registro de Producto", JOptionPane.QUESTION_MESSAGE);
                                                                                if (!nombreP.equalsIgnoreCase("-1")) {
                                                                                    if (nombreP.equalsIgnoreCase("-2")) {
                                                                                        nombre = nombreActual;
                                                                                        preguntarNombre = false;
                                                                                    }else{
                                                                                        if (nombreP.length() >= 4) {
                                                                                            preguntarNombre = false;
                                                                                            nombre = nombreP;
                                                                                        }else{
                                                                                            JOptionPane.showMessageDialog(null, "El nombre del producto debe tener mas de 3 caracteres. Por favor, ingresa un nombre valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                    preguntarNombre = false;
                                                                                    repetirRegristroS = "-1";
                                                                                }     
                                                                            }
                                                                        }
                                                                        String descripcion = "";
                                                                        String descripcionActual = "";
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            descripcionActual = np.dato.getDescripcion();
                                                                            boolean preguntarDescripcion = true;
                                                                            while (preguntarDescripcion) {  
                                                                                String mensajeD = "\n-Descripción actual del producto con codigo("+codigo+"): \n" + descripcionActual+""
                                                                                                + "\n------------------------------------------------\n";
                                                                                
                                                                                String descripcionP = JOptionPane.showInputDialog(null, mensajeD + "\n- Digita la NUEVA DESCRIPCION para el producto\n- Digita -2 para NO MODIFICAR la descripcion del producto\n- Digita -1 para regresar al menu\n\n" , "Registro de Producto", JOptionPane.QUESTION_MESSAGE);
                                                                                if (!descripcionP.equalsIgnoreCase("-1")) {
                                                                                    if (descripcionP.equalsIgnoreCase("-2")) {
                                                                                        descripcion = descripcionActual;
                                                                                        preguntarDescripcion = false;
                                                                                    }else{
                                                                                        if (descripcionP.length() >= 10) {
                                                                                            preguntarDescripcion = false;
                                                                                            descripcion = descripcionP;
                                                                                        }else{
                                                                                            JOptionPane.showMessageDialog(null, "La descripcion del producto debe tener mas de 10 caracteres. Por favor, ingresa una descripcion valida.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                    preguntarDescripcion = false;
                                                                                    repetirRegristroS = "-1";
                                                                                }     
                                                                            }
                                                                        }
                                                                        int stock = 0;
                                                                        int stockActual = 0;
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            stockActual = np.dato.getStock();
                                                                            boolean preguntarStock = true;
                                                                            while (preguntarStock) {
                                                                                String mensajeS = "\n-Stock actual del producto con codigo("+codigo+"): \n" + stockActual+""
                                                                                                + "\n------------------------------------------------\n";
                                                                                try {
                                                                                    int stockP = Integer.parseInt(JOptionPane.showInputDialog(null, mensajeS + "\n- Digita el NUEVO STOCK para el producto\n- Digita -2 para NO MODIFICAR el stock del producto\n- Digita -1 para regresar al menu\n\n", "Registro de Producto", JOptionPane.QUESTION_MESSAGE));

                                                                                    if (stockP != -1) {
                                                                                        if (stockP == -2) {
                                                                                            stock = stockActual;
                                                                                            preguntarStock = false;
                                                                                        }else{
                                                                                            if ( stockP > 0) {
                                                                                                preguntarStock = false;
                                                                                                stock = stockP;
                                                                                            }else{
                                                                                                JOptionPane.showMessageDialog(null, "El stock del producto debe ser mayor a 0. Por favor, ingresa una stock valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                            }
                                                                                        }
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                        preguntarStock = false;
                                                                                        repetirRegistro = -1;
                                                                                    }
                                                                                } catch (NumberFormatException e) {
                                                                                    JOptionPane.showMessageDialog(null, "El stock ingresado no es valido. Por favor, ingresa un stock valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                }
                                                                            }
                                                                        }
                                                                        
                                                                        float precioUnitario = 0;
                                                                        float precioUnitarioActual = 0;
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            precioUnitarioActual = np.dato.getPrecioUnitario();
                                                                            boolean preguntarPrecioUnitario = true;
                                                                            while (preguntarPrecioUnitario) {
                                                                                String mensajePU = "\n-Precio unitario actual del producto con codigo("+codigo+"): \n" + precioUnitarioActual+""
                                                                                                + "\n------------------------------------------------\n";
                                                                                try {
                                                                                    float precioUnitarioP = Float.parseFloat(JOptionPane.showInputDialog(null, mensajePU + "\n- Digita el NUEVO PRECIO UNITARIO para el producto\n- Digita -2 para NO MODIFICAR el precio unitario del producto\n- Digita -1 para regresar al menu\n\n", "Registro de Producto", JOptionPane.QUESTION_MESSAGE));

                                                                                    if (precioUnitarioP != -1) {
                                                                                        if (precioUnitarioP == -2) {
                                                                                            precioUnitario = precioUnitarioActual;
                                                                                            preguntarPrecioUnitario = false;
                                                                                        }else{
                                                                                            if ( precioUnitarioP > 0) {
                                                                                                preguntarPrecioUnitario = false;
                                                                                                precioUnitario = precioUnitarioP;
                                                                                            }else{
                                                                                                JOptionPane.showMessageDialog(null, "El precio unitario del producto debe ser mayor a 0. Por favor, ingresa una precio unitario valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                            }
                                                                                        }
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                        preguntarPrecioUnitario = false;
                                                                                        repetirRegistro = -1;
                                                                                    }
                                                                                } catch (NumberFormatException e) {
                                                                                    JOptionPane.showMessageDialog(null, "El precio unitario ingresado no es valido. Por favor, ingresa un precio unitario valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                }
                                                                            }
                                                                        }
                                                                        int precioPuntos = 0;
                                                                        int precioPuntosActual = 0;
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            precioPuntosActual = np.dato.getPrecioPuntos();
                                                                            boolean preguntarPrecioPuntos = true;
                                                                            while (preguntarPrecioPuntos) {
                                                                                String precioPA = "\n-Precio de Puntos actual del producto con codigo("+codigo+"): \n" + precioPuntosActual + ""
                                                                                                + "\n------------------------------------------------\n";

                                                                                try {
                                                                                    int precioPuntosP = Integer.parseInt(JOptionPane.showInputDialog(null, precioPA + "\n- Digita el NUEVO PRECIO PUNTOS para el producto\n- Digita -2 para NO MODIFICAR el precio por puntos del producto\n- Digita -1 para regresar al menu\n\n", "Registro de Producto", JOptionPane.QUESTION_MESSAGE));

                                                                                    if (precioPuntosP != -1) {
                                                                                        if (precioPuntosP == -2) {
                                                                                            precioPuntos = precioPuntosActual;
                                                                                            preguntarPrecioPuntos = false;
                                                                                        }else{
                                                                                            if ( precioPuntosP > 0) {
                                                                                                preguntarPrecioPuntos = false;
                                                                                                precioPuntos = precioPuntosP;
                                                                                            }else{
                                                                                                JOptionPane.showMessageDialog(null, "El precio de los puntos del producto debe ser mayor a 0. Por favor, ingresa una precio de puntos valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                            }   
                                                                                        }
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                        preguntarPrecioPuntos = false;
                                                                                        repetirRegistro = -1;
                                                                                    }
                                                                                } catch (NumberFormatException e) {
                                                                                    JOptionPane.showMessageDialog(null, "El precio de los puntos ingresado no es valido. Por favor, ingresa un precio de puntos valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                }
                                                                            }
                                                                        }
                                                                        float peso = 0;
                                                                        float pesoActual = 0;
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            pesoActual = np.dato.getPeso();
                                                                            boolean preguntarPeso = true;
                                                                            while (preguntarPeso) {
                                                                                String pesoPE = "\n-Peso actual del producto con codigo("+codigo+"): \n" + pesoActual + ""
                                                                                                + "\n------------------------------------------------\n";

                                                                                try {
                                                                                    float pesoP = Float.parseFloat(JOptionPane.showInputDialog(null, pesoPE + "\n- Digita el PESO para el producto\n- Digita -2 para NO MODIFICAR el peso del producto\n- Digita -1 para regresar al menu\n\n", "Registro de Producto", JOptionPane.QUESTION_MESSAGE));

                                                                                    if (pesoP != -1) {
                                                                                        if (pesoP == -2) {
                                                                                            peso = pesoActual;
                                                                                            preguntarPeso = false;
                                                                                        }else{
                                                                                            if ( pesoP > -1) {
                                                                                                preguntarPeso = false;
                                                                                                peso = pesoP;
                                                                                            }else{
                                                                                                JOptionPane.showMessageDialog(null, "El peso del producto debe ser mayor a 0. Por favor, ingresa una peso valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                            }

                                                                                        }
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                        preguntarPeso = false;
                                                                                        repetirRegistro = -1;
                                                                                    }
                                                                                } catch (NumberFormatException e) {
                                                                                    JOptionPane.showMessageDialog(null, "El peso ingresado no es valido. Por favor, ingresa un peso valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                }
                                                                            }
                                                                        }
                                                                        
                                                                        String categoria = np.dato.getCategoria();
                                                                        
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            String[] options2 = {"Salir sin guardar", "Guardar modificacion de Producto"};
                                                                            String resumenProducto = "\nResumen del producto modificado\n-----------------------------------------\n"
                                                                                + "\n-Codigo del producto: " + codigo
                                                                                + "\n-Nombre del producto: " + nombre +""
                                                                                + "\n-Descripcion: " + descripcion + "\n-Stock: " + stock + ""
                                                                                + "\n-Precio Unitario: " + precioUnitario +"\n-Precio Puntos: " + precioPuntos + ""
                                                                                + "\n-Peso: " + peso +" kg" + "\n-Categoria: "+categoria + "\n\n";
                                                                        
                                                                            int seleccionResumen = JOptionPane.showOptionDialog(null, resumenProducto, "Resumen Producto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options2, options2[0]);
                                                                            System.out.println("mani: " + seleccionResumen);
                                                                            if (seleccionResumen == 0 || seleccionResumen == -1) {
                                                                                repetirRegistro = -1;
                                                                            }else{
                                                                                Tienda tm = st.recuperar();
                                                                                tm.modificarProducto(codigo, nombre, descripcion, stock, precioUnitario, precioPuntos, peso);
                                                                                st.guardar(tm);

                                                                                JOptionPane.showMessageDialog(null, "El producto fue modificado con exito", "Guardado...",JOptionPane.INFORMATION_MESSAGE);   
                                                                                repetirRegistro = -1;
                                                                            }
                                                                        }
                                                                        
                                                                    } while (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1"));
                                                                
                                                                }
                                                                break;
                                                            case 3: //Eliminar un producto existente.
                                                                if (st.recuperar().totalProductosRegistrados() == 0) {
                                                                    JOptionPane.showMessageDialog(null, "   No hay productos registrados para eliminar  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                }else{
                                                                   int repetirRegistro = 0;
                                                                    String repetirRegristroS = "";
                                                                    
                                                                    do {
                                                                        boolean preguntarCodigo = true;
                                                                        int codigo = 0;
                                                                        Nodo<Producto> np = null;
                                                                        while (preguntarCodigo) {
                                                                            try {
                                                                                int codigoP = Integer.parseInt(JOptionPane.showInputDialog(null, "\n- Digita el CODIGO del producto que deseas modificar \n - Digita -1 para regresar al menu\n\n", "Modificar Producto", JOptionPane.QUESTION_MESSAGE));
                                                                                 
                                                                                if (codigoP != -1) {
                                                                                    if ( codigoP > 99999 && codigoP < 1000000) {
                                                                                        if (st.recuperar().buscarProductoB(codigoP)) {
                                                                                            preguntarCodigo = false;
                                                                                            codigo = codigoP;
                                                                                            np = st.recuperar().buscarProductoN(codigo);
                                                                                        }else{
                                                                                            JOptionPane.showMessageDialog(null, "El código del producto no se encuentra en nuestra base de datos. Por favor, ingresa una codigo valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "El codigo del producto debe tener 6 dígitos. Por favor, ingresa una codigo valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                    }
                                                                                }else{
                                                                                     JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                     preguntarCodigo = false;
                                                                                     repetirRegistro = -1;  
                                                                                }
                                                                            } catch (NumberFormatException e) {
                                                                                 JOptionPane.showMessageDialog(null, "El codigo ingresado no es valido. Por favor, ingresa un codigo valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                            }
                                                                        }
                                                                      
                                                                        if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                            String[] options2 = {"Salir sin eliminar", "Eliminar Producto"};
                                                                            String resumenProducto = "\nResumen del producto que desea eliminar\n-----------------------------------------\n"
                                                                                + "\n-Codigo del producto: " + codigo
                                                                                + "\n-Nombre del producto: " + np.dato.getNombre() +""
                                                                                + "\n-Descripcion: " + np.dato.getDescripcion() + "\n-Stock: " + np.dato.getStock() + ""
                                                                                + "\n-Precio Unitario: " + np.dato.getPrecioUnitario() +"\n-Precio Puntos: " + np.dato.getPrecioPuntos() + ""
                                                                                + "\n-Peso: " + np.dato.getPeso() +" kg" + np.dato.getCategoria() + "\n\n";
                                                                        
                                                                            int seleccionResumen = JOptionPane.showOptionDialog(null, resumenProducto, "Resumen Producto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options2, options2[0]);
                                                                            System.out.println("mani: " + seleccionResumen);
                                                                            if (seleccionResumen == 0 || seleccionResumen == -1) {
                                                                                repetirRegistro = -1;
                                                                            }else{
                                                                                Tienda tm = st.recuperar();
                                                                                tm.eliminarProducto(codigo);
                                                                                st.guardar(tm);

                                                                                JOptionPane.showMessageDialog(null, "El producto fue eliminado con exito", "Guardado...",JOptionPane.OK_OPTION);   
                                                                                
                                                                                repetirRegistro = -1;
                                                                            }
                                                                        }
                                                                        
                                                                    } while (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1"));
                                                                
                                                                  
                                                                }
                                                                break;
                                                            case 4: //Ver productos registrados.
                                                                if (st.recuperar().totalProductosRegistrados() == 0) {
                                                                    JOptionPane.showMessageDialog(null, "   No hay productos registrados  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                }else{
                                                                    int repetirRegistro = 0;
                                                                    String repetirRegristroS = "";
                                                                    do {
                                                                        
                                                                        String[] options2 = {"Regresar al menu", "Listar Todos los Productos", "Listar por Categoria"}; 
                                                                        int seleccionResumen = JOptionPane.showOptionDialog(null, "\n           -Selecione una opción\n\n", "Listar Producto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options2, options2[0]);
                                                                        System.out.println("mani: " + seleccionResumen);
                                                                        
                                                                        if (seleccionResumen == 0 || seleccionResumen == -1) {
                                                                            repetirRegistro = -1;
                                                                        }else{
                                                                            JTextArea textArea = new JTextArea(10, 30);
                                                                            textArea.setWrapStyleWord(true);
                                                                            textArea.setLineWrap(true);
                                                                            textArea.setEditable(false);
                                                                            textArea.setCaretPosition(0);
                                                                            if (seleccionResumen == 1) {
                                                                                String listadoProductosT = st.recuperar().listarTodosLosProductos() + "\n\n";
                                                                                textArea.setText(listadoProductosT);
                                                                                JScrollPane scrollPane = new JScrollPane(textArea);
                                                                                JOptionPane.showMessageDialog(null,scrollPane, "Todos los productos de la empresa",JOptionPane.INFORMATION_MESSAGE);   
                                                                            }else{
                                                                                String categoria = "";
                                                                                if (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1")) {
                                                                                    String[] categorias = st.recuperar().getCategoriasA();
                                                                                    String categoriaP = (String) JOptionPane.showInputDialog(null,"\n-Seleccione una categoria para listar sus productos\n-Presione cancelar para regresar al menu\n\n","Listar Producto", JOptionPane.DEFAULT_OPTION, null, categorias, categorias[0]);
                                                                                    
                                                                                    if (categoriaP == null) {
                                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                        repetirRegistro = -1;
                                                                                    }
                                                                                    categoria = categoriaP;
                                                                                }
                                                                                
                                                                                String listadoProductosC = st.recuperar().listarProductosDeLaCategoria(categoria) + "\n\n";
                                                                                
                                                                                textArea.setText(listadoProductosC);
                                                                                JScrollPane scrollPane = new JScrollPane(textArea);
                                                                                
                                                                                JOptionPane.showMessageDialog(null, scrollPane, "Todos los productos de la empresa. Categoria-> " + categoria,JOptionPane.INFORMATION_MESSAGE);   
                                                                              
                                                                            }
                                                                            String[] optionsA = {"Regresar al menu", "Seguir listando"};
                                                                            int seleccionA = JOptionPane.showOptionDialog(null,"", "Resumen Producto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, optionsA, optionsA[0]);
                                                                            if (seleccionA == 0 || seleccionA == -1) {
                                                                                repetirRegistro = -1;
                                                                            }
                                                                        }   
                                                                    } while (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1"));
                                                                    
                                                                }
                                                                break;
                                                            case 5: //Definir las categorias de productos.
                                                                int repetirRegistro = 0;
                                                                String repetirRegristroS = "";
                                                                JTextArea textArea = new JTextArea(20, 40);
                                                                textArea.setWrapStyleWord(true);
                                                                textArea.setLineWrap(true);
                                                                textArea.setEditable(false);
                                                                textArea.setCaretPosition(0);
                                                                
                                                                do {                                                                    
                                                                    String[] c = st.recuperar().getCategoriasA();
                                                                    String categoriasExistentes = "";
                                                                    for (String c1 : c) {
                                                                        categoriasExistentes += "\n-" + c1 + "\n";
                                                                    }
                                                                    String[] optionsB = {"Regresar al menu", "Agregar Nueva Categoria"};
                                                                    categoriasExistentes = "Listado de todas las categorias:\n\n" + categoriasExistentes + "\n";
                                                                    
                                                                    textArea.setText(categoriasExistentes);
                                                                    JScrollPane scrollPane = new JScrollPane(textArea);
                                                                    
                                                                    int seleccionB = JOptionPane.showOptionDialog(null,scrollPane, "Estas son todas las categorias registradas: ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, optionsB, optionsB[0]);
                                                                    if (seleccionB == 0 || seleccionB == -1) {
                                                                        repetirRegistro = -1;
                                                                    }else{
                                                                        String nombreCategoria = "";
                                                                        if (repetirRegistro != -1) {
                                                                            boolean preguntarNombre = true;
                                                                            while (preguntarNombre) {
                                                                                String nombreP = JOptionPane.showInputDialog(null, "\n- Digita  el nombre de la categoria\n- Digita -1 para regresar al menu\n\n", "Registro de Categoria", JOptionPane.QUESTION_MESSAGE);
                                                                                if (!nombreP.equalsIgnoreCase("-1")) {
                                                                                    if (nombreP.length() >= 4) {
                                                                                           preguntarNombre = false;
                                                                                           nombreCategoria = nombreP;
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "El nombre del producto debe tener mas de 3 caracteres. Por favor, ingresa un nombre valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                    }
                                                                                }else{
                                                                                    JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                    preguntarNombre = false;
                                                                                    repetirRegristroS = "-1";
                                                                                }     
                                                                            }
                                                                            Tienda tm = st.recuperar();
                                                                            tm.agregarCategoria(nombreCategoria);
                                                                            st.guardar(tm);
                                                                            
                                                                            JOptionPane.showMessageDialog(null, "La categoria fue agregada con exito", "Guardado...",JOptionPane.INFORMATION_MESSAGE);   
                                                                            String[] optionsA = {"Regresar al menu", "Seguir agregando categorias"};
                                                                            int seleccionA = JOptionPane.showOptionDialog(null,"", "Agregar Categoria", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, optionsA, optionsA[0]);
                                                                            if (seleccionA == 0 || seleccionA == -1) {
                                                                                repetirRegistro = -1;
                                                                            }
                                                                        }
                                                                        
                                                                        
                                                                    } 
                                                                } while (repetirRegistro != -1 && !repetirRegristroS.equalsIgnoreCase("-1"));
                                                                break;
                                                            case 6: //Modificar un cliente registrado.
                                                                if (st.recuperar().totalClientesRegistrados() == 0) {
                                                                    JOptionPane.showMessageDialog(null, "   No hay clientes registrados  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                }else{
                                                                    String repetirRegristroA = "";
                                                                    int repetirRegistroA = 0;
                                                                    do {
                                                                        boolean preguntarCedula = true;
                                                                        String cedula = "";
                                                                        Nodo<Cliente> np = null;
                                                                        while (preguntarCedula) {
                                                                            String cedulaP = JOptionPane.showInputDialog(null, "\n- Digita la CEDULA del cliente que deseas modificar \n - Digita -1 para regresar al menu\n\n", "Modificar Cliente", JOptionPane.QUESTION_MESSAGE);
                                                                            if (!cedulaP.equalsIgnoreCase("-1")) {
                                                                                if (cedulaP.length() == 10 ) {
                                                                                    if (st.recuperar().buscarClienteB(cedulaP)) {
                                                                                        preguntarCedula = false;
                                                                                        cedula = cedulaP;
                                                                                        np = st.recuperar().buscarClienteN(cedula);
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "La cedula no se encuentra en nuestra base de datos. Por favor, ingresa una cedula valida.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                    }
                                                                                }else{
                                                                                    JOptionPane.showMessageDialog(null, "La cedula debe tener 10 dígitos. Por favor, ingresa una cedula valida.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                }
                                                                            }else{
                                                                                 JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                 preguntarCedula = false;
                                                                                 repetirRegistroA = -1;  
                                                                            }
                                                                        }
                                                                        
                                                                        String direccion = "";
                                                                        String direccionActual = "";
                                                                        if (repetirRegistroA != -1) {
                                                                            direccionActual = np.dato.getDireccion();
                                                                            boolean preguntarDireccion = true;
                                                                            while (preguntarDireccion) {
                                                                                String mensaje = "\nDireccion actual de la persona con cedula("+cedula+"): \n-" + direccionActual+""
                                                                                                + "\n------------------------------------------------\n";
                                                                                
                                                                                String direnccionP = JOptionPane.showInputDialog(null, mensaje + "\n- Digita la nueva DIRECCION de la persona\n- Digita -2 para NO MODIFICAR la direccion\n- Digita -1 para regresar al menu\n\n", "Modificar Persona", JOptionPane.QUESTION_MESSAGE);
                                                                                if (!direnccionP.equalsIgnoreCase("-1")) {
                                                                                    if (direnccionP.equalsIgnoreCase("-2")) {
                                                                                        direccion = direccionActual;
                                                                                        preguntarDireccion = false;
                                                                                    }else{
                                                                                        if (direnccionP.length() >= 10) {
                                                                                            preguntarDireccion = false;
                                                                                            direccion = direnccionP;
                                                                                        }else{
                                                                                            JOptionPane.showMessageDialog(null, "La direccion debe tener mas de 10 caracteres. Por favor, ingresa una direccion valida.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                    preguntarDireccion = false;
                                                                                    repetirRegristroA = "-1";
                                                                                }     
                                                                            }
                                                                        }
                                                                        
                                                                        String numeroDeTelefono = "";
                                                                        String numeroDeTelefonoActual = "";
                                                                        if (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1")) {
                                                                            numeroDeTelefonoActual = np.dato.getNumeroDeTelefono();
                                                                            boolean preguntarNumeroDeTelefono = true;
                                                                            while (preguntarNumeroDeTelefono) {  
                                                                                String mensajeNumeroDeTelefono = "\n-Numero de telefono actual de la persona con cedula("+cedula+"): \n" + numeroDeTelefonoActual+""
                                                                                                + "\n------------------------------------------------\n";
                                                                                
                                                                                String numeroDeTelefonoP = JOptionPane.showInputDialog(null, mensajeNumeroDeTelefono + "\n- Digita un nuevo NUMERO DE TELFONO para la persona\n- Digita -2 para NO MODIFICAR el numero de telefono\n- Digita -1 para regresar al menu\n\n" , "Modificar Persona", JOptionPane.QUESTION_MESSAGE);
                                                                                if (!numeroDeTelefonoP.equalsIgnoreCase("-1")) {
                                                                                    if (numeroDeTelefonoP.equalsIgnoreCase("-2")) {
                                                                                        numeroDeTelefono = numeroDeTelefonoActual;
                                                                                        preguntarNumeroDeTelefono = false;
                                                                                    }else{
                                                                                        if (numeroDeTelefonoP.length() == 10) {
                                                                                            preguntarNumeroDeTelefono = false;
                                                                                            numeroDeTelefono = numeroDeTelefonoP;
                                                                                        }else{
                                                                                            JOptionPane.showMessageDialog(null, "El numero de telefono debe tener 10 digitos. Por favor, ingrese una numero de telefono valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                    preguntarNumeroDeTelefono = false;
                                                                                    repetirRegristroA = "-1";
                                                                                }     
                                                                            }
                                                                        }
                                                                        
                                                                        String nombreCompleto = "";
                                                                        String nombreCompletoActual = "";
                                                                        if (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1")) {
                                                                            nombreCompletoActual = np.dato.getNombreCompleto();
                                                                            boolean preguntarNombreCompleto = true;
                                                                            while (preguntarNombreCompleto) {  
                                                                                String mensajeNombreCompleto = "\n-Nombre completo actual de la persona con cedula("+cedula+"): \n" + nombreCompletoActual+""
                                                                                                + "\n------------------------------------------------\n";
                                                                                
                                                                                String NombreCompletoP = JOptionPane.showInputDialog(null, mensajeNombreCompleto + "\n- Digita un nuevo NOMBRE para la persona\n- Digita -2 para NO MODIFICAR el nombre\n- Digita -1 para regresar al menu\n\n" , "Modificar Persona", JOptionPane.QUESTION_MESSAGE);
                                                                                if (!NombreCompletoP.equalsIgnoreCase("-1")) {
                                                                                    if (NombreCompletoP.equalsIgnoreCase("-2")) {
                                                                                        nombreCompleto = nombreCompletoActual;
                                                                                        preguntarNombreCompleto = false;
                                                                                    }else{
                                                                                        if (NombreCompletoP.length() > 0) {
                                                                                            preguntarNombreCompleto = false;
                                                                                            nombreCompleto = NombreCompletoP;
                                                                                        }else{
                                                                                            JOptionPane.showMessageDialog(null, "El campo no puede estar vacio. Por favor, ingrese una nombre.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                    preguntarNombreCompleto = false;
                                                                                    repetirRegristroA = "-1";
                                                                                }     
                                                                            }
                                                                        }
                                                                        
                                                                        String correoElectronico = "";
                                                                        String correoElectronicoActual = "";
                                                                        if (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1")) {
                                                                            correoElectronicoActual = np.dato.getCorreoElectronico();
                                                                            boolean preguntarCorreoElectronico = true;
                                                                            while (preguntarCorreoElectronico) {  
                                                                                String mensajePreguntarCorreoElectronico = "\n-Correo electronico actual de la persona con cedula("+cedula+"): \n" + correoElectronicoActual+""
                                                                                                + "\n------------------------------------------------\n";
                                                                                
                                                                                String correoElectronicoP = JOptionPane.showInputDialog(null, mensajePreguntarCorreoElectronico + "\n- Digita un nuevo CORREO ELECTRONICO para la persona\n- Digita -2 para NO MODIFICAR el correo electronico\n- Digita -1 para regresar al menu\n\n" , "Modificar Persona", JOptionPane.QUESTION_MESSAGE);
                                                                                
                                                                                if (!correoElectronicoP.equalsIgnoreCase("-1")) {
                                                                                    if (correoElectronicoP.equalsIgnoreCase("-2")) {
                                                                                        correoElectronico = correoElectronicoActual;
                                                                                        preguntarCorreoElectronico = false;
                                                                                    }else{
                                                                                        if (correoElectronicoP.length() > 5) {
                                                                                            preguntarCorreoElectronico = false;
                                                                                            correoElectronico = correoElectronicoP;
                                                                                        }else{
                                                                                            JOptionPane.showMessageDialog(null, "El campo debe tener más de 5 digitos. Por favor, ingrese correo electronico valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                    preguntarCorreoElectronico = false;
                                                                                    repetirRegristroA = "-1";
                                                                                }     
                                                                            }
                                                                        }
                                                                        
                                                                        String pais = "";
                                                                        String paisActual = "";
                                                                        if (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1")) {
                                                                            paisActual = np.dato.getPais();
                                                                            boolean preguntarPais = true;
                                                                            while (preguntarPais) {  
                                                                                String mensajePreguntarPais = "\n-Pais actual de la persona con cedula("+cedula+"): \n" + paisActual+""
                                                                                                + "\n------------------------------------------------\n";
                                                                                
                                                                                String paisP = JOptionPane.showInputDialog(null, mensajePreguntarPais + "\n- Digita un nuevo PAIS para la persona\n- Digita -2 para NO MODIFICAR el correo electronico\n- Digita -1 para regresar al menu\n\n" , "Modificar Persona", JOptionPane.QUESTION_MESSAGE);
                                                                                
                                                                                if (!paisP.equalsIgnoreCase("-1")) {
                                                                                    if (paisP.equalsIgnoreCase("-2")) {
                                                                                        pais = paisActual;
                                                                                        preguntarPais = false;
                                                                                    }else{
                                                                                        if (paisP.length() > 3) {
                                                                                            preguntarPais = false;
                                                                                            pais = paisP;
                                                                                        }else{
                                                                                            JOptionPane.showMessageDialog(null, "El campo debe tener más de 3 digitos. Por favor, ingrese pais valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                    preguntarPais = false;
                                                                                    repetirRegristroA = "-1";
                                                                                }     
                                                                            }
                                                                        }
                                                                        
                                                                        
                                                                        if (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1")) {
                                                                            String[] options2 = {"Salir sin guardar", "Guardar modificacion de cliente"};
                                                                            String resumenProducto = "\nResumen del cliente modificado\n-----------------------------------------\n"
                                                                                + "\n-Cedula del cliente: " + cedula
                                                                                + "\n-Direccion del cliente: " + direccion +""
                                                                                + "\n-Numero de telefono: " + numeroDeTelefono + "\n-Nombre Completo: " + nombreCompleto + ""
                                                                                + "\n-Correo Electronico: " + correoElectronico +"\n-Pais: " + pais + "\n\n";
                                                                        
                                                                            int seleccionResumen = JOptionPane.showOptionDialog(null, resumenProducto, "Resumen Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options2, options2[0]);
                                                                            System.out.println("mani: " + seleccionResumen);
                                                                            if (seleccionResumen == 0 || seleccionResumen == -1) {
                                                                                repetirRegistroA = -1;
                                                                            }else{
                                                                                Tienda tm = st.recuperar();
                                                                                tm.modificarCliente(cedula, direccion, numeroDeTelefono, nombreCompleto, correoElectronico, pais);
                                                                                st.guardar(tm);

                                                                                JOptionPane.showMessageDialog(null, "El cliente fue modificado con exito", "Guardado...",JOptionPane.INFORMATION_MESSAGE);   
                                                                                repetirRegistroA = -1;
                                                                            }
                                                                        }
                                                                        
                                                                    } while (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1"));
                                                                }
                                                                break;
                                                            case 7: //Eliminar un cliente registrado.
                                                                if (st.recuperar().totalClientesRegistrados() == 0) {
                                                                    JOptionPane.showMessageDialog(null, "   No hay clientes registrados para eliminar  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                }else{
                                                                    int repetirRegistroA = 0;
                                                                    String repetirRegristroA = "";
                                                                    
                                                                    do {
                                                                        boolean preguntarCedula = true;
                                                                        String cedula = "";
                                                                        Nodo<Cliente> np = null;
                                                                        while (preguntarCedula) {
                                                                            String cedulaP = JOptionPane.showInputDialog(null, "\n- Digita la CEDULA del cliente que deseas eliminar \n - Digita -1 para regresar al menu\n\n", "Eliminar cliente", JOptionPane.QUESTION_MESSAGE);
                                                                            if (!cedulaP.equalsIgnoreCase("-1")) {
                                                                                if ( cedulaP.length() == 10) {
                                                                                    if (st.recuperar().buscarClienteB(cedulaP)) {
                                                                                        preguntarCedula = false;
                                                                                        cedula = cedulaP;
                                                                                        np = st.recuperar().buscarClienteN(cedula);
                                                                                    }else{
                                                                                        JOptionPane.showMessageDialog(null, "La cedula no se encuentra en nuestra base de datos. Por favor, ingrese una cedula valida.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                    }
                                                                                }else{
                                                                                    JOptionPane.showMessageDialog(null, "La cedula debe tener 10 dígitos. Por favor, ingrese una cedula valida.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                }
                                                                            }else{
                                                                                 JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                                 preguntarCedula = false;
                                                                                 repetirRegistroA = -1;  
                                                                            }
                                                                        }
                                                                      
                                                                        if (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1")) {
                                                                            String[] options2 = {"Salir sin eliminar", "Eliminar"};
                                                                            String resumenProducto = "\nResumen del cliente a eliminar\n-----------------------------------------\n"
                                                                                + "\n-Cedula del cliente: " + cedula
                                                                                + "\n-Direccion del cliente: " + np.dato.getDireccion() +""
                                                                                + "\n-Numero de telefono: " + np.dato.getNumeroDeTelefono() + "\n-Nombre Completo: " + np.dato.getNombreCompleto() + ""
                                                                                + "\n-Correo Electronico: " + np.dato.getCorreoElectronico() +"\n-Pais: " + np.dato.getPais() + "\n\n";
                                                                        
                                                                            int seleccionResumen = JOptionPane.showOptionDialog(null, resumenProducto, "Resumen Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options2, options2[0]);
                                                                            System.out.println("mani: " + seleccionResumen);
                                                                            if (seleccionResumen == 0 || seleccionResumen == -1) {
                                                                                repetirRegistroA = -1;
                                                                            }else{
                                                                                Tienda tm = st.recuperar();
                                                                                tm.eliminarCliente(cedula);
                                                                                st.guardar(tm);

                                                                                JOptionPane.showMessageDialog(null, "El cliente fue eliminado con exito", "Guardado...",JOptionPane.OK_OPTION);   
                                                                                
                                                                                repetirRegistroA = -1;
                                                                            }
                                                                        }
                                                                        
                                                                    } while (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1"));

                                                                }
                                                                break;
                                                            case 8: //Ver todos los clientes registrados
                                                                if (st.recuperar().totalClientesRegistrados() == 0) {
                                                                    JOptionPane.showMessageDialog(null, "   No hay clientes registrados  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                }else{
                                                                    int repetirRegistroA = 0;
                                                                    String repetirRegristroA = "";
                                                                    do {
                                                                        
                                                                        String[] options2 = {"Regresar al menu", "Listar todos los clientes", "Listar por cliente por cedula"}; 
                                                                        int seleccionResumen = JOptionPane.showOptionDialog(null, "\n           -Selecione una opción\n\n", "Listar Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options2, options2[0]);
                                                                        System.out.println("mani: " + seleccionResumen);
                                                                        
                                                                        if (seleccionResumen == 0 || seleccionResumen == -1) {
                                                                            repetirRegistroA = -1;
                                                                        }else{
                                                                            JTextArea textAreaa = new JTextArea(10, 30);
                                                                            textAreaa.setWrapStyleWord(true);
                                                                            textAreaa.setLineWrap(true);
                                                                            textAreaa.setEditable(false);
                                                                            textAreaa.setCaretPosition(0);
                                                                            if (seleccionResumen == 1) {
                                                                                String listadoClientesT = st.recuperar().listarTodosLosClientes() + "\n\n";
                                                                                textAreaa.setText(listadoClientesT);
                                                                                JScrollPane scrollPane = new JScrollPane(textAreaa);
                                                                                JOptionPane.showMessageDialog(null,scrollPane, "Todos los clientes de la empresa",JOptionPane.INFORMATION_MESSAGE);   
                                                                            }else{
                                                                                if (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1")) {
                                                                                    String cedula = "";
                                                                                    Nodo<Cliente> np = null;
                                                                                    boolean preguntarCedula = true;
                                                                                    while (preguntarCedula) {
                                                                                        String cedulaP = JOptionPane.showInputDialog(null, "\n- Digita la CEDULA del cliente que deseas buscar \n - Digita -1 para regresar al menu\n\n", "Buscar Cliente", JOptionPane.QUESTION_MESSAGE);
                                                                                        if ( cedulaP.length() == 10) {
                                                                                                if (st.recuperar().buscarClienteB(cedulaP)) {
                                                                                                    preguntarCedula = false;
                                                                                                    cedula = cedulaP;
                                                                                                    np = st.recuperar().buscarClienteN(cedula);
                                                                                                }else{
                                                                                                    JOptionPane.showMessageDialog(null, "La cedula no se encuentra en nuestra base de datos. Por favor, ingrese una cedula valida.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                                }
                                                                                            }else{
                                                                                                JOptionPane.showMessageDialog(null, "La cedula debe tener 10 dígitos. Por favor, ingrese una cedula valida.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                        }
                                                                                    }
                                                                                    String listadoClienteC = st.recuperar().buscarClienteN(cedula).dato.toString() + "\n\n";
                                                                                
                                                                                    textAreaa.setText(listadoClienteC);
                                                                                    JScrollPane scrollPane = new JScrollPane(textAreaa);

                                                                                    JOptionPane.showMessageDialog(null, scrollPane, "Cliente encontrado->",JOptionPane.INFORMATION_MESSAGE);   
                                                                                   
                                                                                }
                                                                                
                                                                                
                                                                            }
                                                                            String[] optionsA = {"Regresar al menu", "Seguir listando"};
                                                                            int seleccionA = JOptionPane.showOptionDialog(null,"", "Resumen Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, optionsA, optionsA[0]);
                                                                            if (seleccionA == 0 || seleccionA == -1) {
                                                                                repetirRegistroA = -1;
                                                                            }
                                                                        }   
                                                                    } while (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1"));
                                                                }
                                                                break;
                                                            case 9: //Ver todo acerca de las ventas.
                                                                if (st.recuperar().totalVentas() == 0) {
                                                                    
                                                                }else{
                                                                    int opS = 0;
                                                                    do {                                                                        
                                                                        String resumenFactura = st.recuperar().mostrarTodasLasFacturas();
                                                                        JTextArea textAreaa = new JTextArea(20, 45);
                                                                        textAreaa.setWrapStyleWord(true);
                                                                        textAreaa.setLineWrap(true);
                                                                        textAreaa.setEditable(false);
                                                                        textAreaa.setCaretPosition(0);

                                                                        
                                                                        textAreaa.setText(resumenFactura);
                                                                        JScrollPane scrollPane = new JScrollPane(textAreaa);
                                                                        JOptionPane.showMessageDialog(null,scrollPane, "Resumen de Factura->",JOptionPane.INFORMATION_MESSAGE);

                                                                        String[] optionsA = {"Regresar al menu"};
                                                                        int seleccionA = JOptionPane.showOptionDialog(null,"", "Resumen Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, optionsA, optionsA[0]);
                                                                        if (seleccionA == 0 || seleccionA == -1) {
                                                                             opS =1;
                                                                        }else{
                                                                            opS = 1;
                                                                        }
                                                
                                                                    } while (opS!=1);
                                                                
                                                                }
                                                                
                                                                
                                                                
                                                                break;    
                                                            case 10: //Salir.
                                                                JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                opcionElegida3 = 1;
                                                                break;
                                                            
                                                            default:
                                                                JOptionPane.showMessageDialog(null, "La opción elegida no se encuentra en el menú", "¡Error!",JOptionPane.ERROR_MESSAGE);
                                                                break;
                                                        }
                                                    
                                                    } while (opcionMenuAdmin != 10);
                                                    
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "¡Error!",JOptionPane.ERROR_MESSAGE);
                                                }
                                            }                                            
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "El usuario es incorrecto", "¡Error!",JOptionPane.ERROR_MESSAGE);   
                                    }
                                }
                            } while (opcionElegida3 != 1);
                            break;
                        case 2: //INICIAR COMO CLIENTE
                            if (st.recuperar().totalProductosRegistrados() == 0) {
                                JOptionPane.showMessageDialog(null, "   No hay productos registrados para comprar  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                            }else{
                                int opcionElegidaCliente = 0;
                                do {                        
                                    System.out.flush();
                                    String menuAdmin = """

                                                       Bienvenido al menu del cliente
                                                       ¿Que desea realizar?

                                                       1. Hacer una comprar.
                                                       2. Regresar al menu.
                                                       """;

                                    opcionElegidaCliente = Integer.parseInt(JOptionPane.showInputDialog(null, menuAdmin, "Ingrese una opcion del menú", JOptionPane.DEFAULT_OPTION));
                                    switch (opcionElegidaCliente) {
                                        case 1://HACER UNA COMPRA
                                            boolean seguirEligiendoProductos = true;
                                            ArrayList<Producto> productosElegidos = new ArrayList<>();
                                            while (seguirEligiendoProductos) { 
                                                
                                                
                                                
                                                boolean elegirCategoria = true;
                                                String categoria = "";
                                                
                                                while (elegirCategoria) {   
                                                    String[] categorias = st.recuperar().getCategoriasA();
                                                    String categoriaP = (String) JOptionPane.showInputDialog(null,"\n-Seleccione la categoria de donde quieres comprar el producto\n-Presione cancelar para regresar al menu\n\n","Registrar Producto", JOptionPane.DEFAULT_OPTION, null, categorias, categorias[0]);
                                                        if (categoriaP == null) {
                                                            JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                            elegirCategoria = false;
                                                            seguirEligiendoProductos = false;
                                                        }
                                                        categoria = categoriaP;
                                                        elegirCategoria = false;
                                                }
                                                String producto = "";
                                                
                                                boolean elegirProducto = true;
                                                boolean elegirS = true;
                                                int cantidad = 0;
                                                if (seguirEligiendoProductos) {
                                                    while (elegirProducto) {   
                                                        String[] productos = st.recuperar().getNombresYCodigo(categoria);
                                                        if (productos.length > 0) {
                                                            String productoP = (String) JOptionPane.showInputDialog(null,"\n-Seleccione el producto\n-Presione x para regresar al menu\n\n","Registrar Producto", JOptionPane.DEFAULT_OPTION, null, productos, productos[0]);
                                                            Producto p = st.recuperar().sacarParteNumerica(productoP);
                                                            Producto proLlevar = null;
                                                            boolean repetirCantidad = true;
                                                            while (repetirCantidad) {                                                                
                                                                if (p.getStock() > 0) {
                                                                    int maxStock = p.getStock();
                                                                    String nombreProducto = p.getNombre();
                                                                    int stockProducto = p.getStock();
                                                                    double precioUnitario = p.getPrecioUnitario();
                                                                    int precioEnPuntos = p.getPrecioPuntos();

                                                                    // Construye una cadena con la información del producto
                                                                    String mensaje = "Producto elegido: " + nombreProducto + "\n" +
                                                                                    "Stock disponible: " + stockProducto + "\n" +
                                                                                    "Precio Unitario: $" + precioUnitario + "\n" +
                                                                                    "Precio en Puntos: " + precioEnPuntos + " puntos\n" +
                                                                                    "Ingrese la cantidad que desea llevar del producto o -1 para salir:\n\n";
                                                                    String cantidadStr = JOptionPane.showInputDialog(null, mensaje, "Cantidad", JOptionPane.QUESTION_MESSAGE);
                                                                    try {
                                                                        int cantidadE = Integer.parseInt(cantidadStr);
                                                                        if (cantidadE == -1) {
                                                                            repetirCantidad = false;
                                                                        }else{
                                                                            if (cantidadE > 0 && cantidadE <= maxStock) {
                                                                                Tienda tm = st.recuperar();
                                                                                tm.buscarProductoN(p.getCodigo()).dato.setStock(p.getStock() - cantidadE) ;
                                                                                st.guardar(tm);
                                                                                
                                                                                cantidad = cantidadE;
                                                                                proLlevar = new Producto(p.getCodigo(), p.getNombre(), p.getDescripcion(), cantidad, p.getPrecioUnitario(), p.getPrecioPuntos(), p.getPeso());
                                                                                proLlevar.setCategoria(p.getCategoria());
                                                                                repetirCantidad = false;
                                                                            }else{
                                                                                JOptionPane.showMessageDialog(null, "La cantidad seleccionada debe ser mayor a 0 y no puede superar el stock disponible del producto.\n", "Mensaje", JOptionPane.WARNING_MESSAGE);
                                                                            }
                                                                        }
                                                                    } catch (NumberFormatException e) {
                                                                    // Manejo de error si la entrada no es un número entero válido
                                                                        JOptionPane.showMessageDialog(null, "La cantidad ingresada no es válida. Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                    }
                                                                }else{
                                                                    JOptionPane.showMessageDialog(null, "El producto no tiene stock disponible.\nElija otro producto", "Alerta: Sin Stock", JOptionPane.WARNING_MESSAGE);
                                                                    repetirCantidad = false;
                                                                
                                                                }
                                                                
                                                            }
                                                            
                                                            if (proLlevar != null) {
                                                                productosElegidos.add(proLlevar);
                                                            }
                                                            
                                                            
                                                            String[] optionsA = {"Regresar al menu", "Seguir eligiendo productos", "Dejar de elegir productos"};
                                                            
                                                            int seleccionA = JOptionPane.showOptionDialog(null,"", "Elegir productos", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, optionsA, optionsA[0]);
                                                            if (seleccionA == 0 || seleccionA == -1) {
                                                               
//                                                                for (Producto pe : productosElegidos) {
//                                                                if (pe != null) {
//                                                                        Tienda tm = st.recuperar();
//                                                                        tm.buscarProductoN(pe.getCodigo()).dato.setStock(pe.getStock() + cantidad);
//                                                                        st.guardar(tm);
//                                                                    }
//                                                                }  
//                                                                productosElegidos.clear();

                                                               elegirProducto = false;
                                                               seguirEligiendoProductos = false;
                                                            }else{
                                                                if (seleccionA == 1) {
                                                                    elegirS = false;
                                                                    elegirProducto = false;
                                                                }else{
                                                                    if (proLlevar == null) {
                                                                        JOptionPane.showMessageDialog(null, "Debes elegir al menos un producto para continuar con la compra.", "Aviso", JOptionPane.WARNING_MESSAGE);
                                                                        elegirS = false;
                                                                        elegirProducto = false;
                                                                    }else{
                                                                        elegirProducto = false;
                                                                    }
                                                                }
                                                            }
                                                        }else{
                                                            elegirProducto = false;
                                                            JOptionPane.showMessageDialog(null, "   No hay productos dentro de la categoria  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);    
                                                        }
                                                        
                                                     
                                                    }
                                                }
                                                
                                                String cedula = "";
                                                boolean elegirR = true;//
                                                if (seguirEligiendoProductos && elegirS ) {
                                                    
                                                    for (Producto productosElegido : productosElegidos) {
                                                        System.out.println(productosElegido.toString());
                                                    }
                                                    
                                                    boolean preguntarCedula = true;
                                                    while (preguntarCedula) {
                                                        String cedulaP = JOptionPane.showInputDialog(null, "\n- Digita la cedula del cliente \n - Digita -1 para regresar al menu\n\n", "Compra", JOptionPane.QUESTION_MESSAGE);
                                                        if (cedulaP.equalsIgnoreCase("-1")) {
                                                            
                                                            preguntarCedula = false;
                                                            elegirS = false;
                                                            seguirEligiendoProductos = false;
                                                            
                                                        }else{
                                                            if ( cedulaP.length() == 10) {
                                                                cedula = cedulaP;
                                                                preguntarCedula = false;
                                                            }else{
                                                                JOptionPane.showMessageDialog(null, "La cedula debe tener 10 dígitos. Por favor, ingrese una cedula valida.", "Error", JOptionPane.ERROR_MESSAGE);
                                                            }
                                                        }
                                                    }
                                                }
                                                
                                                if (seguirEligiendoProductos && elegirS) {
                                                    Cliente clienteCompra = null;
                                                    Nodo<Cliente> bus = st.recuperar().buscarClienteN(cedula);
                                                    if (bus != null) {
                                                        clienteCompra = bus.dato;
                                                        JOptionPane.showMessageDialog(null, "'\nLa persona ya esta registrada\nContinue con el pago\n\n");
                                                    }else{
                                                        JOptionPane.showMessageDialog(null, "'\nLa persona no esta registrada\nRegistrala\n\n");
                                                        String repetirRegristroA = "";
                                                        int repetirRegistroA = 0;
                                                        do {   
                                                            String direccion = "";
                                                            if (repetirRegistroA != -1) {
                                                                boolean preguntarDireccion = true;
                                                                while (preguntarDireccion) {
                                                                    String direnccionP = JOptionPane.showInputDialog(null, "\n- Digita la direccion de la persona\n- Digita -1 para regresar al menu\n\n", "Registrar Persona", JOptionPane.QUESTION_MESSAGE);
                                                                    if (!direnccionP.equalsIgnoreCase("-1")) {
                                                                        if (direnccionP.length() >= 10) {
                                                                                preguntarDireccion = false;
                                                                                direccion = direnccionP;
                                                                        }else{
                                                                            JOptionPane.showMessageDialog(null, "La direccion debe tener mas de 10 caracteres. Por favor, ingresa una direccion valida.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                        }
                                                                    }else{
                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                        preguntarDireccion = false;
                                                                        repetirRegristroA = "-1";
                                                                        seguirEligiendoProductos = false;
                                                                        
                                                                    }     
                                                                }
                                                            }

                                                            String numeroDeTelefono = "";
                                                            if (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1")) {
                                                                boolean preguntarNumeroDeTelefono = true;
                                                                while (preguntarNumeroDeTelefono) {  
                                                                    String numeroDeTelefonoP = JOptionPane.showInputDialog(null,"\n- Digita un numero de telefono para la persona\n- Digita -1 para regresar al menu\n\n" , "Registrar Cliente", JOptionPane.QUESTION_MESSAGE);
                                                                    if (!numeroDeTelefonoP.equalsIgnoreCase("-1")) {
                                                                        if (numeroDeTelefonoP.length() == 10) {
                                                                                preguntarNumeroDeTelefono = false;
                                                                                numeroDeTelefono = numeroDeTelefonoP;
                                                                        }else{
                                                                            JOptionPane.showMessageDialog(null, "El numero de telefono debe tener 10 digitos. Por favor, ingrese una numero de telefono valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                        }
                                                                    }else{
                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                        preguntarNumeroDeTelefono = false;
                                                                        repetirRegristroA = "-1";
                                                                        seguirEligiendoProductos = false;
                                                                        
                                                                    }     
                                                                }
                                                            }
                                                            String nombreCompleto = "";
                                                            if (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1")) {
                                                                boolean preguntarNombreCompleto = true;
                                                                while (preguntarNombreCompleto) {  

                                                                    String NombreCompletoP = JOptionPane.showInputDialog(null, "\n- Digita el nombre del cliente\n- Digita -1 para regresar al menu\n\n" , "Registrar Cliente", JOptionPane.QUESTION_MESSAGE);
                                                                    if (!NombreCompletoP.equalsIgnoreCase("-1")) {
                                                                        if (NombreCompletoP.length() > 0) {
                                                                                preguntarNombreCompleto = false;
                                                                                nombreCompleto = NombreCompletoP;
                                                                        }else{
                                                                            JOptionPane.showMessageDialog(null, "El campo no puede estar vacio. Por favor, ingrese una nombre.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                        }
                                                                    }else{
                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                        preguntarNombreCompleto = false;
                                                                        repetirRegristroA = "-1";
                                                                        seguirEligiendoProductos = false;
                                                                        
                                                                    }     
                                                                }
                                                            }
                                                            String correoElectronico = "";
                                                            if (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1")) {
                                                                boolean preguntarCorreoElectronico = true;
                                                                while (preguntarCorreoElectronico) {
                                                                    String correoElectronicoP = JOptionPane.showInputDialog(null, "\n- Digita el correo electronico del cliente\n-Digita -1 para regresar al menu\n\n" , "Registrar Cliente", JOptionPane.QUESTION_MESSAGE);

                                                                    if (!correoElectronicoP.equalsIgnoreCase("-1")) {
                                                                        if (correoElectronicoP.length() > 5) {
                                                                                preguntarCorreoElectronico = false;
                                                                                correoElectronico = correoElectronicoP;
                                                                        }else{
                                                                            JOptionPane.showMessageDialog(null, "El campo debe tener más de 5 digitos. Por favor, ingrese correo electronico valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                        }
                                                                    }else{
                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                        preguntarCorreoElectronico = false;
                                                                        repetirRegristroA = "-1";
                                                                        seguirEligiendoProductos = false;
                                                                        
                                                                    }     
                                                                }
                                                            }
                                                            String pais = "";
                                                            if (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1")) {
                                                                boolean preguntarPais = true;
                                                                while (preguntarPais) {  
                                                                    String paisP = JOptionPane.showInputDialog(null, "\n- Digita el pais del cliente\n- Digita -1 para regresar al menu\n\n" , "Registrar cliente", JOptionPane.QUESTION_MESSAGE);

                                                                    if (!paisP.equalsIgnoreCase("-1")) {
                                                                        if (paisP.length() > 3) {
                                                                                preguntarPais = false;
                                                                                pais = paisP;
                                                                        }else{
                                                                            JOptionPane.showMessageDialog(null, "El campo debe tener más de 3 digitos. Por favor, ingrese pais valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                        }
                                                                    }else{
                                                                        JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                                                        preguntarPais = false;
                                                                        repetirRegristroA = "-1";
                                                                        seguirEligiendoProductos = false;
                                                                        
                                                                    }     
                                                                }
                                                            }
                                                            if (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1")) {
                                                                String[] options2 = {"Salir al menu", "Registrar cliente cliente"};
                                                                String resumenProducto = "\nResumen del cliente registrado\n-----------------------------------------\n"
                                                                    + "\n-Cedula del cliente: " + cedula
                                                                    + "\n-Direccion del cliente: " + direccion +""
                                                                    + "\n-Numero de telefono: " + numeroDeTelefono + "\n-Nombre Completo: " + nombreCompleto + ""
                                                                    + "\n-Correo Electronico: " + correoElectronico +"\n-Pais: " + pais + "\n\n";

                                                                int seleccionResumen = JOptionPane.showOptionDialog(null, resumenProducto, "Resumen Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options2, options2[0]);
                                                                System.out.println("mani: " + seleccionResumen);
                                                                if (seleccionResumen == 0 || seleccionResumen == -1) {
                                                                    repetirRegistroA = -1;
                                                                    seguirEligiendoProductos = false;
                                                                    
                                                                }else{
                                                                    clienteCompra = new Cliente(cedula, direccion, numeroDeTelefono, nombreCompleto, correoElectronico, pais);
                                                                    Tienda tf = st.recuperar();
                                                                    
                                                                    tf.agregarCliente(clienteCompra);
                                                                    st.guardar(tf);
                                                
                                                                    JOptionPane.showMessageDialog(null, "El cliente fue modificado con exito", "Guardado...",JOptionPane.INFORMATION_MESSAGE);   
                                                                    repetirRegistroA = -1;
                                                                }
                                                            }
                                                        } while (repetirRegistroA != -1 && !repetirRegristroA.equalsIgnoreCase("-1"));    
                                                        
                                                       
                                                    }
                                                    
                                                     float total = 0;
                                                        for (Producto productosElegido : productosElegidos) {
                                                            total += (productosElegido.getStock() * productosElegido.getPrecioUnitario());
                                                        }
                                                        float cantidadIngresada = 0;
                                                        if (seguirEligiendoProductos && elegirS) {



                                                            while (cantidadIngresada < total && cantidadIngresada != -1) {
                                                                String cantidadStr = JOptionPane.showInputDialog(null, "\nEl total a pagar es: " + total+"\n\n"+ "\nIngrese -1 para salir al menu\nIngrese cantidad de dinero del cliente", "Cantidad", JOptionPane.QUESTION_MESSAGE);

                                                                try {
                                                                    cantidadIngresada = Float.parseFloat(cantidadStr);

                                                                    if (cantidadIngresada < total) {
                                                                        JOptionPane.showMessageDialog(null, "La cantidad ingresada es menor que el total. Por favor, ingrese una cantidad igual o mayor al total.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                    }
                                                                } catch (NumberFormatException e) {
                                                                    JOptionPane.showMessageDialog(null, "La cantidad ingresada no es válida. Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                }
                                                            }

                                                        }
                                                        Tienda f = st.recuperar();

                                                        String codigoFactura = f.generarFactura(clienteCompra, productosElegidos,  cantidadIngresada);
                                                        st.guardar(f);

                                                        Nodo<Factura> detalle = st.recuperar().buscarFactura(codigoFactura);
                                                        JTextArea textAreaa = new JTextArea(20, 45);
                                                        textAreaa.setWrapStyleWord(true);
                                                        textAreaa.setLineWrap(true);
                                                        textAreaa.setEditable(false);
                                                        textAreaa.setCaretPosition(0);

                                                        String resumenFactura =  detalle.dato.detalleFactura();
                                                        textAreaa.setText(resumenFactura);
                                                        JScrollPane scrollPane = new JScrollPane(textAreaa);
                                                        JOptionPane.showMessageDialog(null,scrollPane, "Resumen de Factura->",JOptionPane.INFORMATION_MESSAGE);

                                                        String[] optionsA = {"Regresar al menu", "Realizar otra compra"};
                                                        int seleccionA = JOptionPane.showOptionDialog(null,"", "Resumen Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, optionsA, optionsA[0]);
                                                        if (seleccionA == 0 || seleccionA == -1) {
                                                             seguirEligiendoProductos = false;
                                                             elegirS = false;
                                                        }else{
                                                            
                                                        }  
                                                
                                                }
                                            }//FIN WHILE
                                            
                                            break;
                                         
                                        case 2://REGRESAR AL MENU
                                            JOptionPane.showMessageDialog(null, "   ¡Regresando al menu principal!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                                            opcionElegidaCliente = 4;
                                            break;  
                                        default:
                                            JOptionPane.showMessageDialog(null, "La opción elegida no se encuentra en el menú", "¡Error!",JOptionPane.ERROR_MESSAGE);
                                            break;
                                    }
                    
                                    break;
                                } while (opcionElegida1 != 2);
                            
                            }
                            break;
                        case 3: //SALIR
                            JOptionPane.showMessageDialog(null, "   ¡Muchas gracias por usar nuestro programa!  ", "Saliendo...", JOptionPane.DEFAULT_OPTION);
                            opcionElegida1 = -1;
                            break;    
                        default:
                            JOptionPane.showMessageDialog(null, "La opción elegida no se encuentra en el menú", "¡Error!",JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                    
                } while (opcionElegida2 != 3);
            }   
        } while (opcionElegida1 != -1);
        
    }
    
}
