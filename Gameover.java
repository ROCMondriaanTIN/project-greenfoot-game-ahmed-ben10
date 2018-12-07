
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class Gameover extends World {
public String worldName="Gameover";
    public Gameover(String worldName) {
        super(1000, 800, 1, false);
        this.setBackground("gameOver.png");
        this.worldName=worldName;

        Stop stop= new Stop();
        addObject(stop, 626, 503);
        
        Continue cn= new Continue(worldName);
        addObject(cn, 325, 503);
        
        

}
}
