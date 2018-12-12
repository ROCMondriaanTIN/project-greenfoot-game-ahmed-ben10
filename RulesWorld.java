import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Selectscherm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RulesWorld extends World
{
    public String actieveWereld="RulesWorld"; 
    public RulesWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       super(1000,800, 1,false); 
        this.setBackground("rulesGame.png");
        Stop stop= new Stop();
        addObject(stop, 496, 700);
        
    }

}
