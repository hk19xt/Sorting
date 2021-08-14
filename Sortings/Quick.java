package Sortings;

import java.util.*;
import java.io.*;

/* This is Quick class.
 * This class is implemented for testing the quick sorting algorithm. 
 * This class uses a combination of two sorting algorithms: Quick sort and Insertion sort (for efficiency).
 *
 * The partition selection size is 10 because for smaller size array under 10, if the array applies to the insertion sort 
 * without recursive loops for partition method, it can reduce the running time. It was usually improved by almost 10 to 15 percent 
 * when I chose 10 as a size for the partition selection.
 
   Name: Hyejin Kim
   Student# 6823116
   Date: 6/29/2020             */


public class Quick{
  
  final static int INSERTION_SORT_PARTITION_SIZE = 10; // Partition selection size (might be different, depending on the data size)
  private static int[] array;
  private int length;
  
  public Quick(int max){  
    array = new int[max];  
    length = 0;
  }
  
  /* This method is helper method.*/
  public void quickSort(){ 
    quickAndInsertion(0,length-1);  //Initialize the left and right position.
  
  } // quickSort

  /* This method is the combination method of quick and insertion sorts.
   * @param integer left position
            integer right position */
  public void quickAndInsertion(int left, int right){
    int n = right-left+1; // range
    
    if(n<INSERTION_SORT_PARTITION_SIZE){  // If the array size is smaller than 10, it directly applies to insertion method.
      insertion(left,right);
    }else{                                // If the array size is larger than 10, first it calls the partition method, 
      int median = findMedian(left, right);  // then Insertion method (recursively until it hits under 10)
      int partLocation = partition(left,right,median); // Location between left and right partitions
      quickAndInsertion(left,partLocation-1); // Left partition
      quickAndInsertion(partLocation+1,right); // Right partition
    
    }
  } // quickAndInsertion
  
  /* This method is finding a median value. 
   * @param integer left element
            integer right element. */
  public int findMedian(int left, int right){
    int m = (left+right)/2;  // Midian
    
    if(array[left]>array[m]){  // If left value is larger than midian value, then swap.
      swap(left,m);          
    }
    if(array[left]>array[right]){ // If left value is larger than right value, then swap.
      swap(left,right);
    }
    if(array[m]>array[right]){ // If midian value is larger than right value, then swap.
      swap(m,right);
    }
    swap(m,right-1);  // Locate midian value to the right position for implementing the partition method.
    return array[right-1];  // Return the median value.
         
  } // findMedian
  
  /* This method is partition method.
   * @param integer left position
            integer right position
            long pivot value (median value)      */
  public int partition(int left, int right, long pivot){
    int leftLocation = left;
    int rightLocation = right-1;
    
    while(true){
      
      while(array[++leftLocation]<pivot); // The values in the left array should be lower than a median value.
      while(array[--rightLocation]>pivot); // The values in the right array should be higer than a median value.
      
      if(leftLocation>=rightLocation){ // If two position crossed, then break
        break;
      }else{               
        swap(leftLocation,rightLocation);
      }
    }
      swap(leftLocation,right-1);  // Locate the median value into the middle location.
      return leftLocation; // Return the midian location
    
    } // partition
  
  /* This method is inserting the elements into the position in the ascending order. 
   * @param integer left position in the array
            integer right position in the array. */
  public void insertion(int leftPosition, int rightPosition){
    int inPosition; // insert new element
    int outPosition; // pop the old element

    for(outPosition = leftPosition + 1; outPosition<=rightPosition; outPosition++){
      int tempValue = array[outPosition]; // old value is a temporarily value
      inPosition = outPosition; 
      
      while(inPosition > leftPosition && array[inPosition-1] >= tempValue){ // If the left value is larger than the right value in the array,
        array[inPosition] = array[inPosition-1];                            // then put the larger value into the right position (this is ascending order).
        --inPosition; // while implementing for this loop                   // This comparison repeats until it hits the leftmost position.
      
      }
      array[inPosition] = tempValue;  // If the values are already in the ascending order
    }
  } // insertion
  
  /* This method is swapping the first element and the second element.
   * @param integer first position
            integer second position. */
  public void swap(int first, int second){
    int temp = array[first];
    array[first] = array[second];
    array[second] = temp;
  } // swap
  
  /* This method is inserting the new value into the new array. */
  public void insert(int val){
    array[length] = val;
    length++;
  
  } // insert
  
  /* This method is printing the array.*/
  public static void print(){
  
    int t = array.length;
    System.out.print("{");
    for(int i=0;i<t;++i){
      if(i>0)
      {
        System.out.print(", ");
      }
      System.out.print(array[i]);
    }
    System.out.print("}");
      System.out.println();
    } // print

  } // Quick
