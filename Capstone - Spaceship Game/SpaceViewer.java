

import javax.swing.JFrame;

public class SpaceViewer extends JFrame
{
    public SpaceViewer()
    {
        add(new SpaceBoard());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
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