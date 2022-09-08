/**
wk11_java03_201415060 클래스는  
입출력 예외와 문자 파일 출력 흐름을 사용하는 것을 보여주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper 없음
*/
import java.util.Random;
import java.io.*;

public class wk11_java03_201415060
{
	/**
	main 함수는
	열 줄로 구성한 테스트 자료의 파일을 만들며
	각 줄은 10에서 99까지 범위의 정수값을 가집
	니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main (String[] args) throws IOException
	{
		/**행과 열의 최대 성분 개수*/
		final int MAX = 10;
		/**무작위로 받고 인쇄할 값을 저장하는 변수*/
		int value;
		/**인쇄할 파일 생성*/
		String file = "test.txt";

		/**무작위수를 생성할 랜덤 객체 생성*/
		Random rand = new Random();

		/**파일쓰기 객체 생성*/
		FileWriter fw = new FileWriter (file);
		/**버퍼클래스 객체 생성*/
		BufferedWriter bw = new BufferedWriter (fw);
		/**print, println 같은 유용한 메소드를 가진 인쇄 클래스 객체 생성*/
		PrintWriter outFile = new PrintWriter (bw);

		/**10개의 행을 이동하는 반복문*/
		for (int line=1; line <= MAX; line++)
		{
			/**10개의 열을 이동하는 반복문*/
			for (int num=1; num <= MAX; num++)
			{
				/**10에서 99까지 무작위수 받음*/
				value = rand.nextInt (90) + 10;
				/**값을 파일에 인쇄*/
				outFile.print (value + "   ");
			}
			/**행 구분 인쇄*/
			outFile.println ();
		}
		/**출력 파일 닫음*/
		outFile.close();
		/**출력 파일 생성 완료 표시*/
		System.out.println ("Output file has been created - " + file);
	}
}
