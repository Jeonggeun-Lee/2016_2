import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * 라면 프로그램.
 * GUI 등을 담당한다.
 * @author 최중기, 이정근
 * @version 1.0
 */
public class RamyeonProgram extends JPanel
{

	/**
	 * 이미지들의 종류를 설정.
	 * 준비된 재료들은 항상 가장 앞에 배치시켜야함.
	 * @author 최중기, 이정근
	 */

	protected enum E_IMAGE_SORT
	{
		E_1_SOUP,
		E_2_WELSHONION,
		E_3_CHEESE,
		E_4_NOODLE,
		E_5_WATER,
		E_UNWRAPPED_SOUP,
		E_CUT_WELSHONION,
		E_BOILED_WATER,
		E_PLATE,	//재료를 올려두는 접시.
		E_TRIM_PLATE,	//재료를 손질하는 접시.
		E_GARBAGE_BOX,
		E_MAX
	}

	/**
	 * int 값을 E_IMAGE_SORT로 바꾸는 함수.
	 * E_IMAGE_SORT가 갱신되면 같이 갱신되어야함.
	 * @param num	바꾸는 int 값.
	 * @return	바뀐 E_IMAGE_SORT 값.
	 */

	public static E_IMAGE_SORT intToEIS(int num)
	{
		switch(num)
		{
		case 0:
			return E_IMAGE_SORT.E_1_SOUP;
		case 1:
			return E_IMAGE_SORT.E_2_WELSHONION;
		case 2:
			return E_IMAGE_SORT.E_3_CHEESE;
		case 3:
			return E_IMAGE_SORT.E_4_NOODLE;
		case 4:
			return E_IMAGE_SORT.E_5_WATER;
		case 5:
			return E_IMAGE_SORT.E_UNWRAPPED_SOUP;
		case 6:
			return E_IMAGE_SORT.E_CUT_WELSHONION;
		case 7:
			return E_IMAGE_SORT.E_BOILED_WATER;
		case 8:
			return E_IMAGE_SORT.E_PLATE;
		case 9:
			return E_IMAGE_SORT.E_TRIM_PLATE;
		case 10:
			return E_IMAGE_SORT.E_GARBAGE_BOX;
		default:
			return E_IMAGE_SORT.E_MAX;
		}
	}
	
	/**
	 * 재료를 표현하는 JLabel (그림만 사용한다)
	 * @author 최중기, 이정근
	 * @version 1.0
	 */
	protected class IngredLabel extends JLabel
	{
		private Ingredient ingred;	//이 객체가 의미하는 재료.
		
		private E_IMAGE_SORT eImage;	//이 객체의 이미지.
		
		/**
		 * 재료 정보와 이미지로 객체 생성
		 * @param mat	이 객체가 의미하는 재료
		 * @param img	이 객체의 이미지
		 * @param eSort	이 객체의 이미지 - enum 값.
		 */
		public IngredLabel(Ingredient mat, ImageIcon img, E_IMAGE_SORT eSort)
		{
			super(img);
			ingred = mat;
			eImage = eSort;
		}
		
		public Ingredient getIngredient() { return ingred; }	//자신이 무슨 재료를 의미하는지 알려준다.
		public E_IMAGE_SORT getImageSort()	{ return eImage; }	//무슨 이미지를 가지고 있는지 반환한다.
		
		/**
		 * 이미지를 다른 걸로 교체한다.
		 * @param eis	교체하는 이미지의 열거형
		 * @param img	교체하는 이미지 아이콘.
		 */
		public void changeImage(E_IMAGE_SORT eis, ImageIcon img)
		{
			eImage = eis;
			this.setIcon(img);
		}
	}
	
	private Ramyeon cook;	//라면 프로그램 클래스
	
	private IngredLabel[] matImages;	//재료 이미지들.
	private IngredLabel[] addedImages;	//추가된 재료 이미지들.
	private IngredLabel dragImage;	//드래그하고있는 재료 이미지.
	private IngredLabel trimImage;	//손질한 재료의 이미지.
	private JLabel plateImage;	//접시 이미지.
	private JLabel trimPlateImage;	//손질하는 접시 이미지 (올려두면 손질되는 접시)
	
	/**
	 * 쓰레기통 이미지 참조
	 * @author 이정근
	 * */
	private JLabel garbageBoxImage;
	
	Image[] imgs = new Image[E_IMAGE_SORT.E_MAX.ordinal()];	//프로그램 내에서 사용하는 이미지들.
	
