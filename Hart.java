import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hart extends Mover
{
    public Hart()
    {
       setImage("hart.png");
    }
    public void act() 
    {
        applyVelocity();
    }    
}
