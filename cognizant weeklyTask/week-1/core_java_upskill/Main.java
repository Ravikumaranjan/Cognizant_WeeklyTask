class Car{

    String make;
    String model;
    int year;

    Car(String make,String model,int year){
        this.make=make;
        this.model=model;
        this.year=year;
    }

    void displayDetails(){
        System.out.println(make+" "+model+" "+year);
    }
}

public class Main{

    public static void main(String[] args){

        Car c1=new Car("Honda","City",2022);
        Car c2=new Car("Hyundai","i20",2023);

        c1.displayDetails();
        c2.displayDetails();
    }
}