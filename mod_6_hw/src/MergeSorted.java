import java.util.Scanner;
import java.util.Arrays;

public class MergeSorted {
	public static void main(String[] args) {
		// setting variables needed
		int[] list1, list2;
		
		// Prompting user for first list
		list1 = promptUserForList("list1");
		
		// Prompting user for second list
		list2 = promptUserForList("list2");
		
		// displaying merged list
		displayMergedList(list1, list2);
	}	

	// displays merged list
	private static void displayMergedList(int[] list1, int[] list2) {
		int[] mergedList = merge(list1, list2);
		
		System.out.print("Merged List: " + Arrays.toString(mergedList));
	}
	
	// prompts user for list and returns it
	private static int[] promptUserForList(String listName) {
		Scanner input = new Scanner(System.in);
		int[] list;
		int listLength;
		
		System.out.print("Enter " + listName + ": ");
		listLength = input.nextInt();
		list = new int[listLength];
		for(int i = 0; i < list.length; i++) {
			list[i] = input.nextInt();
		}
		
		return list;
	}

	// merges list 1 and list 2, sorts merged list and returns it
	public static int[] merge(int[] list1, int[] list2) {
		int[] mergedList = new int[list1.length + list2.length];
		int mergedListsIndex = 0;
		
		for(int i = 0; i < list1.length; i++) {
			mergedList[mergedListsIndex] = list1[i];
			mergedListsIndex++;
		}
		
		for(int i = 0; i < list2.length; i++) {
			mergedList[mergedListsIndex] = list2[i];
			mergedListsIndex++;
		}
		
		Arrays.sort(mergedList);
		
		return mergedList;
	}
	
	
}

// Enter list1: 5 1 5 16 61 111
// Enter list2: 4 2 4 5 6
// the merged list is 12 4 5 5 6 16 61 11