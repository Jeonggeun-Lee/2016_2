/**
 * �θ� Ŭ����. ����
 * �غ�, ����, ��ǥ ��� �迭 �Ӽ���
 * ��� ���ϱ�, ����, �����ϱ�, �ϼ��ߴ��� Ȯ���ϱ� �޼ҵ带
 * ����� ������.
 * @author ������
 * @version 1.0
 */

public class Food
{
	/**
	 * �غ�Ǿ��ִ� ��� ���.
	 * �� ��� ������ ��� ����� �ǹ��Ѵ�.
	 */
	protected String[] preparedMatArr;
	/**
	 * �߰��� ��� ���.
	 * ���� ���� ������ �߰��� ��� ����� �ǹ��Ѵ�.
	 */
	protected String[] inputMatArr;
	/**
	 * ��ǥ ��� ���.
	 * ���������� �ϼ��Ǿ���ϴ� ������ ���¸� �ǹ��Ѵ�.
	 * addedMat�� ���ؼ� ���� ���θ� �Ǵ��Ѵ�.
	 */
	protected String[] goalMatArr;
	
	/**
	 * ��Ḧ �߰��Ѵ�. �� �̹� �ִ� ���� �����Ѵ�.
	 * @param mat �߰��ϴ� ���
	 * @return ��� �߰��� ���� ����
	 */
	public boolean addMat(String mat)
	{
		/**�غ� ��ᰡ ������ ���� �� ����*/
		if(preparedMatArr == null) return false;
		
		/**���� ��ᰡ ������ ���� �Ѱ��� �� �迭�� ��Ḧ �ִ´�*/
		if(inputMatArr == null)
		{
			inputMatArr = new String[1];
			inputMatArr[0] = mat;
			return true;
		}
		
		/**�̹� ��Ḧ �־����� ���� �� ����.*/
		for(int i = 0; i<inputMatArr.length; i++)
			if(inputMatArr[i] == mat)
				return false;
		
		/**���� ��� �߿� ���� ��ᰡ ������
		 * 1.�ӽ� �迭�� ����� ���� ��Ḧ ����ϰ�
		 * 2.���� ����� ũ�⸦ 1 ���� ��Ų��.
		 * 3.����� �迭�� ���� ��ῡ �� �ְ�
		 * 4.�� ��Ḧ ������ ���ҷ� �ִ´�.
		 * */
		/**1*/
		String[] temp = inputMatArr;
		/**2*/
		inputMatArr = new String[inputMatArr.length+1];
		/**3*/
		int i;	
		for(i = 0; i < temp.length; i++)
		{
			inputMatArr[i] = temp[i];
		}
		/**4*/
		inputMatArr[i] = mat;
		return true;
	}
	
	/**
	 * ��Ḧ �����ϴ� �Լ�
	 * @param mat ������ ���
	 * @return ��� ���� ���� ����
	 */
	public  boolean subtractMat(String mat)
	{
		/**���� ��ᰡ �ƹ��͵� ������ ���� �Ұ�*/
		if(inputMatArr == null ) return false;
		
		/**������ ��ᰡ ��� �ִ��� Ȯ���Ѵ�*/
		for(int i = 0; i < inputMatArr.length; i++)
		{
			
			/**������ ��ᰡ ���� ��*/
			if( mat.equals(inputMatArr[i]) )
			{
				/**���� ��ᰡ �ϳ� ���̸�
				 * ���� ��� �迭�� �������� �η� �����.
				 * */
				if(inputMatArr.length ==1)
				{
					inputMatArr = null;
					return true;
				}
				
				/**��ᰡ �� �̻��̸�
				 * 1. �ӽ� �迭�� ���� ��� �迭�� ����Ѵ�.
				 * 2. ���� ��� �迭 ũ�⸦ �ϳ� ���δ�.
				 * 3. �� ��� ������ ���� ��� �迭�� �����Ѵ�.
				 * 4. �� ��� �������� ���� ��� �迭�� �����Ѵ�. 
				 * 5. ������ ���� ��ȯ
				 * */
				
				/**1*/
				String[] temp = inputMatArr;
				/**2*/
				inputMatArr = new String[inputMatArr.length-1];
				/**3*/
				for( int j = 0; j<i; j++)
				{
					inputMatArr[j] = temp[j];
				}
				/**4*/
				for(int k = i+1; k< temp.length; k++)
				{
					inputMatArr[k-1] = temp[k];
				}
				/**5*/
				return true;
			}
		}
		
		/**���� ��� �߿� �� ��ᰡ ������ ���� ��ȯ*/
		return false;
	}
	
