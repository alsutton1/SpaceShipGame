
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
    
    private int changeX;
    private int bossMove;
    private int addBossLaser;
    private int roomHeight;
    private int playerhealth;
    private int bosshealth;
    private Rectangle bossBar;

    public SpaceBoard()
    {
        addKeyListener(new KeyStrokeListener());
        setFocusable(true);
        setDoubleBuffered(true);

        ship = new Spaceship();
        boss = new BossShip();
        background = new SpaceBackground();
        addBossLaser = 0;
        roomHeight = 900;
        playerhealth = 3;
        bosshealth = 100;
        bossBar = new Rectangle(0, 0, 12*bosshealth, 10);

        bossMove = 5;

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
        
        ArrayList lasers = ship.getLasers();
        
        for (int i = 0; i < lasers.size(); i++)
        {
            PlayerLaser laser = (PlayerLaser) lasers.get(i);
            g2.drawImage(laser.getImage(), laser.getX()+12, laser.getY(), this);
        }
        
        ArrayList bossLasers = boss.getLasers();

        for (int i = 0; i < bossLasers.size(); i++)
        {
            BossLaser bosslaser = (BossLaser) bossLasers.get(i);
            g2.drawImage(bosslaser.getImage(), bosslaser.getX()+25, bosslaser.getY(), this);
        }
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (playerhealth == 0)
        {
            System.out.println("Mission failed!");
        }
        
        if (bosshealth == 0)
        {
            System.out.println("Mission success! Boss defeated!");
        }
        ship.move(changeX);
        
        int shipX = ship.getX();
        int shipY = 800;
        int bossX = boss.getX();
        int bossY = 75;
        
        if ((boss.getX() + bossMove) >= 1000)
        {
            bossMove = -5;
        }
        else if ((boss.getX() + bossMove) <= 5)
        {
            bossMove = 5;
        }
        
        ArrayList lasers = ship.getLasers();
        
        for (int i = 0; i < lasers.size(); i++)
        {
            PlayerLaser laser = (PlayerLaser) lasers.get(i);
            if (laser.isVisible())
            {
                laser.moveLaser();
                laser.checkCollision(bossX, bossY);
            }
            else
            {
                lasers.remove(i);
            }
        }
        
        addBossLaser++;
        
        if (addBossLaser > 10)
        {
            boss.fire();
            addBossLaser = 0;
        }
        
        ArrayList bossLasers = boss.getLasers();
        
        for (int i = 0; i < bossLasers.size(); i++)
        {
            BossLaser bosslaser = (BossLaser) bossLasers.get(i);
            if (bosslaser.isVisible())
            {
                bosslaser.moveLaser(roomHeight);
                int collides = bosslaser.checkCollision(shipX, shipY);
                if (collides == 1)
                {
                    playerhealth--;
                }
            }
            else
            {
                bossLasers.remove(i);
            }
        }
        
        boss.moveBoss(bossMove);
        
        bossBar = new Rectangle(0, 0, 12*bosshealth, 10);
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

            if (key == KeyEvent.VK_UP)
            {
                ship.fire();
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