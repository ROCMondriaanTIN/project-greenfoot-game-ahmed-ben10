
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class BadGuy extends Mover {

    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;

    public BadGuy() {
        super();
        getImage().mirrorHorizontally();
        walkRange = 7000;
        firstAct = true;
        speed = 1;
    }

    @Override
    public void act() {
        int x = getX();
        int y = getY();

        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }

        velocityX = 4;
        applyVelocity();
        if (getX() >= xMax) {
            speed *= -4;
            x = xMax;
            getImage().mirrorHorizontally();
        } else if (getX() <= xMin) {
            speed *= -4;
            x = xMin;
            getImage().mirrorHorizontally();
        }
    }
}
