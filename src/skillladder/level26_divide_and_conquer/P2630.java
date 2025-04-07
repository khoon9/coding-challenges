package skillladder.level26_divide_and_conquer;

/**
 *문제
 * 아래 <그림 1>과 같이 여러개의 정사각형칸들로 이루어진 정사각형 모양의 종이가 주어져 있고, 각 정사각형들은 하얀색으로 칠해져 있거나 파란색으로 칠해져 있다. 주어진 종이를 일정한 규칙에 따라 잘라서 다양한 크기를 가진 정사각형 모양의 하얀색 또는 파란색 색종이를 만들려고 한다.
 *
 *
 *
 * 전체 종이의 크기가 N×N(N=2k, k는 1 이상 7 이하의 자연수) 이라면 종이를 자르는 규칙은 다음과 같다.
 *
 * 전체 종이가 모두 같은 색으로 칠해져 있지 않으면 가로와 세로로 중간 부분을 잘라서 <그림 2>의 I, II, III, IV와 같이 똑같은 크기의 네 개의 N/2 × N/2색종이로 나눈다. 나누어진 종이 I, II, III, IV 각각에 대해서도 앞에서와 마찬가지로 모두 같은 색으로 칠해져 있지 않으면 같은 방법으로 똑같은 크기의 네 개의 색종이로 나눈다. 이와 같은 과정을 잘라진 종이가 모두 하얀색 또는 모두 파란색으로 칠해져 있거나, 하나의 정사각형 칸이 되어 더 이상 자를 수 없을 때까지 반복한다.
 *
 * 위와 같은 규칙에 따라 잘랐을 때 <그림 3>은 <그림 1>의 종이를 처음 나눈 후의 상태를, <그림 4>는 두 번째 나눈 후의 상태를, <그림 5>는 최종적으로 만들어진 다양한 크기의 9장의 하얀색 색종이와 7장의 파란색 색종이를 보여주고 있다.
 *
 *
 *
 * 입력으로 주어진 종이의 한 변의 길이 N과 각 정사각형칸의 색(하얀색 또는 파란색)이 주어질 때 잘라진 하얀색 색종이와 파란색 색종이의 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에는 전체 종이의 한 변의 길이 N이 주어져 있다. N은 2, 4, 8, 16, 32, 64, 128 중 하나이다. 색종이의 각 가로줄의 정사각형칸들의 색이 윗줄부터 차례로 둘째 줄부터 마지막 줄까지 주어진다. 하얀색으로 칠해진 칸은 0, 파란색으로 칠해진 칸은 1로 주어지며, 각 숫자 사이에는 빈칸이 하나씩 있다.
 *
 * 출력
 * 첫째 줄에는 잘라진 햐얀색 색종이의 개수를 출력하고, 둘째 줄에는 파란색 색종이의 개수를 출력한다.
 *
 * 예제 입력 1
 * 8
 * 1 1 0 0 0 0 1 1
 * 1 1 0 0 0 0 1 1
 * 0 0 0 0 1 1 0 0
 * 0 0 0 0 1 1 0 0
 * 1 0 0 0 1 1 1 1
 * 0 1 0 0 1 1 1 1
 * 0 0 1 1 1 1 1 1
 * 0 0 1 1 1 1 1 1
 * 예제 출력 1
 * 9
 * 7
 */

import java.util.*;
import java.io.*;

public class P2630 {
    // 목표: 쿼드 트리 방식으로 나누어졌을 때, 흰색과 파란색 leaf 노드의 개수 구하기
    // 유의:
    // 입력 N -> 2^k
    // 범위가 주어짐 -> 만약 하나라도 다른 부분 발생 시에 범위 4분할 후 재귀호출 수행
    // leaf node에 대해 카운팅 -> 전역 변수로 수행
    private static boolean[][] board;
    private static int whiteCnt = 0;
    private static int blueCnt = 0;
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            board = new boolean[n][n];
            for (int i=0; i<n; i++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++){
                    board[i][j] = st1.nextToken().equals("1");
                }
            }
            function1(0, 0, n, new QuadTreeNode(false, null));
            sb.append(whiteCnt+"\n"+blueCnt);

            System.out.println(sb);
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // 범위 나누고 자식 노드 설정 후 호출. 혹은 주어진 노드 leaf 노드로 판결
    public static void function1(int row, int col, int sideSize, QuadTreeNode node){
        boolean isLeaf = true;
        boolean firstPlaceColor = board[row][col];
        for (int i=0; i<sideSize; i++){
            if (!isLeaf){
                break;
            }
            for (int j=0; j<sideSize; j++){
                if (firstPlaceColor!=board[row+i][col+j]){
                    isLeaf = false;
                    break;
                }
            }
        }
        if (isLeaf){
            node.isLeaf = true;
            node.isBlue = firstPlaceColor;
            if (node.isBlue){
                blueCnt++;
            } else {
                whiteCnt++;
            }
        } else {
            node.child[0] = new QuadTreeNode(isLeaf, null);
            function1(row, col, sideSize/2, node.child[0]);
            node.child[1] = new QuadTreeNode(isLeaf, null);
            function1(row+sideSize/2, col, sideSize/2, node.child[1]);
            node.child[2] = new QuadTreeNode(isLeaf, null);
            function1(row, col+sideSize/2, sideSize/2, node.child[2]);
            node.child[3] = new QuadTreeNode(isLeaf, null);
            function1(row+sideSize/2, col+sideSize/2, sideSize/2, node.child[3]);
        }
    }
}

class QuadTreeNode {
    Boolean isLeaf;
    Boolean isBlue;
    QuadTreeNode[] child = new QuadTreeNode[4];
    QuadTreeNode(Boolean isLeaf, Boolean isBlue){
        this.isLeaf = isLeaf;
        this.isBlue = isBlue;
    }
}