/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledividas.controller;

import controledividas.model.bean.Divida;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Edmilson Rolas
 */
public class DividasController {
    
    public static List<Divida> listar() {
        List<Divida> dividas = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream("dividas.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            dividas = (List<Divida>) objectInputStream.readObject();
                
            fileInputStream.close();
            objectInputStream.close();
//        }catch(EOFException e){
//            return LISTA_USUARIOS;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return dividas;
    }
    
    public static void registar(Divida divida){
        List<Divida> dividas = listar();
        dividas.add(divida);
        try{
            FileOutputStream fileOutputStream = 
                    new FileOutputStream("dividas.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(dividas);
            
            fileOutputStream.flush();
            fileOutputStream.close();
            
            objectOutputStream.flush();
            objectOutputStream.close();
            
        }catch(Exception e) {
            e.printStackTrace( );
        }
    }
    
       public static void main(String[] args) {
           registar(new Divida("lena", "der", Date.from(Instant.now()), 13.00, 20.00));
           System.out.println(listar());
//        System.out.println(contarUsuarios());
    }

}
