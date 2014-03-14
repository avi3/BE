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
    
    /* invite this not friend to be a friend of the specified User */
    public abstract void invite(User inviter);
    public abstract List<Code> getNotFriendCodes();
    public int getId();
    public String getUsername();
}
