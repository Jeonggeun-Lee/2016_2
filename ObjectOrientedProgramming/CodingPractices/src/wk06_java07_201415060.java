/**
wk06_java07_201415060 Ŭ������  
�����ӿ� �̸��� �г��� ���ϰ� ���̰� �����ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
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

/**�̸��� �г�*/
class EmailPanel extends JPanel
{
	/**�޴� ���, �Բ� �޴� ���, ���� �Բ� �޴� ���, ����, ���� ���� ����*/
   private JLabel toLabel, ccLabel, bccLabel, subjectLabel, messageLabel;
   /**�޴� ���, �Բ� �޴� ���, ���� �Բ� �޴� ���, ����, ���� ���� ���� ����*/
   private JTextField to, cc, bcc, subject, message;
   /**������ ��ư�� ����*/
   private JButton sendButton;

   /**�̸��� �г� ������*/
   public EmailPanel()
   {
	   /**�޴� ���, �Բ� �޴� ���, ���� �Բ� �޴� ���, ����, ���� �� ����*/
      toLabel = new JLabel ("To:");
      /***/
      ccLabel = new JLabel ("CC:");
      /***/
      bccLabel = new JLabel ("Bcc: ");
      /***/
      subjectLabel = new JLabel ("Subject: ");
      /***/
      messageLabel = new JLabel ("Message: ");

      /**������ ��ư ����*/
      sendButton = new JButton("Send");
      
      /**�޴� ���, �Բ� �޴� ���, ���� �Բ� �޴� ���, ����, ���� ���� �� ����*/
      to = new JTextField (20);
      /***/
      cc = new JTextField (20);
      /***/
      bcc = new JTextField (20);
      /***/
      subject = new JTextField (30);
      /***/
      message = new JTextField (50);
     
      /**������ ��ư�� ������ ����*/
      sendButton.addActionListener (new TempListener());

      /**�гο� �󺧰� �� ���� ���� ��ư ����*/
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

      /**�г� ũ�� ����*/
      setPreferredSize (new Dimension(800, 500));

   }

   /**��ư�� ������*/
   private class TempListener implements ActionListener
   {

	   /**��ư�� ������ ȣ���ϴ� �޼ҵ�*/
	  public void actionPerformed (ActionEvent event)
      {
		  /**ǥ�� �������
		   * �޴� ���, �Բ� �޴� ���, ���� �Բ� �޴� ���, ����, ���� ���*/
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
	main �Լ���
	�����ӿ� �̸��� �г��� ���ϰ� ���̰� ������
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
   public static void main (String[] args)
   {
	   /**������ ����*/
	   JFrame frame = new JFrame ("e-mail");
	   /**â ��ư. �ּ�, �ִ�, �ݱ�*/
	   frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	   /**�̸��� �г� ����*/
	   EmailPanel panel = new EmailPanel();
	   /**�������� �ҿ� �г��� ����*/
	   frame.getContentPane().add(panel);

	   /**�г��� ����*/
	   frame.pack();
	   /**�������� ����*/
	   frame.setVisible(true);
   }
}
