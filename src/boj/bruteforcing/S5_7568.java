// 덩치 ( 정답 )
// 알고리즘: 브루트포스
// 몸무게와 키 순으로 정렬한 뒤 등수 계산
// 단순히 2중 for문으로도 가능

package boj.bruteforcing;

import java.io.*;
import java.util.*;

public class S5_7568 {

    static class Person implements Comparable<Person> {
        int w, h, index;

        Person (int w, int h, int index) {
            this.w = w;
            this.h = h;
            this.index = index;
        }

        @Override
        public int compareTo(Person p) {
            if (this.w > p.w && this.h > p.h) {
                return -1;
            }
            else if (this.w > p.w) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        ArrayList<Person> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.add(new Person(x,y,i));
        }

        Collections.sort(arr);

        int[] answer = new int[n];
        answer[arr.get(1).index] = 1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (arr.get(j).w > arr.get(i).w && arr.get(j).h > arr.get(i).h) {
                    count += 1;
                }
            }
            answer[arr.get(i).index] = count+1;
        }

        for (Integer integer : answer) {
            System.out.print(integer+" ");
        }
    }
}
