/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import logicadelnegocio.Tienda;

/**
 *
 * @author Jonathan Vizcaino
 */
public class SerializarTienda {
    public void guardar(Tienda t) throws FileNotFoundException, IOException{
        FileOutputStream archivo = new FileOutputStream("tienda.datos");
        ObjectOutputStream salida = new ObjectOutputStream(archivo);
        salida.writeObject(t);
        salida.close();
        archivo.close();
    }
    
    public Tienda recuperar() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream archivo = new FileInputStream("tienda.datos");
        ObjectInputStream entrada = new ObjectInputStream(archivo);
        Tienda t = (Tienda) entrada.readObject();
        entrada.close();
        archivo.close();
        return t;

    }
}
