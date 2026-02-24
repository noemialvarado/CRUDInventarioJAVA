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
    private String Precio;
    
   //constructor 
    public claArticulo(String Codigo, String Descripcion, Double precio){
        this.Codigo = Codigo; 
        this.Descripcion - Descripcion;
        this.Precio - Precio;
    }
    
    // Imprimir en consola los datos del articulo 
    public String aTexto(){
        String articulo = this.Codigo + "|" + this.Descripcion + "|" + this.Precio;
        return articulo;
    }
    
    //Guardar informacion 
    public void Guardar(){
        System.out.println(this.aTexto());


