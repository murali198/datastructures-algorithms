package com.murali.ds.string;

import java.util.HashMap;
import java.util.Map;

public class StringAlgorithms {

	public static void main(String[] args) {
		longestCommonSubstring();
	}

	public static void longestCommonSubstring() {

		String first = "abcde";
		String second = "abc";

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
		String str = "ThisThis";
		int len = 3;
		
		Map<String, Integer> map = new HashMap<>();
	    int limit = str.length() - len + 1;
	    for (int i = 0; i < limit; i++) {
	        String sub = str.substring(i, i + len);
	        Integer counter = map.get(sub);
	        if (counter == null) {
	            counter = 0;
	        }
	        map.put(sub, ++counter);
	    }
		
	}
}
