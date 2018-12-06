import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Selectscherm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RulesWorld extends World
{

    /**
     * Constructor for objects of class Selectscherm.
     * 
     */
    public RulesWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       super(1000,800, 1,false); 
        this.setBackground("rulesGame.png");
        prepare();
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Stop stop= new Stop();
        addObject(stop, 496, 700);
 
    }
}
