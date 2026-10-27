class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        const int last = static_cast<int>(numbers.size()) - 1;
        const int* data = numbers.data();

        int i = static_cast<int>(lower_bound(data, data + last, target - data[last]) - data);

        int right = last;

        for (; i < last; ++i) {
            const int remaining = target - data[i];

            if (remaining < data[i + 1]) {
                break;
            }

            int left = i + 1;
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