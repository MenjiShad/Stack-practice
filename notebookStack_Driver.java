import java.util.Scanner;

public class notebookStack_Driver
{
  private static Scanner input = new Scanner(System.in);
    
  public static void main(String[] BLASFVASDBNSIFHBSDKGW)
  {
    notebookStack stack = new notebookStack();
    char check;
    do
    {
    System.out.println("Stack Operations");
    System.out.println("1. Push");
    System.out.println("2. Pop");
    System.out.println("3. Peek");
    System.out.println("4. Check Empty");
    System.out.println("5. Check size");
    System.out.println("6. Retrieve");
    System.out.println("7. Clear");
    int choice = input.nextInt();
    switch (choice)
    {
      case 1: System.out.println("Enter how many elements to push");
      int pushAmount = input.nextInt();
      for (int count = 0; count < pushAmount; count++)
      {
      System.out.println("Enter element " +  (count+1) + " to push");
      stack.push(input.nextInt());
      }
      break;
      case 2: System.out.println("Enter how many elements to pop");
      int popAmount = input.nextInt();
      for (int counter = 0; counter < popAmount; counter++)
        System.out.println("Popped element = " + stack.pop());
      break;
      case 3: System.out.println("Peek element = " + stack.peek());
      break;
      case 4: if (stack.isEmpty())
      {
       System.out.println("Stack is empty."); 
      }
      else
      {
        System.out.println("Stack is not empty.");
      }
      break;
      case 5: System.out.println("Size of stack: " + stack.getSize());
      break;
      case 6: System.out.println("What number do you want to retrieve?");
      notebookStack subStack = new notebookStack();
      int search = input.nextInt();
      stack.retrieve(search, subStack);
      break;
      case 7: System.out.println("Are you sure you want to clear? (Y/N)");
      check = input.next().charAt(0);
      if (check == 'Y' || check == 'y')
      {
        while (!stack.isEmpty())
          stack.pop();
      }
      break;
    }
    stack.display();
    System.out.println("Do you want to continue? (Y/N)");
    check = input.next().charAt(0);
    } while (check == 'Y' || check == 'y');
  }
}
