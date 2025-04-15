package skillladder.level27_binary_search;

/**
 * 문제
 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
 *
 * 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
 *
 * 출력
 * 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
 *
 * 예제 입력 1
 * 10
 * 6 3 2 10 10 10 -10 -10 7 3
 * 8
 * 10 9 -5 2 3 4 5 -10
 * 예제 출력 1
 * 3 0 0 1 2 0 0 2
 */

import java.util.*;
import java.io.*;

public class P10816 {
    // 목적: 배열에서 요소 조회 후 개수 반환
    // 유의:
    // 구하기 문제
    // lower/upper bound 문제
    // N -> 5* 10^5, M-> 5* 10^5
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st1.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] arrM = new int[M];
            for (int i=0; i<M; i++){
                arrM[i] = Integer.parseInt(st2.nextToken());
            }
            Arrays.sort(arr);
            for (int i=0; i<M; i++){
                int targetValue = arrM[i];
                int lower = lowerBound(arr, 0, arr.length-1, targetValue);
                if (lower!=-1){
                    int upper = upperBound(arr, 0, arr.length-1, targetValue);
                    int ans = upper - lower;
                    sb.append(ans+" ");
                } else {
                    sb.append(0+" ");
                }
            }

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // lower bound
    public static int lowerBound(int[] arr, int l, int r, int targetValue){
        if (l-r==0){
            if (arr[l]==targetValue){
                return l;
            }
            return -1;
        }
        int mid = l + (r - l)/2;
        if (targetValue>arr[mid]){
            return lowerBound(arr, mid+1, r, targetValue);
        } else {
            return lowerBound(arr, l, mid, targetValue);
        }
    }
    // upper bound
    public static int upperBound(int[] arr, int l, int r, int targetValue){
        if (l-r==0){
            if (arr[l]==targetValue){
                return l+1;
            } else {
                return l;
            }
        }
        int mid = l + (r - l)/2;
        if (targetValue>=arr[mid]){
            return upperBound(arr, mid+1, r, targetValue);
        } else {
            return upperBound(arr, l, mid, targetValue);
        }
    }
}
