package Model;

import java.util.ArrayList;

/**
 * @author Julia Merta
 * @version %I%, %G%
 * The interface to count the average grade of the blog
 */
public interface AverageCounter {
    /**
     * Counting the average grade of the blog
     * @param grades the grades
     * @return the average grade of the blog
     */
    double countAverage(ArrayList<Grade> grades);
}