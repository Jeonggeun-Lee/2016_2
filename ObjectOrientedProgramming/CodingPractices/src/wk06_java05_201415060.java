/**
wk06_java05_201415060 클래스는  
증감세기 패널을 프레임에 더하고 붙이고 보여주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**
 * PP6.02
 * Design and implement an application that presents two buttons and a label to the user.
 * Label the buttons Increment and Decrement, respectively.
 * Display a numeric value (initially 50) using the label.
 * Each time the Increment button is pushed, increment the value displayed.
 * Likewise, each time the Decrement button is pressed, decrement the value displayed.
 * Create two separate listener classes for the two buttons.
 * */

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**증감 패널
 * 증감할 정수 변수
 * 증가 감소 버튼
 * 변수를 보여줄 라벨
 * 리스너*/
class InDeCounterPanel extends JPanel
{
	/**증감할 정수 변수*/
	private int count;
	/**증가 감소 버튼 참조*/
	private JButton increase;
	/***/
	private JButton decrease;
	/**변수를 보여줄 라벨 참조*/
	private JLabel label;

	/**생성자*/
	public InDeCounterPanel ()
	{
		/**변수 초기값*/
		count = 50;

		/**증가 감소 버튼 생성*/
		increase = new JButton ("Increase");
		/***/
		decrease = new JButton ("Decrease");
		/**버튼에 리스너 더함*/
		increase.addActionListener (new ButtonListener());
		/***/
		decrease.addActionListener (new ButtonListener());
  
		/**라벨 생성
		 * 증감 변수 보여줌*/
		label = new JLabel ("" + count);

		/**버튼을 패널에 더함*/
		add (increase);
		/***/
		add (decrease);
		/**라벨을 패널에 더함*/
		add (label);

		/**배경색 설정*/
		setBackground (Color.cyan);
		/**패널 크기 설정*/
		setPreferredSize (new Dimension(300, 40));
	}


	/**버튼의 리스너*/
	private class ButtonListener implements ActionListener 
	{

		/**버튼을 누르면 호출*/
		public void actionPerformed (ActionEvent event) 
		{
			/**누른 소스가 증가 버튼이면 변수를 1증가*/
			if(event.getSource()== increase)count++;
			/**아니면 1감소*/
			else count--;
			/**라벨의 글자를 재설정*/
			label.setText("" + count);
		}
	}
}


public class wk06_java05_201415060
{
	/**
	main 함수는
	증감세기 패널을 프레임에 더하고 붙이고 보여줍
	니다.
	@param args: the command line arguments
	@return void
	*/
   public static void main (String[] args)
   {
	   /**프레임 객체 생성*/
      JFrame frame = new JFrame ("증감");
      /**창버튼 최소, 최대, 닫기*/
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      /**패널 객체 생성*/
      InDeCounterPanel panel = new InDeCounterPanel();
      /**프레임 팬에 패널 더함*/
      frame.getContentPane().add(panel);

      /**패널 붙임*/
      frame.pack();
      /**프레임 보이기*/
      frame.setVisible(true);
   }
}
