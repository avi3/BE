/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccessObject;

import person.*;
import Text.*;
import java.util.ArrayList;
import java.util.List;


/**
 *simple implementation data
 * @author g
 */
public class Backend_DAO_List_impl {
    private List<User> _Users;
    private List<Code> _Codes;
    private List<Invitation> _Invitations; 
    
    
    public Backend_DAO_List_impl(){
        _Users = new ArrayList<User>();
        _Codes = new ArrayList<Code>();
        _Invitations= new ArrayList<Invitation>();
    }
    
    /**
     * Function to add user
     * @param tmp
     * @throws Exception 
     */
    public void AddUser(User tmp) throws Exception {
        _Users.add(tmp);
    }
    
    /**
     * @return all users()
     * @throws Exception 
     */
    public ArrayList<User> GetAllUsers() throws Exception {
        return (ArrayList<User>) _Users;
    }
    
   
    /**
     * Function to add code
     * @param tmp
     * @throws Exception 
     */
    public void AddCode(Code tmp) throws Exception {
        _Codes.add(tmp);
    }
    
    /**
     * @return all codes()
     * @throws Exception 
     */
    public ArrayList<Code> GetAllCodes() throws Exception {
        return (ArrayList<Code>) _Codes;
    }
    
   
    /**
     * Function to add invitation
     * @param tmp
     * @throws Exception 
     */
    public void AddInvitation(Invitation tmp) throws Exception {
        _Invitations.add(tmp);
    }
    
    /**
     * @return all invitations()
     * @throws Exception 
     */
    public ArrayList<Invitation> GetAllInvitations() throws Exception {
        return (ArrayList<Invitation>) _Invitations;
    }
    
    
    
    
}
