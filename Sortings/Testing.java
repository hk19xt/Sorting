package Sortings;

import java.util.*;
import java.lang.*;

/* This is a main class.
 * This class is implemented for testing the five sorting algorithms as follows: 
   1) bubble sort, 2) heap sort, 3) merge sort, 4) quick sort, and 5) radix sort. 
 
   Name: Hyejin Kim
   Student# 6823116
   Date: 6/29/2020             */

public class Testing {
  
  public static void main(String[] args){
   
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array (the number should be equal or larger than 10 due to Radix sort): ");
    
    int size = sc.nextInt();
    int array[] = new int[size];
    
    System.out.println("What is your preference?\n1)Option 1: Random numbers for the array.\n2)Option 2: Choose your own numbers for the array.\nSelect 1 or 2:");
    int choice = sc.nextInt();
    while(true){
      switch(choice){
        case 1:                    // Randomly generating numbers.
          Heap b = new Heap(size);
          Quick d = new Quick(size);
          for(int j=0; j<array.length; j++){
          int k = (int) (10000001*Math.random()); 
          array[j]=k;
          b.insert(k);
          d.insert(k);
          }
          System.out.println();
          System.out.println("An array with "+array.length+ " random integers has been created.");
          System.out.println();
          System.out.println("Original array:"); // Before sorting
          print(array);
          
          System.out.println("-----------------------------[1.Bubble Sort]-----------------------------------------");
          System.out.println("After sorting:");   // First try for sorting (bubble sort)
          Bubble a = new Bubble();
          long beforeTiming_a = System.nanoTime(); 
          a.bubbleSort(array);
          long afterTiming_a = System.nanoTime();
          a.print(array);
          float afterTiming_A = ((float)(afterTiming_a - beforeTiming_a)/1000000); // calculating the milliseconds
          System.out.println();
          System.out.println("**In the first sort, the amount of time: " + (afterTiming_a - beforeTiming_a) + " nanoseconds (=" + afterTiming_A + " milliseconds)");
          Bubble a2 = new Bubble();  // Second try for re-sorting
          a2 = a;
          long beforeTiming_a2 = System.nanoTime();
          a2.bubbleSort(array);
          long afterTiming_a2 = System.nanoTime();
          float afterTiming_A2 = ((float)(afterTiming_a2 - beforeTiming_a2)/1000000);  // calculating the milliseconds
          System.out.println("**After re-sorting, the amount of time: " + (afterTiming_a2 - beforeTiming_a2) + " nanoseconds (=" + afterTiming_A2 + " milliseconds)");
          
          System.out.println("-----------------------------[2.Heap Sort]-------------------------------------------");
          System.out.println("After sorting:");   // First try for sorting (heap sort)
          long beforeTiming_b = System.nanoTime();
          b.minHeapBuild();
          long afterTiming_b = System.nanoTime();
          b.print();
          float afterTiming_B = ((float)(afterTiming_b - beforeTiming_b)/1000000);  // calculating the milliseconds
          System.out.println();
          System.out.println("**In the first sort, the amount of time: " + (afterTiming_b - beforeTiming_b) + " nanoseconds (=" + afterTiming_B + " milliseconds)");
          Heap b2 = new Heap(size);   // Second try for re-sorting
          b2 = b;
          long beforeTiming_b2 = System.nanoTime();
          b2.minHeapBuild();
          long afterTiming_b2 = System.nanoTime();
          float afterTiming_B2 = ((float)(afterTiming_b2 - beforeTiming_b2)/1000000);  // calculating the milliseconds
          System.out.println("**After re-sorting, the amount of time: " + (afterTiming_b2 - beforeTiming_b2) + " nanoseconds (=" + afterTiming_B2 + " milliseconds)");
          
          System.out.println("-----------------------------[3.Merge Sort]-------------------------------------------");
          System.out.println("After sorting:");   // First try for sorting (merge sort)
          Merge c = new Merge();
          long beforeTiming_c = System.nanoTime();
          c.sort(array,0,array.length-1);
          long afterTiming_c = System.nanoTime();
          c.print(array);
          float afterTiming_C = ((float)(afterTiming_c - beforeTiming_c)/1000000);  // calculating the milliseconds
          System.out.println();
          System.out.println("**In the first sort, the amount of time: " + (afterTiming_c - beforeTiming_c) + " nanoseconds (=" + afterTiming_C + " milliseconds)");
          Merge c2 = new Merge();   // Second try for re-sorting
          c2 = c;
          long beforeTiming_c2 = System.nanoTime();
          c2.sort(array,0,array.length-1);
          long afterTiming_c2 = System.nanoTime();
          float afterTiming_C2 = ((float)(afterTiming_c2 - beforeTiming_c2)/1000000);  // calculating the milliseconds
          System.out.println("**After re-sorting, the mount of time: " + (afterTiming_c2 - beforeTiming_c2) + " nanoseconds (=" + afterTiming_C2 + " milliseconds)");
          
          System.out.println("-----------------------------[4.Quick Sort]-------------------------------------------");
          System.out.println("After sorting:");   // First try for sorting (quick sort)
          long beforeTiming_d = System.nanoTime();
          d.quickSort();
          long afterTiming_d = System.nanoTime();
          d.print();
          float afterTiming_D = ((float)(afterTiming_d - beforeTiming_d)/1000000);  // calculating the milliseconds
          System.out.println();
          System.out.println("**In the first sort, the amount of time: " + (afterTiming_d - beforeTiming_d) + " nanoseconds (=" + afterTiming_D + " milliseconds)");
          Quick d2 = new Quick(size);   // Second try for re-sorting
          d2 = d;
          long beforeTiming_d2 = System.nanoTime();
          d2.quickSort();
          long afterTiming_d2 = System.nanoTime();
          float afterTiming_D2 = ((float)(afterTiming_d2 - beforeTiming_d2)/1000000);  // calculating the milliseconds
          System.out.println("**After re-sorting, the amount of time: " + (afterTiming_d2 - beforeTiming_d2) + " nanoseconds (=" + afterTiming_D2 + " milliseconds)");
          
          System.out.println("-----------------------------[5.Radix Sort]-------------------------------------------");
          System.out.println("After sorting:");   // First try for sorting (radix sort)
          Radix e = new Radix();
          long beforeTiming_e = System.nanoTime();
          e.radixSort(array);
          long afterTiming_e = System.nanoTime();
          e.print(array);
          float afterTiming_E = ((float)(afterTiming_e - beforeTiming_e)/1000000);  // calculating the milliseconds
          System.out.println();
          System.out.println("**In the first sort, the amount of time: " + (afterTiming_e - beforeTiming_e) + " nanoseconds (=" + afterTiming_E + " milliseconds)");
          Radix e2 = new Radix();   // Second try for re-sorting
          e2 = e;
          long beforeTiming_e2 = System.nanoTime();
          e2.radixSort(array);
          long afterTiming_e2 = System.nanoTime();
          float afterTiming_E2 = ((float)(afterTiming_e2 - beforeTiming_e2)/1000000);  // calculating the milliseconds
          System.out.println("**After re-sorting, the amount of time: " + (afterTiming_e2 - beforeTiming_e2) + " nanoseconds (=" + afterTiming_E2 + " milliseconds)");
          
          break;
        case 2:      // Manually generating numbers.
          Heap g = new Heap(size);
          Quick l = new Quick(size);
          for(int i=0; i<array.length; i++){
            System.out.println("Enter a number in the array for [" +(i+1)+"] element : ");
            int w = sc.nextInt();
            array[i]=w;
            g.insert(w);
            l.insert(w);
          }
          System.out.println();
          System.out.println("An array has been created.");
          System.out.println();
          System.out.println("Original array:");  // Before sorting
          print(array);  
        
          System.out.println("-----------------------------[1.Bubble Sort]-----------------------------------------");
          System.out.println("After sorting:");   // First try for sorting (bubble sort)
          Bubble f = new Bubble();
          long beforeTiming_f = System.nanoTime();
          f.bubbleSort(array);
          long afterTiming_f = System.nanoTime();
          f.print(array);
          float afterTiming_F = ((float)(afterTiming_f - beforeTiming_f)/1000000);  // calculating the milliseconds
          System.out.println();
          System.out.println("**In the first sort, the amount of time: " + (afterTiming_f - beforeTiming_f) + " nanoseconds (=" + afterTiming_F + " milliseconds)");
          Bubble f2 = new Bubble();   // Second try for re-sorting
          f2 = f;
          long beforeTiming_f2 = System.nanoTime();
          f2.bubbleSort(array);
          long afterTiming_f2 = System.nanoTime();
          float afterTiming_F2 = ((float)(afterTiming_f2 - beforeTiming_f2)/1000000);   // calculating the milliseconds
          System.out.println("**After re-sorting, the amount of time: " + (afterTiming_f2 - beforeTiming_f2) + " nanoseconds (=" + afterTiming_F2 + " milliseconds)");
          
          System.out.println("-----------------------------[2.Heap Sort]-------------------------------------------");
          System.out.println("After sorting:");   // First try for sorting (heap sort)
          long beforeTiming_g = System.nanoTime();
          g.minHeapBuild();
          long afterTiming_g = System.nanoTime();
          g.print();
          float afterTiming_G = ((float)(afterTiming_g - beforeTiming_g)/1000000);   // calculating the milliseconds
          System.out.println();
          System.out.println("**In the first sort, the amount of time: " + (afterTiming_g - beforeTiming_g) + " nanoseconds (=" + afterTiming_G + " milliseconds)");
          Heap g2 = new Heap(size);   // Second try for re-sorting
          g2 = g;
          long beforeTiming_g2 = System.nanoTime();
          g2.minHeapBuild();
          long afterTiming_g2 = System.nanoTime();
          float afterTiming_G2 = ((float)(afterTiming_g2 - beforeTiming_g2)/1000000);   // calculating the milliseconds
          System.out.println("**After re-sorting, the amount of time: " + (afterTiming_g2 - beforeTiming_g2) + " nanoseconds (=" + afterTiming_G2 + " milliseconds)");
                
          System.out.println("-----------------------------[3.Merge Sort]-------------------------------------------");
          System.out.println("After sorting:");   // First try for sorting (merge sort)
          Merge h = new Merge();
          long beforeTiming_h = System.nanoTime();
          h.sort(array,0,array.length-1);
          long afterTiming_h = System.nanoTime();
          h.print(array);
          float afterTiming_H = ((float)(afterTiming_h - beforeTiming_h)/1000000);   // calculating the milliseconds
          System.out.println();
          System.out.println("**In the first sort, the amount of time: " + (afterTiming_h - beforeTiming_h) + " nanoseconds (=" + afterTiming_H + " milliseconds)");
          Merge h2 = new Merge();   // Second try for re-sorting
          h2 = h;
          long beforeTiming_h2 = System.nanoTime();
          h2.sort(array,0,array.length-1);
          long afterTiming_h2 = System.nanoTime();
          float afterTiming_H2 = ((float)(afterTiming_h2 - beforeTiming_h2)/1000000);   // calculating the milliseconds
          System.out.println("**After re-sorting, the mount of time: " + (afterTiming_h2 - beforeTiming_h2) + " nanoseconds (=" + afterTiming_H2 + " milliseconds)");
          
          System.out.println("-----------------------------[4.Quick Sort]-------------------------------------------");
          System.out.println("After sorting:");   // First try for sorting (quick sort)
          long beforeTiming_l = System.nanoTime();
          l.quickSort();
          long afterTiming_l = System.nanoTime();
          l.print();
          float afterTiming_L = ((float)(afterTiming_l - beforeTiming_l)/1000000);   // calculating the milliseconds
          System.out.println();
          System.out.println("**In the first sort, the amount of time: " + (afterTiming_l - beforeTiming_l) + " nanoseconds (=" + afterTiming_L + " milliseconds)");
          Quick l2 = new Quick(size);   // Second try for re-sorting
          l2 = l;
          long beforeTiming_l2 = System.nanoTime();
          l2.quickSort();
          long afterTiming_l2 = System.nanoTime();
          float afterTiming_L2 = ((float)(afterTiming_l2 - beforeTiming_l2)/1000000);   // calculating the milliseconds
          System.out.println("**After re-sorting, the amount of time: " + (afterTiming_l2 - beforeTiming_l2) + " nanoseconds (=" + afterTiming_L2 + " milliseconds)");
          
          System.out.println("-----------------------------[5.Radix Sort]-------------------------------------------");
          System.out.println("After sorting:");   // First try for sorting (radix sort)
          Radix o = new Radix();
          long beforeTiming_o = System.nanoTime();
          o.radixSort(array);
          long afterTiming_o = System.nanoTime();
          o.print(array);
          float afterTiming_O = ((float)(afterTiming_o - beforeTiming_o)/1000000);   // calculating the milliseconds
          System.out.println();
          System.out.println("**In the first sort, the amount of time: " + (afterTiming_o - beforeTiming_o) + " nanoseconds (=" + afterTiming_O + " milliseconds)");
          Radix o2 = new Radix();   // Second try for re-sorting
          o2 = o;
          long beforeTiming_o2 = System.nanoTime();
          o2.radixSort(array);
          long afterTiming_o2 = System.nanoTime();
          float afterTiming_O2 = ((float)(afterTiming_o2 - beforeTiming_o2)/1000000);   // calculating the milliseconds
          System.out.println("**After re-sorting, the amount of time: " + (afterTiming_o2 - beforeTiming_o2) + " nanoseconds (=" + afterTiming_O2 + " milliseconds)");
          
      }          
      break;
      }
    } //main
  
  
  /* This method is print for arrays. 
   * @param integer array[] */
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
  } //print
    
  } // Testing