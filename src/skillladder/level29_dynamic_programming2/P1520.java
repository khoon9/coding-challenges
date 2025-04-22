package skillladder.level29_dynamic_programming2;

/**
 *문제
 * 여행을 떠난 세준이는 지도를 하나 구하였다. 이 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 한 칸은 한 지점을 나타내는데 각 칸에는 그 지점의 높이가 쓰여 있으며, 각 지점 사이의 이동은 지도에서 상하좌우 이웃한 곳끼리만 가능하다.
 *
 *
 *
 * 현재 제일 왼쪽 위 칸이 나타내는 지점에 있는 세준이는 제일 오른쪽 아래 칸이 나타내는 지점으로 가려고 한다. 그런데 가능한 힘을 적게 들이고 싶어 항상 높이가 더 낮은 지점으로만 이동하여 목표 지점까지 가고자 한다. 위와 같은 지도에서는 다음과 같은 세 가지 경로가 가능하다.
 *
 *
 *
 * 지도가 주어질 때 이와 같이 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 항상 내리막길로만 이동하는 경로의 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에는 지도의 세로의 크기 M과 가로의 크기 N이 빈칸을 사이에 두고 주어진다. 이어 다음 M개 줄에 걸쳐 한 줄에 N개씩 위에서부터 차례로 각 지점의 높이가 빈 칸을 사이에 두고 주어진다. M과 N은 각각 500이하의 자연수이고, 각 지점의 높이는 10000이하의 자연수이다.
 *
 * 출력
 * 첫째 줄에 이동 가능한 경로의 수 H를 출력한다. 모든 입력에 대하여 H는 10억 이하의 음이 아닌 정수이다.
 *
 * 예제 입력 1
 * 4 5
 * 50 45 37 32 30
 * 35 50 40 20 25
 * 30 30 25 17 28
 * 27 24 22 15 10
 * 예제 출력 1
 * 3
 */

import java.util.*;
import java.io.*;

public class P1520 {
    // 목표: 내리막 길 경우의 수 구하기
    // 유의:
    // 구하기 문제
    // 높 -> 더 낮은 곳 -> 조건에 따라 상하좌우 순회시, 이전 탐색 부분으로 다시 돌아가지 않음
    // -> 즉, dp상 상태 표현을 현재 위치 row, col 만으로 구성 가능
    // dp[row][col] 의미 -> row, col 에서 출발해서 목적지까지 가는 경우의 수를 저장
    // 단위: 경우의 수 최대 10억 ->  int
    public static int[][] dp;
    public static int[][] arrow = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st1.nextToken());
            int N = Integer.parseInt(st1.nextToken());
            int[][] arr = new int[M][N];
            dp = new int[M][N];

            for (int i=0; i<M; i++){
                for (int j=0; j<N; j++){
                    dp[i][j] = -1;
                }
            }
            for (int i=0; i<M; i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st2.nextToken());
                }
            }
            int cnt = function(arr, 0, 0);
            sb.append(cnt);

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static int function(int[][] arr, int row, int col) {
        if (dp[row][col] != -1){
            return dp[row][col];
        }
        if (row==arr.length-1 && col==arr[0].length-1){
            dp[row][col] = 1;
            return dp[row][col];
        }
        int cnt = 0;
        for (int i=0; i<4; i++){
            if (row+arrow[i][0]>=0 && row+arrow[i][0]<arr.length && col+arrow[i][1]>=0 && col+arrow[i][1]<arr[0].length){
                if (arr[row+arrow[i][0]][col+arrow[i][1]]<arr[row][col]){
                    cnt += function(arr, row+arrow[i][0], col+arrow[i][1]);
                }
            }
        }
        dp[row][col] = cnt;
        return dp[row][col];
    }
}
