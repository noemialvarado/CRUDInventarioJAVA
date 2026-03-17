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
public class claArticulo {
    
  //Atributo que necesito que tenga el objeto atributo 
    private String Codigo;
    private String Descripcion;
    private Double Precio;
    
   //constructor 
    public claArticulo(String Codigo, String Descripcion, Double precio){
        this.Codigo = Codigo; 
        this.Descripcion = Descripcion;
        this.Precio = precio;
    }
    //sobrecarga de metodo constructor
    public claArticulo(){
        
    }
    
    // Imprimir en consola los datos del articulo 
    public String aTexto(){
        String articulo = this.Codigo + "|" + this.Descripcion + "|" + this.Precio;
        return articulo;
    }
    
    public String getDescripcion(){
        return this.Descripcion;
    }
    
    //Guardar informacion 
    public void guardar(){
        // Instanciado a la clase de MODELO
        mArticulo article = new mArticulo ();
        // Enviamos la cadena de texto para guardar en el archivo
        article.insertar(this.aTexto());
        
        System.out.println(this.aTexto());
    }
    
    public DefaultListModel<String> llenarLista(){
    // Instancia desde lo datos (modelo)
    mArticulo mArticle = new mArticulo();
    //Llenamos la variable con los datos desde el modelo
    ArrayList<String> datos = mArticle.consultar();
    
    // Creamos la plantilla en blanco para el modelo 
    DefaultListModel<String> modelLista = new DefaultListModel<>();
    // llenamos la plantilla con los datos del modelo
    for (String registro: datos){
        modelLista.addElement (registro);
    }
    
    //devolvemos los datos cargados en el modelo de lista
    return modelLista;  
}
    
    public void actualizar(String newCodigo, String newDescripcion, String newPrecio){
        
        //Generamos la nueva linea del registro
        String nuevaLinea = newCodigo + "|" + newDescripcion + "|" + newPrecio;
        String lineaOriginal = this.Codigo.trim() + "|" + this.Descripcion.trim() + "|" + this.Precio;
        //Inprimir los nuevos valores
        System.out.println("Nuevo valores:" + nuevaLinea);
        System.out.println("Valores Originales:" + lineaOriginal);
        //solicita la actualizacion del registro
        mArticulo mArticule = new mArticulo();
        mArticule.update(lineaOriginal, nuevaLinea, "listado_articulos.txt");
        
    }
    


    public void eliminar(){
        //Registro a eliminar
        String lineaOriginal = this.Codigo + "|" + this.Descripcion + "|" + this.Precio;
        System.out.println("valores Originales:" + lineaOriginal);
        // solicita la actualizacion del registro 
        mArticulo mArticule = new mArticulo();
        mArticule.delete(lineaOriginal, "listado_articulos.txt");
    }
}
