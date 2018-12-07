
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class EindScherm extends World {
public String worldName="EindScherm";

    public EindScherm() {
        super(1000, 800, 1, false);
        this.setBackground("eindscherm.png");
        Stop stop= new Stop();
        addObject(stop, 470,680);

}
}
