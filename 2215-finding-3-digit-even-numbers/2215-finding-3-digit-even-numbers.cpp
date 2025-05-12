class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
         set<int> result;  // to store unique and sorted numbers

        int n = digits.size();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (i == j || j == k || i == k) continue; // distinct digits

                    int d1 = digits[i], d2 = digits[j], d3 = digits[k];

                    if (d1 == 0) continue;     // leading zero not allowed
                    if (d3 % 2 != 0) continue; // must be even

                    int num = d1 * 100 + d2 * 10 + d3;
                    result.insert(num);
                }
            }
        }

        return vector<int>(result.begin(), result.end());
    }
};