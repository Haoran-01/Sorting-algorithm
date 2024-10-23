package project1;

public class Pa{
    public static int[] selectionSort(int[] test){
        int[] sortedArray = test.clone();
        int times = 0;
        for(int i = 0; i < test.length; i++){
            int theIndex = 0;
            int largest = sortedArray[0];
            for(int j = 0; j < test.length-times; j++){
                if(largest < sortedArray[j]){
                    largest = sortedArray[j];
                    theIndex = j;
                }
            }
            int exchangeElement = sortedArray[test.length-times-1];
            sortedArray[test.length - times-1] = largest;
            sortedArray[theIndex] = exchangeElement;
            times++;
        }
        return sortedArray;
    }
    public static int[][] selectionSort2D(int[][] test){
        int[][] sortedArray = test.clone();
        int times = 0;
        for(int i = 0; i < test.length; i++){
            int theIndex = 0;
            int largest = sortedArray[0][0];
            for(int j = 0; j < test.length-times; j++){
                if(largest < sortedArray[j][0]){
                    largest = sortedArray[j][0];
                    theIndex = j;
                }
            }
            int[] exchangeElement = sortedArray[test.length-times-1];
            sortedArray[test.length - times-1] = sortedArray[theIndex];
            sortedArray[theIndex] = exchangeElement;
            times++;
        }
        return sortedArray;
    }
    public static void changeTwoElement(int[] array,int e1,int e2,int index1,int index2){
        if(e1>e2){
            array[index1] = e2;
            array[index2] = e1;
        }
    }
    public static void changeTwoArray(int[][] array,int[] e1,int[] e2,int index1,int index2){
        if(e1[0]>e2[0]){
            array[index1] = e2;
            array[index2] = e1;
        }
    }
    public static int[] insertionSort(int[] test){
        for(int i = 1; i < test.length; i++){
            if(i==1){
                Pa.changeTwoElement(test,test[i-1],test[i],0,i);
            }else{
                for(int theIndex = i;theIndex>0;theIndex--){
                    Pa.changeTwoElement(test,test[theIndex-1],test[theIndex],theIndex-1,theIndex);
                }
            }
        }
        return test;
    }
    public static int[][] insertionSort2D(int[][] test){
        for(int i = 1; i < test.length; i++){
            if(i==1){
                Pa.changeTwoArray(test,test[i-1],test[i],0,i);
            }else{
                for(int theIndex = i;theIndex>0;theIndex--){
                    Pa.changeTwoArray(test,test[theIndex-1],test[theIndex],theIndex-1,theIndex);
                }
            }
        }
        return test;
    }
}
class testToProjectA{
    public static void main(String[] args) {
        int[] testA = new int[]{1, 62, 81, 0, 23, 55, 76, 87, 20, 54, 65, 76, 1};
        int[][] testB = new int[][]{{71,2},{64,8},{31,56},{98,1},{3,6},{59,837},{49,58},{61,8}};

        // testA print
        System.out.print("The initial testA is: ");
        for (int i = 0; i < testA.length; i++){
            System.out.print(testA[i]+" ");
        }
        System.out.println();

        // testA sorted by selectionSort print
        int[] selectionSortedTestA = Pa.selectionSort(testA);
        System.out.print("The testA sorted by selection sort is: ");
        for (int i = 0; i < selectionSortedTestA.length;i++){
            System.out.print(selectionSortedTestA[i]+" ");
        }
        System.out.println();

        // testA sorted by insertionSort print
        int[] insertionSortedTestA = Pa.insertionSort(testA);
        System.out.print("The testA sorted by insertion sort is: ");
        for (int i = 0; i < insertionSortedTestA.length;i++){
            System.out.print(insertionSortedTestA[i]+" ");
        }
        System.out.println();

        // testB print
        System.out.print("The initial testB is: ");
        for (int i = 0; i < testB.length;i++){
            System.out.print("("+testB[i][0] + " " + testB[i][1]+")"+" ");
        }
        System.out.println();
        int[][] selectionSortedTestB = Pa.selectionSort2D(testB);
        int[][] insertionSortedTestB = Pa.insertionSort2D(testB);

        // testB sorted by selectionSorted print
        System.out.print("The testB sorted by selectionSorted is: ");
        for (int i = 0; i < selectionSortedTestB.length;i++){
            System.out.print("("+selectionSortedTestB[i][0] + " " + selectionSortedTestB[i][1]+")"+" ");
        }
        System.out.println();

        // testB sorted by insertionSorted print
        System.out.print("The testB sorted by insertionSorted is: ");
        for (int i = 0; i < insertionSortedTestB.length;i++){
            System.out.print("("+insertionSortedTestB[i][0] + " " + insertionSortedTestB[i][1]+")"+" ");
        }
        System.out.println();
    }
}