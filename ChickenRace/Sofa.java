public class Sofa extends Item{
	
	private static final String NAME = "ソファー";
	private static final int BASE_ENDURANCE = 90;	//基準耐久値
	
	Sofa(){
		super(BASE_ENDURANCE);
	}
	
/***************** toString **************************************/

	public String toString(){
		return "データ　道具：" + NAME + ", 耐久基準値：" + BASE_ENDURANCE + super.toString();
	}
	
/*************** abstract関連 ****************************************/

	@Override
	public boolean message(Target t){
		System.out.println(NAME + " に " + t.getName() + " を座らせました!!\t <<" + getUseCount() + "回目>>");
		return true;
	}
	
	@Override
	public boolean breakMessage(){
		System.out.println(NAME + " が中央から真っ二つになってしまった…");
		return false;
	}
	
	@Override
	public String getNAME(){
		return NAME;
	}
	
	@Override
	public void wastageMessage(){
		System.out.println("ばねが利かなくなってきてるみたいだ");
	}

	@Override
	public String addStartMessage(){
		return "休ませましょう！";
	}

	@Override
	public int getBASE_ENDURANCE(){
		return BASE_ENDURANCE;
	}
	
	@Override
	public void bestItemMessage(){
		System.out.println("п　ふかふかのソファーだ　п");
	}

/**************************************************************/

}