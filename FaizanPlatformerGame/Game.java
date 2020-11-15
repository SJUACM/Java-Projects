import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Game
{
  private Grid grid;
  private int userRow;
  private int msElapsed;
  private int timesGet = 0;
  private int timesAvoid;
  private static long keyPressedMillis;
  private boolean alreadyPassed =false;
  boolean waterDeath = false;
  boolean spikeDeath = false;
  boolean gameOver = false;
  boolean birdDeath = false;
  boolean blockDeath = false;
  int jumps = 1;
  boolean jump = true;
  boolean level1 = false;
  boolean level2 = false;
  boolean level3 = false;
  boolean finish1 = false;
  boolean c = true; 
  boolean c2 = true;
  boolean img = true;
  boolean img2 = true;
  boolean img3 = true;
  boolean c3 = true;
  boolean c4 = true;
  boolean c5 = true;
  boolean complete = false;
  boolean lvl3 = false;
  static boolean show = true;
  static String currLevel = "Level 1";
  ImageIcon icon = new ImageIcon(getClass().getResource("icon.gif"));
  ImageIcon deathIcon = new ImageIcon(getClass().getResource("deathIcon.gif"));
  ImageIcon finishIcon = new ImageIcon(getClass().getResource("finishIcon.gif"));
  private AudioClip themeSong;
  private AudioClip coinSong;
  private AudioClip deathSong;
  private AudioClip finishSong;
  
  private String world = "c3g2g2g2g2g3g3g3g3s3g3g3g3c4g3g3g3g3g2b2g2g2g2s2g2g2g2g3g3g3s3g3g2g2g2w1w1g2g2g2g3c4g3g3g3g3s3g3g3g3g3c4w1w1g3g3g3g3g3g3g4g4g3g3g2c3g2g2s2g2g2w1w1g2g2g2";//this should be what starts scrolling
  private String world2 = "g2g2g3c4g4g4b4g3g3w1w1g2c3g2g2s2g2g2g2s2g2g2c3g2g3g3g3g2g2w1w1g2g2g2s2g2g2c3g2g3g3g3s3g3g3g3w1w1g2c3w1w1g2g2w1w1g2g2g2s2g2g2g2w1w1g2g2c3g3g3s3g3g3g2g2g2";
  private String world3 = "w1g2g2s2g2g2w1w1g2g2c3g3g3s3w1w1g2g2g2s2g2g2w1g3w1g2g2w1w1g3c4s3g3g3w1w1g3g3g3s3w1w1g2g2g3g3g3s3s2w1g2g2g2w1w1g2g2s2g3g3w1w1g2g2g2g2w1w1g3g3g3g3g3s3g2g2g2g2w1w1g2g2g3g3s3g3g3g2g2g2";
  
  public Game(String currLvl, boolean rep)
  {
    if (show) 
        JOptionPane.showMessageDialog(null, null, null, 2, icon);
    
    grid = new Grid(6, 12, "background.gif");
    userRow = 0;
    msElapsed = 0;
    timesAvoid = 0;
    updateTitle();
    grid.setImage(new Location(userRow, 0), "steveStill.gif"); 
    currLevel = currLvl;
    themeSong = Applet.newAudioClip(this.getClass().getResource("ShakeYourBootay.wav"));
    coinSong = Applet.newAudioClip(this.getClass().getResource("smb_coin.wav"));
    deathSong = Applet.newAudioClip(this.getClass().getResource("smb_mariodie.wav"));
    finishSong = Applet.newAudioClip(this.getClass().getResource("smb_world_clear.wav"));
    
    if (currLevel.equals("Level 3"))
    {
        level1 = true;
        level2 = true;
        level3 = false;
    }
    
  }
  
  public void play()
  {
    if (currLevel.equals("Level 1"))
    {
        grid.setImage(new Location(4, grid.getNumCols() - 12), "grassBlock.gif");
        grid.setImage(new Location(5, grid.getNumCols() - 12), "dirtBlock.gif");
        grid.setImage(new Location(4, grid.getNumCols() - 11), "grassBlock.gif");
        grid.setImage(new Location(5, grid.getNumCols() - 11), "dirtBlock.gif");
        grid.setImage(new Location(4, grid.getNumCols() - 10), "grassBlock.gif");
        grid.setImage(new Location(5, grid.getNumCols() - 10), "dirtBlock.gif");
        grid.setImage(new Location(4, grid.getNumCols() - 9), "grassBlock.gif");
        grid.setImage(new Location(5, grid.getNumCols() - 9), "dirtBlock.gif");
        grid.setImage(new Location(4, grid.getNumCols() - 8), "grassBlock.gif");
        grid.setImage(new Location(5, grid.getNumCols() - 8), "dirtBlock.gif");
        grid.setImage(new Location(4, grid.getNumCols() - 7), "grassBlock.gif");
        grid.setImage(new Location(5, grid.getNumCols() - 7), "dirtBlock.gif");
        grid.setImage(new Location(4, grid.getNumCols() - 6), "grassBlock.gif");
        grid.setImage(new Location(5, grid.getNumCols() - 6), "dirtBlock.gif");
        grid.setImage(new Location(4, grid.getNumCols() - 5), "grassBlock.gif");
        grid.setImage(new Location(5, grid.getNumCols() - 5), "dirtBlock.gif");
        grid.setImage(new Location(4, grid.getNumCols() - 4), "grassBlock.gif");
        grid.setImage(new Location(5, grid.getNumCols() - 4), "dirtBlock.gif");
        grid.setImage(new Location(4, grid.getNumCols() - 3), "grassBlock.gif");
        grid.setImage(new Location(5, grid.getNumCols() - 3), "dirtBlock.gif");
        grid.setImage(new Location(5, grid.getNumCols() - 2), "water.gif");
        grid.setImage(new Location(5, grid.getNumCols() - 1), "water.gif");
    }
    
    themeSong.loop();
    
    while (!isGameOver() )//&& !finish1)
    {
        
        if (currLevel.equals("Level 2") && c2)
        {
            deathSong.stop();
            finishSong.stop();
            themeSong.loop();
            grid.setImage(new Location(4, grid.getNumCols() - 12), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 12), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 11), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 11), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 10), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 10), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 9), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 9), "dirtBlock.gif");
            grid.setImage(new Location(3, grid.getNumCols() - 6), "spike.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 8), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 8), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 7), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 7), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 6), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 6), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 5), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 5), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 4), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 4), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 3), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 3), "dirtBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 2), "water.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 1), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 1), "grassBlock.gif");
            
            c2 = false;
        }
        
        if (currLevel.equals("Level 3") && c4)
        {
            finishSong.stop();
            themeSong.loop();
            grid.setImage(new Location(4, grid.getNumCols() - 12), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 12), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 11), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 11), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 10), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 10), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 9), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 9), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 8), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 8), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 7), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 7), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 6), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 6), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 5), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 5), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 4), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 4), "dirtBlock.gif");
            grid.setImage(new Location(4, grid.getNumCols() - 3), "grassBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 3), "dirtBlock.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 2), "water.gif");
            grid.setImage(new Location(5, grid.getNumCols() - 1), "water.gif");
            c4 = false;
        }
        
      grid.pause(100);
      handleKeyPress();
      if (msElapsed % 300 == 0)
      {
        gravity();
        scrollLeft();
        populateRightEdgeWithString();
      }
      
      updateTitle();
      msElapsed += 100;
    }
    
    
    if (spikeDeath)
        grid.setImage(new Location(userRow, 0), "steveSpike.gif");
    
    else if (waterDeath)
        grid.setImage(new Location(userRow, 0), "steveDead.gif");
    
    else if (birdDeath)
        grid.setImage(new Location(userRow, 0), "birdDeath.gif");
    
    else if (blockDeath)
        grid.setImage(new Location(userRow, 0), "steveSitting.gif");

    
    if (spikeDeath || waterDeath || birdDeath || blockDeath)
    {
        grid.setImage(new Location(0, 1), "G.gif");
        grid.setImage(new Location(0, 2), "A.gif");
        grid.setImage(new Location(0, 3), "M.gif");
        grid.setImage(new Location(0, 4), "E.gif");
        grid.setImage(new Location(0, 6), "O.gif");
        grid.setImage(new Location(0, 7), "V.gif");
        grid.setImage(new Location(0, 8), "E.gif");
        grid.setImage(new Location(0, 9), "R.gif");
        grid.setImage(new Location(0, 10), "!.gif");
        
        themeSong.stop();
        deathSong.play();
        int x = JOptionPane.showConfirmDialog(null, "Play Again?\nYour Score: " + timesGet, null, 2, 0, deathIcon);
        if (x == 0)
        {
           show = false;
           themeSong.stop();
            
           test();
        }
        
      
    }
    
    
  }

 int lastKey = -1;

