import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products = new ArrayList<>();

    public void AddProduct(Product p){
        if (p != null){
            products.add(p);
        }
    }

    public int totalPrice(){
        int total = 0;
        for (int i=0; i<products.size(); i++){
            total += products.get(i).getPrice();

        }
        return total;
    }


        public int shippingCost (){
        if (products.size() == 0){
            return 0;


        }

        int total = 0;
        for (int i = 0; i<products.size(); i++){
            total += products.get(i).getWeight();
        }
        if (total < 50){
            return 99;
        }
        return 199;
        }

        public int numberOfItems(){
        return products.size();
        }

    }


