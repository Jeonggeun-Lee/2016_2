/**
 * 요리하는 클래스의 자식. 라면 클래스.
 * GUI는 해당되지 않음.
 * @author 이정근
 * @version 1.0
 */
public class Ramyeon extends Cooking
{
	/**라면 클래스의 생성자. 부모 생성자의 인수를 그대로 인수로 갖는다.*/
	public Ramyeon(int limit, Ingredient[] preparedMaterials, Ingredient[] goalMaterials)
	{
		super(limit, preparedMaterials, goalMaterials);
	}
	
	public String trimIngredient(Ingredient mat)
	{
		if(mat.getState() != "normal")	//아직 다듬어지지 않은 재료만 변경한다.
			return mat.getState();
		
		switch(mat.getName())
		{
		//재료를 손질한 후에는 return true로 빠져나갈 것. (성공했음을 알리기 위함)
		case "파":
			mat.setState("썰음");
			return "썰음";
		}
		
		//switch문에 해당하는 재료가 없었던 경우,
		return "normal";	//손질하는 재료가 아니었으므로 normal을 그대로 반환.
	}
	/**라면 클래스의 개별 메소드. 물끓이기.
	 * 물만 재료로 추가했을 때, 물의 상태를 끓음으로 바꾼다.
	 * 목표 재료의 물은 끓음 상태여야 한다.
	 * 끓이기에 성공하면 참을 반환.
	 * */
	public boolean boil()
	{
		/**
		 * 1.이 클래스의 부모 부분에서 첨가한 재료의 배열의 참조 값을 받아 온다. 
		 * 2.첨가 재료 배열의 끝을 저장할 변수를 선언한다.
		 * 3.바로 다음 참조가 널을 참조하면 그 때의 반복자를 배열의 끝으로 한다. 반복은 멈춘다.  
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
		
		/**첨가 재료 배열이 널이거나
		 * 배열의 끝이 1이 아니거나(즉, 물 이외에 다른 첨가 재료가 있거나)
		 * 유일한 원소가 물이 아니거나
		 * 물이 더라도 상태가 기본(즉, 끓지 않음)이 아니면
		 * 거짓을 반환
		 * */
		if(temp == null
				||  tempTail != 1
				|| !super.getAddedMaterials()[tempTail-1].getName().equals("물")
				|| !super.getAddedMaterials()[tempTail-1].getState().equals("normal")) return false;
		/**첨가 재료가 유일하게 물이라면 물의 상태를 끌음으로 만든다. 반환값은 참.*/
		super.getAddedMaterials()[0].setState("끓음");
		return true;
	}
}