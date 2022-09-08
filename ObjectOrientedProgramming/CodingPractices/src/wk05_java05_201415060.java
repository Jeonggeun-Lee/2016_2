/**
Coin Ŭ������ 
������ ǥ��
�մϴ�.
������ �Ӽ��� �յ޸��̰�
���� ������, �ո����� �˻��ϱ�, ������ �Ӽ��� ���ڿ��� ��ȯ�ϴ� �޼ҵ带 �����ϴ�.

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper Lewis/Loftus
*/

class Coin
{
	/**���� ���� ���� �� �ޱ�*/
   private enum State{ HEADS, TAILS };
   /**���� ���� ���� ����*/
   State face;
   
   /**���� ������*/
   public Coin ()
   {
	   /**���� ���¸� �ʱ�ȭ*/
      flip();
   }
   
   /**���� ������ ���� �޼ҵ�*/
   public void flip ()
   {
	   /**������ �޼ҵ�� 0 �Ǵ� 1 ���� �޾Ƽ� 0�̸� ���� ���°� �ո�*/
	   if( (int) (Math.random() * 2) == 0) face = State.HEADS;
	   /**1�̸� �޸�*/
	   else face = State.TAILS;
   }

   /**���� ���°� �ո����� �Ǵ��ϴ� ���� �޼ҵ�. ������ ��ȯ*/
   public boolean isHeads ()
   {
	   /**���� ��ä�� ���̸� ��, �ڸ� ���� ��ȯ*/
      return (face == State.HEADS);
   }

   /**���� ���¸� ���ڿ��� ��ȯ�ϴ� ���� �޼ҵ�*/
   public String toString()
   {
	   /**���� ���� ���ڿ� ���� ���� ����*/
      String faceName;
      
      /**���� ���°� ���̸�*/
      if (face == State.HEADS)
    	  /**"�ո�" ���ڿ� ��ȯ*/
    	  faceName = "Heads";
      /**�ڸ�*/
      else
    	  /**"�޸�" ���ڿ� ��ȯ*/
    	  faceName = "Tails";
      
      /**���ڿ��� ���� ��ȯ*/
      return faceName;
   }
}

/**
wk05_java05_201415060 Ŭ������
���� �����⸦ 1000�� �ؼ� �յ޸��� ���� Ƚ���� ����ϱ�
���� Ŭ�����Դϴ�.

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper Lewis/Loftus
*/

public class wk05_java05_201415060
{
	/**
	main �Լ���
	���� �����⸦ 1000�� �ؼ� �յڸ��� ���� Ƚ���� ���
	�մϴ�.
	@param args: the command line arguments
	@return void
	*/

   public static void main (String[] args)
   {
	   /**���� ������ Ƚ�� ��� ���� ����� �ʱ�ȭ*/
      final int NUM_FLIPS = 1000;
      /**�ո�� �޸��� ���� Ƚ���� ������ ���� ����� �ʱ�ȭ*/
      int heads = 0, tails = 0;

      
      /**���� ��ü ����*/
      Coin myCoin = new Coin();

      /**���� ���� ȸ�� �ݺ��ڰ� 1���� ������ ������ Ƚ�� ���� 1�� ���� �ϴ� ����*/
      for (int count=1; count <= NUM_FLIPS; count++)
      {
    	  /**���� ������ �޼ҵ� ȣ��*/
    	  myCoin.flip();

    	  /**�ո��� ������*/
    	  if (myCoin.isHeads()) 
    		  /**�ո� ���� Ƚ�� 1 ����*/
    		  heads++;
    	  /**�޸��� ������*/
    	  else
    		  /**�޸� ���� Ƚ�� 1 ����*/
    		  tails++;
      }
      
      /**���� ���� Ƚ�� ���*/
      System.out.println ("Number of flips: " + NUM_FLIPS);
      /**�ո� ���� Ƚ�� ���*/
      System.out.println ("Number of heads: " + heads);
      /**�޸� ���� Ƚ�� ���*/
      System.out.println ("Number of tails: " + tails);
   }
}