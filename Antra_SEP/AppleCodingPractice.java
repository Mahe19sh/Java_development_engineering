import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class AppleCodingPractice {
    //1) Level_order Traversal of binary tree
    public void Level_order(BinaryNode root){
        if(root == null){
            return;
        }

        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
           BinaryNode curr = q.poll();
           
           System.out.println(curr.value+" -> ");

           if(curr.left != null){
            q.add(curr.left);
           }
           if(curr.right != null){
            q.add(curr.right);
           }
        }
    }

    //2) Sort map by values
    /*
    Map<String, Integer> sortedMap = map.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(
            LinkedHashMap::new,
            (m, e) -> m.put(e.getKey(), e.getValue()),
            LinkedHashMap::putAll
        );

    System.out.println(sortedMap);
    */

    //3) Find longest common prefix in an array of strings.
    public String longestCommonPrefix(String[] s){
        if(s == null || s.length == 0){
            return "";
        }
        String prefix = s[0];

        for(int i=1;i<s.length;i++){
            while(s[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    //4) SubArray sum equals K.

    public int subArraySumK(int[] nums, int k){
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int num : nums){
            sum += num;

            if(map.containsKey(sum - k)){
                count += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    //5) Rearrange Array alternating Max/Min
    public void rearrange(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];
        int left = 0, right = n - 1;
        boolean flag = true;

        for(int i=0;i<arr.length;i++){
            if(flag){
                temp[i] = arr[right--];
            }
            if(!flag){
                temp[i] = arr[left++];
            }

            flag = !flag;
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = temp[i];
        }

        System.out.println(Array.toString(arr));
    }

    //6) Width of a Binary tree.
    public int widhtTree(BinaryNode root){
        if(root == null){
            return 0;
        }

        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        int treeMaxWidth = 0;

        while(!q.isEmpty()){
            int currLevel = q.size();
            treeMaxWidth = Math.max(treeMaxWidth, q.size());
            for(int i=1;i<=currLevel;i++){
                if(q.peek().left != null){
                    q.add(q.peek().left);
                }
                if(q.peek().right != null){
                    q.add(q.peek().right);
                }
                q.poll();
            }
        }

        return treeMaxWidth;
    }

    //7) Width of binary tree when null values comes into count.
    public int widthOfTree(BinaryNode root){
        if(root == null){
            return 0;
        }

        int maxWidth = 0;
        Queue<pair<BinaryNode, Integer>> q = new LinkedList<>();
        q.offer(new pair<>(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            int minIndex = q.peek().getValue();
            int first = 0, last = 0;

            for(int i=0;i<size;i++){
                pair<BinaryNode, Integer> curr = q.poll();
                BinaryNode node = curr.getKey();
                int currIdx = curr.getValue() - minIndex;

                if(i == 0){
                    first = currIdx;
                }
                if(i == size - 1){
                    last = currIdx;
                }

                if(node.left != null){
                    q.offer(new pair<>(node.left, 2 * currIdx + 1));
                }
                if(node.right != null){
                    q.offer(new pair<>(node.right, 2 * currIdx + 2));
                }

                maxWidth = Math.max(maxWidth, last - first + 1);
            }
            return maxWidth;
        }

    }

    public Boolean validParenthesis(String s){
        Stack<Character> stack = new Stack<>();

        for(Char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()) { return false; }
                Char top = stack.pop();
                if(ch == ')' && top != '(' || ch == '}' && top != '{' || ch == ']' && top != '['){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public String strCompression(String input){
        StringBuilder result = new StringBuilder();
        int count = 1;

        for(int i=1;i<input.length();i++){
            if(input.charAt(i) == input.charAt(i-1)){
                count++;
            }
            else{
                result.append(input.charAt(i-1)).append(count);
                count = 1;
            }
        }

        result.append(input.charAt(input.length()-1)).append(count);

        return result.toString();

    }

    //"a##b" => "b". 
    public String processString(String s){
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        for(char ch : stack){
            result.append(ch);
        }

        return result.toString();
    }

    public int lengthOfLongestSubstring(String s) {
        int max_len = 0;
        Set<Character> unique = new HashSet<>();
        char[] arr = s.toCharArray();
        int l = 0;
 
        for(int r = 0;r < arr.length;r++){
         while(unique.contains(arr[r])){
             unique.remove(arr[l]);
             l++;
         }
         unique.add(arr[r]);
         max_len = Math.max(max_len, r - l + 1);
        } 
        
        return max_len;
     }

     
}

public class pair<K,V> {
    private K key;
    private V value;

    public pair(K key,V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}
