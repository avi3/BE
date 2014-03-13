/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Text;
//import java.lang.String;
import java.util.Collections;
import java.util.List;
import java.util.Date;
/**
 *
 * @author חיים
 */
        
public class Text {
  private List<Line> lines;
  private int author_id;
  private Date creationDate;
  
  private void parse_lines(String text) {
      int beginIndex = 0, endIndex = 0;
      int lineNumber = 0;
      
      while (endIndex < text.length()) {
          endIndex = text.indexOf("\n");
          Line tmp = new Line(text.substring(beginIndex, endIndex), lineNumber);
          lineNumber++;
          beginIndex = endIndex + 1;
          if  (!lines.add(tmp))
              throw new ArrayStoreException();
      }
  }
  
  public void setLineNumbers(int initialLine, int initNumber) {
      for (Line l : getLines().subList(initialLine, getLines().size()))
          l.setLineNumber(initNumber++);
  }
  
  public Text(User author, String text) throws InstantiationException{
      this.creationDate = new Date();
      this.author_id = author.author_id;
      try {
          parse_lines(text);
      }
       catch (ArrayStoreException e) {
           throw new InstantiationException();
       }
  }
 
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
  
  public void addLine(Line newLine) {
      for (Line l : getLines()) {
          if (l.getLineNumber() == newLine.getLineNumber())
              throw new IllegalArgumentException();
      }
      if (!lines.add(newLine))
          throw new ArrayStoreException();
  }
  
  /* remove range of lines. including start & end */
  public void removeLine(int start, int end) {
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
 