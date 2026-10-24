#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> numSet(nums.begin(), nums.end());
        int maxLength = 0;
        int currLength = 1;

        for (int i = 0; i < nums.size(); i++) {
            int currNum = nums[i];

            if (!numSet.contains(currNum - 1)) {
                while (numSet.contains(currNum + 1)) {
                    currLength++;
                    currNum++;
                }

                if (currLength > maxLength) {
                    maxLength = currLength;
                }

                currLength = 1;
            }
        }

        return maxLength;
    }
};