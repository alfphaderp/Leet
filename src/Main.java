import java.util.Scanner;
import leetspeak.LeetSpeaker;

public class Main {
	public static void main(String[] args) {
		LeetSpeaker ls = new LeetSpeaker("./res/dictionaries/ultimate.leet");
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println(ls.encode(in.nextLine()));
		}
	}
}
