/**
wk03_java05_201415060 Ŭ������ XXX-XXX-XXXX �������� ��ȭ��ȣ�� �������� ����� Ŭ�����Դϴ�.
��, ù ���ڸ� ���ڴ� ��� 8�̳� 9�� �� �� ����, �� ���� ���ڸ� ���ڴ� 742 �����Դϴ�. 

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper ����
*/

/**������ ���� �̱� ���� ���� Ŭ���� ����*/
import java.util.Random;

public class wk03_java05_201415060 {
	/**
	main �Լ���  xxx-xxx-xxxx �������� ��ȭ��ȣ�� �������� ����ϴ�.
	��, ù ���ڸ� ���ڴ� ��� 8�̳� 9�� �� �� ����, �� ���� ���ڸ� ���ڴ� 742 �����Դϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**������ ���� �̱� ���� ���� ��ü ����*/
		Random generator = new Random();
		
		/**��ȭ��ȣ ���*/
		System.out.println(
				" "
				/**ù ���ڸ� ���� ��� �� �ڸ� ���ڴ� 8�̳� 9�� �� ����*/
				+generator.nextInt(8)
				+generator.nextInt(8)
				+generator.nextInt(8)
				+"-"
				/**���� ���ڸ� ���� ���. ��, 100~742 ����*/
				+( generator.nextInt(643)+100 )
				+"-"
				/**������ ���ڸ� ���� ���*/
				+generator.nextInt(10)
				+generator.nextInt(10)
				+generator.nextInt(10)
				+generator.nextInt(10)
				);
	}
}
