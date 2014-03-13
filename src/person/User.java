/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

import java.util.ArrayList;
import Text.*;

/**
 * Class that represents a user
 *
 * @author g
 */
public class User implements Friend, NotFriend {
    private static int nextId = 0;
    private int id;
    private String useranme;
    private String password;
    private String email_address;
    private ArrayList<Integer> friends;
    
    
    private ArrayList<> invitations;
    private ArrayList<Code> mycodes;//להחליף את סטרינג למחלקה קוד או מזהה מספרי של קוד
    
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
        this.useranme = username;
        this.email_address = email_address;
        this.id = assignId();
    }
    
    /**
     * function to add friend
     * @param friendId 
     */
    public void addFriend(int friendId){
        if (friendId >= nextId)
            throw new IllegalArgumentException("friend id out of range");
        for (Integer id : friends) {
            if (id.intValue() == friendId)
                throw new IllegalArgumentException("already in frieds list");
        }
        if (!friends.add(friendId))
            throw new ArrayStoreException();
    }
    
    public void removeFriend(int friendId) {
        for (Integer id : friends)
            if (id == friendId)
                friends.remove(id);
    }
    
    /**
     * get my friends
     * @return 
     */
    public ArrayList<Integer> getIdFRiend(){
        return idFriends ; 
    }
    
    /**
     * function to add code
     * @param code 
     */
    public void addcode(String code){//להחליף את סטרינג למחלקה קוד או מזהה מספרי של קוד
        mycods.add(code);
    }
    
    /**
     * get my cods
     * @return 
     */
    public ArrayList<String> getMyCods(){
        return mycods; //להחליף את סטרינג למחלקה קוד או מזהה מספרי של קוד
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
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the useranme
     */
    public String getUseranme() {
        return useranme;
    }

    /**
     * @param useranme the useranme to set
     */
    public void setUseranme(String useranme) {
        this.useranme = useranme;
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
    public ArrayList<Friend> getFriends() {
        return Friends;
    }

    /**
     * @param Friends the Friends to set
     */
    public void setFriends(ArrayList<Friend> Friends) {
        this.Friends = Friends;
    }

    /**
     * @return the invitations
     */
    public ArrayList<> getInvitations() {
        return invitations;
    }

    /**
     * @param invitations the invitations to set
     */
    public void setInvitations(ArrayList<> invitations) {
        this.invitations = invitations;
    }

    /**
     * @return the mycodes
     */
    public ArrayList<Code> getMycodes() {
        return mycodes;
    }

    /**
     * @param mycodes the mycodes to set
     */
    public void setMycodes(ArrayList<Code> mycodes) {
        this.mycodes = mycodes;
    }
}
