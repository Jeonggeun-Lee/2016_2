/**
wk03_java09_201415060 Ŭ������ ��ǻ�Ϳ� ����ڰ� ������������ �ϱ� ���� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper ����
*/

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;
/**������ ���� ���� ���� Ŭ���� ����*/
import java.util.Random;

public class wk03_java09_201415060 {

	/**
	main �Լ��� ����ڿ��� ����, ����, �� �� �ϳ��� �Է¹ް� ��ǻ���� ����, ����, ���� �������� ������ �� ��, ��, ����� �����մϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		/**������ ���� �̱� ���� ���� ��ü ����*/
		Random generator = new Random();
		/**������ ���� �����ϴ� ����*/
		int temp;
		/**��ǻ�Ϳ� ������� ����, ����, �� ���ڿ��� ���� ����*/
		String com = "", user;
		
		/**����ڿ� ����, ����, �� �Է� ����*/
		System.out.print("Select word(\"scissors\", \"rock\", \"paper\"): ");
		/**����� ����, ����, �� �Է�*/
		user = scan.next();
		
		/**0,1,2 �� �������� �� �̱�*/
		temp = generator.nextInt(3);
		/**���� ���� 0�̸� ��ǻ�ʹ� ������ ��*/
		if(temp == 0) {com = "scissors";}
		/**���� ���� 1�̸� ��ǻ�ʹ� ������ ��*/
		else if(temp == 1) {com = "rock";}
		/**���� ���� 2�̸� ��ǻ�ʹ� ���� ��*/
		else if(temp == 2) {com = "paper";}
		
		/**��ǻ�Ϳ� ������� ����, ����, �� ���� ���*/
		System.out.println("com(" + com + ") & player(" + user + ")" );
		
		/**��ǻ�Ϳ� ������� ���� ������ ���*/
		if(user.equals(com)){ System.out.println("draw."); }
		/**����ڰ� �̱�� ��� you win. ���*/
		else if( (user.equals("scissors") && com.equals("paper"))
				|| (user.equals("rock") && com.equals("scissors"))
				|| (user.equals("paper") && com.equals("rock") ) )
		{ System.out.println("you win."); }
		/**����ڰ� ���� ��� you lose. ���*/
		else { System.out.println("you lose."); }		 

	}

}
