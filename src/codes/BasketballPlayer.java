/**
 * Session 7 Lab: Designing a sports league program
 * Outline for a program that supports players, teams, and a league.

 * @author Emma Lee, Samson Ordonez
 * @version 2024
 */

public class BasketballPlayer
{
    private final String playerFirstName;
    private final String playerLastName;
    private final double playerHeightCm;
    private final String playerID;

    private int playerAge;
    private int skillLevel;

    public BasketballPlayer(final String playerFirstName,
                            final String playerLastName,
                            final double playerHeightCm,
                            final int playerAge,
                            final int skillLevel)
    {
        if(playerAge < 18 || playerAge > 22)
        {
            throw new IllegalArgumentException("Age: "+ playerAge +". NOT VALID. The league only accepts 18-22 years old");
        }


        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.playerHeightCm = playerHeightCm;
        this.playerAge = playerAge;
        this.skillLevel = skillLevel;
        this.playerID = generatePlayerID();
    }

    public String getPlayerFirstName()
    {
        return playerFirstName;
    }

    public String getPlayerLastName()
    {
        return playerFirstName;
    }

    public double getPlayerHeightCm()
    {
        return playerHeightCm;
    }

    public String getPlayerID() {
        return playerID;
    }

    public int getPlayerAge()
    {
        return playerAge;
    }

    public void setPlayerAge(final int playerAge)
    {
        this.playerAge = playerAge;
    }

    public int getSkillLevel()
    {
        return skillLevel;
    }

    public void setSkillLevel(final int skillLevel)
    {
        this.skillLevel = skillLevel;
    }

    public String generatePlayerID()
    {
        final StringBuilder sb;

        sb = new StringBuilder();

        // Append first two characters of first name, or entire name if less than two characters
        if(playerFirstName.length() >= 2)
        {
            sb.append(playerFirstName.substring(0, 2).toUpperCase());
        }
        else
        {
            sb.append(playerFirstName.toUpperCase());
        }

        // Append first two characters of last name, or entire name if less than two characters
        if(playerLastName.length() >= 2)
        {
            sb.append(playerLastName.substring(0, 2).toUpperCase());
        }
        else
        {
            sb.append(playerLastName.toUpperCase());
        }

        // Append player height without decimal points
        sb.append((int) playerHeightCm);

        return sb.toString();
    }
}