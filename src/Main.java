import java.util.Scanner;

import leetspeak.LeetEncoder;

public class Main {
	public static void main(String[] args) {
		LeetEncoder le = new LeetEncoder("./res/ultimate.leet");
		try(Scanner in = new Scanner(System.in)) {
			while(true) {
				String input = in.nextLine();
				System.out.println(le.encode(input) + " (" + le.getPermutations(input) + ")");
			}
		}
	}
}
