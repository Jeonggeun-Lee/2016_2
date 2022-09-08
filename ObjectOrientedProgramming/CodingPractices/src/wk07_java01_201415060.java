/**
wk07_java01_201415060 클래스는  
배열과 문자열 사이의 관계를 보여주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper 없음
*/
/**입력을 위한 스캐너 클래스 도입*/
import java.util.Scanner;

public class wk07_java01_201415060
{
	/**
	main 함수는
	사용자에게서 문장을 입력받고 그 안의 대소문자 각각의 수를 셉
	니다.
	@param args: the command line arguments
	@return void
	*/
	
   public static void main (String[] args)
   {
	   /**알파벳의 갯수*/
      final int NUMCHARS = 26;
      
      
      Scanner scan = new Scanner (System.in);
      
      /**대소문자 수를 저장할 배열 생성*/
      int[] upper = new int[NUMCHARS];
      int[] lower = new int[NUMCHARS];
      
      /**처리하는 현재 문자*/
      char current;
      /**알파벳이 아닌 문자의 갯수*/
      int other = 0;
      
      /**문장 입력 지시*/
      System.out.print ("Enter a sentence: ");
      /**문장 입력*/
      String line = scan.nextLine();

      /**나타나는 각 문자의 수를 셈*/
      for (int ch = 0; ch < line.length(); ch++)
      {
    	  /**문장에서 문자 하나를 저장*/
         current = line.charAt(ch);
         /**저장 문자가 대문자이면*/
         if (current >= 'A' && current <= 'Z')
        	 /**그 문자에 해당하는 배열 원소의 값을 1증가*/
        	 upper[current-'A']++;
         else
        	 /**저장 문자가 소문자이면*/
            if (current >= 'a' && current <= 'z')
            	/**그 문자에 해당하는 배열 원소의 값을 1증가*/
            	lower[current-'a']++;
         /**저장 문자가 대소문자가 아니면*/
            else
            	 /**그 외 문자의 변수 1증가*/
               other++;
      }
      
      /**결과를 출력*/
      for (int letter=0; letter < upper.length; letter++)
      {
         System.out.print ((char) (letter + 'A'));
         System.out.print (" = " + upper[letter]);
         System.out.print ("\t\t" + (char) (letter + 'a'));
         System.out.println (" = " + lower[letter]);
      }

      System.out.println ("Non-alphabetic characters = " + other);
   }
}
