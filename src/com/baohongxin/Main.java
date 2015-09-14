package com.baohongxin;

import java.util.Arrays;
import java.util.HashMap;

class Point implements Comparable<Point>{
    int value;
    int type;
    Point(int v, int t) {
        value = v;
        type = t;
    }
    public int compareTo(Point p) {
        if (this.value == p.value) {
            return 0;
        } else if (this.value > p.value) {
            return 1;
        } else {
            return -1;
        }
    }
}

class Interval {
    int start;
    int end;
    Interval(int a, int b) {
        start = a;
        end = b;
    }
}

public class Main {
    static int[] twoSum(int[] A, int target) {
        int[] res = {-1, -1};
        if (A == null || A.length < 2) return res;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            hm.put(A[i], i);
        }
        for (int i = 0; i < A.length; i++) {
            if (hm.containsKey(target - A[i]) && target != 2 * A[i]) {
                res[0] = i;
                res[1] = hm.get(target - A[i]);
                break;
            }
        }
        return res;
    }
    static int getOverlappingcount(Interval[] A) {
        int max = 0, count = 1;
        if (A == null || A.length == 0) return max;
        Point[] points = new Point[A.length * 2];
        for (int i = 0; i < A.length; i++) {
            points[2 * i] = new Point(A[i].start, 0);
            points[2 * i + 1] = new Point(A[i].end, 1);

        }
        Arrays.sort(points);
        for (int i = 0; i < points.length; i++) {
            if (points[i].type == 0) {
                count++;
                max = Math.max(max, count);
            } else {
                count--;
            }
        }
        return max;
    }

    static boolean hasSum(int[] A, int target) {
        boolean res = false;
        if (A == null || A.length < 2) return res;
        Arrays.sort(A);
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] + A[j] == target) {
                res = true;
                break;
            } else if (A[i] + A[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
	    // write your code here
        //No. 001 O(nlogn)
        int[] intArray = {3, 7, 2, 5, 1};
        System.out.println(hasSum(intArray, 8));
        //No. 002 O(n)
        int[] resArray = twoSum(intArray, 8);
        System.out.println(resArray[0]);
        System.out.println(resArray[1]);
        //No. 006 O(nlogn)
        Interval it1 = new Interval(1, 5);
        Interval it2 = new Interval(10, 15);
        Interval it3 = new Interval(5, 10);
        Interval it4 = new Interval(20, 30);
        Interval[] itArray = {it1, it2, it3, it4};
        System.out.println(getOverlappingcount(itArray));
    }
}
