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
    /**
     * Act - do whatever the GemTeller wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        List<Hero> heroList = this.getWorld().getObjects(Hero.class);
        Hero myHero = heroList.get(0);
        int gem=myHero.getGemBlue();
        getWorld().showText("Gems:"+myHero.getGemBlue(), 100, 80);
    }    
}
