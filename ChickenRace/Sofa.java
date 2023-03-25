public class Sofa extends Item{
	
	private static final String NAME = "�\�t�@�[";
	private static final int BASE_ENDURANCE = 90;	//��ϋv�l
	
	Sofa(){
		super(BASE_ENDURANCE);
	}
	
/***************** toString **************************************/

	public String toString(){
		return "�f�[�^�@����F" + NAME + ", �ϋv��l�F" + BASE_ENDURANCE + super.toString();
	}
	
/*************** abstract�֘A ****************************************/

	@Override
	public boolean message(Target t){
		System.out.println(NAME + " �� " + t.getName() + " �����点�܂���!!\t <<" + getUseCount() + "���>>");
		return true;
	}
	
	@Override
	public boolean breakMessage(){
		System.out.println(NAME + " ����������^����ɂȂ��Ă��܂����c");
		return false;
	}
	
	@Override
	public String getNAME(){
		return NAME;
	}
	
	@Override
	public void wastageMessage(){
		System.out.println("�΂˂������Ȃ��Ȃ��Ă��Ă�݂�����");
	}

	@Override
	public String addStartMessage(){
		return "�x�܂��܂��傤�I";
	}

	@Override
	public int getBASE_ENDURANCE(){
		return BASE_ENDURANCE;
	}
	
	@Override
	public void bestItemMessage(){
		System.out.println("���@�ӂ��ӂ��̃\�t�@�[���@��");
	}

/**************************************************************/

}