package algorithm.sort;

/*heapInsert和heaptify是堆排序中最重要的两个操作*/
public class HeapSort {
    public static void main(String[] args) {
        int []arr=new int[]{2,5,12,0,-3,45,233,1,8};
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void heapSort(int[] arr){
        if(arr==null||arr.length<2){
            return ;
        }
        //一开始需要将整个数组变成大根堆
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int heapSize=arr.length;
        swap(arr,0,--heapSize); //此时已经得到一个大根堆，将数组第一个数（也就是大根堆的顶，也就是最大的数）与最后面的数进行交换，然后将heapSize--
        //只要大根堆的长度不是零，就一直对这个堆进行大根话，之所以如此是因为经过上一步的交换之后，现在的堆不一定是大根堆了
        while(heapSize>0){
            heaptify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
        
    }

    //该方法的功能是，从当前节点开始向下进行大根堆化。
    private static void heaptify(int[] arr, int index, int heapSize) {
        int left=index*2+1;
        while(left<heapSize){

            //如果有左右孩子的话，获取两个左右孩子中的最大值
            int largest=left+1<heapSize&&arr[left+1]>arr[left]?left+1:left;

            //比较父节点和左右孩子中的最大值
            largest=arr[largest]>arr[index]?largest:index;
            if(largest==index){
                break;
            }

            swap(arr,largest,index);
            index=largest;
            left=index*2+1; //不断的向下进行大根堆化

        }
    }

    //该方法的功能是，从当前节点开始向节点的上面进行大根堆化
    private static void heapInsert(int[] arr, int index) {
        while(arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;  //向上进行大根堆化,交换完之后向上跑
        }
    }


    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
