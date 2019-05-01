public class MyHeap{
  /*- size  is the number of elements in the data array.
     - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided that child is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
     - precondition: index is between 0 and size-1 inclusive
     - precondition: size is between 0 and data.length-1 inclusive
  */
  private static void pushDown(int[]data,int size,int index){
    boolean hasChildren = true; //if the parent at index has any children to do valid swaps with, assume true
    while (hasChildren) {
      int ch1 = 2*index+1;
      int ch2 = 2*index+2;
      //no children
      if (ch1 >= size && ch2 >= size){
        hasChildren = false;
      } else if (ch1 < size && ch2 >= size) { //if only 1 child
        if (data[index] < data[ch1]){
          int replace = data[index];
          data[index] = data[ch1];
          data[ch1] = replace;
          index = ch1;
        } else {
          //the parent has valid children, no children to swap with
          hasChildren = false;
        }
      } else if (ch1 < size && ch2 < size) { //if 2 child
        //swap with the largest child 
        if (data[index] >= data[ch1] && data[index] >= data[ch2]){
          hasChildren = false;
        } else if (Math.max(data[ch1], data[ch2]) == data[ch1] && data[index] < data[ch1]){
          int replace = data[index];
          data[index] = data[ch1];
          data[ch1] = replace;
          index = ch1;
        } else if (Math.max(data[ch1],data[ch2]) == data[ch2] && data[index] < data[ch2]){
          int replace = data[index];
          data[index] = data[ch2];
          data[ch2] = replace;
          index = ch2;
        }
      }
    }
  }
  /*- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
     - precondition: index is between 0 and data.length-1 inclusive.
  */
  private static void pushUp(int[]data,int index){
    //traces up the heap from starting index until it reaches zero
    for (int i = index; i > 0; i /= 2){
      //checks and executes valid swaps
      if (data[i] > data[i/2]){
        int replace = data[i];
        data[i] = data[i/2];
        data[i/2] = replace;
      }
    }
  }
  //- convert the array into a valid heap. [ should be O(n) ]
  public static void heapify(int[] data){
    //starting from bottom of the heap
    for (int i = data.length-1; i > -1; i--){
      pushDown(data,data.length,i);
    }
  }
  /*- sort the array [ should be O(nlogn) ] :
     converting it into a heap
     removing the largest value n-1 times (remove places at end of the sub-array)
  */
  public static void heapsort(int[] data){
    heapify(data);
    //check from bottom up, swap root and last number and subtract 1 from the length of the array you're checking, and pushDown that number to ensure valid heap
    for (int i = data.length-1; i>-1; i--){
      int replace = data[0];
      data[0] = data[i];
      data[i] = replace;
      pushDown(data,i,0);
    }
  }
}
