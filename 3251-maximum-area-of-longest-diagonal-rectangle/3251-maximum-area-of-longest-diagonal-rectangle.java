class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagSq = -1;
        int maxArea = -1;

        for (int[] rect : dimensions) {
            int l = rect[0], w = rect[1];
            int diagSq = l * l + w * w;
            int area = l * w;

            if (diagSq > maxDiagSq || (diagSq == maxDiagSq && area > maxArea)) {
                maxDiagSq = diagSq;
                maxArea = area;
            }
        }
        
        return maxArea;
    }
}