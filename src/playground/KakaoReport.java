package playground;

import java.util.*;

public class KakaoReport {
    public static void main(String[] args) {
        System.out.println("solution(id_list_1, report_1, 2) = " + Arrays.toString(solution(id_list_1, report_1, 2)));
        System.out.println("solution(id_list_2, report_2, 3) = " + Arrays.toString(solution(id_list_2, report_2, 3)));


    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        // HashMap 을 사용하자

        return new int[]{1};
    }

    public static final String[] id_list_1 = {"muzi", "frodo", "apeach", "neo"};
    public static final String[] report_1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

    public static final String[] id_list_2 = {"con", "ryan"};
    public static final String[] report_2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
}
