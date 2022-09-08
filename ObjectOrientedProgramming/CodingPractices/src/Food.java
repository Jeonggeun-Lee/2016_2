/**
 * 부모 클래스. 음식
 * 준비, 투입, 목표 재료 배열 속성과
 * 재료 더하기, 빼기, 손질하기, 완성했는지 확인하기 메소드를
 * 멤버로 가진다.
 * @author 이정근
 * @version 1.0
 */

public class Food
{
	/**
	 * 준비되어있는 재료 목록.
	 * 즉 사용 가능한 재료 목록을 의미한다.
	 */
	protected String[] preparedMatArr;
	/**
	 * 추가된 재료 목록.
	 * 손질 등이 끝나고 추가한 재료 목록을 의미한다.
	 */
	protected String[] inputMatArr;
	/**
	 * 목표 재료 목록.
	 * 최종적으로 완성되어야하는 재료들의 상태를 의미한다.
	 * addedMat과 비교해서 성공 여부를 판단한다.
	 */
	protected String[] goalMatArr;
	
	/**
	 * 재료를 추가한다. 단 이미 있는 재료는 무시한다.
	 * @param mat 추가하는 재료
	 * @return 재료 추가의 성공 여부
	 */
	public boolean addMat(String mat)
	{
		/**준비 재료가 없으면 더할 수 없다*/
		if(preparedMatArr == null) return false;
		
		/**넣은 재료가 없으면 원소 한개의 새 배열에 재료를 넣는다*/
		if(inputMatArr == null)
		{
			inputMatArr = new String[1];
			inputMatArr[0] = mat;
			return true;
		}
		
		/**이미 재료를 넣었으면 넣을 수 없다.*/
		for(int i = 0; i<inputMatArr.length; i++)
			if(inputMatArr[i] == mat)
				return false;
		
		/**넣은 재료 중에 넣을 재료가 없으면
		 * 1.임시 배열을 만들어 넣은 재료를 기억하고
		 * 2.넣은 재료의 크기를 1 증가 시킨다.
		 * 3.기억한 배열을 넣은 재료에 다 넣고
		 * 4.새 재료를 마지막 원소로 넣는다.
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
	 * 재료를 제거하는 함수
	 * @param mat 제거할 재료
	 * @return 재료 제거 성공 여부
	 */
	public  boolean subtractMat(String mat)
	{
		/**넣은 재료가 아무것도 없으면 제거 불가*/
		if(inputMatArr == null ) return false;
		
		/**제거할 재료가 어디에 있는지 확인한다*/
		for(int i = 0; i < inputMatArr.length; i++)
		{
			
			/**제거할 재료가 있을 때*/
			if( mat.equals(inputMatArr[i]) )
			{
				/**넣은 재료가 하나 뿐이면
				 * 넣은 재료 배열의 참조값을 널로 만든다.
				 * */
				if(inputMatArr.length ==1)
				{
					inputMatArr = null;
					return true;
				}
				
				/**재료가 둘 이상이면
				 * 1. 임시 배열에 넣은 재료 배열을 기억한다.
				 * 2. 넣은 재료 배열 크기를 하나 줄인다.
				 * 3. 뺄 재료 전까지 넣은 재료 배열에 저장한다.
				 * 4. 뺄 재료 다음부터 넣은 재료 배열에 저장한다. 
				 * 5. 뺐으면 참을 반환
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
		
		/**넣은 재료 중에 뺄 재료가 없으면 거짓 반환*/
		return false;
	}
	
	/**
	 * 재료를 손질하는 함수.
	 * @param mat 손질할 재료
	 * @return 재료가 손질되었는지 여부
	 */
	boolean changeMat( String mat)
	{
		/**준비한 재료가 아무것도 없으면 손질할 수 없다.*/
		if(preparedMatArr == null) return false;
		
		/**준비한 재료 중에 손질할 재료를 찾는다.*/
		for(int i = 0; i<preparedMatArr.length ; i++)
			if( preparedMatArr[i].equals(mat) )
			{
				/**손질할 재료를 "손질한" 재료로 바꾼다*/
				preparedMatArr[i] = "손질한 "+preparedMatArr[i];
				/**재료를 손질했으면 참 반환*/
				return true;
			}
		
		/**준비한 재료 중에 손질할 재료가 없으면 거짓 반환*/
		return false;		
	}

	/**
	 * 요리를 마무리한다.
	 * @return 요리의 성공 여부.
	 */
	public boolean isSuccess()
	{
		/**목표 재료가 없으면 성공이다.*/
		if(goalMatArr == null ) return true;
		/**넣은 재료가 아무것도 없으면 당연히 실패다.*/
		if(inputMatArr == null) return false;		
		/**목표 재료와 넣은 재료의 갯수가 다르면 거짓 반환*/
		if( goalMatArr.length != inputMatArr.length) return false;
		
		/**목표 재료도 있고 넣은 재료도 있고 재료 갯수도 같으면
		 * 1. 목표 재료를 체크할 배열을 만든다. 원소는 각 재료가 있는지 여부.
		 * 2. 각 목표 재료가 넣은 재료 중에 있는지 검사해서 있으면 체크한다. 없으면 거짓.
		 * 3. 목표 재료 중에 넣지 않은 재료가 있으면 실패 반환.
		 * 4. 모든 목표 재료를 넣었으면 성공 반환.
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

	
	/**toString: 준비한 재료, 넣은 재료, 목표 재료 배열, 완성 여부를 인쇄. 없으면 비었음 인쇄.*/
	public String toString()
	{
		String mat = "////////////////////////////\n";
		mat += "준비한 재료 배열\n";
		try{
			for(int i = 0; i<preparedMatArr.length; i++)
			{
				mat += preparedMatArr[i];
				mat += "\n";
			}
		}
		catch(NullPointerException e)
		{
			mat += "비었음\n";
		}
		
		mat += "****************\n";
		mat += "넣은 재료 배열\n";
		try{
			for(int i = 0; i<inputMatArr.length; i++)
			{
				mat += inputMatArr[i];
				mat += "\n";
			}
		}
		catch(NullPointerException e)
		{
			mat += "비었음\n";
		}
		
		mat += "****************\n";
		mat += "목표 재료 배열\n";
		try{
			for(int i = 0; i<goalMatArr.length; i++)
			{
				mat += goalMatArr[i];
				mat += "\n";
			}
		}
		catch(NullPointerException e)
		{
			mat += "비었음\n";
		}
		
		mat += "*****************\n";
		if(this.isSuccess()) mat += "완성\n";
		else mat += "미완성\n";
		
		return mat;
	}
}
