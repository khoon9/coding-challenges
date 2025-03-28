package skillladder.level23_dynamic_programming1;

/**
 *문제
 * 효주는 포도주 시식회에 갔다. 그 곳에 갔더니, 테이블 위에 다양한 포도주가 들어있는 포도주 잔이 일렬로 놓여 있었다. 효주는 포도주 시식을 하려고 하는데, 여기에는 다음과 같은 두 가지 규칙이 있다.
 *
 * 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
 * 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
 * 효주는 될 수 있는 대로 많은 양의 포도주를 맛보기 위해서 어떤 포도주 잔을 선택해야 할지 고민하고 있다. 1부터 n까지의 번호가 붙어 있는 n개의 포도주 잔이 순서대로 테이블 위에 놓여 있고, 각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오.
 *
 * 예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때, 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.
 *
 * 입력
 * 첫째 줄에 포도주 잔의 개수 n이 주어진다. (1 ≤ n ≤ 10,000) 둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양이 순서대로 주어진다. 포도주의 양은 1,000 이하의 음이 아닌 정수이다.
 *
 * 출력
 * 첫째 줄에 최대로 마실 수 있는 포도주의 양을 출력한다.
 *
 * 예제 입력 1
 * 6
 * 6
 * 10
 * 13
 * 9
 * 8
 * 1
 * 예제 출력 1
 * 33
 */

import java.util.*;
import java.io.*;

public class P2156 {
    // 목표: 최대한 많은 양(의 포두주 마시기)
    // 유의
    // 마시는 3개의 잔이 근접해있으면 안 됨
    // 연속 상태 제약/위치
    // 꼭 마지막 잔을 마실 필요는 없고, 단지 중간 잔까지만 마셔도 된다.
    // main에서도 함수 호출 예외 처리 필요
    // 건너뛰는 위치를 꼭 idx+2로 할 필요 없음. 바로 idx+k (k>2)로 갈 수도 있음
    private static int[][] cache;
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            int[] targetArray = new int[n];
            cache = new int[3][n];
            for (int i=0; i<n; i++){
                targetArray[i] = Integer.parseInt(br.readLine());
            }
            for (int i=0; i<3; i++){
                for (int j=0; j<n; j++) {
                    cache[i][j] = -1;
                }
            }
            if (n>1){
                function1(n, 1, 0, targetArray);
                function1(n, 1, 1, targetArray);
                sb.append(Math.max(cache[1][0], cache[1][1]));
            } else{
                function1(n, 1, 0, targetArray);
                sb.append(cache[1][0]);
            }

            System.out.println(sb);
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public static int function1(int n, int seqNum, int idx, int[] targetArray){
        if (cache[seqNum][idx] != -1){
            return cache[seqNum][idx];
        }
        if (idx==n-1){
            cache[seqNum][idx] = targetArray[idx];
            return cache[seqNum][idx];
        }
        int maxValue = targetArray[idx];

        for (int i=1; i<(n-idx); i++){
            int targetValue;
            if (i==1){
                if (seqNum!=2){
                    targetValue = targetArray[idx] + function1(n, seqNum+1, idx+i, targetArray);
                    maxValue = (targetValue>maxValue? targetValue: maxValue);
                    continue;
                } else {
                    maxValue = (targetArray[idx]>maxValue? targetArray[idx]:maxValue);
                    continue;
                }
            }
            targetValue = targetArray[idx] + function1(n, 1, idx+i, targetArray);
            maxValue = (targetValue>maxValue? targetValue: maxValue);
        }
        cache[seqNum][idx] = maxValue;

        return cache[seqNum][idx];
    }
}
