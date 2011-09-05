package game.connectfour.server;

import game.connectfour.IConnectFourPlayer;
import game.connectfour.IConnectFourPlayerConfiguration;
import game.gameserver.IServerSidePlayer;

/**
 * An interface describing a Player in the connect four game.
 * 
 * @author benobiwan
 * 
 */
public interface IConnectFourServerSidePlayer extends
		IServerSidePlayer<IConnectFourPlayerConfiguration>, IConnectFourPlayer
{
	// TODO IServerSideConnectFourPlayer
}
