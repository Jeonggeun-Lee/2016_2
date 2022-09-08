/**
wk06_java04_201415060 클래스는  
좌표 패널을 프레임에 더하고 붙이고 보여주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;


/**좌표패널
 * 패널 위에 한 점을 클릭하면 그 점을 중심으로 한 속을 채운 작은 원이 그려짐*/
class CoordinatesPanel extends JPanel
{
	/**원의 지름*/
	private final int SIZE = 6;
	/**처음 미리 찍혀 있는 점*/
	private int x = 50, y = 50;
	/**생성자*/
	public CoordinatesPanel()
	{
		/**마우스 리스너 더함*/
		addMouseListener(new CoordinatesListener());
		/**배경색 검정*/
		setBackground(Color.black);
		/**처음 패널 크기*/
		setPreferredSize(new Dimension(300, 200));
	}
	/**페인트 클래스
	 * 처음과 repaint() 호출 시 멤버 자동 호출*/
	public void paintComponent(Graphics page)
	{
		/**배경 칠함*/
		super.paintComponent(page);
		/**앞으로 배경 위에 칠할 색 설정*/
		page.setColor(Color.green);
		/**속을 채운 타원 그리기
		 * 매개 변수로 위치와 지름*/
		page.fillOval(x, y, SIZE, SIZE);
		/**문자열 그리기
		 * 매개변수로 내용과 위치*/
		page.drawString("Coordinates: (" + x + "," + y + ")", 5, 15 );
	}
	/**좌표 매널의 리스너*/
	private class CoordinatesListener implements MouseListener
	{
		/**마우스를 누르면*/
		public void mousePressed(MouseEvent event)
		{
			/**마우스 누른 곳의 좌표를 점의 좌표로*/
			x = event.getX();
			/***/
			y = event.getY();
			/**바뀐 좌표로 다시 그림*/
			repaint();
		}
		/**추상클래스의 나머지 메소드
		 * 텅빈 구현*/
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
	main 함수는
	좌표 패널을 프레임에 더하고 붙이고 보여줍
	니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args){
		/**프레임 객체 생성*/
		JFrame frame = new JFrame("Coordinates");
		/**창버튼
		 * 최소, 최대, 닫기*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**팬에 패널 더함*/
		frame.getContentPane().add(new CoordinatesPanel());
		/**패널 붙임*/
		frame.pack();
		/**프레임을 보여줌*/
		frame.setVisible(true);
	}
}
