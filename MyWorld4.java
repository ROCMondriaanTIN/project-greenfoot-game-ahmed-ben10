
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class MyWorld4 extends World {

    private CollisionEngine ce;
    public String actieveWereld="MyWorld4";
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MyWorld4() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("ice.png");

       int[][] map={
           {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,26,25,25,-1,-1,-1,-1,-1,-1,-1,-1,25,26,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,26,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,27,28,29,-1,-1,-1,-1,-1,-1,-1,27,28,29,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,25,26,-1,-1,-1,-1,-1,-1,-1,-1,26,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,32,24,24,24,33,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,27,28,29,-1,-1,-1,-1,-1,-1,-1,27,28,29,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,25,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,32,20,20,20,20,20,33,25,36,-1,26,25,25,36,-1,26,25,25,36,-1,26,36,-1,26,36,-1,26,36,-1,-1,-1,-1,-1,25,25,36,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,26,-1,-1,28,28,-1,-1,26,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,26,28,20,20,20,20,20,20,20,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,28,28,28,24,24,24,24,24,24,28,28,28,28,28,28,28,24,24,24,24},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,25,28,30,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,30,30,30,20,20,20,20,20,20,30,30,30,30,30,30,30,20,20,20,20},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,26,28,30,30,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,30,30,30,20,20,20,20,20,20,30,30,30,30,30,30,30,20,20,20,20},
{-1,-1,-1,-1,-1,-1,-1,25,26,-1,-1,-1,-1,26,-1,25,25,28,30,30,30,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,30,30,30,20,20,20,20,20,20,30,30,30,30,30,30,30,20,20,20,20},
{28,28,28,28,28,28,28,28,31,31,31,31,31,31,28,28,28,30,30,30,30,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,30,30,30,20,20,20,20,20,20,30,30,30,30,30,30,30,20,20,20,20},
{30,30,30,30,30,30,30,30,11,11,11,11,11,11,30,30,30,30,30,30,30,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,30,30,30,20,20,20,20,20,20,30,30,30,30,30,30,30,20,20,20,20},
{30,30,30,30,30,30,30,30,10,10,10,10,10,10,30,30,30,30,30,30,30,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,30,30,30,20,20,20,20,20,20,30,30,30,30,30,30,30,20,20,20,20},
{30,30,30,30,30,30,30,30,10,10,10,10,10,10,30,30,30,30,30,30,30,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,30,30,30,20,20,20,20,20,20,30,30,30,30,30,30,30,20,20,20,20},
{30,30,30,30,30,30,30,30,10,10,10,10,10,10,30,30,30,30,30,30,30,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,30,30,30,20,20,20,20,20,20,30,30,30,30,30,30,30,20,20,20,20},
{30,30,30,30,30,30,30,30,10,10,10,10,10,10,30,30,30,30,30,30,30,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,30,30,30,20,20,20,20,20,20,30,30,30,30,30,30,30,20,20,20,20},
{30,30,30,30,30,30,30,30,10,10,10,10,10,10,30,30,30,30,30,30,30,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,30,30,30,20,20,20,20,20,20,30,30,30,30,30,30,30,20,20,20,20},
{30,30,30,30,30,30,30,30,10,10,10,10,10,10,30,30,30,30,30,30,30,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,30,30,30,20,20,20,20,20,20,30,30,30,30,30,30,30,20,20,20,20},
{30,30,30,30,30,30,30,30,10,10,10,10,10,10,30,30,30,30,30,30,30,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,30,30,30,20,20,20,20,20,20,30,30,30,30,30,30,30,20,20,20,20},

};


        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        BadGuy badGuy=new BadGuy(actieveWereld);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero( actieveWereld);
    
       // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 150, 800);
        addObject(hero, 110,613);
        addObject(badGuy,369,613);

        //addObject(new Enemy(),5555,613);
       
        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
        prepare();
    }

    @Override
    public void act() {
        ce.update();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Hart hart = new Hart();
        addObject(hart,3193,373);
        
        LevenTeller lt=new LevenTeller();
        addObject(lt,130,60);
         
        Door door = new Door();
        addObject(door,105,623);

        DoorTop doorTop = new DoorTop();
        addObject(doorTop,105,553);

        Door door1 = new Door();
        addObject(door1,5676,385);

        DoorTop doorTop1 = new DoorTop();
        addObject(doorTop1,5676,319);

        Key key1 = new Key();
        addObject(key1,4274,258);

        Checkpoint checkpoint2 = new Checkpoint();
        addObject(checkpoint2,3046,383);

        Checkpoint checkpoint = new Checkpoint();
        addObject(checkpoint,198,625);


        GemTeller gt = new GemTeller(actieveWereld);
        addObject(gt, 90, 150);
        
        BoostSnelheid boost = new BoostSnelheid();
        addObject(boost,1896,373);
        
        BoostSnelheid boost1 = new BoostSnelheid();
        addObject(boost1,3116,373);
        
        BoostSnelheid boost2 = new BoostSnelheid();
        addObject(boost2,562,613);
        
       // BoostSpring boost3 = new BoostSpring();
        //addObject(boost3,3924,493);
    }
}
