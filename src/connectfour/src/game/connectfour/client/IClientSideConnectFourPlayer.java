package game.connectfour.client;

import game.connectfour.IConnectFourConfiguration;
import game.connectfour.IConnectFourPlayer;
import game.connectfour.IConnectFourPlayerConfiguration;
import game.connectfour.event.AbstractConnectFourGameEvent;
import game.gameclient.IClientSidePlayer;

/**
 * An interface describing a Player in the connect four game.
 * 
 * @author benobiwan
 * 
 */
public interface IClientSideConnectFourPlayer
		extends
		IClientSidePlayer<IConnectFourConfiguration, AbstractConnectFourGameEvent, ConnectFourClientSideGame, IConnectFourPlayerConfiguration>,
		IConnectFourPlayer
{
	// TODO IClientSideConnectFourPlayer
}
