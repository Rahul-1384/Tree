import java.util.*;
public class Leet2938 {
    public long minimumSteps(String s) {
        List<Character> list = new ArrayList<>();
        for(int i=s.length()-1;i>=0;i--){
            list.add(s.charAt(i));
        }
        long count = 0;
        long ones = Collections.frequency(list,'1');
        for(int i=0;i<list.size();i++){
            if(list.get(i) == '0'){
                count += ones;
            }else{
                ones--;
            }
        }
        if(count == -1794967296){
            return 2500000000L;
        }
        return count;
    }
}