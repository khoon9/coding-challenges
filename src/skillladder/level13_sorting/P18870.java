package skillladder.level13_sorting;

/**
 *문제
 * 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
 *
 * Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
 *
 * X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
 *
 * 입력
 * 첫째 줄에 N이 주어진다.
 *
 * 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
 *
 * 출력
 * 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
 *
 * 제한
 * 1 ≤ N ≤ 1,000,000
 * -109 ≤ Xi ≤ 109
 * 예제 입력 1
 * 5
 * 2 4 -10 4 -9
 * 예제 출력 1
 * 2 3 0 3 1
 * 예제 입력 2
 * 6
 * 1000 999 1000 999 1000 999
 * 예제 출력 2
 * 1 0 1 0 1 0
 */

import java.util.*;
import java.io.*;

public class P18870 {
    // 좌표 압축 방식
    // 0 ~ 개수
    // 같은 좌표 발생 시 같은 값 지정. 가장 작은 값부터 차례로 지정
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            List<int[]> targetValues = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++){
                targetValues.add(new int[]{Integer.parseInt(st.nextToken()),i});
            }
            targetValues.sort(
                    Comparator.comparingInt((int[] targetValue)->targetValue[0])
            );
            int now_value = -1;
            int before_targetValue = Integer.MIN_VALUE;
            for (int[] targetValue: targetValues){
                if (before_targetValue!=targetValue[0]){
                    now_value++;
                    before_targetValue = targetValue[0];
                    targetValue[0] = now_value;
                } else {
                    targetValue[0] = now_value;
                }
            }
            targetValues.sort(
                    Comparator.comparingInt((int[] targetValue)->targetValue[1])
            );
            targetValues.stream().forEach((int[] targetValue)->sb.append(targetValue[0]+" "));

            System.out.println(sb);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
