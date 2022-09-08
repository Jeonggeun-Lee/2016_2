/**
wk06_java08_201415060 Ŭ������  
�� �г��� �����ӿ� ���ϰ� ���̰� ���̱�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

/**
 * PP6.12
 * Design an implement an application
 * that draws a circle using a rubberbanding technique.
 * The circle size is determined by a mouse drag.
 * Use the original mouse click location as a fixed center point.
 * Hint: Compute the distance between the mouse pointer and the center point
 * to determine the current radius of the circle.
 * */
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**�� �г�*/
class CirclePanel extends JPanel
{
	/**�巡�� ���۰� �� �� ����*/
	private Point p1 = null, p2 = null;	
	/**�� �г� ������*/
	public CirclePanel()
	{
		/**�� ������ ����*/
		CircleListener listener = new CircleListener();
		/**���콺 ������ ����*/
		addMouseListener( listener );
		/**���콺 ������ ������ ����*/
		addMouseMotionListener( listener );
		/**���� ����*/
		setBackground( Color.black );
		/**�г� ũ�� ����*/
		setPreferredSize( new Dimension(300, 300));
	}
	/***/
	public void paintComponent(Graphics page)
	{
		/**���� ĥ��*/
		super.paintComponent(page);
		/**���콺 �巡�� ���� ��*/
		if(p1 != null && p2 != null)
		{
			/**�׸��� ���� ����*/
			page.setColor(Color.green);
			/**Ÿ�� �׸���. �Ű������� Ÿ���� �ѷ��� ���簢���� ���� ������ ������ �Ʒ���*/
			page.drawOval(p1.x, p1.y, p2.x-p1.x, p2.y-p1.y);
		}
		
	}
	/**�� ������. ���콺 �����ʿ� ���콺 ��� ������ ����*/
	private class CircleListener implements MouseListener, MouseMotionListener
	{
		/**���콺�� ó�� ������*/
		public void mousePressed(MouseEvent event)
		{
			/**�巡�� ������ ����*/
			p1 = event.getPoint();
		}
		/**���콺 �巡�׸� ������*/
		public void mouseDragged(MouseEvent event)
		{
			/**�巡�� ���� ����*/
			p2 = event.getPoint();
			/**�г� �ٽ� �׸���*/
			repaint();
		}
	
		/**���콺�����ʿ� ���콺�巡�׸������� ������ �޼ҵ� �ֺ� ����*/
		public void mouseClicked(MouseEvent event){}
		/***/
		public void mouseReleased(MouseEvent event){}
		/***/
		public void mouseEntered(MouseEvent event){}
		/***/
		public void mouseExited(MouseEvent event){}
		/***/
		public void mouseMoved(MouseEvent event){}
	}
}

public class wk06_java08_201415060 {
	/**
	main �Լ���
	�� �г��� �����ӿ� ���ϰ� ���̰� ����
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**������ ����*/
		JFrame frame = new JFrame("���׸���");
		
		/**â��ư. �ּ�ȭ, �ִ�ȭ, �ݱ�*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**�� �г� ����*/
		CirclePanel panel = new CirclePanel();
		/**�ҿ� �г� ���ϱ�*/
		frame.getContentPane().add(panel);
		
		/**�г� ���̱�*/
		frame.pack();
		/**������ ���̱�*/
		frame.setVisible(true);
	}
}

