import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class BossShip
{
    private String bosscraft = "BossShip.png";
    private int x;
    private Image image;
    private ArrayList lasers;

    /**
     * constructs the boss ship and assigns private variables appropriate values
     */
    public BossShip()
    {
        ImageIcon boss = new ImageIcon(this.getClass().getResource(bosscraft));
        image = boss.getImage();
        x = 550;
        lasers = new ArrayList();
    }
    
    /**
     * moves the ship based on the input int value
     */
    public void moveBoss(int changeX)
    {
        x += changeX;
    }
    
    /**
     * returns the current X position
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * returns the image
     */
    public Image getImage()
    {
        return image;
    }
    
    /**
     * returns the ArrayList lasers
     */
    public ArrayList getLasers()
    {
        return lasers;
    }
    
    /**
     * when called, creates a boss laser at the current position with 3 way randomized direction
     */
    public void fire()
    {
        int direct = (int)(Math.random()*3);
        lasers.add(new BossLaser(this.getX()+ 60, 170, direct));
    }
}
    