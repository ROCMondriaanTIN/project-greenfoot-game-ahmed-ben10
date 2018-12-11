import greenfoot.*;
import java.util.*;
/**
 *
 * @author R. Springer
 */
public class Hero extends Mover
{
    private final double gravity;
    private final double acc;
    private final double drag;
    public  int leven=3;
    public  int gem=0;
    public  int x= 159;
    public  int y=913;
    private int frame =1;
    public String worldName="";
    private double snelheid;
    private int springen;
    boolean inAir=true;
    boolean key=false;
    boolean level2=false;
    boolean schatkist=false;
    boolean isDood=false;
    boolean removedBadGuy=false;
    GreenfootSound gm =new GreenfootSound("gameSound.wav");
    

    public Hero(String worldName) 
    {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
        this.worldName= worldName;
         
    }

    @Override
    public void act()
    {
        
       if(isDood)//controleert of je dood bent    
       {
           isDood=false;  //isDood = !isDood
           leven--;// haalt lven er af
           setLocation(getX(),getY() - 150);// haalt je weg van de tile die je hebt aangeraakt anders gaat leven -2
                
       } 
        music();//achtergrond muziek
        handleInput();//besturing
        veer();//jump veer
        levens();// controleert levens
        boostSnelheid();//code voor een boost die ervoor zorgt dat je sneller wordt
        boostSpringen();//code voor een boost die ervoor zorgt dat je hoger kan springen 
      
        if(!Greenfoot.isKeyDown("k"))//cheat voor als je niet dood wil gaan
        {
            doodTile();//cactussen,spikes en lava waardoor je doodn kan gaan
            enemies();// de spin enemy waardoor je dood kan gaan
        }

        getGemBlue();// code voor gems verzamellen
        hart();// code voor het verzamellen van leven 
        key();// code voor het pakken van de key
        platform();// code oor de bewegende platform
        touchingSchatkist();//code voor het open maken van de schatkist
        removeBadGuy();// code die de badguy verwijdert en de schatkist toevoegd
        levels();//code die je naar de volgende level brengt
        // getPositie();//code die je X en Y positie geeft
        checkpointVlag();// Code voot j checkpoint die je nieuwe x en y coordinaten geeft
        if(!removedBadGuy)
        {
            atTheEdge();//controleert of de BadGuy bij de edge of de wereld is
        }
        velocityX *= drag;
        velocityY += acc;

        if (velocityY > gravity) 
        {
            velocityY = gravity;
        }
        applyVelocity();
    }    
        
    
    	
    public void atTheEdge()
    {
        List<BadGuy> badList = this.getWorld().getObjects(BadGuy.class);
        BadGuy myBadGuy = badList.get(0);
        boolean atEdge= myBadGuy.atEdge();
        
        if(atEdge==true)
        {
            setLocation(x,y);
            isDood=true;     
        }
    }
    
    public void enemies()
    {
        for(Actor enemy:getIntersectingObjects(Enemy.class))
        {
             setLocation(x,y);
             isDood=true;
             break;
        }   
    }

    public void hart()
    {
        if(leven<3)
        {
            if(isTouching(Hart.class))
            {
                removeTouching(Hart.class);
                leven++;
            }
        }
    }

    public void music()
    {
        if(!gm.isPlaying())
        {
            gm.playLoop();
        }
    }
    
     public int levens()
     {
         if(leven==0)
         {
             gm.stop();
             Greenfoot.setWorld(new Gameover(worldName));
         } 
         return leven;
     }

     public void platform() 
     {
         if (isTouching(Enemy.class)) 
         {
             velocityY = -1.2;
         }
      }

      public double boostSnelheid()
      {
          if(isTouching(BoostSnelheid.class))    
           {
               removeTouching(BoostSnelheid.class);
               snelheid+=1.3;
           }
           return snelheid;
      } 
            
       public int boostSpringen()
       {
            if(isTouching(BoostSpring.class))    
            {
                removeTouching(BoostSpring.class);
                springen+=2;
            
            }
            return springen;
       }

       public void doodTile()
       {
           for (Tile dodelijkeTile : getObjectsInRange(50, DodelijkeTile.class))
           {
                if (dodelijkeTile != null && dodelijkeTile instanceof DodelijkeTile )
                {
                    setLocation(x,y);
                    isDood=true;
                    break;
                }
            
            }
        }

         public boolean touchingSchatkist()
         {
             if(key==true)
             {
                 if(isTouching(Schatkist.class)) 
                 {
                     removeTouching(Schatkist.class);
                     schatkist=true;
                 }
             }
             return schatkist;
          }  

      public void removeBadGuy()
      {
            if(isTouching(BadGuy.class)) 
            {
                    removeTouching(BadGuy.class); 
		    removedBadGuy=true;

                    if(worldName=="MyWorld1")
                    {
                        this.getWorld().addObject(new Schatkist(),5809,686);
                    }
            
                    if(worldName=="MyWorld2")
                    {
                        this.getWorld().addObject(new Schatkist(),5987,1285);
                    }
            
                    if(worldName=="MyWorld3")
                    {
                        this.getWorld().addObject(new Schatkist(),5705,1043);
                    }
            
                    if(worldName=="MyWorld4")
                    {
                        this.getWorld().addObject(new Schatkist(),5440,385);    
                    }
                return;
                }
        }
    
