/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

import java.util.ArrayList;

/**
 * Class that represents a user
 *
 * @author g
 */
public class user implements friendInterface, notFriendInterface {

    ArrayList<Integer> idFriends;
    
    ArrayList<Integer> wantsFriend;
    ArrayList<String> mycods;//להחליף את סטרינג למחלקה קוד או מזהה מספרי של קוד
    
    /**
     * function to add friend
     * @param id 
     */
    public void addFriend(int id){
        idFriends.add(id);
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
}
