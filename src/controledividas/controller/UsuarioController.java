/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledividas.controller;

import controledividas.model.Usuario;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edmilson Rolas
 */
public class UsuarioController {
    
    private static final ArrayList<Usuario> LISTA_USUARIOS = new ArrayList<>();
	
//    static {
//            LISTA_USUARIOS.add(new Usuario(1, "Maria", "kkk", "email@mr", "+55 34 00000 0000", "sss"));
//            LISTA_USUARIOS.add(new Usuario(2, "João", "kkk", "email@jo", "+55 34 00000 0000", "sss"));
//            LISTA_USUARIOS.add(new Usuario(3, "Normandes", "kkk", "email@nr", "+55 34 00000 0000", "sss"));
//            LISTA_USUARIOS.add(new Usuario(4, "Thiago", "kkk", "email@th", "+55 34 00000 0000", "sss"));
//            LISTA_USUARIOS.add(new Usuario(5, "Alexandre", "kkk", "email@al", "+55 34 00000 0000", "sss"));
//    }
//    
    public static int contarUsuarios(){
        return listarUsuarios().size();
    }
    
    public static boolean temUsuarios(){
        return contarUsuarios() > 0;
    }
    
    public static List<Usuario> listarUsuarios() {
        
        try{
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\LP\\Documents\\NetBeansProjects\\ControleDividas\\src\\rgistros\\usuarios.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            List<Usuario> usuarios = (List<Usuario>) objectInputStream.readObject();
            for (int i = 0; i > -1; i++) {
                LISTA_USUARIOS.add((Usuario) objectInputStream.readObject());
                
            }
                
            fileInputStream.close();
            objectInputStream.close();
        }catch(EOFException e){
            return LISTA_USUARIOS;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return LISTA_USUARIOS;
    }
    
    public static void registar(Usuario usuario){
        List<Usuario> usuarios = listarUsuarios();
        try{
            FileOutputStream fileOutputStream = 
                    new FileOutputStream("C:\\Users\\LP\\Documents\\NetBeansProjects\\ControleDividas\\src\\rgistros\\usuarios.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (Usuario usuario1 : usuarios) {
                objectOutputStream.writeObject(usuario1);
            }
            objectOutputStream.writeObject(usuario);
            
            fileOutputStream.close();
            objectOutputStream.close();
            
        }catch(Exception e) {
            e.printStackTrace( );
        }
    }
    
    public static boolean autenticar(Usuario u) {
        List<Usuario> usuarios = listarUsuarios();
        boolean autentica = usuarios.stream().anyMatch(p -> p.getEmail().equals(u.getEmail()));
        return autentica;
    }
    
    public static void main(String[] args) {
//        registar(new Usuario(27, "Maria", "kkk", "email@mr", "+55 34 00000 0000", "sss"));
        System.out.println(listarUsuarios());
//        System.out.println(contarUsuarios());
    }

    
}
