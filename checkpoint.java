import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class checkpoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Checkpoint extends Mover
{
    public Checkpoint()
    {
    setImage("flagBlue.png");    
    }
    public void act() 
    {
        applyVelocity();
    }    
}
