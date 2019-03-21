public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start = 0; end = 0; size = 0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    start = 0; end = 0; size = 0;
  }

  public int size(){return size;}
  public String toString(){
    String output = "[";
    for (int idx = start; idx < end && idx < data.length; idx ++){
      output += data[idx] + ", ";
    }
    if (end < start){
      for (int idx = 0; idx < end; idx ++){
        output += data[idx] + ", ";
      }
    }
    return output.substring(output.length() - 2) + "]";
  }

  @SuppressWarnings("unchecked")
  private void resize(){
    E[] temp = (E[])new Object[data.length * 2];
    int i = 0;
    for (int idx = start; idx < end && idx < data.length; idx ++){
      temp[i] = data[idx];
      i ++;
    }
    if (end < start){
      for (int idx = 0; idx < end; idx ++){
        temp[i] = data[idx];
        i ++;
      }
    }
    data = temp;
  }

  public void addFirst(E element){
    if (size == data.length) resize();
    if (start != 0) data[start - 1] = element;
    else data[data.length - 1] = element;
  }
  //public void addLast(E element){ }
  //public E removeFirst(){ }
  //public E removeLast(){ }
  //public E getFirst(){ }
  //public E getLast(){ }
}
