import java.util.Scanner;

public class ChickenRace{

	public static void main(String[] args){
		Mover mov = new Mover();
		mov.message();
		mov.menu();
		String s = mov.baseMethod();
		mov.interlude002a(26, '◇', 80, '◆', 60, false);
		System.out.println("\n" + s + "ためチキンレース終了です\n\n\n");
		System.out.println("結果：");
		mov.dataPrint();
		System.out.println("");
		mov.keyWait();
		System.out.println("お疲れ様でした！　　(^ω^)ﾉｼ");
	}

}