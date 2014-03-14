/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

import java.util.List;
import Text.Code;
/**
 *Represents a user who is not a friend
 * @author g
 */
public interface Friend {
/**
 * Make a comment of friend
      * @param myCommant
 */
    public abstract List<Code> getCodes();
    void Comments(Code code, int lineNumber, String commentText);
    public int getId();
    public String getUsername();
}