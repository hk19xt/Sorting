package Sortings;

import java.util.*;

/* This is Heap class.
 * This class is implemented for testing the heap(min heap) sorting algorithm.
 * In order for ascending order, the heap means the min heap in this class.
 
   Name: Hyejin Kim
   Student# 6823116
   Date: 6/29/2020             */

public class Heap {
  
  
  private int[] array;
  private int size;
  private int maximum;
  private static final int FVALUE = 1; // Front value
  
  // Initialize size, maximum value, array, and the first element of the array.
  
  public Heap(int maximum){ 
    this.maximum = maximum;
    this.size = 0; 
    array = new int[this.maximum + 1];
    array[0] = Integer.MIN_VALUE;
  }

  /* This method is returning the position of parent value.
   * @param integer position. */
  private int parent(int p){ 
    return p/2;
  } // parent
  
  /* This method is returning the position of left child value.
   * @param integer position. */  
  private int leftChild(int p){
    return (2*p);
  } // leftChild
  
  /* This method is returning the position of right child value.
   * @param integer position. */ 
  private int rightChild(int p){
    return (2*p)+1;
  } // rightChild
  
  /* This method is returning whether it is leaf value.
   * @param integer position. */ 
  private boolean isLeaf(int p){
    if(p>=(size/2) && p<=size){
      return true;
    }
    return false;
  } // isLeaf
  
  /* This method is swapping the first and second elements.
   * @param integer first element
   *        integer second element. */ 
  private void swap(int first, int second){
    int temp;
    temp = array[first];
    array[first] = array[second];
    array[second] = temp;
  } // swap
  
  /* This method is min-heapifying the elements. 
   * @param integer position. */ 
  private void minHeap(int p){
    if(!isLeaf(p)){
      if (array[p]>array[leftChild(p)] || array[p]>array[rightChild(p)]){
        if(array[leftChild(p)]<array[rightChild(p)]){
          swap(p,leftChild(p));
          minHeap(leftChild(p));
        }else{
          swap(p,rightChild(p));
          minHeap(rightChild(p));
        }
      } 
  }
  } // minHeap
  
  /* This method is inserting the new elements into the array.
   * @param integer newElement. */ 
  public void insert(int newElement){
    if(size>=maximum){
      return;   
    }
    array[++size]=newElement;
    int c = size;
    
    while(array[c]<array[parent(c)]){
      swap(c,parent(c));
      c=parent(c);
    }
    } // insert
  
  /* This method is printing the array. */ 
  public void print(){
    System.out.print("{");
    for(int q=1;q<=size;q++){
      if(q>1){
        System.out.print(", ");
      }
      System.out.print(array[q]);
    }
    System.out.print("}");
    System.out.println();
    } // print
  
  
  /* This method is building the tree for minHeap. */
  public void minHeapBuild(){
    for(int p=(size/2);p>=1;p--){
      minHeap(p);
    }
  } // minHeapBuild
  
  /* This method is removing the minimum value from the heap.
   * @param integer position. */ 
  private int removeMin(){
    int popped = array[FVALUE];
    array[FVALUE]=array[size--];
    minHeap(FVALUE);
    return popped;
  } // removeMin
  
  
  } // Heap 
  
