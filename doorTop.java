import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class doorTop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorTop extends Mover
{
    public DoorTop()
    {
    setImage("door_closedTop.png");    
    }
    public void act() 
    {
       applyVelocity();
    }
}