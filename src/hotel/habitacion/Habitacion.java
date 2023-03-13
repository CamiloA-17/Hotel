/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.habitacion;

import hotel.cliente.Cliente;

/**
 *
 * @author izibr
 */
public class Habitacion {
    private String numero;
    private int numeroInvitados;
    private Cliente miCliente;
    public Habitacion(String numero) {
        this.numero = numero;
        this.numeroInvitados = 0;
        this.miCliente = null;
    }
    
    public boolean alquilar(Cliente cliente, int numeroInvitados){
        if(numeroInvitados >= 0 & numeroInvitados < 5){
            this.setNumeroInvitados(numeroInvitados);
            this.setMiCliente(cliente);
            return true;
        }
        return false;    
    }
    
    public void recibir(){
        this.setMiCliente(null);
        this.setNumeroInvitados(0);
    }
    
    public boolean estaLibre(){
        if(this.getMiCliente() == null && this.getNumeroInvitados() == 0){
            return true;
        }
        return false;
    }
    
    public double calcularBeneficios(double valorDiario, double valorAdicional){
        if(!this.estaLibre()){
            return valorDiario + (valorAdicional * this.numeroInvitados);
        }
        return 0;
    }

    public void setNumeroInvitados(int numeroInvitados) {
        this.numeroInvitados = numeroInvitados;
    }

    public void setMiCliente(Cliente miCliente) {
        this.miCliente = miCliente;
    }

    public int getNumeroInvitados() {
        return numeroInvitados;
    }

    public Cliente getMiCliente() {
        return miCliente;
    }

    public String getNumero() {
        return numero;
    }
    
    
}
