package algorithm.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int []arr=new int[]{2,5,12,0,-3,45,233,1,8};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] arr){
        if(arr==null||arr.length<2) return;

        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
