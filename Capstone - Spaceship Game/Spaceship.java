
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Spaceship
{
    private String craft = "spaceship.png";
    private int x;
    private int dx;
    private Image image;
    
    public Spaceship()
    {
        ImageIcon ship = new ImageIcon(this.getClass().getResource(craft));
        image = ship.getImage();
        x = 275;
    }
    
    public void move()
    {
        x += dx;
    }
    
    public int getX()
    {
        return x;
    }
    
    public Image getImage()
    {
        return image;
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT)
        {
            dx = -1;
        }
        if (key == KeyEvent. VK_RIGHT)
        {
            dx = 1;
        }
    }
    
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
        {
            dx = 0;
        }
    }
}