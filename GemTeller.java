import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class GemTeller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GemTeller extends Mover
{
    String actieveWereld="";
    public GemTeller(String actieveWereld)
    {
     this.actieveWereld=actieveWereld; 
    }
    public void act() 
    {
        List<Hero> heroList = this.getWorld().getObjects(Hero.class);
        Hero myHero = heroList.get(0);
        int gem=myHero.getGemBlue();  
        
         if(actieveWereld=="MyWorld1")
            {
                setImage(new GreenfootImage("Gems:"+gem+"/13",24,Color.BLACK,null));;    
            }
            
            if(actieveWereld=="MyWorld2")
            {
                setImage(new GreenfootImage("Gems:"+gem+"/22",24,Color.YELLOW,null));
            }
            
            if(actieveWereld=="MyWorld3")
            {
                setImage(new GreenfootImage("Gems:"+gem+"/36",24,Color.BLACK,null));
            }
            
            if(actieveWereld=="MyWorld4")
            {
                setImage(new GreenfootImage("Gems:"+gem+"/16",24,Color.BLACK,null));
            }
    }    
}
