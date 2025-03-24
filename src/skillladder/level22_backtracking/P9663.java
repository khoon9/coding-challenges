package skillladder.level22_backtracking;

/**
 *문제
 * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
 *
 * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N이 주어진다. (1 ≤ N < 15)
 *
 * 출력
 * 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
 *
 * 예제 입력 1
 * 8
 * 예제 출력 1
 * 92
 */

import java.util.*;

public class P9663 {
    private static int targetCnt = 0;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        int[][] targetArray = new int[N][2];
        for (int i=0; i<N; i++){
            for (int j=0; j<2; j++){
                targetArray[i][j] = -1;
            }
        }
        findTargetCnt(N, N, 0, targetArray);
        sb.append(targetCnt);

        System.out.println(sb);
    }
    // 백트래킹
    public static void findTargetCnt(int N, int M, int nowY, int[][] v){
        if (M==0){
            targetCnt++;
            return;
        }

        for (int i=0; i<N; i++){
            if (checkState(i, nowY, v)){
                v[nowY][0] = i;
                v[nowY][1] = nowY;
                findTargetCnt(N, M-1, nowY+1, v);
                v[nowY][0] = -1;
                v[nowY][1] = -1;
            }
        }
    }
    public static boolean checkState(int x, int nowY,int[][] v){
        for (int[] targetValue: v){
            if (targetValue[0]==-1 && targetValue[1]==-1){
                break;
            }
            if (x==targetValue[0]){
                return false;
            }
            if ((targetValue[0]-(nowY-targetValue[1]))==x){
                return false;
            }
            if ((targetValue[0]+(nowY-targetValue[1]))==x){
                return false;
            }
        }
        return true;
    }
}
