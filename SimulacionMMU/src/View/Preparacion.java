/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Logic.AdminArchivos;
import Logic.seedSingleton;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Aldokler
 * 
 * Imagen de la ram tomada de <a href="https://www.flaticon.es/iconos-gratis/memoria-ram" title="memoria ram iconos">Memoria ram iconos creados por Freepik - Flaticon</a>
 * 
 */
public class Preparacion extends javax.swing.JFrame {

    /**
     * Creates new form Preparacion
     */
    public Preparacion() {
        initComponents();
        
    }
    
    private static String[] args;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        StartSimulationButton = new javax.swing.JButton();
        algorithmInput = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        fileInput = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NoperationsInput = new javax.swing.JTextField();
        PprocessInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        seedInput = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setSize(new java.awt.Dimension(1000, 650));

        StartSimulationButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        StartSimulationButton.setText("Iniciar Simulación!!!");
        StartSimulationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartSimulationButtonActionPerformed(evt);
            }
        });

        algorithmInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        algorithmInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Algoritmo>", "FIFO", "Second Chance", "MRU", "Random" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Algoritmo a usar");

        fileInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fileInput.setText("Seleccionar Archivo");
        fileInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileInputActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Secuencia de instrucciones");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Operaciones");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Procesos");

        NoperationsInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NoperationsInput.setText("500");

        PprocessInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PprocessInput.setText("10");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/memoria-ram.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Semilla");

        seedInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        seedInput.setModel(new javax.swing.SpinnerNumberModel());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(StartSimulationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(297, 297, 297))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(58, 58, 58))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(68, 68, 68))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(seedInput, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel2)
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel3)
                                        .addGap(50, 50, 50))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(algorithmInput, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(fileInput)
                                        .addGap(46, 46, 46)
                                        .addComponent(NoperationsInput, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PprocessInput, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4)))
                        .addGap(84, 84, 84))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileInput)
                    .addComponent(NoperationsInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PprocessInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(algorithmInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seedInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(StartSimulationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartSimulationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartSimulationButtonActionPerformed
        
        if (algorithmInput.getSelectedIndex() == 0){
            JOptionPane.showConfirmDialog(rootPane, "Seleccione un algoritmo", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int procesos, operaciones, seed;
        if (archivo == null){
            if(PprocessInput.getText() == null){
                PprocessInput.setText("10");
            }
            if(NoperationsInput.getText() == null){
                NoperationsInput.setText("500");
            }
            if(seedInput.getValue() == null){
                seedInput.setValue(0);
            }
            try{
                procesos = Integer.parseInt(PprocessInput.getText());
                if (procesos <= 0){
                    procesos = 10;
                }
                operaciones = Integer.parseInt(NoperationsInput.getText());
                if (operaciones <= 0){
                    operaciones = 500;
                }
                seed = (int) seedInput.getValue();
                seedSingleton.getInstance().setSeed(seed);
            } catch (NumberFormatException e) {
                JOptionPane.showConfirmDialog(rootPane, "Ingrese un número válido", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                AdminArchivos.generateProgram(procesos, operaciones, "programa");
                archivo = "programa.txt";
            } catch (IOException ex) {
                Logger.getLogger(Preparacion.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
        
        /*
        int download = JOptionPane.showConfirmDialog(rootPane, "Desea descargar el archivo generado?", "Descargar secuencia de instrucciones", JOptionPane.YES_NO_OPTION);
        
        if (download == JOptionPane.YES_OPTION) {
            //guardar archivo
        }*/
        
        this.setVisible(false);
        this.setEnabled(false);
        
        ArrayList<Integer[]> instrucciones = null;
        try {
            instrucciones = AdminArchivos.readProgram(archivo);
        } catch (IOException ex) {
            Logger.getLogger(Preparacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (instrucciones == null || instrucciones.size() <= 0){
            JOptionPane.showConfirmDialog(rootPane, "Unable to read the program :(", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Simulacion.main(args, algorithmInput.getSelectedIndex(), instrucciones);
    }//GEN-LAST:event_StartSimulationButtonActionPerformed

    private void fileInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileInputActionPerformed
        JFileChooser archivo = new JFileChooser();
        int result = archivo.showOpenDialog(rootPane);

        // Comprobar si el usuario seleccionó un archivo
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File selectedFile = archivo.getSelectedFile();
            
            // Aquí puedes realizar acciones con el archivo seleccionado
            // En este ejemplo, simplemente mostramos la ruta del archivo
            JOptionPane.showMessageDialog(rootPane,
                    "Archivo seleccionado: " + selectedFile.getAbsolutePath());
            
            this.archivo = selectedFile.getAbsolutePath();
            fileInput.setText(selectedFile.getName());
        }
    }//GEN-LAST:event_fileInputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Preparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Preparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Preparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Preparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Preparacion().setVisible(true);
            }
        });
        
        Preparacion.args = args;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NoperationsInput;
    private javax.swing.JTextField PprocessInput;
    private javax.swing.JButton StartSimulationButton;
    private javax.swing.JComboBox<String> algorithmInput;
    private javax.swing.JButton fileInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner seedInput;
    // End of variables declaration//GEN-END:variables

    private String archivo = null;
    
}
