/**
wk06_java02_201415060 클래스는  
Style Options 패널을 프레임에 추가하고 보여 주는 기능을
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**클래스 도입을 위한 자식 클래스나 메소드
 * 이하 동일
 * .setDefaultCloseOperation()
 * .getContentPane()*/
import javax.swing.JFrame;

/**JLabel
 * JComponent
 * .setFont()
 * .setBackground()
 * .setPreferredSize()
 * JCheckBox
 * 
 * */
import javax.swing.*;

/**Font
 * Color
 * AbstractButton
 * .addItemListener()
 * .isSelected()
 * Container
 * .add()
 * Dimension
 * Window
 * .pack()
 * .setVisible()
 * */
import java.awt.*;
/**ItemEvent*/
import java.awt.event.*;

/**라벨과 체크박스를 가진 패널 클래스 정의*/
class StyleOptionsPanel extends JPanel
{
	/**라벨 참조*/
	private JLabel saying;
	/**체크 박스 참조*/
	private JCheckBox bold, italic;
	
	/**패널 생성자*/
	public StyleOptionsPanel()
	{
		/**라벨 생성*/
		saying = new JLabel("Say it with style!");
		/**라벨 폰트.
		 * 폰트 객체 생성하여 매개변수로.
		 * 제 1 매개변수는 작성자 지정 이름.
		 * 제 2 매개변수는 폰트 종류. PLAIN은 기본
		 * 제 3 매개변수는 글자 크기*/
		saying.setFont(new Font("Helvetica", Font.PLAIN, 36));
		
		/**체크박스 생성. 볼트체*/
		bold = new JCheckBox("Bold");
		/**체크박스 배경색 바다색*/
		bold.setBackground(Color.cyan);
		/**체크박스 생성. 이탤릭체*/
		italic = new JCheckBox("Italic");
		/***/
		italic.setBackground(Color.cyan);
		
		/**체크박스의 리스너 생성*/
		StyleListener listener = new StyleListener();
		/**체크박스에 리스너 붙임*/
		bold.addItemListener(listener);
		/***/
		italic.addItemListener(listener);
		
		/**패널에 라벨 더함*/
		add(saying);
		/**패널에 체크박스 더함*/
		add(bold);
		/***/
		add(italic);
		
		/**패널 배경색. 바다색*/
		setBackground(Color.cyan);
		/**패널 크기 지정*/
		setPreferredSize(new Dimension(300, 100));
	}
	
	/**체크박스 리스너 정의*/
	private class StyleListener implements ItemListener
	{
		/**리스너의 메소드 정의.*/
		public void itemStateChanged(ItemEvent event)
		{
			/**체크가 안 되면 기본 폰트*/
			int style = Font.PLAIN;
			
			/**볼드가 체크되면*/
			if(bold.isSelected())
				/**스타일 상수 전달 변수를 볼드 값으로*/
				style = Font.BOLD;
			
			/**이탤릭이 체크되면*/
			if(italic.isSelected())
				/**스타일 상수 전달 변수에 이탤릭 값 더함*/
				style += Font.ITALIC;
			
			/**라벨의 폰트를 다시 설정*/
			saying.setFont(new Font("Helvetica", style, 36));
		}
	}
}


public class wk06_java02_201415060 {
	/**
	main 함수는
	Style Options 패널을 프레임에 추가하고 보여 주는 기능을
	합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**프레임 생성*/
		JFrame frame = new JFrame("Style Options");
		/**창 버튼. 닫으면 프로그램 종료*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**패널을 프레임에 더함*/
		frame.getContentPane().add(new StyleOptionsPanel());
		/**둘을 묶음*/
		frame.pack();
		/**프레임의 내용을 보임*/
		frame.setVisible(true);
	}
}
