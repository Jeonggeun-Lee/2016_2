/**
wk06_java01_201415060 Ŭ������  
������ ��ü�� �����ϰ�
â���� ��ư ����,
�¿� �г� �߰�,
�����Ӱ� �¿� �г� ����,
������ ���̱⸦
�ϱ� ���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

/**�ڹ� ������ ����*/
import javax.swing.JFrame;
/**�߻� â ���� Ŭ������ ��� �ڽ� Ŭ���� ����. Dimension, Color, Container, Window*/
import java.awt.*;
/**�̺�Ʈ Ŭ������ ��� �ڽ� Ŭ���� ����. ActionListener, ActionEvent*/
import java.awt.event.*;
/**���� Ŭ������ ��� �ڽ� Ŭ���� ����. JButton, JLabel, JPanel, AbstractButton, JComponent*/
import javax.swing.*;


/**�¿� �г�. �ڹ� �г��� ���. javax.swing.JPanel*/
/**�¿� �г��� ����ڰ� �ΰ��� ��ư�� ���� ���ڿ��� ��Ʈ�� �ٲٰ� �մϴ�.*/
/**�¿� �г��� ��ư�� ���� �����մϴ�.*/
class LeftRightPanel extends JPanel
{
	
	/**�ڹ� ��ư�� ���� �¿� ����. javax.swing.JButton*/
	private JButton left, right;
	/**�ڹ� ���� ���� �� ����. javax.swing.JLabel*/
	private JLabel label;
	/**�ڹ� �г��� ���� ��ư �г� ����. javax.swing.JPanel*/
	private JPanel buttonPanel;
	
	/**�¿� �г��� ������*/
	public LeftRightPanel()
	{
		/**���ʿ� "����"�̶� �̸��� ���� �ڹ� ��ư ������ ����*/
		left = new JButton("Left");
		/**�����ʿ� "������"�̶� �̸��� ���� �ڹ� ��ư ������ ����*/
		right = new JButton("Right");
		
		/**��ư ������ ����*/
		ButtonListener listener = new ButtonListener();
		/**�� ��ư�� �����ʸ� ����. javax.swing.AbstractButton.addActionListener(�׼Ǹ�����)�� ����*/
		left.addActionListener(listener);
		/**�� ��ư�� �����ʸ� ����*/
		right.addActionListener(listener);
		
		/**�¿� �г��� ���� ����*/
		label = new JLabel("Push a button");
		
		/**��ư �г� ����*/
		buttonPanel = new JPanel();
		/**��ư �г��� ũ�� ���� �޼ҵ� ȣ��. �ǸŰ������� ���� ����. ������Ʈ �ȼ��� ���� 200, ���� 40. javax.swing.JComponent.setPreferredSize(����)�� ����*/
		buttonPanel.setPreferredSize(new Dimension(200, 40));
		/**��ư �г��� ���� ����. �ǸŰ������� �÷��� ���� ���� �Ķ�. javax.swing.JComponent.setBackground(Color)�� ����*/
		buttonPanel.setBackground(Color.blue);
		/**��ư �гο� �� ��ư �߰�. javax.swing.JComponent.add(������Ʈ)�� ����*/
		buttonPanel.add(left);
		/**��ư �гο� �� ��ư �߰�*/
		buttonPanel.add(right);
		
		/**�¿� �г� ũ�� ����, �ǸŰ������� ���� ����. ���� 200, ���� 40. javax.swing.JComponent.setPreferredSize(����)�� ����*/
		setPreferredSize(new Dimension(200, 80));
		/**�¿� �г� ���� ����. �ǸŰ������� �÷��� ���� ���� �ٴٻ�. javax.swing.JComponent.setBackground(Color)�� ����*/
		setBackground(Color.cyan);
		/**�¿� �гο� �� �߰�. javax.swing.JComponent.add(������Ʈ)�� ����*/
		add(label);
		/**�¿� �гο� ��ư �г� �߰�. javax.swing.JComponent.add(������Ʈ)�� ����*/
		add(buttonPanel);
	}
	
	/**���� Ŭ���� ��ư ������ ����. �׼� �����ʸ� ����. java.awt.ActionListener*/
	private class ButtonListener implements ActionListener
	{
		/**��ư �������� �׼� ���� �޼ҵ�. �ǸŰ� ������ �����ʸ� �߰��� ������Ʈ�� �̺�Ʈ*/
		public void actionPerformed(ActionEvent event)
		{
			/**�̺�Ʈ�� �ҽ��� �� ��ư�̸�*/
			if(event.getSource() == left)
				/**���� ���ڸ� �·� ����*/
				label.setText("Left");
			/**�̺�Ʈ �ҽ��� �� ��ư�� �ƴϸ�, �� �� ��ư�̸�*/
			else
				/**���� ���ڸ� ��� ����*/
				label.setText("Right");
		}
	}
}

public class wk06_java01_201415060
{
	/**
	main �Լ���
	������ ��ü�� �����ϰ�
	â���� ��ư ����,
	�¿� �г� �߰�,
	�����Ӱ� �¿� �г� ����,
	������ ���̱⸦
	�մϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**�ڹ� �������� ������ ������. �ǸŰ������� ������ �̸� "�¿�". javax.swing.JFrame*/
		JFrame frame = new JFrame("Left Right");
		/**������ ��ü�� â���� ��ư ����. �ּ�ȭ, �ִ�ȭ, �ݱ�. javax.swing.JFrame.setDefaultCloseOperation(int)*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**������ ��ü�� ����Ʈ ����(java.awt.Container)�� �¿��г� ��ü�� �����ؼ� �߰�. java.awt.Container.add(������Ʈ)�� ����*/
		frame.getContentPane().add(new LeftRightPanel());
		
		/**�������� �¿� �г� ũ�⿡ ����. java.awt.Window.pack()�� ����*/
		frame.pack();
		/**�������� ����� ȭ�鿡 ���̱�. java.awt.Window.setVisible()�� ����*/
		frame.setVisible(true);
	}
}
