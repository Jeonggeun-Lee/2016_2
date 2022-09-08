
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**�׸� �������� �г� �ȿ��� �����̰� �𼭸��� �ε����� ƨ��*/
public class ImagePanel extends JPanel
{
	/**�г� ũ��*/
	private final int WIDTH = 300, HEIGHT = 100;
	/**Ÿ�̸� ����, �̹��� ũ��*/
	private final int DELAY = 20, IMAGE_SIZE = 35;

	/**�׸� ������ ����*/
	private ImageIcon image, image1, image2;
	/**��ġ, �̵��� ����*/
	private int x, y, moveX = 50, moveY = 50;

	/**������*/
	public ImagePanel()
	{
		/**�׸� �������� ����*/
		image = new ImageIcon ("happyFace.gif");
		
		ImageListener listener = new ImageListener();
		addMouseListener( listener );
		/**ó�� ��ġ*/
		x = 0;
		/***/
		y = 40;

		/**�г� ũ�� ����*/
		setPreferredSize (new Dimension(WIDTH, HEIGHT));
		/**���� ����*/
		//setBackground (Color.black);
	}

	/**�����ܰ� ������ �׸��� �޼ҵ�. repaint() ȣ�� �� �ڵ� ȣ��*/
	public void paintComponent (Graphics page)
	{
		/**���� �׸�*/
		super.paintComponent (page);
		image.paintIcon (this, page, x, y);

		/**������ �׸�*/
		
	}

	private class ImageListener implements MouseListener, MouseMotionListener
	{
		/**���콺�� ó�� ������*/
		public void mousePressed(MouseEvent event)
		{

		}
		/**���콺 �巡�׸� ������*/
		public void mouseDragged(MouseEvent event)
		{

		}
		/**���콺�����ʿ� ���콺�巡�׸������� ������ �޼ҵ� �ֺ� ����*/
		public void mouseClicked(MouseEvent event){

		}
		/***/
		public void mouseReleased(MouseEvent event){

		}
		/***/
		public void mouseEntered(MouseEvent event){}
		/***/
		public void mouseExited(MouseEvent event){}
		/***/
		public void mouseMoved(MouseEvent event){}
	}
}