
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;


public class Spaceship
{
    private String craft = "spaceship.png";
    private int x;
    private Image image;

    public Spaceship()
    {
        ImageIcon ship = new ImageIcon(this.getClass().getResource(craft));
        image = ship.getImage();
        x = 275;
    }

    public void move(int changeX)
    {
        x += changeX;
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