        public void levels()
        {
            //deur van level 1 naar level 2
            for(Actor door:getIntersectingObjects(Door.class)) 
            {
                if(key==true)
                {   
                    if(door!=null)
                    {  
                 
                        if(gem == 13)
                        {
                    
                            if(BadGuy.class !=null)
                            {
                                if(schatkist==true)
                                {
                                    Greenfoot.setWorld(new MyWorld2());
                                    String actieveWereld="MyWorld2"; 
                                    gm.stop();
                                    return;
                                }
                            }
                        } 
                    }
                }
            break;    
            }  

            //Deur van level2 naar Level 3
            for(Actor door:getIntersectingObjects(Door.class)) 
            {
                if(key==true)
                {   
                    if(door!=null)
                    {  
                 
                        if(gem == 22)
                        {
                    
                            if(BadGuy.class !=null)
                            {
                                if(schatkist==true)
                                {
                                    Greenfoot.setWorld(new MyWorld3());
                                    String actieveWereld="MyWorld3"; 
                                    gm.stop();
                                    return;
                                }
                            }
                        } 
                    }
                }
            break;    
            }
            //deur van level 3 naar 4
            for(Actor door:getIntersectingObjects(Door.class)) 
            {
                if(key==true)
                {   
                    if(door!=null)
                    {  
                 
                        if(gem == 36)
                        {
                    
                            if(BadGuy.class !=null)
                            {
                                if(schatkist==true)
                                {
                                    Greenfoot.setWorld(new MyWorld4());
                                    String actieveWereld="MyWorld4"; 
                                    gm.stop();
                                    return;
                                }
                            }
                        } 
                    }
                }
            break;    
            }
      
            // deur van level 4 naar EIND
             for(Actor door:getIntersectingObjects(Door.class)) 
            {
                if(key==true)
                {   
                    if(door!=null)
                    {  
                 
                        if(gem == 16)
                        {
                    
                            if(BadGuy.class !=null)
                            {
                                if(schatkist==true)
                                {
                                    Greenfoot.setWorld(new EindScherm());
                                    String actieveWereld="EindScherm"; 
                                    gm.stop();
                                    return;
                                }
                            }
                        } 
                    }
                }
            break;    
            }
        }
        public void checkpointVlag()
        {
            if(isTouching(Checkpoint.class))    
            {
                x=getX();
                y=getY();
            }
       }
       
       public String getPositie()
       {
           String positiexy= "X: "+this.getX() +" Y: "+this.getY(); 
           return positiexy;
       }
    
       public int getGemBlue()
       {
           if(isTouching(GemBlueTile.class))    
           {
               removeTouching(GemBlueTile.class); 
               Greenfoot.playSound("gemSound.wav");
               gem++;
           }  
           return gem;
       }
    
       public boolean key()
       {
    
           if(isTouching(Key.class))    
           {
               removeTouching(Key.class);
               key=true;
           }  
       return key;
       }
    
       public void handleInput() 
       {
            if (isTouching(MovingPlatform.class))
               {
                   velocityY = -1;

                   if (Greenfoot.isKeyDown("UP")||Greenfoot.isKeyDown("Space"))
                   {
                       velocityY = -14;
                   }
               }

           for (Actor Hero: getIntersectingObjects(JumpTile.class))
           {
               if (Greenfoot.isKeyDown("UP")||Greenfoot.isKeyDown("Space"))
               {
                   inAir=true;
                   velocityY = -15-springen;
                   Greenfoot.playSound("jumpSound.wav");
                   setImage("p1_jump.png");
               }
               else 
               {
                   inAir=false;
               }
           }

           if (Greenfoot.isKeyDown("Left")) 
           {
               velocityX = -6.00-snelheid;
               framesLinks();
           } 
           else if (Greenfoot.isKeyDown("Right")) 
           {
               velocityX = 6.00+snelheid;
               framesRechts();
           }
       }

       public void veer()
       {
           for(Tile tile:getIntersectingObjects(SpringboardUpTile.class))    
           {
               if(tile!=null)
               {
                   velocityY=-22; 
               }
           }    
       }

        public void framesRechts()
        {
            if(frame==1)
            {
                setImage("p1_walk01.png");
            }

            if(frame==2)
            {
                setImage("p1_walk02.png");
            }

            if(frame==3)
            {
                setImage("p1_walk03.png");
            }
            
            if(frame==4)
            {
                setImage("p1_walk04.png");
            }
    
            if(frame==5)
            {
                setImage("p1_walk05.png");  
            }

            if(frame==6)
            {
                setImage("p1_walk06.png");
            }

            if(frame==7)
            {
                setImage("p1_walk07.png");
            }
            
            if(frame==8)
            {
                setImage("p1_walk08.png");
            }
            
            if(frame==9)
            {
                setImage("p1_walk09.png");
            }
            
            if(frame==10)
            {
                setImage("p1_walk10.png");
            }
        
            if(frame==11)
            {
                setImage("p1_walk11.png");
                frame=1;
                return ;
            }
            frame++;
        } 
  
        public void framesLinks()
        {
             if(frame==1)
            {
                setImage("p1_links_walk01.png");
            }

            if(frame==2)
            {
                setImage("p1_links_walk02.png");
            }

            if(frame==3)
            {
                setImage("p1_links_walk03.png");
            }
            
            if(frame==4)
            {
                setImage("p1_links_walk04.png");
            }
    
            if(frame==5)
            {
                setImage("p1_links_walk05.png");  
            }

            if(frame==6)
            {
                setImage("p1_links_walk06.png");
            }

            if(frame==7)
            {
                setImage("p1_links_walk07.png");
            }
            
            if(frame==8)
            {
                setImage("p1_links_walk08.png");
            }
            
            if(frame==9)
            {
                setImage("p1_links_walk09.png");
            }
            
            if(frame==10)
            {
                setImage("p1_links_walk10.png");
            }
        
            if(frame==11)
            {
                setImage("p1_links_walk11.png");
                frame=1;
                return ;
            }
            frame++;
        }  
 
        public int getWidth() 
        {
            return getImage().getWidth();
        }

        public int getHeight()
        {
            return getImage().getHeight();
        }
}


   