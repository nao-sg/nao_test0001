import java.util.Random;

public class Target{
	
	private String name;		//�Ώە��̖��O
	private String singular = "";	//�C���M�����[�ȑΏۂ̏ꍇ�@���낭�Ȃ邩�ł��Ȃ邩
	private int solidity;		//�d�x�@�ϋv�����
	private double scoreRate;
	private Random r;
	
	public Target(String name, Random r){
		super();
		this.r = r;
		int singularNum = r.nextInt(10);
		setTarget(name, singularNum);
	}
	
	public void setTarget(String name, int singularNum){
		if(name.equals("�")) knifeTarget(singularNum);
		if(name.equals("�ؐ��o�b�g")) woodTarget(singularNum);
		if(name.equals("�T�������b�v")) clingFilmTarget(singularNum);
		if(name.equals("�r�j�[����")) plasticBagTarget(singularNum);
		if(name.equals("�\�t�@�[")) sofaTarget(singularNum);
	}
	
	public void knifeTarget(int singularNum){	//���ϋv�@50
		int num = r.nextInt(8);
		switch(num){
			case 7:
				name = "�J�c�I��";
				solidity = 44;
				break;
			case 6:
				name = "���ڂ���";
				solidity = 23;
				break;
			case 5:
			case 4:
				name = "�t�����X�p��";
				solidity = 12;
				break;
			case 3:
			case 2:
				name = "�ɂ񂶂�";
				solidity = 8;
				break;
			case 1:
			case 0:
				name = "�L���E��";
				solidity = 4;
				break;
			default:
				System.out.println("default�P�[�X�ɓ���܂���");
				break;
		}
		if(singularNum == 0) {
			singular = "���Ƃ������Ȃ�";
			solidity = (int)(solidity * 0.9);
		}else if(singularNum == 9){
			singular = "������������";
			solidity = (int)(solidity * 1.15);
		}
		scoreRate = 1.4;
	}
	
	public void woodTarget(int singularNum){	//�ؐ��o�b�g��ϋv�@80
		int num = r.nextInt(10);
		switch(num){
			case 9:
				name = "�R���N���[�g�u���b�N";
				solidity = 65;
				break;
			case 8:
				name = "�����K";
				solidity = 55;
				break;
			case 7:
			case 6:
				name = "�y��";
				solidity = 36;
				break;
			case 5:
			case 4:
				name = "��";
				solidity = 18;
				break;
			case 3:
			case 2:
				name = "�K���X";
				solidity = 10;
				break;
			case 1:
			case 0:
				name = "�X";
				solidity = 5;
				break;
			default:
				System.out.println("default�P�[�X�ɓ���܂���");
				break;
		}
		if(singularNum == 0) {
			singular = "������";
			solidity = (int)(solidity * 0.95);
		}else if(singularNum == 9){
			singular = "�ł�����";
			solidity = (int)(solidity * 1.2);
		}
		scoreRate = 1.0;
	}
	
	public void clingFilmTarget(int singularNum){	//�T�������b�v��ϋv�@120
		int num = r.nextInt(8);
		switch(num){
			case 7:
				name = "�܂���";
				solidity = 100;
				break;
			case 6:
				name = "�p�C�i�b�v��";
				solidity = 48;
				break;
			case 5:
			case 4:
				name = "�z�[���P�[�L";
				solidity = 30;
				break;
			case 3:
			case 2:
				name = "�L���x�c";
				solidity = 18;
				break;
			case 1:
			case 0:
				name = "���";
				solidity = 6;
				break;
			default:
				System.out.println("default�P�[�X�ɓ���܂���");
				break;
		}
		if(singularNum <= 0) {
			singular = "�ق�̂菬����";
			solidity = (int)(solidity * 0.8);
		}else if(singularNum >= 7){
			singular = "���炩�Ƀf�J�C";
			solidity = (int)(solidity * 1.15);
		}
		scoreRate = 1.0;
	}

	public void plasticBagTarget(int singularNum){	//�r�j�[���܊�ϋv�@40
		int num = r.nextInt(8);
		switch(num){
			case 7:
				name = "�r��";
				solidity = 26;
				break;
			case 6:
				name = "������";
				solidity = 18;
				break;
			case 5:
			case 4:
				name = "����";
				solidity = 12;
				break;
			case 3:
			case 2:
				name = "������";
				solidity = 9;
				break;
			case 1:
			case 0:
				name = "�G��";
				solidity = 4;
				break;
			default:
				System.out.println("default�P�[�X�ɓ���܂���");
				break;
		}
		if(singularNum <= 0) {
			singular = "�����ڂɔ����Čy��";
			solidity = (int)(solidity * 0.8);
		}else if(singularNum >= 7){
			singular = "�����Ԃ�Əd������";
			solidity = (int)(solidity * 1.5);
		}
		scoreRate = 1.8;
	}


	public void sofaTarget(int singularNum){	//�\�t�@�[�܊�ϋv�@90
		int num = r.nextInt(8);
		switch(num){
			case 7:
				name = "���肸��[";
				solidity = 50;
				break;
			case 6:
				name = "�炢����";
				solidity = 40;
				break;
			case 5:
			case 4:
				name = "�����";
				solidity = 30;
				break;
			case 3:
			case 2:
				name = "�����傤";
				solidity = 18;
				break;
			case 1:
			case 0:
				name = "�͎m";
				solidity = 12;
				break;
			default:
				System.out.println("default�P�[�X�ɓ���܂���");
				break;
		}
		if(singularNum <= 0) {
			singular = "���킢��";
			solidity = (int)(solidity * 0.9);
		}else if(singularNum >= 7){
			singular = "���h��";
			solidity = (int)(solidity * 1.6);
		}
		scoreRate = 1.0;
	}




/*****************************************************************/

	@Override
	public String toString(){
		return "�I�u�W�F�N�g�F" + singular + name + ", �ϋv�x�F" + solidity;
	}
	
	public String getName() {
		return singular + name;
	}
	
	public int getSolidity() {
		return solidity;
	}
	
	public double getScoreRate(){
		return scoreRate;
	}

}