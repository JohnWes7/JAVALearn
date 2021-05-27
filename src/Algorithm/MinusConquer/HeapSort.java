package Algorithm.MinusConquer;

import Algorithm.mArr;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {10,13,7,18,20,26,35,47};
        mArr.PrintArray(arr);
        Sort(arr);
        mArr.PrintArray(arr);
    }

    public static void SieveHeap(int[] arr, int index, int lenght){
        int parent = index;
        //获取左子节点
        int maxchild = index * 2 + 1;

        while (maxchild < lenght){
            
            if (maxchild + 1 < lenght) {
                maxchild = (arr[maxchild] > arr[maxchild + 1] + 1)? maxchild : maxchild + 1;
            }
        
            //如果根节点已经是最大了就不用往下筛了
            if (arr[parent] > arr[maxchild]) {
                break;
            }else{
                //不是最大的就要交换继续往下筛
                int temp = arr[parent];
                arr[parent] = arr[maxchild];
                arr[maxchild] = temp;

                parent = maxchild;
                //拿到交换后的左子节点
                maxchild = parent * 2 + 1;
            }
        }
    }

    public static void Sort(int[] arr){
        //构建最大堆
        for (int i = (arr.length - 1) / 2; i >= 0 ; i--) {
            SieveHeap(arr, i, arr.length);
        }

        System.out.println("建立最大堆：");
        mArr.PrintArray(arr);

        for (int i = 1; i < arr.length; i++) {
            //前面和后面交换 后方为有序区
            int temp = arr[0];
            arr[0] = arr[arr.length - i];
            arr[arr.length - i] = temp;

            //把顶部的往下筛重写形成堆 顶部又会变成最大的
            SieveHeap(arr, 0, arr.length - i);
        }
    }
}