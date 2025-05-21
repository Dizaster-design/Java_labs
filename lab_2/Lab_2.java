import java.util.*;

public class Lab_2 {

    // 1. Наибольшая подстрока без повторяющихся символов
    public static String longestUniqueSubstring(String s) {
        int start = 0, maxLen = 0, maxStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                maxStart = start;
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    // 2. Объединение двух отсортированных массивов
    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            result[k++] = a[i] < b[j] ? a[i++] : b[j++];
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }

    // 3. Максимальная сумма подмассива (алгоритм Кадане)
    public static int maxSubarraySum(int[] nums) {
        int maxSum = nums[0], currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    // 4. Поворот массива на 90 градусов по часовой стрелке
    public static int[][] rotateRight90(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] rotated = new int[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                rotated[j][n - 1 - i] = matrix[i][j];
        return rotated;
    }

    // 5. Пара элементов, сумма которых равна target
    public static int[] findPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return new int[]{complement, num};
            }
            seen.add(num);
        }
        return null;
    }

    // 6. Сумма всех элементов в двумерном массиве
    public static int sum2DArray(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix)
            for (int num : row)
                sum += num;
        return sum;
    }

    // 7. Максимум в каждой строке двумерного массива
    public static int[] maxInEachRow(int[][] matrix) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int max = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) max = matrix[i][j];
            }
            result[i] = max;
        }
        return result;
    }

    // 8. Поворот массива на 90 градусов против часовой стрелки
    public static int[][] rotateLeft90(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] rotated = new int[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                rotated[m - 1 - j][i] = matrix[i][j];
        return rotated;
    }

    // Выводы
    public static void main(String[] args) {
        System.out.println("1. Longest Unique Substring:");
        System.out.println(longestUniqueSubstring("abcabcbb")); // Вывод: "abc"

        System.out.println("\n2. Merge Sorted Arrays:");
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6}))); // [1, 2, 3, 4, 5, 6]

        System.out.println("\n3. Max Subarray Sum:");
        System.out.println(maxSubarraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6

        System.out.println("\n4. Rotate Right 90:");
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        for (int[] row : rotateRight90(matrix)) System.out.println(Arrays.toString(row));
        // [5, 3, 1]
        // [6, 4, 2]

        System.out.println("\n5. Find Pair With Sum 10:");
        int[] pair = findPairWithSum(new int[]{1, 2, 3, 7, 5}, 10);
        if (pair != null) System.out.println(Arrays.toString(pair));
        else System.out.println("null");

        System.out.println("\n6. Sum of 2D Array:");
        System.out.println(sum2DArray(new int[][]{{1, 2}, {3, 4}})); // 10

        System.out.println("\n7. Max in Each Row:");
        System.out.println(Arrays.toString(maxInEachRow(new int[][]{{1, 5, 3}, {9, 2, 4}}))); // [5, 9]

        System.out.println("\n8. Rotate Left 90:");
        for (int[] row : rotateLeft90(matrix)) System.out.println(Arrays.toString(row));
        // [2, 4, 6]
        // [1, 3, 5]
    }
}
