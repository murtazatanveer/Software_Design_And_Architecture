package Object_Relations.Dependency;

class Area{

    double calculateArea(double len , double wid){
        return len*wid;
    }

    double calculateArea(double radius){
        return Math.PI * (Math.pow(radius, 2));
    }

}

class circle{

    private double radius;

    circle(double radius){
        this.radius=radius;
    }

    double area(){ // Dependency relation ship between class Area and circle.

        Area a = new Area();
        return a.calculateArea(radius);
    }

    double getRadius(){return radius;}
}


public class dependency {
    public static void main(String[] args) {
        circle cir = new circle(2.5);
        System.out.println(cir.area());
    }
    
}
