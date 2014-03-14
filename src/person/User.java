/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

import java.util.List;
import Text.*;

/**
 * Class that represents a user
 *
 * @author g
 */
public class User implements Friend, NotFriend {
    private static int nextId = 0;

    
    private final int  id;
    private String username;
    private String password;
    private String email_address;
    private List<Friend> friends;
    
    
    private List<Invitation> pendingInvitations;
    private List<Invitation> outGoingInvitations;
    private List<Code> codes;
    
   public static int assignId() {
        return nextId++;
    }
   
    private boolean hasChar(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ||
                    (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'))
                return true;
        return false;
    }
    
    private boolean hasDigit(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                return true;
        return false;
    }
    
    private void validatePassword(String password) {
        if (!hasDigit(password) || !hasChar(password))
            throw new IllegalArgumentException();
    }
    
    public User(String username, String password, String email_address) {
        validatePassword(password);
        this.password = password;
        this.username = username;
        this.email_address = email_address;
        this.id = assignId();
    }
    
    /**
     * function to add friend
     * @param newFriend 
     */
    public void addFriend(Friend newFriend) {
        for (Friend f : getFriends()) {
            if (f.getId() == newFriend.getId())
                throw new IllegalArgumentException("already in friends list");
        }
        if (!friends.add(newFriend))
            throw new ArrayStoreException();
    }
    
    public void removeFriend(Friend friend) {
        for (Friend f : getFriends())
            if (f.getId() == friend.getId())
                getFriends().remove(getId());
        throw new IllegalArgumentException("not in frieds list");
    }
    
    
    
    /**
     * function to add code
     * @param code 
     */
    public void addCode(Code code){
        if (code.getAuthor_id() != this.getId())
            throw new IllegalArgumentException("this code doesn't belong to this user");
        if (!codes.add(code))
            throw new ArrayStoreException();
    }
    public void removeCode(Code code) {
        for (Code tmp : codes) {
            if (tmp == code)
                codes.remove(code);
        }
        throw new IllegalArgumentException("this code doesn't belong to this user");
    }
    
    public void addPendingInvitation(Invitation newInvitation) {
        if (newInvitation.getNewFriend().getId() != this.getId())
            throw new IllegalArgumentException("invited mismatch");
        for (Invitation tmp : pendingInvitations) {
            if (tmp.getInviter().getId() == newInvitation.getInviter().getId())
                throw new IllegalArgumentException("invitation from this user already exists");
        }
        if (!pendingInvitations.add(newInvitation))
            throw new ArrayStoreException();
    }
   
    public void addOutGoingInvitation(Invitation newInvitation) {
        if (newInvitation.getInviter().getId() != this.getId())
            throw new IllegalArgumentException("invited mismatch");
        for (Invitation tmp : outGoingInvitations) {
            if (tmp.getNewFriend().getId() == newInvitation.getNewFriend().getId())
                throw new IllegalArgumentException("already invited this user");
        }
        if (!outGoingInvitations.add(newInvitation))
            throw new ArrayStoreException();
    }
    
    /**
     * get my cods
     * @return 
     */
    public List<Code> getMyCodes(){
        return codes;
    }
    
    @Override
    public void putComments(String myCommant) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param idFriend
     * @return
     */
    @Override
    public boolean becomeFriend(int idFriend) {
        return wantsFriend.indexOf(idFriend)!=-1;
    }
    
    /**
     *  friend request
     * @param id 
     */
    public void addWantsFriend(int id){
        wantsFriend.add(id);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the useranme to set
     */
    public void setUseranme(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email_address
     */
    public String getEmail_address() {
        return email_address;
    }

    /**
     * @param email_address the email_address to set
     */
    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    /**
     * @return the Friends
     */
    public List<Friend> getFriends() {
        return friends;
    }

    

    

    
    /**
     * @return the pendingInvitations
     */
    public List<Invitation> getPendingInvitations() {
        return pendingInvitations;
    }

    

    /**
     * @return the outGoingInvitations
     */
    public List<Invitation> getOutGoingInvitations() {
        return outGoingInvitations;
    }

    

}
