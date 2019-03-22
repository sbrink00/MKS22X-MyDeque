public class MyDeque<E>{
  public E[] data;
  public int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start = -1; end = -1; size = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    start = -1; end = -1; size = 0;
  }

  public int size(){return size;}

  public String toString(){
    if (size == 0) return "[]";
    String output = "[";
    for (int idx = start; idx < end + 1 && idx < data.length; idx ++){
      //System.out.println("working");
      output += data[idx] + ", ";
    }
    if (end < start){
      for (int idx = 0; idx < end; idx ++){
        output += data[idx] + ", ";
      }
    }
    return output;//.substring(0, output.length() - 2) + "]";
  }

  @SuppressWarnings("unchecked")
  private void resize(){
    E[] temp = (E[])new Object[data.length * 2];
    int i = 0;
    for (int idx = start; idx < end + 1 && idx < data.length; idx ++){
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
    if (size == 0){
      data[0] = element;
      start = 0; end = 0;
      size ++;
    }
    else{
      if (start != 0){
        data[start - 1] = element;
        start --;
      }
      else{
        data[data.length - 1] = element;
        start = data.length - 1;
      size ++;
      }
    }
  }

  public void addLast(E element){
    if (size == data.length) resize();
    if (size == 0){
      data[0] = element;
      start = 0; end = 0;
      size ++;
    }
    else{
      if (end != data.length - 1) data[end + 1] = element;
      else data[0] = element;
      if (end != data.length - 1) end ++;
      else end = 0;
      size ++;
    }
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
