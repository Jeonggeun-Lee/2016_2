/**
wk12_java02_201415060 Ŭ������  
���� �ϳ��� ž ������ Ǯ� ��͸� �����ϱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Dec. 2016
@helper ����
*/

public class wk12_java02_201415060
{
	/**
	main �Լ���
	�ϳ��� ž ������ ����� Ǳ
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
	
	public static void main (String[] args)
	{
		TowersOfHanoi towers = new TowersOfHanoi (4);
		towers.solve();
	}
}

/**�ϳ��� ž Ŭ������ ���� �ϳ��� Ÿ�� ������ ǥ���մϴ�.
 * */

class TowersOfHanoi
{
   private int totalDisks;
   /**Ư�� ���� ���� ���� ������ ����*/
   public TowersOfHanoi (int disks)
   {
      totalDisks = disks;
   }
   /**������ Ǯ�� ���� ž�� �ű�� �޼ҵ忡 ���� ȣ���� ����
    * ž 2�� �̿��� ž 1���� ž 3���� ���� �ű�*/
   public void solve ()
   {
      moveTower (totalDisks, 1, 3, 2);
   }
   /**moveTower �޼ҵ�� Ư�� ���� ���� �ϳ��� ž���� �ٸ� ž���� �ű�
    * n-1���� �κ� ���� �� 3�� ������� �ű�� ���� ū �ϳ��� ���� ���� ������� �ű�
    * �ٽ� �� 3�� ��տ� �ű� n-1���� ���� ���� ��տ� �ű�
    * ���� ���� 1���� �Ǹ� ���� ��.*/
   private void moveTower (int numDisks, int start, int end, int temp)
   {
      if (numDisks == 1)
         moveOneDisk (start, end);
      else
      {
         moveTower (numDisks-1, start, temp, end);
         moveOneDisk (start, end);
         moveTower (numDisks-1, temp, end, start);
      }
   }
   /**Ư�� ��� ž���� Ư�� ���� ž���� �ϳ��� ���� �ű�� ���� �˸��� �μ�*/
   private void moveOneDisk (int start, int end)
   {
      System.out.println ("Move one disk from " + start + " to " +
         end);
   }
}