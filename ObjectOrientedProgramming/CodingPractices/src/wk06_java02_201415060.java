/**
wk06_java02_201415060 Ŭ������  
Style Options �г��� �����ӿ� �߰��ϰ� ���� �ִ� �����
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

/**Ŭ���� ������ ���� �ڽ� Ŭ������ �޼ҵ�
 * ���� ����
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

/**�󺧰� üũ�ڽ��� ���� �г� Ŭ���� ����*/
class StyleOptionsPanel extends JPanel
{
	/**�� ����*/
	private JLabel saying;
	/**üũ �ڽ� ����*/
	private JCheckBox bold, italic;
	
	/**�г� ������*/
	public StyleOptionsPanel()
	{
		/**�� ����*/
		saying = new JLabel("Say it with style!");
		/**�� ��Ʈ.
		 * ��Ʈ ��ü �����Ͽ� �Ű�������.
		 * �� 1 �Ű������� �ۼ��� ���� �̸�.
		 * �� 2 �Ű������� ��Ʈ ����. PLAIN�� �⺻
		 * �� 3 �Ű������� ���� ũ��*/
		saying.setFont(new Font("Helvetica", Font.PLAIN, 36));
		
		/**üũ�ڽ� ����. ��Ʈü*/
		bold = new JCheckBox("Bold");
		/**üũ�ڽ� ���� �ٴٻ�*/
		bold.setBackground(Color.cyan);
		/**üũ�ڽ� ����. ���Ÿ�ü*/
		italic = new JCheckBox("Italic");
		/***/
		italic.setBackground(Color.cyan);
		
		/**üũ�ڽ��� ������ ����*/
		StyleListener listener = new StyleListener();
		/**üũ�ڽ��� ������ ����*/
		bold.addItemListener(listener);
		/***/
		italic.addItemListener(listener);
		
		/**�гο� �� ����*/
		add(saying);
		/**�гο� üũ�ڽ� ����*/
		add(bold);
		/***/
		add(italic);
		
		/**�г� ����. �ٴٻ�*/
		setBackground(Color.cyan);
		/**�г� ũ�� ����*/
		setPreferredSize(new Dimension(300, 100));
	}
	
	/**üũ�ڽ� ������ ����*/
	private class StyleListener implements ItemListener
	{
		/**�������� �޼ҵ� ����.*/
		public void itemStateChanged(ItemEvent event)
		{
			/**üũ�� �� �Ǹ� �⺻ ��Ʈ*/
			int style = Font.PLAIN;
			
			/**���尡 üũ�Ǹ�*/
			if(bold.isSelected())
				/**��Ÿ�� ��� ���� ������ ���� ������*/
				style = Font.BOLD;
			
			/**���Ÿ��� üũ�Ǹ�*/
			if(italic.isSelected())
				/**��Ÿ�� ��� ���� ������ ���Ÿ� �� ����*/
				style += Font.ITALIC;
			
			/**���� ��Ʈ�� �ٽ� ����*/
			saying.setFont(new Font("Helvetica", style, 36));
		}
	}
}


public class wk06_java02_201415060 {
	/**
	main �Լ���
	Style Options �г��� �����ӿ� �߰��ϰ� ���� �ִ� �����
	�մϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**������ ����*/
		JFrame frame = new JFrame("Style Options");
		/**â ��ư. ������ ���α׷� ����*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**�г��� �����ӿ� ����*/
		frame.getContentPane().add(new StyleOptionsPanel());
		/**���� ����*/
		frame.pack();
		/**�������� ������ ����*/
		frame.setVisible(true);
	}
}
