package SoftPrinciples.Controller.withController;

class stack{

    private int []arr;
 
    private int top=-1;
 
   public stack(int size){ 
     arr=new int[size];
   }
 
    void push(int num){
 
    if(isStackFull()){

        int [] temp=new int[arr.length*2];

        for (int i = 0; i < arr.length; i++) {
            temp[i]=arr[i];
        }
        arr=temp;
        
    }

    arr[++top]=num;
   }
 
  int peek(){
 
     if (isEmpty()) {
       System.out.println("Stack is Empty");
       return 0;
     }
 
     return arr[top];
   }
 
   int pop(){
 
     if (isEmpty()) {
       System.out.println("Stack is Empty");
       return 0;
     }
 
     int temp = arr[top];
     arr[top--]=0;
     return temp;
   }
 
    boolean isEmpty(){
     return (top==-1);
   }
 
   private boolean isStackFull(){
     return (top==(arr.length-1));
   }
 
    void displayStack(){
 
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

 class stackController{

    private stack s;

    stackController(){   
        s=new stack(10); // Setting initial size of stack to 10.
    }

    public void push(int num){
        s.push(num);
    }

    public int pop(){
        return s.pop();
    }

    public int peek(){
        return s.peek();
    }

    public boolean isEmpty(){
        return s.isEmpty();
    }

    public void displayStack(){
        s.displayStack();
    }

 }

public class withController {
    public static void main(String[] args) {
        stackController st = new stackController();
        
        st.push(10); //Push 10
        st.push(20); //Push 20
        st.push(30); //Push 30
        st.push(40); //Push 40
        st.push(50); //Push 50

        System.out.println(st.pop()); // Display 50
        System.out.println(st.pop()); // Display 40
        System.out.println(st.isEmpty()); // Display false
        System.out.println(st.peek()); // Display 30

        st.displayStack(); // Display 30 , 20 , 10
    }
}



 
 


