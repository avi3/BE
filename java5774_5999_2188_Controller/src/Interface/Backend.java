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

    /**
     * function to update user
     * @param user 
     */
    public abstract void updateUser(User user);
    
    
     /**
     * function to get user
     * @param id
     * @return 
     */public abstract User GetUser(int id);
    
    
      /**
     * function to get user
     * @param username
     * @param password
     * @return 
     */
     public abstract User GetUser(String username, String password);
    
     
     /**
     * @return all users()
     * @throws Exception 
     */
    public abstract ArrayList<User> GetAllUsers() throws Exception;
    
   /**
     * function to grt friends
     * @param userId
     * @return 
     */
    public abstract ArrayList<Friend> getFriends(int userId);
   
   /**
     * function to get alluser
     * @return 
     */
    public abstract ArrayList<NotFriend> getAllUsers() ;
   
   /**
     * function to assign code according to id
     * @param code 
     */
    public abstract void assignCodeId(Code code);
   
    /***
     * function to assign user according to id
     * @param user 
     */
   public abstract void assignUserId(User user);
   
    
    /**
     * Function to add code
     * @param tmp
     * @throws Exception 
     */
   public abstract void AddCode( Code tmp) throws Exception;
    
 /**
 * function to update code
 * @param code 
 */
    public abstract void updateCode(Code code);
    
    /**
     * @return all codes()
     * @throws Exception 
     */
    public abstract ArrayList<Code> GetAllCodes() throws Exception;
    
    /**
     * function to remove invitation
     * @param inviter
     * @param invited
     * @throws Exception 
     */
    public abstract ArrayList<Code> GetAllUserCodes(int userId);
    
    /**
     * function to get user code
     * @param userId
     * @param isFriend
     * @return
     * @throws Exception 
     */
    public abstract List<Code> GetUserCodes(int user, boolean isFriend) throws Exception;
    
   
    /**
     * function to add invite
     * @param inviterId
     * @param invitedId
     * @throws Exception 
     */
    public abstract void invite(int inviterId, int invitedId) throws Exception;
    
    /**
     * @return all invitations()
     * @throws Exception 
     */
    public abstract ArrayList<Invitation> GetAllInvitations() throws Exception;
    
    
    
    /**
     * function to get user out going
     * @param userId
     * @return 
     */
    public abstract List<Invitation> getUserOutGoing(int  userId);
    
    /**
     * function to get user pending
     * @param userId
     * @return 
     */
    public abstract List<Invitation> getUserPending(int  userId);
    
    /**
     * function to find approved friend
     * @param userId
     * @throws Exception 
     */
    public abstract void findApprovedFriends(int userId) throws Exception;
    
    /**
     * function to notify online
     * @param userId 
     */
    public abstract void notifyOnline(int userId);
    
    /**
     * function to approve invitation
     * @param approver
     * @param invited
     */
    public abstract void approveInvitation(int approver, int invited);
   
    /**
     * Function to remove code by author
     * @param codeId
     * @throws Exception 
     */
    public abstract void RemoveCode(int codeId) throws Exception;
    
     /**
     * Function to remove user by id
     * @param id
     * @throws Exception 
     */
    public abstract void RemoveUser(int id) throws Exception;
       
    
     
     /**
     * function to remove invitation
     * @param inviter
     * @param invited
     * @throws Exception 
     */
    public abstract void RemoveInvitation(int inviter, int invited) throws Exception;
      
}
