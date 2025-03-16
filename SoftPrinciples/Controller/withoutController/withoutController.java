package SoftPrinciples.Controller.withoutController;

class stack{

    private int []arr;
 
    private int top=-1;
 
   public stack(int size){
     
     arr=new int[size];
   }
 
   public void push(int num){
 
    if(isStackFull()){

        int [] temp=new int[arr.length*2];

        for (int i = 0; i < arr.length; i++) {
            temp[i]=arr[i];
        }
        arr=temp;
        
    }

    arr[++top]=num;
   }
 
   public int peek(){
 
     if (isEmpty()) {
       System.out.println("Stack is Empty");
       return 0;
     }
 
     return arr[top];
   }
 
   public int pop(){
 
     if (isEmpty()) {
       System.out.println("Stack is Empty");
       return 0;
     }
 
     int temp = arr[top];
     arr[top--]=0;
     return temp;
   }
 
   public boolean isEmpty(){
     return (top==-1);
   }
 
   private boolean isStackFull(){
     return (top==(arr.length-1));
   }
 
   public void displayStack(){
 
     if (isEmpty()) {
       System.out.println("Stack is Empty");
       return;
     } 
 
     System.out.println("_____TOP_____\n");
     for(int i=top;i>=0;i--){
       System.out.println(arr[i]);
     }
     System.out.println("\n____Bottom___");
   }
 
 }
 
 

public class withoutController {
    public static void main(String[] args) {
        stack s = new stack(7);
        
        s.push(10); //Push 10
        s.push(20); //Push 20
        s.push(30); //Push 30
        s.push(40); //Push 40
        s.push(50); //Push 50

        System.out.println(s.pop()); // Display 50
        System.out.println(s.pop()); // Display 40
        System.out.println(s.isEmpty()); // Display false
        System.out.println(s.peek()); // Display 30

        s.displayStack(); // Display 30 , 20 , 10
    }
}
