/**
 * �ڽ� Ŭ����. ���.
 * @author ������
 * @version 1.0
 */
public class Ramyeon extends Food
{
	/**��� ���� ����*/
	enum Ramen{Cheese, Mandu, Haemul};
	/**��� ���� ���� ����*/
	private Ramen kind;
	
	/**����� ������. �� �� ����
	 * @param void*/
	public Ramyeon()
	{
		super();		
	}
	
	/**��ǥ ���� �޼ҵ�. �޴� �ֹ�.
	 * ��� ������ ���ϰ� �׿� ���� ��Ḧ �����Ѵ�.
	 * @param kind ��� ����
	 * @return void
	 * */
	public void menuOrder(Ramen kind)
	{
		/**�� ��� ��ü�� ������ �ֹ��� ������ �����Ѵ�.*/
		this.kind = kind;
		
		/**���� ���� ��ǥ ��Ḧ �����Ѵ�.
		 * ��� ������ ���� ������ ���� ����*/
		String ramyeonMatArr[] = { "��", "��", "����", "��", null };
		String ramyeonGoalMatArr[] = { "���� ��", "��","����","������ ��", null };
				
		switch(kind)
		{
		case Cheese :
			ramyeonMatArr[ramyeonMatArr.length-1] = "ġ��";
			ramyeonGoalMatArr[ramyeonGoalMatArr.length-1] = "ġ��";
			break;
		case Mandu :
			ramyeonMatArr[ramyeonMatArr.length-1] = "����";
			ramyeonGoalMatArr[ramyeonGoalMatArr.length-1] = "����";
			break;
		case Haemul :
			ramyeonMatArr[ramyeonMatArr.length-1] = "�ع�";
			ramyeonGoalMatArr[ramyeonGoalMatArr.length-1] = "�ع�";
			break;			
		}
		/**��ü�� �θ� ���� �κ��� �޴��� �°� �ٲ۴�.*/
		super.preparedMatArr = ramyeonMatArr;
		super.goalMatArr = ramyeonGoalMatArr;		
	}
	
	/**���� ���̴� �޼ҵ�
	 * @param void
	 * @return ���� �־��� ���� �־��� �� ��. �ƴϸ� ����*/
	boolean boil()
	{
		/**���� ��ᰡ ������ �� ����*/
		if( inputMatArr == null ) return false;
		
		/**���� ��ᰡ �� �̻��̸� �� ���� �ٸ� ��ᰡ �����Ƿ� ����*/
		if( inputMatArr.length != 1) return false;
		
		/**������ ����� ���� ������ "���� "���� �ٲ�*/
		if( inputMatArr[0].equals("��") )
		{
			inputMatArr[0] = "���� "+inputMatArr[0];
			return true;
		}
		
		/**������ ��ᰡ ���� �ƴϸ� �� ����*/
		return false;
	}
	
	/**toString �����: ����� ���� ���� ���ڿ��� �߰�*/
	public String toString()
	{
		String kind = "////////////////////////////\n"+"���� : ";
		if(this.kind == Ramen.Cheese) kind += "ġ����\n";
		if(this.kind == Ramen.Mandu) kind += "���ζ��\n";
		if(this.kind == Ramen.Haemul) kind += "�ع����\n";
		return kind+super.toString();
	}
}