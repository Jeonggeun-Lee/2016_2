/**
wk04_java02_201415060 Ŭ������ 
���Ͽ� ���ͳ� �ּҰ� �� �ٿ� �ϳ��� ���� ���� �ִ� ��Ȳ���� 
���ͳ� �ּ� �� ���� �о� ����ϰ�
�ٽ� "/"�� �����ڷ� �ؼ� �� ��ū�� �� �ٿ� ���
�ϴ� Ŭ�����Դϴ�. 

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ������
*/

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;
/**����� ���ܸ� ������ ���� ����� Ŭ���� ����*/
import java.io.*;

public class wk04_java02_201415060 {

	/**
	main �Լ���
	���Ͽ� ���ͳ� �ּҰ� �� �ٿ� �ϳ��� ���� ���� �ִ� ��Ȳ���� 
	���ͳ� �ּ� �� ���� �о� ����ϰ�
	�ٽ� "/"�� �����ڷ� �ؼ� �� ��ū�� �� �ٿ� ���
	�մϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**���ͳ��ּ� ���� ���ڿ� ��ü ���� ����*/
		String url;
		/**���ϰ� ��ū ��ĳ�� ��ü ���� ����*/
		Scanner fileScan, urlScan;
		
		/**���� �˻�, ���� ���� ���� �˻� ����*/
		try
		{
			/**���� �Է� ��ĳ�� ��ü ���� */
			fileScan = new Scanner(new File("websites.inp"));
			/**���Ͽ��� ���� �Է��� ���� �ִ� ����*/
			while (fileScan.hasNext())
			{
				/**���Ͽ��� �� �ٿ� �ִ� ���ͳ� �ּ� �Է�*/
				url = fileScan.nextLine();
				/**���ͳ� �ּ� ���*/
				System.out.println("URL = " + url);
				
				/**��ū ��ü ����*/
				urlScan = new Scanner(url);
				/**��ū�� �����ڸ� "/"�� ����*/
				urlScan.useDelimiter("/");

				/**��ū�� ������ �ִ� ����*/
				while (urlScan.hasNext())
				{
					/**�� �ٿ� ����� ��ū�� ���*/
					System.out.println(" " + urlScan.next());
				}
				/**�� �� ���ͳ� �ּ��� ��ū�� �� ��µǸ� �� �� ��*/
				System.out.println();
			}
		}
		/**�������� FileNotFoundException���� ���ܸ� �޾�����*/
//		catch (FileNotFoundException e)
		/**���� ���翡 ���� ��� IOException���� ���ܸ� �޾Ҵ�.*/
		catch (IOException e)
		{
			/**�������� �Է��� ���ε� ���ܿ� ���� �޼����� ����ϴ� �޼ҵ�� ���δ�.*/
			e.printStackTrace();
			
		}

	}

}
