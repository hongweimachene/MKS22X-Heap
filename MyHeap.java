public class MyHeap{
  private static void pushDown(int[]data,int size,int index){
    boolean hasChildren = true;
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
      if (Math.max(data[ch1], data[ch2]) == data[ch1] && data[index] < data[ch1]){
        int replace = data[index];
        data[index] = data[ch1];
        data[ch1];
      }
    }
  }
  private static void pushUp(int[]data,int index){

  }
  public static void heapify(int[] data){

  }
  public static void heapsort(int[] data){

  }
}
