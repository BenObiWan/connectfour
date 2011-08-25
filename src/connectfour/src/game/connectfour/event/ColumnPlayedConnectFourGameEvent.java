package game.connectfour.event;

/**
 * Event sent when a column is played in Connect Four.
 * 
 * @author benobiwan
 * 
 */
public final class ColumnPlayedConnectFourGameEvent extends
		AbstractConnectFourGameEvent
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 4358656313419194428L;

	/**
	 * Number of the played column.
	 */
	private final int _iColumnPlayed;

	/**
	 * Creates a new LinePlayedConnectFourGameEvent.
	 * 
	 * @param iGameId
	 *            the id of the game.
	 * @param iPlayerId
	 *            id of the player concerned by the event.
	 * @param iColumnPlayed
	 *            the number of the played column.
	 */
	public ColumnPlayedConnectFourGameEvent(final int iGameId,
			final int iPlayerId, final int iColumnPlayed)
	{
		super(ConnectFourGameEventType.COLUMN_PLAYED, iGameId, iPlayerId);
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
