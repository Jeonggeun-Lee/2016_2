/**
 * ��� ���̱� ���� �׽�Ʈ Ŭ����
 * @author ������
 * @version 1.0
 */

public class RamyeonTest {

	public static void main(String[] args)
	{
		/**��� ��ü ����*/
		Ramyeon ramyeon = new Ramyeon();
		
		/**��� ���� �ֹ�: ġ�� ���*/
		ramyeon.menuOrder(Ramyeon.Ramen.Cheese);
		System.out.print(ramyeon);
		
		/**�� ����*/
		ramyeon.addMat("��");
		System.out.print(ramyeon);
		
		/**�� ����*/
		ramyeon.boil();
		System.out.print(ramyeon);
		
		/**�� ����*/
		ramyeon.addMat("��");
		System.out.print(ramyeon);
		
		/**���� ����*/
		ramyeon.addMat("����");
		System.out.print(ramyeon);
		
		/**�� ����*/
		ramyeon.changeMat("��");
		
		/**������ �� ����*/
		ramyeon.addMat("������ ��");
		System.out.print(ramyeon);
		
		/**ġ�� ����*/
		ramyeon.addMat("ġ��");
		
		/**ġ�� ��� �ϼ�*/
		System.out.print(ramyeon);
		
		ramyeon.subtractMat("���� ��");
		
		System.out.print(ramyeon);
		

	}
	
}
