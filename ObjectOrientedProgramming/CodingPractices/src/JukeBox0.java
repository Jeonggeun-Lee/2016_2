/**
 * PP06.18 주크박스 프로그램을 수정해서
 * 재생과 정지 버튼 기능이 키보드 단축키를 이용해도 제어되게 하라.
*/

//********************************************************************
//  JukeBoxControls.java       Java Foundations
//
//  Represents the control panel for the juke box.
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;
import java.net.URL;

class JukeBox0Controls extends JPanel
{
   private JComboBox musicCombo;
   private JButton stopButton, playButton;
   private AudioClip[] music;
   public AudioClip current;
   
   public AudioClip getCurrentAoudioClip(){
	   return current;
   }

   //-----------------------------------------------------------------
   //  Sets up the GUI for the juke box.
   //-----------------------------------------------------------------
   public JukeBox0Controls()
   {
	   
	   URL url1, url2, url3, url4, url5, url6;
	   url1 = url2 = url3 = url4 = url5 = url6 = null;
	   // Obtain and store the audio clips to play
      try
      {
         url1 = new URL ("file", "localhost", "westernBeat.wav");
         url2 = new URL ("file", "localhost", "classical.wav");
         url3 = new URL ("file", "localhost", "jeopardy.au");
         url4 = new URL ("file", "localhost", "newAgeRythm.wav");
         url5 = new URL ("file", "localhost", "eightiesJam.wav");
         url6 = new URL ("file", "localhost", "hitchcock.wav");
      }
      catch (Exception exception) {}

      music = new AudioClip[7];
      music[0] = null;  // Corresponds to "Make a Selection..."
      music[1] = JApplet.newAudioClip (url1);
      music[2] = JApplet.newAudioClip (url2);
      music[3] = JApplet.newAudioClip (url3);
      music[4] = JApplet.newAudioClip (url4);
      music[5] = JApplet.newAudioClip (url5);
      music[6] = JApplet.newAudioClip (url6);

      // Create the list of strings for the combo box options
      String[] musicNames = {"Make A Selection...", "Western Beat",
               "Classical Melody", "Jeopardy Theme", "New Age Rythm",
               "Eighties Jam", "Alfred Hitchcock's Theme"};

      musicCombo = new JComboBox (musicNames);
      musicCombo.setBackground (Color.cyan);

      //  Set up the buttons
      playButton = new JButton ("Play", new ImageIcon ("play.gif"));
      playButton.setMnemonic('p');
      playButton.setBackground (Color.cyan);
      stopButton = new JButton ("Stop", new ImageIcon ("stop.gif"));
      stopButton.setMnemonic('s');
      stopButton.setBackground (Color.cyan);

      //  Set up this panel
      setPreferredSize (new Dimension (250, 100));
      setBackground (Color.cyan);
      add (musicCombo);
      add (playButton);
      add (stopButton);

      musicCombo.addActionListener (new ComboListener());
      stopButton.addActionListener (new ButtonListener());
     
      playButton.addActionListener (new ButtonListener());
      playButton.addKeyListener (new PSListener());
      current = null;
   }

   //*****************************************************************
   //  Represents the action listener for the combo box.
   //*****************************************************************
   private class ComboListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Stops playing the current selection (if any) and resets
      //  the current selection to the one chosen.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
         if (current != null)
            current.stop();

         current = music[musicCombo.getSelectedIndex()];
      }
    }

   //*****************************************************************
   //  Represents the action listener for both control buttons.
   //*****************************************************************

   private class ButtonListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Stops the current selection (if any) in either case. If
      //  the play button was pressed, start playing it again.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
    	 
         if (current != null)
            current.stop();

         if (event.getSource() == playButton)
            if (current != null)
               current.play();
      }  
   }
   
   private class PSListener implements KeyListener
   {
   	   public void keyPressed(KeyEvent event)
   	   {
   		   
   		   if(event.getKeyChar() == 'p' || event.getKeyChar() == 's')
   			   if (current != null)
   				   current.stop();

   	       if (event.getKeyChar() == 'p')
   	    	   if (current != null)
   	               current.play();
   	   }
   	   public void keyReleased(KeyEvent event){}
   	   public void keyTyped(KeyEvent event){}
   }


   
  
}




//********************************************************************
//JukeBox.java       Java Foundations
//
//Demonstrates the use of a combo box.
//********************************************************************

public class JukeBox0
{
//-----------------------------------------------------------------
//  Creates and displays the controls for a juke box.
//-----------------------------------------------------------------
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Java Juke Box");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		JukeBox0Controls jukeBox0Controls = new JukeBox0Controls();
		
		frame.getContentPane().add(jukeBox0Controls);
		
		frame.pack();
		frame.setVisible(true);
	}
}
