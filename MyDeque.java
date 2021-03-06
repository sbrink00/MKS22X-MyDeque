//1 2 3 4 5 + * - - failed and adding many to front and removing many from back failed.
import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

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
    if (size == 0) return "{}";
    String output = "{";
    if (start <= end){
      for (int idx = start; idx < end + 1; idx ++){
        output += data[idx] + ", ";
      }
    }
    else{
      for (int idx = start; idx < data.length; idx ++) output += data[idx] + ", ";
      for (int idx = 0; idx < end + 1; idx ++) output += data[idx] + ", ";
    }
    return output.substring(0, output.length() - 2) + "}";
  }

  @SuppressWarnings("unchecked")
  private void resize(){
    E[] temp = (E[])new Object[data.length * 2];
    int i = 0;
    if (start <= end){
      for (int idx = start; idx < end + 1; idx ++){temp[i] = data[idx]; i ++;}
    }
    else{
      for (int idx = start; idx < data.length; idx ++) {temp[i] = data[idx]; i ++;}
      for (int idx = 0; idx < end + 1; idx ++) {temp[i] = data[idx]; i ++;}
    }
    data = temp;
    start = 0;
    end = i - 1;
  }

  public void addFirst(E element){
    if (element == null) throw new NullPointerException("This Deque does not take null objects");
    else{
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
          size ++;
        }
        else{
          data[data.length - 1] = element;
          start = data.length - 1;
          size ++;
        }
      }
    }
  }

  public void addLast(E element){
    if (element == null) throw new NullPointerException("This Deque does not take null objects");
    else{
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
  }

  public E removeFirst(){
    if (size == 0) throw new NoSuchElementException("this list is empty");
    else{
      E output = data[start];
      if (size == 1){start = -1; end = -1;}
      else if (start == data.length - 1) start = 0;
      else start ++;
      size --;
      return output;
    }
  }

  public E removeLast(){
    if (size == 0) throw new NoSuchElementException("this list is empty");
    else{
      E output = data[end];
      if (size == 1){start = -1; end = -1;}
      else if (end == 0) end = data.length - 1;
      else end --;
      size --;
      return output;
    }
  }

  public E getFirst() {
    if (size == 0) throw new NoSuchElementException("this list is empty");
    else return data[start];
  }
  public E getLast() {
    if (size == 0) throw new NoSuchElementException("this list is empty");
    else return data[end];
  }
}
