//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2008 Openbravo, S.L.
//    http://sourceforge.net/projects/openbravopos
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

package com.openbravo.pos.sales;

import com.openbravo.pos.customers.DataLogicCustomers;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.ticket.TicketInfo;
import com.openbravo.pos.ticket.TicketLineInfo;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.JFrame;

/**
 *
 * @author  adrianromero
 */
public class ReceiptSplit extends javax.swing.JDialog {
    
    private boolean accepted;
    
    SimpleReceipt receiptone;
    SimpleReceipt receipttwo;
    
    /** Creates new form ReceiptSplit */
    protected ReceiptSplit(java.awt.Frame parent, String ticketline, DataLogicSales dlSales, DataLogicCustomers dlCustomers) {
        super(parent, true);
        init(ticketline, dlSales, dlCustomers);
    }
    /** Creates new form ReceiptSplit */
    protected ReceiptSplit(java.awt.Dialog parent, String ticketline, DataLogicSales dlSales, DataLogicCustomers dlCustomers) {
        super(parent, true);
        init(ticketline, dlSales, dlCustomers);
    } 
    
    private void init(String ticketline, DataLogicSales dlSales, DataLogicCustomers dlCustomers) {
        
        initComponents();        
        getRootPane().setDefaultButton(m_jButtonOK); 
        
        receiptone = new SimpleReceipt(ticketline, dlSales, dlCustomers);
        receiptone.setCustomerEnabled(false);
        jPanel5.add(receiptone, BorderLayout.CENTER);
        
        receipttwo = new SimpleReceipt(ticketline, dlSales, dlCustomers);
        jPanel3.add(receipttwo, BorderLayout.CENTER);  
    }
    
    public static ReceiptSplit getDialog(Component parent, String ticketline, DataLogicSales dlSales, DataLogicCustomers dlCustomers) {
         
        Window window = getWindow(parent);
        
        if (window instanceof Frame) { 
            return new ReceiptSplit((Frame) window, ticketline, dlSales, dlCustomers);
        } else {
            return new ReceiptSplit((Dialog) window, ticketline, dlSales, dlCustomers);
        }
    } 
    
    protected static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window)parent;
        } else {
            return getWindow(parent.getParent());
        }
    }
    
    public boolean showDialog(TicketInfo ticket, TicketInfo ticket2, Object ticketext) {

        receiptone.setTicket(ticket, ticketext);
        receipttwo.setTicket(ticket2, ticketext);
        
        setVisible(true);    
        return accepted;
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        m_jButtonOK = new javax.swing.JButton();
        m_jButtonCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(AppLocal.getIntString("caption.split")); // NOI18N
        setResizable(false);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        m_jButtonOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/button_ok.png"))); // NOI18N
        m_jButtonOK.setText(AppLocal.getIntString("Button.OK")); // NOI18N
        m_jButtonOK.setFocusPainted(false);
        m_jButtonOK.setFocusable(false);
        m_jButtonOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonOK.setRequestFocusEnabled(false);
        m_jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonOKActionPerformed(evt);
            }
        });
        jPanel2.add(m_jButtonOK);

        m_jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/button_cancel.png"))); // NOI18N
        m_jButtonCancel.setText(AppLocal.getIntString("Button.Cancel")); // NOI18N
        m_jButtonCancel.setFocusPainted(false);
        m_jButtonCancel.setFocusable(false);
        m_jButtonCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonCancel.setRequestFocusEnabled(false);
        m_jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonCancelActionPerformed(evt);
            }
        });
        jPanel2.add(m_jButtonCancel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel5);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/2rightarrow.png"))); // NOI18N
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setMargin(new java.awt.Insets(8, 14, 8, 14));
        jButton1.setRequestFocusEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        jPanel4.add(jButton1, gridBagConstraints);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/1rightarrow.png"))); // NOI18N
        jButton5.setFocusPainted(false);
        jButton5.setFocusable(false);
        jButton5.setMargin(new java.awt.Insets(8, 14, 8, 14));
        jButton5.setRequestFocusEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jButton5, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/1leftarrow.png"))); // NOI18N
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.setMargin(new java.awt.Insets(8, 14, 8, 14));
        jButton2.setRequestFocusEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jButton2, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/2leftarrow.png"))); // NOI18N
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.setMargin(new java.awt.Insets(8, 14, 8, 14));
        jButton3.setRequestFocusEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jButton3, gridBagConstraints);

        jPanel1.add(jPanel4);

        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-730)/2, (screenSize.height-470)/2, 730, 470);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonOKActionPerformed

        if (receipttwo.getTicket().getLinesCount() > 0) {
            accepted = true;
            dispose();
        }

    }//GEN-LAST:event_m_jButtonOKActionPerformed

    private void m_jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonCancelActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_m_jButtonCancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        TicketLineInfo line = receiptone.getSelectedLine();
        if (line != null) {
            receipttwo.addSelectedLine(line);
        }       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        TicketLineInfo line = receiptone.getSelectedLineUnit();
        if (line != null) {
            receipttwo.addSelectedLine(line);
        }    
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        TicketLineInfo line = receipttwo.getSelectedLineUnit();
        if (line != null) {
            receiptone.addSelectedLine(line);
        }   
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        TicketLineInfo line = receipttwo.getSelectedLine();
        if (line != null) {
            receiptone.addSelectedLine(line);
        }   
        
    }//GEN-LAST:event_jButton3ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton m_jButtonCancel;
    private javax.swing.JButton m_jButtonOK;
    // End of variables declaration//GEN-END:variables
    
}
