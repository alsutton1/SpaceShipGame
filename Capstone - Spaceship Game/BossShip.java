import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class BossShip
{
    private String bosscraft = "BossShip.png";
    private int x;
    private Image image;
    private ArrayList lasers;

    
    public BossShip()
    {
        ImageIcon boss = new ImageIcon(this.getClass().getResource(bosscraft));
        image = boss.getImage();
        x = 550;
        lasers = new ArrayList();
    }
    
    public void moveBoss(int changeX)
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
    
    public ArrayList getLasers()
    {
        return lasers;
    }
    
    public void fire()
    {
        int direct = (int)(Math.random()*3);
        lasers.add(new BossLaser(this.getX()+ 60, 170, direct));
    }
}
    