/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledividas;

import controledividas.controller.UsuarioController;
import controledividas.view.Login;
import controledividas.view.RegistoUsuario;

/**
 *
 * @author Edmilson Rolas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (UsuarioController.temUsuarios()) 
            new Login().setVisible(true);
        else
            new RegistoUsuario().setVisible(true);
    }
    
}
