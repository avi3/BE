/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java_5774_5999_2188_gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import person.Invitation;

/**
 *
 * @author חיים
 */
public class InvitationModel extends AbstractTableModel  {

    List<Invitation> invits;
    String titles[] = new String[] {"Inviter Name", "Invited Name", "Date invited"};

    public InvitationModel(List<Invitation> invits) {
        this.invits = invits;
    }
    
    
    @Override
    public int getRowCount() {
        return invits.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Invitation invit = invits.get(row);
        
        switch (column) {
            case 0:
                return invit.getInviter().getUsername();
            case 1:
                return invit.getNewFriend().getUsername();
            case 2:
                return invit.getInvitationDate().toString();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int col) {
        return titles[col];
    }
    
}
