/**
wk06_java09_201415060 클래스는  
텍스트 통계 패널을 더하고 붙이고 보여주
기 위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**
 * PP06.15
 * 글의 한 조각의 기초 통계를 내기 위한 간단한 도구를 개발하라.
 * 응용프로그램이 가질 것은 하나의 창에 스크롤 글상자(JTextArea)와 통계 상자이다.
 * 그 통계 상자는 패널로서 제목 경계를 가지고 라벨 필드를 포함하여 글 상자의 단어 수와 평균 단어 길이를 보여준다.
 * 또 네가 더하고 싶은 다른 통계도 가능하다.
 * 통계 상자는 버튼을 가져서 누르면 텍스트 필드의 현재 내용의 통계를 다시 계산한다.
 * */

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

/**통계 패널*/
class StatPanel extends JPanel
{
	/**통계를 낼 텍스트 구역*/
	private JTextArea textArea;
	/**라벨과 버튼을 모아 둘 분석 패널*/	
	private JPanel analPanel;
	/**문자열 개수 헤더 라벨*/		
	private JLabel strsLabel;
	/**문자열 개수 라벨*/	
	private JLabel strs;
	/**단어 개수 헤더 라벨*/	
	private JLabel wordsLabel;
	/**단어 개수 라벨*/	
	private JLabel words;
	/**통계 지시 버튼*/		
	private JButton button;
	/**통계 패널 생성자*/
	public StatPanel()
	{
		/**텍스트 구역 생성*/
		textArea = new JTextArea(7,20);
		/**텍스트 구역에 스크롤 기능 더함*/
		add( new JScrollPane(textArea) );
		
		/**문자열 개수 헤더 라벨 생성*/
		strsLabel = new JLabel("문자열의 길이 : ");
		/**문자열 개수 라벨 생성*/
		strs = new JLabel("0");
		
		/**단어 개수 헤더 라벨 생성*/
		wordsLabel = new JLabel("단어의 수 : ");
		/**단어 개수 라벨 생성*/
		words = new JLabel("0");
		/**통계 지시 버튼 생성*/
		button = new JButton("계산");
		/**버튼 리스너 생성*/
		ButtonListener listener = new ButtonListener();	
		/**버튼 리스너 더함*/
		button.addActionListener(listener);
		/**분석 패널 생성*/
		analPanel = new JPanel();
		/**분석 패널의 제목 설정*/
		analPanel.setBorder(BorderFactory.createTitledBorder("<Analysis>"));
		/**분석 패널에 라벨과 버튼 더함*/
		analPanel.add(strsLabel);
		/***/
		analPanel.add(strs);
		/***/
		analPanel.add(wordsLabel);
		/***/
		analPanel.add(words);
		/***/
		analPanel.add(button);
		/**통계 패널에 분석 패널 더함*/
		add(analPanel);
	
	}
	
	/**버튼 리스너*/
	private class ButtonListener implements ActionListener
	{	
		/**버튼 누르면 호출하는 메소드*/
		public void actionPerformed(ActionEvent event)
		{			
			/**텍스트 길이 저장 변수*/
			Integer txtLen = textArea.getText().length();
			/**텍스트 구역에서 스캔*/
			Scanner txtScan = new Scanner( textArea.getText() );
			/**문자열 개수 세는 변수*/
			Integer sum = 0;
			/**스캔한 문자열 참조*/
			String temp;
			/**스캔할 것이 있는 동안*/
			while(txtScan.hasNext())
			{
				/**텍스트 구역에서 한 문자열 스캔*/
				temp = txtScan.next();
				/**문자열 개수 증가*/
				sum++;
			}
			
			/**텍스트 길이를 라벨에 표시*/
			strs.setText(txtLen.toString());
			/**단어 수를 라벨에 표시*/
			words.setText(sum.toString());
			
		}		
	}
}

public class wk06_java09_201415060
{
	/**
	main 함수는
	텍스트 통계 패널을 더하고 붙이고 보여줍
	니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{	
		/**프레임 생성*/
		JFrame frame = new JFrame("텍스트 분석 프로그램");	
		/**창 버튼. 최소, 최대, 닫기*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		/**패널을 팬에 더함*/
		frame.getContentPane().add(new StatPanel());		
		/**패널을 붙임*/
		frame.pack();
		/**프레임을 보여줌*/
		frame.setVisible(true);
	}
}
