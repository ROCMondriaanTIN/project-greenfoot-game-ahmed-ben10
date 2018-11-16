import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2Button extends Mover
{
    /**
     * Act - do whatever the Level2Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        applyVelocity();
       if(Greenfoot.mouseClicked(this))
        {
        Greenfoot.setWorld(new MyWorld2());
        String actieveWereld="MyWorld2";  
        return;    
        }
    }    
}
