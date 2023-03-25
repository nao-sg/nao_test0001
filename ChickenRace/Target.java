import java.util.Random;

public class Target{
	
	private String name;		//対象物の名前
	private String singular = "";	//イレギュラーな対象の場合　もろくなるか固くなるか
	private int solidity;		//硬度　耐久を削る
	private double scoreRate;
	private Random r;
	
	public Target(String name, Random r){
		super();
		this.r = r;
		int singularNum = r.nextInt(10);
		setTarget(name, singularNum);
	}
	
	public void setTarget(String name, int singularNum){
		if(name.equals("包丁")) knifeTarget(singularNum);
		if(name.equals("木製バット")) woodTarget(singularNum);
		if(name.equals("サランラップ")) clingFilmTarget(singularNum);
		if(name.equals("ビニール袋")) plasticBagTarget(singularNum);
		if(name.equals("ソファー")) sofaTarget(singularNum);
	}
	
	public void knifeTarget(int singularNum){	//包丁基準耐久　50
		int num = r.nextInt(8);
		switch(num){
			case 7:
				name = "カツオ節";
				solidity = 44;
				break;
			case 6:
				name = "かぼちゃ";
				solidity = 23;
				break;
			case 5:
			case 4:
				name = "フランスパン";
				solidity = 12;
				break;
			case 3:
			case 2:
				name = "にんじん";
				solidity = 8;
				break;
			case 1:
			case 0:
				name = "キュウリ";
				solidity = 4;
				break;
			default:
				System.out.println("defaultケースに入りました");
				break;
		}
		if(singularNum == 0) {
			singular = "何とも言えない";
			solidity = (int)(solidity * 0.9);
		}else if(singularNum == 9){
			singular = "おいしそうな";
			solidity = (int)(solidity * 1.15);
		}
		scoreRate = 1.4;
	}
	
	public void woodTarget(int singularNum){	//木製バット基準耐久　80
		int num = r.nextInt(10);
		switch(num){
			case 9:
				name = "コンクリートブロック";
				solidity = 65;
				break;
			case 8:
				name = "レンガ";
				solidity = 55;
				break;
			case 7:
			case 6:
				name = "土鍋";
				solidity = 36;
				break;
			case 5:
			case 4:
				name = "瓦";
				solidity = 18;
				break;
			case 3:
			case 2:
				name = "ガラス";
				solidity = 10;
				break;
			case 1:
			case 0:
				name = "氷";
				solidity = 5;
				break;
			default:
				System.out.println("defaultケースに入りました");
				break;
		}
		if(singularNum == 0) {
			singular = "微妙な";
			solidity = (int)(solidity * 0.95);
		}else if(singularNum == 9){
			singular = "固そうな";
			solidity = (int)(solidity * 1.2);
		}
		scoreRate = 1.0;
	}
	
	public void clingFilmTarget(int singularNum){	//サランラップ基準耐久　120
		int num = r.nextInt(8);
		switch(num){
			case 7:
				name = "まぐろ";
				solidity = 100;
				break;
			case 6:
				name = "パイナップル";
				solidity = 48;
				break;
			case 5:
			case 4:
				name = "ホールケーキ";
				solidity = 30;
				break;
			case 3:
			case 2:
				name = "キャベツ";
				solidity = 18;
				break;
			case 1:
			case 0:
				name = "りんご";
				solidity = 6;
				break;
			default:
				System.out.println("defaultケースに入りました");
				break;
		}
		if(singularNum <= 0) {
			singular = "ほんのり小さな";
			solidity = (int)(solidity * 0.8);
		}else if(singularNum >= 7){
			singular = "明らかにデカイ";
			solidity = (int)(solidity * 1.15);
		}
		scoreRate = 1.0;
	}

	public void plasticBagTarget(int singularNum){	//ビニール袋基準耐久　40
		int num = r.nextInt(8);
		switch(num){
			case 7:
				name = "瓶酒";
				solidity = 26;
				break;
			case 6:
				name = "すいか";
				solidity = 18;
				break;
			case 5:
			case 4:
				name = "白菜";
				solidity = 12;
				break;
			case 3:
			case 2:
				name = "メロン";
				solidity = 9;
				break;
			case 1:
			case 0:
				name = "雑誌";
				solidity = 4;
				break;
			default:
				System.out.println("defaultケースに入りました");
				break;
		}
		if(singularNum <= 0) {
			singular = "見た目に反して軽い";
			solidity = (int)(solidity * 0.8);
		}else if(singularNum >= 7){
			singular = "ずいぶんと重そうな";
			solidity = (int)(solidity * 1.5);
		}
		scoreRate = 1.8;
	}


	public void sofaTarget(int singularNum){	//ソファー袋基準耐久　90
		int num = r.nextInt(8);
		switch(num){
			case 7:
				name = "ぐりずりー";
				solidity = 50;
				break;
			case 6:
				name = "らいおん";
				solidity = 40;
				break;
			case 5:
			case 4:
				name = "ごりら";
				solidity = 30;
				break;
			case 3:
			case 2:
				name = "だちょう";
				solidity = 18;
				break;
			case 1:
			case 0:
				name = "力士";
				solidity = 12;
				break;
			default:
				System.out.println("defaultケースに入りました");
				break;
		}
		if(singularNum <= 0) {
			singular = "かわいい";
			solidity = (int)(solidity * 0.9);
		}else if(singularNum >= 7){
			singular = "立派な";
			solidity = (int)(solidity * 1.6);
		}
		scoreRate = 1.0;
	}




/*****************************************************************/

	@Override
	public String toString(){
		return "オブジェクト：" + singular + name + ", 耐久度：" + solidity;
	}
	
	public String getName() {
		return singular + name;
	}
	
	public int getSolidity() {
		return solidity;
	}
	
	public double getScoreRate(){
		return scoreRate;
	}

}