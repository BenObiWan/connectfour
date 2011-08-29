package game.connectfour.gui;

import game.connectfour.ChangedConnectFourBox;
import game.connectfour.ConnectFourBoard;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

/**
 * Panel describing a Connect Four board.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourBoardPanel extends JPanel implements Observer
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = -6934873011542636553L;

	/**
	 * Logger object.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(ConnectFourBoardPanel.class);

	/**
	 * The board represented on this panel.
	 */
	private final ConnectFourBoard _board;

	/**
	 * Creates a new ConnectFourBoardPanel.
	 * 
	 * @param board
	 *            the board to represent on this panel.
	 */
	public ConnectFourBoardPanel(final ConnectFourBoard board)
	{
		_board = board;
	}

	@Override
	public void update(final Observable o, final Object arg)
	{
		if (o instanceof ConnectFourBoard && _board.equals(o))
		{
			if (arg instanceof ChangedConnectFourBox)
			{
				final ChangedConnectFourBox changedBox = (ChangedConnectFourBox) arg;
				// TODO change the box according to the event
			}
			else
			{
				LOGGER.error("The argument of update isn't a ChangedConnectFourBox object.");
			}
		}
		else
		{
			LOGGER.error("The observable object isn't the attached board.");
		}
	}
}
