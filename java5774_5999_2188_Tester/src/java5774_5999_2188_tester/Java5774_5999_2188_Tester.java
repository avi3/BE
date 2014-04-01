/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java5774_5999_2188_tester;

import java.util.Scanner;
import DataAccessObject.*;
import Text.*;

import java.util.Date;

import person.*;
/**
 *
 * @author חיים
 */
public class Java5774_5999_2188_Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Backend_DAO_List_impl be = new Backend_DAO_List_impl();
        Scanner s = new Scanner(System.in);
        
        
        do {
            try {
            System.out.println("    choose option  ");
            System.out.println(" 1: Add User\n 2: Add friend to user\n 3: Add code\n 4: Remove User\n 5: Remove code\n 6: show all users\n 7: show all codes\n 8: get user friends\n 9: get codes after date\n 10:get user codes\n 11: add invitation\n 12: get user outgoing invitations\n 13: get user pending invitations\n 14: exit");
            switch (s.nextInt()) {
                case 1:
                    System.out.println(" Enter Username, password (letters and digits), email address:");
                    
                    be.AddUser(new User(s.next(), s.next(), s.next()));
                    System.out.println("user added succsesfully");
                    break;
                case 2:
                    System.out.println("Enter user id number and friend id number");
                    
                    User user = be.GetUser(s.nextInt());
                    User friend = be.GetUser(s.nextInt());
                    user.addFriend(friend);
                    System.out.println("  Friend added");
                    break;
                case 3:
                    System.out.println("Enter author id, code text, and subject");
                    be.AddCode(new Code(be.GetUser(s.nextInt()), s.next(), ProgramLang.C, Permissions.ALL, s.next()));
                    System.out.println("caode added");
                    break;
                case 4:
                    System.out.println("Enter User id");
                    be.RemoveUser(s.nextInt());
                    System.out.println("User removed successfully");
                    break;
                case 5:
                    System.out.println("enter code id");
                    be.RemoveCode(s.nextInt());
                    System.out.println("code removed");
                    break;
                case 6:
                   
                    for (NotFriend nf : be.getAllAsNotFriend())
                        System.out.println(((User)nf).toString());
                    break;
                case 7:
                    
                    for (Code c : be.GetAllCodes())
                        System.out.println(c.toString());
                    break;
                case 8:
                    System.out.println("Enter user id");
                   for (Friend f : be.GetUser(s.nextInt()).getFriends())
                        System.out.println(((User)f));
                   break;
                case 9:
                    System.out.println("Enter date (mm/dd/yy):");
                    Date date = new Date(s.next());
                    for (Code c : be.GetAllCodes()) {
                        if (c.getCreationDate().after(date))
                            System.out.println(c);
                    }
                        
                    break;
                case 10:
                    System.out.println("Enter user id:");
                    for (Code c : be.GetUser(s.nextInt()).getMyCodes())
                        System.out.println(c);
                    break;
                case 11:
                    System.out.println("Enter inviter id, invited id:");
                    be.invite(s.nextInt(), s.nextInt());
                    break;
                case 12:
                    System.out.println("Enter user id:");
                    for (Invitation invit : be.getUserOutGoing(s.nextInt())) {
                        System.out.println(invit);
                        
                    }
                break;
                case 13:
                    System.out.println("Enter user id:");
                    for (Invitation invit : be.getUserPending(s.nextInt())) {
                        System.out.println(invit);
                    }
                break;
                case 14:
                     System.out.println("GoodBye");
                    System.exit(0);
                   
                default:
                    System.out.println("please select option between 1 - 14");
                    break;
            } 
            
        
            
            }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        }while (true);
    }
    
}
