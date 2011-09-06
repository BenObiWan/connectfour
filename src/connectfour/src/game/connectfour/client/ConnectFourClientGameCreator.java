package game.connectfour.client;

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
		AbstractClientGameCreator<IConnectFourConfiguration, AbstractConnectFourGameEvent, ConnectFourClientSideGame, IConnectFourPlayerConfiguration, IConnectFourClientSidePlayer, IConnectFourClientSidePlayerObserver>
{
	@Override
	public ConnectFourClientSideGame createGame()
	{
		return new ConnectFourClientSideGame(_gameClient, _gameServer,
				_iGameId, _conf);
	}

	@Override
	public IConnectFourClientSidePlayer createPlayer(
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
		return new ConnectFourClientSidePlayerImpl(iPlayerId, strPlayerName,
				_gameServer, _locGameClient);
	}
}
