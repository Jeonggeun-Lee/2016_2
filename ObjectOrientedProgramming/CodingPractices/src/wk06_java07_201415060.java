/**
wk06_java07_201415060 클래스는  
프레임에 이메일 패널을 더하고 붙이고 보여주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**
 * PP6.08
 * Develop an application
 * that implements a prototype user interface for composing an email message.
 * The application should have text fields for the To, CC, and BCC address lists and subject line,
 * and one for the message body.
 * Include a button labeled Send.
 * When the Send button is pushed,
 * the program should print the contents of all fields
 * to standard output using println statements.
 * */
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**이메일 패널*/
class EmailPanel extends JPanel
{
	/**받는 사람, 함께 받는 사람, 숨긴 함께 받는 사람, 제목, 내용 라벨의 참조*/
   private JLabel toLabel, ccLabel, bccLabel, subjectLabel, messageLabel;
   /**받는 사람, 함께 받는 사람, 숨긴 함께 받는 사람, 제목, 내용 쓰는 란의 참조*/
   private JTextField to, cc, bcc, subject, message;
   /**보내기 버튼의 참조*/
   private JButton sendButton;

   /**이메일 패널 생성자*/
   public EmailPanel()
   {
	   /**받는 사람, 함께 받는 사람, 숨긴 함께 받는 사람, 제목, 내용 라벨 생성*/
      toLabel = new JLabel ("To:");
      /***/
      ccLabel = new JLabel ("CC:");
      /***/
      bccLabel = new JLabel ("Bcc: ");
      /***/
      subjectLabel = new JLabel ("Subject: ");
      /***/
      messageLabel = new JLabel ("Message: ");

      /**보내기 버튼 생성*/
      sendButton = new JButton("Send");
      
      /**받는 사람, 함께 받는 사람, 숨긴 함께 받는 사람, 제목, 내용 쓰는 란 생성*/
      to = new JTextField (20);
      /***/
      cc = new JTextField (20);
      /***/
      bcc = new JTextField (20);
      /***/
      subject = new JTextField (30);
      /***/
      message = new JTextField (50);
     
      /**보내기 버튼에 리스너 붙임*/
      sendButton.addActionListener (new TempListener());

      /**패널에 라벨과 글 쓰는 란과 버튼 더함*/
      add (toLabel);
      add (to);
      add (ccLabel);
      add (cc);
      add (bccLabel);
      add (bcc);
      add (subjectLabel);
      add (subject);
      add (messageLabel);
      add (message);
      add (sendButton);

      /**패널 크기 설정*/
      setPreferredSize (new Dimension(800, 500));

   }

   /**버튼의 리스너*/
   private class TempListener implements ActionListener
   {

	   /**버튼을 누르면 호출하는 메소드*/
	  public void actionPerformed (ActionEvent event)
      {
		  /**표준 출력으로
		   * 받는 사람, 함께 받는 사람, 숨긴 함께 받는 사람, 제목, 내용 출력*/
		  System.out.println("To: " + to.getText());
		  /***/
		  System.out.println("CC: " + cc.getText());
		  /***/
		  System.out.println("Bcc: " + bcc.getText());
		  /***/
		  System.out.println("Subject: " + subject.getText());
		  /***/
		  System.out.println("Message: " + message.getText());
      }
   }
}



public class wk06_java07_201415060
{
	/**
	main 함수는
	프레임에 이메일 패널을 더하고 붙이고 보여줍
	니다.
	@param args: the command line arguments
	@return void
	*/
   public static void main (String[] args)
   {
	   /**프레임 생성*/
	   JFrame frame = new JFrame ("e-mail");
	   /**창 버튼. 최소, 최대, 닫기*/
	   frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	   /**이메일 패널 생성*/
	   EmailPanel panel = new EmailPanel();
	   /**프레임의 팬에 패널을 더함*/
	   frame.getContentPane().add(panel);

	   /**패널을 붙임*/
	   frame.pack();
	   /**프레임을 보임*/
	   frame.setVisible(true);
   }
}
