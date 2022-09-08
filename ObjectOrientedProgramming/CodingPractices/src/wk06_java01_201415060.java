/**
wk06_java01_201415060 클래스는  
프레임 객체를 생성하고
창조절 버튼 설정,
좌우 패널 추가,
프레임과 좌우 패널 접착,
프레임 보이기를
하기 위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**자바 프레임 도입*/
import javax.swing.JFrame;
/**추상 창 도구 클래스의 모든 자식 클래스 도입. Dimension, Color, Container, Window*/
import java.awt.*;
/**이벤트 클래스의 모든 자식 클래스 도입. ActionListener, ActionEvent*/
import java.awt.event.*;
/**스윙 클래스의 모든 자식 클래스 도입. JButton, JLabel, JPanel, AbstractButton, JComponent*/
import javax.swing.*;


/**좌우 패널. 자바 패널을 상속. javax.swing.JPanel*/
/**좌우 패널은 사용자가 두개의 버튼을 눌러 문자열의 폰트를 바꾸게 합니다.*/
/**좌우 패널은 버튼과 라벨을 포함합니다.*/
class LeftRightPanel extends JPanel
{
	
	/**자바 버튼형 참조 좌우 선언. javax.swing.JButton*/
	private JButton left, right;
	/**자바 라벨형 참조 라벨 선언. javax.swing.JLabel*/
	private JLabel label;
	/**자바 패널형 참조 버튼 패널 선언. javax.swing.JPanel*/
	private JPanel buttonPanel;
	
	/**좌우 패널의 생성자*/
	public LeftRightPanel()
	{
		/**왼쪽에 "왼쪽"이란 이름을 가진 자바 버튼 생성과 참조*/
		left = new JButton("Left");
		/**오른쪽에 "오른쪽"이란 이름을 가진 자바 버튼 생성과 참조*/
		right = new JButton("Right");
		
		/**버튼 리스너 생성*/
		ButtonListener listener = new ButtonListener();
		/**좌 버튼에 리스너를 붙임. javax.swing.AbstractButton.addActionListener(액션리스너)에 의존*/
		left.addActionListener(listener);
		/**우 버튼에 리스너를 붙임*/
		right.addActionListener(listener);
		
		/**좌우 패널의 라벨을 생성*/
		label = new JLabel("Push a button");
		
		/**버튼 패널 생성*/
		buttonPanel = new JPanel();
		/**버튼 패널의 크기 설정 메소드 호출. 실매개변수로 차원 생성. 콤포넌트 픽셀이 가로 200, 세로 40. javax.swing.JComponent.setPreferredSize(차원)에 의존*/
		buttonPanel.setPreferredSize(new Dimension(200, 40));
		/**버튼 패널의 배경색 설정. 실매개변수로 컬러의 고정 변수 파랑. javax.swing.JComponent.setBackground(Color)에 의존*/
		buttonPanel.setBackground(Color.blue);
		/**버튼 패널에 좌 버튼 추가. javax.swing.JComponent.add(콤포넌트)에 의존*/
		buttonPanel.add(left);
		/**버튼 패널에 우 버튼 추가*/
		buttonPanel.add(right);
		
		/**좌우 패널 크기 설정, 실매개변수로 차원 생성. 가로 200, 세로 40. javax.swing.JComponent.setPreferredSize(차원)에 의존*/
		setPreferredSize(new Dimension(200, 80));
		/**좌우 패널 배경색 설정. 실매개변수로 컬러의 고정 변수 바다색. javax.swing.JComponent.setBackground(Color)에 의존*/
		setBackground(Color.cyan);
		/**좌우 패널에 라벨 추가. javax.swing.JComponent.add(콤포넌트)에 의존*/
		add(label);
		/**좌우 패널에 버튼 패널 추가. javax.swing.JComponent.add(콤포넌트)에 의존*/
		add(buttonPanel);
	}
	
	/**전용 클래스 버튼 리스너 정의. 액션 리스너를 구현. java.awt.ActionListener*/
	private class ButtonListener implements ActionListener
	{
		/**버튼 리스너의 액션 수행 메소드. 실매개 변수로 리스너를 추가한 콤포넌트의 이벤트*/
		public void actionPerformed(ActionEvent event)
		{
			/**이벤트의 소스가 좌 버튼이면*/
			if(event.getSource() == left)
				/**라벨의 문자를 좌로 설정*/
				label.setText("Left");
			/**이벤트 소스가 좌 버튼이 아니면, 즉 우 버튼이면*/
			else
				/**라벨의 문자를 우로 설정*/
				label.setText("Right");
		}
	}
}

public class wk06_java01_201415060
{
	/**
	main 함수는
	프레임 객체를 생성하고
	창조절 버튼 설정,
	좌우 패널 추가,
	프레임과 좌우 패널 접착,
	프레임 보이기를
	합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**자바 프레임형 프레임 생성자. 실매개변수는 프레임 이름 "좌우". javax.swing.JFrame*/
		JFrame frame = new JFrame("Left Right");
		/**프레임 객체의 창조절 버튼 설정. 최소화, 최대화, 닫기. javax.swing.JFrame.setDefaultCloseOperation(int)*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**프레임 객체의 콘텐트 페인(java.awt.Container)에 좌우패널 객체를 생성해서 추가. java.awt.Container.add(콤포넌트)에 의존*/
		frame.getContentPane().add(new LeftRightPanel());
		
		/**프레임을 좌우 패널 크기에 맞춤. java.awt.Window.pack()에 의존*/
		frame.pack();
		/**프레임을 모니터 화면에 보이기. java.awt.Window.setVisible()에 의존*/
		frame.setVisible(true);
	}
}
