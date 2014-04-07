/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java_5774_5999_2188_gui;

import Text.Code;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author חיים
 */
public class CodesModel extends AbstractTableModel{
List<Code> codes;
String titles[] = new String[] {"Subject", "Language", "Creation Date" };

public CodesModel(List<Code> codes) {
    this.codes = codes;
}
    @Override
    public int getRowCount() {
    return codes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return codes.get(row).getSubject();
            case 1:
                return codes.get(row).getLang();
            case 2:
                return codes.get(row).getCreationDate();
        }
        return null;
    }
    
    public String getColumnName(int col) {
        return titles[col];
    }
}
