package searchandsort;

import java.util.PriorityQueue;

public class LC1046LastStoneWeight {
    public int lastStoneWeightPQ(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            queue.offer(queue.poll() - queue.poll());
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }


}
