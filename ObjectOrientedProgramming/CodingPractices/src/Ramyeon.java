/**
 * 자식 클래스. 라면.
 * @author 이정근
 * @version 1.0
 */
public class Ramyeon extends Food
{
	/**라면 종류 한정*/
	enum Ramen{Cheese, Mandu, Haemul};
	/**라면 종류 저장 변수*/
	private Ramen kind;
	
	/**라면의 생성자. 할 일 없음
	 * @param void*/
	public Ramyeon()
	{
		super();		
	}
	
	/**목표 설정 메소드. 메뉴 주문.
	 * 라면 종류를 정하고 그에 따라 재료를 설정한다.
	 * @param kind 라면 종류
	 * @return void
	 * */
	public void menuOrder(Ramen kind)
	{
		/**이 라면 객체의 종류를 주문한 종류로 저장한다.*/
		this.kind = kind;
		
		/**넣을 재료와 목표 재료를 설정한다.
		 * 라면 종류에 따라 마지막 원소 설정*/
		String ramyeonMatArr[] = { "물", "면", "스프", "파", null };
		String ramyeonGoalMatArr[] = { "끓인 물", "면","스프","손질한 파", null };
				
		switch(kind)
		{
		case Cheese :
			ramyeonMatArr[ramyeonMatArr.length-1] = "치즈";
			ramyeonGoalMatArr[ramyeonGoalMatArr.length-1] = "치즈";
			break;
		case Mandu :
			ramyeonMatArr[ramyeonMatArr.length-1] = "만두";
			ramyeonGoalMatArr[ramyeonGoalMatArr.length-1] = "만두";
			break;
		case Haemul :
			ramyeonMatArr[ramyeonMatArr.length-1] = "해물";
			ramyeonGoalMatArr[ramyeonGoalMatArr.length-1] = "해물";
			break;			
		}
		/**객체의 부모 정보 부분을 메뉴에 맞게 바꾼다.*/
		super.preparedMatArr = ramyeonMatArr;
		super.goalMatArr = ramyeonGoalMatArr;		
	}
	
	/**물을 끓이는 메소드
	 * @param void
	 * @return 물을 넣었고 물만 넣었을 때 참. 아니면 거짓*/
	boolean boil()
	{
		/**넣은 재료가 없으면 못 끓임*/
		if( inputMatArr == null ) return false;
		
		/**넣은 재료가 둘 이상이면 물 말고 다른 재료가 있으므로 실패*/
		if( inputMatArr.length != 1) return false;
		
		/**유일한 재료인 물을 끓여서 "끓인 "물로 바꿈*/
		if( inputMatArr[0].equals("물") )
		{
			inputMatArr[0] = "끓인 "+inputMatArr[0];
			return true;
		}
		
		/**유일한 재료가 물이 아니면 못 끓임*/
		return false;
	}
	
	/**toString 덮어쓰기: 라면의 종류 정보 문자열을 추가*/
	public String toString()
	{
		String kind = "////////////////////////////\n"+"종류 : ";
		if(this.kind == Ramen.Cheese) kind += "치즈라면\n";
		if(this.kind == Ramen.Mandu) kind += "만두라면\n";
		if(this.kind == Ramen.Haemul) kind += "해물라면\n";
		return kind+super.toString();
	}
}