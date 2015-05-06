import java.awt.Image;
import javax.swing.ImageIcon;

public class BossLaser {
    
    private int x, y;
    private Image image;
    private boolean visible;
    private int direction;
    
    private final int LASER_SPEED = 3;
    
    public BossLaser(int x, int y, int direction)
    {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("boss-laser.png"));
        
        image = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    
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
    
    public Image getImage()
    {
        return image;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public boolean isVisible()
    {
        return visible;
    }
}