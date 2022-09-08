/**
wk06_java06_201415060 클래스는  
신호등 패널을 프레임에 더하고 붙이고 보여주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**
 * PP6.07
 * Design and implement an application
 * that draws a traffic light and uses a push button to change the state of the light.
 * Derive the drawing surface from the JPanel class and use another panel
 * to organize the drawing surface and the button.
 * */

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TrafficLightPanel extends JPanel
{
	/**신호등 색 바꾸는 버튼 참조*/
	private JButton light;
	/**신호등 색 보이는 패널 참조*/
	private JPanel color;

	/**패널 생성자*/
	public TrafficLightPanel ()
	{
		/**버튼 생성*/
		light =  new JButton("Change Signal");
		/**버튼에 리스너 붙임*/
		light.addActionListener( new ButtonListener() );
	
		/**색 보이는 패널 생성*/
		color = new JPanel();
		/**색 패널 초기 색 설정 파랑*/
		color.setBackground( Color.blue );
		/**색 패널 크기 설정*/
		color.setPreferredSize (new Dimension(100, 100));

		/**색패널을 신호등 패널에 더함*/
		add (color);
		/**색 바꾸는 버튼을 신호등 패널에 더함*/
		add (light);

		/**패널 배경색 설정*/
		setBackground (Color.black);
		/**패널 크기 설정*/
		setPreferredSize (new Dimension(150, 150));
	}
	/**버튼의 리스너*/
	private class ButtonListener implements ActionListener 
	{
		/**버튼 누른 횟수 저장 변수*/
		int cnt = 0;

		/**버튼 누르면 호츨되는 함수*/
		public void actionPerformed (ActionEvent event) 
		{
			/**누른 횟수 증가*/
			cnt++;
	  
			/**누른 횟수가 3의 배수일 때 파랑*/
			if( cnt %3 ==0) color.setBackground(Color.blue);
			/**누른 횟수를 3으로 나눠 1이 남으면 노랑*/
			if( cnt %3 ==1) color.setBackground(Color.yellow);
			/**누른 횟수가 3으로 나눠 2가 남으면 빨강*/
			if( cnt %3 ==2) color.setBackground(Color.red);
		}
	}
}

public class wk06_java06_201415060
{
	/**
	main 함수는
	신호등 패널을 프레임에 더하고 붙이고 보여줍
	니다.
	@param args: the command line arguments
	@return void
	*/
   public static void main (String[] args)
   {
	   /**프레임 생성*/
	   JFrame frame = new JFrame ("신호등");
	   /**창버튼. 최소 최대 닫기*/
	   frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	   /**신호등 패널 생성*/
      TrafficLightPanel panel = new TrafficLightPanel();
      /**패널을 팬에 더함*/
      frame.getContentPane().add(panel);

      /**패널을 붙임*/
      frame.pack();
      /**프레임 보여줌*/
      frame.setVisible(true);
   }
}
