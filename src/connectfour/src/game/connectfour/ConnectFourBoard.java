package game.connectfour;

import java.util.Observable;

/**
 * Object describing the board for a connect four game.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourBoard extends Observable
{
	/**
	 * Array of Boxes.
	 */
	private final ConnectFourBox[][] _boxes;

	/**
	 * Configuration of this connect four game.
	 */
	private final IConnectFourConfiguration _config;

	/**
	 * Creates a new ConnectFourBoard.
	 * 
	 * @param config
	 *            configuration of this connect four game.
	 */
	public ConnectFourBoard(final IConnectFourConfiguration config)
	{
		_config = config;
		_boxes = new ConnectFourBox[_config.getNumberOfColumns()][_config
				.getNumberOfRows()];
		resetBoard();
	}

	/**
	 * Reset the board by setting all of it's boxes as empty.
	 */
	public void resetBoard()
	{
		for (int i = 0; i < _config.getNumberOfColumns(); i++)
		{
			for (int j = 0; j < _config.getNumberOfRows(); j++)
			{
				_boxes[i][j] = ConnectFourBox.EMPTY;
			}
		}
	}

	/**
	 * Check whether the specified column is playable.
	 * 
	 * @param iColumn
	 *            the column number.
	 * @return true if the specified column is playable.
	 */
	public boolean isColumnPlayable(final int iColumn)
	{
		if (iColumn >= _config.getNumberOfColumns() || iColumn < 0)
		{
			return false;
		}
		return _boxes[iColumn][_config.getNumberOfRows() - 1]
				.equals(ConnectFourBox.EMPTY);
	}

	/**
	 * Play in the specified column.
	 * 
	 * @param iColumnNbr
	 *            the column number.
	 * @param player
	 *            the player playing.
	 * @return true if the column was played.
	 */
	public boolean playInColumn(final int iColumnNbr,
			final IConnectFourPlayer player)
	{
		if (!isColumnPlayable(iColumnNbr))
		{
			return false;
		}
		for (int j = 0; j < _config.getNumberOfRows(); j++)
		{
			if (_boxes[iColumnNbr][j].equals(ConnectFourBox.EMPTY))
			{
				_boxes[iColumnNbr][j] = player.getBoxId();
				final ChangedConnectFourBox observerArg = new ChangedConnectFourBox(
						iColumnNbr, j, player.getBoxId());
				setChanged();
				notifyObservers(observerArg);
				return true;
			}
		}
		// this should never happened
		return false;
	}

	/**
	 * Get the content of the specified box.
	 * 
	 * @param iColumn
	 *            the column of the box.
	 * @param iRow
	 *            the box.
	 * @return the content of the specified box.
	 */
	public ConnectFourBox getBox(final int iColumn, final int iRow)
	{
		if (iColumn >= _config.getNumberOfColumns() || iColumn < 0)
		{
			throw new IllegalArgumentException();
		}
		if (iRow >= _config.getNumberOfRows() || iRow < 0)
		{
			throw new IllegalArgumentException();
		}
		return _boxes[iColumn][iRow];
	}

	/**
	 * Number of columns of this connect four board.
	 * 
	 * @return the number of columns of this connect four board.
	 */
	public int getNumberOfColumns()
	{
		return _config.getNumberOfColumns();
	}

	/**
	 * Number of rows of this connect four board.
	 * 
	 * @return the number of rows of this connect four board.
	 */
	public int getNumberOfRows()
	{
		return _config.getNumberOfRows();
	}
}
