package skillladder.level04_one_dimensional_array;

/**
 * 문제
 * 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다. 또, 1번부터 N번까지 번호가 적혀있는 공을 매우 많이 가지고 있다. 가장 처음 바구니에는 공이 들어있지 않으며, 바구니에는 공을 1개만 넣을 수 있다.
 *
 * 도현이는 앞으로 M번 공을 넣으려고 한다. 도현이는 한 번 공을 넣을 때, 공을 넣을 바구니 범위를 정하고, 정한 바구니에 모두 같은 번호가 적혀있는 공을 넣는다. 만약, 바구니에 공이 이미 있는 경우에는 들어있는 공을 빼고, 새로 공을 넣는다. 공을 넣을 바구니는 연속되어 있어야 한다.
 *
 * 공을 어떻게 넣을지가 주어졌을 때, M번 공을 넣은 이후에 각 바구니에 어떤 공이 들어 있는지 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
 *
 * 둘째 줄부터 M개의 줄에 걸쳐서 공을 넣는 방법이 주어진다. 각 방법은 세 정수 i j k로 이루어져 있으며, i번 바구니부터 j번 바구니까지에 k번 번호가 적혀져 있는 공을 넣는다는 뜻이다. 예를 들어, 2 5 6은 2번 바구니부터 5번 바구니까지에 6번 공을 넣는다는 뜻이다. (1 ≤ i ≤ j ≤ N, 1 ≤ k ≤ N)
 *
 * 도현이는 입력으로 주어진 순서대로 공을 넣는다.
 *
 * 출력
 * 1번 바구니부터 N번 바구니에 들어있는 공의 번호를 공백으로 구분해 출력한다. 공이 들어있지 않은 바구니는 0을 출력한다.
 *
 * 예제 입력 1
 * 5 4
 * 1 2 3
 * 3 4 4
 * 1 4 1
 * 2 2 2
 * 예제 출력 1
 * 1 2 1 1 0
 */

import java.io.*;
import java.util.*;

public class P10810{
    public static void main(String[] args) throws IOException{
        // 입력 받은 바구니의 범위는 index 관계상 -1을 수행
        // k 값(공의 번호)은 그대로 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        int M = Integer.parseInt(first_line[1]);

        List<Integer> bucket = new ArrayList<>(Collections.nCopies(N,0));

        for (int i=0; i<M; i++){
            String[] second_line = br.readLine().split(" ");
            int stard_index = Integer.parseInt(second_line[0]) - 1;
            int end_index = Integer.parseInt(second_line[1]) - 1;
            int ball_number = Integer.parseInt(second_line[2]);

            for (int j=stard_index; j<=end_index; j++){
                bucket.set(j,ball_number);
            }
        }

        for (int i=0; i<bucket.size(); i++){
            sb.append(bucket.get(i)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
