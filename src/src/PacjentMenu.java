
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import javax.swing.JOptionPane;

public class PacjentMenu extends javax.swing.JFrame {
Connection con=null;
ResultSet rs=null;
PreparedStatement pst=null;

   public PacjentMenu() {
        initComponents();
        setLocationRelativeTo(this);
        this.getContentPane().setBackground( Color.white );
        String login=(Login.login);
        setIco();
  
        jLabel8.setText(Nazwa());
        jLabel11.setText(OstatnieLogowanie());
        jLabel9.setText(Status());
        jLabel4.setText(Pacjenci());
        jLabel5.setText(Lekarz());
        jLabel12.setText(PacjentOddzial());
        jLabel21.setText(PacjentLekarz());
        jLabel22.setText(PacjentDiagnoza());
        jLabel23.setText(PacjentData());
        jLabel24.setText(LiczbaWyleczonych());
        jLabel26.setText(PacjentLiczbaNaOddziale());
        jLabel27.setText(PoliczWszyscy());
        jLabel25.setText(PacjentOddzialNajwiecej());
        jLabel29.setText(PacjentDataWypis());

    }
   private String OstatnieLogowanie()
   {
       String ostatnieLogowanie = "null";
        con=Polaczenie.ConnectDB();
         String sql= "select ostatnieLogowanie from SZPITAL_DB.LOGOWANIE where LOGIN= '" +(Login.login)+ "'";
    try
      {
          pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
           if(rs.next()){
        String add1=rs.getString("ostatnielogowanie");
          ostatnieLogowanie = add1;
           }
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return ostatnieLogowanie;
   }
   private String Status()
   {
     String status = "null";
     
        con=Polaczenie.ConnectDB();
         String sql= "select status from SZPITAL_DB.LOGOWANIE where LOGIN= '" +(Login.login)+ "'";
    try
      {
          pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
           if(rs.next()){
        String add1=rs.getString("status");
          status = add1;
           }
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return status;
   }
   private String Nazwa()
   {
     String nazwa = "null";
     
        con=Polaczenie.ConnectDB();
         String sql= "select IMIE from SZPITAL_DB.LOGOWANIE where LOGIN= '" +Login.login+ "'";
    try
      {
          pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
           if(rs.next()){
        String add1=rs.getString("IMIE");
          nazwa = add1;
           }
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return nazwa;
   }
   private String Sesja()
   {
          String ostatnieLogowanie;
    ostatnieLogowanie = (Login.terazLogowanie);
       String login;
       login = (Login.login);
              //   JOptionPane.showMessageDialog(null, ostatnieLogowanie);
         con=Polaczenie.ConnectDB();
             String sql= "update SZPITAL_DB.LOGOWANIE set OSTATNIELOGOWANIE='"+ostatnieLogowanie+"' WHERE login = '"+login+"'";
            try
            {
                pst=con.prepareStatement(sql);
                pst.execute();

            }catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, e);

            }
    return ostatnieLogowanie;
       
   }
   private String Pacjenci()
   {
   String Pacjenci = "null";
     
        con=Polaczenie.ConnectDB();
         String sql="{? = call SZPITAL_DB.POLICZ_PACJENCI}";
    try
      {
    CallableStatement stmt = con.prepareCall(sql);
    stmt.registerOutParameter(1,Types.VARCHAR);
    stmt.execute();
    String ile = stmt.getString(1);
     Pacjenci = ile;
    
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return Pacjenci;
   }
   private String Lekarz()
   {
    String Lekarz = "null";
     
        con=Polaczenie.ConnectDB();
         String sql="{? = call SZPITAL_DB.POLICZ_LEKARZ}";
    try
      {
    CallableStatement stmt = con.prepareCall(sql);
    stmt.registerOutParameter(1,Types.VARCHAR);
    stmt.execute();
    String ile = stmt.getString(1);
     Lekarz = ile;
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return Lekarz;
   }
   private String PacjentOddzial()
   {
    String PacjentOddzial = "null-";
    String login = Login.login;
          

     con=Polaczenie.ConnectDB();
         String sql="{? = call SZPITAL_DB.PACJENT_ODDZIAL(?)}";
    try
      {
    CallableStatement stmt = con.prepareCall(sql);
    stmt.setString(2, Login.login);
    stmt.registerOutParameter(1,Types.VARCHAR);
    stmt.execute();
    String ile = stmt.getString(1);
    stmt.execute();
    
     PacjentOddzial = ile;
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return PacjentOddzial;
   }
   private String PacjentLekarz()
   {
    String PacjentLekarz = "null-";
    String login = Login.login;
           
     con=Polaczenie.ConnectDB();
         String sql="{? = call SZPITAL_DB.PACJENT_LEKARZ(?)}";
    try
      {
    CallableStatement stmt = con.prepareCall(sql);
    stmt.setString(2, Login.login);
    stmt.registerOutParameter(1,Types.VARCHAR);
    stmt.execute();
    String ile = stmt.getString(1);
    stmt.execute();
    
     PacjentLekarz = ile;
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return PacjentLekarz;
   }
   private String PacjentDiagnoza()
   {
    String PacjentDiagnoza = "null-";
    String login = Login.login;
          

     con=Polaczenie.ConnectDB();
         String sql="{? = call SZPITAL_DB.PACJENT_DIAGNOZA(?)}";
    try
      {
    CallableStatement stmt = con.prepareCall(sql);
    stmt.setString(2, Login.login);
    stmt.registerOutParameter(1,Types.VARCHAR);
    stmt.execute();
    String ile = stmt.getString(1);
    stmt.execute();
    
     PacjentDiagnoza = ile;
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return PacjentDiagnoza;
   }
   private String PacjentData()
   {
    String PacjentData = "null-";
    String login = Login.login;
          

     con=Polaczenie.ConnectDB();
         String sql="{? = call SZPITAL_DB.PACJENT_DATA(?)}";
    try
      {
    CallableStatement stmt = con.prepareCall(sql);
    stmt.setString(2, Login.login);
    stmt.registerOutParameter(1,Types.VARCHAR);
    stmt.execute();
    String ile = stmt.getString(1);
    stmt.execute();
    
     PacjentData = ile;
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return PacjentData;
   }
   private String LiczbaWyleczonych()
   {
   String LiczbaWyleczonych = "null";
     
        con=Polaczenie.ConnectDB();
         String sql="{? = call SZPITAL_DB.POLICZ_WYPIS}";
    try
      {
    CallableStatement stmt = con.prepareCall(sql);
    stmt.registerOutParameter(1,Types.VARCHAR);
    stmt.execute();
    String ile = stmt.getString(1);
     LiczbaWyleczonych = ile;
    
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return LiczbaWyleczonych;
   }
   private String PacjentLiczbaNaOddziale()
   {
    String PacjentLiczbaNaOddziale = "null-";
    String login = Login.login;
          

     con=Polaczenie.ConnectDB();
         String sql="{? = call SZPITAL_DB.PACJENT_LICZBA_ODDZIAL(?)}";
    try
      {
    CallableStatement stmt = con.prepareCall(sql);
    stmt.setString(2, Login.login);
    stmt.registerOutParameter(1,Types.VARCHAR);
    stmt.execute();
    String ile = stmt.getString(1);
    stmt.execute();
    
     PacjentLiczbaNaOddziale = ile;
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return PacjentLiczbaNaOddziale;
   }
   private String PoliczWszyscy()
   {
   String PoliczWszyscy = "null";
     
        con=Polaczenie.ConnectDB();
         String sql="{? = call SZPITAL_DB.POLICZ_WSZYSCY}";
    try
      {
    CallableStatement stmt = con.prepareCall(sql);
    stmt.registerOutParameter(1,Types.VARCHAR);
    stmt.execute();
    String ile = stmt.getString(1);
     PoliczWszyscy = ile;
    
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return PoliczWszyscy;
   }
   private String PacjentOddzialNajwiecej()
   {
   String PacjentOddzialNajwiecej = "null";
     
        con=Polaczenie.ConnectDB();
         String sql="{? = call SZPITAL_DB.PACJENT_ODDZIAL_NAJWIECEJ}";
    try
      {
    CallableStatement stmt = con.prepareCall(sql);
    stmt.registerOutParameter(1,Types.VARCHAR);
    stmt.execute();
    String ile = stmt.getString(1);
     PacjentOddzialNajwiecej = ile;
    
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return PacjentOddzialNajwiecej;
   }
   private String PacjentDataWypis()
   {
    String PacjentDataWypis = "null-";
    String login = Login.login;
          

     con=Polaczenie.ConnectDB();
         String sql="{? = call SZPITAL_DB.PACJENT_DATA_WYPIS(?)}";
    try
      {
    CallableStatement stmt = con.prepareCall(sql);
    stmt.setString(2, Login.login);
    stmt.registerOutParameter(1,Types.VARCHAR);
    stmt.execute();
    String ile = stmt.getString(1);
    stmt.execute();
    
     PacjentDataWypis = ile;
      }
    catch(SQLException | HeadlessException e){
         JOptionPane.showMessageDialog(null, e); 
   }
     return PacjentDataWypis;
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();

        jMenu6.setText("jMenu6");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu12.setText("jMenu12");

        jMenuItem16.setText("jMenuItem16");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                SesjaOnEXIT(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacje"));

        jLabel6.setFont(new java.awt.Font("Andale Mono", 0, 14)); // NOI18N
        jLabel6.setText("Witaj,");

        jLabel7.setFont(new java.awt.Font("Andale Mono", 0, 14)); // NOI18N
        jLabel7.setText("Status:");

        jLabel8.setFont(new java.awt.Font("Andale Mono", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("null");

        jLabel9.setFont(new java.awt.Font("Andale Mono", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("null");

        jLabel2.setFont(new java.awt.Font("Andale Mono", 0, 14)); // NOI18N
        jLabel2.setText("Liczba pacjentów:");

        jLabel4.setFont(new java.awt.Font("Andale Mono", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("null");

        jLabel3.setFont(new java.awt.Font("Andale Mono", 0, 14)); // NOI18N
        jLabel3.setText("Liczba lekarzy:");

        jLabel5.setFont(new java.awt.Font("Andale Mono", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("null");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Zdjecia/szpital-matopat_242687a92318af2e0e221797c614389f.jpg"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ustawienia"));

        jButton7.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jButton7.setText("Zmiana hasła");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jButton8.setText("Wyloguj");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jButton9.setText("Wyjście");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Szpital"));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Jestelś na oddziale:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Lekarz prowadzący:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Diagnoza:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Data przyjęcia na oddział:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("oddzial");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 255));
        jLabel21.setText("lekarz");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 255));
        jLabel22.setText("diagnoza");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 255));
        jLabel23.setText("data+prz");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Data wypisu:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 255));
        jLabel29.setText("data+wypis");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel21)
                    .addComponent(jLabel16)
                    .addComponent(jLabel23)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel22)
                        .addComponent(jLabel15)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacje o logowaniu"));

        jLabel10.setText("Ostatnie logowanie:");

        jLabel11.setForeground(new java.awt.Color(51, 51, 255));
        jLabel11.setText("brak");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacje ogólne"));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Wyleczonych pacjentów:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Oddizał z największą liczbą pacjentów:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Na twoim oddziale przebywa:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Liczba wszystkich osób w szpitalu:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 255));
        jLabel24.setText("wyleczeni");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 255));
        jLabel25.setText("najwieksza");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 255));
        jLabel26.setText("liczba+oddizal");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 255));
        jLabel27.setText("wszyscy");

        jToggleButton1.setText("Pobierz");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel30.setText("Raport z pobytu w szpitalu:");

        jLabel31.setText("Choroby:");

        jButton1.setText("Wyświetl");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel19)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel20)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jLabel30))
                .addGap(2, 2, 2))
        );

        jMenu2.setText("Ustawienia");

        jMenuItem5.setText("Zmiana hasła");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Pomoc");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        jMenuItem12.setText("O programie");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("");
        jPanel5.getAccessibleContext().setAccessibleName("Informacje");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    ZmianaHasla frm = new ZmianaHasla();
    frm.setVisible(true); 
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
   
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
     oProgramie frm= new oProgramie();
     frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
             Login frm=new Login();
             frm.setVisible(true);
             this.hide();
             dispose(); 
             Sesja();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Sesja(); 
        System.exit(0);       
    }//GEN-LAST:event_jButton9ActionPerformed

    private void SesjaOnEXIT(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_SesjaOnEXIT
     Sesja();
    }//GEN-LAST:event_SesjaOnEXIT

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     ZmianaHasla frm = new ZmianaHasla();
    frm.setVisible(true); 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
    GenerowaniePDF frm = new GenerowaniePDF();
    frm.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ChorobyPacjentTabela frm = new ChorobyPacjentTabela();
    frm.setVisible(true); 
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void setIco() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Zdjecia/443775.png")));
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PacjentMenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
