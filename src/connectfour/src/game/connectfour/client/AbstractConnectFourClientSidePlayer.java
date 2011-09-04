package game.connectfour.client;

import game.communication.IGameServer;
import game.communication.event.ICommonGameEvent;
import game.communication.event.IGameEvent;
import game.connectfour.ConnectFourBox;
import game.connectfour.IConnectFourConfiguration;
import game.connectfour.IConnectFourPlayerConfiguration;
import game.connectfour.event.AbstractConnectFourGameEvent;
import game.gameclient.AbstractClientSidePlayer;
import game.gameclient.LocalGameClient;

public abstract class AbstractConnectFourClientSidePlayer
		extends
		AbstractClientSidePlayer<IConnectFourConfiguration, AbstractConnectFourGameEvent, ConnectFourClientSideGame, IClientSideConnectFourPlayer, IConnectFourPlayerConfiguration>
		implements IClientSideConnectFourPlayer
{

	/**
	 * Creates a new ConnectFourClientSidePlayer.
	 * 
	 * @param iPlayerId
	 *            id of the player.
	 * @param strName
	 *            the name of the player.
	 * @param server
	 *            the {@link IGameServer} where this client is playing.
	 * @param localGameClient
	 *            the {@link LocalGameClient}.
	 */
	protected AbstractConnectFourClientSidePlayer(final int iPlayerId,
			final String strName, final IGameServer server,
			final LocalGameClient localGameClient)
	{
		super(iPlayerId, strName, server, localGameClient);
	}

	@Override
	public void handleGameEvent(final IGameEvent evt)
	{
		if (evt instanceof ICommonGameEvent)
		{
			final ICommonGameEvent event = (ICommonGameEvent) evt;
			handleCommonGameEvent(event);
		}
		else if (evt instanceof AbstractConnectFourGameEvent)
		{
			final AbstractConnectFourGameEvent event = (AbstractConnectFourGameEvent) evt;
			handleConnectFourGameEvent(event);
		}
		else
		{
			// TODO
		}
	}

	/**
	 * Handle a {@link ICommonGameEvent}.
	 * 
	 * @param evt
	 *            the {@link ICommonGameEvent} to handle.
	 */
	private void handleCommonGameEvent(final ICommonGameEvent evt)
	{
		switch (evt.getType())
		{
		case YOUR_TURN:
			break;
		case TURN_TIMEOUT:
			break;
		case UNAUTHORIZED_ACTION:
			break;
		case CANT_ACT:
			break;
		case UNSUPPORTED_ACTION:
			break;
		}
	}

	/**
	 * Handle a {@link AbstractConnectFourGameEvent}.
	 * 
	 * @param evt
	 *            the {@link AbstractConnectFourGameEvent} to handle.
	 */
	private void handleConnectFourGameEvent(
			final AbstractConnectFourGameEvent evt)
	{
		switch (evt.getType())
		{
		case COLUMN_PLAYED:
			break;
		}
	}

	@Override
	public ConnectFourBox getBoxId()
	{
		synchronized (_lock)
		{
			if (_playerConf == null)
			{
				return ConnectFourBox.EMPTY;
			}
			return _playerConf.getBoxId();
		}
	}
}
