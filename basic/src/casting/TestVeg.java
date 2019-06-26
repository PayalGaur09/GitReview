package casting;

public class TestVeg {
    public static void main(String[] args){
        GetVegetable gv= new GetVegetable();
        Vegetable v= gv.getVegetable("Aloo");
        v.price=10;
        v.quantity=2.5f;
        v.color="Brown";
        Aloo a= (Aloo)v;
        a.makePranthe();

    }
}
