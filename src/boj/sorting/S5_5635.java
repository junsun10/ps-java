// 생일 ( 정답 )
// 알고리즘: 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class S5_5635 {

    public static class Student {
        String name;
        int year;
        int month;
        int day;

        public Student(String name, int year, int month, int day) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    static int n;
    static ArrayList<Student> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            arr.add(new Student(name, year, month, day));
        }

        Collections.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.year < o2.year) {
                    return 1;
                }
                else if (o1.year > o2.year) {
                    return -1;
                }
                else {
                    if (o1.month < o2.month) {
                        return 1;
                    }
                    else if (o1.month > o2.month) {
                        return -1;
                    }
                    else {
                        return o2.day - o1.day;
                    }
                }
            }
        });

        System.out.println(arr.get(0).name);
        System.out.println(arr.get(n-1).name);
    }
}
