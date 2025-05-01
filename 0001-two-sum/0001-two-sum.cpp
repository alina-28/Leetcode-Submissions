#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> seen;

        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums[i];
            if (seen.count(complement)) {
                return {seen[complement], i};
            }
            seen[nums[i]] = i;
        }
        return {};
    }
};

int Main() {
    vector<int> nums = {2, 7, 11, 15};
    int target = 9;

    Solution sol;
    vector<int> result = sol.twoSum(nums, target);
    cout << "[" << result[0] << ", " << result[1] << "]" << endl;

    return 0;
}

