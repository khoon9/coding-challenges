package skillladder.level20_advanced_2;

/**
 *문제
 * 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다. 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N의 진짜 약수의 개수가 주어진다. 이 개수는 50보다 작거나 같은 자연수이다. 둘째 줄에는 N의 진짜 약수가 주어진다. 1,000,000보다 작거나 같고, 2보다 크거나 같은 자연수이고, 중복되지 않는다.
 *
 * 출력
 * 첫째 줄에 N을 출력한다. N은 항상 32비트 부호있는 정수로 표현할 수 있다.
 *
 * 예제 입력 1
 * 2
 * 4 2
 * 예제 출력 1
 * 8
 * 예제 입력 2
 * 1
 * 2
 * 예제 출력 2
 * 4
 * 예제 입력 3
 * 6
 * 3 4 2 12 6 8
 * 예제 출력 3
 * 24
 * 예제 입력 4
 * 14
 * 14 26456 2 28 13228 3307 7 23149 8 6614 46298 56 4 92596
 * 예제 출력 4
 * 185192
 */

import java.util.*;

public class P1037 {
    public static void main(String[] args){
        // 진짜 약수 -> 1과 target 자체가 아님
        // 진짜 약수의 개수와 그 모든 수를 제공 받아 target이 몇인지 구하는 문제
        // 이떄, 진짜 약수로 제공받은 수 이외에 또다른 진짜 약수가 target에 대하여 존재해서는 안 됨
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        scanner.nextLine();
        StringTokenizer st = new StringTokenizer(scanner.nextLine());
        Set<Integer> targetValues = new HashSet<>();
        for (int i=0; i<N; i++){
            targetValues.add(Integer.parseInt(st.nextToken()));
        }
        int nowValue = 3;
        while (!isOk(targetValues, nowValue)){
            nowValue++;
        }
        sb.append(nowValue);

        System.out.println(sb);
    }
    public static boolean isOk(Set<Integer> targetValues, int nowValue){
        for (int targetValue:targetValues){
            if ((nowValue%targetValue != 0) || (targetValue == nowValue)){
                return false;
            }
        }
        for (int i=2; i< nowValue; i++){
            if (nowValue%i == 0 && !targetValues.contains(i)){
                return false;
            }
        }
        return true;
    }
}
