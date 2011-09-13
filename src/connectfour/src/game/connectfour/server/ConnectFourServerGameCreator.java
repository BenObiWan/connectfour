package game.connectfour.server;

import game.common.IGameClient;
import game.common.IGameInstanceDescription;
import game.connectfour.IConnectFourConfiguration;
import game.connectfour.IConnectFourPlayerConfiguration;
import game.connectfour.action.AbstractConnectFourGameAction;
import game.connectfour.client.ConnectFourClientGameCreator;
import game.gameserver.AbstractServerGameCreator;

/**
 * Server side creator for Connect Four game.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourServerGameCreator
		extends
		AbstractServerGameCreator<IConnectFourPlayerConfiguration, AbstractConnectFourGameAction, IConnectFourConfiguration, ConnectFourServerSidePlayer, ConnectFourServerSideGame>
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
	public ConnectFourServerSidePlayer createPlayer(
			final IGameClient hostingClient, final int iPlayerId)
	{
		return new ConnectFourServerSidePlayer(iPlayerId, hostingClient,
				hostingClient.getName(), false, this);
	}

	@Override
	public IGameInstanceDescription createGameDescription()
	{
		return new ConnectFourGameInstanceDescription(getGameId(),
				_creatorPlayer.getName(), _playerList.size());
	}

	@Override
	public ConnectFourServerSidePlayer createAI(
			final IGameClient hostingClient, final int iPlayerId,
			final String strPlayerName)
	{
		return new ConnectFourServerSidePlayer(iPlayerId, hostingClient,
				strPlayerName, true, this);
	}
}
