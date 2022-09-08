/**
wk06_java04_201415060 Ŭ������  
��ǥ �г��� �����ӿ� ���ϰ� ���̰� �����ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;


/**��ǥ�г�
 * �г� ���� �� ���� Ŭ���ϸ� �� ���� �߽����� �� ���� ä�� ���� ���� �׷���*/
class CoordinatesPanel extends JPanel
{
	/**���� ����*/
	private final int SIZE = 6;
	/**ó�� �̸� ���� �ִ� ��*/
	private int x = 50, y = 50;
	/**������*/
	public CoordinatesPanel()
	{
		/**���콺 ������ ����*/
		addMouseListener(new CoordinatesListener());
		/**���� ����*/
		setBackground(Color.black);
		/**ó�� �г� ũ��*/
		setPreferredSize(new Dimension(300, 200));
	}
	/**����Ʈ Ŭ����
	 * ó���� repaint() ȣ�� �� ��� �ڵ� ȣ��*/
	public void paintComponent(Graphics page)
	{
		/**��� ĥ��*/
		super.paintComponent(page);
		/**������ ��� ���� ĥ�� �� ����*/
		page.setColor(Color.green);
		/**���� ä�� Ÿ�� �׸���
		 * �Ű� ������ ��ġ�� ����*/
		page.fillOval(x, y, SIZE, SIZE);
		/**���ڿ� �׸���
		 * �Ű������� ����� ��ġ*/
		page.drawString("Coordinates: (" + x + "," + y + ")", 5, 15 );
	}
	/**��ǥ �ų��� ������*/
	private class CoordinatesListener implements MouseListener
	{
		/**���콺�� ������*/
		public void mousePressed(MouseEvent event)
		{
			/**���콺 ���� ���� ��ǥ�� ���� ��ǥ��*/
			x = event.getX();
			/***/
			y = event.getY();
			/**�ٲ� ��ǥ�� �ٽ� �׸�*/
			repaint();
		}
		/**�߻�Ŭ������ ������ �޼ҵ�
		 * �ֺ� ����*/
		public void mouseClicked(MouseEvent event){}
		/***/
		public void mouseReleased(MouseEvent event){}
		/***/
		public void mouseEntered(MouseEvent event){}
		/***/
		public void mouseExited(MouseEvent event){}
	}
}

/***/
public class wk06_java04_201415060 {
	
	/**
	main �Լ���
	��ǥ �г��� �����ӿ� ���ϰ� ���̰� ������
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args){
		/**������ ��ü ����*/
		JFrame frame = new JFrame("Coordinates");
		/**â��ư
		 * �ּ�, �ִ�, �ݱ�*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**�ҿ� �г� ����*/
		frame.getContentPane().add(new CoordinatesPanel());
		/**�г� ����*/
		frame.pack();
		/**�������� ������*/
		frame.setVisible(true);
	}
}
