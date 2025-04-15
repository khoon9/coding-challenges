package skillladder.level27_binary_search;

/**
 * 문제
 * 도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.
 *
 * 도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다. 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고, 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.
 *
 * C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다. 둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.
 *
 * 출력
 * 첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.
 *
 * 예제 입력 1
 * 5 3
 * 1
 * 2
 * 8
 * 4
 * 9
 * 예제 출력 1
 * 3
 */

import java.util.*;
import java.io.*;

public class P2110 {
    // 목표: (최소 인접 거리) 최댓값 구하기
    // 유의:
    // 동일 좌표 없음
    // 설치 -> (최소 인접 거리) 최대화
    // (N 개 중 C 개 선택 후 구해낸 최소 인접 거리) 최대화
    // 단위: 좌표 10^9
    // 특정 지점을 선택. 이게 선택한 지점을 지준으로 좌 우 판별 가능?
    // 그리디 방식이라면 선택 과정에서 값 임의지정 가능
    // 단순 탐색이라면 O(N^2) 불가하므로 안 됨
    // 설치 위치 선택 가짓수 nCc 너무 방대함
    // 만약 해당 거리를 미리 정하고 그 거리 이상의 값을 가지는 대상만 연결로 선택할 수 있도록 구성하는 방식이라면
    // -> O(N) -> 최소 인접 거리를 미리 설정함으로써, 설치 위치를 선택하는데에 있어서 간단한 조건으로 선택이 가능해짐
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int i=0; i<N; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            long left = 0;
            long right = 1000000000;
            long maxValue = 0;
            while (left<=right){
                long mid = (left + right)/2;
                if (check(arr, mid, C)){
                    maxValue = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(maxValue);
            
            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // 주어진 최소 인접 거리를 기준으로 공유기를 C개 배치할 수 있는지 반환
    private static boolean check(int[] arr, long mid, int c) {
        int beforeValue = -1000000000;
        int cnt = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]-beforeValue>=mid){
                cnt++;
                beforeValue = arr[i];
            }
        }
        return cnt>=c;
    }
}
