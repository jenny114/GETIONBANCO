/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.TBBANCO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Menu;

/**
 *
 * @author JENNY
 */
public class GestionClientes extends javax.swing.JFrame {

   Conexion con=new Conexion();
    Connection cnn=con.conexiondb();
    PreparedStatement ps=null;
    ResultSet re=null;
    
    public GestionClientes() {
        initComponents();
        Cargatabla();
        Cargarcombox();
    }

    
    
    public void  Cargatabla(){
        DefaultTableModel tabla=new DefaultTableModel();
        tabla.addColumn("Documento");
        tabla.addColumn("Nombre Usuario");
        tabla.addColumn("Clave");
        tablaconsulta.setModel(tabla);
        String datos[]=new String[3];
        try{
            ps=cnn.prepareStatement("SELECT*FROM TBUsuario");
            re=ps.executeQuery();
            while(re.next()){
                datos[0]=re.getString(1);
                datos[1]=re.getString(2);
                datos[2]=re.getString(3);
                tabla.addRow(datos);
                
            }
        }
        catch (Exception e){
            System.out.print(e);
            
        }
        
    
}
    
   public void listardatos(){
       
     int lis=jComboBox1.getSelectedIndex();
     if(lis>=0){
         
        
        //jComboBox1.setSelectedItem(tablaconsulta.getValueAt(lis, 0).toString());
        jTextUSU.setText(tablaconsulta.getValueAt(lis, 1).toString());
        jTextCONTR.setText(tablaconsulta.getValueAt(lis, 2).toString());
     }
       
   } 
    public void Registrar(){
    try{
    ps=cnn.prepareStatement("INSERT INTO tbusuario(USUsu,USCliDoc,USClave) values (?,?,?)");
    ps.setString(1,jTextUSU .getText());
    ps.setString(2,jComboBox1.getSelectedItem().toString());
    ps.setString(3,jTextCONTR.getText());
    ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Datos guardados");
    }
    catch (Exception e){
    System.out.print("es " + e);
    }
}
    public void Eliminar(String dat){
        try{
        ps=cnn.prepareStatement("DELETE FROM tbusuario where  USCliDoc='"+dat+"' ");
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Datos eliminados");
        }
            catch(Exception e){
                    System.out.print(e);
                    }
     }
    
    public void Modificar(String  doc,String usu,String cla){
        try{
            ps=cnn.prepareStatement("UPDATE tbusuario SET  USUsu='"+ usu +"', USClave='"+cla+"' where USCliDoc='"+doc+"' ");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados");
        }
        catch(Exception e){
            
            System.out.print( e);
        }
        
        
    }
    
  public void  filtro(){
        DefaultTableModel tabla=new DefaultTableModel();
        tabla.addColumn("Nombre Usuario");
        tabla.addColumn("Documento");
        tabla.addColumn("Clave");
       
        tablaconsulta.setModel(tabla);
        String datos[]=new String[3];
        try{
            ps=cnn.prepareStatement("SELECT*FROM TBUsuario where   USCliDoc like '%"+ jComboBox1.getSelectedItem() +"%' or  USUsu like '%"+jTextUSU.getText()+"%' or USClave like'%"+jTextCONTR.getText()+"%' ");
            
            re=ps.executeQuery();
            while(re.next()){
                datos[0]=re.getString(1);
                datos[1]=re.getString(2);
                datos[2]=re.getString(3);
                tabla.addRow(datos);
                
                
            }
        }
        catch (Exception e){
            System.out.print(e);
            
        }
        
    
}   
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaconsulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextUSU = new javax.swing.JTextField();
        jTextCONTR = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jBuLIM = new javax.swing.JButton();
        jBuModifi = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jTexBUSCAR = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("ATRAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        tablaconsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaconsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaconsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaconsulta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 740, 230));

        jLabel1.setText("Documento");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel3.setText("Contraseña");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jTextUSU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextUSUKeyReleased(evt);
            }
        });
        getContentPane().add(jTextUSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 150, 30));

        jTextCONTR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCONTRKeyReleased(evt);
            }
        });
        getContentPane().add(jTextCONTR, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 150, 30));

        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        jBuLIM.setText("Limpiar");
        jBuLIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuLIMActionPerformed(evt);
            }
        });
        getContentPane().add(jBuLIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        jBuModifi.setText("Modificar");
        jBuModifi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuModifiActionPerformed(evt);
            }
        });
        getContentPane().add(jBuModifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox1KeyReleased(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 150, 30));

        jButton4.setText("Buscar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton4KeyTyped(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, -1, -1));

        jTexBUSCAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTexBUSCARKeyReleased(evt);
            }
        });
        getContentPane().add(jTexBUSCAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu m=new Menu();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Registrar ();
        Cargatabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String dat=jComboBox1.getSelectedItem().toString();
        Eliminar(dat);
        Cargatabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBuLIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuLIMActionPerformed
      jComboBox1.removeAllItems();
      Cargarcombox();
       jTextUSU.setText(null);
       jTextCONTR.setText(null);
       
    }//GEN-LAST:event_jBuLIMActionPerformed

    private void jBuModifiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuModifiActionPerformed
        String doc,usu,cla;
        doc=jComboBox1.getSelectedItem().toString();
        usu=jTextUSU.getText();
        cla=jTextCONTR.getText();
        Modificar(doc, usu, cla);
        Cargatabla();
    }//GEN-LAST:event_jBuModifiActionPerformed
public void Cargarcombox(){
    try{
        jComboBox1.removeAll();
        jComboBox1.addItem("Seleccione Documento");
        ps=cnn.prepareStatement("SELECT CliDoc FROM  tbcliente ");
        re=ps.executeQuery();
        while(re.next()){
            String aux=re.getString("CliDoc");
            this.jComboBox1.addItem(aux);
        }
    }
    catch(Exception e){
        
        
    }
   
}
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void tablaconsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaconsultaMouseClicked
       listardatos();
    }//GEN-LAST:event_tablaconsultaMouseClicked

    private void jButton4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyReleased
     
      filtro();
    }//GEN-LAST:event_jButton4KeyReleased
/*
    private void jButton4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyTyped
      filtro();
    }//GEN-LAST:event_jButton4KeyTyped
*/
    private void jComboBox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyReleased
        //filtro();
    }//GEN-LAST:event_jComboBox1KeyReleased

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        filtro();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jTexBUSCARKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTexBUSCARKeyReleased
       // filtro();
      
    }//GEN-LAST:event_jTexBUSCARKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      filtro();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        listardatos();
        filtro();
       
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jTextUSUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextUSUKeyReleased
       
    }//GEN-LAST:event_jTextUSUKeyReleased

    private void jTextCONTRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCONTRKeyReleased
       
    }//GEN-LAST:event_jTextCONTRKeyReleased

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
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBuLIM;
    private javax.swing.JButton jBuModifi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTexBUSCAR;
    private javax.swing.JTextField jTextCONTR;
    private javax.swing.JTextField jTextUSU;
    private javax.swing.JTable tablaconsulta;
    // End of variables declaration//GEN-END:variables
}
