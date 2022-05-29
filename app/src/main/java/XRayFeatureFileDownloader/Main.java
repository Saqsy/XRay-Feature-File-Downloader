/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package XRayFeatureFileDownloader;

import components.TaskExecutor;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static components.ExcelProcessor.fetchDataFromExcel;

/**
 * @author Saqsy
 */
public class Main extends javax.swing.JFrame {

    // custom variables
    public static ArrayList<String> testCases = new ArrayList<>();

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        excelFileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        inputTypeComboBox = new javax.swing.JComboBox<>();
        chooseExcel = new javax.swing.JButton();
        testCaseIdsTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        downloadButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        threadNumberComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("XRay Feature File Downloader");

        jLabel2.setText("This utility will help you download feature files uploaded in your JIRA project");

        jLabel3.setText("Select Input type:");

        inputTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enter Test Case IDs", "Use Excel" }));
        inputTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inputTypeComboBoxItemStateChanged(evt);
            }
        });

        chooseExcel.setText("Choose Excel");
        chooseExcel.setEnabled(false);
        chooseExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseExcelActionPerformed(evt);
            }
        });

        jLabel4.setText("Enter Test IDs\n(Comma Separated)");

        downloadButton.setText("Download");
        downloadButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        downloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Select Threads");

        threadNumberComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "4", "6", "8" }));

        jLabel6.setText("For Multi-Threading");

        jLabel7.setText("or");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(threadNumberComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputTypeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 249, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(testCaseIdsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooseExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(downloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(456, 456, 456))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(threadNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(jLabel5))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(testCaseIdsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseExcel)
                    .addComponent(jLabel7))
                .addGap(58, 58, 58)
                .addComponent(downloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void inputTypeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inputTypeComboBoxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if (evt.getItem().toString().equalsIgnoreCase("Use Excel")){
                chooseExcel.setEnabled(true);
                testCaseIdsTextField.setText("");
                testCaseIdsTextField.setEnabled(false);
            } else if (evt.getItem().toString().equalsIgnoreCase("Enter Test Case IDs")){
                chooseExcel.setEnabled(false);
                testCaseIdsTextField.setText("");
                testCaseIdsTextField.setEnabled(true);
            }
        }
    }//GEN-LAST:event_inputTypeComboBoxItemStateChanged

    private void chooseExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseExcelActionPerformed
        FileFilter filter;
        filter = new FileNameExtensionFilter("Excel File", "xlsx");
        excelFileChooser.addChoosableFileFilter(filter);
        excelFileChooser.setFileFilter(filter);
        int r = excelFileChooser.showSaveDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            testCases.clear();
            testCases = fetchDataFromExcel(excelFileChooser.getSelectedFile());
        } else {
            JOptionPane.showMessageDialog(null,"No file selected, try again");
        }
    }//GEN-LAST:event_chooseExcelActionPerformed

    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadButtonActionPerformed

        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Void doInBackground() {
                if (!chooseExcel.isEnabled() && !testCaseIdsTextField.getText().isEmpty()){
                    List<String> testCases = Arrays.asList(testCaseIdsTextField.getText().trim().split(","));
                    TaskExecutor taskExecutor = new TaskExecutor(Integer.parseInt(threadNumberComboBox.getSelectedItem().toString()));
                    taskExecutor.executeDownloadAndProcessingTask(testCases);
                } else {
                    if (!testCases.isEmpty()){
                        TaskExecutor taskExecutor = new TaskExecutor(Integer.parseInt(threadNumberComboBox.getSelectedItem().toString()));
                        taskExecutor.executeDownloadAndProcessingTask(testCases);
                    } else {
                        JOptionPane.showMessageDialog(null,"Could not fetch test cases from excel, try again");
                    }
                }
                return null;
            }
        };
        swingWorker.execute();
    }//GEN-LAST:event_downloadButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseExcel;
    private javax.swing.JButton downloadButton;
    private javax.swing.JFileChooser excelFileChooser;
    private javax.swing.JComboBox<String> inputTypeComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField testCaseIdsTextField;
    private javax.swing.JComboBox<String> threadNumberComboBox;
    // End of variables declaration//GEN-END:variables
}
