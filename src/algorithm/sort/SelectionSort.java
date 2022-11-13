package algorithm.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int []arr=new int[]{2,5,12,0,-3,45,233,1,8};
        selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    //选择排序的原理
    // 0 ~ N-1  找到最小值，在哪，放到0位置上
    // 1 ~ n-1  找到最小值，在哪，放到1 位置上
    // 2 ~ n-1  找到最小值，在哪，放到2 位置上
    public static void selectionSort(int[] arr){
        if(arr==null||arr.length<2){
            return ;
        }
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                minIndex=arr[j]<arr[minIndex]?j:minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
