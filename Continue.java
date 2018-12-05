import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Continue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Continue extends Mover
{
    public String actieveWereld="";
    public Continue(String actieveWereld)
    {
    setImage("continue.png"); 
    this.actieveWereld=actieveWereld;
    }
    public void act() 
    {
    applyVelocity();
        if(Greenfoot.mouseClicked(this))
        { 
            if(actieveWereld=="MyWorld1")
            {
              Greenfoot.setWorld(new MyWorld());    
            }
            if(actieveWereld=="MyWorld2")
            {
              Greenfoot.setWorld(new MyWorld2());    
            }
            
            if(actieveWereld=="MyWorld3")
            {
              Greenfoot.setWorld(new MyWorld3());    
            }
            
            if(actieveWereld=="MyWorld4")
            {
               Greenfoot.setWorld(new MyWorld4());   
            }
        }   
    } 
 }


