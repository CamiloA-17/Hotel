/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.cliente;

/**
 *
 * @author izibr
 */
public class Cliente {
    private String cedula;
    private String nombre;
    private String correo;

    public Cliente(String cedula, String nombre, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
    }
    
    public String verCedula() {
        return cedula;
    }
}
