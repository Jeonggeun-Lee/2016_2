/**
 wk02_java02_201415060 Ŭ������ �� ���� ���ڸ� �Է¹޾� �״�� ����ϱ� ���� Ŭ�����Դϴ�.  

 @author 201415060 ������(nalbojima@daum.net)
 @version 1.0 Sep. 2016
 @helper ����
 */

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;

public class wk02_java02_201415060 {

	/**
	 main �Լ��� �� ���� ���ڸ� �Է¹޾� �״�� ����մϴ�.
	 @param args: the command line arguments
	 @return void
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**�Է��� ������ ���ڿ�����*/
		String message;
		/**��ĳ�� ��ü ����*/
		Scanner scan = new Scanner (System.in);
		/**�Է��� ����*/
		System.out.println ("Enter a line of text:");
		/**���͸� ĥ ������ �Է�*/
		message =  scan.nextLine();
		/**�Է³����� ���*/
		System.out.println("You entered \"" + message + "\"");
	}
}
