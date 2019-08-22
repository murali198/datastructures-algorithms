package com.murali.ds.string;

import java.util.HashMap;

public class StringAlgorithms {

	public static void main(String[] args) {
		findAllInterleavingsString();
	}

	public static void longestCommonSubstring() {

		String first = "abcdefgh";
		String second = "abcsdefgabfg";

		int maxlen = 0;
		int endingIndex = first.length();
		int[][] lookup = new int[first.length() + 1][second.length() + 1];

		for (int i = 1; i <= first.length(); i++) {

			for (int j = 1; j <= second.length(); j++) {

				if (first.charAt(i - 1) == second.charAt(j - 1)) {

					lookup[i][j] = lookup[i - 1][j - 1] + 1;
					if (lookup[i][j] > maxlen) {

						maxlen = lookup[i][j];
						endingIndex = i;
					}
				}
			}
		}

		System.out.println(first.substring(endingIndex - maxlen, endingIndex));
	}

	public static void findAllInterleavingsString() {
		interleavings("AB", "MN", "");
	}

	private static void interleavings(String str1, String str2, String interleavingString) {
		
		if(str1 == null){
			System.out.println(str2);
			return;
		}

		if(str2 == null){
			System.out.println(str1);
			return;
		}

		if(str1.length() == 0 && str2.length() == 0){
			System.out.println(interleavingString);
		}

		if(str1.length() != 0){
			interleavings(str1.substring(1), str2, interleavingString + str1.charAt(0));
		}

		if(str2.length() != 0){
			interleavings(str1, str2.substring(1), interleavingString + str2.charAt(0));
		}
	}
	
	public static void duplicateSubstringOfGivenLength() {
		String str = "";
		int len = 3;
		
		int result = 0;
	    int i = 0;
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    
	    for(int j = 0; j < str.length(); j++) {
	    	char c = str.charAt(j);
	    	if(map.containsKey(c)) {
	    		map.put(c, map.get(c)+1);
	    	} else {
	    		map.put(c, 1);
	    	}
	    }
		
	}
}
