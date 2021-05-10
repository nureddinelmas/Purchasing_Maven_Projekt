import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaserTest {

    //Skapa en produkt med specifika egenskaper
    @Test
    public void CreateProduct(){
        Product soffa = new Product(4000, 35);

        assertEquals(4000, soffa.getPrice());
        assertEquals(35, soffa.getWeight());
    }

    //Skapa en varukorg, och se att den är tomt
    @Test
    public void CreateEmptyCart(){
        Cart cart = new Cart();

        assertEquals(0, cart.totalPrice());
        assertEquals(0,cart.shippingCost());
        assertEquals(0, cart.numberOfItems());

    }

    // Skapa en varukorg, lägga till produkter,
    // Hämta totalpris och fraktkostnad
    @Test
    public void CreateNoneEmptyCart(){
        Cart cart = new Cart();

        Product soffa = new Product(4000, 35);
        Product stol = new Product(250, 3);

        cart.AddProduct(soffa);
        cart.AddProduct(stol);

        assertEquals(4250, cart.totalPrice());
        assertEquals(99,cart.shippingCost());
        assertEquals(2, cart.numberOfItems());

        cart.AddProduct(soffa);

        assertEquals(199, cart.shippingCost());
    }

    //Hantera om vi lägger till "null" istället för en product
    // Lägg inte till den till listan alls

    @Test
    public void AddNullCart(){
        Cart cart = new Cart();

        Product soffa = null;

        cart.AddProduct(soffa); // Här kommer något gå galet

        assertEquals(0, cart.numberOfItems());

    }
}
/*
Vi jobbar på ett varuhus som säljer möbler

Vi vill kunna lägga ihop ett antal produkter i en varkorg
och räkna ut
-totalkostnaden för alla dessa produkter
-fraktkostnaden (de berör på produkternes vikt)
- Fraken är 99 kr för allt upp till 50 kg
därefter 199 kr

* */
//TDD - Test-Driven Development