	private JButton completeBtn;	//완성했음을 확인하는 버튼.
	
	/**끓이는 버튼의 참조
	 * @author 이정근
	 * */
	private JButton boilBtn;
	

	/**
	 * 이미지들을 불러온다.
	 * 경로 등의 설정은 오버라이딩으로 처리할 것.
	 */
	protected void loadImages()
	{
		try 
		{
			//이미지들을 읽어온다.
			imgs[E_IMAGE_SORT.E_1_SOUP.ordinal()] = ImageIO.read(new File("soup.png"));
			imgs[E_IMAGE_SORT.E_2_WELSHONION.ordinal()] = ImageIO.read(new File("welshonion.png"));
			imgs[E_IMAGE_SORT.E_3_CHEESE.ordinal()] = ImageIO.read(new File("cheese.png"));
			imgs[E_IMAGE_SORT.E_4_NOODLE.ordinal()] = ImageIO.read(new File("noodle.png"));
			imgs[E_IMAGE_SORT.E_5_WATER.ordinal()] = ImageIO.read(new File("water.png"));
			imgs[E_IMAGE_SORT.E_UNWRAPPED_SOUP.ordinal()] = ImageIO.read(new File("unwrappedsoup.png"));
			imgs[E_IMAGE_SORT.E_CUT_WELSHONION.ordinal()] = ImageIO.read(new File("cutwelshonion.png"));
			imgs[E_IMAGE_SORT.E_BOILED_WATER.ordinal()] = ImageIO.read(new File("boiledwater.png"));
			imgs[E_IMAGE_SORT.E_PLATE.ordinal()] = ImageIO.read(new File("range.png"));
			imgs[E_IMAGE_SORT.E_TRIM_PLATE.ordinal()] = ImageIO.read(new File("doma.png"));
			imgs[E_IMAGE_SORT.E_GARBAGE_BOX.ordinal()] = ImageIO.read(new File("garbageBox.png"));
		} 
		catch (IOException e) //파일 입력에 오류가 발생하는 경우.
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * GUI를 첫 설정하는 RamyeonProgram의 생성자.
	 */
	public RamyeonProgram()
	{
		setPanel();
	}
	
	/**
	 * 패널의 컴포넌트나 패널 자체등을 설정.
	 * 변경시 오버라이딩 할 것.
	 */
	protected void setPanel()
	{
		//	>>	패널의 기본 설정	>>	//
		GUIMouseListener gl = new GUIMouseListener();
		this.addMouseListener(gl);	//마우스 리스너를 패널에 추가한다.
		this.addMouseMotionListener(gl);
		
		//패널의 특징을 설정한다.
		this.setLayout(null);
		this.setBackground (Color.cyan);	//패널 배경은 시안으로 설정.
		this.setPreferredSize (new Dimension(1024, 768));	//1024 X 768의 크기로 설정.
		//	<<	패널의 기본 설정	<<	//

		//	>>	요리 프로그램의 내부 설정	>>	//
		//준비되어있는 요리 재료들을 설정.
		Ingredient[] prepared = {new Ingredient("스프"), new Ingredient("파"), new Ingredient("치즈"),new Ingredient("면"),new Ingredient("물")};
		//완성된 요리에 들어갈 재료 목록을 설정.
		Ingredient[] goal = {new Ingredient("스프","가루"), new Ingredient("파","썰음"), new Ingredient("치즈"),new Ingredient("면"),new Ingredient("물","끓음")};
		//요리 프로그램 내부를 생성한다. 준비 재료는 다른 변수 두가지 보다 항상 길이가 길거나 같으므로 해당 길이를 기준으로 길이 전달.
		cook = new Ramyeon(prepared.length, prepared, goal);
		//	<<	요리 프로그램의 내부 설정	<<	//
		
		//	>>	이미지 설정	>>	//
		
		loadImages();
		
		//>>재료 이미지들 설정>>//
		matImages = new IngredLabel[prepared.length];	//컴포넌트 인식을 위해서 Label을 사용한다.
		addedImages = new IngredLabel[prepared.length];	//추가된 재료 이미지는 배열만큼만 할당한다.
		for (int n=0; n<matImages.length; n++)
		{
			//준비된 재료 순서는 gui와 프로그램이 서로 동일.
			matImages[n] = new IngredLabel(prepared[n], new ImageIcon(imgs[n]), intToEIS(n));	
			matImages[n].setSize(matImages[n].getPreferredSize());
			this.add(matImages[n]);	//재료 이미지를 패널에 추가.
		}
		//<<재료 이미지들 설정<<//
		
		//>>접시 이미지 설정>>//
		//재료 올려두는 접시 이미지 설정
		plateImage = new JLabel(new ImageIcon(imgs[E_IMAGE_SORT.E_PLATE.ordinal()]));	//바로 이미지를 부여.
		plateImage.setSize(plateImage.getPreferredSize());
		this.add(plateImage);	//접시 이미지를 패널에 추가.
		//손질용 접시 이미지 설정
		trimPlateImage = new JLabel(new ImageIcon(imgs[E_IMAGE_SORT.E_TRIM_PLATE.ordinal()]));
		trimPlateImage.setSize(trimPlateImage.getPreferredSize());
		this.add(trimPlateImage);
		//접시들은 가장 뒤에 배치.
		this.setComponentZOrder(plateImage, this.getComponentCount() - 2);
		this.setComponentZOrder(trimPlateImage, this.getComponentCount() -1);
		//<<접시 이미지 설정<<//
		
		/**쓰레기통 이미지 설정
		 * @author 이정근
		 * */
		//>>쓰레기통 이미지 설정>>//
		garbageBoxImage = new JLabel(new ImageIcon(imgs[E_IMAGE_SORT.E_GARBAGE_BOX.ordinal()]));	//바로 이미지를 부여.
		garbageBoxImage.setSize(garbageBoxImage.getPreferredSize());
		this.add(garbageBoxImage);	//접시 이미지를 패널에 추가.
		//<<쓰레기통 이미지 설정<<//
		
		//	<<	이미지 설정	<<	//
		
		//버튼 추가.
		completeBtn = new JButton("Complete");
		completeBtn.setSize(100, 50);
		completeBtn.addActionListener(new ButtonListener());
		this.add(completeBtn);
		
		/**끓이기 버튼 추가*/
		/**
		 * @author 이정근
		 * */
		boilBtn = new JButton("Boil");
		boilBtn.setSize(100, 50);
		boilBtn.addActionListener(new ButtonListener());
		this.add(boilBtn);
	}
	
	/**
	 * 컴포넌트들의 기본 위치를 설정하는 함수.
	 */
	protected void setDefaultLocation()
	{
		//재료 이미지들의 위치선정.
		for(int n=0; n<matImages.length; n++)
			matImages[n].setLocation(n * 150, this.getSize().height - (matImages[n].getSize().height));
		//접시 이미지의 위치 선정.
		plateImage.setLocation((this.getSize().width / 2) - (plateImage.getSize().width),	//가운데에서 왼쪽으로 설정.
				(this.getSize().height / 2) - (plateImage.getSize().height / 2)-85);	//세로는 가운데로 설정.
		//손질용 접시 이미지의 위치 선정.
		trimPlateImage.setLocation((this.getSize().width / 2) + (50),	//가운데에서 오른쪽에 배치
				(this.getSize().height / 2) - (trimPlateImage.getSize().height / 2));	//세로는 가운데에 배치.
		
		//쓰레기통 이미지의 위치 선정.
		garbageBoxImage.setLocation((this.getSize().width ) - (garbageBoxImage.getSize().width + 100), 100);	//오른쪽 끝 -200.위끝+100
		
		//버튼의 위치 선정.
		completeBtn.setLocation((this.getSize().width / 2) - (completeBtn.getSize().width / 2),	//가운데에 배치
				100);	//위에서 100
		
		/**
		 * 끓이기 버튼의 위치 선정.
		 * @author 이정근
		 * */
		boilBtn.setLocation( (this.getSize().width / 2) - (boilBtn.getSize().width / 2) - 200,	//가로:가운데에서 - 200에 배치
				100 );//세로: 가운데보다 조금 아래 배치
		bSet = true;
	}
	
	/**
	 * 재료를 추가한다.
	 * 프로그램 내에도 추가하며, gui로도 추가해서 접시에 올려둔다.
	 * @param ingred	추가하는 재료
	 * @return	추가 성공 여부.
	 */
	public boolean addIngredient(IngredLabel ingred)
	{
		int index = cook.addIngredient(ingred.getIngredient());	//재료를 추가한다.
		
		if(index >= 0)	//재료 추가에 성공한 경우,
		{
			/**재료가 스프인 경우 가루가 물에 퍼진 모양으로 변한다
			 * @author 이정근
			 * */
			if( ingred.getImageSort() == E_IMAGE_SORT.E_1_SOUP )
			{
				ingred.changeImage(E_IMAGE_SORT.E_UNWRAPPED_SOUP,
						new ImageIcon(imgs[E_IMAGE_SORT.E_UNWRAPPED_SOUP.ordinal()]) );
				ingred.getIngredient().setState("가루");
				ingred.setSize(getPreferredSize());
			}
			
			addedImages[index] = ingred;	//해당하는 번호에 재료를 추가해둔다. (그대로 옮겨둔다)
			Point pos = plateImage.getLocation();
            
			/**
			 * 접시의 가운데에 모든 재료를 놓는다
			 * @author 이정근
			 */
			pos.x += plateImage.getWidth()/2-ingred.getWidth()/2;
			pos.y += plateImage.getHeight()/2-ingred.getHeight()/2;
			addedImages[index].setLocation(pos);	//위치를 변경시킨다.
			
				
			return true;
		}
		
		//실패한 경우.
		return false;
	}
	/**
	 * 재료를 제외한다.
	 * 프로그램 내에서도 제외하며, gui에서도 제외한다.
	 * @param ingred	제외하는 재료
	 * @return	제외 성공 여부.
	 */
	public boolean removeIngredient(IngredLabel ingred)
	{
		boolean check = false;	//해당 재료가 들어있는지 판별한다.
		for(IngredLabel lab : addedImages)
			if(lab == ingred)	//재료가 들어있는 게 확인되면
				check = true;	//통과.
		
		if( check == false)	//재료가 없다면
			return false;	//재료 빼기 실패.
		//라면 클래스 객체에서 재료를 제거
		int index = cook.removeIngredient(ingred.getIngredient());
		//우선 해당 이미지를 삭제시킨다.
		this.remove(addedImages[index]);
		this.repaint();
		addedImages[index] = null;
		//뒤에 있는 재료들을 모두 한 칸씩 땡긴다. (혼란을 막기 위함)
		int k;
		for(k = index; k < addedImages.length - 1; k++)
		{
			addedImages[k] = addedImages[k+1];	//바로 뒤의 재료를 앞의 칸으로 땡겨온다.	
			if(addedImages[k] != null)	//null이 아닌 실제 재료를 땡겨온 경우
			{
				//재료의 위치를 땡긴다.
				Point pos = addedImages[k].getLocation();
				pos.x -= 100;	//X값을 100 땡긴다.
				addedImages[k].setLocation(pos);	//재료의 위치 변환 확정.
			}
			if( addedImages[k+1] == null)	//다음 위치가 비어있는 경우는 굳이 더 옮길 필요 없음.
				break;
			//위 if문이 뒤에 위치한 이유는 마지막 값은 null로 채워둘 필요가 있기 때문이다.
		}
		//이정근: 다음 조건문은 불필요하다는 생각
		if( k == addedImages.length)	//만약 마지막 값까지 땡겨온 경우,
			addedImages[k] = null;	//마지막 값은 앞으로 땡겨왔으므로 마지막 위치는 삭제시킨다.
		
		return true;	//성공적으로 제거
	}
	/**
	 * 재료를 손질한다.
	 * @param ingred	손질하는 재료
	 * @return	손질 성공 여부.
	 */
	public boolean trimIngredient(IngredLabel ingred)
	{
		if(trimImage != null)	//이미 손질한 재료가 올려져있으면,
			return false;	//손질 불가능.
		
		cook.removeIngredient(ingred.getIngredient());	//손질하기위해 올려놓으면 추가된 재료 목록에서는 제외한다.
		String stat = cook.trimIngredient(ingred.getIngredient());
		
		ingred.getIngredient().setState(stat);	//해당 상태로 변경한다.
		trimImage = ingred;	//손질하는 이미지로 설정.
		switch(trimImage.getImageSort())
		{
		/**
		 * 파 이미지를 썬 파로 변환.
		 * @author 이정근
		 */
		case E_2_WELSHONION:
			trimImage.changeImage(E_IMAGE_SORT.E_CUT_WELSHONION, 
					new ImageIcon(imgs[E_IMAGE_SORT.E_CUT_WELSHONION.ordinal()]));
			break;
		default:
			//주로 이미 손질한 경우, 혹은 손질한 재료와 해당하는 이미지가 없을 경우, case가 없을 경우에 발생.
			System.out.println("It isn't trimmed");
			break;
		}
		trimImage.setSize(trimImage.getPreferredSize());	//사이즈 변경
		//위치 설정 -> 손질 접시 위에 위치한다.
		trimImage.setLocation(trimPlateImage.getLocation().x + (trimPlateImage.getWidth() / 2) - (trimImage.getSize().width / 2),
				trimPlateImage.getLocation().y + (trimPlateImage.getHeight() / 2) - (trimImage.getSize().height / 2));
		return true;
	}

	
	/**
	 * 완료 버튼을 위한 버튼 리스너
	 * 물 끓이기 버튼 리스너
	 * 그 외의 버튼들도 사용은 가능하도록 해두었다.
	 * @author 최중기, 이정근
	 *
	 */
	protected class ButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			if( event.getSource() == completeBtn)
			{
				if(cook.succeedCook())	//요리가 성공한 경우.
				{
					JOptionPane.showMessageDialog(null, "요리에 성공하셨습니다!");
				}
				else	//요리가 실패한 경우.
				{
					JOptionPane.showMessageDialog(null, "요리에 실패하셨습니다.");
				}
				
				
			}
			
			/**끓이기 버튼을 눌렀을 때의 작동
			 * @author 이정근
			 * */
			if( event.getSource() == boilBtn)
			{
				if(cook.boil() == true)//물을 끓인 경우
				{
					for(IngredLabel i: addedImages)
					{
						if( i.getImageSort().equals(E_IMAGE_SORT.E_5_WATER) )
						{
							i.changeImage(E_IMAGE_SORT.E_BOILED_WATER, new ImageIcon( imgs[E_IMAGE_SORT.E_BOILED_WATER.ordinal()] ) );
							i.getIngredient().setState("끓음");
							i.setSize(getPreferredSize());
							Point pos = plateImage.getLocation();
							
							/**
							 * 가스레인지의 가운데에 끓는 물을 놓는다
							 */
							pos.x += plateImage.getWidth()/2-i.getWidth()/2;
							pos.y += plateImage.getHeight()/2-i.getHeight()/2;
							i.setLocation(pos);
							break;
						}
					}
					JOptionPane.showMessageDialog(null, "물이 끓습니다. 다른 재료를 넣으세요.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "지금 물을 끓이면 안 됩니다. 실패!");
				}
			}
		}
	}
	
