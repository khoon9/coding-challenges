package skillladder.level23_dynamic_programming1;

/**
 *문제
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 *
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 *
 * 입력
 * 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
 *
 * 출력
 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 *
 * 예제 입력 1
 * 2
 * 예제 출력 1
 * 1
 * 예제 입력 2
 * 10
 * 예제 출력 2
 * 3
 */

import java.util.*;

public class P1463 {
    // 목표: (주어진 수를 1로 만드는) 최소 연산횟수 수하기
    // 유의:
    // 3 가지 연산 중 선택 가능
    private static int[] cache;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = scanner.nextInt();
        cache = new int[n+1];
        function(n);
        sb.append(cache[n]);

        System.out.println(sb);
    }
    public static int function(int x){
        if (x==1){
            return 0;
        }
        if (cache[x] != 0){
            return cache[x];
        }
        int minValue = 1 + function(x-1);
        if (x%3==0){
            int tarvetValue = 1 + function(x/3);
            minValue = (tarvetValue<minValue? tarvetValue: minValue);
        }
        if (x%2==0){
            int tarvetValue = 1 + function(x/2);
            minValue = (tarvetValue<minValue? tarvetValue: minValue);
        }
        cache[x] = minValue;
        return cache[x];
    }
}
