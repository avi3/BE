/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Text.Code;
import java.util.ArrayList;
import java.util.List;
import person.Invitation;
import person.*;

/**
 *
 * @author g
 */
public interface Backend {
    
        /**
     * Function to add user
     * @param tmp
     * @throws Exception 
     */
    public abstract void AddUser(User tmp) throws Exception;

    public abstract void updateUser(User user);
    
    public abstract User GetUser(int id);
    
    public abstract User GetUser(String username, String password);
    /**
     * @return all users()
     * @throws Exception 
     */
    public abstract ArrayList<User> GetAllUsers() throws Exception;
    
   public abstract ArrayList<Friend> getFriends(int userId);
   
   public abstract ArrayList<NotFriend> getAllUsers() ;
   
   public abstract void assignCodeId(Code code);
   
   public abstract void assignUserId(User user);
   
    public abstract void AddCode( Code tmp) throws Exception;
    
    public abstract void updateCode(Code code);
    
    /**
     * @return all codes()
     * @throws Exception 
     */
    public abstract ArrayList<Code> GetAllCodes() throws Exception;
    
    public abstract ArrayList<Code> GetAllUserCodes(int userId);
    public abstract List<Code> GetUserCodes(int user, boolean isFriend) throws Exception;
    
   
   
    public abstract void invite(int inviterId, int invitedId) throws Exception;
    
    /**
     * @return all invitations()
     * @throws Exception 
     */
    public abstract ArrayList<Invitation> GetAllInvitations() throws Exception;
    
    public abstract List<Invitation> getUserOutGoing(int  userId);
    public abstract List<Invitation> getUserPending(int  userId);
    
    
    
    public abstract void notifyOnline(int userId);
    
    public abstract void approveInvitation(int approver, int invited);
   
    public abstract void RemoveCode(int codeId) throws Exception;
    
     /**
     * Function to remove user by id
     * @param id
     * @throws Exception 
     */
    public abstract void RemoveUser(int id) throws Exception;
       
    
     
     
    public abstract void RemoveInvitation(int inviter, int invited) throws Exception;
      
}
