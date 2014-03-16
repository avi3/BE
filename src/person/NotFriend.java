/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

import Text.Code;
import java.util.List;


/**
 *Represents a user who is not a friend
 * @author g 
 */
public interface NotFriend {
    
    /**
     * function to invite friend
     * @param inviter 
     */
    /* invite this not friend to be a friend of the specified User */
    public abstract void invite(User inviter);
    
    /**
    * @return the not friend code
    */ 
    public abstract List<Code> getNotFriendCodes();
    
     /**
     * @return the id
     */
    public int getId();
    
    
    /**
     * @return the username
     */
    public String getUsername();
}
