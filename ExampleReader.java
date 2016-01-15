import greenfoot.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class ExampleReader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExampleReader extends Actor
{
    /**
     * Act - do whatever the ExampleReader wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     int curLine=0;
     String l;
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            MyWorld w = (MyWorld) getWorld();
            int maxLines = w.getMaxLines();
            //System.out.println("Max: " + maxLines + "\n Current: " + curLine);
            if (curLine >= maxLines)
             {
                 curLine = 0;
             }
             w.printQ(curLine);
             curLine += 1;
        }
        
        /*
         * Write your code so that if the mouse is clicked on this actor
         * then you will call the MyWorld's printQ method, passing in curLine as an
         * integer argument, you will increment the curLine var each time the mouse is
         * clicked. If the curLine is greater than or equal to the maxLines variable, then
         * you will reset it back to 0. maxLines is set in MyWorld. to indicate the length
         * of the lines arraylist.
         */
       
     
      
    }
}

