package algorithm.sort;

public class QuickSort {
    public static void main(String[] args) {
        int []arr=new int[]{2,5,12,0,-3,45,233,1,8};
        quickSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr) {
        if(arr==null || arr.length<2){
            return ;
        }
        process(arr,0,arr.length-1);
    }


    public static void process(int arr[],int L,int R){
        if(L>=R){
            return ;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea=partition(arr,L,R);
        process(arr,L,equalArea[0]-1);
        process(arr,equalArea[1]+1,R);
    }


    public static int[] partition(int[] arr, int L,int R){
        if(L>R){
            return new int[] {-1,-1};
        }
        if(L==R){
            return new int[]{L,R};
        }
        int less=L-1;   //小于区的结束位置，开始的时候肯定设置为-1
        int more=R;
        int index=L;
        while(index<more){
            if(arr[index]==arr[R]){ //如果当前值等于最右边的值，就不做交换，将index向后移动
                index++;
            }else if(arr[index]<arr[R]){    //如果当前值小于枢值，即将其余小于区的后一个交换，小于区域向后扩充一个位置
                swap(arr,index++,++less);
            }else {                 //如果当前值大于枢值，就将其与大于区域的前一个进行交换，大于区向前扩充一个位置
                swap(arr,index,--more); //但是由于这里的index是刚刚交换过来的，所以不急着向后移动
            }
        }

        swap(arr,more,R);
        return new int[]{less+1,more};  //返回值是小于区的右边界和大于区域的左边界
    }

    public static void swap(int arr[],int L,int R){
        int temp=arr[L];
        arr[L]=arr[R];
        arr[R]=temp;

    }
}
