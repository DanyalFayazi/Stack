package com.company;

public class stack<T>{

    private T[] array;
    private int size;
    private int RemovedElements;
    private int max;

    stack(int size){
        array = (T[]) new Object[10];
        this.size =0 ;
        max = size;
        RemovedElements =0;
    }
    stack(){
        array = (T[]) new Object[10];
        size =0 ;
        max = 10;
        RemovedElements =0;
    }

    public void check_size(){
        if(size >= max*90/100){
            T[] temp = (T[]) new Object[2*max];
            for(int i=0 ; i<size ; i++){
                temp[i] = array[i];
            }
            array = temp;
            max *= 2;
        }else if(RemovedElements == max / 2){
            T[] temp = (T[])new Object[max / 2];

            for(int i=0 ; i<size ; i++)
                temp[i]  = array[i];

            max /=2 ;
            RemovedElements =0;
        }
    }
    public void push(T data){
        check_size();
        array[size] = data;
        size++;
    }

    public T pop() throws Exception {
        if(size!=0) {
            T tmp = array[size - 1];
            array[size - 1] = null;
            size =size- 1;
            RemovedElements++;
            check_size();

            return tmp;
        }else
            throw new Exception("Array is Empty");
    }

    public T top() throws Exception {
        if(size !=0){
            return array[size -1];
        }else
            throw new Exception("Array is Empty");
    }

    public boolean isEmpty(){
        if(size != 0)
            return false;
        else return true;
    }

    public void truncate(){
        T[] temp = (T[]) new Object[size];

        for(int i=0 ; i<size ;i++){
            temp[i] = array[i];
        }

        array = temp;
        max = size;
    }


    public void rotate(char direction)  {
        if(direction == 'L'){
            T tmp = array[0];
            int i=0;
            for(i=0 ; i<=size -2 ;i++)
                array[i] = array[i+1];
            array[i] = tmp;
        }
        else if(direction == 'R'){
            int i = size-1;
            T tmp = array[i];
            for(i=size-1 ; i>0 ;i--)
                array[i] = array[i-1];
            array[i] = tmp;

        }

    }
    public void reverse(){
        T[] tmp =(T[]) new Object[max];

        for(int i=0  ; i<size ; i++){
            tmp[i] = array[(size -1) -i];
        }
        array = tmp;
    }
}