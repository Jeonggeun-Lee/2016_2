/**
wk06_java06_201415060 Ŭ������  
��ȣ�� �г��� �����ӿ� ���ϰ� ���̰� �����ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
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
	/**��ȣ�� �� �ٲٴ� ��ư ����*/
	private JButton light;
	/**��ȣ�� �� ���̴� �г� ����*/
	private JPanel color;

	/**�г� ������*/
	public TrafficLightPanel ()
	{
		/**��ư ����*/
		light =  new JButton("Change Signal");
		/**��ư�� ������ ����*/
		light.addActionListener( new ButtonListener() );
	
		/**�� ���̴� �г� ����*/
		color = new JPanel();
		/**�� �г� �ʱ� �� ���� �Ķ�*/
		color.setBackground( Color.blue );
		/**�� �г� ũ�� ����*/
		color.setPreferredSize (new Dimension(100, 100));

		/**���г��� ��ȣ�� �гο� ����*/
		add (color);
		/**�� �ٲٴ� ��ư�� ��ȣ�� �гο� ����*/
		add (light);

		/**�г� ���� ����*/
		setBackground (Color.black);
		/**�г� ũ�� ����*/
		setPreferredSize (new Dimension(150, 150));
	}
	/**��ư�� ������*/
	private class ButtonListener implements ActionListener 
	{
		/**��ư ���� Ƚ�� ���� ����*/
		int cnt = 0;

		/**��ư ������ ȣ���Ǵ� �Լ�*/
		public void actionPerformed (ActionEvent event) 
		{
			/**���� Ƚ�� ����*/
			cnt++;
	  
			/**���� Ƚ���� 3�� ����� �� �Ķ�*/
			if( cnt %3 ==0) color.setBackground(Color.blue);
			/**���� Ƚ���� 3���� ���� 1�� ������ ���*/
			if( cnt %3 ==1) color.setBackground(Color.yellow);
			/**���� Ƚ���� 3���� ���� 2�� ������ ����*/
			if( cnt %3 ==2) color.setBackground(Color.red);
		}
	}
}

public class wk06_java06_201415060
{
	/**
	main �Լ���
	��ȣ�� �г��� �����ӿ� ���ϰ� ���̰� ������
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
   public static void main (String[] args)
   {
	   /**������ ����*/
	   JFrame frame = new JFrame ("��ȣ��");
	   /**â��ư. �ּ� �ִ� �ݱ�*/
	   frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	   /**��ȣ�� �г� ����*/
      TrafficLightPanel panel = new TrafficLightPanel();
      /**�г��� �ҿ� ����*/
      frame.getContentPane().add(panel);

      /**�г��� ����*/
      frame.pack();
      /**������ ������*/
      frame.setVisible(true);
   }
}
