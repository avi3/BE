/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Text.Code;
import java.util.ArrayList;
import person.Invitation;
import person.User;

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
     * @return all users()
     * @throws Exception 
     */
    public abstract ArrayList<User> GetAllUsers() throws Exception;
    
   
    /**
     * Function to add code
     * @param tmp
     * @throws Exception 
     */
    public abstract void AddCode(Code tmp) throws Exception;
    
    /**
     * @return all codes()
     * @throws Exception 
     */
    public abstract ArrayList<Code> GetAllCodes() throws Exception;
    
   
    /**
     * Function to add invitation
     * @param tmp
     * @throws Exception 
     */
    public abstract void AddInvitation(Invitation tmp) throws Exception;
    
    /**
     * @return all invitations()
     * @throws Exception 
     */
    public abstract ArrayList<Invitation> GetAllInvitations() throws Exception;
    
    /**
     * Function to remove code by author
     * @param id
     * @throws Exception 
     */
    public abstract void RemoveCode(int id) throws Exception;
    
     /**
     * Function to remove user by id
     * @param id
     * @throws Exception 
     */
    public abstract void RemoveUser(int id) throws Exception;
       
    
     /**
     * Function to remove invitation by id of invater
     * @param id
     * @throws Exception 
     */
    public abstract void RemoveInvitation(int id) throws Exception;
      
}
