/**
 wk02_java05_201415060 Ŭ������ ��,��,�ʸ� �Է� �޾� �ʷ� ����Ͽ� ����ϱ� ���� Ŭ�����Դϴ�.  

 @author 201415060 ������(nalbojima@daum.net)
 @version 1.0 Sep. 2016
 @helper ����
 */
/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;
public class wk02_java05_201415060 {

	/**
	 main �Լ��� ��,��,�ʸ� �Է� �޾� �ʷ� ����Ͽ�  ����մϴ�.
	 @param args: the command line arguments
	 @return void
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		/**�ð�, ��, �ʿ� ���� ��ü �ʸ� �����ϴ� ����*/
		int hour, minute, second, totalSecond;
		/**�ð� �Է� ����*/
		System.out.print("Input hours: ");
		/**�Է��� �� �� ������ �ð� ������ ����*/
		hour = scan.nextInt();
		/**�� �Է� ����*/
		System.out.print("Input minutes: ");
		/**�Է��� �� �� ������ �� ������ ����*/
		minute = scan.nextInt();
		/**�� �Է� ����*/
		System.out.print("Input seconds: ");
		/**�Է��� �� �� ������ �� ������ ����*/
		second = scan.nextInt();
		/**��ü �ʸ� ����ϴ� ��*/
		totalSecond = hour*3600+minute*60+second;
		/**��ü �ʸ� ���*/
		System.out.println("Total seconds = " + totalSecond);
	}

}
