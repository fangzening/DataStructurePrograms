// sorting algorithm
// selection sort, time: O(n^2) space O(1)
// 挡板 【0， i） sorted， 【i，n-1】 to be sorted 
class Solution{
    public void selectionSort(int[] array){
        if(array == null || array.length <= 1){
            return;
        }
        for(int i = 0; i < array.length -1; i++){
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }
    private void swap(int[]array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}

public class sorting{
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] array = {9, 7, 8};
        sol.selectionSort(array);
        for(int x: array){
            System.out.println(x);
        }
    }
}