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

    public abstract List<Code> getFriendCodes(); 
    public abstract void addComment(User commentator, Code code, int lineNumber, String commentText) throws InstantiationException ;
    public abstract int getId();
    public abstract String getUsername();
}