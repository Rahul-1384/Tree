import java.util.*;
class leet682 {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<operations.length;i++){
            if(!st.isEmpty() && operations[i].equals("C")){
                st.pop();
            }
            else if(!st.isEmpty() && operations[i].equals("D")){
                st.push(st.peek()*2);
            }
            else if(!st.isEmpty() && operations[i].equals("+")){
                int top = st.peek();
                int secondTop = st.get(st.size() - 2);
                st.push(top + secondTop);
            }
            else{
                st.push(Integer.parseInt(operations[i]));
            }
        }
        int total = 0;
        while(!st.isEmpty()){
            total += st.pop();
        }
        return total;
    }
}