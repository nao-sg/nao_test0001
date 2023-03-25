import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Mover{

	private int score = 0;
	private int totalCount = 0;
	private int itemCount = 0;
	private ArrayList<String> data = new ArrayList<String>();


	private int itemNumber = 0;
	private boolean gameEndFlag = true;	
	static Scanner sc;
	
/********** �R���X�g���N�^ *****************************/
	
	public Mover(){
	}
	
	
/************ toString **********************************/

	public String toString(){
		return "�������@����̐��F" + itemCount + "�@�@���_�F" + score + "�@�@���s�񐔁F" + totalCount + "�@�@������";
	}

/*********** �Q�b�^�[ �� �Z�b�^�[ ************************/


/*********************************************************/
	
	public String baseMethod(){
		sc = new Scanner(System.in);
		Random r = new Random();
		Item item;
		Target target;
		String word;
		interlude002a(26, '��', 80, '��', 60, false);
		System.out.println("\n");
		while(totalCount < 60 && gameEndFlag == true && score < 1000){
			itemCount++;
			item = getItem(r);//�C���X�^���X�����肷�郁�\�b�h
			target = new Target(item.getNAME(), r);
			gameEndFlag = item.mainBehavior(target, sc);	//���C�������ł̖߂�l�ŃQ�[���I���p�t���O�̕ύX
			totalCount += item.getUseCount();
			score += item.getTemporaryScore();
			setData(dataMake(item,target));		//1�T�C�N���ɂ�������𕶎��񉻂��AarrayList�^�̕ϐ�data�ɉ�����
			System.out.println("\n");
			if(gameEndFlag == true) interlude001(26, '�E', '�{', 30);
			System.out.println("\n");
		}
		return finishedSign();
	}
	
	public void dataPrint(){
		System.out.println(this);
	}
	
	public void keyWait(){
		String s = "null";
		for(int i = 0; i <= 20; i++){
			if(i % 2 == 0)System.out.print("�@�@�@�@�@�@�@�E�\���������͌�G���^�[�ŏI�����\�E\r");
			else System.out.print("�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@\r");
			try{
				Thread.sleep(40);
			}catch(InterruptedException e){
				System.out.println("sleep error" + e);
			}
		}
		System.out.println("");
		while(true){
			s = sc.nextLine();
			if(s.equals("get") || s.equals("result") || s.equals("answer") || s.equals("data") || s.equals("chickenrace")){
				getAllData();
			}
			if( !(s.equals("")) ) break;
		}
		sc.close();
	}
	
	
	
/************** ArrayList�p ***************************/

	public String dataMake(Item item, Target target){
		return itemCount + ".  �A�C�e�� : " + item.getNAME() + "  �c�ϋv" + item.getEndurance() + "/" + item.getMax_endurance() + "\n" +
				"�Ώ� : " + target.getName() + " " + target.getSolidity() + "  �� : " + item.getUseCount() + "  ���_ : " + item.getTemporaryScore() + "\n" +
				"\n�Z - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - �Z\n";
	}
	
	public void setData(String s){
		data.add(s);
	}
	
	public void getAllData(){
		for(String s: data){
			System.out.println(s);
		}
	}
	
/***************************************************************/

	public Item getItem(Random r){
		itemNumber = r.nextInt(5);
		switch(itemNumber){
			case 0:
				return new Knife();
			case 1:
				return new Wood();
			case 2:
				return new ClingFilm();
			case 3:
				return new PlasticBag();
			case 4:
				return new Sofa();
			default:
				System.out.println("�A�C�e���C���X�^���X�I����default�ɓ���܂���");
				return new Knife();
		}
	}
	
	public String finishedSign(){
		if (gameEndFlag == false) return "������Ă��܂���";
		else if(totalCount >= 60) return "����̎g�p�񐔂�60��ɓ��B����";
		else if(score >= 1000) return "���_�� 1000 �𒴂���";
		else return "�z��O�G���[�@�I�����̏������ƃ��\�b�h�܂ł̉ߒ����m�F";
	}



/************** ���o���� ****************************/

	public static void message(){
		System.out.println("");
		System.out.println("���̃Q�[���́\�\�\�\");
		System.out.println("");
		System.out.println("�@�@�����ϋv�M���M���܂Ŏg���c�c");
		System.out.println("");
		System.out.println("�\�\�\�@�`�L�����[�X�I�@�\�\�\");
		System.out.println("");
		System.out.println("�ł��B");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	public static void menu(){
		sc = new Scanner(System.in);
		int num = 99;
		while(num != 0){
			System.out.println("�����j���[��");
			System.out.println("�O�F�Q�[���J�n�@�@�@�P�F�Q�[�������@�@�Q�F�������");
			System.out.println("�R�F�q���g���̂P�@�@�S�F�q���g���̂Q�@�@�T�F���_�Z�o�@�@�U�F���̑�");
			try{
				String numIn = sc.nextLine();
				num = Integer.parseInt(numIn);
				if(num < 0 || num > 6) System.out.println(">>�͈͓��̐�������͂��Ă�������");
			}catch(NumberFormatException e){
				System.out.println(">>�͈͓��̐�������͂��Ă�������");
			}
			if(num == 1){
				System.out.println("*********************************************************************");
				System.out.println("");
				System.out.println("���Q�[��������");
				System.out.println("1.�@������钼�O�܂Ŏg�p���A�ϋv�̂��肬��Ŏ~�߂܂��B");
				System.out.println("2.�@����ȏ㖳�����A�Ƃ����Ƃ���Ŏ��̓���ցB");
				System.out.println("3.�@������J��Ԃ��A����̔j��A�����s��60��A���_1000�_�A");
				System.out.println("�@�@�@�@�@�@�@�@�@�@�@�@�@�����ꂩ�̏����𖞂������i�K�ŏI���ł��B");
				System.out.println("���������Ԃ͂���܂���B�@�������l���Ă�������");
				System.out.println("");
				System.out.println("*********************************************************************");
			}
			if(num == 2){
				System.out.println("*********************************************************************");
				System.out.println("");
				System.out.println("�����������");
				System.out.println("��������ꂸ�G���^�[�L�[�F�ϋv����");
				System.out.println("�@�@�@�@�@�@�@�@�@�@�@�@�@�ʏ�̏����@����̑ϋv������Ă����܂�");
				System.out.println("���������ăG���^�[�L�[�F����̕ύX");
				System.out.println("�@�@�@�@�@�@�@�@�@�@�@�@�@�����╶������͂���Ǝ��̓���ֈڂ�܂�");
				System.out.println("");
				System.out.println("*********************************************************************");
			}
			if(num == 3){
				System.out.println("*********************************************************************");
				System.out.println("");
				System.out.println("���q���g�P��");
				System.out.println("����g�p�̍ŏ��̃��b�Z�[�W�́A���̎g�p�ɑ΂�����l�������Ă��܂��B");
				System.out.println("���G�̗\���c�c�I�@�@�@�@�@�F�ϋv�l�̔����ȏ�����");
				System.out.println("�ǂ��܂Ńg���C�ł��邩�ȁH�F1/3�ȏ�͍����");
				System.out.println("");
				System.out.println("*********************************************************************");
			}
			if(num == 4){
				System.out.println("*********************************************************************");
				System.out.println("");
				System.out.println("���q���g�Q��");
				System.out.println("�ϋv�l��4����؂�Ɠ���Ƃ̏��Ճ��b�Z�[�W���o�܂��B");
				System.out.println("���b�Z�[�W���o��܂ł̎g�p�񐔂���A��܂��Ȍ��E�̌��ɂ߂��ł��܂��B");
				System.out.println("");
				System.out.println("*********************************************************************");
			}
			if(num == 5){
				System.out.println("*********************************************************************");
				System.out.println("");
				System.out.println("�����_�Z�o��");
				System.out.println("���̎g�p�ɂ�������l�������ꍇ�ɂ͓��_�{�[�i�X���t���܂��B");
				System.out.println("�܂��c��ϋv�l��4���ȉ��ł̓���̎g�p�̍ۂɂ����_�{�[�i�X���t���܂��B");
				System.out.println("����Ɏc��ϋv�l���Ⴂ�قǃ{�[�i�X�͏オ��܂��B");
				System.out.println("");
				System.out.println("*********************************************************************");
			}
			if(num == 6){
				System.out.println("*********************************************************************");
				System.out.println("");
				System.out.println("�����̑���");
				System.out.println("���̓���Ɉڂ�ہA���g�p���Ɠ��_�������}�C�i�X����܂��B");
				System.out.println("����́u�K�����͎g����v�Ƃ����킯�ł͂���܂���B");
				System.out.println("����̑ϋv�́u��l�`��l�~0.8�v�̃����_���ł��B");
				System.out.println("�ϋv�l�̍ł������l���m�肵�����̓��b�Z�[�W���o�܂��B");
				System.out.println("�Q�[���I�����O�̓��͎�t�� get �� data �Ȃǂ̕��������邱�Ƃ� >>");
				System.out.println("    >>�Q�[���̏ڍ׌��ʂ�\�����܂��B");
				System.out.println("");
				System.out.println("*********************************************************************");
			}
			System.out.println("");
		}
	}


	public static void interlude001(int num, char a, char b, int time){
		try{
			for(int i  = 0; i <= num; i++){
				Thread.sleep(time);
				if(i % 2 ==0){
					System.out.print(a);
				}else{
					System.out.print(b);
				}
			}
		}catch(InterruptedException e){
			System.out.println("interlude001 �X���[�v�G���[\n" + e);
		}
		System.out.println();
	}

	//num�͏����̒���
	//char��a����U�ōs����}�X�̕������� �P�ԍŏ��ɕ\�������̂͂�����
	//char��b����U�ōs�������}�X�̕������� �P�}�X�ڂ̕\���͂�����
	//boolean��true�Ȃ甼�p�Afalse�Ȃ�S�p�ł�
	// a a a a a a a a
	//babababababababab�̏�
	public static void interlude002a(int num, char a, int timeA, char b, int timeB, boolean zenhankaku){
		try{
			for(int cycle = 0; cycle < 2; cycle++){
				for(int i = 0; i <= num; i++){
					if(i % 2 == 0){
						if(cycle == 0){
							if(zenhankaku)System.out.print(" ");
							else System.out.print("�@");
						}else System.out.print(b);
						if(cycle == 1) Thread.sleep(timeB);
					}else {
						System.out.print(a);
						if(cycle == 0) Thread.sleep(timeA);
					}
				}
				Thread.sleep(200);
				System.out.print("\r");
			}
		}catch(InterruptedException e){
			System.out.println("interlude002a �X���[�v�G���[\n" + e);
		}
		System.out.println("");
	}


}