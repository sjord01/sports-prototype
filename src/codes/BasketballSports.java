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

    private final Map<String, BasketballTeam> basketBallTeams;

    public BasketballSports(Map<String, BasketballTeam> basketBallTeams)
    {
        this.basketBallTeams = new HashMap<>();
    }

    public void addBasketBallTeamToLeague(final BasketballTeam newBasketballTeam)
    {
        this.basketBallTeams.put(newBasketballTeam.getBasketballTeamName(), newBasketballTeam);
    }

    public void threePointShot(final boolean ballIn,
                               final double playerPositionFromCentreOfBasketMeter,
                               final BasketballTeam basketballTeam)
    {
        // Check if the points scored are valid according to international rules
        if(ballIn && playerPositionFromCentreOfBasketMeter > THREE_PT_ARC_DISTANCE_FROM_CENTRE_OF_BASKET_METER)
        {
            System.out.println(basketballTeam.getBasketballPlayer().getPlayerFirstName() + " from " + basketballTeam.getBasketballTeamName() + " scored three points!");
        }
        else if(ballIn && playerPositionFromCentreOfBasketMeter < THREE_PT_ARC_DISTANCE_FROM_CENTRE_OF_BASKET_METER)
        {
            System.out.println(basketballTeam.getBasketballPlayer().getPlayerFirstName() + " from " + basketballTeam.getBasketballTeamName() + " scored two points!");
        }
        else
            System.out.println(basketballTeam.getBasketballPlayer().getPlayerFirstName() + " from " + basketballTeam.getBasketballTeamName() + " failed to score!");
    }

    public void travellingPenalty(final boolean hasBall,
                                  final int stepsDribbling,
                                  final BasketballTeam basketballTeam)
    {
        if (hasBall && stepsDribbling >= MAX_STEPS_WITHOUT_DRIBBLING)
        {
            System.out.println(basketballTeam.getBasketballPlayer().getPlayerFirstName() + " from " + basketballTeam.getBasketballTeamName() + " committed a travelling penalty!");
        }
        else
        {
            System.out.println(basketballTeam.getBasketballPlayer().getPlayerFirstName() + " from " + basketballTeam.getBasketballTeamName()+ " did not commit a travelling penalty.");
        }
    }

    public void fiveSecondsCloselyGuardedPenalty(final boolean isGuarded,
                                                 final int playerHasBallInSeconds,
                                                 final BasketballTeam basketballTeam)
    {
        if (isGuarded && playerHasBallInSeconds >= 5)
        {
            System.out.println(basketballTeam.getBasketballPlayer().getPlayerFirstName() + " from " + basketballTeam.getBasketballTeamName() + " committed a five-second closely guarded penalty!");
        }
        else
        {
            System.out.println(basketballTeam.getBasketballPlayer().getPlayerFirstName() + " from " + basketballTeam.getBasketballTeamName() + " did not commit a five-second closely guarded penalty.");
        }
    }


}
