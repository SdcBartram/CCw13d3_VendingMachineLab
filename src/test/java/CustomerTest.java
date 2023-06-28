import com.AndySam.Customer.Customer;
import com.AndySam.Customer.Purse;
import com.AndySam.Customer.Shopping;
import com.AndySam.Money.Coins;
import com.AndySam.Products.Products;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CustomerTest {

    Purse purse;
    Customer customer;

    Coins coin1;
    Coins coin2;
    Coins coin10p;

    Coins coin20p;
    Coins coin50p;

    Products product;
    Shopping shopping;



    @Before
    public void before(){
        coin1 = Coins.ONE_POUND;
        coin2 = Coins.TWO_POUND;
        coin10p = Coins.TEN_PENCE;
        coin20p = Coins.TWENTY_PENCE;
        coin50p = Coins.FIFTY_PENCE;
        purse = new Purse();
        purse.addCoinToPurse(coin1);
        purse.addCoinToPurse((coin2));
        purse.addCoinToPurse(coin10p);
        purse.addCoinToPurse(coin20p);
        product = new Products("BB02", "Yorkie", 1.00);
        shopping = new Shopping();
        shopping.addProductToShopping(product);
        customer = new Customer("Bobbi Bob", purse, shopping);
    }

    @Test
    public void canAddProductToShopping(){
        assertEquals(true, shopping.getPurchases().contains(product));
    }

    @Test
    public void canGetTotalValueOfPurse(){
        assertEquals(3.30, purse.getTotalPurseValue(),0.1);
    }

    @Test
    public void canRemoveCoinFromPurse(){
        purse.removeCoinFromPurse(coin20p);
        assertEquals(3.10, purse.getTotalPurseValue());
    }
}
