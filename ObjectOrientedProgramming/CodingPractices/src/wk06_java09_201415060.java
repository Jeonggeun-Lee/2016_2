/**
wk06_java09_201415060 Ŭ������  
�ؽ�Ʈ ��� �г��� ���ϰ� ���̰� ������
�� ���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

/**
 * PP06.15
 * ���� �� ������ ���� ��踦 ���� ���� ������ ������ �����϶�.
 * �������α׷��� ���� ���� �ϳ��� â�� ��ũ�� �ۻ���(JTextArea)�� ��� �����̴�.
 * �� ��� ���ڴ� �гημ� ���� ��踦 ������ �� �ʵ带 �����Ͽ� �� ������ �ܾ� ���� ��� �ܾ� ���̸� �����ش�.
 * �� �װ� ���ϰ� ���� �ٸ� ��赵 �����ϴ�.
 * ��� ���ڴ� ��ư�� ������ ������ �ؽ�Ʈ �ʵ��� ���� ������ ��踦 �ٽ� ����Ѵ�.
 * */

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

/**��� �г�*/
class StatPanel extends JPanel
{
	/**��踦 �� �ؽ�Ʈ ����*/
	private JTextArea textArea;
	/**�󺧰� ��ư�� ��� �� �м� �г�*/	
	private JPanel analPanel;
	/**���ڿ� ���� ��� ��*/		
	private JLabel strsLabel;
	/**���ڿ� ���� ��*/	
	private JLabel strs;
	/**�ܾ� ���� ��� ��*/	
	private JLabel wordsLabel;
	/**�ܾ� ���� ��*/	
	private JLabel words;
	/**��� ���� ��ư*/		
	private JButton button;
	/**��� �г� ������*/
	public StatPanel()
	{
		/**�ؽ�Ʈ ���� ����*/
		textArea = new JTextArea(7,20);
		/**�ؽ�Ʈ ������ ��ũ�� ��� ����*/
		add( new JScrollPane(textArea) );
		
		/**���ڿ� ���� ��� �� ����*/
		strsLabel = new JLabel("���ڿ��� ���� : ");
		/**���ڿ� ���� �� ����*/
		strs = new JLabel("0");
		
		/**�ܾ� ���� ��� �� ����*/
		wordsLabel = new JLabel("�ܾ��� �� : ");
		/**�ܾ� ���� �� ����*/
		words = new JLabel("0");
		/**��� ���� ��ư ����*/
		button = new JButton("���");
		/**��ư ������ ����*/
		ButtonListener listener = new ButtonListener();	
		/**��ư ������ ����*/
		button.addActionListener(listener);
		/**�м� �г� ����*/
		analPanel = new JPanel();
		/**�м� �г��� ���� ����*/
		analPanel.setBorder(BorderFactory.createTitledBorder("<Analysis>"));
		/**�м� �гο� �󺧰� ��ư ����*/
		analPanel.add(strsLabel);
		/***/
		analPanel.add(strs);
		/***/
		analPanel.add(wordsLabel);
		/***/
		analPanel.add(words);
		/***/
		analPanel.add(button);
		/**��� �гο� �м� �г� ����*/
		add(analPanel);
	
	}
	
	/**��ư ������*/
	private class ButtonListener implements ActionListener
	{	
		/**��ư ������ ȣ���ϴ� �޼ҵ�*/
		public void actionPerformed(ActionEvent event)
		{			
			/**�ؽ�Ʈ ���� ���� ����*/
			Integer txtLen = textArea.getText().length();
			/**�ؽ�Ʈ �������� ��ĵ*/
			Scanner txtScan = new Scanner( textArea.getText() );
			/**���ڿ� ���� ���� ����*/
			Integer sum = 0;
			/**��ĵ�� ���ڿ� ����*/
			String temp;
			/**��ĵ�� ���� �ִ� ����*/
			while(txtScan.hasNext())
			{
				/**�ؽ�Ʈ �������� �� ���ڿ� ��ĵ*/
				temp = txtScan.next();
				/**���ڿ� ���� ����*/
				sum++;
			}
			
			/**�ؽ�Ʈ ���̸� �󺧿� ǥ��*/
			strs.setText(txtLen.toString());
			/**�ܾ� ���� �󺧿� ǥ��*/
			words.setText(sum.toString());
			
		}		
	}
}

public class wk06_java09_201415060
{
	/**
	main �Լ���
	�ؽ�Ʈ ��� �г��� ���ϰ� ���̰� ������
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{	
		/**������ ����*/
		JFrame frame = new JFrame("�ؽ�Ʈ �м� ���α׷�");	
		/**â ��ư. �ּ�, �ִ�, �ݱ�*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		/**�г��� �ҿ� ����*/
		frame.getContentPane().add(new StatPanel());		
		/**�г��� ����*/
		frame.pack();
		/**�������� ������*/
		frame.setVisible(true);
	}
}
