public class Knife extends Item{
	
	private static final String NAME = "�";
	private static final int BASE_ENDURANCE = 50;	//��ϋv�l
	
	Knife(){
		super(BASE_ENDURANCE);
	}
	
/***************** toString **************************************/

	public String toString(){
		return "�f�[�^�@����F" + NAME + ", �ϋv��l�F" + BASE_ENDURANCE + super.toString();
	}
	
/*************** abstract�֘A ****************************************/

	@Override
	public boolean message(Target t){
		System.out.println(NAME + " �� " + t.getName() + " ��؂���!!\t <<" + getUseCount() + "���>>");
		return true;
	}
	
	@Override
	public boolean breakMessage(){
		System.out.println(NAME + " ���{���{���ɂȂ��Đ؂�Ȃ��Ȃ��Ă��܂����c");
		return false;
	}
	
	@Override
	public String getNAME(){
		return NAME;
	}
	
	@Override
	public void wastageMessage(){
		System.out.println("�n���ڂꂵ�Ă��܂���");
	}

	@Override
	public String addStartMessage(){
		return "�؂�܂��傤�I";
	}

	@Override
	public int getBASE_ENDURANCE(){
		return BASE_ENDURANCE;
	}
	
	@Override
	public void bestItemMessage(){
		System.out.println("���@��͋P���Ă��܂��@��");
	}

/**************************************************************/

}