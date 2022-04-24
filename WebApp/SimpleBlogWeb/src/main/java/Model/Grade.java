package Model;

/**
 * @author Julia Merta
 * @version %I%, %G%
 * The Grade enumerator
 */
public enum Grade {
    EXCELLENT (5),
    GOOD (4),
    AVERAGE(3),
    BAD(2),
    HORRIBLE(1);

    /**
     * The integer value of the grade
     */
    private final int gradeNumber;

    /**
     * The grade constructor
     * @param gradeNumber the integer value of the grade
     */
    Grade(int gradeNumber) {
        this.gradeNumber=gradeNumber;
    }

    /**
     * The method gets the integer value of the grade
     * @return
     */
    public int getGradeNumber()
    {return gradeNumber;}

}
