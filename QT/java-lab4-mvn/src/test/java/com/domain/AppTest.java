package domain;

import com.cart.Cart;
import com.cart.Product;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AppTest {

    @Test
    public void testGeneralCartGeneralProduct() {
        Cart generalCart = new Cart(1,"General");
        Cart dealCart = new Cart(2,"Deal");
        Product spring = new Product("Spring",false);

        assertEquals(1, generalCart.getCartId());
        assertNotEquals(2, generalCart.getCartId());
        assertEquals(true, generalCart.addProduct(spring));
        assertEquals(1, generalCart.getProducts().size());
        assertEquals("Spring",generalCart.getProducts().get(0).getName());
    }

    @Test
    public void testDealCartGeneralProduct() {
        Cart dealCart = new Cart(2,"Deal");
        Product spring = new Product("Spring",false);

        assertEquals(2, dealCart.getCartId());
        assertEquals(false, dealCart.addProduct(spring));
        assertEquals(0, dealCart.getProducts().size());
    }

    @Test
    public void testDealCartDealProduct() {
        Cart dealCart = new Cart(2,"Deal");
        Product spring = new Product("Sumner",true);

        assertEquals(2, dealCart.getCartId());
        assertEquals(true, dealCart.addProduct(spring));
        assertEquals(1, dealCart.getProducts().size());
        assertEquals("Sumner",dealCart.getProducts().get(0).getName());
    }
}
