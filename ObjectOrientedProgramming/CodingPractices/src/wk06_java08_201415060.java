/**
wk06_java08_201415060 클래스는  
원 패널을 프레임에 더하고 붙이고 보이기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
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

/**원 패널*/
class CirclePanel extends JPanel
{
	/**드래그 시작과 끝 점 참조*/
	private Point p1 = null, p2 = null;	
	/**원 패널 생성자*/
	public CirclePanel()
	{
		/**원 리스너 생성*/
		CircleListener listener = new CircleListener();
		/**마우스 리스너 더함*/
		addMouseListener( listener );
		/**마우스 움직임 리스너 더함*/
		addMouseMotionListener( listener );
		/**배경색 설정*/
		setBackground( Color.black );
		/**패널 크기 설정*/
		setPreferredSize( new Dimension(300, 300));
	}
	/***/
	public void paintComponent(Graphics page)
	{
		/**배경색 칠함*/
		super.paintComponent(page);
		/**마우스 드래그 중일 때*/
		if(p1 != null && p2 != null)
		{
			/**그리는 색을 설정*/
			page.setColor(Color.green);
			/**타원 그리기. 매개변수는 타원을 둘러싼 직사각형의 왼쪽 위점과 오른쪽 아랫점*/
			page.drawOval(p1.x, p1.y, p2.x-p1.x, p2.y-p1.y);
		}
		
	}
	/**원 리스너. 마우스 리스너와 마우스 모션 리스너 구현*/
	private class CircleListener implements MouseListener, MouseMotionListener
	{
		/**마우스를 처음 누르면*/
		public void mousePressed(MouseEvent event)
		{
			/**드래그 시작점 설정*/
			p1 = event.getPoint();
		}
		/**마우스 드래그를 끝내면*/
		public void mouseDragged(MouseEvent event)
		{
			/**드래그 끝점 설정*/
			p2 = event.getPoint();
			/**패널 다시 그리기*/
			repaint();
		}
	
		/**마우스리스너와 마우스드래그리스너의 나머지 메소드 텅빈 구현*/
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
	main 함수는
	원 패널을 프레임에 더하고 붙이고 보입
	니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**프레임 생성*/
		JFrame frame = new JFrame("원그리기");
		
		/**창버튼. 최소화, 최대화, 닫기*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**원 패널 생성*/
		CirclePanel panel = new CirclePanel();
		/**팬에 패널 더하기*/
		frame.getContentPane().add(panel);
		
		/**패널 붙이기*/
		frame.pack();
		/**프레임 보이기*/
		frame.setVisible(true);
	}
}

