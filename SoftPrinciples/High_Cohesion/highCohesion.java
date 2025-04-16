 package SoftPrinciples.High_Cohesion;

 /*  Both stack and Queue classes are responsible for handling their own
  well-defined responsibility instead of handling irrelevant responsibilities/functionality.
   For Example : stack class only focuses on its main functionality such as push (add element to stack)
    , pop (remove top element from stack) etc*/

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

 class Queue{

    private int arr[];
    private int end;

    Queue(int initialSize){
        end=-1;
        arr=new int[initialSize];
    }

    void enQueue(int data){
        if (isArrayFull()) {
            int [] temp = new int[arr.length*2];

            for(int i=0;i<arr.length;i++){
                temp[i]=arr[i];
            }
            arr=temp;
            arr[++end]=data;
            return;
        }
        arr[++end]=data;
    }

    int deQueue(){

        if (isEmpty()) {
            System.out.println("Empty Queue");
            return Integer.MIN_VALUE;
        }

        int temp=arr[0];
        arr[0]=0;

        for (int i = 0; i <= end; i++) {
            if(i==arr.length-1){
                arr[arr.length-1]=0;
                break;
            }
            arr[i]=arr[i+1];
        }
        end--;
        return temp;
    }
    
    int peek(){
        return arr[0];
    }

    boolean isEmpty(){
        return  (end==-1);
    }

    private boolean isArrayFull(){
        return (end+1)==arr.length; 
    }
    
    int size(){
        return end+1;
    }

    void displayQueue(){
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }
        System.out.print("Queue : ");
        for (int i = 0; i <= end; i++) {
            if (i==end) {
                System.out.print(arr[i]);
                break;
            }
            System.out.print(arr[i]+" <-- ");
        }
        System.out.println();
    }

}