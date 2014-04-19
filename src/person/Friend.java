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
     * @return the friend code
     */
    public abstract List<Code> getFriendCodes(); 
 
    /**
     * function to add coment
     * @param commentator
     * @param code
     * @param lineNumber
     * @param commentText
     * @throws InstantiationException 
     */
    public abstract void addComment(User commentator, Code code, int lineNumber, String commentText) throws Exception ;
    
     /**
     * @return the id
     */
    public abstract int getId();
    
    
    /**
     * @return the username
     */
    public abstract String getUsername();
    
    /**
     *
     * @return
     */
    public abstract String getEmailAddress();
    
    
    public abstract boolean isOnline();
}