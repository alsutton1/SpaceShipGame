import java.awt.Image;
import javax.swing.ImageIcon;

public class PlayerLaser {
    private String laser = "player-laser.png";
    private int x, y;
    private Image image;
    private boolean visible;

    private final int LASER_SPEED = -10;

    /**
     * creates the player laser image based on the position ints input
     * assigns specific values to private initialized variables
     */
    public PlayerLaser(int x, int y)
    {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(laser));

        image = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
    }

    /**
     * checks to see if the player laser has collided with the boss ship's coordinates
     * returns a int value of 1 if collided or 0 if not collided
     * if collided is zero, sets visible to false
     * 
     * (buggy)(collision compiles and works, but does not cover the entire ship)
     */
    public int checkCollision(int bossX, int bossY)
    {
        int collides = 0;
        for (int i = bossX; i < bossX + 150; i++)
        {
            for (int ii = bossY; ii < bossY + 150; ii++)
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
     * when called, moves the laser a specific distance if visible == true
     */
    public void moveLaser()
    {
        y += LASER_SPEED;
        if (y <= 0)
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

    