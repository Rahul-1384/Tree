import java.util.*;
public class KthLargest {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i : arr){
            pq.add(i);
        }
        int ans = 0;
        for(int i=pq.size()-1;i>=k-1;i--){
            ans = pq.poll();
        }
        System.out.print(ans);
    }
}