package project1;

public class Pd {
    public static void bucketSort(int[] arr){
        // find the minimum value
        int min = arr[0];
        for(int i = 0; i < arr.length;i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        // find the maximum value
        int max = arr[0];
        for(int i = 0; i < arr.length;i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        // create a bucket to put the element in (In this program I set the interval to 1)
        int[] bucket = new int[max-min+1];
        int[] temArr = new int[arr.length];
        // put the number in each bucket
        for(int i = 0; i < arr.length; i++){
            bucket[arr[i]-min]++;
        }
        // take the element out and join them to get the sorted array
        int j = 0;
        for (int i = 0; i < bucket.length; i++){
            if(bucket[i]!=0){
                for(int a = 0; a < bucket[i]; a++){
                    temArr[j] = i + min;
                    j++;
                }
            }
        }
        // store the sorted array in arr
        for(int i = 0; i < arr.length;i++){
            arr[i] = temArr[i];
        }
    }
    public static void bucketSort2D(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            Pd.bucketSort(arr[i]);
        }
    }
}
class testToProjectD{
    public static void main(String[] args) {
        int[] testCase1 = new int[]{31,33,27,15,42,11,40,5,19,21};
        // testCase1 print
        System.out.print("The initial testCase1 is: ");
        for (int i = 0; i < testCase1.length; i++){
            System.out.print(testCase1[i] + " ");
        }
        System.out.println();

        int[][] testCase2 = new int[][]{
                {98,34,100,36,44,64,3,99,59},
                {20,88,55,91,14,58,25,29,44},
                {66,62,4,65,49,71,71,24,12},
                {14,3,58,23,12,66,11,45,36},
                {55,64,35,24,85,73,33,85,46},
                {94,76,23,36,57,26,8,92,17},
                {85,68,52,34,53,93,4,37,34},
                {70,9,15,42,31,16,72,61,62},
                {11,38,34,21,81,9,45,68,11},
                {20,83,27,6,69,26,5,31,8},
                {74,97,11,60,1,68,14,27,46}};
        // testCase2 print
        System.out.println("The initial testCase2 is: ");
        for(int i = 0; i < testCase2.length; i++){
            for(int j = 0; j < testCase2[i].length;j++){
                System.out.print(testCase2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // testCase1 sorted by bucket print
        Pd.bucketSort(testCase1);
        System.out.print("The testCase1 sorted by bucket is: ");
        for(int i = 0; i < testCase1.length; i++){
            System.out.print(testCase1[i]+" ");
        }
        System.out.println();

        // testCase2 sorted by bucketSort2D print
        System.out.println("The testCase2 sorted by bucketSort2D is: ");
        Pd.bucketSort2D(testCase2);
        for(int i = 0; i < testCase2.length; i++){
            for(int j = 0; j < testCase2[i].length;j++){
                System.out.print(testCase2[i][j] + " ");
            }
            System.out.println();
        }
    }
}

