/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Text;

import java.util.Collections;
import java.util.List;
/**
 *
 * @author חיים
 */
public class Code extends Text{
    private ProgramLang lang;
    private List<Comment> comments;
    private  final Permissions permission;

    
    public Code(User author, String text, ProgramLang lang, Permissions perm) {
        super(author, text);
        this.lang = lang;
        permission = perm;
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
        comments.add(newComment);
        Collections.sort(comments);
    }
}
