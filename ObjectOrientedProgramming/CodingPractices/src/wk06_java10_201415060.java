/**
wk06_java10_201415060 클래스는  
쥬크박스 패널을 더하고 붙이고 보여 주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**
 * PP06.18 주크박스 프로그램을 수정해서
 * 재생과 정지 버튼 기능이 키보드 단축키를 이용해도 제어되게 하라.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;
import java.net.URL;

/**쥬크박스 패널*/
class JukeBoxControls extends JPanel
{
	/**콤보박스 참조*/
   private JComboBox musicCombo;
   /**재생 멈춤 버튼 참조*/
   private JButton stopButton, playButton;
   /**음원 배열 참조*/
   private AudioClip[] music;
   /**현재재생 음원 참조*/
   private AudioClip current;
   
   /**패널 생성자*/
   public JukeBoxControls()
   {
	   
	   /**음원 주소 참조*/
	   URL url1, url2, url3, url4, url5, url6;
	   /**널로 초기화*/
	   url1 = url2 = url3 = url4 = url5 = url6 = null;

	   /**음원의 주소 생성*/
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

	   /**음원 배열 생성*/
	   music = new AudioClip[7];
	   /**음원 배열 원소 저장*/
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

	   /**음악 이름 문자열의 배열 생성*/
      String[] musicNames = {"Make A Selection...", "Western Beat",
               "Classical Melody", "Jeopardy Theme", "New Age Rythm",
               "Eighties Jam", "Alfred Hitchcock's Theme"};
      /**콤보 박스 생성*/
      musicCombo = new JComboBox (musicNames);
      /**콤보 박스 배경 설정*/
      musicCombo.setBackground (Color.cyan);


      /**재생 버튼 생성*/
      playButton = new JButton ("Play", new ImageIcon ("play.gif"));
      /**재생 버튼 단축키 설정*/
      playButton.setMnemonic('p');
      /**버튼 배경색 설정*/
      playButton.setBackground (Color.cyan);
      /**멈춤 버튼 생성*/
      stopButton = new JButton ("Stop", new ImageIcon ("stop.gif"));
      /**멈춤 버튼 단축키 설정*/
      stopButton.setMnemonic('s');
      /**멈춤 버튼 배경색 설정*/
      stopButton.setBackground (Color.cyan);

      /**패널 크기 설정*/
      setPreferredSize (new Dimension (250, 100));
      /**패널 배경색 설정*/
      setBackground (Color.cyan);
      /**콤보 더함*/
      add (musicCombo);
      /**버튼 더함*/
      add (playButton);
      /***/
      add (stopButton);

      /**콤보에 리스너 더함*/
      musicCombo.addActionListener (new ComboListener());
      /**버튼에 리스너 더함*/
      stopButton.addActionListener (new ButtonListener());
      /***/
      playButton.addActionListener (new ButtonListener());
      /**현재 음원 널로 초기화*/
      current = null;
   }
   
   /**콤보 리스너*/
   private class ComboListener implements ActionListener
   {
	   /**콤보 항목을 바꾸면 호출하는 메소드*/
	   public void actionPerformed (ActionEvent event)
	   {
		   /**현재 재생 중인 음원이 있으면*/
		   if (current != null)
			   /**재생 중인 음원을 멈춤*/
			   current.stop();

		   /**콤보에서 선택한 음원을 현재 재생하는 음원으로*/
		   current = music[musicCombo.getSelectedIndex()];
      }
   }

   /**버튼 리스너*/
   private class ButtonListener implements ActionListener
   {
	   /**버튼 누르면 호출하는 메소드*/
	   public void actionPerformed (ActionEvent event)
	   {
		   /**재생 중인 음원이 있으면*/
		   if (current != null)
			   /**음원 멈춤*/
			   current.stop();

		   /**누른 것이 재생 버튼이면*/
		   if (event.getSource() == playButton)
			   /**재생 중으로 설정된 음원이 있으면*/
			   if (current != null)
				   /**그 음원을 재생*/
				   current.play();
      }  
   }
}


public class wk06_java10_201415060
{
	/**
	main 함수는
	쥬크박스 패널을 더하고 붙이고 보여줍
	니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main (String[] args)
	{
		/**프레임 생성*/
		JFrame frame = new JFrame ("Java Juke Box");
		/**창 버튼. 최소화 최대화 닫기*/
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		/**패널을 팬에 더함*/
		frame.getContentPane().add(new JukeBoxControls());
		/**패널을 붙임*/
		frame.pack();
		/**프레임을 보임*/
		frame.setVisible(true);
	}	
}
