/*
 * Copyright (C) 2014 Mark Grant
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*########################################################################
##									##
## Class ID: AlarmClockHelpAboutJDialog					##
## Author: Mark Grant							##
##									##
## Further Info:							##
##									##
##########################################################################

##########################################################################
##									##
## Changelog								##
##									##
## Date		Author	Version	Description				##
##									##
## 09/12/2015	MG	1.0.3	Introduced in-source ChangeLogs.	##
##									##
##########################################################################
*/

package alarmclock;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * Class to display a Help | About Swing modal dialog form.
 * @author Mark Grant
 * @version 1.0.3
 */
public class AlarmClockHelpAboutJDialog extends javax.swing.JDialog {

    public BufferedImage alarmClockImage;

    /**
     * Creates new form AlarmClockHelpAboutJDialog
     * @param parent The parent frame.
     * @param modal Modal behaviour true / false.
     */
    public AlarmClockHelpAboutJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        // Initialise icon for use in frame borders etc..
        try {
            alarmClockImage = ImageIO.read(this.getClass().getResource("AlarmClock.png"));
        }
        catch (Exception e) { }

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

        helpAboutjScrollPane = new javax.swing.JScrollPane();
        helpAboutjTextArea = new javax.swing.JTextArea();
        OKjButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About AlarmClock");
        setModal(true);
        setName("AlarmClockHelpAboutJDialog"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        helpAboutjTextArea.setEditable(false);
        helpAboutjTextArea.setColumns(20);
        helpAboutjTextArea.setRows(5);
        helpAboutjScrollPane.setViewportView(helpAboutjTextArea);

        OKjButton.setText("OK");
        OKjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(helpAboutjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OKjButton)
                .addGap(239, 239, 239))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(helpAboutjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(OKjButton)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event handler to close the form when the OK button is actioned.
     * @param evt Event object.
     */
    private void OKjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKjButtonActionPerformed
        dispose();
    }//GEN-LAST:event_OKjButtonActionPerformed

    /**
     * Event handler when window opened. Retrieve & display Help | About details.
     * @param evt Event object.
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        int fileByte;
        String text = "";

        try(InputStream fis = this.getClass().getResourceAsStream("AlarmClockAbout.txt")) {
            do {
                fileByte = fis.read();
                if (fileByte != -1) text += (char) fileByte;
            } while (fileByte != -1);
            this.helpAboutjTextArea.setText(text);
            this.helpAboutjTextArea.setCaretPosition(0);
        }
        catch (Exception e) { }
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlarmClockHelpAboutJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlarmClockHelpAboutJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlarmClockHelpAboutJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlarmClockHelpAboutJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                AlarmClockHelpAboutJDialog dialog = new AlarmClockHelpAboutJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton OKjButton;
    private javax.swing.JScrollPane helpAboutjScrollPane;
    private javax.swing.JTextArea helpAboutjTextArea;
    // End of variables declaration//GEN-END:variables
}
