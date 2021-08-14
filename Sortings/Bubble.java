package Sortings;

import java.util.*;

/* This is Bubble class.
 * This class is implemented for testing the bubble sorting algorithm.
 * 
 Name: Hyejin Kim
 Student# 6823116
 Date: 6/29/2020             */

public class Bubble{
  
  /* This method is bubblesort for swapping when the left element is larger than the right element.
   * @param integer array                                                                          */
  public void bubbleSort(int array[]){
    int s = array.length;
    for(int i=0;i<s-1;i++){ 
      for(int j=0;j<s-i-1;j++){ // The value at the end is already ordered.
        if(array[j]>array[j+1]){  // Swap if the first element is larger than the second element.
          int temp = array[j];
          array[j] = array[j+1];
          array[j+1] = temp;
        }
      }
    }
  } // bubbleSort
  
  /* This method is print for arrays.
   * @param integer array           */
  public static void print(int array[]){
    
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
  
} // Bubble
  
