class Solution {
    public int[] twoSum(int[] numbers, int target) {
        final int n = numbers.length;
        final int last = n - 1;

        for (int i = 0; i < last; i++) {
            final int remaining = target - numbers[i];

            // Cắt sớm: mảng đã sắp xếp nên nếu remaining nằm ngoài
            // [numbers[i + 1], numbers[last]] thì không thể có đáp án cho i này
            if (remaining < numbers[i + 1] || remaining > numbers[last]) {
                continue;
            }

            int left = i + 1;
            int right = last;

            while (left <= right) {
                int mid = (left + right) >>> 1;
                int value = numbers[mid];

                if (value == remaining) {
                    return new int[]{i + 1, mid + 1};
                }
                if (value < remaining) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return new int[]{-1, -1};
    }
}