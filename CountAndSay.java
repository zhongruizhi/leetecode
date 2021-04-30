import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-and-say/
 * https://www.geeksforgeeks.org/look-and-say-sequence/
 */

class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        StringBuffer resultBuffer = new StringBuffer();
        String said = countAndSay(n - 1);
        char current = said.charAt(0);
        int count = 1;
        for(int i = 1; i < said.length(); i++) {
            if (current == said.charAt(i)) {
                count++;
            } else {
                resultBuffer.append(count).append(current);
                current = said.charAt(i);
                count = 1;
            }
        }
        resultBuffer.append(count).append(current);
        
        return resultBuffer.toString(); 
    }



    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();
        System.out.println(cas.countAndSay(5));
        
        Map<String, String> map = new HashMap<>();
        map.put("name", null);
        map.put("name", "abc");
        System.out.println(map.size());

        String s = "hello";
        String t = "hello";
        char c[] = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(t.equals(new String("hello")));
        
    }
}