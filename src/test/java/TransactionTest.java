import com.AndySam.Customer.Customer;
import com.AndySam.Customer.Purse;
import com.AndySam.Customer.Shopping;
import com.AndySam.Money.Coins;
import com.AndySam.Products.Products;
import com.AndySam.VendingMachine.Stock;
import com.AndySam.VendingMachine.Till;
import com.AndySam.VendingMachine.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TransactionTest {
    Transaction transaction;
    Till till;
    Coins coin1;
    Coins coin2;
    Coins coin10p;
    Coins coin20p;
    Coins coin50p;
    Products product;
    Stock stock;
    ArrayList<Coins> coinReturn;
    ArrayList<Coins> customerCoins;
    Shopping shopping;
    Customer customer;

    Purse purse;

    @Before
    public void before(){
        coin1 = Coins.ONE_POUND;
        coin2 = Coins.TWO_POUND;
        coin10p = Coins.TEN_PENCE;
        coin20p = Coins.TWENTY_PENCE;
        coin50p = Coins.FIFTY_PENCE;
        customerCoins = new ArrayList<>();
        customerCoins.add(coin1);
        purse = new Purse();
        purse.addCoinToPurse(coin1);
        purse.addCoinToPurse(coin2);
        customer = new Customer("John Doe", purse, shopping);
        till = new Till();
        coinReturn = new ArrayList<>();
        product = new Products("BB11", "Pepsi", 1);
        stock = new Stock();
        stock.addProductToStock(product);
        shopping = new Shopping();
        transaction = new Transaction(0, coinReturn, product, till, stock, shopping);
    }

    @Test
    public void canPurchaseProduct(){
        transaction.purchaseProcess("BB11", customerCoins, customer);
        assertEquals(1.0, till.getTotalTillValue(), 0.0);
        assertEquals(false, stock.getStock().contains(product));
        assertEquals(true, customerCoins.isEmpty());
        assertEquals(true, shopping.getPurchases().contains(product));
        assertEquals(false, coinReturn.contains(coin1));
    }
}
