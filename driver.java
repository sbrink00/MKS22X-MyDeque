public class driver{
  @SuppressWarnings("unchecked")
  public static void main(String[]args){
    String expression = "1 2 3 4 5 + * - -";
    System.out.println(Calculator.eval(expression));
  }
}
