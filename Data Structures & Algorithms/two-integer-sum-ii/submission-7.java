class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int remaining = target - numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (numbers[mid] == remaining) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] < remaining) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return new int[]{-1, -1};
    }
}