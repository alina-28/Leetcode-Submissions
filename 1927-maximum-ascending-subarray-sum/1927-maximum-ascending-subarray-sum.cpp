class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        int maxSum = nums[0], currSum = nums[0];

        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] > nums[i - 1]) {
                currSum += nums[i]; //xtend current ascending subarray
            } else {
                currSum = nums[i]; //new subarray
            }
            maxSum = max(maxSum, currSum); //max sum
        }

        return maxSum;
    }
};
