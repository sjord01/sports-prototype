import java.util.HashMap;
import java.util.Map;


/**
 * Session 7 Lab: Designing a sports league program
 * Outline for a program that supports players, teams, and a league.

 * @author Emma Lee, Samson Ordonez
 * @version 2024
 */

public class BasketballTeam
{
    private final BasketballPlayer              basketballPlayer;
    private final String                        basketballTeamName;
    private final Map<String, BasketballPlayer> basketballPlayers;

    public BasketballTeam(final BasketballPlayer basketballPlayer,
                          final String basketballTeamName)
    {
        this.basketballPlayer   = basketballPlayer;
        this.basketballTeamName = basketballTeamName;
        this.basketballPlayers  = new HashMap<>();
    }

    public BasketballPlayer getBasketballPlayer()
    {
        return basketballPlayer;
    }

    public String getBasketballTeamName()
    {
        return basketballTeamName;
    }

    public void addBasketballPlayer(final BasketballPlayer newBasketballPlayer)
    {
        this.basketballPlayers.put(newBasketballPlayer.generatePlayerID(), newBasketballPlayer);
    }

    public void removeBasketballPlayer(final String playerId)
    {
        final String uppercasePlayerId;

        uppercasePlayerId = playerId.toUpperCase();

        this.basketballPlayers.remove(uppercasePlayerId);
    }
}
