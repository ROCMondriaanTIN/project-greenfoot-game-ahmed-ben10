import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoostSpring here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoostSpring extends Mover
{
    public BoostSpring()
    {
     setImage("star.png");    
    }
    public void act() 
    {
    applyVelocity();
    }    
}
