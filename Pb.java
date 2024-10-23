package project1;

public class Pb {
    public static void changeTwoElement(int[] array,int e1,int e2,int index1,int index2){
        array[index1] = e2;
        array[index2] = e1;
    }
    public static void quickSort(int[] a, int lo, int hi){
        int low, high, pivotNumber;
        low = lo;
        high = hi;
        // this if statement make sure when the low >= high, Stop the iteration
        if(low >= high){
            return;
        }
        // set the first number is the pivotNumber
        pivotNumber = a[low];
        while(low<high) {
            // find the number of greater than pivotNumber
            while (pivotNumber < a[high] && high>low) {
                high--;
            }
            // find the number of less than or equal to pivotNumber
            while (pivotNumber >= a[low] && low<high) {
                low++;
            }
            // exchange these two number
            if(low<high){
                Pb.changeTwoElement(a, a[high], a[low], high, low);
            }
        }
        Pb.changeTwoElement(a, a[lo], a[low], lo, low);
        // Quick sort for the part less than the reference value
        quickSort(a,lo,low-1);
        // Quick sort for portions that are larger than the reference value
        quickSort(a,high+1,hi);
    }
    public static void quickSort2D(int[][] a, int lo, int hi){
        for(int i = 0; i < a.length; i++){
            quickSort(a[i],lo,hi);
        }
    }
}
class testToProjectB{
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

        // testCase1 sorted by quickSort print
        System.out.print("The testCase1 sorted by quickSort is: ");
        Pb.quickSort(testCase1,0,testCase1.length-1);
        for(int i = 0; i < testCase1.length; i++){
            System.out.print(testCase1[i]+" ");
        }
        System.out.println();

        // testCase2 sorted by quickSort2D print
        System.out.println("The testCase2 sorted by quickSort2D is: ");
        Pb.quickSort2D(testCase2,0,testCase2[0].length-1);
        for(int i = 0; i < testCase2.length; i++){
            for(int j = 0; j < testCase2[i].length;j++){
                System.out.print(testCase2[i][j] + " ");
            }
            System.out.println();
        }
    }
}