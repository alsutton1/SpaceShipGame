
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
import java.util.ArrayList;

public class SpaceBoard extends JComponent implements ActionListener
{
    private Timer timer;
    private Spaceship ship;
    private BossShip boss;
    private SpaceBackground background;
    private ArrayList lasers;
    
    private int changeX;
    private int bossMove;
    private boolean fired;

    public SpaceBoard()
    {
        addKeyListener(new KeyStrokeListener());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        ship = new Spaceship();
        boss = new BossShip();
        background = new SpaceBackground();
        lasers = new ArrayList();

        bossMove = 5;
        fired = false;

        timer = new Timer(5,this);
        timer.start();
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background.getImage(),0,0,this);
        g2.drawImage(ship.getImage(), ship.getX(), 800, this);
        g2.drawImage(boss.getImage(), boss.getX(), 75, this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public ArrayList getLasers()
    {
        return lasers;
    }

    public void actionPerformed(ActionEvent e)
    {
        ship.move(changeX);
        
        if ((boss.getX() + bossMove) >= 1000)
        {
            bossMove = -5;
        }
        else if ((boss.getX() + bossMove) <= 5)
        {
            bossMove = 5;
        }
        
        if (fired == true)
        {
            ship.fire();
            fired = false;
        }
        
        boss.moveBoss(bossMove);
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

            if (key == KeyEvent.VK_SPACE)
            {
                fired = true;
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