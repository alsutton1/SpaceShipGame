import java.awt.Image;
import javax.swing.ImageIcon;

public class SpaceBackground
{
    private String space = "spacebackground.jpg";
    private Image image;
    
    /**
     * creates the background image for the game
     */
    public SpaceBackground()
    {
        ImageIcon background = new ImageIcon(this.getClass().getResource(space));
        image = background.getImage();
    }
    
    /**
     * returns the initialized image
     */
    public Image getImage()
    {
        return image;
    }
}
    