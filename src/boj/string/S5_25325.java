// 학생 인기도 측정

package boj.string;

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
    static Student[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new Student[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = new Student(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {

            }
        }
    }
}
