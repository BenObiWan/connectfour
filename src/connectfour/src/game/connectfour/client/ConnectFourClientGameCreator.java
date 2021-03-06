package game.connectfour.client;

import game.connectfour.ConnectFourConfigurationImpl;
import game.connectfour.IConnectFourConfiguration;
import game.connectfour.IConnectFourPlayerConfiguration;
import game.connectfour.event.AbstractConnectFourGameEvent;
import game.gameclient.AbstractClientGameCreator;
import game.gameclient.LocalGameClient;

/**
 * Client side creator for Connect Four game.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourClientGameCreator
		extends
		AbstractClientGameCreator<IConnectFourConfiguration, AbstractConnectFourGameEvent, ConnectFourClientSideGame, IConnectFourPlayerConfiguration, ConnectFourClientSidePlayer, IConnectFourClientSidePlayerChangeListener>
{
	@Override
	public ConnectFourClientSideGame createGame()
	{
		return new ConnectFourClientSideGame(_gameClient, _gameServer,
				_iGameId, _conf);
	}

	@Override
	public ConnectFourClientSidePlayer createPlayer(
			final LocalGameClient _locGameClient, final int iPlayerId)
	{
		String strPlayerName;
		final String strAIName = _locGameClient.getAIName(iPlayerId);
		if (strAIName == null)
		{
			strPlayerName = _gameClient.getName();
		}
		else
		{
			strPlayerName = strAIName + "@" + _gameClient.getName();
		}
		return new ConnectFourClientSidePlayer(iPlayerId, strPlayerName,
				_gameServer, _locGameClient, this);
	}

	@Override
	public IConnectFourPlayerConfiguration createPlayerConfiguration()
	{
		// TODO createPlayerConfiguration
		return null;
	}

	@Override
	public IConnectFourConfiguration createGameConfiguration()
	{
		return new ConnectFourConfigurationImpl(null, null);
	}
}
