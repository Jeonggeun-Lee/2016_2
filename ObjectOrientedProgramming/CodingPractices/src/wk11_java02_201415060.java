/**
wk11_java02_201415060 Ŭ������  
����� ���� ���ܸ� ������ �� �ִ� ���ɼ��� �����ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper ����
*/
import java.util.Scanner;

public class wk11_java02_201415060
{
	/**
	main �Լ���
	���� ��ü�� ����� ���� �װ��� ����
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main (String[] args) throws OutOfRangeException
	{
		/**�Է� ������ �ִ� �ּҰ�*/
		final int MIN = 25, MAX = 40;
		/**�Է��� �޴� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner (System.in);
		/**���ܰ�ü ����. ���� �޽��� ����*/
		OutOfRangeException problem = new OutOfRangeException ("Input value is out of range.");
		/**���� �ȿ��� �Է��� ����*/
		System.out.print ("Enter an integer value between " + MIN + " and " + MAX + ", inclusive: ");
		/**���� �Է��� ����*/
		int value = scan.nextInt();
		
		/**���ܸ� ���������� �Ǵ��մϴ�.*/
		if (value < MIN || value > MAX)
			/**���ܸ� ����*/
			throw problem;
		/**���� �޼ҵ��� ���� �˸�*/
		System.out.println ("End of main method.");  // may never reach
	}
}

/**OutOfRangeException Ŭ������
 * ���� � Ư�� ���� �ۿ� �ִ� ���� ������ ǥ���մϴ�.
 * */
class OutOfRangeException extends Exception
{
	/**Ư�� �޽����� ���� ��ü�� �����մϴ�.*/
	OutOfRangeException (String message)
	{
		/**�θ��� ���� Ŭ������ ������*/
		super (message);
	}
}
