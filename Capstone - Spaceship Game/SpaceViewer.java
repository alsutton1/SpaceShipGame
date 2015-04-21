

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SpaceViewer extends JFrame
{
    private SpaceBoard space;
    
    class FrameWindowListener extends WindowAdapter
    {
        public void windowOpened(WindowEvent event)
        {
            space.requestFocusInWindow();
        }
    }
    
    public SpaceViewer()
    {
        space = new SpaceBoard();
        add(space);
        
        this.addWindowListener(new FrameWindowListener());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,900);
        setLocationRelativeTo(null);
        setTitle("SpaceShip Game");
        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new SpaceViewer();
    }
}