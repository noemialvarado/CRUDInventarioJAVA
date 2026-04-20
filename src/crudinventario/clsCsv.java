/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ponce
 */
public class clsCsv {
    
    //Atributo de el objeto csv2
    String archivo = "inventario2.1.csv";
    
    //Metodo de el objeto csv2
    public void importarDatos(){
        try(BufferedReader br = new BufferedReader ( new FileReader(archivo))){
            br.readLine(); //Salta la primera linea
            
        String linea;
        
        while ((linea = br.readLine()) !=null){
       
            String[] datos = linea.split(",");
            // asignacion de valores para insertar datos.
            claArticulo cArticulo = new claArticulo (
                datos[0], datos[1], Double.parseDouble(datos[2]));
            //Almacena en archivo txt 
            cArticulo.guardar();
        }
        System.out.println("se ha terminado con la importacion :");
    }catch(IOException e){
        System.out.println("Mensaje de error" + e.getMessage());
            }
        
    }
    
}
