import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


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

    public void printAllBasketballTeamData()
    {
        if (basketballPlayers == null || basketballPlayers.isEmpty()) {
            System.out.println(basketballTeamName + " has no players.");
            return;
        }
        System.out.printf("%s has %d players: ", basketballTeamName, basketballPlayers.size());

        final Set<String> keys;
        final Iterator<String> it;

        keys    = basketballPlayers.keySet();
        it      = keys.iterator();

        int playerCount = 0;
        while(it.hasNext())
        {
            final String            theNextKey;
            final BasketballPlayer  player;

            theNextKey  = it.next();
            player     = this.basketballPlayers.get(theNextKey);

            if(player != null)
            {
                if(player.getPlayerFirstName() != null && player.getPlayerLastName() != null
                    && !player.getPlayerFirstName().isBlank() && !player.getPlayerLastName().isBlank())
                {
                    System.out.print(player.getPlayerFirstName() + " " + player.getPlayerLastName());
                }

                // Check if there are more players
                if(it.hasNext())
                {
                    System.out.print(", ");
                }
                else
                {
                    // If it's the last player, print a period instead of a comma
                    System.out.print(".");
                }
                playerCount++;

            }
        }
    }
}
