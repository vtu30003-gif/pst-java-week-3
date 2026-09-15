import java.io.*;
import java.util.*;

public class Solution {

    public static List<Long> maxSubarray(List<Long> arr) {

        // Maximum contiguous subarray sum
        long current = arr.get(0);
        long maxSubarray = arr.get(0);

        // Maximum subsequence sum
        long maxSubsequence = 0;
        long largest = arr.get(0);

        for (long x : arr) {

            // Largest single element
            if (x > largest) {
                largest = x;
            }

            // Maximum subsequence
            if (x > 0) {
                maxSubsequence += x;
            }
        }

        // If all elements are negative
        if (maxSubsequence == 0) {
            maxSubsequence = largest;
        }

        // Kadane's algorithm
        for (int i = 1; i < arr.size(); i++) {
            long x = arr.get(i);

            current = Math.max(x, current + x);
            maxSubarray = Math.max(maxSubarray, current);
        }

        return Arrays.asList(maxSubarray, maxSubsequence);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            List<Long> arr = new ArrayList<>();

            while (arr.size() < n) {

                String line = br.readLine();

                if (line == null) {
                    break;
                }

                StringTokenizer st =
                    new StringTokenizer(line);

                while (st.hasMoreTokens()) {
                    arr.add(Long.parseLong(st.nextToken()));
                }
            }

            List<Long> result = maxSubarray(arr);

            System.out.println(
                result.get(0) + " " + result.get(1)
            );
        }

        br.close();
    }
}
