/**
wk06_java11_201415060 클래스는  
초시계 패널을 프레임에 더하고 붙이고 보이기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**
 * PP06.22
 * Design and implement an application that works as a stopwatch.
 * Include a display that shows the time (in seconds) as it increments.
 * Include buttons that allow the user to start and stop the time,
 * and reset the display to zero.
 * Arrange the components to present a nice interface.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**초시계 패널*/
class StopWatchPanel extends JPanel
{
	/**라벨과 버튼들의 모음 패널의 참조*/
	private JPanel iswp;
	/**초시계 패널 크기 값*/
	private final int WIDTH = 250, HEIGHT = 100;
	/**초시계 패널 생성자*/
	public StopWatchPanel()
	{
		/**패널 크기 설정*/
		setPreferredSize (new Dimension(WIDTH, HEIGHT));

		/**모음 패널 생성*/
		iswp = new InnerStopWatchPanel();
		/**모음 패널 더함*/
		add(iswp);
	}
		
}

/**라벨과 버튼 모음 패널
 * 프레임 크기를 늘려도 패널의 인터페이스가 정돈되어 보이기 위함*/
class InnerStopWatchPanel extends JPanel
{
	/**모음 패널 크기*/
	private final int WIDTH = 250, HEIGHT = 100;
	/**타이머 간격*/
	private final int DELAY = 1000;

	/**타이머 참조*/
	private Timer timer;
	/**라벨 참조*/
	private JLabel label;
	/**초와 초의 각 자리수, 분과 분의 각 자리수 변수*/
	private int second, second1, second10, minute, minute1, minute10, hour;
	/**버튼 패널 참조*/
	private JPanel bp;
	
	/**모음 패널 생성자*/
	public InnerStopWatchPanel()
	{
		/**타이머 생성*/
		timer = new Timer(DELAY, new StopWatchListener());
		/**모음 패널 크기 설정*/
		setPreferredSize (new Dimension(WIDTH, HEIGHT));

		
		/**초의 초기값*/
		second = 0;
		/**라벨 생성*/
		label = new JLabel("0:00:00");
		/**라벨 더함*/
		add(label);

		/**버튼 패널 생성*/
		bp = new ButtonPanel();
		/**버튼 패널 더함*/
		add(bp);
	}
	
	/**초시계 리스너*/
	private class StopWatchListener implements ActionListener
	{
		/**타이머 간격마다 호출하는 메소드*/
		public void actionPerformed (ActionEvent event)
		{ 
			/**1초마다 초 값 1 증가*/
			second +=1;
			/**초, 분 자리 값 설정*/
			second1 = second%10;
			/***/
			second10 = (second/10)%6;
			/***/
			minute = second/60;
			/***/
			minute1 = minute%10;
			/***/
			minute10 = (minute/10)%6;
			/***/
			hour = minute/60;
     
			/**라벨의 글자를 새로 정함*/
			label.setText(hour+":"+minute10+minute1+":"+second10+second1);
		}
	}
	/**버튼 패널*/
	class ButtonPanel extends JPanel
	{
		/**시작, 멈춤, 초기화 버튼 참조*/
		private JButton start, stop, reset;
		/**버튼 패널 생성자*/
		public ButtonPanel()
		{
			/**각 버튼 생성*/
			start = new JButton("Start");
			/***/
			stop = new JButton("Stop");
			/***/
			reset = new JButton("Reset");
			/**버튼 리스너 생성*/
			ButtonListener buttonListener = new ButtonListener();
			/**각 버튼 리스너 더함*/
			start.addActionListener( buttonListener );
			/***/
			stop.addActionListener( buttonListener );
			/***/
			reset.addActionListener( buttonListener );
			/**각 버튼 더함*/
			add(start);
			/***/
			add(stop);
			/***/
			add(reset);
		}
		
		/**버튼 리스너*/
		private class ButtonListener implements ActionListener
		{

			/**버튼을 누르면 호출하는 메소드*/
			public void actionPerformed (ActionEvent event)
			{
				/**누른 것이 시작이면*/
				if(event.getSource() == start)
				{
					/**타이머 작동 시작*/
					timer.start();
				}
				/**누른 것이 멈춤이면*/
				else if(event.getSource() == stop)
				{
					/**타이머 작동 멈춤*/
					timer.stop();
				}
				/**누른 것이 초기화면*/
				else if(event.getSource() == reset)
				{
					/**타이머 작동을 멈추고*/
					timer.stop();
					/**초 값을 0으로*/
					second = 0;
					/**라벨 글자를 초기화*/
					label.setText("0:00:00");
				}
			}
		}
	}

}
public class wk06_java11_201415060
{
	/**
	main 함수는
	초시계 패널을 프레임에 더하고 붙이고 보입
	니다.
	@param args: the command line arguments
	@return void
	*/
   public static void main (String[] args)
   {
	   /**프레임 생성*/
	   JFrame frame = new JFrame ("스탑워치");
	   /**창버튼. 최소화 최대화 닫기*/
	   frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	   /**패널을 팬에 더함*/
	   frame.getContentPane().add(new StopWatchPanel());

	   /**패널을 붙임*/
	   frame.pack();
	   /**프레임을 보임*/
	   frame.setVisible(true);
   }
}
