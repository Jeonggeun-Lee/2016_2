/**
wk06_java10_201415060 Ŭ������  
��ũ�ڽ� �г��� ���ϰ� ���̰� ���� �ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

/**
 * PP06.18 ��ũ�ڽ� ���α׷��� �����ؼ�
 * ����� ���� ��ư ����� Ű���� ����Ű�� �̿��ص� ����ǰ� �϶�.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;
import java.net.URL;

/**��ũ�ڽ� �г�*/
class JukeBoxControls extends JPanel
{
	/**�޺��ڽ� ����*/
   private JComboBox musicCombo;
   /**��� ���� ��ư ����*/
   private JButton stopButton, playButton;
   /**���� �迭 ����*/
   private AudioClip[] music;
   /**������� ���� ����*/
   private AudioClip current;
   
   /**�г� ������*/
   public JukeBoxControls()
   {
	   
	   /**���� �ּ� ����*/
	   URL url1, url2, url3, url4, url5, url6;
	   /**�η� �ʱ�ȭ*/
	   url1 = url2 = url3 = url4 = url5 = url6 = null;

	   /**������ �ּ� ����*/
	   try
      {
		   /***/
		   url1 = new URL ("file", "localhost", "westernBeat.wav");
		   /***/
		   url2 = new URL ("file", "localhost", "classical.wav");
		   /***/
		   url3 = new URL ("file", "localhost", "jeopardy.au");
		   /***/
		   url4 = new URL ("file", "localhost", "newAgeRythm.wav");
		   /***/
		   url5 = new URL ("file", "localhost", "eightiesJam.wav");
		   /***/
		   url6 = new URL ("file", "localhost", "hitchcock.wav");
      }
	   /***/
	   catch (Exception exception) {}

	   /**���� �迭 ����*/
	   music = new AudioClip[7];
	   /**���� �迭 ���� ����*/
	   music[0] = null;
	   /***/
	   music[1] = JApplet.newAudioClip (url1);
	   /***/
	   music[2] = JApplet.newAudioClip (url2);
	   /***/
	   music[3] = JApplet.newAudioClip (url3);
	   /***/
	   music[4] = JApplet.newAudioClip (url4);
	   /***/
	   music[5] = JApplet.newAudioClip (url5);
	   /***/
	   music[6] = JApplet.newAudioClip (url6);

	   /**���� �̸� ���ڿ��� �迭 ����*/
      String[] musicNames = {"Make A Selection...", "Western Beat",
               "Classical Melody", "Jeopardy Theme", "New Age Rythm",
               "Eighties Jam", "Alfred Hitchcock's Theme"};
      /**�޺� �ڽ� ����*/
      musicCombo = new JComboBox (musicNames);
      /**�޺� �ڽ� ��� ����*/
      musicCombo.setBackground (Color.cyan);


      /**��� ��ư ����*/
      playButton = new JButton ("Play", new ImageIcon ("play.gif"));
      /**��� ��ư ����Ű ����*/
      playButton.setMnemonic('p');
      /**��ư ���� ����*/
      playButton.setBackground (Color.cyan);
      /**���� ��ư ����*/
      stopButton = new JButton ("Stop", new ImageIcon ("stop.gif"));
      /**���� ��ư ����Ű ����*/
      stopButton.setMnemonic('s');
      /**���� ��ư ���� ����*/
      stopButton.setBackground (Color.cyan);

      /**�г� ũ�� ����*/
      setPreferredSize (new Dimension (250, 100));
      /**�г� ���� ����*/
      setBackground (Color.cyan);
      /**�޺� ����*/
      add (musicCombo);
      /**��ư ����*/
      add (playButton);
      /***/
      add (stopButton);

      /**�޺��� ������ ����*/
      musicCombo.addActionListener (new ComboListener());
      /**��ư�� ������ ����*/
      stopButton.addActionListener (new ButtonListener());
      /***/
      playButton.addActionListener (new ButtonListener());
      /**���� ���� �η� �ʱ�ȭ*/
      current = null;
   }
   
   /**�޺� ������*/
   private class ComboListener implements ActionListener
   {
	   /**�޺� �׸��� �ٲٸ� ȣ���ϴ� �޼ҵ�*/
	   public void actionPerformed (ActionEvent event)
	   {
		   /**���� ��� ���� ������ ������*/
		   if (current != null)
			   /**��� ���� ������ ����*/
			   current.stop();

		   /**�޺����� ������ ������ ���� ����ϴ� ��������*/
		   current = music[musicCombo.getSelectedIndex()];
      }
   }

   /**��ư ������*/
   private class ButtonListener implements ActionListener
   {
	   /**��ư ������ ȣ���ϴ� �޼ҵ�*/
	   public void actionPerformed (ActionEvent event)
	   {
		   /**��� ���� ������ ������*/
		   if (current != null)
			   /**���� ����*/
			   current.stop();

		   /**���� ���� ��� ��ư�̸�*/
		   if (event.getSource() == playButton)
			   /**��� ������ ������ ������ ������*/
			   if (current != null)
				   /**�� ������ ���*/
				   current.play();
      }  
   }
}


public class wk06_java10_201415060
{
	/**
	main �Լ���
	��ũ�ڽ� �г��� ���ϰ� ���̰� ������
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main (String[] args)
	{
		/**������ ����*/
		JFrame frame = new JFrame ("Java Juke Box");
		/**â ��ư. �ּ�ȭ �ִ�ȭ �ݱ�*/
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		/**�г��� �ҿ� ����*/
		frame.getContentPane().add(new JukeBoxControls());
		/**�г��� ����*/
		frame.pack();
		/**�������� ����*/
		frame.setVisible(true);
	}	
}
