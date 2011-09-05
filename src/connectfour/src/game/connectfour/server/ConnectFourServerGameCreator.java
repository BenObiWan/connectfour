package game.connectfour.server;

import game.common.IGameDescription;
import game.communication.IGameClient;
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
		AbstractServerGameCreator<IConnectFourPlayerConfiguration, AbstractConnectFourGameAction, IConnectFourConfiguration, IConnectFourServerSidePlayer, ConnectFourServerSideGame>
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
	public IConnectFourServerSidePlayer createPlayer(
			final IGameClient hostingClient, final int iPlayerId)
	{
		final IConnectFourPlayerConfiguration conf = createPlayerConfiguration();
		return new ConnectFourServerSidePlayerImpl(iPlayerId, hostingClient,
				hostingClient.getName(), false, this, conf);
	}

	@Override
	public IGameDescription createGameDescription()
	{
		return new ConnectFourGameDescription(getGameId(),
				_creatorPlayer.getName(), _playerList.size());
	}

	@Override
	public IConnectFourServerSidePlayer createAI(
			final IGameClient hostingClient, final int iPlayerId,
			final String strPlayerName)
	{
		final IConnectFourPlayerConfiguration conf = createPlayerConfiguration();
		return new ConnectFourServerSidePlayerImpl(iPlayerId, hostingClient,
				strPlayerName, true, this, conf);
	}

	@Override
	public IConnectFourPlayerConfiguration createPlayerConfiguration()
	{
		// TODO createPlayerConfiguration
		return null;
	}
}
