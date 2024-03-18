package hammurabi;
import org.junit.Test;
import static org.junit.Assert.*;

public class HammurabiTest {

    @Test
    public final void testHarvest() {
        int[] yield = new int[7];
        for (int i = 0; i < 1000; i++) {
            int harvest = Hammurabi.harvest(1);
            assertTrue("Illegal harvest per acre: " + harvest, harvest > 0 && harvest <= 6);
            yield[harvest] += 1;
        }
        for (int j = 1; j <= 6; j++) {
            assertTrue("You never have a yield of " + j + " bushels per acre.", yield[j] > 0);
        }
    }

    @Test
    public final void testNewCostOfLand() {
        int[] cost = new int[24];
        for (int i = 0; i < 1000; i++) {
            int price = Hammurabi.newCostOfLand();
            assertTrue("Illegal cost of land: " + price, price >= 17 && price <= 23);
            cost[price] += 1;
        }
        for (int j = 17; j <= 23; j++) {
            assertTrue("You never have a land cost of " + j + " bushels per acre.", cost[j] > 0);
        }
    }

    @Test
    public final void testStarvationDeaths() {
        int deaths = Hammurabi.starvationDeaths(100, 1639);
        assertEquals("Wrong number of starvation deaths.", 19, deaths);
        deaths = Hammurabi.starvationDeaths(100, 2500);
        if (deaths < 0) {
            fail("You starved a negative number of people!");
        }
    }
}
