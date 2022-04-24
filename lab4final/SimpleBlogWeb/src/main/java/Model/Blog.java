package Model;
import Exceptions.InvalidGradeException;
import Exceptions.InvalidTitleException;
import Exceptions.InvalidIndexException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Julia Merta
 * @Version %I%
 */
/** Model.Blog class the blog representation. Blog contains topics and posts connected with them.
 */
public class Blog {

    /**Title of the blog*/
    private    String title;
    /**All the topics*/
    private ArrayList<Topic> topics;

    /**The list of grades given by readers*/
    private ArrayList<Grade> grades;

   private static final Blog INSTANCE = new Blog();

    private Blog() {
            this.topics = new ArrayList<Topic>();
            this.topics.add(new Topic());
            this.grades=new ArrayList<>();
    }

    public static Blog getInstance() {
        return INSTANCE;
    }

    /** Model.Blog constructor, the ArrayList topics
     * is being initiated with default topic called "Without topic".
     * @param title title of the blog
     * @throws InvalidTitleException when the title is empty
     */
    public Blog(String title) throws InvalidTitleException {
        if(title.isBlank() || title.isEmpty())
        { throw new InvalidTitleException("The title of the blog is invalid!");}
        else {
            this.title = title;
            this.topics = new ArrayList<Topic>();
            this.topics.add(new Topic("Without topic"));
            this.grades=new ArrayList<>();
        }
    }

    /**
     * The constructor
     * @param  title the title of the blog
     * @param topics the list of topics
     * @throws InvalidTitleException when the title of the blog is empty
     */
    public Blog(String title, ArrayList<Topic> topics) throws InvalidTitleException
    {
        if(title.isBlank() || title.isEmpty())
        { throw new InvalidTitleException("The title of the blog is invalid!");}
        else {
            this.title = title;
            this.topics = topics;
            this.grades=new ArrayList<>();
        }
    }

    /**
     * The method returns the title.
     * @return the blog's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * The method returns the ArrayList of the topics.
     * @return the ArrayList of the topics
     */
    public ArrayList<Topic> getTopics() {
        return topics;
    }

    /**
     * The method returns the number of topics
     * @return the number of topics
     */
    public int getNumberOfTopics()
    {
       return this.topics.size();
    }

    /**
     * The method returns the topic defined by index.
     * @param index the index of the topic
     * @return Model.Topic
     * @throws InvalidIndexException when there is no topic with that index
     */
    public Topic getTopicByIndex(int index) throws InvalidIndexException
    {
        if((index<0)||(this.topics.size()+1<index)) {
            throw new InvalidIndexException("There is no topic with this index!");
        }
        else {
            return this.topics.get(index);
        }
    }

    /**
     * The method adds new topic at the end of the ArrayList
     * @param topic the topic
     */
    public void addTopic(Topic topic)
    {
        this.topics.add(topic);
    }

    /**
     * The method removes topic defined by index
     * and all the posts connected with the topic
     * @param index index of the topic to remove
     * @throws InvalidIndexException when there is no topic with this index
     */
    public void removeTopicByIndex(int index) throws InvalidIndexException
    {
        if(index<0||index>topics.size()-1)
            throw new InvalidIndexException("There is no topic with this index! "+ index);
        for(int i=0; i<this.topics.get(index).getNumberOfPosts(); i++)
        {
            this.topics.get(index).removePost(i);
        }
        this.topics.remove(index);
    }

    /**
     * The method sets the title of the blog
     * @param title the title
     * @throws InvalidTitleException if the title is blank
     */
    public void SetTitle(String title) throws InvalidTitleException
    {
        if(title.isBlank())
            throw new InvalidTitleException("Incorrect blog's title!");
        this.title=title;
    }


    /**
     * The text representation of the blog
     * @return the text representation of the blog
     */
    @Override
    public String toString() {
        return title;
    }


    /**
     * The method adds new grade to the array
     * @param i the numeric value of the grade
     * @throws InvalidGradeException when the numeric value is not in (1,2,3,4,5)
     */
    public void addGrade(int i) throws InvalidGradeException
    {
        switch (i){
            case 1: this.grades.add(Grade.HORRIBLE);
                    break;
            case 2: this.grades.add(Grade.BAD);
                    break;
            case 3: this.grades.add(Grade.AVERAGE);
                    break;
            case 4: this.grades.add(Grade.GOOD);
                    break;
            case 5: this.grades.add(Grade.EXCELLENT);
                    break;
            default: throw new InvalidGradeException("Incorrect grade!");
        }
    }


    /**
     * The method to count average grade of the blog
     * The method uses Lambda block
     * @return the average grade
     */
    public double CountAverageGrade()
    {
        AverageCounter averageGrade=(n)->{
            double sum=0;
            for(Grade g: this.grades)
            {
                sum= (double) (sum+g.getGradeNumber());
            }
            double average = sum / this.grades.size();
            return average;
        };

        if(this.grades.isEmpty())
            return 0;
        return averageGrade.countAverage(grades);

    }



    /**
     * The method gets grades
     * @return the grades array
     */
    public ArrayList<Grade> getGrades() {
        return grades;
    }


    /**
     * The method to set the grades
     * @param grades the grade array
     */
    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }

    /**
     * The method to remove topic without posts
     */
    public void RemoveEmptyTopics() {
        for (Topic topic:topics) {
            if(topic.getNumberOfPosts()==0)
            topics.remove(topic);}}

}