public void keyPressed(KeyEvent arg0)
{
    // TODO Auto-generated method stub
    int codigo = arg0.getKeyCode();
    if (codigo != lastKey)
    {
        lastKey = codigo;
        if(codigo == KeyEvent.VK_SPACE)
        {
           keyPressedMillis = System.currentTimeMillis();           
        }
        
    }
    
}

  public void handleKeyPress()
  {     
      int key = grid.checkLastKeyPressed();
      int temp = userRow;
      
      if (jumps % 4 == 0)
      {
         jump = false;
      }
      if (grid.getImage(new Location(userRow + 1, 0)) != null && grid.getImage(new Location(userRow + 1, 0)).equals("grassBlock.gif"))
      {
          jump = true;
          jumps = 1; 
      }
      if (key == 38 && jump)
      {
          if (userRow != 0) 
          {    
              userRow--;
              handleCollision(new Location(userRow, 1));
              grid.setImage(new Location(userRow, 0), "steveStill.gif");
              grid.setImage(new Location(temp, 0), null);
              jumps++;
          }
      }

  }
   public void populateRightEdgeWithString()
   {
       if (!level1 && !level2 && currLevel.equals("Level 1"))
       {
            if(world.length() >= 2)
            {
                 String currentFloor = world.substring(0,2);
                 world = world.substring(2);
                 char floorType = currentFloor.charAt(0);
                 int height = Integer.parseInt(currentFloor.substring(1,2));

                 //set everything at grid.getNumRows-height and greater to the the floor type
                 //and everything smaller than grid.
                 
                 if (world.length() == 0)
                 {
                     grid.setImage(new Location(grid.getNumRows() - height - 1, grid.getNumCols() - 1), "finishFlag.gif");
                 }
                 
                 if (floorType == 'g')
                 {
                     grid.setImage(new Location(grid.getNumRows() - height, grid.getNumCols() - 1), "grassBlock.gif");

                     for (int i = 1; i < height; i++)
                     {
                         grid.setImage(new Location(grid.getNumRows() - i, grid.getNumCols() - 1), "dirtBlock.gif");
                     }
                 }
                 else if (floorType == 's')
                 {
                     grid.setImage(new Location(grid.getNumRows() - height - 1, grid.getNumCols() - 1), "spike.gif");
                     grid.setImage(new Location(grid.getNumRows() - height, grid.getNumCols() - 1), "grassBlock.gif");

                     for (int i = 1; i < height; i++)
                     {
                         grid.setImage(new Location(grid.getNumRows() - i, grid.getNumCols() - 1), "dirtBlock.gif");
                     }
                 }
                 else if (floorType == 'c')
                 {
                     grid.setImage(new Location(grid.getNumRows() - height - 1, grid.getNumCols() - 1), "coin.gif");
                     grid.setImage(new Location(grid.getNumRows() - height + 1, grid.getNumCols() - 1), "grassBlock.gif");

                     for (int i = 2; i < height; i++)
                     {
                         grid.setImage(new Location(grid.getNumRows() - height + i, grid.getNumCols() - 1), "dirtBlock.gif");
                     }
                 }
                 else if (floorType == 'w')
                 {
                     grid.setImage(new Location(grid.getNumRows() - 1, grid.getNumCols() - 1), "water.gif");
                 }
                 else if (floorType == 'b')
                 {
                     grid.setImage(new Location(grid.getNumRows() - height - 2, grid.getNumCols() - 1), "bird.gif");
                     grid.setImage(new Location(grid.getNumRows() - height, grid.getNumCols() - 1), "grassBlock.gif");

                     for (int i = 1; i < height; i++)
                     {
                         grid.setImage(new Location(grid.getNumRows() - height + i, grid.getNumCols() - 1), "dirtBlock.gif");
                     }
                 }
            }
            
            if (finish1 && img)
            {
                level1 = true;
                grid.setImage(new Location(userRow, 0), "steveFlag.gif");
                img = false;

                grid.setImage(new Location(0, 2), "F.gif");
                grid.setImage(new Location(0, 3), "I.gif");
                grid.setImage(new Location(0, 4), "N.gif");
                grid.setImage(new Location(0, 5), "I.gif");
                grid.setImage(new Location(0, 6), "S.gif");
                grid.setImage(new Location(0, 7), "H.gif");
                grid.setImage(new Location(0,8), "!.gif");
            }

            if (level1 && c && currLevel.equals("Level 1"))
            {
                themeSong.stop();
                finishSong.play();
                JOptionPane.showMessageDialog(null, "CONGRATULATIONS YOU HAVE COMPLETED LEVEL 1!!\nClick OK to continue to Level 2!",null,2,finishIcon);
                grid.setImage(new Location(userRow, 0), "steveWalking.gif");
                grid.setImage(new Location(0, 2), null);
                grid.setImage(new Location(0, 3), null);
                grid.setImage(new Location(0, 4), null);
                grid.setImage(new Location(0, 5), null);
                grid.setImage(new Location(0, 6), null);
                grid.setImage(new Location(0, 7), null);
                grid.setImage(new Location(0,8), null);
                c = false;
                finish1 = false;
            }

       }
       
       if ((level1 && !level2 && !level3) || currLevel.equals("Level 2"))
       { 
           currLevel = "Level 2";
           if(world2.length() >= 2)
           {
               
                 String currentFloor = world2.substring(0,2);
                 world2 = world2.substring(2);
                 char floorType = currentFloor.charAt(0);
                 int height = Integer.parseInt(currentFloor.substring(1,2));

                 //set everything at grid.getNumRows-height and greater to the the floor type
                 //and everything smaller than grid.

                 if (world2.length() == 0)
                 {
                     grid.setImage(new Location(grid.getNumRows() - height - 1, grid.getNumCols() - 1), "finishFlag.gif");
                 }
                 
                 if (floorType == 'g')
                 {
                     grid.setImage(new Location(grid.getNumRows() - height, grid.getNumCols() - 1), "grassBlock.gif");

                     for (int i = 1; i < height; i++)
                     {
                         grid.setImage(new Location(grid.getNumRows() - i, grid.getNumCols() - 1), "dirtBlock.gif");
                     }
                 }
                 else if (floorType == 's')
                 {
                     grid.setImage(new Location(grid.getNumRows() - height - 1, grid.getNumCols() - 1), "spike.gif");
                     grid.setImage(new Location(grid.getNumRows() - height, grid.getNumCols() - 1), "grassBlock.gif");

                     for (int i = 1; i < height; i++)
                     {
                         grid.setImage(new Location(grid.getNumRows() - i, grid.getNumCols() - 1), "dirtBlock.gif");
                     }
                 }
                 else if (floorType == 'c')
                 {
                     grid.setImage(new Location(grid.getNumRows() - height - 1, grid.getNumCols() - 1), "coin.gif");
                     grid.setImage(new Location(grid.getNumRows() - height + 1, grid.getNumCols() - 1), "grassBlock.gif");

                     for (int i = 2; i < height; i++)
                     {
                         grid.setImage(new Location(grid.getNumRows() - height + i, grid.getNumCols() - 1), "dirtBlock.gif");
                     }
                 }
                 else if (floorType == 'w')
                 {
                     grid.setImage(new Location(grid.getNumRows() - 1, grid.getNumCols() - 1), "water.gif");
                 }
                 else if (floorType == 'b')
                 {
                     grid.setImage(new Location(grid.getNumRows() - height - 2, grid.getNumCols() - 1), "bird.gif");
                     grid.setImage(new Location(grid.getNumRows() - height, grid.getNumCols() - 1), "grassBlock.gif");

                     for (int i = 1; i < height; i++)
                     {
                         grid.setImage(new Location(grid.getNumRows() - height + i, grid.getNumCols() - 1), "dirtBlock.gif");
                     }
                 }
            }
           
           if (finish1 && img2)
           {
               level2 = true;
               grid.setImage(new Location(userRow, 0), "steveFlag.gif");
               img2 = false;
               finish1 = false;

               grid.setImage(new Location(0, 2), "F.gif");
               grid.setImage(new Location(0, 3), "I.gif");
               grid.setImage(new Location(0, 4), "N.gif");
               grid.setImage(new Location(0, 5), "I.gif");
               grid.setImage(new Location(0, 6), "S.gif");
               grid.setImage(new Location(0, 7), "H.gif");
               grid.setImage(new Location(0,8), "!.gif");
           }

           if (level2 && c3 && currLevel.equals("Level 2") && !lvl3)
           {
               themeSong.stop();
               finishSong.play();
               JOptionPane.showMessageDialog(null, "CONGRATULATIONS YOU HAVE COMPLETED LEVEL 2!!\nClick OK to continue to Level 3!",null,2,finishIcon);
               grid.setImage(new Location(userRow, 0), "steveWalking.gif");
               grid.setImage(new Location(0, 2), null);
               grid.setImage(new Location(0, 3), null);
               grid.setImage(new Location(0, 4), null);
               grid.setImage(new Location(0, 5), null);
               grid.setImage(new Location(0, 6), null);
               grid.setImage(new Location(0, 7), null);
               grid.setImage(new Location(0, 8), null);
               c3 = false;
               level1 = true;
               level2 = true;
                      
           }
       }
       
       if (level1 && level2 && !level3)
       { 
           currLevel = "Level 3";
           lvl3 = true;
           if (world3.length() >= 2)
           {
                 String currentFloor = world3.substring(0,2);
                 world3 = world3.substring(2);
                 char floorType = currentFloor.charAt(0);
                 int height = Integer.parseInt(currentFloor.substring(1,2));

                 //set everything at grid.getNumRows-height and greater to the the floor type
                 //and everything smaller than grid.

                 if (world3.length() == 0)
                 {
                     grid.setImage(new Location(grid.getNumRows() - height - 1, grid.getNumCols() - 1), "finishFlag.gif");
                 }
                 
                 if (floorType == 'g')
                 {
                     grid.setImage(new Location(grid.getNumRows() - height, grid.getNumCols() - 1), "grassBlock.gif");

                     for (int i = 1; i < height; i++)
                     {
                         grid.setImage(new Location(grid.getNumRows() - i, grid.getNumCols() - 1), "dirtBlock.gif");
                     }
                 }
                 else if (floorType == 's')
                 {
                     grid.setImage(new Location(grid.getNumRows() - height - 1, grid.getNumCols() - 1), "spike.gif");
                     grid.setImage(new Location(grid.getNumRows() - height, grid.getNumCols() - 1), "grassBlock.gif");

                     for (int i = 1; i < height; i++)
                     {
                         grid.setImage(new Location(grid.getNumRows() - i, grid.getNumCols() - 1), "dirtBlock.gif");
                     }
                 }
                 else if (floorType == 'c')
                 {
                     grid.setImage(new Location(grid.getNumRows() - height - 1, grid.getNumCols() - 1), "coin.gif");
                     grid.setImage(new Location(grid.getNumRows() - height + 1, grid.getNumCols() - 1), "grassBlock.gif");

                     for (int i = 2; i < height; i++)
                     {
                         grid.setImage(new Location(grid.getNumRows() - height + i, grid.getNumCols() - 1), "dirtBlock.gif");
                     }
                 }
                 else if (floorType == 'w')
                 {
                     grid.setImage(new Location(grid.getNumRows() - 1, grid.getNumCols() - 1), "water.gif");
                 }
                 else if (floorType == 'b')
                 {
                     grid.setImage(new Location(grid.getNumRows() - height - 2, grid.getNumCols() - 1), "bird.gif");
                     grid.setImage(new Location(grid.getNumRows() - height, grid.getNumCols() - 1), "grassBlock.gif");

                     for (int i = 1; i < height; i++)
                     {
                         grid.setImage(new Location(grid.getNumRows() - height + i, grid.getNumCols() - 1), "dirtBlock.gif");
                     }
                 }
                 
                 
            }
           
           if (finish1 && img3)
           {
               level3 = false;
               grid.setImage(new Location(userRow, 0), "steveFlag.gif");
               img3 = false;
               finish1 = false;
               complete = true;
               
               grid.setImage(new Location(0, 2), "F.gif");
               grid.setImage(new Location(0, 3), "I.gif");
               grid.setImage(new Location(0, 4), "N.gif");
               grid.setImage(new Location(0, 5), "I.gif");
               grid.setImage(new Location(0, 6), "S.gif");
               grid.setImage(new Location(0, 7), "H.gif");
               grid.setImage(new Location(0,8), "!.gif");
               
               if (!level3 && complete && c5)
               {
                  themeSong.stop();
                  finishSong.play();
                  JOptionPane.showMessageDialog(null, "CONGRATULATIONS YOU HAVE COMPLETED JUMPMAN!!");
                  grid.setImage(new Location(0, 2), null);
                  grid.setImage(new Location(0, 3), null);
                  grid.setImage(new Location(0, 4), null);
                  grid.setImage(new Location(0, 5), null);
                  grid.setImage(new Location(0, 6), null);
                  grid.setImage(new Location(0, 7), null);
                  grid.setImage(new Location(0,8), null);
                  grid.setBackground("thanks.gif");
                  c5 = false;
               }
           }
 
       }
       
   }
   
   public void setUserImage()
   {
       grid.setImage(new Location(userRow, 0), "steveWalking.gif");
       if (msElapsed % 100 == 0)
           grid.setImage(new Location(userRow, 0), "steveStill.gif");
   }
   
   public void gravity()
   {
       Location locUnderUser = null;
       
       if (userRow + 1 < grid.getNumRows())
            locUnderUser = new Location(userRow + 1, 0);
       
       if (locUnderUser!=null)
       {
           String imgUnderUser = grid.getImage(locUnderUser);
           
           if (imgUnderUser != null && imgUnderUser.equals("water.gif"))
           {
               userRow++;
               handleCollision(new Location(userRow, 0));
               grid.setImage(new Location(userRow, 0), "steveDead.gif");
           }
           
           else if (imgUnderUser != null && imgUnderUser.equals("spike.gif"))
           {
               userRow++;
               handleCollision(new Location(userRow, 0));
               grid.setImage(new Location(userRow, 0), "steveSpike.gif");
           }
           
           else if (imgUnderUser == null)
           {
                userRow++;
                handleCollision(new Location(userRow, 1));
                grid.setImage(new Location(userRow, 0), "steveWalking.gif");
                grid.setImage(new Location(userRow-1, 0), null);
           }
       }
   }
    
  public void populateRightEdge()
  {

  }
  
  public void scrollLeft()
  {
      handleCollision(new Location(userRow, 0));
      handleCollision(new Location(userRow, 1));
      
      for (int i = 0; i < grid.getNumRows(); i++)
      {
          for (int j = 0; j < grid.getNumCols(); j++)
          {
              if (grid.getImage(new Location(i,j)) != null) //&& !grid.getImage(new Location(i,j)).equals("steveWalking.gif") && !grid.getImage(new Location(i,j)).equals("steveStill.gif"))
              {
                  if (j != 0) //&& grid.getImage(new Location(i,j - 1)) != null && !grid.getImage(new Location(i,j - 1)).equals("user.gif"))
                  {
                     
                    grid.setImage(new Location(i, j - 1), grid.getImage(new Location(i,j)));
                    
                    if (msElapsed % 200 == 0)
                    {
                        grid.setImage(new Location(userRow, 0), "steveWalking.gif"); 
                    }
                    else
                    {
                        grid.setImage(new Location(userRow, 0), "steveStill.gif"); 
                    }
                    
                  }
                  
                  grid.setImage(new Location(i, j), null);
                  
              }
          }
      }
  }
  
  public void handleCollision(Location loc)
  {
        if (grid.getImage(loc)==null)
        {

        }

        else if(grid.getImage(loc).equals("grassBlock.gif"))
        {
            blockDeath = true;
            gameOver = true;
        }
        
        else if (grid.getImage(loc).equals("coin.gif"))
        {
            coinSong.play();
            timesGet++;
            grid.setImage(loc, null);
        }

        else if (grid.getImage(loc).equals("spike.gif"))
        {
            grid.setImage(loc, "steveSpike.gif");
            spikeDeath = true;
            gameOver = true;
        }
        
        else if(grid.getImage(loc).equals("water.gif"))
        {
            grid.setImage(loc, "steveDead.gif");
            waterDeath = true;
            gameOver = true;
        }
  
        else if (grid.getImage(loc).equals("bird.gif"))
        {
            birdDeath = true;
            gameOver = true;
        }
        
        else if (grid.getImage(loc).equals("finishFlag.gif"))
        {
            finish1 = true;
        }
        
  }
  
  public int getScore()
  {
    return timesGet;
  }
  
  public void updateTitle()
  {
    grid.setTitle("Jumpman " +  currLevel + " Score: " + getScore());
  }
  
  public boolean isGameOver()
  {
    return gameOver;
  }
  
  public static void test()
  {
    Game game = new Game(currLevel, show);
    game.play();
  }
  
  public static void main(String[] args)
  {
    test();
  }
}