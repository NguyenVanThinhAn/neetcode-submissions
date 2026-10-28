class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        storage = []
        nums.sort()
        for i in range(0,size - 2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            start = i + 1
            end = size - 1
            target = -(nums[i])
            while start < end:
                two_sum = nums[start] + nums[end]
                if (two_sum > target):
                    end-=1
                elif (two_sum < target):
                    start+=1
                elif two_sum == target:
                    storage.append([nums[i], nums[start], nums[end]])
                    start += 1
                    end -= 1
                    while start < end and nums[start] == nums[start - 1]:
                        start += 1
                    while start < end and nums[end] == nums[end + 1]:
                        end -= 1
        return storage