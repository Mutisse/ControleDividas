/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledividas.model;

import java.io.Serializable;

/**
 *
 * @author Edmilson Rolas
 */
public class Usuario implements Serializable{
    
    private int id;
    private String nome;
    private String apelido;
    private String email;
    private String telefone;
    private String senha;

    public Usuario(int id, String nome, String apelido, String email, String telefone, String senha) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "\nUsuario{" + "id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", email=" + email + ", telefone=" + telefone + '}';
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }

//    public boolean autentica (Usuario u){
//        if (this.email.equals(u.email) && this.senha.equals(u.senha)) {
//            return true;
//        }
//        return false;
//    }
    
    
}
