package skillladder.level29_dynamic_programming2;

/**
 * 문제
 * 양팔 저울과 몇 개의 추가 주어졌을 때, 이를 이용하여 입력으로 주어진 구슬의 무게를 확인할 수 있는지를 결정하려고 한다.
 *
 * 무게가 각각 1g과 4g인 두 개의 추가 있을 경우, 주어진 구슬과 1g 추 하나를 양팔 저울의 양쪽에 각각 올려놓아 수평을 이루면 구슬의 무게는 1g이다. 또 다른 구슬이 4g인지를 확인하려면 1g 추 대신 4g 추를 올려놓으면 된다.
 *
 * 구슬이 3g인 경우 아래 <그림 1>과 같이 구슬과 추를 올려놓으면 양팔 저울이 수평을 이루게 된다. 따라서 각각 1g과 4g인 추가 하나씩 있을 경우 주어진 구슬이 3g인지도 확인해 볼 수 있다.
 *
 *
 *
 * <그림 1> 구슬이 3g인지 확인하는 방법 (
 * $\boxed{1}$은 1g인 추,
 * $\boxed{4}$는 4g인 추, ●은 무게를 확인할 구슬)
 *
 * <그림 2>와 같은 방법을 사용하면 구슬이 5g인지도 확인할 수 있다. 구슬이 2g이면 주어진 추를 가지고는 확인할 수 없다.
 *
 * 추들의 무게와 확인할 구슬들의 무게가 입력되었을 때, 주어진 추만을 사용하여 구슬의 무게를 확인 할 수 있는지를 결정하는 프로그램을 작성하시오.
 *
 *
 *
 * <그림 2> 구슬이 5g인지 확인하는 방법
 *
 * 입력
 * 첫째 줄에는 추의 개수가 자연수로 주어진다. 추의 개수는 30 이하이다. 둘째 줄에는 추의 무게들이 자연수로 가벼운 것부터 차례로 주어진다. 같은 무게의 추가 여러 개 있을 수도 있다. 추의 무게는 500g이하이며, 입력되는 무게들 사이에는 빈칸이 하나씩 있다. 세 번째 줄에는 무게를 확인하고자 하는 구슬들의 개수가 주어진다. 확인할 구슬의 개수는 7이하이다. 네 번째 줄에는 확인하고자 하는 구슬들의 무게가 자연수로 주어지며, 입력되는 무게들 사이에는 빈 칸이 하나씩 있다. 확인하고자 하는 구슬의 무게는 40,000보다 작거나 같은 자연수이다.
 *
 * 출력
 * 주어진 각 구슬의 무게에 대하여 확인이 가능하면 Y, 아니면 N 을 차례로 출력한다. 출력은 한 개의 줄로 이루어지며, 각 구슬에 대한 답 사이에는 빈칸을 하나씩 둔다.
 *
 * 예제 입력 1
 * 2
 * 1 4
 * 2
 * 3 2
 * 예제 출력 1
 * Y N
 * 예제 입력 2
 * 4
 * 2 3 3 3
 * 3
 * 1 4 10
 * 예제 출력 2
 * Y Y N
 */

import java.util.*;
import java.io.*;

public class P2629 {
    // 목표: 추가 주어졌을 때, 각 구슬 무게 판단 가능 여부 출력하기 문제
    // 유의:
    // 저울 양쪽에 구슬 하나(필수)와 추 가능한 만큼 배치(양쪽에 구슬 또는 추가 하나 이상 존재, 추는 모두 사용하지 않아도 됨)했을 때
    // 양쪽이 수평을 이루는 경우를 발견할 경우 성공
    // 경우의 수 -> 매우 많음
    // 상태 -> 한 쪽에 어떤 요소가 있는 상태인지 -> 2^30 -> 10^9 까지도 되므로 불가
    // 추 -> A 방향, B 방향, 넣지 않는다 -> 총 3가지 선택
    // 추 무게 M -> -M, +M, 0
    // 구슬 무게 G -> 초기에 -G
    // 3^30 -> 10^12 -> 개별 취급시 불가 -> 상태 따라서 dp 지정 가능?
    // 현재 value, index 가 주어졌을 때, 가불 여부에 대해 알 수 있다면? -> 전체 순회 방식으로
    // 70000*30 -> 10^6 -> 가능
    // 70000 -> -55000 ~ 14999
    private static int[][] dp;
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st1.nextToken());
            }
            int T = Integer.parseInt(br.readLine());
            int[] arrT = new int[T];
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i=0; i<T; i++){
                arrT[i] = Integer.parseInt(st2.nextToken());
            }
            for (int i=0; i<T; i++){
                // 70000 -> -55000 ~ 14999
                dp = new int[N][70000];
                boolean target = function(arr, -arrT[i], 0);
                sb.append((target?"Y":"N")+" ");
            }

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static boolean function(int[] arr, int w, int idx) {
        if (w==0){
            return true;
        }
        if (idx == arr.length){
            return false;
        }
        if (dp[idx][w+55000]!=0){
            return dp[idx][w+55000]==1;
        }
        boolean flag = false;
        for (int i=0; i<3; i++){
            if (function(arr, w+(i-1)*arr[idx], idx+1)){
                flag = true;
                break;
            }
        }
        if (flag){
            dp[idx][w+55000] = 1;
        } else {
            dp[idx][w+55000] = -1;
        }
        return dp[idx][w+55000]==1;
    }
}
