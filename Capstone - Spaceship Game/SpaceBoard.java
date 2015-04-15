
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;


public class SpaceBoard extends JPanel implements ActionListener
{
    private Timer timer;
    private Spaceship ship;
    
    public SpaceBoard()
    {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        
        ship = new Spaceship();
        
        timer = new Timer(5,this);
        timer.start();
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(ship.getImage(), ship.getX(), 400, this);
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        ship.move();
        repaint();
    }
    
    private class TAdapter extends KeyAdapter
    {
        public void keyReleased(KeyEvent e)
        {
            ship.keyReleased(e);
        }
        
        public void keyPressed(KeyEvent e)
        {
            ship.keyPressed(e);
        }
    }
}