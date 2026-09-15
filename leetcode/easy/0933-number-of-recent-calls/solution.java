import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        // Add the new request time
        queue.add(t);
        
        // Remove requests older than (t - 3000)
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        
        // The remaining elements in the queue are within [t - 3000, t]
        return queue.size();
    }
}