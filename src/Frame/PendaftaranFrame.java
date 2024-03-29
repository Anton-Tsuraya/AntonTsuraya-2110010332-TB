
package Frame;


import db.Koneksi;
//import java
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Pendaftaran;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class PendaftaranFrame extends javax.swing.JFrame {

    Pendaftaran pendaftaran;
    private final int SEDANG_TAMBAH= 001;
    private final int SEDANG_UBAH = 002;
    
    private int status;
    
    public void rbJenisKelaminSetSelected(String jenisKelamin) {
        if(jenisKelamin.equals("Laki-laki"))
            rbLaki.setSelected(true);
        else
            rbPerempuan.setSelected(true);
    }
    
    public String rbJenisKelaminGetSelected() {
        if(rbLaki.isSelected())
            return "Laki-laki";
        else if(rbPerempuan.isSelected())
            return "Perempuan";
        else return "";
    }

    public PendaftaranFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        status = SEDANG_TAMBAH;
        RefreshData();
    }

    
  public ArrayList<Pendaftaran> getPendaftaranList () {
        ArrayList<Pendaftaran> pendaftaranList = new ArrayList<Pendaftaran>();
        Koneksi koneksi = new Koneksi();
        Connection connection = koneksi.getConnection();
        
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * From pendaftaran";
        String order = " ORDER BY pendaftaran.no_daftar";
//        if(!keyword.equals(""))
//            query = query+ " WHERE anggota.id = ? OR nama_anggota like ?";
        
        query = query+order;
        try{
            ps = connection.prepareStatement(query);
//            if(!keyword.equals("")){
//                ps.setString(1,eCari.getText());
//                ps.setString(2, "%"+eCari.getText()+"%");
//            }
            rs = ps.executeQuery();
            while(rs.next()){
                pendaftaran = new Pendaftaran(
                        rs.getString("no_daftar"),
                        rs.getString("nisn"),
                        rs.getString("nik"),
                        rs.getString("nama_siswa"),
                        rs.getString("jengkel"),
                        rs.getString("agama"),
                        rs.getString("ttl"),
                        rs.getString("alamat"),
                        rs.getString("asal_sekolah"));
                pendaftaranList.add(pendaftaran);
            }
        } catch(SQLException ex){
            System.err.println("ERROR getPendaftaranList : "+ex);
            System.err.println(ex.getMessage());
        }
        return pendaftaranList;
    }
    
    public void selectPendaftaran(){
        ArrayList<Pendaftaran> list;
        list = getPendaftaranList();
        DefaultTableModel model = (DefaultTableModel)PendaftaranTable.getModel();
        Object[] row =  new Object[9];
        
        for (int i=0; i<list.size(); i++){
            row[0] = list.get(i).getNoDaftar();
            row[1] = list.get(i).getNisn();
            row[2] = list.get(i).getNik();
            row[3] = list.get(i).getNamaSiswa();
            row[4] = list.get(i).getJengkel();
            row[5] = list.get(i).getAgama();
            row[6] = list.get(i).getTtl();
            row[7] = list.get(i).getAlamat();
            row[8] = list.get(i).getAsalSekolah();           
            model.addRow(row);
        }
    }
      
    public final void RefreshData(){
        DefaultTableModel  dtmbk = (DefaultTableModel) PendaftaranTable.getModel();
        dtmbk.setRowCount(0);
        selectPendaftaran();
    }
    
    public final void resetForm(){
        NDtf.setEditable(true);
        NStf.setText("");
        NIStf.setText("");
        NIKtf.setText("");
        TTLtf.setText("");
        buttonGroup1.clearSelection();
        AGcbb.setSelectedItem("- Pilih Agama -");
        AStf.setText("");
        NDtf.setText("");
        ALta.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        KomponenPanel = new javax.swing.JPanel();
        NSlbl = new javax.swing.JLabel();
        NStf = new javax.swing.JTextField();
        NISlbl = new javax.swing.JLabel();
        NIStf = new javax.swing.JTextField();
        NIKlbl = new javax.swing.JLabel();
        NIKtf = new javax.swing.JTextField();
        TTLlbl = new javax.swing.JLabel();
        TTLtf = new javax.swing.JTextField();
        JKlbl = new javax.swing.JLabel();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        AGlbl = new javax.swing.JLabel();
        AGcbb = new javax.swing.JComboBox<>();
        ASlbl = new javax.swing.JLabel();
        AStf = new javax.swing.JTextField();
        ALlbl = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ALta = new javax.swing.JTextArea();
        NDlbl = new javax.swing.JLabel();
        NDtf = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKosong = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        cetakbtn = new javax.swing.JButton();
        TabelPanel = new javax.swing.JPanel();
        ScrollPane = new javax.swing.JScrollPane();
        PendaftaranTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        KomponenPanel.setBackground(new java.awt.Color(190, 190, 190));
        KomponenPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pendaftaran Peserta Didik Baru", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 1, 18))); // NOI18N

        NSlbl.setText("NAMA SISWA");

        NISlbl.setText("NISN");

        NIKlbl.setText("NIK");

        NIKtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIKtfActionPerformed(evt);
            }
        });

        TTLlbl.setText("TTL");

        JKlbl.setText("JENIS KELAMIN");

        buttonGroup1.add(rbLaki);
        rbLaki.setText("Laki-laki");

        buttonGroup1.add(rbPerempuan);
        rbPerempuan.setText("Perempuan");

        AGlbl.setText("AGAMA");

        AGcbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Agama -", "Islam", "Kristen Protestan", "Kristen Katolik", "Hindu", "Buddha", "Kong Hu Chu" }));
        AGcbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGcbbActionPerformed(evt);
            }
        });

        ASlbl.setText("ASAL SEKOLAH");

        ALlbl.setText("ALAMAT");

        ALta.setColumns(20);
        ALta.setRows(5);
        jScrollPane3.setViewportView(ALta);

        NDlbl.setText("NO DAFTAR");

        btnSimpan.setBackground(new java.awt.Color(153, 153, 153));
        btnSimpan.setText("Save");
        btnSimpan.setBorderPainted(false);
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(153, 153, 153));
        btnUbah.setText("Edit");
        btnUbah.setBorderPainted(false);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(153, 153, 153));
        btnHapus.setText("Delete");
        btnHapus.setBorderPainted(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKosong.setBackground(new java.awt.Color(153, 153, 153));
        btnKosong.setText("Clear");
        btnKosong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKosongActionPerformed(evt);
            }
        });

        btnKeluar.setBackground(new java.awt.Color(153, 153, 153));
        btnKeluar.setText("Return");
        btnKeluar.setBorderPainted(false);
        btnKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        cetakbtn.setBackground(new java.awt.Color(153, 153, 153));
        cetakbtn.setText("Print");
        cetakbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cetakbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KomponenPanelLayout = new javax.swing.GroupLayout(KomponenPanel);
        KomponenPanel.setLayout(KomponenPanelLayout);
        KomponenPanelLayout.setHorizontalGroup(
            KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KomponenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KomponenPanelLayout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnKosong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cetakbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(KomponenPanelLayout.createSequentialGroup()
                        .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(KomponenPanelLayout.createSequentialGroup()
                                .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TTLlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NIKlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NSlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(NISlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NStf)
                                    .addComponent(TTLtf, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NIKtf, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NIStf, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))
                            .addGroup(KomponenPanelLayout.createSequentialGroup()
                                .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JKlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(AGlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AGcbb, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(KomponenPanelLayout.createSequentialGroup()
                                        .addComponent(rbLaki, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbPerempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NDlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ASlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ALlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KomponenPanelLayout.createSequentialGroup()
                                .addComponent(AStf, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KomponenPanelLayout.createSequentialGroup()
                                .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NDtf, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(160, 160, 160))))))
        );
        KomponenPanelLayout.setVerticalGroup(
            KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KomponenPanelLayout.createSequentialGroup()
                .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KomponenPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NSlbl))
                    .addComponent(NStf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AStf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ASlbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NISlbl)
                    .addComponent(NIStf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NDtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NDlbl)))
                .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KomponenPanelLayout.createSequentialGroup()
                        .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(KomponenPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(NIKlbl))
                            .addGroup(KomponenPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NIKtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ALlbl))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TTLlbl)
                            .addComponent(TTLtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JKlbl)
                            .addComponent(rbLaki)
                            .addComponent(rbPerempuan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AGlbl)
                            .addComponent(AGcbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(KomponenPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(KomponenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnKosong)
                    .addComponent(cetakbtn))
                .addContainerGap())
        );

        getContentPane().add(KomponenPanel, java.awt.BorderLayout.PAGE_START);

        TabelPanel.setBackground(new java.awt.Color(190, 190, 190));

        ScrollPane.setBackground(new java.awt.Color(204, 204, 204));
        ScrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScrollPaneMouseClicked(evt);
            }
        });

        PendaftaranTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO DAFTAR", "NISN", "NIK", "NAMA SISWA", "JENIS KELAMIN", "AGAMA", "TTL", "ALAMAT", "ASAL SEKOLAH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PendaftaranTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PendaftaranTableMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(PendaftaranTable);

        javax.swing.GroupLayout TabelPanelLayout = new javax.swing.GroupLayout(TabelPanel);
        TabelPanel.setLayout(TabelPanelLayout);
        TabelPanelLayout.setHorizontalGroup(
            TabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabelPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
                .addContainerGap())
        );
        TabelPanelLayout.setVerticalGroup(
            TabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabelPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(TabelPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AGcbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGcbbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AGcbbActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        Pendaftaran pendaftaran = new Pendaftaran();
        pendaftaran.setNoDaftar(NDtf.getText());
        pendaftaran.setNisn(NIStf.getText());
        pendaftaran.setNik(NIKtf.getText());
        pendaftaran.setNamaSiswa(NStf.getText());
        pendaftaran.setJengkel(rbJenisKelaminGetSelected());        
        pendaftaran.setTtl(TTLtf.getText());
        pendaftaran.setAgama(AGcbb.getSelectedItem().toString());
        pendaftaran.setAlamat(ALta.getText());
        pendaftaran.setAsalSekolah(AStf.getText());
              
        if( NStf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Lengkapi data");
        }else{
            
            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getConnection();
            PreparedStatement ps;
            try {
                    String qry = "insert into pendaftaran(no_daftar, nisn, nik, nama_siswa, jengkel, agama, ttl, alamat, asal_sekolah) values (?,?,?,?,?,?,?,?,?)";
                    
                        ps = con.prepareStatement(qry);
                        ps.setString(1, pendaftaran.getNoDaftar());
                        ps.setString(2, pendaftaran.getNisn());
                        ps.setString(3, pendaftaran.getNik());
                        ps.setString(4, pendaftaran.getNamaSiswa());
                        ps.setString(5,pendaftaran.getJengkel());
                        ps.setString(6, pendaftaran.getAgama());
                        ps.setString(7, pendaftaran.getTtl());
                        ps.setString(8, pendaftaran.getAlamat());
                        ps.setString(9, pendaftaran.getAsalSekolah());
                        ps.executeUpdate();
                        RefreshData();
                        resetForm();
             }catch(SQLException e){
                System.err.println("error :"+e);   
            }
        }        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnKosongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKosongActionPerformed
        resetForm();
    }//GEN-LAST:event_btnKosongActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        Pendaftaran pendaftaran = new Pendaftaran();
        pendaftaran.setNoDaftar(NDtf.getText());
        pendaftaran.setNisn(NIStf.getText());
        pendaftaran.setNik(NIKtf.getText());
        pendaftaran.setNamaSiswa(NStf.getText());
        pendaftaran.setJengkel(rbJenisKelaminGetSelected());        
        pendaftaran.setTtl(TTLtf.getText());
        pendaftaran.setAgama(AGcbb.getSelectedItem().toString());
        pendaftaran.setAlamat(ALta.getText());
        pendaftaran.setAsalSekolah(AStf.getText());
              
        if( NStf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin diubah");
        }else{
            
            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getConnection();
            PreparedStatement ps;
            try {
                    String qry = "update pendaftaran set nisn=?, nik=?, nama_siswa=?, jengkel=?, agama=?, ttl=?, alamat=?, asal_sekolah=? where no_daftar=?";
                        ps = con.prepareStatement(qry);                       
                        ps.setString(1, pendaftaran.getNisn());
                        ps.setString(2, pendaftaran.getNik());
                        ps.setString(3, pendaftaran.getNamaSiswa());
                        ps.setString(4,pendaftaran.getJengkel());
                        ps.setString(5, pendaftaran.getAgama());
                        ps.setString(6, pendaftaran.getTtl());
                        ps.setString(7, pendaftaran.getAlamat());
                        ps.setString(8, pendaftaran.getAsalSekolah());
                        ps.setString(9, pendaftaran.getNoDaftar());
                        ps.executeUpdate();
                        RefreshData();
                        resetForm();
             }catch(SQLException e){
                System.err.println("error :"+e);   
            }
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void ScrollPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScrollPaneMouseClicked
        
    }//GEN-LAST:event_ScrollPaneMouseClicked

    private void PendaftaranTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PendaftaranTableMouseClicked
        int i  = PendaftaranTable.getSelectedRow();
        if(i>=0) {
            NDtf.setEditable(false);
            TableModel model  = PendaftaranTable.getModel();
            NDtf.setText(model.getValueAt(i, 0).toString());
            NIStf.setText(model.getValueAt(i, 1).toString());
            NIKtf.setText(model.getValueAt(i, 2).toString());
            NStf.setText(model.getValueAt(i, 3).toString());
            rbJenisKelaminSetSelected(model.getValueAt(i, 4).toString());
            AGcbb.setSelectedItem(model.getValueAt(i, 5).toString());
            TTLtf.setText(model.getValueAt(i, 6).toString());
            ALta.setText(model.getValueAt(i, 7).toString());
            AStf.setText(model.getValueAt(i, 8).toString());
        }else{
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin diubah");
        }
    }//GEN-LAST:event_PendaftaranTableMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int i = PendaftaranTable.getSelectedRow();
        if(i>=0){
        int pilihan = JOptionPane.showConfirmDialog(
                null,
                "Yakin mau hapus ?",
                "Konfirmasi hapus",
                JOptionPane.YES_NO_OPTION);
        if(pilihan==0){
                try{
                    TableModel model = PendaftaranTable.getModel();
                    Koneksi koneksi = new Koneksi();
                    Connection con = koneksi.getConnection();
                    String executeQuery = "delete from pendaftaran where no_daftar =?";
                    PreparedStatement ps = con.prepareStatement(executeQuery);
                    ps.setString(1, NDtf.getText());
                    ps.executeUpdate();
                        RefreshData();
                        resetForm();                   
                } catch (SQLException ex){
                    System.err.println(ex);
                }
            }
            }else{
                JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        RefreshData();
        
    }//GEN-LAST:event_formWindowActivated

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void cetakbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakbtnActionPerformed
        try {
         Koneksi koneksi = new Koneksi();
         Connection con= koneksi.getConnection(); 
         String path = "src/Laporan/pendaftaran.jasper";
            HashMap<String, Object> parameter = new HashMap();            
            JasperPrint jp = JasperFillManager.fillReport(path, parameter, con);
            JasperViewer viewer = new JasperViewer(jp, false);
        viewer.setVisible(true);
        } catch(Exception e) {
            System.err.println("error report :"+e);
        }        
    }//GEN-LAST:event_cetakbtnActionPerformed

    private void NIKtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIKtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NIKtfActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PendaftaranFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PendaftaranFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PendaftaranFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PendaftaranFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PendaftaranFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AGcbb;
    private javax.swing.JLabel AGlbl;
    private javax.swing.JLabel ALlbl;
    private javax.swing.JTextArea ALta;
    private javax.swing.JLabel ASlbl;
    private javax.swing.JTextField AStf;
    private javax.swing.JLabel JKlbl;
    private javax.swing.JPanel KomponenPanel;
    private javax.swing.JLabel NDlbl;
    private javax.swing.JTextField NDtf;
    private javax.swing.JLabel NIKlbl;
    private javax.swing.JTextField NIKtf;
    private javax.swing.JLabel NISlbl;
    private javax.swing.JTextField NIStf;
    private javax.swing.JLabel NSlbl;
    private javax.swing.JTextField NStf;
    private javax.swing.JTable PendaftaranTable;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JLabel TTLlbl;
    private javax.swing.JTextField TTLtf;
    private javax.swing.JPanel TabelPanel;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnKosong;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cetakbtn;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    // End of variables declaration//GEN-END:variables
}
