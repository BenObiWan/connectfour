package game.connectfour;

import game.config.IPlayerConfiguration;

/**
 * Configuration for the player in the connect four game.
 * 
 * @author benobiwan
 * 
 */
public interface IConnectFourPlayerConfiguration extends IPlayerConfiguration
{
	/**
	 * Get the box played by this player.
	 * 
	 * @return the box played by this player.
	 */
	ConnectFourBox getBoxId();
}
