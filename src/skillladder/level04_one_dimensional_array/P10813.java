package skillladder.level04_one_dimensional_array;

/**
 * 문제
 * 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다. 바구니에는 공이 1개씩 들어있고, 처음에는 바구니에 적혀있는 번호와 같은 번호가 적힌 공이 들어있다.
 *
 * 도현이는 앞으로 M번 공을 바꾸려고 한다. 도현이는 공을 바꿀 바구니 2개를 선택하고, 두 바구니에 들어있는 공을 서로 교환한다.
 *
 * 공을 어떻게 바꿀지가 주어졌을 때, M번 공을 바꾼 이후에 각 바구니에 어떤 공이 들어있는지 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
 *
 * 둘째 줄부터 M개의 줄에 걸쳐서 공을 교환할 방법이 주어진다. 각 방법은 두 정수 i j로 이루어져 있으며, i번 바구니와 j번 바구니에 들어있는 공을 교환한다는 뜻이다. (1 ≤ i ≤ j ≤ N)
 *
 * 도현이는 입력으로 주어진 순서대로 공을 교환한다.
 *
 * 출력
 * 1번 바구니부터 N번 바구니에 들어있는 공의 번호를 공백으로 구분해 출력한다.
 *
 * 예제 입력 1
 * 5 4
 * 1 2
 * 3 4
 * 1 4
 * 2 2
 * 예제 출력 1
 * 3 1 4 2 5
 */

import java.util.*;
import java.io.*;

public class P10813 {
    // 공을 서로 바꿀 바구니의 위치로 입력받은 각 순서는 -1 이후 index로 사용 가능
    // 바구니에 든 공의 기본 값으로, 각 바구니의 index 마다 +1 한 값을 사용하여 초기화 진행
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        int M = Integer.parseInt(first_line[1]);

        List<Integer> bucket = new ArrayList<>();

        for (int i=0; i<N; i++){
            bucket.add(i+1);
        }

        for (int i=0; i<M; i++){
            String[] input_line = br.readLine().split(" ");
            int first_idx = Integer.parseInt(input_line[0]) - 1;
            int second_idx = Integer.parseInt(input_line[1]) - 1;

            int temp = bucket.get(first_idx);
            bucket.set(first_idx, bucket.get(second_idx));
            bucket.set(second_idx, temp);
        }

        for (int i=0; i<N; i++){
            sb.append(bucket.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
