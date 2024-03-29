// 학생 인기도 측정 ( 정답 )
// 알고리즘: 맵, 정렬

package boj.hash;

import java.io.*;
import java.util.*;

public class S5_25325 {

    static class Student {
        String name;
        int count = 0;

        public Student(String name) {
            this.name = name;
        }
    }

    static int n;
    static HashMap<String, Student> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            String name = st.nextToken();
            map.put(name, new Student(name));
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                String name = st.nextToken();
                map.get(name).count += 1;
            }
        }

        solution();
    }

    static void solution() {
        Student[] arr = new Student[n];
        int index = 0;
        for (Student student : map.values()) {
            arr[index] = student;
            index += 1;
        }

        Arrays.sort(arr, new Comparator<Student>() {
            @Override
            public int compare (Student o1, Student o2) {
                if (o1.count == o2.count) {
                    return o1.name.compareTo(o2.name);
                }
                else {
                    return o2.count - o1.count;
                }
            }
        });

        for (Student student : arr) {
            System.out.printf("%s %d\n", student.name, student.count);
        }
    }
}
