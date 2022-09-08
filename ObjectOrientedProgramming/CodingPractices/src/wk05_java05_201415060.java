/**
Coin 클래스는 
동전을 표현
합니다.
동전의 속성은 앞뒷면이고
동전 던지기, 앞면인지 검사하기, 동전의 속성을 문자열로 반환하는 메소드를 갖습니다.

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper Lewis/Loftus
*/

class Coin
{
	/**동전 상태 전용 수 메김*/
   private enum State{ HEADS, TAILS };
   /**동전 상태 전용 변수*/
   State face;
   
   /**동전 생성자*/
   public Coin ()
   {
	   /**동전 상태를 초기화*/
      flip();
   }
   
   /**동전 던지기 공용 메소드*/
   public void flip ()
   {
	   /**무작위 메소드로 0 또는 1 값을 받아서 0이면 동전 상태가 앞면*/
	   if( (int) (Math.random() * 2) == 0) face = State.HEADS;
	   /**1이면 뒷면*/
	   else face = State.TAILS;
   }

   /**동전 상태가 앞면인지 판단하는 공용 메소드. 참거짓 반환*/
   public boolean isHeads ()
   {
	   /**동전 상채가 앞이면 참, 뒤면 거짓 반환*/
      return (face == State.HEADS);
   }

   /**동전 상태를 문자열로 반환하는 공용 메소드*/
   public String toString()
   {
	   /**동전 상태 문자열 참조 변수 선언*/
      String faceName;
      
      /**동전 상태가 앞이면*/
      if (face == State.HEADS)
    	  /**"앞면" 문자열 반환*/
    	  faceName = "Heads";
      /**뒤면*/
      else
    	  /**"뒷면" 문자열 반환*/
    	  faceName = "Tails";
      
      /**문자열의 참조 반환*/
      return faceName;
   }
}

/**
wk05_java05_201415060 클래스는
동전 던지기를 1000번 해서 앞뒷면이 나온 횟수를 출력하기
위한 클래스입니다.

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper Lewis/Loftus
*/

public class wk05_java05_201415060
{
	/**
	main 함수는
	동전 던지기를 1000번 해서 앞뒤면이 나온 횟수를 출력
	합니다.
	@param args: the command line arguments
	@return void
	*/

   public static void main (String[] args)
   {
	   /**동전 던지기 횟수 상수 정수 선언과 초기화*/
      final int NUM_FLIPS = 1000;
      /**앞면과 뒷면이 나온 횟수를 저장할 변수 선언과 초기화*/
      int heads = 0, tails = 0;

      
      /**동전 객체 생성*/
      Coin myCoin = new Coin();

      /**동전 던진 회수 반복자가 1에서 정해진 던지기 횟수 까지 1씩 증가 하는 동안*/
      for (int count=1; count <= NUM_FLIPS; count++)
      {
    	  /**동전 던지는 메소드 호출*/
    	  myCoin.flip();

    	  /**앞면이 나오면*/
    	  if (myCoin.isHeads()) 
    		  /**앞면 나온 횟수 1 증가*/
    		  heads++;
    	  /**뒷면이 나오면*/
    	  else
    		  /**뒷면 나온 횟수 1 증가*/
    		  tails++;
      }
      
      /**동전 던진 횟수 출력*/
      System.out.println ("Number of flips: " + NUM_FLIPS);
      /**앞면 나온 횟수 출력*/
      System.out.println ("Number of heads: " + heads);
      /**뒷면 나온 횟수 출력*/
      System.out.println ("Number of tails: " + tails);
   }
}