import java.util.Scanner;

public class ChickenRace{

	public static void main(String[] args){
		Mover mov = new Mover();
		mov.message();
		mov.menu();
		String s = mov.baseMethod();
		mov.interlude002a(26, '��', 80, '��', 60, false);
		System.out.println("\n" + s + "���߃`�L�����[�X�I���ł�\n\n\n");
		System.out.println("���ʁF");
		mov.dataPrint();
		System.out.println("");
		mov.keyWait();
		System.out.println("�����l�ł����I�@�@(^��^)ɼ");
	}

}