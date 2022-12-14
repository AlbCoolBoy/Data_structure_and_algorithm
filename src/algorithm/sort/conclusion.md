## 对于几个重要排序的总结

#### HeapSort堆排序
原理：

根据大根堆的性质，如果创建了一个大根堆，那么该二叉树的第一个节点一定是最大值。
所以，将一个数组转换为大根堆，并不断的将大根堆最顶端的元素放在数组的倒数第一个，第二个...，第n
个位置，那么得到的数组一定就是有序的

实现方式：

- 两个重要的方法：heapInsert和heaptify

- heapInsert方法的功能是根据给定的数组的元素，不断的向上构建大根堆，保证以上的元素构成的二叉树一定是一个大根堆

- heaptify方法的功能是根据给定的节点，不断地向下构建大根堆，也就是不断的与其子节点进行大小比较，如果出现问题就进行交换，创建出一个大根堆

- 在有了上述两个方法之后，堆排序就可以进行了

- 先将数组从第一个元素开始，使用heapInsert方法不断的去构建大根堆，直到数组中的每一个元素都加入到了大根堆中。这时候数组就被转换成一种大根堆的结构。这时候大根堆的大小heapSize等于数组的大小

- 然后将第一数（也就是大根堆的第一个节点，一定是最大值）与数组的最后一个元素进行交换。交换完成之后，最后面的数就不用再参与排序了。

- 所以将heapSize--，再使用heaptify方法从当前节点开始进行大根堆化，得到第一个节点，交换，heapSize--。周而复始即可