public class Knife extends Item{
	
	private static final String NAME = "包丁";
	private static final int BASE_ENDURANCE = 50;	//基準耐久値
	
	Knife(){
		super(BASE_ENDURANCE);
	}
	
/***************** toString **************************************/

	public String toString(){
		return "データ　道具：" + NAME + ", 耐久基準値：" + BASE_ENDURANCE + super.toString();
	}
	
/*************** abstract関連 ****************************************/

	@Override
	public boolean message(Target t){
		System.out.println(NAME + " で " + t.getName() + " を切った!!\t <<" + getUseCount() + "回目>>");
		return true;
	}
	
	@Override
	public boolean breakMessage(){
		System.out.println(NAME + " がボロボロになって切れなくなってしまった…");
		return false;
	}
	
	@Override
	public String getNAME(){
		return NAME;
	}
	
	@Override
	public void wastageMessage(){
		System.out.println("刃こぼれしてきました");
	}

	@Override
	public String addStartMessage(){
		return "切りましょう！";
	}

	@Override
	public int getBASE_ENDURANCE(){
		return BASE_ENDURANCE;
	}
	
	@Override
	public void bestItemMessage(){
		System.out.println("☆　包丁は輝いています　☆");
	}

/**************************************************************/

}