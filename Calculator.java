import java.util.Arrays;
public class Calculator{
  public static void main(String[]args){
    String expression = "10 2.0 +";
    eval(expression);
  }

  public static double eval(String s){
    String[] things = s.split(" ");
    System.out.println(Arrays.toString(things));
    MyDeque help = new MyDeque<String>();
    for (String thing: things){
      if (!operation())
    }
    return 1.0;
  }

  private static boolean operation(String maybeOperation){
    String[] operations = {"+", "-", "*", "/", "%"};
    for (String operation: operations) if (operation.equals(maybeOperation)) return true;
    return false;
  }
}
