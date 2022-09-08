/**
wk06_java03_201415060 Ŭ������  
ReboundPanel�� �����ӿ� ���̰� �����ֱ�
�ϱ� ���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/


import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**�׸� �������� �г� �ȿ��� �����̰� �𼭸��� �ε����� ƨ��*/
class ReboundPanel extends JPanel
{
	/**�г� ũ��*/
	private final int WIDTH = 300, HEIGHT = 100;
	/**Ÿ�̸� ����, �̹��� ũ��*/
	private final int DELAY = 20, IMAGE_SIZE = 35;

	/**�׸� ������ ����*/
	private ImageIcon image;
	/**Ÿ�̸� ����*/
	private Timer timer;
	/**��ġ, �̵��� ����*/
	private int x, y, moveX, moveY;

	/**������*/
	public ReboundPanel()
	{
		/**Ÿ�̸� ����. �Ű������� ���ݰ� ������*/
		timer = new Timer(DELAY, new ReboundListener());
		/**�׸� �������� ����*/
		image = new ImageIcon ("happyFace.gif");

		/**ó�� ��ġ*/
		x = 0;
		/***/
		y = 40;
		/**Ÿ�̸� ���� ���� �̵���*/
		moveX = moveY = 3;

		/**�г� ũ�� ����*/
		setPreferredSize (new Dimension(WIDTH, HEIGHT));
		/**���� ����*/
		setBackground (Color.black);
		/**Ÿ�̸� ����*/
		timer.start();
	}

	/**�����ܰ� ������ �׸��� �޼ҵ�. repaint() ȣ�� �� �ڵ� ȣ��*/
	public void paintComponent (Graphics page)
	{
		/**���� �׸�*/
		super.paintComponent (page);
		/**������ �׸�*/
		image.paintIcon (this, page, x, y);
	}

	/**Ÿ�̸ӿ� �ִ� ������*/
	private class ReboundListener implements ActionListener
	{
		/**Ÿ�̸� �������� ȣ��Ǵ� �޼ҵ�*/
		public void actionPerformed (ActionEvent event)
		{
			/**���� �̵�*/
			x += moveX;
			/**���� �̵�*/
			y += moveY;

			/**���� �𼭸��� �ε�����*/
			if (x <= 0 || x >= WIDTH-IMAGE_SIZE)
				/**�̵����� �ݴ��*/
				moveX = moveX * -1;

			/**���� �𼭸��� �ε�����*/
			if (y <= 0 || y >= HEIGHT-IMAGE_SIZE)
				/**�̵����� �ݴ��*/
				moveY = moveY * -1;

			/**��ġ ��ȭ�� �������� �ٽ� �׸�*/
			repaint();
		}
	}
}

/***/
public class wk06_java03_201415060
{

	/**
	main �Լ���
	ReboundPanel�� �����ӿ� ���̰� �����ֱ⸦
	�մϴ�.
	@param args: the command line arguments
	@return void
	*/
   public static void main (String[] args)
   {
	   /**������ ����*/
	   JFrame frame = new JFrame ("Rebound");
	   /**â ��ư. �ּ�, �ִ�, �ݱ�*/
	   frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	   /**�г��� �������� �ҿ� ����*/
	   frame.getContentPane().add(new ReboundPanel());

	   /**�г��� ����*/
	   frame.pack();
	   /**�������� ������*/
	   frame.setVisible(true);
   }
}
