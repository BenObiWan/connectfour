package game.connectfour;

import game.common.IPlayer;

/**
 * An interface describing a Player in the connect four game.
 * 
 * @author benobiwan
 * 
 */
public interface IConnectFourPlayer extends
		IPlayer<IConnectFourPlayerConfiguration>
{
	/**
	 * Get the box played by this player.
	 * 
	 * @return the box played by this player.
	 */
	ConnectFourBox getBoxId();
}
