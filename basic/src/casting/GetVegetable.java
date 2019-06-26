package casting;

public class GetVegetable {
    Aloo a= new Aloo();
    Tomato t= new Tomato();
    public Vegetable getVegetable(String veg) {
        if (veg.equalsIgnorCase("Aloo")) {
            return a;

        } else if (veg.equalsIgnorCase("Tomato")) {
            return t;

        } else {
            System.out.println(veg +" nahi hain, kahi aur se lelo.")

        }
    }
}
