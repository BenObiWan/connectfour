package game.connectfour.action;

/**
 * Action of playing a column in the Connect Four Game.
 * 
 * @author benobiwan
 * 
 */
public final class PlayColumnConnectFourGameAction extends
		AbstractConnectFourGameAction
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 7499397885726713567L;

	/**
	 * Number of the played column.
	 */
	private final int _iColumnPlayed;

	/**
	 * Creates a new PlayLineConnectFourGameAction.
	 * 
	 * @param iGameId
	 *            the id of the game.
	 * @param iPlayerId
	 *            id of the player doing the action.
	 * @param iColumnPlayed
	 *            the number of the played column.
	 */
	public PlayColumnConnectFourGameAction(final int iGameId,
			final int iPlayerId, final int iColumnPlayed)
	{
		super(ConnectFourGameActionType.PLAY_COLUMN, iGameId, iPlayerId);
		_iColumnPlayed = iColumnPlayed;
	}

	/**
	 * Get the number of the played column.
	 * 
	 * @return the number of the played column.
	 */
	public int getColumnPlayed()
	{
		return _iColumnPlayed;
	}
}
