class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        const int n = static_cast<int>(numbers.size());
        const int last = n - 1;
        const int* data = numbers.data();

        for (int i = 0; i < last; ++i) {
            const int remaining = target - data[i];

            if (remaining < data[i + 1] || remaining > data[last]) {
                continue;
            }

            int left = i + 1;
            int right = last;

            while (left <= right) {
                const int mid = static_cast<int>(
                    (static_cast<unsigned int>(left) + static_cast<unsigned int>(right)) >> 1);
                const int value = data[mid];

                if (value == remaining) {
                    return {i + 1, mid + 1};
                }
                if (value < remaining) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return {-1, -1};
    }
};