package binary_search;

class Search2DMatrix {
    public static String searchMatrix(int[][] matrix, int target) {
        int[]res=new int[2];
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return "False";

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / cols][mid % cols]; // Convert 1D index to 2D indices

            if (midValue == target) {
                res[0] = mid/cols;
                res[1] = mid%cols;
                String result="True ";
                result+=res[0];
                result+=" ,";
                result+=res[1];
                return result;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "False"; // Target not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 16;

        String result = searchMatrix(matrix, target);
        System.out.println(result);
    }
}
