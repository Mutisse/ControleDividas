/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledividas.model.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Edmilson Rolas
 */
public class Divida implements Serializable{
    private String id;
    private String nomeDevedor;
    private String apelidoDevedor;
    private Date data;
    private double valorDivida;
    private double valorAPagar;
    
    enum Status {
        PAGA, NÃO_PAGA
    }

    public Divida(String nomeDevedor, String apelidoDevedor, Date data, double valorDivida, double valorAPagar) {
        this.id = UUID.randomUUID().toString();
        this.nomeDevedor = nomeDevedor;
        this.apelidoDevedor = apelidoDevedor;
        this.data = data;
        this.valorDivida = valorDivida;
        this.valorAPagar = valorAPagar;
    }

    @Override
    public String toString() {
        return "\nDivida{" + "id=" + id + ", nomeDevedor=" + nomeDevedor + ", apelidoDevedor=" + apelidoDevedor + ", data=" + data + ", valorDivida=" + valorDivida + ", valorAPagar=" + valorAPagar + '}';
    }

    

}
