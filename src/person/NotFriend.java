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
public interface NotFriend {
    
    public abstract void invite(User inviter);
    public abstract List<Code> getCodes();
    public int getId();
    public String getUsername();
}
