import greenfoot.*;  
import java.util.*;
/**
 * Write a description of class LevenTeller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevenTeller extends Mover
{
    /**
     * Act - do whatever the LevenTeller wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    List<Hero> heroList = this.getWorld().getObjects(Hero.class);
        Hero myHero = heroList.get(0);
        int leven=myHero.levens();
        //getWorld().showText("Levens:"+myHero.levens(), 90,120);
        if(leven==3)
        {
        setImage("healtBare3.png");
        getImage().scale(250, 100);
        }
        if(leven==2)
        {
        setImage("healtBare2.png");   
        getImage().scale(250, 100);
        }
        if(leven==1)
        {
        setImage("healtBare1.png");  
        getImage().scale(250, 100);  
        }
    }    
}
