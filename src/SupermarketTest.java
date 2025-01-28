import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SupermarketTest {
    private Account account;
    private Catalog catalog;

    @BeforeEach
    void setUp() {
        catalog = new Catalog();
        catalog.addCatalogProduct("Milk", 12);
        catalog.addCatalogProduct("Cheese", 15);
        catalog.addCatalogProduct("Yogurt", 10);
        account = new Account(catalog);
    }

    @Test
    void testTotalAmountWithThreeProducts() {
        account.addProduct("Milk",100);
        account.addProduct("Cheese",510);
        account.addProduct("Yogurt",820);
        double expectedTotal = (100* 12) + (510 * 15) + (820 * 10);
        assertEquals(expectedTotal, account.calcTotalAmount(), 0.001);
    }

    @Test
    void testTotalAmountOfEmptyAccount() {
        assertEquals(0.0, account.calcTotalAmount(), 0.001);
    }

    @Test
    void testAddAndRemoveItemResultsInEmptyAccount() {
        account.addProduct("Milk",10);
        account.removeProduct("Milk");
        assertEquals(0, account.calcNumOfDiffProds());
    }
    @Test
    void testAddingTwoProductsResultsInTwoProductsInAccount() {
        account.addProduct("Milk", 100);
        account.addProduct("Cheese", 200);
        assertEquals(2, account.calcNumOfDiffProds()); // Check product count
    }

    @Test
    void testTotalAmountHalvedAfter50PercentDiscount() {
        account.addProduct("Milk",150);
        account.addProduct("Cheese",200);
        double totalBeforeDiscount = account.calcTotalAmount();
        account.applyGlobalDiscount(0.5);
        double totalAfterDiscount = account.calcTotalAmount();
        assertEquals(totalBeforeDiscount / 2, totalAfterDiscount, 0.001);
    }

    @Test
    void testChangingQuantityTwiceEqualsLastUpdate() {
        account.addProduct("Milk",1);
        account.changeQuantity("Milk", 500);
        account.changeQuantity("Milk", 300);
        assertEquals(300, account.getQuantity("Milk"));
    }

    @Test
    void testDisplayQuantityForNonExistentItem() {
        assertEquals(0, account.getQuantity("Eggs")); // No exception expected
    }
}
