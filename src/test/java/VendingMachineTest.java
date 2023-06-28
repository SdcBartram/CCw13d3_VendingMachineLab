import com.AndySam.Customer.Purse;
import com.AndySam.Money.Coins;
import com.AndySam.Products.Products;
import com.AndySam.VendingMachine.Stock;
import com.AndySam.VendingMachine.Till;
import com.AndySam.VendingMachine.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class VendingMachineTest {
    Till till;
    VendingMachine vendingMachine;
    Coins coin1;
    Coins coin2;
    Coins coin10p;
    Coins coin20p;
    Coins coin50p;
    Products product;
    Products product2;
    Stock stock;

    @Before
    public void before(){
        coin1 = Coins.ONE_POUND;
        coin2 = Coins.TWO_POUND;
        coin10p = Coins.TEN_PENCE;
        coin20p = Coins.TWENTY_PENCE;
        coin50p = Coins.FIFTY_PENCE;
        till = new Till();
        till.addCoinToTill(coin1);
        till.addCoinToTill(coin2);
        till.addCoinToTill(coin10p);
        till.addCoinToTill(coin20p);
        till.addCoinToTill(coin50p);
        product = new Products("BB11", "Pepsi", 1);
        product2 = new Products("BB12", "Pepsi Max", 1);
        stock = new Stock();
        stock.addProductToStock(product);
        stock.addProductToStock(product2);
        vendingMachine = new VendingMachine(stock, till);
    }

    @Test
    public void canAddProductsToStock(){
        assertEquals(true, stock.getStock().contains(product));
    }

    @Test
    public void canGetTotalValueOfTill(){
        assertEquals(3.80, till.getTotalTillValue(),0.1);
    }

    @Test
    public void canRemoveCoinFromTill(){
        till.removeCoinFromTill(coin50p);
        assertEquals(3.3, till.getTotalTillValue(), 0.1);
    }

    @Test
    public void canRemoveProductsFromStock(){
        stock.removeProductFromStock(product2);
        assertEquals(!true, stock.getStock().contains(product2));
    }
}
