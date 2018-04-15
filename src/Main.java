import java.util.Scanner;
import leetspeak.LeetSpeaker;

public class Main {
	public static void main(String[] args) {
		// Create 3 LeetSpeakers, each with a different level of complexity
		LeetSpeaker basicLeetSpeaker = new LeetSpeaker("./res/dictionaries/basic.leet");
		LeetSpeaker advancedLeetSpeaker = new LeetSpeaker("./res/dictionaries/advanced.leet");
		LeetSpeaker ultimateLeetSpeaker = new LeetSpeaker("./res/dictionaries/ultimate.leet");
		
		// Encode some characters
		System.out.println("This leetspeak encoder uses randomness to generate what each character becomes!");
		System.out.println("For example, the following same letter \"M\" is generated 20 times:\n");
		
		for(int i = 0; i < 20; i++) {
			System.out.print(ultimateLeetSpeaker.encode('M'));
		}
		System.out.println("\n");
		
		// Encode some strings
		System.out.println("You can also use custom dictionaries of varying complexity!\n");
		
		String str = "This is what a string of text looks like ";
		
		System.out.println(str + "normally!");
		System.out.println(basicLeetSpeaker.encode(str + "in basic Leetspeak!"));
		System.out.println(advancedLeetSpeaker.encode(str + "in advanced Leetspeak!"));
		System.out.println(ultimateLeetSpeaker.encode(str + "in ultimate Leetspeak!\n"));
		
		// Encode some files
		System.out.println("Files can be encoded as well! Check out ./res/samples/!\n");
		
		String sampleDir = "./res/samples/";
		
		basicLeetSpeaker.encodeFile("./res/samples/lorem.txt", sampleDir + "basiclorem.txt");
		advancedLeetSpeaker.encodeFile("./res/samples/lorem.txt", sampleDir + "advancedlorem.txt");
		ultimateLeetSpeaker.encodeFile("./res/samples/lorem.txt", sampleDir + "ultimatelorem.txt");
		
		// Encode some input
		System.out.println("Try it yourself! Enter some text into the console!\n");
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println(ultimateLeetSpeaker.encode(in.nextLine()));
		}
	}
}
