package game.connectfour.client;

import game.connectfour.IConnectFourConfiguration;
import game.connectfour.IConnectFourPlayerConfiguration;
import game.connectfour.event.AbstractConnectFourGameEvent;
import game.gameclient.AbstractClientGameCreator;

/**
 * Client side creator for Connect Four game.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourClientGameCreator
		extends
		AbstractClientGameCreator<IConnectFourConfiguration, AbstractConnectFourGameEvent, ConnectFourClientSideGame, IConnectFourPlayerConfiguration, IClientSideConnectFourPlayer>
{
	@Override
	public ConnectFourClientSideGame createGame()
	{
		return new ConnectFourClientSideGame(_gameClient, _gameServer,
				_iGameId, _conf);
	}

	@Override
	public IClientSideConnectFourPlayer createPlayer(final int iPlayerId)
	{
		return null;
	}

	@Override
	public void setConfiguration(
			final IConnectFourConfiguration gameConfiguration)
	{
		// TODO Auto-generated method stub

	}
}
