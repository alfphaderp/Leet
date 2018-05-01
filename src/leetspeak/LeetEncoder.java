package leetspeak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LeetEncoder {
	private HashMap<Character, String[]> dictionary = new HashMap<Character, String[]>();
	
	// Load dictionary from constructor
	public LeetEncoder(String dict) {
		loadDictionary(dict);
	}
	
	// Read from a dictionary file
	public void loadDictionary(String dict) {
		try(BufferedReader reader = new BufferedReader(new FileReader(new File(dict)))) {
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
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	// Encode a single character
	public String encode(char ch) {
		ch = Character.toUpperCase(ch);
		String[] values = dictionary.get(ch);
		
		if(values != null) {
			return values[(int) Math.floor(Math.random() * values.length)];
		} else {
			return Character.toString(ch);
		}
	}
	
	// Encode a string
	public String encode(String str) {
		String encodedString = "";
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				encodedString += " ";
			} else {
				encodedString += encode(str.charAt(i));
			}
		}
		
		return encodedString;
	}
	
	// Encode a file
	public void encodeFile(String source, String destination) {
		try(BufferedReader reader = new BufferedReader(new FileReader(new File(source))); PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(new File(destination))))) {
			while(reader.ready()) {
				writer.println(encode(reader.readLine()));
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	// See how many possible ways to encode a string exist
	public BigInteger getPermutations(String str) {
		BigInteger permutations = BigInteger.ONE;
		
		for(int i = 0; i < str.length(); i++) {
			String[] values = dictionary.get(Character.toUpperCase(str.charAt(i)));
			
			if(values != null) {
				permutations = permutations.multiply(new BigInteger(Integer.toString(values.length)));
			}
		}
		
		return permutations;
	}
}
