import java.util.*;

public class Priority {
    public class Priority_Queue {
        static ArrayList<Integer> data = new ArrayList<Integer>();

        // Inserting Element
        public void addElements(int val){
            data.add(val);
            upheapify(data.size()-1);
        }
        private void upheapify(int ci){
            int pi = (ci-1)/2;
            if(data.get(pi) < data.get(ci)){
                swap(ci,pi);
                upheapify(pi);
            }
        }
        private void swap(int ci,int pi){
            int child = data.get(ci);
            int parent = data.get(pi);
            data.set(pi,child);
            data.set(ci,parent);
        }

        // Deleting Elements
        public void max(){
            int value = data.get(0);
            data.set(value, data.get(data.size()-1));
            downheapify(0);
        }
        public void downheapify(int pi){
            int idx = pi;
            int leftIndx = 2*idx + 1;
            int rightIndx = 2*idx +1;
            if(leftIndx < data.size()-1 && leftIndx < data.get(idx)){
                leftIndx = idx;
            }
            if(rightIndx < data.size()-1 && rightIndx < data.get(idx)){
                rightIndx = idx;
            }
        }
    }
    public static void main(String[] args) {
        Priority p = new Priority();
        
    }

    
}
