/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;
import hotel.cliente.Cliente;
import hotel.habitacion.Habitacion;
import java.util.ArrayList;


public class Hotel {
    private String nombre;
    private ArrayList<Cliente> misClientes;
    private Habitacion[] misHabitaciones;
    private double valorDiario;
    private double valorAdicional;

    public Hotel(String nombre, double valorDiario, double valorAdicional) {
        this.nombre = nombre;
        this.valorDiario = valorDiario;
        this.valorAdicional = valorAdicional;
        this.misClientes = new ArrayList<>();
        this.misHabitaciones = new Habitacion[8];
        misHabitaciones[0] = new Habitacion("101");
        misHabitaciones[1] = new Habitacion("102");
        misHabitaciones[2] = new Habitacion("201");
        misHabitaciones[3] = new Habitacion("202");
        misHabitaciones[4] = new Habitacion("301");
        misHabitaciones[5] = new Habitacion("302");
        misHabitaciones[6] = new Habitacion("401");
        misHabitaciones[7] = new Habitacion("402");

    }
    
    public boolean registrarUsuario(String cedula, String nombre, String correo){
        if(this.buscarCliente(cedula)==null){
            Cliente nuevoCliente = new Cliente(cedula, nombre, correo);
            this.misClientes.add(nuevoCliente);
            return true;
        }
        return false;
    }

    public int buscarHabitacion() {
        for (int i = 0; i < this.misHabitaciones.length; i++) {
            if (this.misHabitaciones[i].estaLibre()) {
                return i;
            }
        }
        return -1;
    }
    
    public int buscarHabitacion(String numero){
        for (int i = 0; i < this.misHabitaciones.length; i++) {
            if (this.misHabitaciones[i].getNumero().equals(numero)) {
                return i;
            }
        }
        return -1;
    }

    public Cliente buscarCliente(String cedula) {
        for (Cliente cliente : this.misClientes) {
            if (cliente.verCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean alquilarHabitacion(String cedula, int numInvitados) {
        Cliente cliente = this.buscarCliente(cedula);
        if (cliente!=null) {
            int indice = this.buscarHabitacion();
            if (indice != -1) {
                Habitacion habitacion = this.misHabitaciones[indice];
                if(habitacion.alquilar(cliente, numInvitados)){
                    return true;
                }
            }
        }
        //1. El cliente no está registrado
        //2. Todas las habitaciones están llenas
        //3. La cantidad de invitados sobrepasa lo estipulado
        return false;
    }

    public boolean dejarHabitacion(String numero) {
        int indice = this.buscarHabitacion(numero);
        if(indice!=-1){
            Habitacion habitacion = this.misHabitaciones[indice];
            habitacion.recibir();
            return true;
        }
        //1. La habitación ingresada no existe
        return false;
    }
    
    public double calcularBeneficios(){
        double resultado = 0;
        for (int i = 0; i < this.misHabitaciones.length; i++) {
            resultado += this.misHabitaciones[i].calcularBeneficios(this.valorDiario, this.valorAdicional);
        }
        return resultado;
    }
    
    public double calcularBeneficios(String numero){
        int indice = this.buscarHabitacion(numero);
        if(indice!=-1){
            return this.misHabitaciones[indice].calcularBeneficios(this.valorDiario, this.valorAdicional);
        }
        return 0;
    }
    
    
    //==================================================
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Cliente> getMisClientes() {
        return misClientes;
    }
    
    
    
    
}
