
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Spaceship
{
    private String craft = "spaceshipimage.png";
    private int x;
    private Image image;
    private ArrayList lasers;

    public Spaceship()
    {
        ImageIcon ship = new ImageIcon(this.getClass().getResource(craft));
        image = ship.getImage();
        x = 600;
        lasers = new ArrayList();
    }

    
    public void move(int changeX)
    {
        int changed = x + changeX;
        if (changed > 10 && changed < 1140)
        {
            x = changed;
        }
    }

    public int getX()
    {
        return x;
    }

    public Image getImage()
    {
        return image;
    }
    
    public ArrayList getLasers()
    {
        return lasers;
    }
    
    public void fire()
    {
        lasers.add(new PlayerLaser(this.getX(), 800));
    }
}
