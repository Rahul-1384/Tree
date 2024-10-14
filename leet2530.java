import java.util.*;
public class Leet2530 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        long score = 0;
        while(k > 0){
            int head = pq.poll();
            score += head;
            head = (int)Math.ceil((double)head/3);
            pq.add(head);
            k--;
        }
        return score;
    }
}