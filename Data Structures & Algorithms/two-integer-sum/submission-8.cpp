
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> numMap;

        for (int i = 0; i < nums.size(); i++) {
            if (numMap.find(target - nums[i]) != numMap.end()) {
                vector<int> result = {numMap[target - nums[i]], i};
                return result;
            }
            numMap[nums[i]] = i;
        }

        vector<int> result = {-1, -1};
        return result;
    }
};