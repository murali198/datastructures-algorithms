package com.murali.ds.search;

public class SearchAlogarithem {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {2, 5, 6, 7, 11, 13, 15,18, 20};
		Integer index = binarySearchRecursive(arr, 21, 0, arr.length -1);
		System.out.println(arr[index]);
	}

	private static Integer binarySearch(Integer[] arr, Integer value) {
		int first = 0;
		int last = arr.length -1;
		int mid = 0;
		while(first <= last) {
			mid = (first + last) / 2;
			Integer midValue = arr[mid];
			if(value > midValue) {
				first = mid + 1;
			} else if(value < midValue) {
				last = mid -1;
			} else {
				return mid;
			}
		}
		return mid;
	}

	private static Integer binarySearchRecursive(Integer[] arr, Integer value, int first, int last) {
		int mid = 0;
		while(first <= last) {
			mid = (first + last) / 2;
			Integer midValue = arr[mid];
			if(value > midValue) {
				return binarySearchRecursive(arr, value, mid + 1, last);
			} else if(value < midValue) {
				return binarySearchRecursive(arr, value, first, mid -1);
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	private static Integer linearSearchRecursive(Integer[] arr, Integer value, int i) {
		if(i >= arr.length) {
			return -1;
		}
		else if(value == arr[i]) {
			return i;
		} else {
			return linearSearchRecursive(arr, value, i + 1);
		}
	}
}