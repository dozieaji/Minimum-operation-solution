package com.shedrack.assesment.solution;

import java.util.Arrays;

public class TestSolution {

	public static void main(String[] args) {

		int[] nums = { 3, 2, 20, 1, 1, 3 };
		minOperations(nums, 10);
	}

	public static int minOperations(int[] nums, int x) {
		int target = Arrays.stream(nums).sum() - x;
		int n = nums.length, numOperation = -1, current = 0;

		for (int right = 0, left = 0; right < n; right++) {
			current += nums[right];
			while (current > target && left <= right)
				current -= nums[left++];

			if (current == target)
				numOperation = Math.max(numOperation, right - left + 1);
		}
		System.out.println(numOperation != -1 ? n - numOperation : -1);
		return numOperation != -1 ? n - numOperation : -1;
	}

}
