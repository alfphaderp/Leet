package leetspeak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LeetSpeaker {
	private HashMap<Character, String[]> dictionary = new HashMap<Character, String[]>();
	
	// Load dictionary from constructor
	public LeetSpeaker(String dic) {
		loadDictionary(dic);
	}
	
	// Read from a dictionary file
	public void loadDictionary(String dic) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(dic)));
			StringTokenizer tokenizer;
			String[] values;
			int count;
			char key;
			
			while(reader.ready()) {
				tokenizer = new StringTokenizer(reader.readLine());
				
				if(tokenizer.countTokens() > 0) {
					key = tokenizer.nextToken().charAt(0);
					count = tokenizer.countTokens();
					values = new String[count];
					
					for(int i = 0; i < count; i++) {
						values[i] = tokenizer.nextToken();
					}
					
					dictionary.put(key, values);
				}
			}
			
			reader.close();
		}
		catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	// Encode a single character
	public String encode(char ch) {
		ch = Character.toUpperCase(ch);
		String[] values = dictionary.get(ch); 
		
		if(values != null) {
			return values[(int) Math.floor(Math.random() * values.length)];
		}
		else {
			return Character.toString(ch);
		}
	}
	
	// Encode a string
	public String encode(String str) {
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
	
	// Encode a file
	public void encodeFile(String source, String destination) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(source)));
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(new File(destination))));
			
			while(reader.ready()) {
				writer.println(encode(reader.readLine()));
			}
			
			reader.close();
			writer.close();
		}
		catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
