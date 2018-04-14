import java.util.Scanner;
import leetspeak.LeetSpeaker;

public class Main {
	public static void main(String[] args) {
		// Create 3 leetspeakers, each with different levels of complexity
		LeetSpeaker basicLS = new LeetSpeaker("./res/dictionaries/basic.leetdic");
		LeetSpeaker advancedLS = new LeetSpeaker("./res/dictionaries/advanced.leetdic");
		LeetSpeaker ultimateLS = new LeetSpeaker("./res/dictionaries/ultimate.leetdic");
		
		// Leetspeak some text
		String str = "Hello world! This is what a string of text looks like ";
		
		System.out.println(str + "normally!");
		System.out.println(basicLS.encode(str + "in basic Leetspeak!"));
		System.out.println(advancedLS.encode(str + "in advanced Leetspeak!"));
		System.out.println(ultimateLS.encode(str + "in ultimate Leetspeak!"));
	}
}
