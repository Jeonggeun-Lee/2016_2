/**
wk11_java01_201415060 클래스는  
예외 전파를 예시하기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper 없음
*/

public class wk11_java01_201415060
{
	/**
	main 함수는
	레벨1 메소드를 시작해서 예외의 예시를 시작합
	니다.
	@param args: the command line arguments
	@return void
	*/
   
   static public void main (String[] args)
   {
      ExceptionScope demo = new ExceptionScope();

      System.out.println("Program beginning.");
      demo.level1();
      System.out.println("Program ending.");
   }
}

/**ExceptionScope.java는 예외 전파를 예시합니다.
 * */
class ExceptionScope
{
	/**레벨3에서 던지는 예외를 잡고 처리합니다.
	 * */
   public void level1()
   {
      System.out.println("Level 1 beginning.");

      try
     {
         level2();
      }
      catch (ArithmeticException problem)
      {
         System.out.println ();
         System.out.println ("The exception message is: " + problem.getMessage());
         System.out.println ();
         System.out.println ("The call stack trace:");
         problem.printStackTrace();
         System.out.println ();
      }

      System.out.println("Level 1 ending.");
}
   /**중간 레벨로 역할을 합니다.
    * 예외가 이 메소드를 통해 레벨1로 전파합니다.
    * */
   public void level2()
   {
      System.out.println("Level 2 beginning.");
      level3 ();
      System.out.println("Level 2 ending.");
   }
   /**예외를 만들기 위한 계산을 수행합니다.
    * 이 레벨에서는 잡히고 처리하지 않습니다.
    * */
   public void level3 ()
   {
      int numerator = 10, denominator = 1;

      System.out.println("Level 3 beginning.");
      int result = numerator / denominator;
      System.out.println("Level 3 ending.");
   }
}