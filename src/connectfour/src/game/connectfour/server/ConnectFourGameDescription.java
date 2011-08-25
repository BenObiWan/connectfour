package game.connectfour.server;

import game.common.AbstractGameDescription;

/**
 * Description for a Connect four game, be it in creation or currently in play.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourGameDescription extends AbstractGameDescription
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 4744501383482890839L;

	/**
	 * Creates a new ConnectFourGameDescription.
	 * 
	 * @param iGameId
	 *            the id of the game.
	 * @param strCreatorName
	 *            the name of the game creator.
	 * @param iNumberOfPlayer
	 *            the current number of player of this game.
	 */
	public ConnectFourGameDescription(final int iGameId,
			final String strCreatorName, final int iNumberOfPlayer)
	{
		super(iGameId, strCreatorName, iNumberOfPlayer);
	}

	@Override
	public String getGameType()
	{
		return "ConnectFour";
	}

	@Override
	public int getMaximumNumberOfPlayer()
	{
		return 2;
	}
}
