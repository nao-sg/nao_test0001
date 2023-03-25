public class Wood extends Item{
	
	private static final String NAME = "木製バット";
	private static final int BASE_ENDURANCE = 80;	//基準耐久値
	
	Wood(){
		super(BASE_ENDURANCE);
	}
	
/***************** toString **************************************/

	public String toString(){
		return "データ　道具：" + NAME + ", 耐久基準値：" + BASE_ENDURANCE + super.toString();
	}
	
/*************** abstract関連 ****************************************/

	@Override
	public boolean message(Target t){
		System.out.println(NAME + " で " + t.getName() + " を砕いた!!\t <<" + getUseCount() + "回目>>");
		return true;
	}
	
	@Override
	public boolean breakMessage(){
		System.out.println(NAME + " が見事に折れてしまった…");
		return false;
	}
	
	@Override
	public String getNAME(){
		return NAME;
	}
	
	@Override
	public void wastageMessage(){
		System.out.println("傷が付き始めました");
	}

	@Override
	public String addStartMessage(){
		return "叩きましょう！";
	}

	@Override
	public int getBASE_ENDURANCE(){
		return BASE_ENDURANCE;
	}
	
	@Override
	public void bestItemMessage(){
		System.out.println("■　しっかりした" + getNAME() + "だ！　■");
	}

/**************************************************************/

}