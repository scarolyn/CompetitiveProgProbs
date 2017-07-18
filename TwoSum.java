import java.util.*;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(cur)) {
                int[] answer = {map.get(cur), i};
                return answer;
                                                                                                        }
            map.put(target-cur, i);
        }
        return new int[2];
                                        }
    public static void main (String[] args) {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        int[] answer = twoSum(array, target);
        System.out.println(answer[0] + ", " + answer[1]);
    }
}
