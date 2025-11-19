/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Persistencia.*;
import Entidades.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.sql.Time;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author lucio
 */
public class ProyeccionesV extends javax.swing.JInternalFrame {
 private DefaultTableModel modelo= new DefaultTableModel();

    ProyeccionData proyeD = new ProyeccionData();

    public ProyeccionesV() {
        initComponents();
        cabecera();
        cargarCombosP();
        cargarCombosS();
        configurarColores ();
        jcbPeliculas.setSelectedIndex(-1);
        jcbSalas.setSelectedIndex(-1);
        this.setLocation(180, 0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcbSalas = new javax.swing.JComboBox<>();
        jcbPeliculas = new javax.swing.JComboBox<>();
        jtIdiomas = new javax.swing.JTextField();
        jrbApto = new javax.swing.JRadioButton();
        jrSubtitulada = new javax.swing.JRadioButton();
        jsHoraInicio = new javax.swing.JSpinner();
        jsHoraFin = new javax.swing.JSpinner();
        jtPrecio = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProyecciones = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();
        jbMostrar = new javax.swing.JButton();
        jbHabilitar = new javax.swing.JButton();
        jbInhabilitar = new javax.swing.JButton();
        jrNoApto = new javax.swing.JRadioButton();
        jrNoSubti = new javax.swing.JRadioButton();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Proyeccion/Funcion");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Salas: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Peliculas:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Idioma:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Es 3D:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Es subtitulada:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Hora de Finalizacion:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Hora de Inicio:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Precio Lugar:");

        jcbSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSalasActionPerformed(evt);
            }
        });

        jtIdiomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtIdiomasActionPerformed(evt);
            }
        });

        jrbApto.setText("Apto para 3D");
        jrbApto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAptoActionPerformed(evt);
            }
        });

        jrSubtitulada.setText("Subtitulada");
        jrSubtitulada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrSubtituladaActionPerformed(evt);
            }
        });

        jsHoraInicio.setModel(new javax.swing.SpinnerDateModel());
        jsHoraInicio.setToolTipText("");
        jsHoraInicio.setEditor(new javax.swing.JSpinner.DateEditor(jsHoraInicio, " HH:mm"));

        jsHoraFin.setModel(new javax.swing.SpinnerDateModel());
        jsHoraFin.setEditor(new javax.swing.JSpinner.DateEditor(jsHoraFin, "HH:mm"));

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Id Proyeccion:");

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jtProyecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtProyecciones);

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbMostrar.setText("Mostrar");
        jbMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarActionPerformed(evt);
            }
        });

        jbHabilitar.setText("Habilitar");
        jbHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHabilitarActionPerformed(evt);
            }
        });

        jbInhabilitar.setText("Inhabilitar");
        jbInhabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInhabilitarActionPerformed(evt);
            }
        });

        jrNoApto.setText("No Apto para 3D");
        jrNoApto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrNoAptoActionPerformed(evt);
            }
        });

        jrNoSubti.setText("No Subtitulada");
        jrNoSubti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrNoSubtiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(429, 429, 429))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbGuardar)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jcbSalas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbPeliculas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtIdiomas)
                                .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jrbApto)
                                        .addComponent(jrSubtitulada))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jrNoSubti)
                                        .addComponent(jrNoApto))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jsHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jsHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbEliminar)
                                .addGap(55, 55, 55)
                                .addComponent(jbModificar)
                                .addGap(51, 51, 51)
                                .addComponent(jbHabilitar)
                                .addGap(41, 41, 41)
                                .addComponent(jbInhabilitar)))
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(434, 434, 434))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtIdiomas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jrbApto)
                    .addComponent(jrNoApto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jrSubtitulada)
                    .addComponent(jrNoSubti))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jsHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jsHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificar)
                    .addComponent(jbEliminar)
                    .addComponent(jbGuardar)
                    .addComponent(jbHabilitar)
                    .addComponent(jbBuscar)
                    .addComponent(jbInhabilitar))
                .addGap(26, 26, 26)
                .addComponent(jbMostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtIdiomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtIdiomasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtIdiomasActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        cargarProyeccion();
        limpiarCampos();
        mostraPro();
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
       String nro = jtId.getText();
        
        jtId.setEditable(true);
        
         if (nro.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Ingrese el Id de Sala que desee modificar");
        } else {
             
            elimarProy();
            limpiarCampos();
            
        }
         
         mostraPro();    
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jcbSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSalasActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jcbSalasActionPerformed

    private void jrbAptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAptoActionPerformed
        // TODO add your handling code here:
        if (jrbApto.isSelected()) {
            
            jrNoApto.setSelected(false);
        }
    }//GEN-LAST:event_jrbAptoActionPerformed

    private void jrSubtituladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrSubtituladaActionPerformed
        // TODO add your handling code here:
        if (jrSubtitulada.isSelected()) {
            
            jrNoSubti.setSelected(false);
        }
    }//GEN-LAST:event_jrSubtituladaActionPerformed

    private void jbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarActionPerformed
        // TODO add your handling code here:
        mostraPro();
    }//GEN-LAST:event_jbMostrarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
        buscarProye();
        limpiarCampos();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        
        dispose ();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jrNoSubtiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrNoSubtiActionPerformed
        // TODO add your handling code here:
        if (jrNoSubti.isSelected()) {
            
            jrSubtitulada.setSelected(false);
        }
    }//GEN-LAST:event_jrNoSubtiActionPerformed

    private void jrNoAptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrNoAptoActionPerformed
        // TODO add your handling code here:
        if (jrNoApto.isSelected()) {
            
            jrbApto.setSelected(false);
        }
    }//GEN-LAST:event_jrNoAptoActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        // TODO add your handling code here:
        
        
        String nro = jtId.getText();
        
        
         if (nro.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Ingrese el Id de Sala que desee modificar");
        } else {
             
            modificarProy();
            limpiarCampos();
        }
         
         mostraPro();   
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHabilitarActionPerformed
        // TODO add your handling code here:
        
        String nro = jtId.getText();
        
        
         if (nro.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Ingrese el Id de Sala que desee Habilitar");
        } else {
             
            darAlta();
            limpiarCampos();
        }
         
         mostraPro();  
    }//GEN-LAST:event_jbHabilitarActionPerformed

    private void jbInhabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInhabilitarActionPerformed
        // TODO add your handling code here:
        String nro = jtId.getText();
        
        
         if (nro.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Ingrese el Id de Sala que desee Inhabilitar");
        } else {
             
            darBaja();
            limpiarCampos();
        }
         
         mostraPro();
    }//GEN-LAST:event_jbInhabilitarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbHabilitar;
    private javax.swing.JButton jbInhabilitar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbMostrar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Object> jcbPeliculas;
    private javax.swing.JComboBox<Object> jcbSalas;
    private javax.swing.JRadioButton jrNoApto;
    private javax.swing.JRadioButton jrNoSubti;
    private javax.swing.JRadioButton jrSubtitulada;
    private javax.swing.JRadioButton jrbApto;
    private javax.swing.JSpinner jsHoraFin;
    private javax.swing.JSpinner jsHoraInicio;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtIdiomas;
    private javax.swing.JTextField jtPrecio;
    private javax.swing.JTable jtProyecciones;
    // End of variables declaration//GEN-END:variables

    private void cargarProyeccion(){
        
        Pelicula peliSele = (Pelicula) jcbPeliculas.getSelectedItem();
        Sala salaSele = (Sala) jcbSalas.getSelectedItem();
        
        Date horaInicio = (Date) jsHoraInicio.getValue();
        java.sql.Time horaI = new java.sql.Time(horaInicio.getTime());
        
        Date horaFin = (Date) jsHoraFin.getValue();
        java.sql.Time horaF = new java.sql.Time(horaFin.getTime());
        
        String idiomas = jtIdiomas.getText();
        
        boolean apto = false; 
        boolean sub = false;
        boolean estado= true;
        
        if (jrbApto.isSelected() == true) {
            
            apto = true;
        } else {
            
            if (jrNoApto.isSelected() == true) {
                
                apto = false;
            } else {
                
                JOptionPane.showMessageDialog(this, "Eliga una de las opciones");
            }
        }
        
        if (jrSubtitulada.isSelected() == true) {
            
            sub = true;
        } else {
            
            if (jrNoSubti.isSelected() == true) {
                
                sub = false;
            } else {
                
                JOptionPane.showMessageDialog(this, "Eliga una de las opciones");
            }
        }
        try{
            
            
            double precio = Double.parseDouble(jtPrecio.getText());    
            
            if (horaInicio == null || horaFin == null || idiomas.isEmpty() || precio == 0 || peliSele == null || salaSele == null ) {
                
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");

            } else {
                
                if (proyeD.existeProyeccionXH(salaSele.getIdSala(), horaI, horaF)) {
                    
                    JOptionPane.showMessageDialog(this, "Ya existe una proyeccion en ese horario en esta hora.");
                    
                } else {
                    Proyeccion proy = new Proyeccion( 0 ,peliSele, salaSele, idiomas, apto, sub, horaI, horaF, precio, estado);
                
                    proyeD.guardarProyeccion(proy, peliSele.getIdPelicula(), salaSele.getIdSala());
                
                    JOptionPane.showMessageDialog(this, "Proyeccion guardad exitosamente.");
                }
                
            }
        } catch (NumberFormatException x){
            
            JOptionPane.showMessageDialog(this, "Numero Invalido.");
        } 
    }
    
        private void buscarProye (){
        
        modelo.setRowCount(0);
        
        int id;
        String apto = ""; 
        String sub = "";
        String estado= "";
       
        try {
  
            id = Integer.parseInt(jtId.getText());
            
            if (proyeD.buscarProyeccion(id) != null) {
                
                Proyeccion pro = proyeD.buscarProyeccion(id);
            
                if (pro != null) {
                    
                    if (pro.isEs3D() == true) {
                        
                        apto = "Apta para 3D";
                    } else {
                
                        apto = "No es Apta para 3D";
                    }
                
                    if (pro.isSubtitulada() == true) {
                        
                        sub = "Subtitulada";
                    } else {
                
                        sub = "No esta Subtitulada";
                    }
                    
                    if(pro.isEstado() == true){
                        
                        estado = "Habilitado";
                    } else {
                        
                        estado = "Inhabilitado";
                    }
                
                    modelo.addRow(new Object []{
                    
                        pro.getIdProyeccion(),
                        pro.getSala().getNroSala(),
                        pro.getPelicula().getTitulo(),
                        sub,
                        apto,
                        pro.getIdioma(),
                        pro.getHoraInicio(),
                        pro.getHoraFin(),
                        pro.getPrecioLugar(),
                        estado
                    });
                }
            } else {
                
                JOptionPane.showMessageDialog(this, "No se encontro el ID indicado");
            }
        
        } catch (NumberFormatException e){
            
            JOptionPane.showMessageDialog(this, "El ID debe ser un numero entero.");
            return;
        }        
    }
    
    public void mostraPro(){
        
        List <Proyeccion> lista = proyeD.listarProyecciones();
        modelo.setRowCount(0);
        String apta, sub, estado;
        
        for (Proyeccion p: lista) {
            
            if (p.isEs3D() == true) {
                
                apta = "Apta para 3D";
            } else {
                
                apta = "No es Apta para 3D";
            }
            
            if (p.isSubtitulada() == true) {
                
                sub = "Subtitulada";
            } else {
                
                sub = "No esta Subtitulada";
            }
            
            if(p.isEstado() == true){
                        
                estado = "Habilitado";
            } else {
                        
                estado = "Inhabilitado";
            }
            
            modelo.addRow(new Object []{
                
               p.getIdProyeccion(),
                p.getSala().getNroSala(),
                p.getPelicula().getTitulo(),
                sub,
                apta,
                p.getIdioma(),
                p.getHoraInicio(),
                p.getHoraFin(),
                p.getPrecioLugar(),
                estado
            });
        }
    }
    
    private void elimarProy (){
         
        int id;
        
        try {
            
            id = Integer.parseInt(jtId.getText());
            
            if (proyeD.buscarProyeccion(id) != null) {
                
                int confirmar = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar la Proyeccion: " +jtId.getText() + "?" ,
                        " Confirmar el Borrado: ", JOptionPane.YES_NO_OPTION);
                
                if (confirmar == JOptionPane.YES_OPTION) {
                    
                    proyeD.borrarProyeccion(id);
                }          
            }
        } catch (NumberFormatException e){
            
            JOptionPane.showMessageDialog(this, "El ID debe ser un numero entero.");   
            return;
        }
    }
    
    private void modificarProy(){
        
        try{
            
            int id = Integer.parseInt(jtId.getText());
            
            Pelicula peli = (Pelicula) jcbPeliculas.getSelectedItem();
            Sala sala = (Sala) jcbSalas.getSelectedItem();

            String idiomas = jtIdiomas.getText().trim();
            
            boolean apto = false ; 
            boolean sub = false ;
            
            if (jrbApto.isSelected() == true) {
            
                apto = true;
            } else {
            
                if (jrNoApto.isSelected() == true) {
                
                    apto = false;
                } else {
                
                    JOptionPane.showMessageDialog(this, "Eliga una de las opciones");
                }
            }
            if (jrSubtitulada.isSelected() == true) {
            
                sub = true;
            } else {
            
                if (jrNoSubti.isSelected() == true) {
                
                    sub = false;
                } else {
                
                    JOptionPane.showMessageDialog(this, "Eliga una de las opciones");
                }
            }

            double precio = Double.parseDouble(jtPrecio.getText().trim());

            java.util.Date horaInicio = (java.util.Date) jsHoraInicio.getValue();
            java.util.Date horaFin = (java.util.Date) jsHoraFin.getValue();
        
            java.sql.Time sqlHoraI = new java.sql.Time(horaInicio.getTime());
            java.sql.Time sqlHoraF = new java.sql.Time(horaFin.getTime());
                   
            boolean estado = true;
            
            Proyeccion proy = proyeD.buscarProyeccion(id);
            
            if (proy == null) {
                
                JOptionPane.showMessageDialog(this, "No se encontro una proyeccion con ese ID");
                return;
            } else {
            proy.setPelicula(peli);
            proy.setSala(sala);
            proy.setIdioma(idiomas);
            proy.setEs3D(apto);
            proy.setSubtitulada(sub);
            proy.setHoraInicio(sqlHoraI);
            proy.setHoraFin(sqlHoraF);
            proy.setPrecioLugar(precio);
            
            proyeD.actualizarProyeccion(proy);

            }
            
        } catch (NumberFormatException x){
            
            JOptionPane.showMessageDialog(this, "Verifique que todos los campos sean Validos.");
        } catch (Exception x){
            
            JOptionPane.showMessageDialog(this, "Error Inesperado: " + x.getMessage());
        }
    }
    
    private void darAlta (){
        
        try {
            
            int id = Integer.parseInt(jtId.getText());
            
            if (proyeD.buscarProyeccion(id) != null) {
                
                proyeD.darDeAlta(id);
            } else {
                
                JOptionPane.showMessageDialog(this, "No se encontro el ID indicado");
            }
        } catch (NumberFormatException e){
            
            JOptionPane.showMessageDialog(this, "El ID debe ser un numero entero");
        }
    }
    
    private void darBaja (){
        
        try{
            
            int id = Integer.parseInt(jtId.getText());
            
            if (proyeD.buscarProyeccion(id) != null) {
                
                proyeD.darDeBaja(id);
            } else {
                
                JOptionPane.showMessageDialog(this, "No se encontro el ID indicado.");
            }
            
            
        } catch (NumberFormatException e){
            
            JOptionPane.showMessageDialog(this, "El ID debe ser un numero entero.");
        }
    }
    
    //------------Visuales------------
    
    private void cargarCombosP(){
        jcbPeliculas.removeAllItems();
        PeliculaData peliD = new PeliculaData();

        
        for (Pelicula p: peliD.listarPeliculas()) {
            
            if (p.isEnCartelera() == true) {
                
                jcbPeliculas.addItem(p);
            }
        }
    }
    
     private void cargarCombosS(){
        jcbSalas.removeAllItems();
        SalaData salaD = new SalaData ();
        
        for (Sala s: salaD.listarSala()) {
            
            if (!s.getEstado().equalsIgnoreCase("Inhabilitado")) {
                
                jcbSalas.addItem(s);

            }
        }
    }
    private void cabecera(){
        
        modelo.addColumn("Id Proyecciones");
        modelo.addColumn("Nro Salas");
        modelo.addColumn("Pelicula");
        modelo.addColumn("Subtitulada");
        modelo.addColumn("Apta 3D");
        modelo.addColumn("Idioma");
        modelo.addColumn("Hora de Inicio");
        modelo.addColumn("Hora de Finalizacion");
        modelo.addColumn("Precio");
        modelo.addColumn("Estado");
        
        jtProyecciones.setModel(modelo);
    }
    
     private void limpiarCampos(){
         
            jcbPeliculas.setSelectedIndex(-1);
            jcbSalas.setSelectedIndex(-1);
         
            jsHoraInicio.setValue(new java.util.Date());
            jsHoraFin.setValue(new java.util.Date());
            
            jrSubtitulada.setSelected(false);
            jrbApto.setSelected(false);
            
            jrNoSubti.setSelected(false);
            jrNoApto.setSelected(false);
            
            jtId.setText("");
            jtPrecio.setText("");
            jtIdiomas.setText("");
     }
     
     private void configurarColores (){
        
        jtProyecciones.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            
            @Override
        
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
                    
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    
                    String estado = table.getValueAt(row, 9).toString();
                    
                    if (estado.equalsIgnoreCase("Habilitado")) {
                        c.setBackground(new Color(144, 238, 144));                   
                    
                    } else {
                        
                        if (estado.equalsIgnoreCase("Inhabilitado")) {
                            
                            c.setBackground(new Color(255, 102, 102));
                        } else {
                            
                            c.setBackground(Color.WHITE);
                        }
                    }
                    
                    if (isSelected) {
                    
                        c.setBackground(new Color (135, 206, 250));
                    }
                
            
            return c;
                }
        });
    }
}
