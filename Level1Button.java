import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1Button extends Mover
{
    /**
     * Act - do whatever the Level1Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        applyVelocity();
        if(Greenfoot.mouseClicked(this))
        {
        Greenfoot.setWorld(new MyWorld());
        String actieveWereld="MyWorld1";  
        return;    
        }
    }    
}
