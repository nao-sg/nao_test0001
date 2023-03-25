import java.util.Random;
import java.util.Scanner;

public abstract class Item{
	
	private int endurance;				//�ϋv�l�@�s�����Ƀu���C�N�̍d�x������
	private final int max_endurance;	//������̒l�@�ϓ����Ȃ�
	private int useCount = 0;					//���s(�ł���)��
	private int temporaryScore = 0;
	private boolean continueFlag = true;		//�Q�[���I���p
	static Random r = new Random();			//�����_���p
	
	Item(int endurance){
		this.endurance = (int)(endurance * fluctuation());
		this.max_endurance = this.endurance;
	}
	
	//�h�炬�@���l��80������100���ŕϓ�
	double fluctuation(){
		return (100.0 - r.nextInt(21)) / 100;
	}
/***************** toString **********************************/

	public String toString(){
		return ", �ő�ϋv�F" + max_endurance + ", ���ϋv�l�F" + endurance + ", �g�����񐔁F" + useCount + ", ���̓���̃X�R�A�F" + temporaryScore;
	}
	
/************* abstract�֘A ***********************************/
	
	abstract boolean message(Target t);
	
	abstract boolean breakMessage();
	
	abstract void wastageMessage();
	
	abstract String getNAME() ;
	
	abstract String addStartMessage();
	
	abstract int getBASE_ENDURANCE();

	abstract void bestItemMessage();


/************ �Q�b�^�[ �� �Z�b�^�[ ****************************/

	public int getUseCount(){
		return useCount;
	}

	public int getTemporaryScore(){
		return temporaryScore;
	}

	public int getResidualEndurance(){
		return endurance  * 100 / max_endurance;
	}
	
	public int getEndurance(){
		return endurance;
	}

	public int getMax_endurance(){
		return max_endurance;
	}
	

/**************************************************************/

	//���ŉ����ǂ������A�ƁA
	//���񃁃b�Z�[�W�@�񐔂̎w�j
	public void startMessage(Target t){
		System.out.println(getNAME() + " �ŁA");
		System.out.println("�@�@�@" + t.getName() + " �� ");
		System.out.println("�@�@�@�@�@" + addStartMessage());
		if(getBASE_ENDURANCE() == max_endurance) bestItemMessage();
		System.out.println("");
		double wastage = (double)t.getSolidity() / max_endurance;
		if(wastage >= 0.5 ) System.out.println("���G�̗\���c�c�I");
		else if(wastage >= 0.34 ) System.out.println("����g���C�ł��邩�ȁH");
		else System.out.println("�ǂ��܂łł��邩�ȁH");
	}
	
	public boolean use(Target t){
		useCount++;
		endurance -= t.getSolidity();
		if(judge()) {
			temporaryScore += (int)(t.getSolidity() * t.getScoreRate() * ratePass(t)) + additionalScore();
			double difficulty = t.getSolidity() / max_endurance;
			if(difficulty > 0.65) temporaryScore += (int)(t.getSolidity() * t.getScoreRate() * 0.25);
			return message(t);
		}else {
			temporaryScore = 0;
			return breakMessage();
		}
	}
	
	public boolean judge(){
		return endurance > 0;
	}
	
	public int additionalScore(){
		int num = useCount / 3;
		return num;
	}
	
	public double ratePass(Target t){
		double rate = ((double)endurance + t.getSolidity()) / max_endurance;
		if(rate < 0.2) System.out.println("���E���U�߂�ō��̃N���C�W�[�g���C�I�Ȃ�Ă���I");
		else if(rate < 0.4) System.out.println("���C�ȃg���C�I�f���炵���I");
		if(rate < 0.2) {
			return 4.5;
		}else if(rate < 0.3){
			return 3.0;
		}else if(rate < 0.35){
			return 2.0;
		}else if(rate < 0.4){
			return 1.5;
		}else {
			return 1.0;
		}
	}
		
	public boolean mainBehavior(Target t, Scanner sc){
		startMessage(t);
		while(true){
			String s = sc.nextLine();//���͑҂�
			if(!s.equals("")) {
				if(useCount == 0) temporaryScore -= 10;
				break;
			}
			continueFlag = use(t);
			if(continueFlag == false) break;
			if((double)endurance / max_endurance < 0.4) wastageMessage();
		}
		return continueFlag;
	}
	
}