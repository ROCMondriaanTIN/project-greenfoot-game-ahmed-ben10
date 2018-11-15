import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class BadGuy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadGuy extends Mover
{
    /**
     * Act - do whatever the BadGuy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //String getPositie();
        
        List<Hero> heroList = this.getWorld().getObjects(Hero.class);
        Hero myHero = heroList.get(0);
        int gem = myHero.gem;
        for (Actor Hero: getIntersectingObjects(Tile.class))
        {
        velocityX = 6;  
        velocityY=0;
        applyVelocity(); 
        
       
        if(gem==13)
        {
         
        setLocation(5508,394);
        
        }
    } 
}
    public String getPositie()
    {
    String positiexy= "X"+this.getX() +"y:"+this.getY(); 
    return positiexy;
    }
}
