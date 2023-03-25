public class Wood extends Item{
	
	private static final String NAME = "�ؐ��o�b�g";
	private static final int BASE_ENDURANCE = 80;	//��ϋv�l
	
	Wood(){
		super(BASE_ENDURANCE);
	}
	
/***************** toString **************************************/

	public String toString(){
		return "�f�[�^�@����F" + NAME + ", �ϋv��l�F" + BASE_ENDURANCE + super.toString();
	}
	
/*************** abstract�֘A ****************************************/

	@Override
	public boolean message(Target t){
		System.out.println(NAME + " �� " + t.getName() + " ���ӂ���!!\t <<" + getUseCount() + "���>>");
		return true;
	}
	
	@Override
	public boolean breakMessage(){
		System.out.println(NAME + " �������ɐ܂�Ă��܂����c");
		return false;
	}
	
	@Override
	public String getNAME(){
		return NAME;
	}
	
	@Override
	public void wastageMessage(){
		System.out.println("�����t���n�߂܂���");
	}

	@Override
	public String addStartMessage(){
		return "�@���܂��傤�I";
	}

	@Override
	public int getBASE_ENDURANCE(){
		return BASE_ENDURANCE;
	}
	
	@Override
	public void bestItemMessage(){
		System.out.println("���@�������肵��" + getNAME() + "���I�@��");
	}

/**************************************************************/

}