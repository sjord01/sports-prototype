import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BasketballTeamTest {

    private BasketballTeam team;
    private BasketballPlayer player1;
    private BasketballPlayer player2;

    @BeforeEach
    void setUp() {
        player1 = new BasketballPlayer("John", "Doe", 190.0, 20, 5);
        player2 = new BasketballPlayer("Jane", "Smith", 180.0, 21, 4);
        team = new BasketballTeam("Team A");
        team.addBasketballPlayer(player1); // Add player1 to the team
    }

    @AfterEach
    void tearDown() {
        team = null;
    }

    @Test
    void testAddAndRemoveBasketballPlayer() {
        // Test adding a player
        team.addBasketballPlayer(player2);
        assertEquals(2, team.getFormattedBasketballTeamData().split(", ").length);

        // Test removing a player
        team.removeBasketballPlayer(player1.getPlayerID());
        assertEquals(1, team.getFormattedBasketballTeamData().split(", ").length);
    }

    @Test
    void testGetFormattedBasketballTeamData() {
        // Test formatting team data
        String expectedOutput = "Team A has 1 player: John Doe.";
        assertEquals(expectedOutput, team.getFormattedBasketballTeamData());
    }
}