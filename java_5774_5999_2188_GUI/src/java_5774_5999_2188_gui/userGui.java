/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java_5774_5999_2188_gui;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import person.Friend;
import person.User;

/**
 *
 * @author חיים
 */
public class userGui extends javax.swing.JFrame {
    User user;
    /**
     * Creates new form userGui
     */
    public userGui(User me) {
        initComponents();
        try {
        user = me;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	   //get current date time with Date()
	   Calendar cal = Calendar.getInstance();
	  dateText.setText(dateFormat.format(cal.getTime()));
        welcome.setText("Welcome, " + me.getUsername() + "!");
        login.dataBase.notifyOnline(me.getId(), true);
        List<Friend> friends = login.dataBase.findApprovedFriends(me.getId());
        if (friends.size() > 0) {
            StringBuilder sb  = new StringBuilder("You have " + friends.size() + " new friends!\n");
            for (Friend f : friends) {
                sb.append(f.getUsername() + " is now your friend.\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        logo = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        friends = new javax.swing.JLabel();
        codes = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateText = new javax.swing.JFormattedTextField();
        logOutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        logo.setBackground(new java.awt.Color(153, 153, 255));
        logo.setFont(new java.awt.Font("Aharoni", 1, 48)); // NOI18N
        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setText("Filesbook");
        logo.setOpaque(true);

        welcome.setFont(new java.awt.Font("Wide Latin", 1, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(0, 0, 255));
        welcome.setText("welcome");

        friends.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        friends.setText("My Friends");
        friends.setToolTipText("see your current friends, and invite new ones!");
        friends.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                friendsMouseClicked(evt);
            }
        });

        codes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        codes.setText("My Codes");
        codes.setToolTipText("see what your friends think of your published codes, and comment codes of others!");
        codes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                codesMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("My invitations");
        jLabel3.setToolTipText("see who invited you to be his/her friend!");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        dateText.setEditable(false);
        dateText.setBackground(new java.awt.Color(204, 204, 255));
        dateText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dateText.setForeground(new java.awt.Color(51, 51, 255));
        dateText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL))));

        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(friends, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codes, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(friends, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(codes, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void friendsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friendsMouseClicked
       /*try {
           JFrame friends = new friends(user);
           friends.setVisible(true);
       }
       catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error opening friends list");
       }*/
        try {
            if (login.dataBase.getAllAsNotFriend().size()!=1){
                JFrame friends = new friends(user);
                friends.setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(null, "Users no exist except you");
       }
       catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error opening friends list");
       }
        
    }//GEN-LAST:event_friendsMouseClicked

    private void codesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codesMouseClicked
Codes codes2 = new Codes(user.getId(), user.getId(), true, false);
codes2.setVisible(true);
    }//GEN-LAST:event_codesMouseClicked

    
    
    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed

        try {
        Invitations invit = new Invitations(user);
        if (invit.outgoing.isEmpty()&&invit.pendings.isEmpty())
            throw new Exception("Don't exist Invitations");
        invit.setVisible(true);
       }
       catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }//GEN-LAST:event_jLabel3MousePressed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
login.dataBase.notifyOnline(user.getId(), false);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_logOutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codes;
    private javax.swing.JFormattedTextField dateText;
    private javax.swing.JLabel friends;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton logOutButton;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}