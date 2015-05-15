
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Spaceship
{
    private String craft = "spaceshipimage.png";
    private int x;
    private Image image;
    private ArrayList lasers;

    /**
     * constructs the player ship
     * assigns appropriate values to the private variables
     */
    public Spaceship()
    {
        ImageIcon ship = new ImageIcon(this.getClass().getResource(craft));
        image = ship.getImage();
        x = 600;
        lasers = new ArrayList();
    }

    /**
     * moves the player ship based on the input int changeX
     */
    public void move(int changeX)
    {
        int changed = x + changeX;
        if (changed > 10 && changed < 1140)
        {
            x = changed;
        }
    }

    /**
     * returns the current X position
     */
    public int getX()
    {
        return x;
    }

    /**
     * returns the image
     */
    public Image getImage()
    {
        return image;
    }
    
    /**
     * returns the ArrayList lasers
     */
    public ArrayList getLasers()
    {
        return lasers;
    }
    
    /**
     * when called, adds a laser to the ArrayList lasers, and creates the laser in the SpaceBoard
     */
    public void fire()
    {
        lasers.add(new PlayerLaser(this.getX(), 800));
    }
}
