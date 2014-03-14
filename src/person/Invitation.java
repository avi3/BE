/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;
import java.util.Date;
/**
 *
 * @author חיים
 */
public class Invitation {
    private NotFriend inviter;
    private NotFriend newFriend;
    private Friend approvedFriend;
    private boolean approved;
    private Date invitationDate;
    
    //only user can create it, but we don't want to save it as user so the invited can't see its data
    public Invitation(User inviter, NotFriend newFriend) {
        this.inviter = inviter;
        this.newFriend = newFriend;
        this.invitationDate = new Date();
    }
    public void approve(Friend validator) {
        if (validator.getId() == getNewFriend().getId()) {
            setApproved(true);
            setApprovedFriend(validator);
        }
        else
            throw new IllegalArgumentException("not authorized to approve"); 
    }

    /**
     * @return the inviter
     */
    public NotFriend getInviter() {
        return inviter;
    }

    /**
     * @param inviter the inviter to set
     */
    public void setInviter(NotFriend inviter) {
        this.inviter = inviter;
    }

    /**
     * @return the newFriend
     */
    public NotFriend getNewFriend() {
        return newFriend;
    }

    /**
     * @param newFriend the newFriend to set
     */
    public void setNewFriend(NotFriend newFriend) {
        this.newFriend = newFriend;
    }

    /**
     * @return the approvedFriend
     */
    public Friend getApprovedFriend(User inviter) throws Exception{
        if (inviter.getId() == this.inviter.getId() && approved)
                return approvedFriend;
        throw new Exception("not approved");
    }

    /**
     * @param approvedFriend the approvedFriend to set
     */
    private void setApprovedFriend(Friend approvedFriend) {
        this.approvedFriend = approvedFriend;
    }

    /**
     * @return the approved
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * @param approved the approved to set
     */
    private void setApproved(boolean approved) {
        this.approved = approved;
    }

    /**
     * @return the invitationDate
     */
    public Date getInvitationDate() {
        return invitationDate;
    }

    /**
     * @param invitationDate the invitationDate to set
     */
    public void setInvitationDate(Date invitationDate) {
        this.invitationDate = invitationDate;
    }
}