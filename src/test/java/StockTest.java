import com.AndySam.Products.Products;
import com.AndySam.VendingMachine.Stock;
import com.AndySam.VendingMachine.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockTest {
    Stock stock;
    Products product;
    Products product2;


    @Before
    public void before(){
        product = new Products("BB11", "Pepsi", 1);
        product2 = new Products("BB12", "Pepsi Max", 1);
        stock = new Stock();
        stock.addProductToStock(product);
        stock.addProductToStock(product2);
    }

    @Test
    public void canGetProductByCode(){
        assertEquals("Pepsi", stock.getProductByCode("BB11").getName());
    }
}
