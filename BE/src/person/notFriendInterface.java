/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

/**
 *Represents a user who is not a friend
 * @author g 
 */
public interface notFriendInterface {
    /**
     * Does person want to be my friend
     * @param idFriend
     * @return  
     */
    public abstract boolean becomeFriend(int idFriend);
}
