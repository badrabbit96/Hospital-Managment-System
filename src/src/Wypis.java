
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Wypis extends javax.swing.JFrame {
Connection con=null;
ResultSet rs=null;
PreparedStatement pst=null;
   
    public Wypis() {
        initComponents();
        setLocationRelativeTo(null);
        txtID2.setVisible(false);
        txtID1.setVisible(false);
    }
private void Reset()
{
    LekarzImie.setText("");
    LekarzNazwisko.setText("");
    ID.setText("");
    PacjentImie.setText("");
    PESEL.setText("");
    PacjentNazwisko.setText("");
    txtDiagnoza.setText("");
    txtDataPrzyjecia.setText("");
    txtOddzial.setText("");
    txtUwagi.setText("");
    txtDataWypisu.setText("");
    btnZapisz.setEnabled(true);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        PacjentImie = new javax.swing.JTextField();
        txtDataPrzyjecia = new javax.swing.JFormattedTextField();
        jLabel29 = new javax.swing.JLabel();
        PacjentNazwisko = new javax.swing.JTextField();
        PESEL = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtDiagnoza = new javax.swing.JTextField();
        LekarzNazwisko = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtUwagi = new javax.swing.JTextArea();
        txtOddzial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDataWypisu = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        btnNowy = new javax.swing.JButton();
        btnZapisz = new javax.swing.JButton();
        btnUsun = new javax.swing.JButton();
        btnGetData = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtID1 = new javax.swing.JTextField();
        txtID2 = new javax.swing.JTextField();
        LekarzImie = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jButton2.setText("Zamknij");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Wypis");
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacje"));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("ID");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Imię");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("PESEL");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Uwagi");

        ID.setEditable(false);

        PacjentImie.setEditable(false);

        txtDataPrzyjecia.setEditable(false);
        txtDataPrzyjecia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Nazwisko");

        PacjentNazwisko.setEditable(false);

        PESEL.setEditable(false);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Diagnoza");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Data przyjęcia");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Oddział");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Imię Lekarza");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Nazwisko Lek");

        txtDiagnoza.setEditable(false);

        LekarzNazwisko.setEditable(false);

        txtUwagi.setColumns(20);
        txtUwagi.setRows(5);
        jScrollPane3.setViewportView(txtUwagi);

        txtOddzial.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Data wypisu");

        txtDataWypisu.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText(">");
        jButton1.setPreferredSize(new java.awt.Dimension(41, 21));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnNowy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNowy.setText("Reset");
        btnNowy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNowyActionPerformed(evt);
            }
        });

        btnZapisz.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnZapisz.setText("Zapisz (wypisz)");
        btnZapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZapiszActionPerformed(evt);
            }
        });

        btnUsun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUsun.setText("Usuń");
        btnUsun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsunActionPerformed(evt);
            }
        });

        btnGetData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGetData.setText("Historia");
        btnGetData.setActionCommand("Historia ");
        btnGetData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetDataActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Zamknij");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        LekarzImie.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PESEL)
                            .addComponent(PacjentNazwisko)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDiagnoza)
                            .addComponent(txtDataPrzyjecia)
                            .addComponent(PacjentImie, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel35))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtOddzial, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LekarzNazwisko)
                                    .addComponent(LekarzImie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel7))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDataWypisu)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))))))
                    .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(btnUsun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNowy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnZapisz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGetData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33)
                                .addComponent(txtOddzial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(PacjentImie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(LekarzImie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(PacjentNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(LekarzNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(PESEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtDataWypisu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDiagnoza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28))
                                    .addComponent(jLabel31))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32)
                                    .addComponent(txtDataPrzyjecia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNowy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnZapisz, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUsun, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGetData, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Zdjecia/0005L0ASNOG8SCDU-C122.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZapiszActionPerformed
   try{
            con=Polaczenie.ConnectDB();
              if (ID.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Podaj ID","Błąd !", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (PacjentImie.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Podaj imię pacjenta","Błąd !", JOptionPane.ERROR_MESSAGE);
                return;
            }
           if (PacjentNazwisko.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Podaj płeć","Błąd !", JOptionPane.ERROR_MESSAGE);
                return;
            }
         
            if (PESEL.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Podaj grupę krwi","Błąd !", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtDiagnoza.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Podaj diagnozę","Błąd !", JOptionPane.ERROR_MESSAGE);
                return;
            }
             if (txtDataPrzyjecia.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Podaj datę przyjęcia","Błąd !", JOptionPane.ERROR_MESSAGE);
                return;
            }
           
            if (LekarzImie.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Podaj ID lekarza","Błąd !", JOptionPane.ERROR_MESSAGE);
                return;

            }
            if (LekarzNazwisko.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Podaj imię lekarza","Błąd !", JOptionPane.ERROR_MESSAGE);
                return;

            }
             if (txtDataWypisu.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Podaj datę wypisu","Błąd !", JOptionPane.ERROR_MESSAGE);
                return;

            }
              Statement stmt;
       stmt= con.createStatement();
       String sql1="Select WYPISID from SZPITAL_DB.WYPIS_Z_ODDZIALU where WYPISID= " + txtID1.getText() + "";
      rs=stmt.executeQuery(sql1);
      if(rs.next()){
        JOptionPane.showMessageDialog( this, "ID jest zajęte","Błąd !", JOptionPane.ERROR_MESSAGE);
        return;
      }
     
            //zmiana na PROCEDURĘ
            String sql= "insert into SZPITAL_DB.WYPIS_Z_ODDZIALU(PRZYJECIEID,DATAWYP,UWAGI)values("+ txtID1.getText() + ",'"+ txtDataWypisu.getText() + "','"+ txtUwagi.getText() + "')";

            pst=con.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(this,"Wypisano pacjęta","Potwierdzenie",JOptionPane.INFORMATION_MESSAGE);
            btnZapisz.setEnabled(false);

        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_btnZapiszActionPerformed

    private void btnNowyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNowyActionPerformed
    Reset();
    }//GEN-LAST:event_btnNowyActionPerformed

    private void btnUsunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsunActionPerformed
     WypisUsun frm= new WypisUsun();
        frm.setVisible(true);
    }//GEN-LAST:event_btnUsunActionPerformed

    private void btnGetDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetDataActionPerformed
    
        WypisTabela frm= new WypisTabela();
        frm.setVisible(true);
    }//GEN-LAST:event_btnGetDataActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.hide();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.hide();
        PrzyjecieTabela1 frm = new PrzyjecieTabela1();
        frm.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Wypis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wypis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wypis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wypis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wypis().setVisible(true);
                //PatientDischarge_Room
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField ID;
    public javax.swing.JTextField LekarzImie;
    public javax.swing.JTextField LekarzNazwisko;
    public javax.swing.JTextField PESEL;
    public javax.swing.JTextField PacjentImie;
    public javax.swing.JTextField PacjentNazwisko;
    private javax.swing.JButton btnGetData;
    private javax.swing.JButton btnNowy;
    public javax.swing.JButton btnUsun;
    public javax.swing.JButton btnZapisz;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JFormattedTextField txtDataPrzyjecia;
    public javax.swing.JFormattedTextField txtDataWypisu;
    public javax.swing.JTextField txtDiagnoza;
    public javax.swing.JTextField txtID1;
    public javax.swing.JTextField txtID2;
    public javax.swing.JTextField txtOddzial;
    public javax.swing.JTextArea txtUwagi;
    // End of variables declaration//GEN-END:variables
}
