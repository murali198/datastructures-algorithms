package com.murali.ds.array;

import java.util.Arrays;

public class NumberArrayAlogorithms {

	public static void main(String[] args) {
		findSubArrayWithSumGivenNum();
		
	}

	public static void reverseArray() {

		Integer[] arr = new Integer[] {1,2,3,4,5};
		int temp, size = arr.length;
		for(int i = 0; i < size/2; i++) {
			temp = arr[i];
			arr[i] = arr[size - i - 1];
			arr[size - i - 1] = temp;
		}

		for(int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void removeDublicateWithSort() {
		Integer[] arr = new Integer[] {1,1,2,3,4,5, 5, 5, 3};
		Arrays.sort(arr);
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(i == 0 || arr[i] != arr[i - 1]) {
				arr[count++] = arr[i];
			}
		}
		arr = Arrays.copyOf(arr, count);

		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void dublicateElement( ) {
		int arr[] = {1, 2, 3, 1, 3, 6, 99};
		for (int i = 0; i < arr.length; i++) { 
            if (arr[Math.abs(arr[i])] >= 0) 
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])]; 
            else
                System.out.print(Math.abs(arr[i]) + " "); 
        }
	}
	
	public static void roundOfArryElement() {
		int arr[] = {12, 2, 37, 10, 35, 61, 99};
		for(int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			int mod = temp % 10;
			temp = temp - mod;
			if(mod > 5)
				temp = temp + 10;
			arr[i] = temp;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void findTripletWithoutSort() {
		
		int arr[] = {4, 2, 2, 0, 1, 3, 1};
		int sum = 5;
		
		for (int i = 0; i < arr.length - 2; i++) {
			
			for (int j = i + 1; j < arr.length - 1; j++) { 
				
				for (int k = j + 1; k < arr.length; k++) {
					
					if (arr[i] + arr[j] + arr[k] == sum) {
						 System.out.print("(" + arr[i] + ", " + arr[j] + ", " + arr[k] +")"); 
					}
				}
			}
		}
	}
	
	public static void findTripletWithSort() {
		
		int arr[] = {4, 2, 2, 0, 1, 3, 1};
		int sum = 5;
		
		Arrays.sort(arr);
		for (int i = 0; i <= arr.length - 3; i++) {
			
			int k = sum - arr[i];
			int low = i + 1;
			int high = arr.length - 1;

			while (low < high) {
				
				if (arr[low] + arr[high] < k) {
					low++;
				} else if (arr[low] + arr[high] > k) {
					high--;
				} else {
					System.out.print("(" + arr[i] + " " + arr[low] + " " + arr[high] + ")");
					low++;
					high--;
				}
			}
		}
	}
	
	public static void findSubArrayWithSumGivenNum() {
		int arr[] = {4, 2, 2, 0, 1, 3, 1};
		int sum = 5;
		
		for(int i = 0; i < arr.length; i++) {
			int temp = 0;
			
			for(int j = i; j < arr.length; j++) {
				temp += arr[j];
				if(sum == temp)
					System.out.println("array start index[ "+ i   +" ] end index [ "+ j + " ]");
			}
		}
	}
	
}
