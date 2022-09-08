/**
wk06_java11_201415060 Ŭ������  
�ʽð� �г��� �����ӿ� ���ϰ� ���̰� ���̱�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
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

/**�ʽð� �г�*/
class StopWatchPanel extends JPanel
{
	/**�󺧰� ��ư���� ���� �г��� ����*/
	private JPanel iswp;
	/**�ʽð� �г� ũ�� ��*/
	private final int WIDTH = 250, HEIGHT = 100;
	/**�ʽð� �г� ������*/
	public StopWatchPanel()
	{
		/**�г� ũ�� ����*/
		setPreferredSize (new Dimension(WIDTH, HEIGHT));

		/**���� �г� ����*/
		iswp = new InnerStopWatchPanel();
		/**���� �г� ����*/
		add(iswp);
	}
		
}

/**�󺧰� ��ư ���� �г�
 * ������ ũ�⸦ �÷��� �г��� �������̽��� �����Ǿ� ���̱� ����*/
class InnerStopWatchPanel extends JPanel
{
	/**���� �г� ũ��*/
	private final int WIDTH = 250, HEIGHT = 100;
	/**Ÿ�̸� ����*/
	private final int DELAY = 1000;

	/**Ÿ�̸� ����*/
	private Timer timer;
	/**�� ����*/
	private JLabel label;
	/**�ʿ� ���� �� �ڸ���, �а� ���� �� �ڸ��� ����*/
	private int second, second1, second10, minute, minute1, minute10, hour;
	/**��ư �г� ����*/
	private JPanel bp;
	
	/**���� �г� ������*/
	public InnerStopWatchPanel()
	{
		/**Ÿ�̸� ����*/
		timer = new Timer(DELAY, new StopWatchListener());
		/**���� �г� ũ�� ����*/
		setPreferredSize (new Dimension(WIDTH, HEIGHT));

		
		/**���� �ʱⰪ*/
		second = 0;
		/**�� ����*/
		label = new JLabel("0:00:00");
		/**�� ����*/
		add(label);

		/**��ư �г� ����*/
		bp = new ButtonPanel();
		/**��ư �г� ����*/
		add(bp);
	}
	
	/**�ʽð� ������*/
	private class StopWatchListener implements ActionListener
	{
		/**Ÿ�̸� ���ݸ��� ȣ���ϴ� �޼ҵ�*/
		public void actionPerformed (ActionEvent event)
		{ 
			/**1�ʸ��� �� �� 1 ����*/
			second +=1;
			/**��, �� �ڸ� �� ����*/
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
     
			/**���� ���ڸ� ���� ����*/
			label.setText(hour+":"+minute10+minute1+":"+second10+second1);
		}
	}
	/**��ư �г�*/
	class ButtonPanel extends JPanel
	{
		/**����, ����, �ʱ�ȭ ��ư ����*/
		private JButton start, stop, reset;
		/**��ư �г� ������*/
		public ButtonPanel()
		{
			/**�� ��ư ����*/
			start = new JButton("Start");
			/***/
			stop = new JButton("Stop");
			/***/
			reset = new JButton("Reset");
			/**��ư ������ ����*/
			ButtonListener buttonListener = new ButtonListener();
			/**�� ��ư ������ ����*/
			start.addActionListener( buttonListener );
			/***/
			stop.addActionListener( buttonListener );
			/***/
			reset.addActionListener( buttonListener );
			/**�� ��ư ����*/
			add(start);
			/***/
			add(stop);
			/***/
			add(reset);
		}
		
		/**��ư ������*/
		private class ButtonListener implements ActionListener
		{

			/**��ư�� ������ ȣ���ϴ� �޼ҵ�*/
			public void actionPerformed (ActionEvent event)
			{
				/**���� ���� �����̸�*/
				if(event.getSource() == start)
				{
					/**Ÿ�̸� �۵� ����*/
					timer.start();
				}
				/**���� ���� �����̸�*/
				else if(event.getSource() == stop)
				{
					/**Ÿ�̸� �۵� ����*/
					timer.stop();
				}
				/**���� ���� �ʱ�ȭ��*/
				else if(event.getSource() == reset)
				{
					/**Ÿ�̸� �۵��� ���߰�*/
					timer.stop();
					/**�� ���� 0����*/
					second = 0;
					/**�� ���ڸ� �ʱ�ȭ*/
					label.setText("0:00:00");
				}
			}
		}
	}

}
public class wk06_java11_201415060
{
	/**
	main �Լ���
	�ʽð� �г��� �����ӿ� ���ϰ� ���̰� ����
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
   public static void main (String[] args)
   {
	   /**������ ����*/
	   JFrame frame = new JFrame ("��ž��ġ");
	   /**â��ư. �ּ�ȭ �ִ�ȭ �ݱ�*/
	   frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	   /**�г��� �ҿ� ����*/
	   frame.getContentPane().add(new StopWatchPanel());

	   /**�г��� ����*/
	   frame.pack();
	   /**�������� ����*/
	   frame.setVisible(true);
   }
}
