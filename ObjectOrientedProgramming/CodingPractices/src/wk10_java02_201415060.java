/**
wk10_java02_201415060 Ŭ������  
�������̽��� ����� �����ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper ����
*/

import java.util.Random;

/**Encryptable �������̽��� �Ϻ�ȣȭ ������ ��ü�� �������̽��� ǥ���մϴ�.*/
interface Encryptable
{
   public void encrypt();
   public String decrypt();
}

/**Secret Ŭ������ �Ϻ�ȣȭ ������ ��� �޼����� ǥ���մϴ�.*/
class Secret implements Encryptable
{
	private String message;
	private boolean encrypted;
	private int shift;
	private Random generator;

	/**�����ڷμ� ���� �޼����� �����ϰ� ��ȣȭ ��ȯ ���� ����*/
	public Secret (String msg)
	{
		message = msg;
		encrypted = false;
		generator = new Random();
		shift = generator.nextInt(10) + 5;
	}
	
	/**����� ���� ��ȣ������ ��ȣȭ�ϴ� �޼ҵ�. ��ȣȭ������ ȿ�� ����*/
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

	/**����� ��ȣȭ�ϴ� �޼ҵ�. ��ȣȭ���� �ʾ����� ȿ�� ����*/
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

	/**����� ��ȣȭ ������ �� ��ȯ �޼ҵ�*/
	public boolean isEncrypted()
	{
		return encrypted;
	}
	
	/**��г����� ��ȯ. ��ȣȭ�� ä�ε� ������*/
	public String toString()
	{
		return message;
	}
}


public class wk10_java02_201415060
{
	/**
	main �Լ���
	Secret ��ü�� ����� encrypt�� ������
	�ϴ�.
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
