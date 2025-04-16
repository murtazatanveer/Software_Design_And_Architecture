 package SoftPrinciples.Polymorphism;

 interface area{
    double calculateArea();
 }

 class rectangle implements area{

    double length;
    double width;

    rectangle(double length , double width){
        this.length=length;
        this.width=width;
    }

    public double calculateArea(){
        return (length*width);
    }

 }

 class circle implements area{

    double radius;
    

    circle(double radius){
        this.radius=radius;
    }

    public double calculateArea(){
        return 3.14*(Math.pow(radius, 2));
    }

 }

 class shapes{

    double calculateArea(area sha){
        return sha.calculateArea();
    }
   
 }


public class polymorphism {

    public static void main(String[] args) {
        
        shapes s = new shapes();
        System.out.println(s.calculateArea(new circle(2.5)));
        System.out.println(s.calculateArea(new rectangle(5, 10)));


    }
    
}