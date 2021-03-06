/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

import java.util.List;

import Text.*;
import java.util.ArrayList;

/**
 * Class that represents a user
 *
 * @author g
 */
public class User implements Friend, NotFriend {
   

    
    private  int  id;
    private String username;
    private String password;
    private String emailAddress;
    private List<Friend> friends;
    private boolean isOnline;
    
    
    private List<Invitation> pendingInvitations;
    private List<Invitation> outGoingInvitations;
    private List<Code> codes;
    
    
    /**
     * function to add coment
     * @param commentator
     * @param code
     * @param lineNumber
     * @param commentText
     * @throws InstantiationException 
     */
    @Override
    public void addComment(User commentator, Code code, int lineNumber, String commentText) throws Exception 
     {
        boolean hisCode = false;
        
        for (Code c : codes) {
            if (c == code)
                hisCode = true;
        }
        if (!hisCode)
            throw new IllegalArgumentException("Code not of this friend");
        
        code.addComment(new Comment(commentator, commentText, code, lineNumber ));
    }
     
    
    /**
     * function to update details
     * @param user 
     */
    public void update(User user) {
        if (this.getId() != user.getId())
            throw new IllegalArgumentException("not the same user");
        this.codes = user.getMyCodes();
        this.emailAddress = user.emailAddress;
        this.username = user.username;
        this.friends = user.getFriends();
        this.password= user.password;
        this.pendingInvitations = user.getPendingInvitations();
        this.outGoingInvitations = user.getOutGoingInvitations();
        this.isOnline = user.isOnline();
    }
    
    /**
     * function to invite friend
     * @param inviter 
     */
    @Override
    public void invite(User inviter) {
        for (Invitation invit : pendingInvitations) {
            if (invit.getInviter().getId() == inviter.getId())
                throw new IllegalArgumentException("friend was already invited");
        }
        addPendingInvitation(new Invitation(inviter, this));
        
    }
    
  
   /**
    * Function to verify the validity of strings
    * @param s
    * @return 
    */
    private boolean hasChar(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ||
                    (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'))
                return true;
        return false;
    }
    
    /**
     * Function to verify the validity of numbers
     * @param s
     * @return 
     */
    private boolean hasDigit(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                return true;
        return false;
    }
    
    /**
     *     Function to verify the validity of password
     * @param password 
     */
    private void validatePassword(String password) throws Exception {
        if (!hasDigit(password) || !hasChar(password))
            throw new Exception("Password must contain letters and digits");
    }
    
    /**
     * constractor
     * @param username
     * @param password
     * @param emailAddress 
     * @throws java.lang.Exception 
     */
    public User(String username, String password, String emailAddress) throws Exception {
        validatePassword(password);
        this.password = password;
        this.username = username;
        this.emailAddress = emailAddress;
        this.codes = new ArrayList<Code>();
        this.friends = new ArrayList<Friend>();
        this.outGoingInvitations = new ArrayList<Invitation>();
        this.pendingInvitations = new ArrayList<Invitation>();
        
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
    
    /**
     * function to remove friend
     * @param friend 
     */
    public void removeFriend(Friend friend) {
        for (Friend f : getFriends())
            if (f.getId() == friend.getId())
                getFriends().remove(f);
        throw new IllegalArgumentException("not in friends list");
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
    
    /**
     * function to remove code
     * @param code 
     */
    public void removeCode(Code code) {
        for (Code tmp : codes) {
            if (tmp.getCodeId() == code.getCodeId())
                codes.remove(tmp);
            return;
        }
        throw new IllegalArgumentException("this code doesn't belong to this user");
    }
    
    /**
     * function to update code
     * @param code 
     */
    public void updateCode(Code code) {
        for (Code tmp : codes) {
            if (tmp.getCodeId() == code.getCodeId())
                tmp.update(code);
            return;
        }
        throw new IllegalArgumentException("code not found");
    }
    
    /**
     * function to update out going invitations
     * @throws Exception 
     */
    public void updateoutGoingInvitations() throws Exception {
        for (Invitation invitation : outGoingInvitations) {
            if (invitation.isApproved()) {
                addFriend(invitation.getApprovedFriend(this));
                removeOutgoingInvitation(invitation);
            }
        }
    }
    
    /**
     * function to add pending invitation
     * @param newInvitation 
     */
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
   
    
    /**
     * function to remove pending invitation
     * @param pending 
     */
    public void removePendingInvitation(Invitation pending) {
        for (Invitation tmp : pendingInvitations) {
            if (tmp == pending)
                pendingInvitations.remove(tmp);
        }
        throw new IllegalArgumentException("pending invitation not found");
    }
    
    /**
     * function to add out going invitation
     * @param newInvitation 
     */
    public void addOutGoingInvitation(Invitation newInvitation) {
        if (newInvitation.getInviter().getId() != this.getId())
            throw new IllegalArgumentException("inviter mismatch");
        for (Invitation tmp : outGoingInvitations) {
            if (tmp.getNewFriend().getId() == newInvitation.getNewFriend().getId())
                throw new IllegalArgumentException("you already invited this user");
        }
        if (!outGoingInvitations.add(newInvitation))
            throw new ArrayStoreException();
    }
    
    /**
     * function to remove out going invitation
     * @param pending 
     */
    public void removeOutgoingInvitation(Invitation pending) {
        for (Invitation tmp : outGoingInvitations) {
            if (tmp == pending)
                outGoingInvitations.remove(tmp);
        }
        throw new IllegalArgumentException("outgoing invitation not found");
    }
    
    /**
     * get my cods
     * @return 
     */
    public List<Code> getMyCodes(){
        return codes;
    }
    
    
    
   
    /**
     * @return the id
     */
    @Override
    public int getId() {
        return id;
    }

    

    /**
     * @return the username
     */
    @Override
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
    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param email_address the email_address to set
     */
    public void setEmailAddress(String email_address) {
        this.emailAddress = emailAddress;
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

    
    /**
     * @return the friend code
     */
    @Override
    public List<Code> getFriendCodes() {
        List<Code> toFriend = new ArrayList();
    
        for (Code c : codes) {
            if (c.getPermission() == Permissions.ALL ||
                    c.getPermission() == Permissions.FRIENDS
                    /* || c.getPermission() == Permissions.REQUEST*/)
                toFriend.add(c);
        }
        return toFriend;
    }

   /**
    * @return the not friend code
    */ 
    @Override
    public List<Code> getNotFriendCodes() {
        List<Code> toFriend = new ArrayList();
    
        for (Code c : codes) {
            if (c.getPermission() == Permissions.ALL)
                toFriend.add(c);
        }
        return toFriend;
    }

    /**
     * @return the isOnline
     */
    @Override
    public boolean isOnline() {
        return isOnline;
    }

    /**
     * @param isOnline the isOnline to set
     */
    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /**
     *override the to string
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
       sb.append("id: " + id + " username: "  + username + " password: " + password + " email: " + emailAddress + " codes: ");
      for (Code c : codes)
            sb.append(c.getCodeId());
        return sb.toString();
    }

    
    
        
   
    

    
 
}
