/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel.gui;

import hotel.Hotel;
import javax.swing.JOptionPane;

/**
 *
 * @author izibr
 */
public class Vista extends javax.swing.JFrame {
    Hotel hotel;
    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
        //Cambiar título ventana
        //setTitle(hotel.getNombre());
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnAlquilar = new javax.swing.JButton();
        btnDejar = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel1.setText("Hotel Trivago");

        btnRegistrar.setText("Registrar usuario");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnAlquilar.setText("Alquilar habitación");
        btnAlquilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlquilarActionPerformed(evt);
            }
        });

        btnDejar.setText("Dejar habitación");
        btnDejar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDejarActionPerformed(evt);
            }
        });

        btnReportes.setText("Ver reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlquilar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDejar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(167, 167, 167))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addComponent(btnRegistrar)
                .addGap(18, 18, 18)
                .addComponent(btnAlquilar)
                .addGap(18, 18, 18)
                .addComponent(btnDejar)
                .addGap(18, 18, 18)
                .addComponent(btnReportes)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        VistaRegistrarr nuevaVentana= new VistaRegistrarr(this);
        nuevaVentana.setVisible(true);
        if(!nuevaVentana.isControl())
            return;
        String cedula= nuevaVentana.getCedula();
        String nombre= nuevaVentana.getNombre();
        String correo= nuevaVentana.getCorreo();
        if(hotel.registrarUsuario(cedula, nombre, correo)){
            JOptionPane.showMessageDialog(this, "¡Se agregó correctamente el usuario!", "Registrar", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Ya existe una persona registrada con esa cédula", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnAlquilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlquilarActionPerformed
        VistaAlquilarr nuevaVentana= new VistaAlquilarr(this, hotel.getMisClientes());
        nuevaVentana.setVisible(true);
        if(!nuevaVentana.isControl())
            return;
        String cedula= nuevaVentana.getCedula();
        int numInvitados= nuevaVentana.getNumInvitados();
        if(hotel.alquilarHabitacion(cedula, numInvitados)){
            JOptionPane.showMessageDialog(null, "¡Habitación alquilada con éxito!", "Aviso", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "No hay habitaciones disponibles", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAlquilarActionPerformed

    private void btnDejarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDejarActionPerformed
        String numero = JOptionPane.showInputDialog(this, "Ingrese el número de habitación");
        if(hotel.dejarHabitacion(numero)){
            JOptionPane.showMessageDialog(this, "La habitación fue desasignada con exito");
        }else{
            JOptionPane.showMessageDialog(this, "La habitación ingresada no existe");
        }
        
    }//GEN-LAST:event_btnDejarActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        double beneficiosTotal= hotel.calcularBeneficios();
        VistaReportee nuevaVentana= new VistaReportee(this, beneficiosTotal);
        nuevaVentana.setVisible(true);
        if(!nuevaVentana.isControl())
            return;
        String numHabitacion= nuevaVentana.getNumHabitacion();
        double beneficios= hotel.calcularBeneficios(numHabitacion);
        VistaReporteTotal reporte= new VistaReporteTotal(this, numHabitacion, beneficios);
        reporte.setVisible(true);   
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlquilar;
    private javax.swing.JButton btnDejar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
