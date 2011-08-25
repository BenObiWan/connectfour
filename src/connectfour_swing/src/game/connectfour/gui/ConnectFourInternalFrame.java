package game.connectfour.gui;

import javax.swing.JInternalFrame;

/**
 * Main internal frame for the connect four game.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourInternalFrame extends JInternalFrame
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 1153938461766239388L;

	/**
	 * The main panel of this frame.
	 */
	private final ConnectFourPanel _mainPanel;

	/**
	 * The menu to use on this frame.
	 */
	private final ConnectFourMenuBar _mainMenu;

	/**
	 * Creates a new ConnectFourInternalFrame.
	 */
	public ConnectFourInternalFrame()
	{
		super(ConnectFourPanel.FRAME_NAME, false, true, false, true);
		_mainPanel = new ConnectFourPanel();
		_mainMenu = new ConnectFourMenuBar(_mainPanel);
		setContentPane(_mainPanel);
		setJMenuBar(_mainMenu);
	}
}
