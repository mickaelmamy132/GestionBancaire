/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gestion_bancaire2;

import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mickael
 */
public class TablePrete extends javax.swing.JInternalFrame {

    /**
     * Creates new form TablePrete
     */
    Connection conn;
    PreparedStatement st;
    PreparedStatement preparer;
    ResultSet resultat;
    public TablePrete() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        voir_liste_pret();
        JComboBox();
    }
    public void JComboBox()
    {
        
 
        try
        {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
           preparer = conn.prepareStatement("SELECT numCompte FROM CLIENT");
           resultat = preparer.executeQuery();
            while (resultat.next()) 
            {
              String numCompte = resultat.getString("numCompte");
              modifCompt.addItem(numCompte);
            }
        } 
        catch (SQLException e) 
        {
                e.printStackTrace();
        }
}

    public void voir_liste_pret()
    {
         int Compter;
         try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
            st = conn.prepareStatement("SELECT CLIENT.NOM,CLIENT.PRENOM,PRETER.num_pret,PRETER.num_compte,PRETER.montant_preté,PRETER.datepret FROM PRETER join client on CLIENT.numCompte = PRETER.num_compte ORDER BY num_pret DESC");
            resultat = st.executeQuery();
            
            ResultSetMetaData RSMD = resultat.getMetaData();
            Compter = RSMD.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) Table_Pret.getModel();
            dft.setRowCount(0);
            
            while (resultat.next())
            {
                Vector v2 = new Vector();
                
                for (int i = 1 ; i<= Compter; i++)
                {
                    String nom = resultat.getString("CLIENT.NOM");
                    String prenom = resultat.getString("CLIENT.PRENOM");
                    String nomComplet = nom+" "+prenom;
                    
                    v2.add(resultat.getString("PRETER.num_pret"));
                    v2.add(resultat.getString("PRETER.num_compte"));
                    v2.add(nomComplet);
                    v2.add(resultat.getString("PRETER.montant_preté"));
                    v2.add(resultat.getString("PRETER.datepret"));
                }
                dft.addRow(v2);
            }
            
        }
        catch(SQLException e)
        {
            //System.out.println("erreur");
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AjoutP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Pret = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        modifPret = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        datePret = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Modife = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        annuler = new javax.swing.JButton();
        modifCompt = new javax.swing.JComboBox<>();

        setFocusable(false);

        AjoutP.setText("faire une Prêt");
        AjoutP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutPActionPerformed(evt);
            }
        });

        Table_Pret.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "num_pret", "num_compte", "nom et prenom", "montant", "date"
            }
        ));
        Table_Pret.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_PretMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Pret);

        jLabel1.setText("montant_preté");

        jLabel3.setText("datepret");

        jLabel4.setText("num_Compte");

        Modife.setBackground(new java.awt.Color(0, 0, 0));
        Modife.setForeground(new java.awt.Color(255, 255, 255));
        Modife.setText("MODIFIER");
        Modife.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifeActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("EFFACER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        annuler.setBackground(new java.awt.Color(0, 0, 0));
        annuler.setForeground(new java.awt.Color(255, 255, 255));
        annuler.setText("ANNULER");
        annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerActionPerformed(evt);
            }
        });

        modifCompt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AjoutP)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(31, 31, 31)
                                .addComponent(modifCompt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modifPret, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datePret, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(Modife)
                        .addGap(55, 55, 55)
                        .addComponent(jButton2)
                        .addGap(52, 52, 52)
                        .addComponent(annuler)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AjoutP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(modifPret, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(datePret, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifCompt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Modife)
                    .addComponent(jButton2)
                    .addComponent(annuler))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AjoutPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutPActionPerformed
        // TODO add your handling code here:
        AjoutPrete prete = new AjoutPrete(new javax.swing.JFrame(), true);
        prete.setVisible(true);
    }//GEN-LAST:event_AjoutPActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try
        {
            DefaultTableModel model = (DefaultTableModel) Table_Pret.getModel();
            int selectedIndex = Table_Pret.getSelectedRow();
            
            int num = Integer.parseInt(model.getValueAt(selectedIndex,0).toString());
        
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
            st = conn.prepareStatement("DELETE FROM PRETER WHERE num_pret=?");
            st.setInt(1, num);
            int row = st.executeUpdate();
            JOptionPane.showMessageDialog(null,"suppression effectuer");
            
            modifCompt.setSelectedIndex(0);
            modifPret.setText("");
            datePret.setText("");
            
            voir_liste_pret();
                  
        }
        catch(SQLException e)
        {
            //System.out.println("erreur");
            e.printStackTrace();
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Table_PretMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_PretMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) Table_Pret.getModel();
        int selectedIndex = Table_Pret.getSelectedRow();
        int num = Integer.parseInt(model.getValueAt(selectedIndex,0).toString());
        String num1 = (model.getValueAt(selectedIndex,1).toString());
        Float num2 = Float.parseFloat(model.getValueAt(selectedIndex,3).toString());
        
        //modifCompt.setText(model.getValueAt(selectedIndex,1).toString());
        modifCompt.setSelectedItem(model.getValueAt(selectedIndex,1).toString());
        modifPret.setText(model.getValueAt(selectedIndex,3).toString());
        datePret.setText(model.getValueAt(selectedIndex,4).toString());
        
        
    }//GEN-LAST:event_Table_PretMouseClicked

    private void ModifeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifeActionPerformed
        // TODO add your handling code here:
         try
        {
            DefaultTableModel model = (DefaultTableModel) Table_Pret.getModel();
            int selectedIndex = Table_Pret.getSelectedRow();
            
           int num = Integer.parseInt(model.getValueAt(selectedIndex,0).toString());
           String num1 = (model.getValueAt(selectedIndex,1).toString());
           Float num2 = Float.parseFloat(model.getValueAt(selectedIndex,3).toString());
        
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
            st = conn.prepareStatement("UPDATE PRETER SET num_compte=?,montant_preté=?,datepret=? WHERE num_pret=?");
            
            st.setString(1,modifCompt.getSelectedItem().toString());
            st.setFloat(2,Float.parseFloat(modifPret.getText()));
            st.setString(3,datePret.getText());
            st.setInt(4, num);
            int row = st.executeUpdate();
            JOptionPane.showMessageDialog(null,"modification valider");
            
            modifCompt.setSelectedIndex(0);
            modifPret.setText("");
            datePret.setText("");
            
            voir_liste_pret();
        }
        catch(SQLException e)
        {
            //System.out.println("erreur");
            e.printStackTrace();
        }         
    }//GEN-LAST:event_ModifeActionPerformed

    private void annulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerActionPerformed
        // TODO add your handling code here:
        modifCompt.setSelectedIndex(0);
        modifPret.setText("");
        datePret.setText("");
    }//GEN-LAST:event_annulerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AjoutP;
    private javax.swing.JButton Modife;
    private javax.swing.JTable Table_Pret;
    private javax.swing.JButton annuler;
    private javax.swing.JTextField datePret;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> modifCompt;
    private javax.swing.JTextField modifPret;
    // End of variables declaration//GEN-END:variables
}
