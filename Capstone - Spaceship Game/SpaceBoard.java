
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.Timer;


public class SpaceBoard extends JComponent implements ActionListener
{
    private Timer timer;
    private Spaceship ship;
    private int changeX;

    public SpaceBoard()
    {
        addKeyListener(new KeyStrokeListener());
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
        g2.drawImage(ship.getImage(), ship.getX(), 450, this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e)
    {
        ship.move(changeX);
        repaint();
    }

    public class KeyStrokeListener implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT)
            {
                changeX = -10;           
            }
            else if (key == KeyEvent.VK_RIGHT)
            {
                changeX = 10;           
            }
        } 

        public void keyReleased(KeyEvent e)
        {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
            {
                changeX = 0;
            }
        }
        
        public void keyTyped(KeyEvent event) 
        {}
    }
}