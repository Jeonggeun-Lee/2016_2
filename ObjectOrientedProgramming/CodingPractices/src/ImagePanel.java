
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**그림 아이콘이 패널 안에서 움직이고 모서리에 부딪히면 튕김*/
public class ImagePanel extends JPanel
{
	/**패널 크기*/
	private final int WIDTH = 300, HEIGHT = 100;
	/**타이머 간격, 이미지 크기*/
	private final int DELAY = 20, IMAGE_SIZE = 35;

	/**그림 아이콘 참조*/
	private ImageIcon image, image1, image2;
	/**위치, 이동값 참조*/
	private int x, y, moveX = 50, moveY = 50;

	/**생성자*/
	public ImagePanel()
	{
		/**그림 아이콘의 원본*/
		image = new ImageIcon ("happyFace.gif");
		
		ImageListener listener = new ImageListener();
		addMouseListener( listener );
		/**처음 위치*/
		x = 0;
		/***/
		y = 40;

		/**패널 크기 설정*/
		setPreferredSize (new Dimension(WIDTH, HEIGHT));
		/**배경색 설정*/
		//setBackground (Color.black);
	}

	/**아이콘과 배경색을 그리는 메소드. repaint() 호출 시 자동 호출*/
	public void paintComponent (Graphics page)
	{
		/**배경색 그림*/
		super.paintComponent (page);
		image.paintIcon (this, page, x, y);

		/**아이콘 그림*/
		
	}

	private class ImageListener implements MouseListener, MouseMotionListener
	{
		/**마우스를 처음 누르면*/
		public void mousePressed(MouseEvent event)
		{

		}
		/**마우스 드래그를 끝내면*/
		public void mouseDragged(MouseEvent event)
		{

		}
		/**마우스리스너와 마우스드래그리스너의 나머지 메소드 텅빈 구현*/
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