/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ponce
 */
public class mArticulo {
 
    public void insertar(String cadenaArticulo){
        
        try {
            // Esta linea crea el archivo donde se guarda la informacion
            FileWriter archivo = new FileWriter("listado_articulos.txt",true);
            // Buffer temporal que se encarga de guardar los datos en el archivo
            BufferedWriter buffer = new BufferedWriter(archivo);
            
            // Escribe en el archivo de texto
            buffer.write(cadenaArticulo); 
            // Agrega un salto de linea al registro
            buffer.newLine(); 
            // Guarda los registros en el archivo
            buffer.close();
            

        } catch (IOException e) {
            //lblSaludo.setText("Error al guardar el archivo: " + e.getMessage());
        }
   }     
    
    public ArrayList<String>  consultar(){
        //variable donde se guarda los registros de mi archivo 
        ArrayList<String> listaRegistros = new ArrayList <>();
        
        //Este codigo lee el archivo completo para usarlo 
        try(BufferedReader br = new BufferedReader (new FileReader("listado_articulos.txt"))){
            //Recorrido de registros en el archivo
            String linea;
            while ((linea = br.readLine()) != null){
              // separa el dato guardado por un caracter especial
              String[] datos = linea.split("\\|");
              //crea un String formateando como lo necesitas 
              String datoBonito = "Codigo: " + datos[0] + "| Descripcion: " + datos[1] + "| Precio: " + datos[2];
              //Agrega el registro a el listado de datos 
              listaRegistros.add(datoBonito);
               
            }
            
        }catch(IOException e){
            // Muestra los error que pudieran tener 
            System.out.println("Mensaje de error" + e.getMessage());
            listaRegistros.add("Error al cargar los datos");
        }
        return listaRegistros;
    }
    

public void update(String lineaActual, String lineaNueva, 
            String archivoOriginal){
        
        //Declaramos los archivos original(lectura) temporal(escritura)
        java.io.File fileOriginal = new java.io.File(archivoOriginal);
        java.io.File fileTemporal = new java.io.File("temporal.txt");
        
        String lineaLeida;
        Boolean actualizado = false;
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileOriginal));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemporal));){
            
            while((lineaLeida = br.readLine()) != null){
                if(lineaLeida.equals(lineaActual)){
                    bw.write(lineaNueva);
                    actualizado = true;
                } else {
                    bw.write(lineaLeida); 
                    bw.newLine();
                }
                
            }
        }catch(Exception e){
            System.out.println("Error al actualizar" + e.getMessage());
        }
        
        // Eliminación de archivo original y renombre de temporal
        if(actualizado){
            if(fileOriginal.delete()){
                fileTemporal.renameTo(fileOriginal);
                System.out.println("Registro Actualizado");
            } else {
                System.out.println("Error: No se pudo borrar el archivo");
            }
        }else{
            fileTemporal.delete();
            System.out.println("No se encontró el registro");
        }
        
        
    }

public void delete(String lineaActual,String archivoOriginal){
        
        //Declaramos los archivos original(lectura) temporal(escritura)
        java.io.File fileOriginal = new java.io.File(archivoOriginal);
        java.io.File fileTemporal = new java.io.File("temporal.txt");
        
        String lineaLeida;
        Boolean eliminado = false;
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileOriginal));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemporal));){
            
            while((lineaLeida = br.readLine()) != null){
                if(lineaLeida.equals(lineaActual)){
                    
                    eliminado = true;
                } else {
                    bw.write(lineaLeida);
                }
                    bw.newLine();  
            }
        }catch(Exception e){
            System.out.println("Error al eliminar" + e.getMessage());
        }
        
        // Eliminación de archivo original y renombre de temporal
        if(eliminado){
            if(fileOriginal.delete()){
                fileTemporal.renameTo(fileOriginal);
                System.out.println("Registro eliminado");
            } else {
                System.out.println("Error: No se pudo borrar el archivo");
            }
        }else{
            fileTemporal.delete();
            System.out.println("No se encontró el registro");
        }
        
        
    }
}