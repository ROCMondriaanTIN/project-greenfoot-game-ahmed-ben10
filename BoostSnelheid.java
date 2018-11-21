import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoostSnelheid extends Mover
{
    /**
     * Act - do whatever the Boost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Boost()
    {
    setImage("plantPurple.png");    
    }
    public void act() 
    {
        applyVelocity();
    }    
}
