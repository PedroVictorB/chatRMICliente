/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.glass.events.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.actions;

/**
 *
 * @author Pedro
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
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

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chat RMI");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        jButton1.setText("Login");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Cadastro");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel2.setText("Não tem login?Cadastre-se!! -->");

        jLabel3.setText("Login:");

        jLabel4.setText("Senha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordField1)
                                    .addComponent(jTextField1))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 143, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(167, 167, 167))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (jTextField1.getText().isEmpty() || jPasswordField1.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Digite login e senha!!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
        } else {
            String login = jTextField1.getText();
            String senha = new String(jPasswordField1.getPassword());
            try {
                if (new actions().login(login, senha)) {
                    System.out.println("LOGADO!");
                    Principal p = Principal.getInstance();
                    p.setVisible(true);
                    p.setUsuario(new actions().buscarUsuarioByName(login));
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou senha incorreto ou usuário já está logado no sistema!!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (NotBoundException ex) {
                JOptionPane.showMessageDialog(null, "Nome RMI não achado!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                System.out.println(ex.getMessage());
            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, "URL RMI errada!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                System.out.println(ex.getMessage());
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, "Erro na execução do método remoto!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jTextField1.getText().isEmpty() || jPasswordField1.getPassword().length == 0) {
                JOptionPane.showMessageDialog(null, "Digite login e senha!!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            } else {

                String login = jTextField1.getText();
                String senha = new String(jPasswordField1.getPassword());
                try {
                    if (new actions().login(login, senha)) {
                        System.out.println("LOGADO!");
                        Principal p = Principal.getInstance();
                        p.setVisible(true);
                        p.setUsuario(new actions().buscarUsuarioByName(login));
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou senha incorreto ou usuário já está logado no sistema!!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (NotBoundException ex) {
                    JOptionPane.showMessageDialog(null, "Nome RMI não achado!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    System.out.println(ex.getMessage());
                } catch (MalformedURLException ex) {
                    JOptionPane.showMessageDialog(null, "URL RMI errada!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    System.out.println(ex.getMessage());
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, "Erro na execução do método remoto!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    System.out.println(ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jTextField1.getText().isEmpty() || jPasswordField1.getPassword().length == 0) {
                JOptionPane.showMessageDialog(null, "Digite login e senha!!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            } else {

                String login = jTextField1.getText();
                String senha = new String(jPasswordField1.getPassword());
                try {
                    if (new actions().login(login, senha)) {
                        System.out.println("LOGADO!");
                        Principal p = Principal.getInstance();
                        p.setVisible(true);
                        p.setUsuario(new actions().buscarUsuarioByName(login));
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou senha incorreto ou usuário já está logado no sistema!!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (NotBoundException ex) {
                    JOptionPane.showMessageDialog(null, "Nome RMI não achado!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    System.out.println(ex.getMessage());
                } catch (MalformedURLException ex) {
                    JOptionPane.showMessageDialog(null, "URL RMI errada!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    System.out.println(ex.getMessage());
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, "Erro na execução do método remoto!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    System.out.println(ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        new Cadastro().setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
