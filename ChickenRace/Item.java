import java.util.Random;
import java.util.Scanner;

public abstract class Item{
	
	private int endurance;				//耐久値　行動毎にブレイクの硬度分減る
	private final int max_endurance;	//代入時の値　変動しない
	private int useCount = 0;					//実行(できた)回数
	private int temporaryScore = 0;
	private boolean continueFlag = true;		//ゲーム終了用
	static Random r = new Random();			//ランダム用
	
	Item(int endurance){
		this.endurance = (int)(endurance * fluctuation());
		this.max_endurance = this.endurance;
	}
	
	//揺らぎ　数値を80％から100％で変動
	double fluctuation(){
		return (100.0 - r.nextInt(21)) / 100;
	}
/***************** toString **********************************/

	public String toString(){
		return ", 最大耐久：" + max_endurance + ", 実耐久値：" + endurance + ", 使った回数：" + useCount + ", 今の道具のスコア：" + temporaryScore;
	}
	
/************* abstract関連 ***********************************/
	
	abstract boolean message(Target t);
	
	abstract boolean breakMessage();
	
	abstract void wastageMessage();
	
	abstract String getNAME() ;
	
	abstract String addStartMessage();
	
	abstract int getBASE_ENDURANCE();

	abstract void bestItemMessage();


/************ ゲッター ＆ セッター ****************************/

	public int getUseCount(){
		return useCount;
	}

	public int getTemporaryScore(){
		return temporaryScore;
	}

	public int getResidualEndurance(){
		return endurance  * 100 / max_endurance;
	}
	
	public int getEndurance(){
		return endurance;
	}

	public int getMax_endurance(){
		return max_endurance;
	}
	

/**************************************************************/

	//何で何をどうするよ、と、
	//初回メッセージ　回数の指針
	public void startMessage(Target t){
		System.out.println(getNAME() + " で、");
		System.out.println("　　　" + t.getName() + " を ");
		System.out.println("　　　　　" + addStartMessage());
		if(getBASE_ENDURANCE() == max_endurance) bestItemMessage();
		System.out.println("");
		double wastage = (double)t.getSolidity() / max_endurance;
		if(wastage >= 0.5 ) System.out.println("強敵の予感……！");
		else if(wastage >= 0.34 ) System.out.println("何回トライできるかな？");
		else System.out.println("どこまでできるかな？");
	}
	
	public boolean use(Target t){
		useCount++;
		endurance -= t.getSolidity();
		if(judge()) {
			temporaryScore += (int)(t.getSolidity() * t.getScoreRate() * ratePass(t)) + additionalScore();
			double difficulty = t.getSolidity() / max_endurance;
			if(difficulty > 0.65) temporaryScore += (int)(t.getSolidity() * t.getScoreRate() * 0.25);
			return message(t);
		}else {
			temporaryScore = 0;
			return breakMessage();
		}
	}
	
	public boolean judge(){
		return endurance > 0;
	}
	
	public int additionalScore(){
		int num = useCount / 3;
		return num;
	}
	
	public double ratePass(Target t){
		double rate = ((double)endurance + t.getSolidity()) / max_endurance;
		if(rate < 0.2) System.out.println("限界を攻める最高のクレイジートライ！なんてやつだ！");
		else if(rate < 0.4) System.out.println("強気なトライ！素晴らしい！");
		if(rate < 0.2) {
			return 4.5;
		}else if(rate < 0.3){
			return 3.0;
		}else if(rate < 0.35){
			return 2.0;
		}else if(rate < 0.4){
			return 1.5;
		}else {
			return 1.0;
		}
	}
		
	public boolean mainBehavior(Target t, Scanner sc){
		startMessage(t);
		while(true){
			String s = sc.nextLine();//入力待ち
			if(!s.equals("")) {
				if(useCount == 0) temporaryScore -= 10;
				break;
			}
			continueFlag = use(t);
			if(continueFlag == false) break;
			if((double)endurance / max_endurance < 0.4) wastageMessage();
		}
		return continueFlag;
	}
	
}