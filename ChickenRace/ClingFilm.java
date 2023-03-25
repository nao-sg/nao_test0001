public class ClingFilm extends Item{
	
	private static final String NAME = "サランラップ";
	private static final int BASE_ENDURANCE = 120;	//基準耐久値
	
	ClingFilm(){
		super(BASE_ENDURANCE);
	}
	
/***************** toString **************************************/

	public String toString(){
		return "データ　道具：" + NAME + ", 耐久基準値：" + BASE_ENDURANCE + super.toString();
	}
	
/*************** abstract関連 ****************************************/

	@Override
	public boolean message(Target t){
		System.out.println(NAME + " で " + t.getName() + " を包んだ!!\t <<" + getUseCount() + "回目>>");
		return true;
	}
	
	@Override
	public boolean breakMessage(){
		System.out.println(NAME + " が切れて芯だけになってしまった…");
		return false;
	}
	
	@Override
	public String getNAME(){
		return NAME;
	}
	
	@Override
	public void wastageMessage(){
		System.out.println("厚みがなくなってきた");
	}

	@Override
	public String addStartMessage(){
		return "ラップしましょう！";
	}

	@Override
	public int getBASE_ENDURANCE(){
		return BASE_ENDURANCE;
	}
	
	@Override
	public void bestItemMessage(){
		System.out.println("＠　心なしか少し巻きが厚い　＠");
	}

/**************************************************************/

}