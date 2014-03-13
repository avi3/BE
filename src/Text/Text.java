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
  protected List<Line> lines;
  protected int author_id;
  protected Date creationDate;
  
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
      for (Line l : lines.subList(initialLine, lines.size()))
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
      Collections.sort(lines);
      StringBuilder sb = new StringBuilder();
      for (Line l : lines) {
          sb.append(l.getText());
      }
      return sb.toString();
  }
  
  public void addLine(Line newLine) {
      for (Line l : lines) {
          if (l.getLineNumber() == newLine.getLineNumber())
              throw new IllegalArgumentException();
      }
      if (!lines.add(newLine))
          throw new ArrayStoreException();
  }
  
  /* remove range of lines. including start & end */
  public void removeLine(int start, int end) {
        setLineNumbers(end + 1, start);
        lines.subList(start, end).clear();  
  }
}
 