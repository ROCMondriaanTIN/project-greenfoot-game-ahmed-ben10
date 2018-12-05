import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stop extends Mover
{
    public Stop()
    {
    setImage("stop.png");    
    }
    public void act() 
    {
        applyVelocity();
        if(Greenfoot.mouseClicked(this))
        { 
        Greenfoot.setWorld(new StartScherm());
        String actieveWereld="startscherm";  
        return;    
        }
    }    
}
