package game.connectfour;

/**
 * Object describing a box that has changed state.
 * 
 * @author benobiwan
 * 
 */
public final class ChangedConnectFourBox
{
	/**
	 * The column of the box.
	 */
	private final int _iColumn;

	/**
	 * The row of the box.
	 */
	private final int _iRow;

	/**
	 * The new state of the box.
	 */
	private final ConnectFourBox _newState;

	/**
	 * Creates a new ChangedConnectFourBox.
	 * 
	 * @param iColumn
	 *            the column of the box.
	 * @param iRow
	 *            the row of the box.
	 * @param newState
	 *            the new state of the box.
	 */
	public ChangedConnectFourBox(final int iColumn, final int iRow,
			final ConnectFourBox newState)
	{
		_iColumn = iColumn;
		_iRow = iRow;
		_newState = newState;
	}

	/**
	 * Get the column of the box.
	 * 
	 * @return the column of the box.
	 */
	public int getColumn()
	{
		return _iColumn;
	}

	/**
	 * Get the row of the box.
	 * 
	 * @return the row of the box.
	 */
	public int getRow()
	{
		return _iRow;
	}

	/**
	 * Get the new state of the box.
	 * 
	 * @return the new state of the box.
	 */
	public ConnectFourBox getNewState()
	{
		return _newState;
	}
}