	/**
	 * ��Ḧ �����ϴ� �Լ�.
	 * @param mat ������ ���
	 * @return ��ᰡ �����Ǿ����� ����
	 */
	boolean changeMat( String mat)
	{
		/**�غ��� ��ᰡ �ƹ��͵� ������ ������ �� ����.*/
		if(preparedMatArr == null) return false;
		
		/**�غ��� ��� �߿� ������ ��Ḧ ã�´�.*/
		for(int i = 0; i<preparedMatArr.length ; i++)
			if( preparedMatArr[i].equals(mat) )
			{
				/**������ ��Ḧ "������" ���� �ٲ۴�*/
				preparedMatArr[i] = "������ "+preparedMatArr[i];
				/**��Ḧ ���������� �� ��ȯ*/
				return true;
			}
		
		/**�غ��� ��� �߿� ������ ��ᰡ ������ ���� ��ȯ*/
		return false;		
	}

	/**
	 * �丮�� �������Ѵ�.
	 * @return �丮�� ���� ����.
	 */
	public boolean isSuccess()
	{
		/**��ǥ ��ᰡ ������ �����̴�.*/
		if(goalMatArr == null ) return true;
		/**���� ��ᰡ �ƹ��͵� ������ �翬�� ���д�.*/
		if(inputMatArr == null) return false;		
		/**��ǥ ���� ���� ����� ������ �ٸ��� ���� ��ȯ*/
		if( goalMatArr.length != inputMatArr.length) return false;
		
		/**��ǥ ��ᵵ �ְ� ���� ��ᵵ �ְ� ��� ������ ������
		 * 1. ��ǥ ��Ḧ üũ�� �迭�� �����. ���Ҵ� �� ��ᰡ �ִ��� ����.
		 * 2. �� ��ǥ ��ᰡ ���� ��� �߿� �ִ��� �˻��ؼ� ������ üũ�Ѵ�. ������ ����.
		 * 3. ��ǥ ��� �߿� ���� ���� ��ᰡ ������ ���� ��ȯ.
		 * 4. ��� ��ǥ ��Ḧ �־����� ���� ��ȯ.
		 * */
		
		boolean[] goalMatCheckArr = new boolean[goalMatArr.length];
		for(int i = 0; i< goalMatArr.length; i++)
		{
			goalMatCheckArr[i] = false;
			for(int j = 0; j< inputMatArr.length; j++)
				if( goalMatArr[i].equals(inputMatArr[j]) )
					goalMatCheckArr[i] = true;				
		}
		
		for(int i = 0; i< goalMatCheckArr.length; i++)
			if(goalMatCheckArr[i] == false)
				return false;
		return true;
	}

	
	/**toString: �غ��� ���, ���� ���, ��ǥ ��� �迭, �ϼ� ���θ� �μ�. ������ ����� �μ�.*/
	public String toString()
	{
		String mat = "////////////////////////////\n";
		mat += "�غ��� ��� �迭\n";
		try{
			for(int i = 0; i<preparedMatArr.length; i++)
			{
				mat += preparedMatArr[i];
				mat += "\n";
			}
		}
		catch(NullPointerException e)
		{
			mat += "�����\n";
		}
		
		mat += "****************\n";
		mat += "���� ��� �迭\n";
		try{
			for(int i = 0; i<inputMatArr.length; i++)
			{
				mat += inputMatArr[i];
				mat += "\n";
			}
		}
		catch(NullPointerException e)
		{
			mat += "�����\n";
		}
		
		mat += "****************\n";
		mat += "��ǥ ��� �迭\n";
		try{
			for(int i = 0; i<goalMatArr.length; i++)
			{
				mat += goalMatArr[i];
				mat += "\n";
			}
		}
		catch(NullPointerException e)
		{
			mat += "�����\n";
		}
		
		mat += "*****************\n";
		if(this.isSuccess()) mat += "�ϼ�\n";
		else mat += "�̿ϼ�\n";
		
		return mat;
	}
}
