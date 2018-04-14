package leetspeak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

public class Encoder {
	static HashMap<Character, String[]> dictionary = new HashMap<Character, String[]>();
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		loadDictionary();
		
		while(true) {
			try {
				System.out.println(encode(input.readLine()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Read from a file called dictionary.txt
	public static void loadDictionary() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("dictionary.txt")));
			StringTokenizer tokenizer;
			int tokens;
			char key;
			String[] values;
			
			while(reader.ready()) {
				// Assign key to the first character of each line
				tokenizer = new StringTokenizer(reader.readLine());
				key = tokenizer.nextToken().charAt(0);
				
				// Assign values to an array of strings
				tokens = tokenizer.countTokens();
				values = new String[tokens];
				for(int i = 0; i < tokens; i++) {
					values[i] = tokenizer.nextToken();
				}
				
				// Put key with values into dictionary
				dictionary.put(key, values);
			}
			
			reader.close();
		}
		catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	// Encode a single character
	public static String encode(char ch) {
		ch = Character.toUpperCase(ch);
		
		if(dictionary.get(ch) != null) {
			return dictionary.get(ch)[(int) Math.floor(Math.random() * dictionary.get(ch).length)];
		}
		else {
			return Character.toString(ch);
		}
	}
	
	// Encode a string
	public static String encode(String str) {
		String encodedString = "";
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				encodedString += " ";
			}
			else {
				encodedString += encode(str.charAt(i));
			}
		}
		
		return encodedString;
	}
}
