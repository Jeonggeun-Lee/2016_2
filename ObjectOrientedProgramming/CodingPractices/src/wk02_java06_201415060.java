/**
wk02_java05_201415060 Ŭ������ �ʸ� �Է� �޾� ��,��,�ʷ� ����Ͽ� ����ϱ� ���� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper ����
*/

import java.util.Scanner;


public class wk02_java06_201415060 {

/**
main �Լ��� �ʸ� �Է� �޾� ��,��,�ʷ� ����Ͽ�  ����մϴ�.
@param args: the command line arguments
@return void
*/


	public static void main(String[] args) {

		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		/**�Է� �ʿ� ��ȯ �� �ð�, ��, �ʸ� ������ ����*/
		int totalSecond, hour, minute, second;
		/**�� �Է��� ����*/
		System.out.print("Input seconds: ");
		/**�Է��� �� �� ������ ��ü �� ������ ����*/
		totalSecond = scan.nextInt();
		/**�ð��� ����� ����*/
		hour = totalSecond/3600;
		/**�ð� ���*/
		System.out.println("hours = " + hour);		
		/**�ð��� ���� ��ü �ʿ��� ����*/
		totalSecond %=3600;
		/**���� ����� ����*/
		minute = totalSecond/60;
		/**���� ���*/
		System.out.println("minutes = " + minute);
		/**���� ���� ��ü �ʿ��� ����*/
		totalSecond %=60;
		/**���� �ʸ� ����*/
		second = totalSecond;
		/**�ʸ� ���*/
		System.out.println("seconds = " + second);		
	}

}
