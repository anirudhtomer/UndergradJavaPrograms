/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DSS.java
 *
 * Created on Apr 22, 2011, 10:40:51 PM
 */

package NIS_version_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Anirudh
 */
public class DSS extends javax.swing.JFrame {

    /** Creates new form DSS */
    KeyPairGenerator keyPairGenerator;
    SecureRandom secureRandom;
    KeyPair keyPair;
    Signature signatureSign,signatureVerify;
    PublicKey publicKey,regeneratedPublicKey;
    PrivateKey privateKey;

    JFileChooser fileChooserdata,fileChooserpublickey,fileChoosersignature;
    String datafilepath,publickeyfilepath,signaturefilepath;

    public DSS() {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            System.out.println("Error :" + e.getMessage());
        }

        initComponents();

        fileChooserdata = new JFileChooser();

        fileChooserdata.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(fileChooserdata.getSelectedFile()!=null){
                    jTextField1.setText(fileChooserdata.getSelectedFile().getPath());
                    datafilepath = jTextField1.getText();
                }
            }
        });

        fileChoosersignature = new JFileChooser();

        fileChoosersignature.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(fileChoosersignature.getSelectedFile()!=null){
                    jTextField2.setText(fileChoosersignature.getSelectedFile().getPath());
                    signaturefilepath = jTextField2.getText();
                }
            }
        });

        fileChooserpublickey = new JFileChooser();

        fileChooserpublickey.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(fileChooserpublickey.getSelectedFile()!=null){
                    jTextField3.setText(fileChooserpublickey.getSelectedFile().getPath());
                    publickeyfilepath = jTextField3.getText();
                }
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("File Path: Data");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 290, -1));

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        jLabel2.setText("File Path: Public Key");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel3.setText("File Path: Signature");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 290, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 290, 20));

        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));

        jButton3.setText("Browse");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 430, 100));

        jLabel4.setText("Public Key");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 430, 100));

        jLabel5.setText("Private Key");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setEnabled(false);
        jScrollPane3.setViewportView(jTextArea3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 430, 100));

        jButton4.setText("Generate Keys");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, -1, -1));

        jLabel6.setText("Signature");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, -1, -1));

        jLabel7.setText("Plain Text Data");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jButton5.setText("Read File");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setEnabled(false);
        jScrollPane4.setViewportView(jTextArea4);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 430, 110));

        jButton6.setText("Sign Doc");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 550, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, -1, 680));

        jLabel8.setText("SIGNATURE VERIFICATION (optional)");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 200, -1));

        jButton7.setText("Regenerate Public Key from the File");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 260, -1));

        jButton8.setText("Verify The Signature with the Messge Contents");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 260, -1));

        jButton9.setText("Make Random Changes in Message (optional)");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 260, -1));

        jButton10.setText("Make Random Changes in Signature (optional)");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 260, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fileChooserdata.showOpenDialog(getContentPane());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fileChoosersignature.showSaveDialog(getContentPane());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        fileChooserpublickey.showSaveDialog(getContentPane());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try{
            jTextArea1.setText("");
            FileInputStream fin = new FileInputStream(datafilepath);

            byte [] data = new byte[10000];
            int cnt;

            while((cnt = fin.read(data))!=-1){
                jTextArea1.setText(jTextArea1.getText() + new String(data,0,cnt));
            }

            fin.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            keyPairGenerator = KeyPairGenerator.getInstance("DSA","SUN");
            secureRandom = SecureRandom.getInstance("SHA1PRNG","SUN");

            keyPairGenerator.initialize(1024, secureRandom);
            
            keyPair = keyPairGenerator.generateKeyPair();

            privateKey = keyPair.getPrivate();
            publicKey =  keyPair.getPublic();

            jTextArea2.setText("" + publicKey);
            jTextArea3.setText("" + privateKey);

            FileOutputStream fout = new FileOutputStream(publickeyfilepath);

            fout.write(publicKey.getEncoded());

            fout.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try{
            signatureSign= Signature.getInstance("SHA1withDSA","SUN");

            signatureSign.initSign(privateKey);

            FileInputStream fin = new FileInputStream(datafilepath);

            byte [] data = new byte[10000];
            int cnt;

            while((cnt = fin.read(data))!=-1){
                signatureSign.update(data,0,cnt);
            }

            byte []dsasign = signatureSign.sign();
            jTextArea4.setText(new String(dsasign));

            FileOutputStream fout = new FileOutputStream(signaturefilepath);

            fout.write(dsasign);

            fout.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try{
            FileInputStream fin = new FileInputStream(publickeyfilepath);

            int filesize = fin.available();
            byte []publickeybytes = new byte[filesize];
            fin.read(publickeybytes);

            X509EncodedKeySpec keyspec = new X509EncodedKeySpec(publickeybytes);

            KeyFactory keyFactory = KeyFactory.getInstance("DSA","SUN");
            regeneratedPublicKey = keyFactory.generatePublic(keyspec);

            System.out.println(regeneratedPublicKey);

            fin.close();

            JOptionPane.showMessageDialog(getContentPane(),"Public Key Obtained");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(),"Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try{
            FileInputStream fin = new FileInputStream(datafilepath);
            FileInputStream finsig = new FileInputStream(signaturefilepath);

            signatureVerify = Signature.getInstance("SHA1withDSA","SUN");
            signatureVerify.initVerify(regeneratedPublicKey);

            byte [] msgdata = new byte[1000];
            byte [] sigdata = new byte[finsig.available()];

            int cnt;

            while((cnt = fin.read(msgdata) )!=-1){
                signatureVerify.update(msgdata,0,cnt);
            }

            finsig.read(sigdata);

            fin.close();
            finsig.close();

            if(signatureVerify.verify(sigdata)){
                JOptionPane.showMessageDialog(getContentPane(),"Signature Verified");
            }
            else{
                JOptionPane.showMessageDialog(getContentPane(),"Signature Not Verified");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(),"Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try{
            FileOutputStream fout = new FileOutputStream(signaturefilepath);

            String datarandom = Math.random() + "";
            fout.write((datarandom).getBytes());
            jTextArea4.setText(datarandom);
            fout.close();

            JOptionPane.showMessageDialog(getContentPane(),"Random Changes Made signature");
        }
        catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try{
            FileOutputStream fout = new FileOutputStream(datafilepath);

            String datarandom = Math.random() + "";
            fout.write((datarandom).getBytes());
            jTextArea1.setText(datarandom);

            fout.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}
