/**
wk04_java06_201415060 Ŭ������
���� �� ���� �� �پ� ���Ͽ� ���̰� �ִ� ���� ���
�ϱ� ���� Ŭ�����Դϴ�.

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;
/**����� ���ܸ� ������ ���� ����� Ŭ���� ����*/
import java.io.*;


public class wk04_java06_201415060 {
	/**
	main �Լ���
	���� �� ���� �� �پ� ���Ͽ� ���̰� �ִ� ���� ���
	�մϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		/**�� ������ �� ���� �����ϴ� ���ڿ� ��ü ���� ����*/
		String line1 = "", line2 = "";
		
		/**������ ã�⳪ ���� ���� �˻� ����*/
		try{
			/**���� ��ĳ�� ���� ����*/
			Scanner fileScan1, fileScan2;
			/**�� 1 ���� ��ĳ�� ��ü ����*/
			fileScan1 = new Scanner( new File("in1.txt") );
			/**�� 2 ���� ��ĳ�� ��ü ����*/
			fileScan2 = new Scanner( new File("in2.txt") );
		
			/**�� �ݺ��� ����� �ʱ�ȭ*/
			int lineIterator = 0;
			/**�� 1 ���� �Ǵ� �� 2 ���Ͽ� ���� ���ڿ��� �ִ� ����*/
			while( fileScan1.hasNext() || fileScan2.hasNext()){
				/**�� �ݺ��ڸ� 1�� ������Ű�鼭*/
				lineIterator++;
				/**�� 1 ���Ͽ��� �� ���� �Է�*/
				line1 = fileScan1.nextLine();
				/**�� 2 ���Ͽ��� �� ���� �Է�*/
				line2 = fileScan2.nextLine();
				/**�� 1 ���ϰ� �� 2 ������ �ٸ���*/
				if( !line1.equals(line2) ){
					/**�ٸ� ���� ���Ͽ����� ��ġ�� ����ϰ�*/
					System.out.println("- line "+ lineIterator +" in \"in1.txt\" and \"in2.txt\" ");
					/**�� 1 ������ �� �� ���*/
					System.out.println(line1);
					/**�� 2 ������ �� �� ���*/
					System.out.println(line2);
				}
			}
		
		}
		/**���� �ޱ�*/
		catch(FileNotFoundException e){
			/**���� �޼��� ���*/	
			e.printStackTrace();
		}
	}
}
