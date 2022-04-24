package Model;
/**
 * @Author Julia Merta
 * @Version %I%
 */

import Exceptions.EmptyFilePathException;
import Exceptions.InvalidImageParamException;

/**
 * Model.Image class.
 */
public class Image  {
    /**
     * Path to the file with an image
     */
    private String filePath;
    /**
     * Caption under the image
     */
    private String caption;
    /**
     * The position on the X coordinate of the upper left corner of the image
     */
    private int x;
    /**
     * The position on the Y coordinate of the upper left corner of the image
     */
    private int y;
    /**
     * The height of the image
     */
    private int height;
    /**
     * The width of the image
     */
    private int width;
    
    /**
     * Model.Image constructor
     * @param x the position on the x-axis of the left upper corner of the image
     * @param y the position on the y-axis of the left upper corner of the image
     * @param height the height of the image
     * @param width the width of the image
     * @param filePath the path to the file
     * @param caption the caption under the image
     * @throws InvalidImageParamException when the parameter of the image is invalid
     * @throws EmptyFilePathException when the path to the file is blank
     */
    public Image(int x, int y, int height, int width, String filePath, String caption)throws InvalidImageParamException
    ,EmptyFilePathException{
        if(y<0)
            throw new InvalidImageParamException("The size or position parameter to create the image was invalid!");
        else if(x<0)
            throw new InvalidImageParamException("The x parameter must be equal or greater than zero!");
        else if(width<=0)
            throw new InvalidImageParamException("The width parameter must be equal or greater than zero!");
        else if(height<=0)
            throw new InvalidImageParamException("The height parameter must be equal or greater than zero!");
        else if(filePath.isBlank()||filePath.isEmpty()||filePath==null)
            throw new EmptyFilePathException("The path to the file is invalid!");
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        this.filePath = filePath;
        this.caption = caption;
    }

    /**
     * The method gets the position of the upper left corner of thr image on the x-axis
     * @return the position on the X axis
     */
    public int getX() {
        return x;
    }

    /**
     * The method sets the position of the upper left corner of thr image on the X axis
     * @param x the position on the x-axis
     * @throws InvalidImageParamException when the parameter is smaller then zero
     */
    public void setX(int x) throws InvalidImageParamException {
        if(x<0)
            throw new InvalidImageParamException("The parameter x should be equal or bigger then 0!");
        this.x = x;
    }

    /**
     * The method gets the position of the upper left corner of thr image on the y-axis
     * @return the position on the y-axis
     */
    public int getY() {
        return y;
    }

    /**
     * The method sets the position of the upper left corner of thr image on the y-axis
     * @param y the position on the y-axis
     * @throws InvalidImageParamException when the parameter is smaller then zero
     */
    public void setY(int y) throws InvalidImageParamException {
        if(y<0)
            throw new InvalidImageParamException("The parameter y should be equal or bigger then 0!");
        this.y = y;
    }

    /**
     * The method gets the height of the image
     * @return height of the image
     */
    public int getHeight() {
        return height;
    }

    /**
     * The method sets the height of the image
     * @param height the height of the image
     * @throws InvalidImageParamException when the parameter is smaller or equal zero
     */
    public void setHeight(int height) throws InvalidImageParamException {

        if(height<=0)
            throw new InvalidImageParamException("The parameter height must be greater then zero!");
        this.height = height;
    }

    /**
     * The method gets the width of the image
     * @return the width of the image
     */
    public int getWidth() {
        return width;
    }

    /**
     * The method sets width of the image
     * @param width the width of the image
     * @throws InvalidImageParamException when the width was smaller or equal zero
     */
    public void setWidth(int width) throws InvalidImageParamException {

        if(width<=0)
            throw new InvalidImageParamException("The parameter width must be greater then zero!");
        this.width = width;
    }

    /**
     * Method gets the path to the image file
     * @return the path to the image
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Method sets a path to the image file
     * @param filePath the path to the image
     * @throws EmptyFilePathException when the String with the filepath was empty
     */
    public void setFilePath(String filePath) throws EmptyFilePathException {
        if(filePath.isBlank())
            throw new EmptyFilePathException("The path was empty!");
        this.filePath = filePath;
    }

    /**
     * Method gets image's caption
     * @return image's caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Method sets new image's caption
     * @param caption the caption under the image
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * The method to show image in the console.
     * @return text
     */
    @Override
    public String toString() {
        return "src=\""+filePath+
                "\" alt="+caption+   
                "\n height="+height+
                "\n width="+width;           
    }
}

