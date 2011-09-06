package game.connectfour.server;

import game.common.IGameClient;
import game.connectfour.ConnectFourBox;
import game.connectfour.IConnectFourPlayerConfiguration;
import game.gameserver.AbstractServerSidePlayer;
import game.gameserver.IServerGameCreator;

public final class ConnectFourServerSidePlayerImpl extends
		AbstractServerSidePlayer<IConnectFourPlayerConfiguration> implements
		IConnectFourServerSidePlayer
{
	/**
	 * Creates a new ServerSideConnectFourPlayerImpl.
	 * 
	 * @param iPlayerId
	 *            the id of the player.
	 * @param hostingClient
	 *            the hosting client.
	 * @param strName
	 *            the name of the player.
	 * @param bIsAI
	 *            whether this player is an AI or not.
	 * @param serverGameCreator
	 *            the {@link IServerGameCreator} which created this game.
	 * @param conf
	 *            the player configuration.
	 */
	public ConnectFourServerSidePlayerImpl(final int iPlayerId,
			final IGameClient hostingClient, final String strName,
			final boolean bIsAI,
			final IServerGameCreator<?, ?, ?, ?, ?> serverGameCreator,
			final IConnectFourPlayerConfiguration conf)
	{
		super(iPlayerId, hostingClient, strName, bIsAI, serverGameCreator, conf);
	}

	@Override
	public ConnectFourBox getBoxId()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
