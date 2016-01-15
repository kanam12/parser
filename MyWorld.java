import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


import java.io.*;

import java.util.ArrayList;


/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    // variables that specify where and how the output lines will be printed to the screen
    int yStart=10;
    int xStart=100;
    int yMax=150;
    int lineHeight=16;
    int curYline=yStart;
    
    // A variable identifying your resource file, these files have to live in your
    // project directory and will get zipped up into a jar file when you create a
    // java applet.  You can use a ClassLoader object to read these files into your
    // scenario.
    
    private String fileName = "final-db.txt";
    
    //Note: Create the above file as a comma separated file with the following structure
    // Question,choice1,choice2,choice3,choice4
    // Include at least 5 rows in your file!!
    
    public ArrayList<String> lines;
    public int maxLines = 181 ; // You  can hard code the maximum lines here, or use the ArrayList size method to set
                            // this value later
    
     /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
        
        try {
     
          lines = loadFile(fileName);
   
        }
        catch (IOException ioe){
            System.out.println("error loading file");
        }
    }
    
    private void loadRound(String filename) throws IOException {
   
        ArrayList<String> lines = loadFile(filename);
  
    }
    
    private ArrayList<String> loadFile(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        
        // Allow loading from JAR files once compiled as applet
        
        // "filename" has to reference a file in the project directory used to
        // create the jar file.
        
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream(filename);
        if (is == null) {
            throw new IOException("No such file: " + filename);
        }
        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(is));
        String line = reader.readLine();
        while (line != null) {
            
            // Note that we are ignoring lines that start with "#". This way we
            // can add comments to our data file.
            if (!line.equals("") && !line.startsWith("#")) {
                lines.add(line);
            }
            line = reader.readLine();
        }
        reader.close();
        return lines;
    }

   

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
  
        ExampleReader examplereader = new ExampleReader();
        addObject(examplereader, 301, 206);
    }

// Prints one line of text, assuming certain things about height and starting location

    public void printText(String s){
        showText(s, xStart,curYline);
        curYline+=lineHeight;
        if (curYline>yMax)
           curYline=yStart;
    }
    
// Prints all lines.  A similar loop could be used to parse lines into individual
// questions and answers, for instance, using the method String.split()

    public void printLines(){
         for (String line: lines)
          printText(line);
        }
        
    public void printLine(int lineno){
         
          showText(lines.get(lineno),xStart,yStart);
        }      
    public void printQ(int lineno){
        System.out.print('\f');
        String question = lines.get(0);
        String[] qnArray = question.split(",");
        /*while (line != null)
        {
            if (line */
            
        System.out.println(qnArray[lineno]);


        /*for (int lineno; lineno <= maxLines; lineno++)
        {
           String message =  qnArray[lineno];
           System.out.println(message);
        }*/
        
        /*for (int count = 0; count <= maxLines; count++)
        {
                 line = in.readLine();
                 if (line == null) break;
                 for (int field = 0; field < 7; field++)
                 {
                     data[count][field] = line.substring(0, indexOf(lineno));
                     line = line.substring(line.indexOf(lineno) + 1);
                 }
                 data[count][field] = line;
        }
        }*/
         /*
          * This is the method you will need to write. It should split the lines element at index lineno using
          * the comma as a deliminator, then print each part as described in the assigment instructions.
          */
        
        }
    
        
    public int getMaxLines(){
       // Once you determine how to set maxLines, you can call this from ExampleReader
       return maxLines;
    }
    
   public static String fixedLengthString(String string,int length) {
    return String.format("%1$"+length+ "s", string);
} 
}
