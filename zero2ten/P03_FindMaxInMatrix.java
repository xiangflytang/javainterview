package zero2ten;

public class P03_FindMaxInMatrix {
    /*
    规律从右上角开始：
    如果该数字大于目标，向左col --;
    如果该数字小于目标，向下row ++;
    直到要找到的数字，或者查找范围已为空。
    * @param matrix 待查找数组
    * @param number 要查找的数
    * @return 查找结果， true为找到，false没找到。
    *
    *
     */
    public static boolean find(int[][] matrix, int number) {
        //输入的条件判断。
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        //要查找的在数组之内
        int totalCol = matrix[0].length;
        int totalRow = matrix.length;

        int currCol = matrix[0].length - 1;
        int currRow = 0;
        while (currCol >= 0 && currCol <= totalCol - 1 && currRow >= 0 && currRow <= totalRow-1) {
            if (matrix[currRow][currCol] == number) {
                return true;
            } else if (matrix[currRow][currCol] < number) {
                currRow++;
            } else {
                currCol--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(matrix,7));
        System.out.println(find(matrix,5));
        System.out.println(find(matrix,1));
        System.out.println(find(matrix,15));
        System.out.println(find(matrix,16));
        System.out.println(find(matrix,-1));
        System.out.println(find(null,-1));
    }
}
