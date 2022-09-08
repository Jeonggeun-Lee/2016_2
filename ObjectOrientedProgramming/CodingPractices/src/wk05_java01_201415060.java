/**
wk05_java01_201415060 Ŭ������ �ֻ����� 500�� ���� ���ֻ���(1,1)�� ���� Ƚ���� ����ϱ�  ���� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

/**Die Ŭ������ �ֻ����� ����(�ִ�, ���� ��), �ൿ(������, ������, �� ����, �� �˷��ֱ�, �� ���� ���ڿ��� �ٲٱ�)�� ǥ���մϴ�.*/
class Die
{
	/**�ֻ����� �ִ� ���� ��� ����� �ʱ�ȭ*/
   private final int MAX = 6; 	// maximum face value
   /**�ֻ����� ���� �� ���� ���� ����*/
   private int faceValue;  	// current value showing on the die

   /**������.*/
   public Die() 			//  Constructor
   {
	   /**���� 1�� �ʱ�ȭ.*/
	   faceValue = 1;
   }

   /**�ֻ��� ������ ���� �Լ�.�������� ���� �� ���� ��ȯ*/
   public int roll() 		//  Computes a new face value for this die
   {
	   /**�� ������ 1~�ִ� ������ �������� ����*/
      faceValue = (int)(Math.random() * MAX) + 1;
      /**�� ���� ��ȯ*/
      return faceValue;
   }

   /**�� ����  �����Լ�. ��ȯ�� ����. ������ �� ���� �Է�*/
   public void setFaceValue (int value) //  Face value mutator. 
   {
	   /**������ ���� ������ ������*/
      if (value > 0 && value <= MAX)
    	  /**�ֻ��� ���� ������ ���� */
    	  faceValue = value;
   }

   /**�� ���� ��ȯ�ϴ� �����Լ�*/
   public int getFaceValue() 	//  Face value accessor.
   {
	   /**�� ���� ��ȯ*/
      return faceValue;
   }

   /**�� ���� �������� ���ڿ��� �ٲپ� ��ȯ�ϴ� �����Լ�*/
   public String toString() 	//  Returns a string representation of this die.
   {
	   /**������ �� ���� ���ڷ� ��ȯ�Ͽ� ����*/
      String result = Integer.toString(faceValue);
      /**��ȯ�� ���ڿ��� �ٳ�*/
      return result;
   }
}


public class wk05_java01_201415060 {
	/**
	main �Լ��� �ֻ����� 500�� ���� ���ֻ���(1,1)�� ���� Ƚ���� ����մϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main (String[] args)
	   {
		/**������ Ƚ��*/
	      final int ROLLS = 500;
	      /**ù��°, �ι�° �ֻ��� ���� ���ֻ����� ���� Ƚ�� ���� ���� ����*/
	      int num1, num2, count = 0;

	      /**ù��° �ֻ��� ����*/
	      Die die1 = new Die();
	      /**�ι�° �ֻ��� ����*/
	      Die die2 = new Die();

	      /**�ݺ��ڴ� 1���� ������ 1~500 ������ �ְ� 1�� ����*/
	      for (int roll=1; roll <= ROLLS; roll++)
	      {
	    	  /**ù��° �ֻ��� ������*/
	         num1 = die1.roll();
	         /**�ι�° �ֻ��� ������*/
	         num2 = die2.roll();

	         /**ù �ֻ��� ���� 1�̰� �ι�° �ֻ��� ���� 1�̸�*/
	         if (num1 == 1 && num2 == 1)    // check for snake eyes
	        	 /**���� Ƚ���� 1����*/
	        	 count++;
	      }

	      /**���� Ƚ�� ���*/
	      System.out.println ("Number of rolls: " + ROLLS);
	      /**�촫�� ���� Ƚ�� ���*/
	      System.out.println ("Number of snake eyes: " + count);
	      /**�촫�� ���� ���� ���*/
	      System.out.println ("Ratio: " + (float)count / ROLLS);
	   }
}
