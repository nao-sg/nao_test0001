public class PlasticBag extends Item{
	
	private static final String NAME = "ビニール袋";
	private static final int BASE_ENDURANCE = 40;	//基準耐久値
	
	PlasticBag(){
		super(BASE_ENDURANCE);
	}
	
/***************** toString **************************************/

	public String toString(){
		return "データ　道具：" + NAME + ", 耐久基準値：" + BASE_ENDURANCE + super.toString();
	}
	
/*************** abstract関連 ****************************************/

	@Override
	public boolean message(Target t){
		System.out.println(NAME + " に " + t.getName() + " を入れました!!\t <<" + getUseCount() + "回目>>");
		return true;
	}
	
	@Override
	public boolean breakMessage(){
		System.out.println(NAME + " が破れて使えなくなりました…");
		return false;
	}
	
	@Override
	public String getNAME(){
		return NAME;
	}
	
	@Override
	public void wastageMessage(){
		System.out.println("微妙に重さに耐えきれてない感じ");
	}

	@Override
	public String addStartMessage(){
		return "持ち上げましょう！";
	}

	@Override
	public int getBASE_ENDURANCE(){
		return BASE_ENDURANCE;
	}
	
	@Override
	public void bestItemMessage(){
		System.out.println("∪　かなり丈夫そうだ！　∪");
	}

/**************************************************************/

}