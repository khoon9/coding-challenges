package skillladder.level08_basic_math1;

/**
 *문제
 *
 * (BOJ 2292 그림 참고)
 *
 * 위의 그림과 같이 육각형으로 이루어진 벌집이 있다. 그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다. 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오. 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.
 *
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.
 *
 * 출력
 * 입력으로 주어진 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나는지 출력한다.
 *
 * 예제 입력 1
 * 13
 * 예제 출력 1
 * 3
 */

import java.util.*;

public class P2292 {
    // N: ~10억
    // 중앙을 기준으로 육각형 꼴로 동일한 껍질을 이루는 층은 중앙으로부터 같은 거리를 갖는다
    // 1  6  12 18 24
    // 1  2  3  4  5
    // a_n = a_(n-1) + 6 (n>2)
    // a_2 = a_1 + 5
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int roomCnt = 0;
        int a_n = 0;
        while (N>0){
            if (a_n==0){
                a_n += 1;
                N -= a_n;
                roomCnt++;
            } else if (a_n==1){
                a_n += 5;
                N -= a_n;
                roomCnt++;
            } else{
                a_n += 6;
                N -= a_n;
                roomCnt++;
            }
        }
        System.out.println(roomCnt);
    }
}
