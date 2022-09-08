/**
wk10_java02_201415060 클래스는  
인터페이스의 사용을 보여주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper 없음
*/

import java.util.Random;

/**Encryptable 인터페이스는 암복호화 가능한 객체의 인터페이스를 표현합니다.*/
interface Encryptable
{
   public void encrypt();
   public String decrypt();
}

/**Secret 클래스는 암복호화 가능한 비밀 메세지를 표현합니다.*/
class Secret implements Encryptable
{
	private String message;
	private boolean encrypted;
	private int shift;
	private Random generator;

	/**생성자로서 원래 메세지를 저장하고 암호화 변환 값을 설정*/
	public Secret (String msg)
	{
		message = msg;
		encrypted = false;
		generator = new Random();
		shift = generator.nextInt(10) + 5;
	}
	
	/**비밀을 시저 암호법으로 암호화하는 메소드. 암호화했으면 효과 없음*/
	public void encrypt ()
	{
		if (!encrypted)
		{
			String masked = "";
			for (int index=0; index < message.length(); index++)
				masked = masked + (char)(message.charAt(index)+shift);
			message = masked;
			encrypted = true;
		}
	}

	/**비밀을 복호화하는 메소드. 암호화하지 않았으면 효과 없음*/
	public String decrypt()
	{
		if (encrypted)
		{
			String unmasked = "";
			for (int index=0; index < message.length(); index++)
				unmasked = unmasked + (char)(message.charAt(index)-shift);
			message = unmasked;
			encrypted = false;
		}

		return message;
	}

	/**비밀을 암호화 했으면 참 반환 메소드*/
	public boolean isEncrypted()
	{
		return encrypted;
	}
	
	/**비밀내용을 반환. 암호화한 채로도 보여줌*/
	public String toString()
	{
		return message;
	}
}


public class wk10_java02_201415060
{
	/**
	main 함수는
	Secret 객체를 만들고 encrypt를 실험합
	니다.
	@param args: the command line arguments
	@return void
	*/
	
   public static void main (String[] args)
   {
      Secret hush = new Secret ("Wil Wheaton is my hero!");
      System.out.println (hush);

      hush.encrypt();
      System.out.println (hush);

      hush.decrypt();
      System.out.println (hush);
   }
}
