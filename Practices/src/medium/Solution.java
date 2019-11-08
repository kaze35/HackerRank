import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        if(scores == null || alice == null){
            return null;
        }

        int scoresSize = scores.length;
        int aliceSize = alice.length;
        int ranks[] = new int[scoresSize];
        int aliceRanks[] = new int[aliceSize];
        int rank = 1;
        int previousNumber = scores[0];


        for(int i = 0 ; i < scoresSize ; i++){
            if(previousNumber != scores[i])
                ranks[i] = ++rank;
            else
                ranks[i] = rank;

            previousNumber = scores[i];
        }

        int lastIndex = aliceSize - 1;

        for(int j = 0 ; lastIndex >= 0 ;){
            if(alice[lastIndex] >= scores[j]) {
                aliceRanks[lastIndex--] = ranks[j];
            }
            else if(j == scoresSize - 1){
                aliceRanks[lastIndex--] = ranks[j]+1;
            }else{
                j++;
            }

            if(j == scoresSize)
                --j;
        }

        return aliceRanks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
