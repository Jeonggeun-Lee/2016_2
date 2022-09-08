/**
wk11_java01_201415060 Ŭ������  
���� ���ĸ� �����ϱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper ����
*/

public class wk11_java01_201415060
{
	/**
	main �Լ���
	����1 �޼ҵ带 �����ؼ� ������ ���ø� ������
	�ϴ�.
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

/**ExceptionScope.java�� ���� ���ĸ� �����մϴ�.
 * */
class ExceptionScope
{
	/**����3���� ������ ���ܸ� ��� ó���մϴ�.
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
   /**�߰� ������ ������ �մϴ�.
    * ���ܰ� �� �޼ҵ带 ���� ����1�� �����մϴ�.
    * */
   public void level2()
   {
      System.out.println("Level 2 beginning.");
      level3 ();
      System.out.println("Level 2 ending.");
   }
   /**���ܸ� ����� ���� ����� �����մϴ�.
    * �� ���������� ������ ó������ �ʽ��ϴ�.
    * */
   public void level3 ()
   {
      int numerator = 10, denominator = 1;

      System.out.println("Level 3 beginning.");
      int result = numerator / denominator;
      System.out.println("Level 3 ending.");
   }
}