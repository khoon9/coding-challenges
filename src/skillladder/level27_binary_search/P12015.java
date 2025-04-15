package skillladder.level27_binary_search;

/**
 * 문제
 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
 *
 * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
 *
 * 입력
 * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.
 *
 * 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000,000)
 *
 * 출력
 * 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
 *
 * 예제 입력 1
 * 6
 * 10 20 10 30 20 50
 * 예제 출력 1
 * 4
 */

import java.util.*;
import java.io.*;

public class P12015 {
    // 목표: 최장 증가 부분 수열 길이 구하기
    // 유의:
    // 단위:
    // N 10^6 요소 10^6
    // 시간 복잡도 O(N^2) 이상이면 못 풂
    // target 값 판단 -> dp에 저장된 값들보다 큰 수 -> dp에 저장
    // 그 외의 경우 -> dp에서 해당 숫자 이상이면서 가장 큰 수를 찾아 target 값으로 대체한다. -> logN 요구
    // 해당 방법 적절성 판별:
    // dp를 기준으로, 다음으로 가능한 값 중 가장 작은 값이 무엇인지 알 수 있다.
    // 탐색 알고리즘 입력/출력 예시
    // [ 1, 3, 5 ] 8 -> 2, 3 -> 0, 1 -> -1, 5 -> 1
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer> dp = new ArrayList<>();
            for (int i=0; i<N; i++) {
                int targetIdx = findIdx(dp, arr[i]) + 1;
                if (targetIdx==dp.size()){
                    dp.add(targetIdx, arr[i]);
                } else {
                    dp.set(targetIdx, arr[i]);
                }
            }
            sb.append(dp.size());

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static int findIdx(List<Integer> dp, int targetValue){
        int left = 0;
        int right = dp.size()-1;
        int targetIdx = -1;
        while (left<=right){
            int mid = (left + right)/2;
            if (dp.get(mid)<targetValue){
                targetIdx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return targetIdx;
    }
}
