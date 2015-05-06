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

    public void checkCollision()
    {
        int nums = 0;
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

    