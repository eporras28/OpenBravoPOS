//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007 Openbravo, S.L.
//    http://sourceforge.net/projects/
//
//    This program is free software; you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation; either version 2 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package com.openbravo.pos.config;

import java.awt.Component;
import com.openbravo.pos.forms.AppConfig;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.util.AltEncrypter;

/**
 *
 * @author adrianromero
 */
public class JPanelConfigERP extends javax.swing.JPanel implements PanelConfig {
    
    /** Creates new form JPanelConfigERP */
    public JPanelConfigERP() {
        initComponents();
    }
    
    public Component getConfigComponent() {
        return this;
    }
   
    public void loadProperties(AppConfig config) {

        jtxtUrl.setText(config.getProperty("erp.URL"));    
        jtxtId.setText(config.getProperty("erp.id"));
        jTextField2.setText(config.getProperty("erp.pos"));
        jTextField1.setText(config.getProperty("erp.org"));
        
        String sERPUser = config.getProperty("erp.user");
        String sERPPassword = config.getProperty("erp.password");        
        if (sERPUser != null && sERPPassword != null && sERPPassword.startsWith("crypt:")) {
            // La clave esta encriptada.
            AltEncrypter cypher = new AltEncrypter("cypherkey" + sERPUser);
            sERPPassword = cypher.decrypt(sERPPassword.substring(6));
        }        
        jtxtName.setText(sERPUser);
        jtxtPassword.setText(sERPPassword);           
    }
    
    public void saveProperties(AppConfig config) {
        
        config.setProperty("erp.URL", jtxtUrl.getText());
        config.setProperty("erp.id", jtxtId.getText());
        config.setProperty("erp.pos", jTextField2.getText());
        config.setProperty("erp.org", jTextField1.getText());
        
        config.setProperty("erp.user", jtxtName.getText());
        AltEncrypter cypher = new AltEncrypter("cypherkey" + jtxtName.getText());             
        config.setProperty("erp.password", "crypt:" + cypher.encrypt(new String(jtxtPassword.getPassword())));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jlabelUrl = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelProperties = new javax.swing.JLabel();
        jtxtUrl = new javax.swing.JTextField();
        jtxtId = new javax.swing.JTextField();
        jtxtName = new javax.swing.JTextField();
        jLabelConfiguracion = new javax.swing.JLabel();
        jtxtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setLayout(null);

        setPreferredSize(new java.awt.Dimension(680, 230));
        jlabelUrl.setText(AppLocal.getIntString("label.erpurl"));
        add(jlabelUrl);
        jlabelUrl.setBounds(20, 40, 130, 15);

        jLabelId.setText(AppLocal.getIntString("label.erpid"));
        add(jLabelId);
        jLabelId.setBounds(20, 70, 130, 15);

        jLabelName.setText(AppLocal.getIntString("label.erpuser"));
        add(jLabelName);
        jLabelName.setBounds(20, 160, 130, 15);

        jLabelProperties.setText(AppLocal.getIntString("label.erppassword"));
        add(jLabelProperties);
        jLabelProperties.setBounds(20, 190, 130, 15);

        add(jtxtUrl);
        jtxtUrl.setBounds(150, 40, 380, 19);

        add(jtxtId);
        jtxtId.setBounds(150, 70, 180, 19);

        add(jtxtName);
        jtxtName.setBounds(150, 160, 180, 19);

        jLabelConfiguracion.setText(AppLocal.getIntString("label.configerp"));
        jLabelConfiguracion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(jLabelConfiguracion);
        jLabelConfiguracion.setBounds(20, 10, 660, 16);

        add(jtxtPassword);
        jtxtPassword.setBounds(150, 190, 180, 20);

        jLabel1.setText(AppLocal.getIntString("label.erporg"));
        add(jLabel1);
        jLabel1.setBounds(20, 100, 130, 15);

        add(jTextField1);
        jTextField1.setBounds(150, 100, 180, 20);

        jLabel2.setText(AppLocal.getIntString("label.erppos"));
        add(jLabel2);
        jLabel2.setBounds(20, 130, 130, 15);

        add(jTextField2);
        jTextField2.setBounds(150, 130, 180, 19);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelConfiguracion;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelProperties;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel jlabelUrl;
    private javax.swing.JTextField jtxtId;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JPasswordField jtxtPassword;
    private javax.swing.JTextField jtxtUrl;
    // End of variables declaration//GEN-END:variables
    
}
