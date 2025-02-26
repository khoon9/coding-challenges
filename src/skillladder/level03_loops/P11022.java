package skillladder.level03_loops;

/**
 * 문제
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 *
 * 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
 *
 * 출력
 * 각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다. x는 테스트 케이스 번호이고 1부터 시작하며, C는 A+B이다.
 *
 * 예제 입력 1
 * 5
 * 1 1
 * 2 3
 * 3 4
 * 9 8
 * 5 2
 * 예제 출력 1
 * Case #1: 1 + 1 = 2
 * Case #2: 2 + 3 = 5
 * Case #3: 3 + 4 = 7
 * Case #4: 9 + 8 = 17
 * Case #5: 5 + 2 = 7
 */

import java.io.*;

public class P11022 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        for (int i=0; i<num; i++){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            sb.append("Case #").append(i+1).append(": ").append(a).append(" + ").append(b).append(" = ").append(a+b).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
