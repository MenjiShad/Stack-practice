Stack-practice
==============
CECS274 Lab 
==============
Driver
==============
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
Notebook Stack
==============
import java.util.Scanner;
import java.util.ArrayList;

public class notebookStack
{
  // instance variables
  protected ArrayList<Integer> aList = new ArrayList<Integer>();
  protected Scanner input = new Scanner(System.in);
  protected int top = -1;

  public boolean isEmpty()
  {
    return top == -1;
  }
  
  public int peek()
  {
    if (isEmpty())
    {
      System.out.println("Your stack is empty."); 
    }
    return aList.get(top);
  }
  
  public int getSize()
  {
    return aList.size();
  }
  public void push(int i)
  {
   aList.add(i);
   top++;
  }
  
  public int pop()
  {
    if (isEmpty())
    {
      System.out.println("Stack is empty");
    }
    return aList.remove(top--);
  }
  
  public void retrieve(int search, notebookStack subStack)
  {
    if (isEmpty())
    {
      System.out.println("Stack is empty. Could not retrieve element");
      while (!subStack.isEmpty())
      {
        push(subStack.pop());
      }
      return;
    }
    if (!isEmpty())
    {
      if (search == peek())
      {
        System.out.println("Element retrieved " + pop());
        while (!subStack.isEmpty())
        {
          push(subStack.pop());
        }
      } else
      {
        subStack.push(pop());
        retrieve(search, subStack);
      }
    }
  }
  
  public void display()
  {
   System.out.print("\nStack = ");
   if (aList.size() == 0)
   {
     System.out.println("Empty\n");
   } else
   {
     System.out.print(" (Bottom) ");
   }
    for (int count = 0; count <= top; count++)
    {
      System.out.print(aList.get(count) + " ");
    }
    if (!isEmpty())
    {   
      System.out.println(" (Top)");
    }
  }
}
