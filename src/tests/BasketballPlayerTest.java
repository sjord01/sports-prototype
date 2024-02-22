import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketballPlayerTest {
    BasketballPlayer b1;
    BasketballPlayer b2;

    @BeforeEach
    void setUp() {
        b1 = new BasketballPlayer("JoHn", "DOe", 198.6, 18, 4);
        b2 = new BasketballPlayer("xu", "Li", 180.4, 22, 4);
    }

    @AfterEach
    void tearDown() {
        b1 = null;
        b2 = null;
    }

    @Test
    void getExpectedExceptionsPlayerAge() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            b1 = new BasketballPlayer("JoHn", "DOe", 198.6, 46, 4);
        });
        assertTrue(ex.getMessage().equals("Age: 46. NOT VALID. The league only accepts 18-22 years old"));

        ex = assertThrows(IllegalArgumentException.class, () -> {
            b2 = new BasketballPlayer("JoHn", "DOe", 198.6, 17, 4);
        });
        assertTrue(ex.getMessage().equals("Age: 17. NOT VALID. The league only accepts 18-22 years old"));
    }
}