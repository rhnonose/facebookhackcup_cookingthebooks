package facebookHackCup.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.common.collect.Lists;

public class CookingTheBooks implements Solvable {

	String fileName = "cooking_the_books_example_input.txt";

	public String getFileName() {
		return fileName;
	}

	public List<String> solveFor(List<String> input) {

		ArrayList<String> result = Lists.newArrayList();
		input.remove(0);
		int i = 1;

		for (String line : input) {
			result.add("Case #" + (i++) + ": " + solveSmaller(line) + " "
					+ solveBigger(line));
		}

		return result;
	}

	public String solveSmaller(String number) {
		if(number.length() == 1)
			return number;
		
		char[] charArray = number.toCharArray();
		
		char smaller = findSmaller(charArray);
		int smallerIndex = findSmallerRightmostIndex(charArray, smaller);
		int biggerIndex = findBiggerIndex(charArray, smaller, smallerIndex);
		String result = swap(charArray, smallerIndex, biggerIndex);
		
		return result;
	}
	
	private String swap(char[] charArray, int smallerIndex, int biggerIndex) {
		char temp;
		temp = charArray[smallerIndex];
		charArray[smallerIndex] = charArray[biggerIndex];
		charArray[biggerIndex] = temp;
		return new String(charArray);
	}

	private int findBiggerIndex(char[] charArray, char smaller, int smallerIndex) {
		for(int i = 0; i < smallerIndex; i++){
			if(charArray[i] > smaller) return i;
		}
		return 0;
	}

	private char findSmaller(char[] charArray) {
		char smaller = '9';
		for(char sm : charArray){
			if(sm < smaller) smaller = sm;
		}
		return smaller;
	}
	
	private int findSmallerRightmostIndex(char[] charArray, char smaller) {
		int smallerIndex = 0;
		int smallerL = smaller;
		for(int i = 0; i < charArray.length; i++){
			if(charArray[i] == smallerL) smallerIndex = i;
		}
		return smallerIndex;
	}

	public String solveBigger(String number) {
		if(number.length() == 1)
			return number;
		
		char[] charArray = number.toCharArray();
		
		char bigger = findBigger(charArray);
		int biggerIndex = findBiggerRightmostIndex(charArray, bigger);
		int smallerIndex = findSmallerIndex(charArray, bigger, biggerIndex);
		String result = swap(charArray, smallerIndex, biggerIndex);
		
		return result;
	}

	private char findBigger(char[] charArray) {
		char bigger = 0;
		for (char c : charArray) {
			if(c > bigger) bigger = c;
		}
		return bigger;
	}
	
	private int findBiggerRightmostIndex(char[] charArray, char bigger) {
		int biggerIndex = 0;
		for (int i = 0; i < charArray.length; i++) {
			if(charArray[i] == bigger) biggerIndex = i;
		}
		return biggerIndex;
	}

	private int findSmallerIndex(char[] charArray, char bigger, int biggerIndex) {
		for (int i = 0; i < charArray.length; i++) {
			if(charArray[i] < bigger) return i;
		}
		return 0;
	}
	
	
	
}
