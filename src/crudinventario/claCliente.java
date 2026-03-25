/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author ponce
 */
public class claCliente {
    
    //Atributo que necesito que tenga el objeto atributo 
    private String NoCliente;
    private String Nombre;
    private String TipoCliente;
    private String RazonSocial;
    
   //constructor 
    public claCliente(String NoCliente, String Nombre, String TipoCliente,String RazonSocial){
        this.NoCliente = NoCliente; 
        this.Nombre = Nombre;
        this.TipoCliente = TipoCliente;
        this.RazonSocial = RazonSocial;
    }
    //sobrecarga de metodo constructor
    public  claCliente (){
        
    }
    
    // Imprimir en consola los datos del articulo 
    public String aTexto(){
        String Cliente = this.NoCliente + "|" + this.Nombre + "|" + this.TipoCliente + "|" + this.RazonSocial;
        return Cliente;
    }
    
    public String getNombre(){
        return this.Nombre;
    }
    
    //Guardar informacion 
    public void guardar(){  
        // Instanciado a la clase de MODELO
        mCliente cliente = new mCliente ();
        // Enviamos la cadena de texto para guardar en el archivo
        cliente.insertar(this.aTexto());
        
        System.out.println(this.aTexto());
    }

    public DefaultListModel<String> llenarLista(){
    // Instancia desde lo datos (modelo)
    mCliente cClient = new mCliente();
    //Llenamos la variable con los datos desde el modelo
    ArrayList<String> datos = cClient.consultar ();
    
    // Creamos la plantilla en blanco para el modelo 
    DefaultListModel<String> modelLista = new DefaultListModel<>();
    // llenamos la plantilla con los datos del modelo
    for (String registro: datos){
        modelLista.addElement (registro);
    }
    
    //devolvemos los datos cargados en el modelo de lista
    return modelLista;  
}

    public void actualizar(String newNoCliente, String newNombre, String newTipoCliente,String newRazonSocial ){
        
        //Generamos la nueva linea del registro
        String NuevaLinea = newNoCliente + "|" + newNombre + "|" + newTipoCliente + "|" + newRazonSocial ;
        String lineaOriginal = this.NoCliente + "|" + this.Nombre.trim() + "|" + this.TipoCliente.trim() + "|" + this.RazonSocial.trim();

        //Inprimir los nuevos valores
        System.out.println("Nuevo valores:" + NuevaLinea);
        System.out.println("Valores Originales:" + lineaOriginal);
        //solicita la actualizacion del registro
        mCliente cCliente = new mCliente();
        cCliente.update (lineaOriginal,NuevaLinea,"listado_clientes.txt");
    } 

    public void eliminar(){
        //Registro a eliminar
        String lineaOriginal = this.NoCliente + "|" + this.Nombre + "|" + this.TipoCliente + "|" + this.RazonSocial ;
        System.out.println("valores Originales:" + lineaOriginal);
        // solicita la actualizacion del registro 
        mCliente cCliente = new mCliente();
        cCliente.delete(lineaOriginal, "listado_clientes.txt");
            } 
}
