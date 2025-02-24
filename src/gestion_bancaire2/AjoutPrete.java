/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gestion_bancaire2;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.mail.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author mickael
 */
public class AjoutPrete extends javax.swing.JDialog {

    /**
     * Creates new form AjoutPrete
     */
    Connection conn;
    PreparedStatement preparer;
    PreparedStatement email;
    PreparedStatement date;
    PreparedStatement reste;
    PreparedStatement client;
    ResultSet resultat;
    
    
    public AjoutPrete(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        deroulante_client();
        
    }

    
     public AjoutPrete() {}

     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        MontPret = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AjoutPret = new javax.swing.JButton();
        retour = new javax.swing.JButton();
        numCompt = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        DatePret = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("AJOUTE UN PRET");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        MontPret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MontPretActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("N° Client");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Montant de prêt");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("Date");

        AjoutPret.setBackground(new java.awt.Color(0, 0, 0));
        AjoutPret.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AjoutPret.setForeground(new java.awt.Color(255, 255, 255));
        AjoutPret.setText("Ajouter");
        AjoutPret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutPretActionPerformed(evt);
            }
        });

        retour.setBackground(new java.awt.Color(0, 0, 0));
        retour.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        retour.setForeground(new java.awt.Color(255, 255, 255));
        retour.setText("Retour");
        retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourActionPerformed(evt);
            }
        });

        numCompt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisissez un numero" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Ar");

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("AJOUTE UN PRET");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(73, 73, 73))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DatePret, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MontPret, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numCompt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(75, 75, 75))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(AjoutPret)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(retour)
                .addGap(120, 120, 120))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numCompt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MontPret, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(DatePret, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retour)
                    .addComponent(AjoutPret))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourActionPerformed
        // TODO add your handling code here:
        if (evt.getSource()== this.retour)
        {
            this.dispose();
            TablePrete clt = new TablePrete();
            clt.voir_liste_pret();
        }
    }//GEN-LAST:event_retourActionPerformed
    
    public void deroulante_client()
    {
         // Obtenir la date actuelle
        java.util.Date currentDate = new java.util.Date();

       
        // Créer un format de date souhaité
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        // Formater la date en une chaîne de caractères
        String formattedDate = dateFormat.format(currentDate);

        // Afficher la date dans le champ de texte
        DatePret.setText(formattedDate);
 
        try
        {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
           preparer = conn.prepareStatement("SELECT * FROM CLIENT");
           resultat = preparer.executeQuery();
            while (resultat.next()) 
            {
              String numCompte = resultat.getString("numCompte");
              numCompt.addItem(numCompte);
            }
        } 
        catch (SQLException e) 
        {
                e.printStackTrace();
        }
        
    }
    
    private void AjoutPretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutPretActionPerformed
        // TODO add your handling code here:
        try
        {
         
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
            preparer = conn.prepareStatement("INSERT INTO PRETER (num_compte, montant_preté, datepret) values(?,?,?)");
            preparer.setString(1,numCompt.getSelectedItem().toString());
            preparer.setFloat(2,Float.parseFloat(MontPret.getText()));
            preparer.setString(3,DatePret.getText() );
            int rowt = preparer.executeUpdate();
            
            // Récupération du montant du client
            client = conn.prepareStatement("SELECT SOLDET FROM CLIENT WHERE numCompte = ?");
            client.setString(1, numCompt.getSelectedItem().toString());
            resultat = client.executeQuery();
            int SoldeClient = 0;
            while (resultat.next()) 
            {
                 SoldeClient = resultat.getInt("SOLDET");
            } 
            
            
             //debut du transaction
            //modification du solde client
            conn.setAutoCommit(false);
            
            client = conn.prepareStatement("UPDATE CLIENT SET SOLDET = SOLDET + ? WHERE numCompte = ?");
            client.setFloat(1, Float.parseFloat(MontPret.getText()));
            client.setString(2,numCompt.getSelectedItem().toString());
            client.executeUpdate();
            
            conn.commit();
            
            String situation= ("pas encore payer");
            float montant = Float.parseFloat(MontPret.getText());
            float beneficeBanque = (float) (montant*0.1);
            float Total = montant + beneficeBanque;
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
            preparer = conn.prepareStatement("INSERT INTO RENDRE (num_pret,situation,rest_payé,date_rendu) values(?,?,?,?)"); 
            preparer.setString(1,numCompt.getSelectedItem().toString());
            //preparer.setString(2,deroulante2.getSelectedItem().toString());
            preparer.setString(2,situation);
            preparer.setFloat(3,Total);
            preparer.setString(4,DatePret.getText());
            int valide = preparer.executeUpdate();
            
            // Validation de la transaction
            
            
            SoldeClient += Float.parseFloat(MontPret.getText());
            
            JOptionPane.showMessageDialog(null,"pret ajoutér");
            
            TablePrete clt = new TablePrete();
            clt.voir_liste_pret();
            
            envoi_Email();
            
       
            
            numCompt.setSelectedIndex(0);
            MontPret.setText("");
            DatePret.setText("");
       
           
        }
        catch(SQLException e)
        {
            //System.out.println("erreur");
            e.printStackTrace();
        }
    }//GEN-LAST:event_AjoutPretActionPerformed

    private void MontPretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MontPretActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MontPretActionPerformed
    public void envoi_Email() throws SQLException 
    {
        // date du pret
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
        date = conn.prepareStatement("SELECT * FROM PRETER ORDER BY num_pret DESC LIMIT 1");
        resultat = date.executeQuery();
        String date="";//date du pret
        while (resultat.next()) 
        {
           date = resultat.getString("datepret");
        }
        String datePret = date;
        // Obtenez la date actuelle
        LocalDate dateActuelle = LocalDate.now();
        int dureePret = 30; // Durée du prêt en jours
        // Convertissez la date du prêt en objet LocalDate
        LocalDate datePretObj = LocalDate.parse(datePret); // Assurez-vous que le format de la date correspond à "yyyy-MM-dd"
        
        // Calculez la date d'échéance
        LocalDate dateEcheance = datePretObj.plusDays(dureePret);

        // Calculez le nombre de jours restants
        long joursRestants = ChronoUnit.DAYS.between(dateActuelle, dateEcheance);

        //System.out.println("Nombre de jours restants : " + joursRestants);
        
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
        reste = conn.prepareStatement("SELECT * FROM RENDRE ORDER BY num_rendu DESC LIMIT 1");
        resultat = reste.executeQuery();
        float rest = 0;//email du client
        while (resultat.next()) 
        {
           rest = resultat.getFloat("rest_payé");
        }
        //obtenir email client
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
        email = conn.prepareStatement("SELECT * FROM CLIENT WHERE numCompte=?");
        email.setString(1,numCompt.getSelectedItem().toString());
        resultat = email.executeQuery();
        String emailclient = "";//email du client
        String nom = "";
        String prenom = "";
        String nomclient ="";
        while (resultat.next()) 
        {
           emailclient = resultat.getString("EMAIL");
           nom = resultat.getString("NOM");
           prenom = resultat.getString("PRENOM");
           nomclient = nom+" "+prenom;
        }
        
        // Paramètres SMTP du fournisseur de messagerie
        String host = "smtp.gmail.com";
        int port = 587;
        String username = "andrianaivomicke@gmail.com";
        String password = "mkzfaqidfvsnnoeg";

        // Configuration des propriétés
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Création de la session avec l'authentification
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {
            // Créez un objet MimeMessage
            MimeMessage message = new MimeMessage(session);

            // Définir l'expéditeur et les destinataires
            message.setFrom(new InternetAddress("andrianaivomicke@gmail.com")); // Remplacez par votre adresse e-mail
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailclient)); // Adresse e-mail du client

            // Définir le sujet du message
            message.setSubject("Notification de prêt");

            // Construire le contenu du message
            String contenuMessage = "Cher " +nomclient+ ",\n\n";
            contenuMessage += "Il vous reste " + joursRestants + " jours pour rembourser votre prêt.\n";
            contenuMessage += "Le montant à rendre est de " + rest + " Ar.\n\n";
            contenuMessage += "Cordialement,\n";
            contenuMessage += "Votre banque";

            // Définir le contenu du message
            message.setText(contenuMessage);

            // Envoyer le message
            Transport.send(message);

                System.out.println("E-mail de notification envoyé avec succès !");
                System.out.println(emailclient);
            } 
        catch (MessagingException e) 
        {
        System.out.println("Erreur lors de l'envoi de l'e-mail : " + e.getMessage());
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(AjoutPrete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutPrete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutPrete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutPrete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AjoutPrete dialog = new AjoutPrete(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AjoutPret;
    private javax.swing.JTextField DatePret;
    private javax.swing.JTextField MontPret;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> numCompt;
    private javax.swing.JButton retour;
    // End of variables declaration//GEN-END:variables
}
