import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Mover{

	private int score = 0;
	private int totalCount = 0;
	private int itemCount = 0;
	private ArrayList<String> data = new ArrayList<String>();


	private int itemNumber = 0;
	private boolean gameEndFlag = true;	
	static Scanner sc;
	
/********** コンストラクタ *****************************/
	
	public Mover(){
	}
	
	
/************ toString **********************************/

	public String toString(){
		return "◇◆◇　道具の数：" + itemCount + "　　得点：" + score + "　　試行回数：" + totalCount + "　　◇◆◇";
	}

/*********** ゲッター ＆ セッター ************************/


/*********************************************************/
	
	public String baseMethod(){
		sc = new Scanner(System.in);
		Random r = new Random();
		Item item;
		Target target;
		String word;
		interlude002a(26, '◇', 80, '◆', 60, false);
		System.out.println("\n");
		while(totalCount < 60 && gameEndFlag == true && score < 1000){
			itemCount++;
			item = getItem(r);//インスタンスを決定するメソッド
			target = new Target(item.getNAME(), r);
			gameEndFlag = item.mainBehavior(target, sc);	//メイン処理での戻り値でゲーム終了用フラグの変更
			totalCount += item.getUseCount();
			score += item.getTemporaryScore();
			setData(dataMake(item,target));		//1サイクルにおける情報を文字列化し、arrayList型の変数dataに加える
			System.out.println("\n");
			if(gameEndFlag == true) interlude001(26, '・', '＋', 30);
			System.out.println("\n");
		}
		return finishedSign();
	}
	
	public void dataPrint(){
		System.out.println(this);
	}
	
	public void keyWait(){
		String s = "null";
		for(int i = 0; i <= 20; i++){
			if(i % 2 == 0)System.out.print("　　　　　　　・―＜文字入力後エンターで終了＞―・\r");
			else System.out.print("　　　　　　　　　　　　　　　　　　　　　　　　　\r");
			try{
				Thread.sleep(40);
			}catch(InterruptedException e){
				System.out.println("sleep error" + e);
			}
		}
		System.out.println("");
		while(true){
			s = sc.nextLine();
			if(s.equals("get") || s.equals("result") || s.equals("answer") || s.equals("data") || s.equals("chickenrace")){
				getAllData();
			}
			if( !(s.equals("")) ) break;
		}
		sc.close();
	}
	
	
	
/************** ArrayList用 ***************************/

	public String dataMake(Item item, Target target){
		return itemCount + ".  アイテム : " + item.getNAME() + "  残耐久" + item.getEndurance() + "/" + item.getMax_endurance() + "\n" +
				"対象 : " + target.getName() + " " + target.getSolidity() + "  回数 : " + item.getUseCount() + "  得点 : " + item.getTemporaryScore() + "\n" +
				"\n〇 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 〇\n";
	}
	
	public void setData(String s){
		data.add(s);
	}
	
	public void getAllData(){
		for(String s: data){
			System.out.println(s);
		}
	}
	
/***************************************************************/

	public Item getItem(Random r){
		itemNumber = r.nextInt(5);
		switch(itemNumber){
			case 0:
				return new Knife();
			case 1:
				return new Wood();
			case 2:
				return new ClingFilm();
			case 3:
				return new PlasticBag();
			case 4:
				return new Sofa();
			default:
				System.out.println("アイテムインスタンス選択でdefaultに入りました");
				return new Knife();
		}
	}
	
	public String finishedSign(){
		if (gameEndFlag == false) return "道具が壊れてしまった";
		else if(totalCount >= 60) return "道具の使用回数が60回に到達した";
		else if(score >= 1000) return "得点が 1000 を超えた";
		else return "想定外エラー　終了時の条件式とメソッドまでの過程を確認";
	}



/************** 演出処理 ****************************/

	public static void message(){
		System.out.println("");
		System.out.println("このゲームは――――");
		System.out.println("");
		System.out.println("　　道具を耐久ギリギリまで使う……");
		System.out.println("");
		System.out.println("―――　チキンレース！　―――");
		System.out.println("");
		System.out.println("です。");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	public static void menu(){
		sc = new Scanner(System.in);
		int num = 99;
		while(num != 0){
			System.out.println("＜メニュー＞");
			System.out.println("０：ゲーム開始　　　１：ゲーム説明　　２：操作説明");
			System.out.println("３：ヒントその１　　４：ヒントその２　　５：得点算出　　６：その他");
			try{
				String numIn = sc.nextLine();
				num = Integer.parseInt(numIn);
				if(num < 0 || num > 6) System.out.println(">>範囲内の数字を入力してください");
			}catch(NumberFormatException e){
				System.out.println(">>範囲内の数字を入力してください");
			}
			if(num == 1){
				System.out.println("*********************************************************************");
				System.out.println("");
				System.out.println("＜ゲーム説明＞");
				System.out.println("1.　道具が壊れる直前まで使用し、耐久のぎりぎりで止めます。");
				System.out.println("2.　これ以上無理だ、というところで次の道具へ。");
				System.out.println("3.　これを繰り返し、道具の破壊、総試行回数60回、得点1000点、");
				System.out.println("　　　　　　　　　　　　　いずれかの条件を満たした段階で終了です。");
				System.out.println("※制限時間はありません。　ゆっくり考えてください");
				System.out.println("");
				System.out.println("*********************************************************************");
			}
			if(num == 2){
				System.out.println("*********************************************************************");
				System.out.println("");
				System.out.println("＜操作説明＞");
				System.out.println("文字を入れずエンターキー：耐久処理");
				System.out.println("　　　　　　　　　　　　　通常の処理　道具の耐久を削っていきます");
				System.out.println("文字を入れてエンターキー：道具の変更");
				System.out.println("　　　　　　　　　　　　　数字や文字を入力すると次の道具へ移ります");
				System.out.println("");
				System.out.println("*********************************************************************");
			}
			if(num == 3){
				System.out.println("*********************************************************************");
				System.out.println("");
				System.out.println("＜ヒント１＞");
				System.out.println("道具使用の最初のメッセージは、一回の使用に対する削り値を示しています。");
				System.out.println("強敵の予感……！　　　　　：耐久値の半分以上削られる");
				System.out.println("どこまでトライできるかな？：1/3以上は削られる");
				System.out.println("");
				System.out.println("*********************************************************************");
			}
			if(num == 4){
				System.out.println("*********************************************************************");
				System.out.println("");
				System.out.println("＜ヒント２＞");
				System.out.println("耐久値が4割を切ると道具ごとの消耗メッセージが出ます。");
				System.out.println("メッセージが出るまでの使用回数から、大まかな限界の見極めができます。");
				System.out.println("");
				System.out.println("*********************************************************************");
			}
			if(num == 5){
				System.out.println("*********************************************************************");
				System.out.println("");
				System.out.println("＜得点算出＞");
				System.out.println("一回の使用における削り値が高い場合には得点ボーナスが付きます。");
				System.out.println("また残り耐久値が4割以下での道具の使用の際にも得点ボーナスが付きます。");
				System.out.println("さらに残り耐久値が低いほどボーナスは上がります。");
				System.out.println("");
				System.out.println("*********************************************************************");
			}
			if(num == 6){
				System.out.println("*********************************************************************");
				System.out.println("");
				System.out.println("＜その他＞");
				System.out.println("次の道具に移る際、未使用だと得点が少しマイナスされます。");
				System.out.println("道具は「必ず一回は使える」というわけではありません。");
				System.out.println("道具の耐久は「基準値～基準値×0.8」のランダムです。");
				System.out.println("耐久値の最も高い値が確定した時はメッセージが出ます。");
				System.out.println("ゲーム終了直前の入力受付で get や data などの文字を入れることで >>");
				System.out.println("    >>ゲームの詳細結果を表示します。");
				System.out.println("");
				System.out.println("*********************************************************************");
			}
			System.out.println("");
		}
	}


	public static void interlude001(int num, char a, char b, int time){
		try{
			for(int i  = 0; i <= num; i++){
				Thread.sleep(time);
				if(i % 2 ==0){
					System.out.print(a);
				}else{
					System.out.print(b);
				}
			}
		}catch(InterruptedException e){
			System.out.println("interlude001 スリープエラー\n" + e);
		}
		System.out.println();
	}

	//numは処理の長さ
	//charのaが先攻で行う奇数マスの文字処理 １番最初に表示されるのはこちら
	//charのbが後攻で行う偶数マスの文字処理 １マス目の表示はこちら
	//booleanがtrueなら半角、falseなら全角です
	// a a a a a a a a
	//bababababababababの順
	public static void interlude002a(int num, char a, int timeA, char b, int timeB, boolean zenhankaku){
		try{
			for(int cycle = 0; cycle < 2; cycle++){
				for(int i = 0; i <= num; i++){
					if(i % 2 == 0){
						if(cycle == 0){
							if(zenhankaku)System.out.print(" ");
							else System.out.print("　");
						}else System.out.print(b);
						if(cycle == 1) Thread.sleep(timeB);
					}else {
						System.out.print(a);
						if(cycle == 0) Thread.sleep(timeA);
					}
				}
				Thread.sleep(200);
				System.out.print("\r");
			}
		}catch(InterruptedException e){
			System.out.println("interlude002a スリープエラー\n" + e);
		}
		System.out.println("");
	}


}