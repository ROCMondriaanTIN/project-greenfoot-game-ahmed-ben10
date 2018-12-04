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
     setImage("score.png");
    }
    public void act() 
    {
        List<Hero> heroList = this.getWorld().getObjects(Hero.class);
        Hero myHero = heroList.get(0);
        int gem=myHero.getGemBlue();   
         if(actieveWereld=="MyWorld1")
            {
                getWorld().showText("Gems:"+myHero.getGemBlue()+"/13", 90, 150);    
            }
            
            if(actieveWereld=="MyWorld2")
            {
                getWorld().showText("Gems:"+myHero.getGemBlue()+"/22", 90, 150);
            }
            
            if(actieveWereld=="MyWorld3")
            {
                getWorld().showText("Gems:"+myHero.getGemBlue()+"/36", 90, 150);
            }
            
            if(actieveWereld=="MyWorld4")
            {
                getWorld().showText("Gems:"+myHero.getGemBlue()+"/16", 90, 150);
            }
    }    
}
