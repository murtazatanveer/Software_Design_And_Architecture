package Patterns;

// we create only one instnce of this stack class

class stack{

    private static final stack st = new stack(10);

    private int []arr;
 
    private int top=-1;
 
   private stack(int size){ 
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

   public static stack getStackInstance(){return st;}
 
 }


