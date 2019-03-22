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
    if (size == 0) return "[]";
    //if (size == 1) return "[" + getFirst() + "]";
    String output = "[";
    for (int idx = start; idx < end && idx < data.length; idx ++){
      output += data[idx] + ", ";
    }
    if (end < start){
      for (int idx = 0; idx < end; idx ++){
        output += data[idx] + ", ";
      }
    }
    return output;
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
    if (start == 0) start = data.length - 1;
    else start --;
    size ++;
  }

  public void addLast(E element){
    if (size == data.length) resize();
    if (end != data.length - 1) data[end + 1] = element;
    else data[0] = element;
    if (end != data.length - 1) end ++;
    else end = 0;
    size ++;
  }
  public E removeFirst(){
    E output = data[start];
    if (start == data.length - 1) start = 0;
    else start ++;
    size --;
    return output;
  }

  public E removeLast(){
    E output = data[end];
    if (end == 0) end = data.length - 1;
    else end --;
    size --;
    return output;
  }

  public E getFirst() {return data[start];}
  public E getLast() {return data[end];}
}
