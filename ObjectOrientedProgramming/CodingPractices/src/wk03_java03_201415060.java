/**
wk03_java03_201415060 Ŭ������ �̸��� ���� �Է� �ް� �̸��� ù���ڿ� ���� ù �ټ� ���ڸ� �����ϰ� �ű⿡ ���ڸ� �ڿ����� �����Ͽ� ���̵� ����� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper ����
*/

import java.util.Scanner;
import java.util.Random;

/**
main �Լ��� �̸��� ���� �Է� �ް� �̸��� ù���ڿ� ���� ù �ټ� ���ڸ� �����ϰ� �ű⿡ �� �ڸ� �ڿ����� �����Ͽ� ���̵� ����ϴ�.
@param args: the command line arguments
@return void
*/

public class wk03_java03_201415060{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**�̸�, ��, ���̵� ���� ���� ����*/
		String firstname, lastname, ID;
		/**������ ���� ����� ���� ���� ��ü ����*/
		Random generator = new Random();
		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		
		/**�̸� �Է� ����*/
		System.out.print("Enter the first name: ");
		/**�̸� �Է�*/
		firstname = scan.next();
		
		/**�� �Է� ����*/
		System.out.print("Enter the last name: ");
		/**�� �Է� ����*/
		lastname = scan.next();
		
		/**�̸��� ù���ڿ� ���� ù �ټ� ���ڸ� �����ϰ� �ű⿡ ���ڸ� �ڿ����� ����*/
		ID = firstname.charAt(0)
				+ lastname.substring(0,5)
				+ (generator.nextInt(90)+10);
		
		/***/
		System.out.println(ID);
	}

}
