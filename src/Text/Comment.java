/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import person.*;
/**
 *Class to represent comment
 * @author חיים
 */
public class Comment extends Text implements Comparable<Comment>{
    private Text commentedText;
    private int commentedLineNumber;
    private boolean viewed;
    private List<Comment> replies;
   
    /**
     * constractor
     * @param author
     * @param text
     * @param commented
     * @param lineNumber
     * @throws InstantiationException 
     */
    public Comment(User author, String text, Text commented, int lineNumber) throws InstantiationException{
        super(author, text);
        commentedText = commented;
        commentedLineNumber = lineNumber;
        this.replies = new ArrayList<Comment>();
    }
    
    //to sort comments by date
    @Override
    public int compareTo(Comment otherComment)
    {
        return this.getCreationDate().compareTo(otherComment.getCreationDate());
    }
    
    /**
     * function to add reply
     * @param reply 
     */
    public void addReply(Comment reply) {
        if (reply.getCommentedLineNumber() >= lines.size())
            throw new IllegalArgumentException("commented line out of range");
        replies.add(reply);
        Collections.sort(replies);
    }
    
    /**
     * function to remove reply
     * @param reply 
     */
    public void removeReply(Comment reply) {
        for (Comment c : replies) {
            if (c == reply)
                replies.remove(c);
            return;
        }
        throw new IllegalArgumentException("commente not found");
    }
    
    /**
     * @return the commentedText
     */
    public Text getCommentedCode() {
        return commentedText;
    }

    /**
     * @param commentedText the commentedCode to set
     */
    public void setCommentedText(Text commentedText) {
        this.commentedText = commentedText;
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

    /**
     * @return the replies
     */
    public List<Comment> getReplies() {
        return replies;
    }

    /**
     * @param replies the replies to set
     */
    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }
    
    @Override
    public String toString() {
        return "commented line: " + commentedLineNumber + "viewed: " + viewed + super.toString();
    }
}
 