/**

�ϱ� ���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/***/
public class ImageMove
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
	   JFrame frame = new JFrame ("ImageMove");
	   /**â ��ư. �ּ�, �ִ�, �ݱ�*/
	   frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	   /**�г��� �������� �ҿ� ����*/
	   frame.getContentPane().add(new ImagePanel());

	   /**�г��� ����*/
	   frame.pack();
	   /**�������� ������*/
	   frame.setVisible(true);
   }
}
