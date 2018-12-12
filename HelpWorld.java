import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpWorld extends World
{
    public String actieveWereld="HelpWorld"; 
    public HelpWorld()
    {    
        super(1000,800, 1,false); 
        this.setBackground("helpScherm.png");
        Stop stop= new Stop();
        addObject(stop, 486, 720);
    }
}
