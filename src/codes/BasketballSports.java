import java.util.HashMap;
import java.util.Map;

/**
 * Session 7 Lab: Designing a sports league program
 * Outline for a program that supports players, teams, and a league.

 * @author Emma Lee, Samson Ordonez
 * @version 2024
 */

public class BasketballSports
{
    public static final double  THREE_PT_ARC_DISTANCE_FROM_CENTRE_OF_BASKET_METER = 6.75;
    public static final int     MAX_STEPS_WITHOUT_DRIBBLING = 3;
    public static final int     MAX_SECONDS_CLOSELY_GUARDED = 5;

    private final BasketballPlayer            basketballPlayer;
    private final Map<String, BasketballTeam> basketBallTeam;

    public BasketballSports(final BasketballPlayer basketballPlayer)
    {
        this.basketballPlayer = basketballPlayer;
        this.basketBallTeam = new HashMap<>();
    }

    public BasketballPlayer getBasketballPlayer()
    {
        return basketballPlayer;
    }
    public void addBasketBallTeamToLeague(final BasketballTeam newBasketballTeam)
    {
        this.basketBallTeam.put(newBasketballTeam.getBasketballTeamName(), newBasketballTeam);
    }

    public String threePointShot(final boolean ballIn,
                                 final double playerPositionFromCentreOfBasketMeter,
                                 final BasketballTeam basketballTeam)
    {
        final StringBuilder sb;

        sb = new StringBuilder();

        // Check if the points scored are valid according to international rules
        if(ballIn && playerPositionFromCentreOfBasketMeter > THREE_PT_ARC_DISTANCE_FROM_CENTRE_OF_BASKET_METER)
        {
            sb.append(basketballPlayer.getPlayerFirstName())
                    .append(" from ")
                    .append(basketballTeam.getBasketballTeamName())
                    .append(" scored three points!");
        }
        else if(ballIn && playerPositionFromCentreOfBasketMeter < THREE_PT_ARC_DISTANCE_FROM_CENTRE_OF_BASKET_METER)
        {
            sb.append(basketballPlayer.getPlayerFirstName())
                    .append(" from ")
                    .append(basketballTeam.getBasketballTeamName())
                    .append(" scored two points!");
        }
        else
        {
            sb.append(basketballPlayer.getPlayerFirstName())
                    .append(" from ")
                    .append(basketballTeam.getBasketballTeamName())
                    .append(" failed to score!");
        }
        return sb.toString();
    }

    public String travellingPenalty(final boolean hasBall,
                                    final int stepsDribbling,
                                    final BasketballTeam basketballTeam)
    {
        final StringBuilder sb;

        sb = new StringBuilder();

        if(hasBall && stepsDribbling >= MAX_STEPS_WITHOUT_DRIBBLING)
        {
            sb.append(basketballPlayer.getPlayerFirstName())
                    .append(" from ")
                    .append(basketballTeam.getBasketballTeamName())
                    .append(" committed a travelling penalty!");
        }
        else
        {
            sb.append(basketballPlayer.getPlayerFirstName())
                    .append(" from ")
                    .append(basketballTeam.getBasketballTeamName())
                    .append(" did not commit a travelling penalty.");
        }
        return sb.toString();
    }

    public String fiveSecondsCloselyGuardedPenalty(final boolean isGuarded,
                                                   final int playerHasBallInSeconds,
                                                   final BasketballTeam basketballTeam)
    {
        final StringBuilder sb;

        sb = new StringBuilder();

        if(isGuarded && playerHasBallInSeconds >= 5)
        {
            sb.append(basketballPlayer.getPlayerFirstName())
                    .append(" from ")
                    .append(basketballTeam.getBasketballTeamName())
                    .append(" committed a five-second closely guarded penalty!");
        }
        else
        {
            sb.append(basketballPlayer.getPlayerFirstName())
                    .append(" from ")
                    .append(basketballTeam.getBasketballTeamName())
                    .append(" did not commit a five-second closely guarded penalty.");
        }
        return sb.toString();
    }
}
