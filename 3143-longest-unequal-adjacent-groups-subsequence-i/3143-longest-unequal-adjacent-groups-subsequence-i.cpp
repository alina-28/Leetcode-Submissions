class Solution {
public:
    vector<string> getLongestSubsequence(vector<string>& words, vector<int>& groups) {
        vector<string> result;

        if (words.empty()) return result;

        // Always include the first word
        result.push_back(words[0]);
        int prev = groups[0];

        // Traverse and select alternating group values
        for (int i = 1; i < words.size(); ++i) {
            if (groups[i] != prev) {
                result.push_back(words[i]);
                prev = groups[i]; // update previous group
            }
        }

        return result;
    }
};