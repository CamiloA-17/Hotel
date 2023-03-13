/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel;

import hotel.gui.Vista;

/**
 *
 * @author izibr
 */
public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Trivago", 1000, 300);
        Vista vista = new Vista();
        vista.setHotel(hotel);
        vista.setVisible(true);
    }
}
