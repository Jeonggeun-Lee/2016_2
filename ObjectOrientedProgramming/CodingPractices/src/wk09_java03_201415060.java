/**
wk09_java03_201415060 클래스는  
상속한 전용 자료를 간접적으로 접근하는 것을 보여 주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper 없음
*/

/**FoodItem 클래스는 음식물을 표현합니다.
 * 간접 참조를 보여주기 위한 파생클래스의 부모로 사용합니다.*/
class FoodItem
{
	final private int CALORIES_PER_GRAM = 9;
	private int fatGrams;
	protected int servings;
   
/**음식물 객체를 생성하고 지방 그램 수와 제공 회수를 정하는 생성자*/
	public FoodItem (int numFatGrams, int numServings)
	{
		fatGrams = numFatGrams;
		servings = numServings;
	}
   
/**음식물의 지방으로 얻는 칼로리를 계산하고 반환하는 메소드*/
	private int calories()
	{
		return fatGrams * CALORIES_PER_GRAM;
	}
   
/**1회 제공량의 지방 칼로리를 계산하고 반환하는 메소드*/
	public int caloriesPerServing()
	{
		return (calories() / servings);
	}
}

/**피자 클래스는 피자를 표현하고 음식물 클래스의 자식입니다.
 * 상속에 의한 간접 참조를 보여 주기 위해 사용합니다.*/
class Pizza extends FoodItem
{
	/**피자 클래스의 생성자. 지방의 양을 정함. 제공 횟수를 정함. 8회라 가정*/
	public Pizza (int fatGrams)
	{
		super (fatGrams, 8);
	}
}

public class wk09_java03_201415060
{
	/**
	main 함수는
	피자 객체를 생성하고 1회 제공량의 칼로리를 인쇄합
	니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main (String[] args)
	{
		Pizza special = new Pizza (275);

		System.out.println ("Calories per serving: " + special.caloriesPerServing());
	}
}
