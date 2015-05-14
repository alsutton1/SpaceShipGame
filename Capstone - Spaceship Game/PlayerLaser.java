import java.awt.Image;
import javax.swing.ImageIcon;

public class PlayerLaser {
    private String laser = "player-laser.png";
    private int x, y;
    private Image image;
    private boolean visible;

    private final int LASER_SPEED = -10;

    public PlayerLaser(int x, int y)
    {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(laser));

        image = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
    }

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
    
    public void moveLaser()
    {
        y += LASER_SPEED;
        if (y <= 0)
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

    