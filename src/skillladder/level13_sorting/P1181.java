package skillladder.level13_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *문제
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 *
 * 길이가 짧은 것부터
 * 길이가 같으면 사전 순으로
 * 단, 중복된 단어는 하나만 남기고 제거해야 한다.
 *
 * 입력
 * 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
 *
 * 출력
 * 조건에 따라 정렬하여 단어들을 출력한다.
 *
 * 예제 입력 1
 * 13
 * but
 * i
 * wont
 * hesitate
 * no
 * more
 * no
 * more
 * it
 * cannot
 * wait
 * im
 * yours
 * 예제 출력 1
 * i
 * im
 * it
 * no
 * but
 * more
 * wait
 * wont
 * yours
 * cannot
 * hesitate
 */

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class P1181 {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            List<String> targetList = new ArrayList<>();
            for (int i=0; i<N; i++){
                targetList.add(br.readLine());
            }
            targetList.sort(
                    Comparator.comparing((String targetString)->targetString.length())
                            .thenComparing(targetString->targetString)
            );
            targetList = targetList.stream().distinct().collect(Collectors.toList());
            targetList.stream().forEach((targetValue)->sb.append(targetValue+"\n"));

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
