
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScherm here.
 * 
 * @author (your name)  
 * @version (a version number or a date)
 */
public class StartScherm extends World
{
    public String actieveWereld="startscherm";  
    public StartScherm()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000,800, 1,false); 
        this.setBackground("gameAchtergrond.png");
        prepare();
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Level1Button level1Button = new Level1Button();
        //addObject(level1Button,496,600);
        StartButton sb = new StartButton();
        addObject(sb,490,550);
        
        Rules rules = new Rules();
        addObject(rules,490, 600);
        
        HelpButton hb = new HelpButton();
        addObject(hb,490,650);

    }
}
