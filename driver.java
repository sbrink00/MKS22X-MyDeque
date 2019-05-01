public class driver{
  @SuppressWarnings("unchecked")
  public static void main(String[]args){
    MyDeque<Integer> md = new MyDeque<Integer>();
    for (int i = 0; i < 100000; i++) md.addFirst(i);
    System.out.println(md);
    for (int i = 0; i < 100000; i++) md.removeLast();
    System.out.println(md);
  }
}
