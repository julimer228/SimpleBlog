package Model;
import Exceptions.InvalidIndexException;
/**
 * @Author Julia Merta
 * @Version %I%, %G%
 */
import Exceptions.InvalidTitleException;
import java.util.ArrayList;


/**
 * The Model.Topic class.
 */
public class Topic {

    /**
     * Title of the topic
     */
    private String title;

    /**
     * ArrayList of the posts connected with the topic.
     */
    private ArrayList<Post> posts;

    
    public Topic()
    {
        this.title="Without Topic";
        posts =new ArrayList<Post>();
    }
    /**
     * Model.Topic constructor, the posts ArrayList is empty
     * @param title title of the topic
     * @throws InvalidTitleException when the title is blank
     */
    public Topic(String title) throws  InvalidTitleException {
        if (title.isBlank()||title.isEmpty()) {
            throw new InvalidTitleException("Invalid topic's name!");
        }
           this.title =title;
           posts =new ArrayList<Post>();
}


public Topic(String title, ArrayList<Post> posts) throws InvalidTitleException
{
    if (title.isBlank()) {
        throw new InvalidTitleException("Invalid topic's name!");
    }
    this.title =title;
    this.posts =posts;
}


    /**
     * Method to set topic's title
     * @param title title of the post
     * @throws InvalidTitleException when the title is blank
     */
    public void setTitle(String title) throws InvalidTitleException {

        if(title.isBlank())
            throw new InvalidTitleException("Invalid topic's name!");
        this.title = title;
    }

    /**
     * Method gets the title of the topic
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * The method returns the ArrayList of the posts.
     * @return the ArrayList of posts
     */
    public ArrayList<Post> getPosts() {
        return posts;
   }

    /**
     * The method gets the number of posts connected with the topic
     * @return the number of posts
     */
    public int getNumberOfPosts()
    {
       return this.posts.size();
    }

    /**
     * The method adds new post to the topic
     * @param post post to add
     */
    public void addPost(Post post)
    {
        this.posts.add(post);
    }

    /**
     * The method removes post defined by index
     * @param index index of the post to remove
     * @throws InvalidIndexException when there is no post with that index
     */
    public void removePost(int index) throws InvalidIndexException
    {
        if(index<0||index>=posts.size())
            throw new InvalidIndexException("There is no post with this index!");
        this.posts.remove(index);
    }

    /**
     * Model.Topic representation in the console (the title of the topic and the number of posts)
     * @return text representation of the topic
     */
    @Override
    public String toString() {
        return "[ "+this.title+"] Number of posts: "+this.posts.size();
    }
}


