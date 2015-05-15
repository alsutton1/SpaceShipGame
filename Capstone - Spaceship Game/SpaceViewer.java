

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SpaceViewer extends JFrame
{
    private SpaceBoard space;
    
    /**
     * focuses on the window at the start of the program
     */
    class FrameWindowListener extends WindowAdapter
    {
        public void windowOpened(WindowEvent event)
        {
            space.requestFocusInWindow();
        }
    }
    
    
    /**
     * creates the SpaceBoard()
     * adds the SpaceBoard() to the JFrame
     */
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
    
    /**
     * starts the program
     */
    public static void main(String[] args)
    {
        new SpaceViewer();
    }
}