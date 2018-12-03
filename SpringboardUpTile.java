import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class SpringboardUpTile extends Tile
{
    int frames=1;
    
    public SpringboardUpTile(String image,int width,int height)
    {
        super(image,width,height); 
        setImage("springboardUp.png");
    }
    
    public void act() 
    {
       
        for(Actor hero:getIntersectingObjects(Hero.class))
        {
                
                    if(frames==1)
                    {
                    setImage("springboardDown.png");    
                    }
                   
                    if(frames==2)
                    {
                    setImage("springboardUp.png");   
                    frames=1;
                    return;
                    }
                    frames++;
                
    }
    }    
}