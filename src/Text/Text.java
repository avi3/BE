/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Text;
//import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;
import person.*;

/**
 *Class to represent text
 * @author חיים
 */
        
public class Text {
  protected List<Line> lines;
  private int author_id;
  private final Date creationDate;
  
  /**
   * funtion to update text
   * @param text 
   */
  public void update(Text text) {
      this.author_id = text.getAuthor_id();
      this.lines = text.getLines();
  }
  
  /**
   * function to parse line
   * @param text 
   */
  private void parse_lines(String text) throws Exception {
      int endIndex = 1;
      int lineNumber = 0;
      while (endIndex >= 0) {
          String s = text;
          endIndex = text.indexOf("\n");
          if (endIndex > 0)
              s = text.substring(0, endIndex);
          else if (endIndex == 0)
              s = "";
          
          Line tmp = new Line(s, lineNumber);
          
          lineNumber++;
          text = text.substring(endIndex + 1, text.length());
          if  (!lines.add(tmp))
              throw new Exception("problem");
      }
  }
  /**
   * function to set line number
   * @param initialLine
   * @param initNumber 
   */
  public void setLineNumbers(int initialLine, int initNumber) {
      if (lines.size() < initialLine)
          throw new IllegalArgumentException("line number out of range");
      for (Line l : getLines().subList(initialLine, getLines().size()))
          l.setLineNumber(initNumber++);
  }
  /**
   * constractor
   * @param author
   * @param text
   * @throws InstantiationException 
   */
  public Text(User author, String text) throws Exception{
      this.creationDate = new Date();
      this.author_id = author.getId();
      
      this.lines = new ArrayList<Line>();
      
      try {
          parse_lines(text);
      }
       catch (Exception e) {
           throw new Exception(e.getMessage());
       }
  }
 /**
  * function to override "to string"
  * @return 
  */
  @Override
  public String toString()
  {
      Collections.sort(getLines());
      StringBuilder sb = new StringBuilder();
      for (Line l : getLines()) {
          sb.append(l.getText());
      }
      return sb.toString();
  }
  
  /**
   * function to add line
   * @param newLine 
   */ 
  public void addLine(Line newLine) {
      if (newLine.getLineNumber() < 0)
          throw new IllegalArgumentException("negative line number");
      if (newLine.getLineNumber() > lines.size() + 1)
          throw new IllegalArgumentException("line number not in sequence");
      for (Line l : getLines()) {
          if (l.getLineNumber() == newLine.getLineNumber())
              throw new IllegalArgumentException("line number " + newLine.getLineNumber() + " exists");
      }
      if (!lines.add(newLine))
          throw new ArrayStoreException();
      /* keep lines sorted */
      Collections.sort(lines);
  }
  
  /**
   * remove range of lines
   * @param start
   * @param end 
   */
  /* remove range of lines. including start & end */
  public void removeLines(int start, int end) {
      if (start < 0 || end > lines.size())
          throw new IllegalArgumentException("remove lines: range error");
        setLineNumbers(end + 1, start);
        getLines().subList(start, end).clear();
  }

    /**
     * @return the lines
     */
    public List<Line> getLines() {
        return lines;
    }

    /**
     * @param lines the lines to set
     */
    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    /**
     * @return the author_id
     */
    public int getAuthor_id() {
        return author_id;
    }

    /**
     * @param author_id the author_id to set
     */
    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

 
}
 