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
        ImageIcon ii = new ImageIcon(this.getClass().getResource("player-laser.png"));
        
        image = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
        this.direction = direction;
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
}