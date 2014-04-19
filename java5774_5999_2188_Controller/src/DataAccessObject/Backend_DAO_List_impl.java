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
import Interface.Backend;
import java.util.Date;
import java.util.Iterator;


/**
 *simple implementation data
 * @author g
 */
public class Backend_DAO_List_impl implements Backend{
    private List<User> _Users;
    private List<Code> _Codes;
    private List<Invitation> _Invitations; 
    private int nextCodeId = 1;
    private int nextUserId = 1;
    
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
    @Override   
    public void AddUser(User tmp) throws Exception {
        assignUserId(tmp);
        _Users.add(tmp);
    }
    
    /**
     * @return all users()
     * @throws Exception 
     */
    @Override
    public ArrayList<User> GetAllUsers() throws Exception {
        return (ArrayList<User>) _Users;
    }
    
   
    /**
     * Function to add code
     * @param tmp
     * @throws Exception 
     */
    @Override
    public void AddCode(Code tmp) throws Exception {
        assignCodeId(tmp);
        _Codes.add(tmp);
        for (User toAdd : _Users) {
            if (toAdd.getId() == tmp.getAuthor_id())
                toAdd.addCode(tmp);
        }
      
    }
    
    /**
     * @return all codes()
     * @throws Exception 
     */
    @Override
    public ArrayList<Code> GetAllCodes() throws Exception {
        return (ArrayList<Code>) _Codes;
    }
    
   
    
    
    /**
     * @return all invitations()
     * @throws Exception 
     */
    @Override
    public ArrayList<Invitation> GetAllInvitations() throws Exception {
        return (ArrayList<Invitation>) _Invitations;
    }
    
     /**
     * Function to remove code by author
     * @param codeId
     * @throws Exception 
     */
    @Override
    public void RemoveCode(int codeId) throws Exception {
        
        for (Code code : _Codes) 
            if (code.getCodeId() == codeId) {
                for (User user : _Users) {
                    if (user.getId() == code.getAuthor_id()) {
                        user.removeCode(code);
                        break;
                }
                }
                 _Codes.remove(code);
                 return;
            }
          throw new Exception("code not found");
           
    }
    
     /**
     * Function to remove user by id
     * @param id
     * @throws Exception 
     */
    @Override
    public void RemoveUser(int id) throws Exception {
       
        for (User user : _Users) 
            if (user.getId()== id){
                /* remove user codes */
                List<Code> codes = GetAllUserCodes(id);
                for (Code code : codes) {
                    _Codes.remove(code);
                }
                 _Users.remove(user);
                return;
            }
        throw new Exception("Id number is not in the list");
    }
    
    
    /**
     * function to update user
     * @param user 
     */
    @Override
    public void updateUser(User user) {
        User tmp = GetUser(user.getId());
        tmp.update(user);
    }

    /**
     * function to get user
     * @param id
     * @return 
     */
    @Override
    public User GetUser(int id) {
        for (User tmp : _Users) {
            if (tmp.getId() == id)
                return tmp;
        }
       throw new IllegalArgumentException("user not found"); 
    }
    
    /**
     * function to grt friends
     * @param userId
     * @return 
     */
    @Override
    public ArrayList<Friend> getFriends(int userId) {
        ArrayList<Friend> ret = new ArrayList<Friend>(); 
        User user = GetUser(userId);
        for (Friend friend : user.getFriends()) {
            try {
            ret.add(GetUser(friend.getId()));
            }
            catch (Exception e) {
                //ignore non exsitent friends
            }
        }
        return ret;
    }

    /**
     * function to get alluser
     * @return 
     */
    @Override
    public ArrayList<NotFriend> getAllAsNotFriend() {
        ArrayList<NotFriend> ret = new ArrayList<>();
        for (User user : _Users)
            ret.add(user);
        return ret;
    }

    
/**
 * function to update code
 * @param code 
 */
    @Override
    public void updateCode(Code code) throws Exception {
     
        
            Code toUpdate = getCode(code.getCodeId());
            
            toUpdate.update(code);
            for (User user : _Users) {
                if (user.getId() == code.getAuthor_id())
                    user.updateCode(code);
            }
        
    }

    /**
     * function to get user code
     * @param userId
     * @param isFriend
     * @return
     * @throws Exception 
     */
    @Override
    public List<Code> GetUserCodes(int userId, boolean isFriend) throws Exception {
        User user = GetUser(userId);
        
        if (isFriend)
            return ((Friend)user).getFriendCodes();
        else
            return ((NotFriend)user).getNotFriendCodes();
    }

    /**
     * function to add invite
     * @param inviterId
     * @param invitedId
     * @throws Exception 
     */
    @Override
    public void invite(int inviterId, int invitedId) throws Exception {
        User inviter  = GetUser(inviterId);
        NotFriend invited = GetUser(invitedId);
        for (Friend f : inviter.getFriends()) {
            if (f.getId() == invitedId)
                throw new Exception("You are already a friend of " + f.getUsername());
        }
        if (invitedId == inviterId)
            throw new Exception("you can't invite yourself, ha?");
        for (Invitation i : _Invitations) {
            if (i.getInviter().getId() == inviterId && i.getNewFriend().getId() == invitedId )
                throw new Exception("You already invited " + invited.getUsername());
           if  (i.getInviter().getId() == invitedId && i.getNewFriend().getId() == inviterId)
               throw new Exception(invited.getUsername() + " has already invited you! Approve his invitation to become friends");
          
        }
        
        invited.invite(inviter);
        _Invitations.add(new Invitation(inviter, invited));
    }

    

