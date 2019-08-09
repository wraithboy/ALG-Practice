package heap;

import java.util.Arrays;

public class MinHeap {

    private int capacity =10;
    private int size=0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex)
    {
        return parentIndex*2+1;
    }

    private int getRightChildIndex(int parentIndex)
    {
        return parentIndex*2+2;
    }

    private boolean hasLeftChild(int index)
    {
        return getLeftChildIndex(index)<size;
    }

    private boolean hasRightChild(int index)
    {
        return getRightChildIndex(index)<size;
    }

    private int leftChild(int index)
    {
        return items[index*2+1];
    }

    private int rightChild(int index)
    {
        return items[index*2+2];
    }

    private int parent(int index)
    {
        return items[(index-1)/2];
    }

    private void swap(int i,int j)
    {
        int tmp=items[i];
        items[i]=items[j];
        items[j]=tmp;
    }

    private void ensureExtraCapacity(){
        if(size==capacity)
        {
            items= Arrays.copyOf(items,capacity*2);
            capacity=capacity*2;
        }
    }

    public int peek()
    {
        if(size==0) return -999;

        return items[0];
    }

    public int poll()
    {
        if(size==0) return -999;

        int item=items[0];

        items[0]=items[size-1];

        size--;

        heapifyDown();

        return item;
    }

    public void add(int item)
    {
        ensureExtraCapacity();
        items[size]=item;
        size++;
        heapifyUp();
    }

    public void heapifyUp(){

        int index=size-1;

        while(parent(index)>=0 && items[parent(index)]>items[index])
        {
            swap(parent(index),index);
            index=parent(index);
        }
    }

    public void heapifyDown()
    {
        int index=0;

        while(hasLeftChild(index))
        {
            int smallerChildIndex=getLeftChildIndex(index);

            if(hasRightChild(index)&&getRightChildIndex(index)<smallerChildIndex)
            {
                smallerChildIndex=getRightChildIndex(index);
            }

            if(items[index]<smallerChildIndex)
                break;
            else
            {
                swap(index,smallerChildIndex);
            }

            index=smallerChildIndex;
        }

    }

}
