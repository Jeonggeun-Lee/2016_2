/**
wk06_java03_201415060 클래스는  
ReboundPanel을 프레임에 붙이고 보여주기
하기 위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/


import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**그림 아이콘이 패널 안에서 움직이고 모서리에 부딪히면 튕김*/
class ReboundPanel extends JPanel
{
	/**패널 크기*/
	private final int WIDTH = 300, HEIGHT = 100;
	/**타이머 간격, 이미지 크기*/
	private final int DELAY = 20, IMAGE_SIZE = 35;

	/**그림 아이콘 참조*/
	private ImageIcon image;
	/**타이머 참조*/
	private Timer timer;
	/**위치, 이동값 참조*/
	private int x, y, moveX, moveY;

	/**생성자*/
	public ReboundPanel()
	{
		/**타이머 생성. 매개변수는 간격과 리스너*/
		timer = new Timer(DELAY, new ReboundListener());
		/**그림 아이콘의 원본*/
		image = new ImageIcon ("happyFace.gif");

		/**처음 위치*/
		x = 0;
		/***/
		y = 40;
		/**타이머 간격 동안 이동값*/
		moveX = moveY = 3;

		/**패널 크기 설정*/
		setPreferredSize (new Dimension(WIDTH, HEIGHT));
		/**배경색 설정*/
		setBackground (Color.black);
		/**타이머 시작*/
		timer.start();
	}

	/**아이콘과 배경색을 그리는 메소드. repaint() 호출 시 자동 호출*/
	public void paintComponent (Graphics page)
	{
		/**배경색 그림*/
		super.paintComponent (page);
		/**아이콘 그림*/
		image.paintIcon (this, page, x, y);
	}

	/**타이머에 주는 리스너*/
	private class ReboundListener implements ActionListener
	{
		/**타이머 간격으로 호출되는 메소드*/
		public void actionPerformed (ActionEvent event)
		{
			/**가로 이동*/
			x += moveX;
			/**세로 이동*/
			y += moveY;

			/**가로 모서리에 부딪히면*/
			if (x <= 0 || x >= WIDTH-IMAGE_SIZE)
				/**이동값을 반대로*/
				moveX = moveX * -1;

			/**세로 모서리에 부딪히면*/
			if (y <= 0 || y >= HEIGHT-IMAGE_SIZE)
				/**이동값을 반대로*/
				moveY = moveY * -1;

			/**위치 변화를 기준으로 다시 그림*/
			repaint();
		}
	}
}

/***/
public class wk06_java03_201415060
{

	/**
	main 함수는
	ReboundPanel을 프레임에 붙이고 보여주기를
	합니다.
	@param args: the command line arguments
	@return void
	*/
   public static void main (String[] args)
   {
	   /**프레임 생성*/
	   JFrame frame = new JFrame ("Rebound");
	   /**창 버튼. 최소, 최대, 닫기*/
	   frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	   /**패널을 프레임의 팬에 더함*/
	   frame.getContentPane().add(new ReboundPanel());

	   /**패널을 묶음*/
	   frame.pack();
	   /**프레임을 보여줌*/
	   frame.setVisible(true);
   }
}