    /**
     * function to assign code according to id
     * @param code 
     */
    @Override
    public void assignCodeId(Code code) {
        code.setCodeId(nextCodeId++);
    }

     /***
     * function to assign user according to id
     * @param user 
     */
    @Override
    public void assignUserId(User user) {
       user.setId(nextUserId++);
    }

    /**
     * function to get user out going
     * @param userId
     * @return 
     */
    @Override
    public List<Invitation> getUserOutGoing(int userId) {
        List<Invitation> ret = new ArrayList<Invitation>();
        
        for (Invitation invit : _Invitations) {
            if (invit.getInviter().getId() == userId)
                ret.add(invit);
        }
        return ret;
    }

    /**
     * function to get user pending
     * @param userId
     * @return 
     */
    @Override
    public List<Invitation> getUserPending(int userId) {
        List<Invitation> ret = new ArrayList<Invitation>();
        
        for (Invitation invit : _Invitations) {
            if (invit.getNewFriend().getId() == userId)
                ret.add(invit);
        }
        return ret;
        
    }

    
    /**
     * function to notify online
     * @param userId 
     */
    @Override
    public void notifyOnline(int userId, boolean isOnline) {
        GetUser(userId).setIsOnline(isOnline);
    }

    /**
     * function to approve invitation
     * @param approver
     * @param inviter 
     */
    @Override
    public void approveInvitation(int approver, int inviter) {
      for (Invitation tmp : _Invitations) {
          if (tmp.getInviter().getId() == inviter && tmp.getNewFriend().getId() == approver) {
              tmp.approve(GetUser(approver));
              GetUser(approver).addFriend(GetUser(inviter));
          }
      }
    }

    /**
     * function to remove invitation
     * @param inviter
     * @param invited
     * @throws Exception 
     */
    @Override
    public void RemoveInvitation(int inviter, int invited) throws Exception {
        for (Invitation tmp : _Invitations) {
          if (tmp.getInviter().getId() == inviter && tmp.getNewFriend().getId() == invited) {
              _Invitations.remove(tmp);
              return;
          }
      }
    }

    
    /**
     * function  to get all user codes
     * @param userId
     * @return 
     */
    @Override
    public ArrayList<Code> GetAllUserCodes(int userId) {
        ArrayList<Code> ret = new ArrayList<Code>();
        
        for (Code code : _Codes) {
            if (code.getAuthor_id() == userId)
                ret.add(code);
        }
        return ret;
    }

    
    /**
     * function to get user
     * @param username
     * @param password
     * @return 
     */
    @Override
    public User GetUser(String username, String password) {
        for (User user : _Users) {
            if (user.getUsername().compareTo(username) == 0 && user.getPassword().compareTo(password) == 0)
                return user;
        }
        throw new IllegalArgumentException("user not found");
    }

    /**
     * function to find new approved friend
     * @param userId
     * @throws Exception 
     */
    @Override
    public List<Friend> findApprovedFriends(int userId) throws Exception{
        User toAdd = GetUser(userId);
        List<Friend> newFriends = new ArrayList<>();
       /* for (Invitation invit : _Invitations) {
            if (invit.getInviter().getId() == userId && invit.isApproved()) {
                toAdd.addFriend((invit.getApprovedFriend(toAdd)));
                _Invitations.remove(invit);
            }
        }*/
        for (Iterator<Invitation> iter = _Invitations.listIterator(); iter.hasNext();) {
            Invitation invit = iter.next();
            if (invit.getInviter().getId() == userId && invit.isApproved()) {
                toAdd.addFriend((invit.getApprovedFriend(toAdd)));
                newFriends.add((invit.getApprovedFriend(toAdd)));

                iter.remove();
            }
        }
        return newFriends;
    }

    @Override
    public List<Friend> GetUserFriends(int userId) {
        return GetUser(userId).getFriends();
    }

    @Override
    public List<Invitation> GetInvitationsAfter(Date date) {
       List<Invitation> ret = new ArrayList<Invitation>();
       
       for (Invitation invit : _Invitations) {
           if (invit.getInvitationDate().after(date))
               ret.add(invit);
       }
       return ret;
    }

    @Override
    public List<Code> GetCodesAfter(Date date) {
        List<Code> ret = new ArrayList<Code>();
       
       for (Code code : _Codes) {
           if (code.getCreationDate().after(date))
               ret.add(code);
       }
       return ret;
        
    }
    
    @Override
    public Code getCode(int codeId) throws Exception{
        
        for (Code c : _Codes) {
            
            if (codeId == c.getCodeId()) {
                
                return c;
            }
        }
      throw new Exception("code not found");
    }
} 