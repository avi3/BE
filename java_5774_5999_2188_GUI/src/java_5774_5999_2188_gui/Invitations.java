/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java_5774_5999_2188_gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import person.Invitation;
import person.User;
/**
 *
 * @author חיים
 */
public class Invitations extends javax.swing.JFrame {
User user;
List<Invitation> pendings;
List<Invitation> outgoing;
    /**
     * Creates new form Invitations
     */
    public Invitations(User user) {
        initComponents();
        try {
        this.user = user;
        
        this.pendings = getPendings();
        this.outgoing = getOutgoings();
        
             updateTable(outgoing, outgoingTable);
            updateTable(pendings, pendingTable);
            
           
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
public List<Invitation> getPendings() throws Exception{
    List<Invitation> all = login.dataBase.GetAllInvitations();
        List<Invitation> pendings = new ArrayList<>();
        for (Invitation i : all) {
            if (i.getNewFriend().getId() == user.getId()  && !i.isApproved())
                pendings.add(i);
        }
        return pendings;
}
    
    public List<Invitation> getOutgoings() throws Exception{
    List<Invitation> all = login.dataBase.GetAllInvitations();
        List<Invitation> outgoing = new ArrayList<>();
        for (Invitation i : all) {
            if (i.getInviter().getId() == user.getId())
                outgoing.add(i);
        }
        return outgoing;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pendingLabel = new javax.swing.JLabel();
        outGoingLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pendingTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        outgoingTable = new javax.swing.JTable();
        approveButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pendingLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pendingLabel.setText("These  users want to be your friends:");

        outGoingLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        outGoingLabel.setText("People you invited:");

        pendingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(pendingTable);

        outgoingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(outgoingTable);

        approveButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        approveButton.setText("Approve selected");
        approveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        logo.setBackground(new java.awt.Color(153, 153, 255));
        logo.setFont(new java.awt.Font("Aharoni", 1, 48)); // NOI18N
        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setText("Filesbook");
        logo.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(outGoingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(pendingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(approveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, Short.MAX_VALUE)
                        .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(pendingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(outGoingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveButtonActionPerformed
/*try {
            if (pendingTable.getSelectedRow() < 0)
                throw new Exception("Please select invitaion to approve");
            int friendId = pendings.get(pendingTable.getSelectedRow()).getInviter().getId();
            login.dataBase.approveInvitation(user.getId(), friendId);
            JOptionPane.showMessageDialog(null, "you are now friends with " + login.dataBase.GetUser(friendId).getUsername() + "!");
           pendings = getPendings();
            updateTable(pendings, pendingTable);
}
catch (Exception e) {
    JOptionPane.showMessageDialog(null, e.getMessage());
}*/
        try {
            if ((pendingTable.getSelectedRow() < 0)&&(pendings.size()!=1))
                throw new Exception("Please select invitaion to approve");
            int friendId;
            if (pendings.size()==1)
                friendId = pendings.get(0).getInviter().getId();
            else
                friendId = pendings.get(pendingTable.getSelectedRow()).getInviter().getId();
            login.dataBase.approveInvitation(user.getId(), friendId);
            JOptionPane.showMessageDialog(null, "you are now friends with " + login.dataBase.GetUser(friendId).getUsername() + "!");
           pendings = getPendings();
            updateTable(pendings, pendingTable);
}
catch (Exception e) {
    JOptionPane.showMessageDialog(null, e.getMessage());
}
    }//GEN-LAST:event_approveButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

   public void updateTable(List<Invitation> invits, JTable table) {
       InvitationModel model = new InvitationModel(invits);
       table.setModel(model);
       table.getSelectionModel().setSelectionInterval(-1, -1);
       if (invits.isEmpty()) 
           approveButton.setEnabled(false);
       else{
           approveButton.setEnabled(true);
           if (invits.size()==1) 
               approveButton.setText("Approve");
           else
               approveButton.setText("Approve selected");
       }
       
       
           
   }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveButton;
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel outGoingLabel;
    private javax.swing.JTable outgoingTable;
    private javax.swing.JLabel pendingLabel;
    private javax.swing.JTable pendingTable;
    // End of variables declaration//GEN-END:variables
}
