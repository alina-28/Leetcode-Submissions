import java.util.*;

public class Solution {
    private Set<String> exactWords;
    private Map<String, String> caseMap;
    private Map<String, String> vowelMap;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        exactWords = new HashSet<>();
        caseMap = new HashMap<>();
        vowelMap = new HashMap<>();

        // Build dictionaries
        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseMap.putIfAbsent(lower, word);

            String devowel = devowel(lower);
            vowelMap.putIfAbsent(devowel, word);
        }

        // Process queries
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exactWords.contains(q)) {
                ans[i] = q;
            } else if (caseMap.containsKey(q.toLowerCase())) {
                ans[i] = caseMap.get(q.toLowerCase());
            } else if (vowelMap.containsKey(devowel(q.toLowerCase()))) {
                ans[i] = vowelMap.get(devowel(q.toLowerCase()));
            } else {
                ans[i] = "";
            }
        }

        return ans;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');  // replace vowels with *
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
