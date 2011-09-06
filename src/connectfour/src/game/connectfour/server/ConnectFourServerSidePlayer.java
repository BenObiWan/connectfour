package game.connectfour.server;

import game.common.IGameClient;
import game.connectfour.ConnectFourBox;
import game.connectfour.IConnectFourPlayer;
import game.connectfour.IConnectFourPlayerConfiguration;
import game.gameserver.AbstractServerSidePlayer;
import game.gameserver.IServerGameCreator;

/**
 * An interface describing a Player in the connect four game.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourServerSidePlayer extends
		AbstractServerSidePlayer<IConnectFourPlayerConfiguration> implements
		IConnectFourPlayer
{
	/**
	 * Creates a new ConnectFourServerSidePlayer.
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
	public ConnectFourServerSidePlayer(final int iPlayerId,
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
