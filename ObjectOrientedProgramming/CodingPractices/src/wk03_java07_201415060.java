/**
wk03_java07_201415060 Ŭ������ �������� �Է� �޾� ���� ���ǿ� �ѳ��̸� ���ϴ� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper ����
*/

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;
/**��� ������ ���� �ڸ��� ���� Ŭ���� ����*/
import java.text.DecimalFormat;
public class wk03_java07_201415060 {
	/**
	main �Լ��� �������� �Է� �޾� ���� ���ǿ� �ѳ��̸� ���մϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**������, ����, �ѳ���*/
		double radius, volume, surface;
		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		/**��� ������ ���� �ڸ��� ���� ��ü ����. �Ҽ��� ���� ���ڸ��� ���*/
		DecimalFormat fmt = new DecimalFormat("0.####");
		
		/**������ �Է� ����*/
		System.out.print("radius: ");
		/**������ �Է�*/
		radius = scan.nextInt();
		/**���� ���� ����*/
		volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3);
		/**�ѳ��� ���� ����*/
		surface = 4.0 * Math.PI * Math.pow(radius, 2);
		
		/**���� ���. �Ҽ��� ���� ���ڸ�������*/
		System.out.println("Volume = "+ fmt.format(volume) );
		/**�ѳ��� ���. �Ҽ��� ���� ���ڸ�������*/
		System.out.println("Surface area = " + fmt.format(surface) );
	}

}
