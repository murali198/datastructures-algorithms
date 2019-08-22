package com.murali.ds.sorting;

public class MergeSortAlgorithm {

	private static int  arr[]= { 100, 20, 15, 30, 5, 75, 40 };

	public static void main(String[] args) {
		mergeSort(0, arr.length - 1);
		for(int num : arr) 
			System.out.print(num+ " ");
		
	}
	
	private static void mergeSort(int start,int end) {
		int mid = ( start + end ) / 2;
		if(start < end ) {
			mergeSort(start,mid);
			mergeSort(mid+1,end);
			merge(start,mid,end);
		}
	}

	private static void merge(int start, int mid, int end) {
		
		int[] tempArray = new int[arr.length];
		
		int tempArrayIndex = start;
		int startIndex = start;
		int midIndex = mid+1;

		while(startIndex <= mid && midIndex <= end) {
			
			if( arr[startIndex] < arr[midIndex] ) {
				tempArray[tempArrayIndex++] = arr[startIndex++];
			} else {
				tempArray[tempArrayIndex++] = arr[midIndex++];
			}
		}

		while(startIndex <= mid) {
			tempArray[tempArrayIndex++] =arr [startIndex++];
		}
		
		while(midIndex <= end) {
			tempArray[tempArrayIndex++] = arr[midIndex++];
		}
		// Copy tempArray to actual array after sorting 
		for (int i = start; i <=end; i++) {
			arr[i]=tempArray[i];
		}
	}
}
