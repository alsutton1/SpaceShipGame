
import java.awt.Image;
import javax.swing.ImageIcon;

public class Spaceship
{
    private String craft = "spaceshipimage.png";
    private int x;
    private Image image;

    public Spaceship()
    {
        ImageIcon ship = new ImageIcon(this.getClass().getResource(craft));
        image = ship.getImage();
        x = 600;
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
}