public class ClingFilm extends Item{
	
	private static final String NAME = "�T�������b�v";
	private static final int BASE_ENDURANCE = 120;	//��ϋv�l
	
	ClingFilm(){
		super(BASE_ENDURANCE);
	}
	
/***************** toString **************************************/

	public String toString(){
		return "�f�[�^�@����F" + NAME + ", �ϋv��l�F" + BASE_ENDURANCE + super.toString();
	}
	
/*************** abstract�֘A ****************************************/

	@Override
	public boolean message(Target t){
		System.out.println(NAME + " �� " + t.getName() + " ����!!\t <<" + getUseCount() + "���>>");
		return true;
	}
	
	@Override
	public boolean breakMessage(){
		System.out.println(NAME + " ���؂�Đc�����ɂȂ��Ă��܂����c");
		return false;
	}
	
	@Override
	public String getNAME(){
		return NAME;
	}
	
	@Override
	public void wastageMessage(){
		System.out.println("���݂��Ȃ��Ȃ��Ă���");
	}

	@Override
	public String addStartMessage(){
		return "���b�v���܂��傤�I";
	}

	@Override
	public int getBASE_ENDURANCE(){
		return BASE_ENDURANCE;
	}
	
	@Override
	public void bestItemMessage(){
		System.out.println("���@�S�Ȃ������������������@��");
	}

/**************************************************************/

}