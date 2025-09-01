class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Push initial classes with their gain
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = gain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }

        // Assign extra students
        while (extraStudents-- > 0) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1], total = (int) top[2];
            pass++; total++;
            double gain = gain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }

        // Compute final average ratio
        double sum = 0.0;
        for (double[] entry : maxHeap) {
            sum += entry[1] / entry[2];
        }

        return sum / classes.length;
    }

    private double gain(int p, int t) {
        return (double)(p + 1) / (t + 1) - (double)p / t;
    }
}