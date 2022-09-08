/**
wk07_java04_201415060 클래스는  
0이상 50이하의 수 10개를 입력 받아 입력한 수의 갯수를 출력하기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper 없음
*/

/**수 입력을 위한 스캐너 클래스 생성*/
import java.util.Scanner;
public class wk07_java04_201415060 {

/**
main 함수는
0이상 50이하의 수 10개를 입력 받아 입력한 수의 갯수를 출력합
니다.
@param args: the command line arguments
@return void
*/
	
	public static void main(String[] args)
	{
		/**최대 입력 범위*/
		final int MAXRANGE = 50;
		/**최소 입력 범위*/
		final int MINRANGE = 0;
		/**입력 개수*/
		final int MAXCOUNT = 10;
		/**입력값 저장 배열*/
		int[] array = new int[MAXRANGE+1];
		/**입력 값 저장 변수*/
		int inputnum;
		/**수 입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner(System.in);
		/**입력 개수 만큼 이하 반복*/
		for(int count = 0; count<MAXCOUNT; count++)
		{
			/**0부터 50까지 수 입력 지시*/
			System.out.print(count+1+". Enter the number(0 to 50): ");
			/**정수 입력*/
			inputnum = scan.nextInt();
			/**해당 정수의 배열 원소 1 증가*/
			array[inputnum]++;
		}
		/**최소에서 최대 범위까지 입력 받은 수의 빈도를 출력*/
		for(int count = MINRANGE; count<=MAXRANGE; count++)
		{
			/***/
			if(array[count]>=1) System.out.println(count+" ; "+array[count]);
		}
	}
}
