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
 *
 * @author חיים
 */
public class Code extends Text{
    
    private int codeId;
    private ProgramLang lang;
    private List<Comment> comments;
    private Permissions permission;
    private String subject;

    
    
    public Code(User author, String text, ProgramLang lang, Permissions perm, String subject)  throws InstantiationException{
        super(author, text);
        this.lang = lang;
        this.subject = subject;
        permission = perm;
        this.comments = new ArrayList<Comment>();
    }
    
    public void update(Code code) {
        if (this.getCodeId() != code.getCodeId())
            throw new IllegalArgumentException("not the same code");
        super.update(code);
        this.comments = code.getComments();
        this.lang = code.getLang();
        this.lines = code.getLines();
        this.permission = code.getPermission();
        this.subject = code.getSubject();
    }
    /**
     * @return the lang
     */
    public ProgramLang getLang() {
        return lang;
    }

    /**
     * @param lang the lang to set
     */
    public void setLang(ProgramLang lang) {
        this.lang = lang;
    }

    /**
     * @return the comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
    public void addComment(Comment newComment) {
        if (newComment.getCommentedLineNumber() >= lines.size())
            throw new IllegalArgumentException("commented line out of range");
        comments.add(newComment);
        Collections.sort(comments);
    }
    
    public void removeComment(Comment comment) {
        
        for (Comment c : comments) {
            if (c == comment)
                comments.remove(c);
            return;
        }
        throw new IllegalArgumentException("commente not found");
    }
    
   

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the permission
     */
    public Permissions getPermission() {
        return permission;
    }

    /**
     * @param permission the permission to set
     */
    public void setPermission(Permissions permission) {
        this.permission = permission;
    }

    /**
     * @return the codeId
     */
    public int getCodeId() {
        return codeId;
    }

    /**
     * @param codeId the codeId to set
     */
    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }
}
