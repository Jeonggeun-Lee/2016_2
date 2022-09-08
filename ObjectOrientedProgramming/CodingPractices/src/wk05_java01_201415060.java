/**
wk05_java01_201415060 클래스는 주사위를 500번 던져 뱀주사위(1,1)가 나온 횟수를 출력하기  위한 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**Die 클래스는 주사위의 상태(최댓값, 나온 눈), 행동(생성자, 굴리기, 눈 설정, 눈 알려주기, 눈 값을 문자열로 바꾸기)을 표현합니다.*/
class Die
{
	/**주사위의 최댓값 내부 상수 선언과 초기화*/
   private final int MAX = 6; 	// maximum face value
   /**주사위의 나온 면 내부 변수 선언*/
   private int faceValue;  	// current value showing on the die

   /**생성자.*/
   public Die() 			//  Constructor
   {
	   /**눈을 1로 초기화.*/
	   faceValue = 1;
   }

   /**주사위 굴리기 공용 함수.무작위로 나온 눈 정수 반환*/
   public int roll() 		//  Computes a new face value for this die
   {
	   /**눈 변수에 1~최댓값 범위의 무작위수 저장*/
      faceValue = (int)(Math.random() * MAX) + 1;
      /**눈 값을 반환*/
      return faceValue;
   }

   /**눈 설정  공용함수. 반환값 없음. 설정할 눈 정수 입력*/
   public void setFaceValue (int value) //  Face value mutator. 
   {
	   /**설정할 값이 범위에 있으면*/
      if (value > 0 && value <= MAX)
    	  /**주사위 눈에 설정값 저장 */
    	  faceValue = value;
   }

   /**눈 값을 반환하는 공용함수*/
   public int getFaceValue() 	//  Face value accessor.
   {
	   /**눈 값을 반환*/
      return faceValue;
   }

   /**눈 값을 정수에서 문자열로 바꾸어 반환하는 공용함수*/
   public String toString() 	//  Returns a string representation of this die.
   {
	   /**정수인 눈 값을 문자로 변환하여 저장*/
      String result = Integer.toString(faceValue);
      /**번환한 문자열을 바놘*/
      return result;
   }
}


public class wk05_java01_201415060 {
	/**
	main 함수는 주사위를 500번 던져 뱀주사위(1,1)가 나온 횟수를 출력합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main (String[] args)
	   {
		/**굴리는 횟수*/
	      final int ROLLS = 500;
	      /**첫번째, 두번째 주사위 눈과 뱀주사위가 나온 횟수 저장 변수 선언*/
	      int num1, num2, count = 0;

	      /**첫번째 주사위 생성*/
	      Die die1 = new Die();
	      /**두번째 주사위 생성*/
	      Die die2 = new Die();

	      /**반복자는 1부터 시작해 1~500 범위에 있고 1씩 증가*/
	      for (int roll=1; roll <= ROLLS; roll++)
	      {
	    	  /**첫번째 주사위 던지기*/
	         num1 = die1.roll();
	         /**두번째 주사위 던지기*/
	         num2 = die2.roll();

	         /**첫 주사위 눈이 1이고 두번째 주사위 눈이 1이면*/
	         if (num1 == 1 && num2 == 1)    // check for snake eyes
	        	 /**나온 횟수를 1증가*/
	        	 count++;
	      }

	      /**던진 횟수 출력*/
	      System.out.println ("Number of rolls: " + ROLLS);
	      /**뱀눈이 나온 횟수 출력*/
	      System.out.println ("Number of snake eyes: " + count);
	      /**뱀눈이 나온 비율 출력*/
	      System.out.println ("Ratio: " + (float)count / ROLLS);
	   }
}
