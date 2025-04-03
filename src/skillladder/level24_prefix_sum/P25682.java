package skillladder.level24_prefix_sum;

/**
 *문제
 * 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 K×K 크기의 체스판으로 만들려고 한다.
 *
 * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
 *
 * 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 K×K 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 당연히 K×K 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 정수 N, M, K가 주어진다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.
 *
 * 출력
 * 첫째 줄에 지민이가 잘라낸 K×K 보드를 체스판으로 만들기 위해 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
 *
 * 제한
 * 1 ≤ N, M ≤ 2000
 * 1 ≤ K ≤ min(N, M)
 * 예제 입력 1
 * 4 4 3
 * BBBB
 * BBBB
 * BBBW
 * BBWB
 * 예제 출력 1
 * 2
 * 예제 입력 2
 * 8 8 8
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBBBWBW
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBWBWBW
 * 예제 출력 2
 * 1
 * 예제 입력 3
 * 10 13 10
 * BBBBBBBBWBWBW
 * BBBBBBBBBWBWB
 * BBBBBBBBWBWBW
 * BBBBBBBBBWBWB
 * BBBBBBBBWBWBW
 * BBBBBBBBBWBWB
 * BBBBBBBBWBWBW
 * BBBBBBBBBWBWB
 * WWWWWWWWWWBWB
 * WWWWWWWWWWBWB
 * 예제 출력 3
 * 30
 * 예제 입력 4
 * 9 23 9
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBBBBBBBBB
 * BBBBBBBBBBBBBBBWWWWWWWW
 * 예제 출력 4
 * 40
 */

import java.util.*;
import java.io.*;

public class P25682 {
    // 목표: 고쳐야하는 개수 최소값 구하기
    // 유의
    // k*k 잘라낸 이후 체스판과의 차이 최솟값 구하기
    // (N*M)^2 -> 10^12 근접하므로 방법 고안 필요
    // -> prefixW 와 prefixB 정의 후 각 영역에 대한 누적합 영역 최솟값구하기
    // arr: true -> Black, false -> White
    // prefixW -> prefixW[0][0]이 White로 시작하는 체스판 기준 차이 누적합
    // prefixB -> prefixB[0][0]이 Black로 시작하는 체스판 기준 차이 누적합
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());
            int k = Integer.parseInt(st1.nextToken());
            boolean[][] arr = new boolean[n+1][m+1];
            int[][] prefixW = new int[n+1][m+1];
            int[][] prefixB = new int[n+1][m+1];
            for (int i=1; i<=n; i++){
                char[] target = br.readLine().toCharArray();
                for (int j=1; j<=m; j++){
                    arr[i][j] = (target[j-1]=='B'? true: false);
                    prefixW[i][j] = -prefixW[i-1][j-1]
                            + prefixW[i-1][j]
                            + prefixW[i][j-1]
                            + ((i+j)%2==0? (arr[i][j]==true? 1: 0): (arr[i][j]==false? 1: 0));
                    prefixB[i][j] = -prefixB[i-1][j-1]
                            + prefixB[i-1][j]
                            + prefixB[i][j-1]
                            + ((i+j)%2==1? (arr[i][j]==true? 1: 0): (arr[i][j]==false? 1: 0));
                }
            }
            int[][] prefix;
            int minValue = n*m;
            prefix = prefixW;
            for (int i=0; i<=n-k; i++){
                for (int j=0; j<=m-k; j++){
                    int targetValue = prefix[i][j]
                            - prefix[i+k][j]
                            - prefix[i][j+k]
                            + prefix[i+k][j+k];
                    minValue = Math.min(targetValue, minValue);
                }
            }
            prefix = prefixB;
            for (int i=0; i<=n-k; i++){
                for (int j=0; j<=m-k; j++){
                    int targetValue = prefix[i][j]
                            - prefix[i+k][j]
                            - prefix[i][j+k]
                            + prefix[i+k][j+k];
                    minValue = Math.min(targetValue, minValue);
                }
            }
            sb.append(minValue);

            System.out.println(sb);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
