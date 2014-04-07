/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java_5774_5999_2188_gui;

import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import person.Friend;
import person.User;

/**
 *
 * @author חיים
 */
public class FriendsModel extends AbstractTableModel {

    List<User> users;
    List<Friend> friends;
    String titles[] = new String[] {"Name", "Email", "# of codes", "ONLINE"};

    public FriendsModel(List<Friend> friends) {
        this.friends = friends;
        this.users = null;
    }
    
   public FriendsModel(List<User> users, boolean just) {
        this.friends = null;
        this.users = users;
    }
    
    @Override
    public int getRowCount() {
        if (friends != null)
        return friends.size();
        else
            return users.size();
    }

    @Override
    public int getColumnCount() {
       return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Friend friend;
        if (friends != null)
            friend = friends.get(row);
        else
            friend = users.get(row);
        switch (column) {
            case 0:
                return friend.getUsername();
            case 1:
                return friend.getEmailAddress();
            case 2:
                return friend.getFriendCodes().size();
            case 3:
                return friend.isOnline();
                
        }
        return null;
    }
    
    public String getColumnName(int col) {
        return titles[col];
    }
}