	public static boolean bSet = false;	//처음 위치 선정을 했는지 여부.
	
	/**
	 * 프로그램에서 마우스를 입력받고 처리하기 위한 리스너 클래스.
	 * @author 최중기
	 * @version 1.5
	 */
	protected class GUIMouseListener extends MouseMotionAdapter implements MouseListener
	{
		private Point offset;	//드래그할 때 사용. 드래그 시작시 누른 위치를 의미한다.
		private Point startPos;	//드래그할 때, 컴포넌트의 처음 위치를 저장한다.
		private RamyeonProgram cpanel = null;
		
		public void mousePressed(MouseEvent event)
		{
			JLabel label;
			try	//누른 이미지를 찾을 때 발생할 예외를 대비한 처리.
			{
				label = (JLabel) cpanel.getComponentAt(event.getPoint());	//누른 이미지를 찾는다.
				if( label == null)	//누른 이미지가 없는 경우.
					return;
			}
			catch(ClassCastException e)	//주로 컴포넌트가 아닌 배경이 눌러졌을 때 패널이 컴포넌트로 반환되며 발생.
			{	return;	}	//그냥 함수를 강제종료한다.
			
			for(int n=0; n<matImages.length; n++)
			{
				if(matImages[n] == label)	//만약 재료 이미지를 누른 경우. (주로 재료를 추가/손질하는 용도에 사용된다)
				{
					//원 이미지와 별개로 드래그할 이미지를 만든다.
					dragImage = new IngredLabel(matImages[n].getIngredient(), new ImageIcon(imgs[n]), cpanel.intToEIS(n));
					dragImage.setBounds(matImages[n].getBounds());
					cpanel.add(dragImage);
					cpanel.setComponentZOrder(dragImage, 0);	//이미지를 가장 앞쪽에 놓는다.
					startPos = new Point(-100, -100);	//이 경우는 새로 생성한 것이므로 시작위치가 없다.
				}
				
				if(addedImages[n] != null)	//추가된 재료가 있는 경우.
					if(addedImages[n] == label)	//추가된 재료를 누른 거라면,
					{
						dragImage = addedImages[n];	//별개가 아니라 그 이미지를 그대로 옮긴다.
						startPos = dragImage.getLocation();	//드래그 시작위치 저장.
					}
			}
			
			if(trimImage != null && trimImage == label)	//손질한 이미지라면,
			{
				dragImage = trimImage;	//마찬가지로 그 이미지를 그대로 이동시킨다.
				trimImage = null;	//손질한 이미지로서는 빠진다.
				startPos = dragImage.getLocation();	//드래그 시작 위치 저장.
			}
			
			offset = event.getPoint();	//드래그를 위한 offset 설정.
		}
		
