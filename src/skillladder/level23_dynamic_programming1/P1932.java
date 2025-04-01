package skillladder.level23_dynamic_programming1;

/**
 *문제
 *         7
 *       3   8
 *     8   1   0
 *   2   7   4   4
 * 4   5   2   6   5
 * 위 그림은 크기가 5인 정수 삼각형의 한 모습이다.
 *
 * 맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
 *
 * 삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.
 *
 * 입력
 * 첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.
 *
 * 출력
 * 첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.
 *
 * 예제 입력 1
 * 5
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 * 예제 출력 1
 * 30
 */

import java.util.*;
import java.io.*;

public class P1932 {
    // 목적: 최대합 구하기
    // 유의: 이전 상태 기준 왼쪽 대각선 혹은 오른쪽 대각선으로 이동 가능
    // 왼쪽으로 붙이면, 아래 혹은 오른쪽 대각선으로 취급 가능
    // 이전 상태(index)와 현재 높이
    // -> 현재 row, 현재 col 기준으로 변경
    private static int[][] cacheArray;
    private static int[][] board;
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            cacheArray = new int[n][n];
            board = new int[n][n];
            for (int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<=i; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i=0; i<n; i++){
                for (int j=0; j<=i; j++){
                    cacheArray[i][j] = -1;
                }
            }
            function1(0,0);
            sb.append(cacheArray[0][0]);

            System.out.println(sb);
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public static int function1(int row, int col){
        if (cacheArray[row][col]!=-1){
            return cacheArray[row][col];
        }
        if (row==cacheArray.length-1){
            cacheArray[row][col] = board[row][col];
            return cacheArray[row][col];
        }
        int maxValue;
        maxValue = board[row][col] + function1(row+1,col+1);
        int targetValue = board[row][col] + function1(row+1,col);
        maxValue = (targetValue>maxValue? targetValue: maxValue);
        cacheArray[row][col] = maxValue;
        return cacheArray[row][col];
    }
}
