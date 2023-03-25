public class PlasticBag extends Item{
	
	private static final String NAME = "�r�j�[����";
	private static final int BASE_ENDURANCE = 40;	//��ϋv�l
	
	PlasticBag(){
		super(BASE_ENDURANCE);
	}
	
/***************** toString **************************************/

	public String toString(){
		return "�f�[�^�@����F" + NAME + ", �ϋv��l�F" + BASE_ENDURANCE + super.toString();
	}
	
/*************** abstract�֘A ****************************************/

	@Override
	public boolean message(Target t){
		System.out.println(NAME + " �� " + t.getName() + " �����܂���!!\t <<" + getUseCount() + "���>>");
		return true;
	}
	
	@Override
	public boolean breakMessage(){
		System.out.println(NAME + " ���j��Ďg���Ȃ��Ȃ�܂����c");
		return false;
	}
	
	@Override
	public String getNAME(){
		return NAME;
	}
	
	@Override
	public void wastageMessage(){
		System.out.println("�����ɏd���ɑς�����ĂȂ�����");
	}

	@Override
	public String addStartMessage(){
		return "�����グ�܂��傤�I";
	}

	@Override
	public int getBASE_ENDURANCE(){
		return BASE_ENDURANCE;
	}
	
	@Override
	public void bestItemMessage(){
		System.out.println("���@���Ȃ��v�������I�@��");
	}

/**************************************************************/

}