		/**
		 * contains 함수가 잘 안돼서 직접 만든 함수
		 * @param bounds	포함하는 지 확인하는 범위
		 * @param pos		포함되는 지 확인하는 위치.
		 * @return bounds 범위 내에 pos가 들어가는 지 여부.
		 */
		public boolean checkContain(Rectangle bounds, Point pos)
		{
			if(pos.x >= bounds.x && pos.x <= (bounds.x + bounds.width) &&	//왼쪽 모서리와 오른쪽 모서리 사이인지 확인.
					pos.y >= bounds.y && pos.y <= (bounds.y + bounds.height))	//위쪽 모서리와 아래쪽 모서리 사이인지 확인.
				return true;
			else
				return false;
		}
		
		public void mouseReleased(MouseEvent event)
		{
			if( dragImage != null )	//드래그하는 재료가 있는 경우,
			{
				if(checkContain(plateImage.getBounds(), event.getPoint()))	//드래그하는 재료가 접시 위에 올라왔는지 확인.
				{
					if(addIngredient(dragImage) == false)	//재료 추가를 해보고 실패한 경우,
					{
						if( startPos.x >= 0 )	//되돌아갈 위치가 있는 경우,
							dragImage.setLocation(startPos);	//처음 위치로 돌려보낸다.
						else	//돌아갈 위치가 없는 경우.
						{
							//드래그 하던 이미지를 삭제.
							cpanel.remove(dragImage);
							cpanel.repaint();
						}
					}
				}
				else if(checkContain(trimPlateImage.getBounds(), event.getPoint()))	//재료가 손질 접시 위에 올라왔는지 확인.
				{
					if(trimIngredient(dragImage) == false)	//이미 손질된 재료가 있었거나 하는 등의 이유로 손질에 실패한 경우.
					{
						if( startPos.x >= 0 )	//되돌아갈 위치가 있는 경우,
							dragImage.setLocation(startPos);	//처음 위치로 돌려보낸다.
						else	//돌아갈 위치가 없는 경우.
						{
							//드래그 하던 이미지를 삭제.
							cpanel.remove(dragImage);
							cpanel.repaint();
						}
					}
				}
				else	//아무데도 올라가지 않은 경우.
				{
					//드래그하던 것이 추가된 재료였다면 삭제한다.
					//아니라면 false가 반환될 뿐일 것이니 문제는 없음.
					if(cpanel.removeIngredient(dragImage) == false)	//재료가 삭제되지 않은 경우,
					{
						//드래그 하던 이미지를 직접 삭제.
						cpanel.remove(dragImage);
						cpanel.repaint();
					}
				}
				dragImage = null;
			}
			
		}
		
		public void mouseClicked(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		
		public void mouseDragged(MouseEvent event)
		{
			if(dragImage != null)	//이미지를 드래그하는 도중인 경우.
			{
				int mx = event.getPoint().x - offset.x;	//X축으로 이동한 거리
				int my = event.getPoint().y - offset.y;	//Y축으로 이동한 거리
				offset = event.getPoint();	//사용한 다음에는 오프셋 초기화.
				Point loc = dragImage.getLocation();
				loc.x += mx;	loc.y += my;	//위치를 드래그한만큼 이동시킴.
				dragImage.setLocation(loc);
			}
		}
		
		public void mouseMoved(MouseEvent event)	//적어도 현재에는 편법 용도로만 사용중.
		{
			if(cpanel == null)
				cpanel = ((RamyeonProgram)plateImage.getParent());
			//일종의 편법으로 컴포넌트들의 첫 기본 위치를 설정한다.
			if(!bSet)
			{
				cpanel.setDefaultLocation();
			}
		}
	}

	/**
	 * 프레임을 만들고 패널을 붙이고 보여주는 메인 메소드
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Ramyeon Program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RamyeonProgram panel = new RamyeonProgram();
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}

}
