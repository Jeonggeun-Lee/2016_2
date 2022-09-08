/**
 * �丮�ϴ� Ŭ������ �ڽ�. ��� Ŭ����.
 * GUI�� �ش���� ����.
 * @author ������
 * @version 1.0
 */
public class Ramyeon extends Cooking
{
	/**��� Ŭ������ ������. �θ� �������� �μ��� �״�� �μ��� ���´�.*/
	public Ramyeon(int limit, Ingredient[] preparedMaterials, Ingredient[] goalMaterials)
	{
		super(limit, preparedMaterials, goalMaterials);
	}
	
	public String trimIngredient(Ingredient mat)
	{
		if(mat.getState() != "normal")	//���� �ٵ������ ���� ��Ḹ �����Ѵ�.
			return mat.getState();
		
		switch(mat.getName())
		{
		//��Ḧ ������ �Ŀ��� return true�� �������� ��. (���������� �˸��� ����)
		case "��":
			mat.setState("����");
			return "����";
		}
		
		//switch���� �ش��ϴ� ��ᰡ ������ ���,
		return "normal";	//�����ϴ� ��ᰡ �ƴϾ����Ƿ� normal�� �״�� ��ȯ.
	}
	/**��� Ŭ������ ���� �޼ҵ�. �����̱�.
	 * ���� ���� �߰����� ��, ���� ���¸� �������� �ٲ۴�.
	 * ��ǥ ����� ���� ���� ���¿��� �Ѵ�.
	 * ���̱⿡ �����ϸ� ���� ��ȯ.
	 * */
	public boolean boil()
	{
		/**
		 * 1.�� Ŭ������ �θ� �κп��� ÷���� ����� �迭�� ���� ���� �޾� �´�. 
		 * 2.÷�� ��� �迭�� ���� ������ ������ �����Ѵ�.
		 * 3.�ٷ� ���� ������ ���� �����ϸ� �� ���� �ݺ��ڸ� �迭�� ������ �Ѵ�. �ݺ��� �����.  
		 * */
		/**1*/
		Ingredient[] temp = super.getAddedMaterials();
		/**2*/
		int tempTail = 0;
		/**3*/
		for(int i=0; i < temp.length; i++)
			if( temp[i] == null)
			{
				tempTail = i;
				break;
			}
		
		/**÷�� ��� �迭�� ���̰ų�
		 * �迭�� ���� 1�� �ƴϰų�(��, �� �̿ܿ� �ٸ� ÷�� ��ᰡ �ְų�)
		 * ������ ���Ұ� ���� �ƴϰų�
		 * ���� ���� ���°� �⺻(��, ���� ����)�� �ƴϸ�
		 * ������ ��ȯ
		 * */
		if(temp == null
				||  tempTail != 1
				|| !super.getAddedMaterials()[tempTail-1].getName().equals("��")
				|| !super.getAddedMaterials()[tempTail-1].getState().equals("normal")) return false;
		/**÷�� ��ᰡ �����ϰ� ���̶�� ���� ���¸� �������� �����. ��ȯ���� ��.*/
		super.getAddedMaterials()[0].setState("����");
		return true;
	}
}