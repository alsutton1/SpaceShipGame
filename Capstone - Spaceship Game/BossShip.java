import java.awt.Image;
import javax.swing.ImageIcon;


public class BossShip
{
    private String bosscraft = "BossShip.png";
    private int x;
    private Image image;
    
    public BossShip()
    {
        ImageIcon boss = new ImageIcon(this.getClass().getResource(bosscraft));
        image = boss.getImage();
        x = 550;
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
}
    