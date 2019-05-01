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
      if (ch1 >= size && ch2 >= size){
        hasChildren = false;
      } else if (ch1 < size && ch2 >= size) {
        if (data[index] < data[ch1]){
          int replace = data[index];
          data[index] = data[ch1];
          data[ch1] = replace;
          index = ch1;
        } else {
          hasChildren = false;
        }
      } else if (ch1 < size && ch2 < size) {
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
  private static void pushUp(int[]data,int index){
    for (int i = index; i > 0; i /= 2){
      if (data[i] > data[i/2]){
        int replace = data[i];
        data[i] = data[i/2];
        data[i/2] = replace;
      }
    }
  }
  public static void heapify(int[] data){

  }
  public static void heapsort(int[] data){

  }
}
