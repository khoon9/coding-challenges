package skillladder.level23_dynamic_programming1;

/**
 *문제
 * 두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다. 합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.
 *
 * 예를 들어, < 그림 1 >과 같이 전깃줄이 연결되어 있는 경우 A의 1번 위치와 B의 8번 위치를 잇는 전깃줄, A의 3번 위치와 B의 9번 위치를 잇는 전깃줄, A의 4번 위치와 B의 1번 위치를 잇는 전깃줄을 없애면 남아있는 모든 전깃줄이 서로 교차하지 않게 된다.
 *
 *
 *
 * < 그림 1 >
 *
 * 전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다. 전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때, 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에는 두 전봇대 사이의 전깃줄의 개수가 주어진다. 전깃줄의 개수는 100 이하의 자연수이다. 둘째 줄부터 한 줄에 하나씩 전깃줄이 A전봇대와 연결되는 위치의 번호와 B전봇대와 연결되는 위치의 번호가 차례로 주어진다. 위치의 번호는 500 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없다.
 *
 * 출력
 * 첫째 줄에 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력한다.
 *
 * 예제 입력 1
 * 8
 * 1 8
 * 3 9
 * 2 2
 * 4 1
 * 6 4
 * 10 10
 * 9 7
 * 7 6
 * 예제 출력 1
 * 3
 */

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class P2565 {
    // 목표: (교차 전깃줄 중 일부 없애서 교차 없도록 할 때) 없앨 전깃줄 개수 최소값
    // 유의:
    // 전깃줄 -> 함수 A -> B 영역 에서 조합 문제와 유사
    // A idx 가 순차적으로 증가할 때, B값이 오름차순 이어야 겹치지 않음
    // 즉, 오름차순 수열 최대 길이 문제로 치환. A에서의 값은 정렬 후 idx로 사용
    // 수열 최대 길이 구한 후, (n - 최대 길이)가 답
    private static int[] cache;
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            List<int[]> targetArray = new ArrayList<>();
            for (int i=0; i<n; i++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                targetArray.add(new int[]{
                        Integer.parseInt(st1.nextToken()),
                        Integer.parseInt(st1.nextToken())
                });
            }
            Collections.sort(targetArray, Comparator.comparing(
                    target->target[0]
            ));
            int[] targetArrays2 = targetArray.stream()
                    .mapToInt(target->target[1])
                    .toArray();
            int maxValue = 1;
            for (int i=0; i<n; i++){
                cache = new int[n];
                function1(n, i, targetArrays2);
                maxValue = (cache[i]>maxValue? cache[i]: maxValue);
            }
            int answer = n - maxValue;
            sb.append(answer);

            System.out.println(sb);
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    // 오름차순 수열 최대 길이를 구하기 위해 사용될 함수
    public static int function1(int n, int x, int[] targetArrays2){
        if (cache[x]!=0){
            return cache[x];
        }
        if (x==n-1){
            cache[x] = 1;
            return cache[x];
        }
        int maxValue = 1;
        for (int i=1; i+x<n; i++){
            if (targetArrays2[i+x]>targetArrays2[x]){
                int targetValue = 1 + function1(n, i+x, targetArrays2);
                maxValue = (targetValue>maxValue? targetValue: maxValue);
            }
        }
        cache[x] = maxValue;
        return cache[x];
    }
}
