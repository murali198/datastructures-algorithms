package com.murali.ds.sorting;

public class SortingAlgorithms {

	public static void main(String[] args) {
		quickSort();
	}

	public static void selectionSort() {
		int arr[] = {100,20,15,30,5,75,40};
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.print("selection sort: ");
		print(arr);
	}

	public static void bubbleSort() {
		int arr[] = {100,20,15,30,5,75,40};
		for(int i = 0; i < arr.length; i++ ) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.print("bubble sort: ");
		print(arr);
	}

	public static void insertionSort() {
		int arr[] = {100,20,15,30,5,75,40};
		for(int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i;
			for (;j > 0 && arr[j - 1] > temp; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = temp;
		}
		System.out.print("insertion sort: ");
		print(arr);
	}

	public static void quickSort() {
		int arr[] = { 100, 20, 15, 30, 5, 75, 40 };
		quickSortIntern(arr, 0, arr.length - 1);
		System.out.print("quick sort: ");
		print(arr);
	}
	
	private static void quickSortIntern(int array[], int left, int right) {
		int i = left;
		int j = right;
		int pivot = array[ left + (right-left) / 2 ];
		while (i <= j) {
			while (array[i] < pivot) { i++; } while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		if (left < j)
			quickSortIntern(array, left, j);
		if (i < right)
			quickSortIntern(array, i, right);
	}


	private static void print(int arr[]) {
		for(int val : arr) {
			System.out.print(val+ " ");
		}
		System.out.println("");
	}
}
