/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java_5774_5999_2188_gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import person.Friend;
import person.Invitation;
import person.NotFriend;
import person.User;

/**
 *
 * @author חיים
 */
public class NotFriendModel extends AbstractTableModel  {

    List<NotFriend> users;
    User user;
    String titles[] = new String[] {"Name", "# of public codes", "status"};
    
    public NotFriendModel(List<NotFriend> users, User user) {
        this.users = users;
        this.user = user;
    }
    
    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        NotFriend notFriend = users.get(row);
        try {
        switch (column) {
            case 0:
                return notFriend.getUsername();
            case 1:
                return notFriend.getNotFriendCodes().size();
            case 2:
                ArrayList<Invitation> invit = login.dataBase.GetAllInvitations();
                for (Invitation i : invit) {
                    if (i.getInviter().getId() == user.getId() && i.getNewFriend().getId() == notFriend.getId() && !i.isApproved())
                        return "Invited by you";
                    if (i.getInviter().getId() == notFriend.getId() && i.getNewFriend().getId() == user.getId() && !i.isApproved())
                        return "Invited you";
                }
                
                for (Friend f : login.dataBase.GetUser(user.getId()).getFriends()) {
                    if (f.getId() == notFriend.getId())
                        return "Friend";
                }
                return "Not Friend";
                
                
        }
        return null;
    }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    @Override
    public String getColumnName(int col) {
        return titles[col];
    }
}
