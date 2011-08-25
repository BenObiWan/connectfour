package game.connectfour.server;

import game.connectfour.IConnectFourConfiguration;
import game.connectfour.IConnectFourPlayerConfiguration;
import game.connectfour.action.AbstractConnectFourGameAction;
import game.connectfour.client.ConnectFourClientGameCreator;
import game.common.IGameDescription;
import game.communication.IGameClient;
import game.gameserver.AbstractServerGameCreator;

/**
 * Server side creator for Connect Four game.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourServerGameCreator
		extends
		AbstractServerGameCreator<IConnectFourPlayerConfiguration, AbstractConnectFourGameAction, IConnectFourConfiguration, IServerSideConnectFourPlayer, ConnectFourServerSideGame>
{
	@Override
	public ConnectFourServerSideGame createGame()
	{
		return new ConnectFourServerSideGame(_gameServer, _iGameId, _conf);
	}

	@Override
	public final ConnectFourClientGameCreator getClientGameCreator()
	{
		return new ConnectFourClientGameCreator();
	}

	@Override
	public IServerSideConnectFourPlayer createPlayer(
			final IGameClient hostingClient, final int iPlayerId)
	{
		return new ServerSideConnectFourPlayerImpl(iPlayerId, hostingClient,
				hostingClient.getName(), false, this, conf);
	}

	@Override
	public IGameDescription createGameDescription()
	{
		return new ConnectFourGameDescription(getGameId(),
				_creatorPlayer.getName(), _playerList.size());
	}

	@Override
	public IServerSideConnectFourPlayer createAI(
			final IGameClient hostingClient, final int iPlayerId,
			final String strPlayerName)
	{
		return new ServerSideConnectFourPlayerImpl(iPlayerId, hostingClient,
				strPlayerName, true, this, conf);
	}
}
