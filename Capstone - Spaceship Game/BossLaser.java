import java.awt.Image;
import javax.swing.ImageIcon;

public class BossLaser {
    
    private int x, y;
    private Image image;
    private boolean visible;
    private int direction;
    
    private final int LASER_SPEED = 3;
    
    /**
     * constructs the boss laser based input int values
     * assigns appropriate values to the private variables
     */
    public BossLaser(int x, int y, int direction)
    {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("boss-laser.png"));
        
        image = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    
    /**
     * checks to see if boss laser has collided with the player ship
     * returns collides - if 0, did not collide with the player ship, if 1, did collide the player
     * ship
     * sets visible to false if collides equals 1
     * 
     * (incomplete)(compiles, but does not always get the collision right, does not cover the entire
     * player ship)
     */
    public int checkCollision(int shipX, int shipY)
    {
        int collides = 0;
        for (int i = shipX; i < shipX + 25; i++)
        {
            for (int ii = shipY; ii < shipY + 25; ii++)
            {
                if (this.x == i && this.y == ii)
                {
                    collides = 1;
                    visible = false;
                } 
            }
        }
        
        return collides;
    }
    
    /**
     * moves the boss laser based in the passed in direction value
     * sets visible to false if it reaches the bottom of the JFrame
     */
    public void moveLaser(int roomHeight)
    {
        if (direction == 0)
        {
            y += LASER_SPEED;
        }
        else if (direction == 1)
        {
            y += LASER_SPEED;
            x += (LASER_SPEED - 1);
        }
        else 
        {
            y += LASER_SPEED;
            x += (LASER_SPEED - 1)*(-1);
        }
        
        if (y >= roomHeight)
        {
            visible = false;
        }
    }
    
    /**
     * returns the image
     */
    public Image getImage()
    {
        return image;
    }

    /**
     * returns the current X position
     */
    public int getX()
    {
        return x;
    }

    /**
     * returns the current Y position
     */
    public int getY()
    {
        return y;
    }

    /**
     * returns the boolean visible
     */
    public boolean isVisible()
    {
        return visible;
    }
}