import java.awt.Image;
import javax.swing.ImageIcon;

public class SpaceBackground
{
    private String space = "spacebackground.jpg";
    private Image image;
    
    public SpaceBackground()
    {
        ImageIcon background = new ImageIcon(this.getClass().getResource(space));
        image = background.getImage();
    }
    
    public Image getImage()
    {
        return image;
    }
}
    