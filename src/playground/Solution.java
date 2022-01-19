package playground;

public class Solution {
    final static String[] NUM_TO_ENG = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    final static String[] TEST_CASE = {"one4seveneight", "23four5six7", "2three45sixseven", "123"};

    public static void main(String[] args) {
        solution(TEST_CASE[0]);
    }

    static int solution(String s) {
        int answer = 0;

        try {
            answer = Integer.parseInt(s);
            System.out.println("the case is num");
        } catch (Exception e) {
            for (int i = 0; i < NUM_TO_ENG.length; i++) {
                if(s.contains(NUM_TO_ENG[i])){
                    int engIdx = s.lastIndexOf(NUM_TO_ENG[i]);

                }
            }
        }

        return answer;
    }
}
