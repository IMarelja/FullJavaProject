/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.view.model;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author windsten
 */

public class ProgressDialog extends JDialog {
    private JProgressBar progressBar;
    private JLabel statusLabel;
    private int totalSteps;
    private int currentStep;
    
    public ProgressDialog(JFrame parent, String title, int totalSteps) {
        super(parent, title, true);
        this.totalSteps = totalSteps;
        this.currentStep = 0;
        
        initializeComponents();
        setupLayout();
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(parent);
    }
    
    private void initializeComponents() {
        progressBar = new JProgressBar(0, totalSteps);
        progressBar.setStringPainted(true);
        progressBar.setString("0%");
        
        statusLabel = new JLabel("Initializing...");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        
        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        contentPanel.add(statusLabel, BorderLayout.NORTH);
        contentPanel.add(progressBar, BorderLayout.CENTER);
        
        add(contentPanel, BorderLayout.CENTER);
    }
    
    public void updateProgress(String status) {
        try{
            Thread.sleep(200);
            SwingUtilities.invokeLater(() -> {
            currentStep++;
            statusLabel.setText(status);
            progressBar.setValue(currentStep);
            int percentage = (int) ((double) currentStep / totalSteps * 100);
            progressBar.setString(percentage + "%");
        });
        }catch(Exception ex){
            ex.printStackTrace();
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, 
                        "An unexpected error occurred!\n" + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                });
        }
    }
    
    public void closeDialog() {
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }
    
    public void openDialog() {
        SwingUtilities.invokeLater(() -> {
            setVisible(true);
        });
    }
}
