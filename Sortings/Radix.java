package Sortings;

import java.util.*;

/* This is Radix class.
 * This class is implemented for testing the radix sorting algorithm.
 
   Name: Hyejin Kim
   Student# 6823116
   Date: 6/29/2020             */

public class Radix{
  
  /* This method is sorting the array based on the digits. 
   * @param integer array. */
  public static void radixSort(int[] array){
    int m = getMax(array); // Get maximum value in the array.
    int pos = 1; // Position
  
    while(m/pos>0){ // In order to create buckets for digits, maximum valus is divided by 1, 10, 100, and so on. 
      counting(array, pos); 
      pos = pos*10; 
    }
  }
  
  /* This method is returning a maximum value in the array.
   * @param integer array. 
     return maximum value. */
  private static int getMax(int[] array){
    int m = array[0];  // Maximum value
    for(int i=1;i<array.length;i++){
      if(array[i]>m){
        m = array[i];
      }
    }
  return m;
  } // getMax

  /* This method is counting the number of elements in each bucket. 
   * @param integer array
            integer position. */
  private static void counting(int[] array, int pos){
    int s = array.length;
    int[] result = new int[s]; // New array for copying the array for the next sorting
    int[] c = new int[s];
    
    for(int i=0;i<s;i++){
      c[(array[i]/pos)%10]++; // In the digit bucket, c[0]=(0 element),c[1]=(2 elements),c[2]=(0 element),c[3]=(0 element),c[4]=(1 element),
                              // e[5]=(2elements ),e[6]=(2 elements),e[7]=(1 element),e[8]=(1 element),e[9]=(0 element)
    }
    
    for(int i=1;i<s;i++){ // In order to locate the right position for each elements in the buckets, count the number of elements in each bucket.
      c[i]=c[i]+c[i-1];   // Accumulate the number of elements in 0,1,2,...9 buckets.
    }
    
    for(int i=s-1;i>=0;i--){ // Insert the values from the end position to the left position.
      result[c[(array[i]/pos)%10]-1]=array[i];
      c[(array[i]/pos)%10]--; // Move to the -1 position
    }
    
    for(int i=0;i<result.length;i++){ // Copy the result array in order for the sorting with the next digit.
      array[i] = result[i];
    }
  } // counting
  
  /* This method is printing the array. 
   * @param integer array. */
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
} // Radix