package project1;
public class Pc {
    public static void merge(int[] arr, int start, int middle, int end){
        // create an all 0 same size array
        int[] temArr = new int[arr.length];
        // store start, middle and start in s,m and i
        int s = start;
        int m = middle;
        int i = start;
        // Start by comparing the first digit of the two parts and place the smaller digit into the new array
        while(s <= middle && m + 1 <= end){
            if(arr[s] < arr[m + 1]){
                temArr[i] = arr[s];
                i++;
                s++;
            }else {
                temArr[i] = arr[m + 1];
                i++;
                m++;
            }
        }
        // If the right part is arranged, add the remaining digits on the left to the new array
        while(s<=middle){
            temArr[i] = arr[s];
            s++;
            i++;
        }
        // If the left part is arranged, add the remaining numbers on the right to the new array
        while (m+1<=end){
            temArr[i] = arr[m + 1];
            m++;
            i++;
        }
        // store the sorted array in arr
        for(int j = start; j <= end;j++){
            arr[j] = temArr[j];
        }
    }
    public static void mergeSort(int[] arr1, int left, int right){
        if (left < right){
            // iterate over binary arrays until each array has only one number
            int middle = (left + right)/2;
            mergeSort(arr1,left,middle);
            mergeSort(arr1,middle+1,right);
            // Sort the two arrays into one array using mergesort
            merge(arr1,left,middle,right);
        }
    }
    public static void mergeSort2D(int[][] arr,int left,int right){
        for(int i = 0; i < arr.length; i++){
            mergeSort(arr[i],left,right);
        }
    }
}
class testToProjectC{
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

        // testCase1 sorted by mergeSort print
        Pc.mergeSort(testCase1,0,testCase1.length-1);
        System.out.print("The testCase1 sorted by mergeSort is: ");
        for(int i = 0; i < testCase1.length; i++){
            System.out.print(testCase1[i]+" ");
        }
        System.out.println();

        // testCase2 sorted by mergeSort2D print
        System.out.println("The testCase2 sorted by mergeSort2D is: ");
        Pc.mergeSort2D(testCase2,0,testCase2[0].length-1);
        for(int i = 0; i < testCase2.length; i++){
            for(int j = 0; j < testCase2[i].length;j++){
                System.out.print(testCase2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
