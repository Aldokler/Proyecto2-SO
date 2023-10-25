/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.MMU;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Aldokler
 */
public class Simulacion extends javax.swing.JFrame {

    /**
     * Creates new form rfera
     */
    public Simulacion() {
        initComponents();
    }
    private static Timer timer;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OptRamTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        OtherRamTable = new javax.swing.JTable();
        labelOtherRam = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        OptMMUTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        OtherMMUTable = new javax.swing.JTable();
        labelOtherMMU = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        OptStats = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        labelOtherStats = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        OtherStats = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setEnabled(false);

        OptRamTable.setBackground(new java.awt.Color(230, 230, 230));
        OptRamTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        OptRamTable.setForeground(new java.awt.Color(230, 230, 230));
        OptRamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OptRamTable.setAutoscrolls(false);
        OptRamTable.setEnabled(false);
        OptRamTable.setFocusable(false);
        OptRamTable.setSelectionBackground(new java.awt.Color(187, 187, 187));
        OptRamTable.setShowGrid(true);
        jScrollPane1.setViewportView(OptRamTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("MMU - Óptimo");

        jScrollPane2.setEnabled(false);

        OtherRamTable.setBackground(new java.awt.Color(230, 230, 230));
        OtherRamTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        OtherRamTable.setForeground(new java.awt.Color(230, 230, 230));
        OtherRamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OtherRamTable.setAutoscrolls(false);
        OtherRamTable.setEnabled(false);
        OtherRamTable.setFocusable(false);
        OtherRamTable.setSelectionBackground(new java.awt.Color(187, 187, 187));
        OtherRamTable.setShowGrid(true);
        jScrollPane2.setViewportView(OtherRamTable);

        labelOtherRam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelOtherRam.setText("RAM - Otro");

        jScrollPane4.setEnabled(false);

        OptMMUTable.setBackground(new java.awt.Color(230, 230, 230));
        OptMMUTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        OptMMUTable.setForeground(new java.awt.Color(230, 230, 230));
        OptMMUTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PAGE ID", "PID", "Loaded", "L-ADDR", "M-ADDR", "D-ADDR", "TIME", "MARK"
            }
        ));
        OptMMUTable.setAutoscrolls(false);
        OptMMUTable.setSelectionBackground(new java.awt.Color(187, 187, 187));
        OptMMUTable.setShowGrid(true);
        jScrollPane4.setViewportView(OptMMUTable);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("RAM - Óptimo");

        jScrollPane5.setEnabled(false);

        OtherMMUTable.setBackground(new java.awt.Color(230, 230, 230));
        OtherMMUTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        OtherMMUTable.setForeground(new java.awt.Color(230, 230, 230));
        OtherMMUTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PAGE ID", "PID", "Loaded", "L-ADDR", "M-ADDR", "D-ADDR", "TIME", "MARK"
            }
        ));
        OtherMMUTable.setAutoscrolls(false);
        OtherMMUTable.setSelectionBackground(new java.awt.Color(187, 187, 187));
        OtherMMUTable.setShowGrid(true);
        jScrollPane5.setViewportView(OtherMMUTable);

        labelOtherMMU.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelOtherMMU.setText("MMU - Otro");

        OptStats.setBackground(new java.awt.Color(230, 230, 230));
        OptStats.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        OptStats.setForeground(new java.awt.Color(230, 230, 230));
        OptStats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Procesos", "Operaciones", "Tiempo", "RAM KB", "RAM %", "V-RAM KB", "V-RAM %", "Págs en uso", "Págs libres", "Thrashing s", "Thrashing %", "Fragmentación"
            }
        ));
        OptStats.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        OptStats.setAutoscrolls(false);
        OptStats.setSelectionBackground(new java.awt.Color(187, 187, 187));
        OptStats.setShowGrid(true);
        OptStats.getTableHeader().setResizingAllowed(false);
        OptStats.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(OptStats);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Estadísticas - Óptimo");

        labelOtherStats.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelOtherStats.setText("Estadísticas - Otro");

        jScrollPane7.setEnabled(false);

        OtherStats.setBackground(new java.awt.Color(230, 230, 230));
        OtherStats.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        OtherStats.setForeground(new java.awt.Color(230, 230, 230));
        OtherStats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Procesos", "Operaciones", "Tiempo", "RAM KB", "RAM %", "V-RAM KB", "V-RAM %", "Págs en uso", "Págs libres", "Thrashing s", "Thrashing %", "Fragmentación"
            }
        ));
        OtherStats.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        OtherStats.setAutoscrolls(false);
        OtherStats.setSelectionBackground(new java.awt.Color(187, 187, 187));
        OtherStats.setShowGrid(true);
        OtherStats.getTableHeader().setResizingAllowed(false);
        OtherStats.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(OtherStats);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelOtherRam)
                .addGap(217, 217, 217))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelOtherMMU)
                .addGap(210, 210, 210))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelOtherStats)
                .addGap(186, 186, 186))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOtherRam)
                    .addComponent(jLabel3))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelOtherMMU))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(labelOtherStats))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //cambia el color de una celda OwO
    //ram.setDefaultRenderer(Object.class, new CustomCellRenderer(row, column));
    static class CustomCellRenderer extends DefaultTableCellRenderer {
        
        private int row, column;
        private Color rgb;

        public CustomCellRenderer(int row, int column, Color rgb) {
            this.row = row;
            this.column = column;
            this.rgb = rgb;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public void setRGB(Color rgb) {
            this.rgb = rgb;
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            // Cambiar el color de fondo de la celda en la fila y columna objetivo
            if (this.row == row && this.column == column) {
                cellComponent.setBackground(this.rgb); ///Modificar esta linea para que sea el color del proceso con variables globales
            } else {
                // Restaurar el color de fondo predeterminado para otras celdas
                cellComponent.setBackground(table.getBackground());
            }

            return cellComponent;
        }
    }
    
    /**
     * @param args the command line arguments
     * @param algoritmo
     * @param programa
     */
    public static void main(String args[], int algoritmo, ArrayList<Integer[]> programa) {
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
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MMU OptMMU = new MMU();
                MMU OtherMMU = new MMU();
        
                Simulacion instance = new Simulacion();
                instance.setVisible(true);
                instance.changeLabel(algoritmo);
                
                CustomCellRenderer OptRenderer = new CustomCellRenderer(0, 0, new Color(0,0,0));
                CustomCellRenderer OtherRenderer = new CustomCellRenderer(0, 0, new Color(0,0,0));

                /*
                <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

                INSERTAR ALGORITMO Y LÓGICA DEL MAIN en el timer, todavía no lo defino

                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                 */
                
                // Configuración del temporizador para actualizar la interfaz a un ritmo de 70bpm
                timer = new Timer(857, new ActionListener() {
                    int page = 0;
                    Color pageColor = new Color(123, 43, 212);
                    int i = 0;
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Actualizar la interfaz gráfica dentro del hilo de eventos de Swing
                        EventQueue.invokeLater(() -> {
                            if ( i >= programa.size()){
                                System.out.println("Simulación terminada");
                                timer.stop();
                            }
                            
                            int instruction = programa.get(i)[0];
                            int param = programa.get(i)[1];
                            int size = 0;
                            if (instruction == 1){
                                size = programa.get(i)[2];
                            }
                            
                            switch (instruction){
                                case 1 -> {
                                    OptMMU.New(param, size);
                                    OtherMMU.New(param, size);
                                }
                                case 2 -> {
                                    OptMMU.use(param);
                                    OtherMMU.use(param);
                                }
                                case 3 -> {
                                    OptMMU.delete(param);
                                    OtherMMU.delete(param);
                                }
                                case 4 -> {
                                    OptMMU.kill(param);
                                    OtherMMU.kill(param);
                                }
                            }
                            
                            
                            OptRenderer.setRow(page/20);
                            OptRenderer.setColumn(page%20);
                            OptRenderer.setRGB(pageColor);
                            instance.OptRamTable.getColumnModel().getColumn(page%20).setCellRenderer(OptRenderer);
                            ((AbstractTableModel) instance.OptRamTable.getModel()).fireTableCellUpdated(page/20, page%20);
                            
                            OtherRenderer.setRow(page/20);
                            OtherRenderer.setColumn(page%20);
                            OtherRenderer.setRGB(pageColor);
                            instance.OtherRamTable.getColumnModel().getColumn(page%20).setCellRenderer(OtherRenderer);
                            ((AbstractTableModel) instance.OtherRamTable.getModel()).fireTableCellUpdated(page/20, page%20);
                            
                            
                            //// Cambio momentaneo a paginas en Ram, arreglar luego
                            for (int j = 0; j < instance.OptMMU.getRam().length; j++){

                            }
                            for (int j = 0; j < instance.OtherMMU.getRam().length; j++){

                            }
                            
                            i++;
                            page++; //quiten esto
                        });
                    }
                });
                
                timer.start();
            }
        });
        
        /*
        for (Integer[] number : programa){
            System.out.println(Arrays.toString(number));
        }
        */
    }

    private void changeLabel(int algoritmo){
        String text = "Otro";
        switch(algoritmo){
            case 1 -> {
                text = "FIFO";
            }
            case 2 -> {
                text = "Second Chance";
            }
            case 3 -> {
                text = "MRU";
            }
            case 4 -> {
                text = "Random";
            }
        }
        labelOtherMMU.setText("MMU - "+text);
        labelOtherRam.setText("RAM - "+text);
        labelOtherStats.setText("Estadísticas - "+text);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable OptMMUTable;
    private javax.swing.JTable OptRamTable;
    private javax.swing.JTable OptStats;
    private javax.swing.JTable OtherMMUTable;
    private javax.swing.JTable OtherRamTable;
    private javax.swing.JTable OtherStats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel labelOtherMMU;
    private javax.swing.JLabel labelOtherRam;
    private javax.swing.JLabel labelOtherStats;
    // End of variables declaration//GEN-END:variables

    private MMU OptMMU, OtherMMU;
    
}
