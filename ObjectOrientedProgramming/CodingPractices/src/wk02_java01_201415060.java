/**
 wk02_java01_201415060 Ŭ������ ���� 24���� ȭ���� �ٲ� ����ϱ� ���� Ŭ�����Դϴ�.  

 @author 201415060 ������(nalbojima@daum.net)
 @version 1.0 Sep. 2016
 @helper ����
 */


public class wk02_java01_201415060 {

	/**
	 main �Լ��� ���� 24���� ȭ���� �ٲ�  ����մϴ�.
	 @param args: the command line arguments
	 @return void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**����0���� �ش��ϴ� ȭ���µ� 32*/
		final int BASE = 32;
		/**���� 0.5���� �ö� ��, ȭ���� 9.0���� ���*/
		final double CONVERSION_FACTOR = 9.0/5.0;
		/**ȭ���µ��� ������ ����*/
		double fahrenheitTemp;
		/**��ȯ�� �����µ� 24��*/
		int celsiusTemp = 24;
		/**�����µ����� ȭ���µ����� �����*/
		fahrenheitTemp = celsiusTemp * CONVERSION_FACTOR + BASE;
		/**�����µ��� ȭ���µ� ���*/
		System.out.println( "Celsius Temperature = " + celsiusTemp);
		System.out.println( "Fahrenheit Equivalent = " + fahrenheitTemp);
	}

}
