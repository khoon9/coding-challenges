package skillladder.level15_divisors_multiples_primes2;

import java.util.Scanner;

/**
 *문제
 * 서강대학교 컴퓨터공학과 실습실 R912호에는 현재 N개의 창문이 있고 또 N명의 사람이 있다. 1번째 사람은 1의 배수 번째 창문을 열려 있으면 닫고 닫혀 있으면 연다.  2번째 사람은 2의 배수 번째 창문을 열려 있으면 닫고 닫혀 있으면 연다. 이러한 행동을 N번째 사람까지 진행한 후 열려 있는 창문의 개수를 구하라. 단, 처음에 모든 창문은 닫혀 있다.
 *
 * 예를 들어 현재 3개의 창문이 있고 3명의 사람이 있을 때,
 *
 * 1번째 사람은 1의 배수인 1,2,3번 창문을 연다. (1, 1, 1)
 * 2번째 사람은 2의 배수인 2번 창문을 닫는다. (1, 0, 1)
 * 3번째 사람은 3의 배수인 3번 창문을 닫는다. (1, 0, 0)
 * 결과적으로 마지막에 열려 있는 창문의 개수는 1개 이다.
 *
 * 입력
 * 첫 번째 줄에는 창문의 개수와 사람의 수 N(1 ≤ N ≤ 2,100,000,000)이 주어진다.
 *
 * 출력
 * 마지막에 열려 있는 창문의 개수를 출력한다.
 *
 * 예제 입력 1
 * 3
 * 예제 출력 1
 * 1
 * 예제 입력 2
 * 24
 * 예제 출력 2
 * 4
 */

import java.util.*;

public class P13909 {
    // 모두 닫혀있음
    // N: 1 ~ 21억
    // 반복문 기반의 연산은 불가
    // 상태 저장 후 한 번에 연산하는 작업 불가
    // -> 수열 방식과 같은 일정한 규칙이 존재할 것으로 판단
    // -> 약수의 개수가 홀수일 때 열려있는 상태로 종결
    // -> 제곱근이 정수일 경우에만 약수의 개수가 홀수
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        int targetNumber = (int) Math.sqrt(N);
        sb.append(targetNumber).append("\n");

        System.out.print(sb);
    }
}
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
// 1 2 2 3 2 4 2 4 3 4  2  6  2  4  4  5
// 1 0 0 1 0 0 0 0 1 0  0  0  0  0  0  1