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
        for (User user : _Users) 
            if (user.getId()== tmp.getId())
                throw new Exception("The user already exists");
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
    
     /**
     * Function to remove code by author
     * @param id
     * @throws Exception 
     */
    public void RemoveCode(int id) throws Exception {
        boolean flag=true;
        for (Code code : _Codes) 
            if (code.getAuthor_id()== id) {
                 _Codes.remove(code);
                 flag=false;
            }
         if (flag) throw new Exception("To this id number is not exit code");

    }
    
     /**
     * Function to remove user by id
     * @param id
     * @throws Exception 
     */
    public void RemoveUser(int id) throws Exception {
        boolean flag=true;
        for (User user : _Users) 
            if (user.getId()== id){ 
                 _Users.remove(user);
                 flag=false;
            }
        if (flag) throw new Exception("Id number is not in the list");
    }
    
     /**
     * Function to remove invitation by id of invater
     * @param id
     * @throws Exception 
     */
    public void RemoveInvitation(int id) throws Exception {
        boolean flag=true;
        for (Invitation invitation : _Invitations) 
            if (invitation.getInviter().getId()== id){ 
                 _Invitations.remove(invitation);
                 flag=false;
            }
         if (flag) throw new Exception("To this id number is not exit invitation");
    }
    
    
}
