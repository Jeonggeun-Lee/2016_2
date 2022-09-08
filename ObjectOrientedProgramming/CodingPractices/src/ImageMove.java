/**

하기 위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/***/
public class ImageMove
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
	   JFrame frame = new JFrame ("ImageMove");
	   /**창 버튼. 최소, 최대, 닫기*/
	   frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	   /**패널을 프레임의 팬에 더함*/
	   frame.getContentPane().add(new ImagePanel());

	   /**패널을 묶음*/
	   frame.pack();
	   /**프레임을 보여줌*/
	   frame.setVisible(true);
   }
}
