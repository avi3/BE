/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Text;

/**
 *Class to represent line
 * @author חיים
 */
public class Line implements Comparable<Line>{
    private int lineNumber;
    private int tabsStart;
    private String text;

    /**
     * constractor
     * @param text
     * @param number 
     */
    public Line(String text, int number) {
        this.text = text;
        this.lineNumber = number;
    }
    
    /**
     *function to override "compare to"
     * @param otherLine
     * @return 0 if same line number, greater than 0 if this line comes after the other line
     * less than 0 if this line is before other line
     */
    @Override
    public int compareTo(Line otherLine) {
        return this.lineNumber - otherLine.lineNumber;
    }
    /**
     * @return the lineNumber
     */
    public int getLineNumber() {
        return lineNumber;
    };
    

    /**
     * @param lineNumber the lineNumber to set
     */
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * @return the tabsStart
     */
    public int getTabsStart() {
        return tabsStart;
    }

    /**
     * @param tabsStart the tabsStart to set
     */
    public void setTabsStart(int tabsStart) {
        this.tabsStart = tabsStart;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
}
