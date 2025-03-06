package skillladder.level08_basic_math1;

/**
 *문제
 * 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
 *
 * 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
 *
 * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)
 *
 * 출력
 * 첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
 *
 * 예제 입력 1
 * 2 1 5
 * 예제 출력 1
 * 4
 * 예제 입력 2
 * 5 1 6
 * 예제 출력 2
 * 2
 * 예제 입력 3
 * 100 99 1000000000
 * 예제 출력 3
 * 999999901
 */

import java.util.*;

public class P2869 {
    // 입력 A, B, V 값 10억 이하 정수
    // 반복문 정상 도착시 종료 -> 마지막 상황 V-A<=0
    // 하루 통으로 지나면 V = V - (A-B)
    // 5 -> 4 3 2 1 0
    // V = V-A
    // V/(A-B)
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int V = scanner.nextInt();

        int targetCnt = 0;
        V = V-A;
        targetCnt++;

        if (V<=0){
            sb.append(targetCnt);
        } else if ((V%(A-B))==0){
            targetCnt = targetCnt + V/(A-B);
            sb.append(targetCnt);
        } else{
            targetCnt = targetCnt + V/(A-B) + 1;
            sb.append(targetCnt);
        }

        System.out.println(sb);
    }
}
