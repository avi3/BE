/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Text;

/**
 *
 * @author חיים
 */
public class Comment extends Text implements Comparable<Comment>{
    private Code commentedCode;
    private int commentedLineNumber;
    private Boolean viewed;
   
    //to sort comments by date
    public int compareTo(Comment otherComment)
    {
        if (this.creationDate.before(otherComment.creationDate))
            return 1;
        else
            return 0;
    }

    /**
     * @return the commentedCode
     */
    public Code getCommentedCode() {
        return commentedCode;
    }

    /**
     * @param commentedCode the commentedCode to set
     */
    public void setCommentedCode(Code commentedCode) {
        this.commentedCode = commentedCode;
    }

    /**
     * @return the commentedLine
     */
    public int getCommentedLineNumber() {
        return commentedLineNumber;
    }

    /**
     * @param commentedLineNumber the commentedLineNumber to set
     */
    public void setCommentedLineNumber(int commentedLineNumber) {
        this.commentedLineNumber = commentedLineNumber;
    }

    /**
     * @return the viewed
     */
    public Boolean getViewed() {
        return viewed;
    }

    /**
     * @param viewed the viewed to set
     */
    public void setViewed(Boolean viewed) {
        this.viewed = viewed;
    }
}
