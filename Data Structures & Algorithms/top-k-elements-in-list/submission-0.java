class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> kMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            kMap.put(nums[i], kMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> kMap.get(a) - kMap.get(b)
        );
        for (int number : kMap.keySet()) {
            minHeap.offer(number);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }

}