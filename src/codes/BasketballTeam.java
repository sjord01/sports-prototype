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
    private final String                        basketballTeamName;
    private final Map<String, BasketballPlayer> basketballPlayers;

    public BasketballTeam(final String basketballTeamName)
    {
        this.basketballTeamName = basketballTeamName;
        this.basketballPlayers = new HashMap<>();
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

    public String getFormattedBasketballTeamData()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(basketballTeamName).append(" has ");

        if (basketballPlayers == null || basketballPlayers.isEmpty())
        {
            sb.append("no players.");
        }
        else
        {
            int numPlayers = basketballPlayers.size();
            sb.append(numPlayers).append(" player").append(numPlayers > 1 ? "s" : "").append(": ");

            final Set<String> keys;
            final Iterator<String> it;

            keys    = basketballPlayers.keySet();
            it      = keys.iterator();

            while (it.hasNext()) {
                final String            theNextKey;
                final BasketballPlayer  player;

                theNextKey = it.next();
                player     = this.basketballPlayers.get(theNextKey);

                sb.append(player.getPlayerFirstName()).append(" ").append(player.getPlayerLastName());

                // Check if there are more players
                if(it.hasNext())
                {
                    sb.append(", ");
                }
                else
                {
                    sb.append(".");
                }
            }
        }
        return sb.toString();
    }
}
