class Solution:
    def maxArea(self, heights: List[int]) -> int:
        maxAcreage = 0
        start = 0
        end = len(heights) - 1
        while start < end:
            greatThan = True if heights[start] > heights[end] else False
            acreage = None
            if greatThan:
                acreage = heights[end] * (end - start)
            else:
                acreage = heights[start] * (end - start)
            
            if acreage > maxAcreage:
                maxAcreage = acreage
            if greatThan:
                if heights[end - 1] < heights[end]:
                    # break
                    end-=1
            else:
                if heights[start + 1] < heights[start]:
                    # break
                    start+=1
            
            if greatThan:
                end-=1
            else:
                start+=1
        return maxAcreage
