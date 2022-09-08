/**
wk06_java05_201415060 Ŭ������  
�������� �г��� �����ӿ� ���ϰ� ���̰� �����ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
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

/**���� �г�
 * ������ ���� ����
 * ���� ���� ��ư
 * ������ ������ ��
 * ������*/
class InDeCounterPanel extends JPanel
{
	/**������ ���� ����*/
	private int count;
	/**���� ���� ��ư ����*/
	private JButton increase;
	/***/
	private JButton decrease;
	/**������ ������ �� ����*/
	private JLabel label;

	/**������*/
	public InDeCounterPanel ()
	{
		/**���� �ʱⰪ*/
		count = 50;

		/**���� ���� ��ư ����*/
		increase = new JButton ("Increase");
		/***/
		decrease = new JButton ("Decrease");
		/**��ư�� ������ ����*/
		increase.addActionListener (new ButtonListener());
		/***/
		decrease.addActionListener (new ButtonListener());
  
		/**�� ����
		 * ���� ���� ������*/
		label = new JLabel ("" + count);

		/**��ư�� �гο� ����*/
		add (increase);
		/***/
		add (decrease);
		/**���� �гο� ����*/
		add (label);

		/**���� ����*/
		setBackground (Color.cyan);
		/**�г� ũ�� ����*/
		setPreferredSize (new Dimension(300, 40));
	}


	/**��ư�� ������*/
	private class ButtonListener implements ActionListener 
	{

		/**��ư�� ������ ȣ��*/
		public void actionPerformed (ActionEvent event) 
		{
			/**���� �ҽ��� ���� ��ư�̸� ������ 1����*/
			if(event.getSource()== increase)count++;
			/**�ƴϸ� 1����*/
			else count--;
			/**���� ���ڸ� �缳��*/
			label.setText("" + count);
		}
	}
}


public class wk06_java05_201415060
{
	/**
	main �Լ���
	�������� �г��� �����ӿ� ���ϰ� ���̰� ������
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
   public static void main (String[] args)
   {
	   /**������ ��ü ����*/
      JFrame frame = new JFrame ("����");
      /**â��ư �ּ�, �ִ�, �ݱ�*/
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      /**�г� ��ü ����*/
      InDeCounterPanel panel = new InDeCounterPanel();
      /**������ �ҿ� �г� ����*/
      frame.getContentPane().add(panel);

      /**�г� ����*/
      frame.pack();
      /**������ ���̱�*/
      frame.setVisible(true);
   }
}
