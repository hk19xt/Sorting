package Sortings;

import java.util.*;

/* This is Merge class.
 * This class is implemented for testing the merge sorting algorithm.
 
   Name: Hyejin Kim
   Student# 6823116
   Date: 6/29/2020             */

public class Merge{

  /* This method is merging the two subarrays.
   * @param integer array
            integer left position : 0
            integer middle position (will be calculated in later part)
            integer right : array.length - 1*/
  private void merge(int array[], int left, int middle, int right){
    int sub1 = middle - left + 1; // The first subarray (from left to middle)
    int sub2 = right - middle;    // The second subarray (from middle + 1 to right)
    
    int L[] = new int[sub1]; // Left subarray
    int R[] = new int[sub2]; // Right subarray
    
    for(int i=0;i<sub1;++i){ // Insert the values into the left subarray
      L[i]=array[left+i];    
    }
    for(int j=0;j<sub2;++j){ // Insert the values into the right subarray
      R[j]=array[middle+1+j];
    }
    
    int i=0; // First element in the left subarray
    int j=0; // First element in the right subarray
    
    int t=left;
    while(i<sub1 && j<sub2){ // Merge two subarrays.
      if(L[i] <= R[j]){    // If the element in the left array is smaller than the right element,
        array[t] = L[i];   // then insert the smaller left element into the new array.
        i++;
      }else{               // If the element in the right array is smaller than the left element,
        array[t] = R[j];   // then insert the smaller right element into the new array.
        j++;
      }
    t++;  
    }
    
    while(i<sub1){
      array[t] = L[i];
      i++;
      t++;    
    }
    
    while(j<sub2){
      array[t] = R[j];
      j++;
      t++;
    }
  } // Merge
  
  
  /* This method is sorting the subarrays. 
   * @param integer array
            integer left : 0
            integer right : array.length - 1*/
  public void sort(int array[], int left, int right){
    if(left<right){
      int middle = (left+right)/2; // Find the middle position.
      sort(array,left,middle);     // Sort the first subarray(from left to middle).
      sort(array,middle+1,right);  // Sort the second subarray (from middle + 1 to right).
      merge(array,left,middle,right); // Merge two subarrays.
    }
  } // sort
  
 /*This method is printing the array.
  * param integer array. */
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
  }
  
} // Merge




