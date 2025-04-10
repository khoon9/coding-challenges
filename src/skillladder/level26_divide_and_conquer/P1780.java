package skillladder.level26_divide_and_conquer;

/**
 *문제
 * N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다. 우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.
 *
 * 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
 * (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
 * 이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.
 *
 * 출력
 * 첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
 *
 * 예제 입력 1
 * 9
 * 0 0 0 1 1 1 -1 -1 -1
 * 0 0 0 1 1 1 -1 -1 -1
 * 0 0 0 1 1 1 -1 -1 -1
 * 1 1 1 0 0 0 0 0 0
 * 1 1 1 0 0 0 0 0 0
 * 1 1 1 0 0 0 0 0 0
 * 0 1 -1 0 1 -1 0 1 -1
 * 0 -1 1 0 1 -1 0 1 -1
 * 0 1 -1 1 0 -1 0 1 -1
 * 예제 출력 1
 * 10
 * 12
 * 11
 */

import java.util.*;
import java.io.*;

public class P1780 {
    // 목표: 쿼드 트리 유사 -> 9등분 트리 순회 -> leaf 노드 value별 개수 구하기
    // 유의:
    // 구현하기 문제
    // leaf node -> 카운팅
    // now leaf node -> 9분할 재귀호출 수행
    // 크기 범위 -> (3^7)^2 < (9^4)^2 < (10^4)^2 -> 10^8 : int 범위 이내
    private static int[][] board;
    private static int minusOneCnt = 0;
    private static int zeroCnt = 0;
    private static int oneCnt = 0;
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            for (int i=0; i<n; i++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++) {
                    board[i][j] = Integer.parseInt(st1.nextToken());
                }
            }
            function1(0, 0, n);
            sb.append(minusOneCnt+"\n");
            sb.append(zeroCnt+"\n");
            sb.append(oneCnt+"\n");

            System.out.println(sb);
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void function1(int row, int col, int sideSize){
        int targetValue = board[row][col];
        for (int i=0; i<sideSize; i++){
            for (int j=0; j<sideSize; j++) {
                if (targetValue!=board[row+i][col+j]){
                    int miniSideSize = sideSize/3;
                    for (int k=0; k<3; k++){
                        for (int l=0; l<3; l++){
                            function1(row+k*miniSideSize, col+l*miniSideSize, miniSideSize);
                        }
                    }
                    return;
                }
            }
        }
        switch (targetValue){
            case -1:
                minusOneCnt++;
                break;
            case 0:
                zeroCnt++;
                break;
            case 1:
                oneCnt++;
                break;
            default:
                break;
        }
    }
}
