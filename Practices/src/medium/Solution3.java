package medium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution3 {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        // System.out.println(indexMap);
        int result = 0;

        for(int index = 0 ; index < q.length ; index++ ){
            int diff = q[index] - (index+1);

            if(diff <= 0){
                for(int j = Math.max(0, q[index] - 2) ; j < index ; j++){
                    if(q[j] > q[index])
                        result++;
                }
            } else if(diff > 2){
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(result);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
