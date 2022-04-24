package Model;
/**
 * @Author Julia Merta
 * @Version %I%
 */

import Exceptions.InvalidTitleException;

/**
 * Model.Post class. Model.Post contains some images and texts.
 */
public class Post {
    /**
     * The title of the post
     */
    private    String title;

    /**
     * Image under the text
     */
    private Image image;
    /**
     * The text of the post
     */

    private String text;

    /**
     * The post constructor
     * @param title title of the post
     * @param image image (can be null)
     * @param text post text content
     * @throws InvalidTitleException when the title was blank
     */
    public Post(String title, Image image, String text) throws InvalidTitleException {
        if(title.isBlank()||title.isEmpty())
            throw new InvalidTitleException("The title is empty!");
        if(text.isBlank()||text.isEmpty())
            throw new InvalidTitleException("The text is empty!");
        this.title = title;
        this.image = image;
        this.text = text;
    }

    /**
     * The method sets the title.
     * @param title the title
     * @throws InvalidTitleException when the title is blank
     */
    public void setTitle(String title) throws InvalidTitleException
    {
        if(title.isBlank())
            throw new InvalidTitleException("The title is blank!");
        this.title=title;
    }

    /**
     * The method gets the title.
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * The method to show the post in the console
     * @return text representation of the post
     */
    @Override
    public String toString() {
        return "<p class=\"center\">"+title+"</p>\n"
                +"\n<p>"+this.text+"</p>\n"
               +"<center><p style=\"background:rgba(0,200,0,.3); border: 20px solid rgba(0,50,0,.1);   margin-top: 50px;\n" +
"  margin-bottom:"+ this.image.getY()+"px;\n" +
"  margin-right:"+ this.image.getX()+"px;\n" +
"  margin-left: 500px;\n" +
"  padding: 3px;\">"+"<img "+this.image.toString()+"/><p></center>";
    }
}
