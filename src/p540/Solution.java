package p540;

import java.util.Arrays;

public class Solution {

	// public static int[] inputArray = { 3, 3, 7, 7, 10, 11, 11 };
	// public static int[] inputArray = { 1, 1, 2, 3, 3, 4, 4, 8, 8, 3, 3, 7, 7, 11, 11 };
	public static int[] inputArray = { 3, 3, 6, 6, 4, 4, 1, 1, 6, 6, 2, 2, 9, 1, 1, 7, 7, 5, 5, 8, 8 };
	// public static int[] inputArray = { 1, 1, 2, 2, 4, 4, 5, 5, 9 };
	// public static int[] inputArray = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };

	public int candidate = -1;

	public static void main(String[] args) {
		System.out.println(new Solution().singleNonDuplicate(inputArray));
	}

	public int singleNonDuplicate(int[] nums) {

		System.out.println("nums:" + Arrays.toString(nums));

		int[] newArray = null;

		int size = nums.length;
		int middle = nums[(size / 2)];
		boolean isEven = ((size / 2) % 2 == 0 ? true : false);
		System.out.println("middle:" + middle);

		if (size == 1) candidate = middle;

		// peek to the left
		else if (middle == nums[(size / 2) - 1]) {
			if (!isEven) {// if leftover is odd then attach to left and discard
				newArray = new int[size / 2];
				System.arraycopy(nums, size / 2 + 1, newArray, 0, size / 2);
				singleNonDuplicate(newArray);
			} else {// if leftover is even then attach to left and keep it
				newArray = new int[size / 2 + 1];
				System.arraycopy(nums, 0, newArray, 0, size / 2 + 1);
				singleNonDuplicate(newArray);
			}
		}

		// peek to the right
		else if (middle == nums[(size / 2) + 1]) {
			if (!isEven) {// if leftover is odd then attach to right and discard
				newArray = new int[size / 2];
				System.arraycopy(nums, 0, newArray, 0, size / 2);
				singleNonDuplicate(newArray);
			} else {// if leftover is even then attach to right and keep it
				newArray = new int[size / 2 + 1];
				System.arraycopy(nums, size / 2, newArray, 0, size / 2 + 1);
				singleNonDuplicate(newArray);
			}
		}

		else candidate = middle;

		return candidate;

	}

}
