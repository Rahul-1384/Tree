import java.util.PriorityQueue;

public class arr {
    public static void main(String[] args) {
        int[] arr = {4,3,2,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int finSum = 0;
        while(pq.size() != 1){
            int sum = 0;
            int a = pq.poll();
            int b = pq.poll();
            sum = a+b;
            finSum += sum;
            pq.add(sum);
        }
        System.out.println(finSum);
    }
}
