/**
wk07_java01_201415060 Ŭ������  
�迭�� ���ڿ� ������ ���踦 �����ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper ����
*/
/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;

public class wk07_java01_201415060
{
	/**
	main �Լ���
	����ڿ��Լ� ������ �Է¹ް� �� ���� ��ҹ��� ������ ���� ��
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
	
   public static void main (String[] args)
   {
	   /**���ĺ��� ����*/
      final int NUMCHARS = 26;
      
      
      Scanner scan = new Scanner (System.in);
      
      /**��ҹ��� ���� ������ �迭 ����*/
      int[] upper = new int[NUMCHARS];
      int[] lower = new int[NUMCHARS];
      
      /**ó���ϴ� ���� ����*/
      char current;
      /**���ĺ��� �ƴ� ������ ����*/
      int other = 0;
      
      /**���� �Է� ����*/
      System.out.print ("Enter a sentence: ");
      /**���� �Է�*/
      String line = scan.nextLine();

      /**��Ÿ���� �� ������ ���� ��*/
      for (int ch = 0; ch < line.length(); ch++)
      {
    	  /**���忡�� ���� �ϳ��� ����*/
         current = line.charAt(ch);
         /**���� ���ڰ� �빮���̸�*/
         if (current >= 'A' && current <= 'Z')
        	 /**�� ���ڿ� �ش��ϴ� �迭 ������ ���� 1����*/
        	 upper[current-'A']++;
         else
        	 /**���� ���ڰ� �ҹ����̸�*/
            if (current >= 'a' && current <= 'z')
            	/**�� ���ڿ� �ش��ϴ� �迭 ������ ���� 1����*/
            	lower[current-'a']++;
         /**���� ���ڰ� ��ҹ��ڰ� �ƴϸ�*/
            else
            	 /**�� �� ������ ���� 1����*/
               other++;
      }
      
      /**����� ���*/
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
