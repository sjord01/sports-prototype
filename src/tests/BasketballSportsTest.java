import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasketballSportsTest
{

    @Test
    void testThreePointShot()
    {
        BasketballPlayer player = new BasketballPlayer("John", "Doe", 190.0, 20, 5);
        BasketballTeam team = new BasketballTeam("Team A");

        BasketballSports sports = new BasketballSports(player);

        String ex = "John from Team A scored three points!";
        String actual = sports.threePointShot(true, 7.0, team);

        assertEquals(ex, actual);
    }

    @Test
    void testTravellingPenalty()
    {
        BasketballPlayer player = new BasketballPlayer("John", "Doe", 190.0, 20, 5);
        BasketballTeam team = new BasketballTeam("Team A");

        BasketballSports sports = new BasketballSports(player);

        String ex = "John from Team A committed a travelling penalty!";
        String actual = sports.travellingPenalty(true, 4, team);

        assertEquals(ex, actual);
    }

    @Test
    void testFiveSecondsCloselyGuardedPenalty()
    {
        BasketballPlayer player = new BasketballPlayer("John", "Doe", 190.0, 20, 5);
        BasketballTeam team = new BasketballTeam("Team A");

        BasketballSports sports = new BasketballSports(player);

        String ex = "John from Team A committed a five-second closely guarded penalty!";
        String actual = sports.fiveSecondsCloselyGuardedPenalty(true, 5, team);

        assertEquals(ex, actual);
    }
}