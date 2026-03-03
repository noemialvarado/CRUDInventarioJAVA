/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

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
    
    // Imprimir en consola los datos del articulo 
    public String aTexto(){
        String articulo = this.Codigo + "|" + this.Descripcion + "|" + this.Precio;
        return articulo;
    }
    
    //Guardar informacion 
    public void guardar(){
        // Instanciado a la clase de MODELO
        mArticulo article = new mArticulo ();
        // Enviamos la cadena de texto para guardar en el archivo
        article.insertar(this.aTexto());
        
        System.out.println(this.aTexto());
    }
}


