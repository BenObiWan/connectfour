package game.connectfour.client;

import game.common.IGameServer;
import game.communication.event.CommonGameEventType;
import game.communication.event.ICommonGameEvent;
import game.communication.event.IGameEvent;
import game.communication.event.InconsistentEventTypeException;
import game.communication.event.game.CantActCmnEvent;
import game.communication.event.game.TurnTimeoutCmnEvent;
import game.communication.event.game.UnauthorizedActionCmnEvent;
import game.communication.event.game.UnsupportedActionCmnEvent;
import game.communication.event.game.YourTurnCmnEvent;
import game.connectfour.ConnectFourBox;
import game.connectfour.IConnectFourConfiguration;
import game.connectfour.IConnectFourPlayer;
import game.connectfour.IConnectFourPlayerConfiguration;
import game.connectfour.event.AbstractConnectFourGameEvent;
import game.connectfour.event.ColumnPlayedConnectFourGameEvent;
import game.connectfour.event.ConnectFourGameEventType;
import game.gameclient.AbstractClientSidePlayer;
import game.gameclient.LocalGameClient;

/**
 * An interface describing a Player in the connect four game.
 * 
 * @author benobiwan
 * 
 */
public class ConnectFourClientSidePlayer
		extends
		AbstractClientSidePlayer<IConnectFourConfiguration, AbstractConnectFourGameEvent, ConnectFourClientSideGame, ConnectFourClientSidePlayer, IConnectFourPlayerConfiguration, IConnectFourClientSidePlayerChangeListener>
		implements IConnectFourPlayer
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
	 * @param gameCreator
	 *            the {@link ConnectFourClientGameCreator} which created this
	 *            player.
	 */
	public ConnectFourClientSidePlayer(final int iPlayerId,
			final String strName, final IGameServer server,
			final LocalGameClient localGameClient,
			final ConnectFourClientGameCreator gameCreator)
	{
		super(iPlayerId, strName, server, localGameClient, gameCreator);
	}

	@Override
	public void handleGameEvent(final IGameEvent evt)
			throws InconsistentEventTypeException
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
			// _gameServer.handleAction(this, act)
		}
	}

	/**
	 * Handle a {@link ICommonGameEvent}.
	 * 
	 * @param evt
	 *            the {@link ICommonGameEvent} to handle.
	 * @throws InconsistentEventTypeException
	 *             the type field of the {@link AbstractConnectFourGameEvent}
	 *             and it's class are inconsistent.
	 */
	private void handleCommonGameEvent(final ICommonGameEvent evt)
			throws InconsistentEventTypeException
	{
		switch (evt.getType())
		{
		case YOUR_TURN:
			if (evt instanceof YourTurnCmnEvent)
			{
				handleYourTurnCmnEvent((YourTurnCmnEvent) evt);
			}
			else
			{
				throw new InconsistentEventTypeException(
						CommonGameEventType.YOUR_TURN, evt.getClass());
			}
			break;
		case TURN_TIMEOUT:
			if (evt instanceof TurnTimeoutCmnEvent)
			{
				handleTurnTimeoutCmnEvent((TurnTimeoutCmnEvent) evt);
			}
			else
			{
				throw new InconsistentEventTypeException(
						CommonGameEventType.TURN_TIMEOUT, evt.getClass());
			}
			break;
		case UNAUTHORIZED_ACTION:
			if (evt instanceof UnauthorizedActionCmnEvent)
			{
				handleUnauthorizedActionCmnEvent((UnauthorizedActionCmnEvent) evt);
			}
			else
			{
				throw new InconsistentEventTypeException(
						CommonGameEventType.UNAUTHORIZED_ACTION, evt.getClass());
			}
			break;
		case CANT_ACT:
			if (evt instanceof CantActCmnEvent)
			{
				handleCanActCmnEvent((CantActCmnEvent) evt);
			}
			else
			{
				throw new InconsistentEventTypeException(
						CommonGameEventType.CANT_ACT, evt.getClass());
			}
			break;
		case UNSUPPORTED_ACTION:
			if (evt instanceof UnsupportedActionCmnEvent)
			{
				handleUnsupportedActionCmnEvent((UnsupportedActionCmnEvent) evt);
			}
			else
			{
				throw new InconsistentEventTypeException(
						CommonGameEventType.UNSUPPORTED_ACTION, evt.getClass());
			}
			break;
		}
	}

	/**
	 * Handle a {@link AbstractConnectFourGameEvent}.
	 * 
	 * @param evt
	 *            the {@link AbstractConnectFourGameEvent} to handle.
	 * @throws InconsistentEventTypeException
	 *             the type field of the {@link AbstractConnectFourGameEvent}
	 *             and it's class are inconsistent.
	 */
	private void handleConnectFourGameEvent(
			final AbstractConnectFourGameEvent evt)
			throws InconsistentEventTypeException
	{
		switch (evt.getType())
		{
		case COLUMN_PLAYED:
			if (evt instanceof ColumnPlayedConnectFourGameEvent)
			{
				handleColumnPlayedConnectFourGameEvent((ColumnPlayedConnectFourGameEvent) evt);
			}
			else
			{
				throw new InconsistentEventTypeException(
						ConnectFourGameEventType.COLUMN_PLAYED, evt.getClass());
			}
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

	@Override
	public void handleYourTurnCmnEvent(final YourTurnCmnEvent evt)
	{
		_eventBus.post(evt);
	}

	@Override
	public void handleTurnTimeoutCmnEvent(final TurnTimeoutCmnEvent evt)
	{
		_eventBus.post(evt);

	}

	@Override
	public void handleUnauthorizedActionCmnEvent(
			final UnauthorizedActionCmnEvent evt)
	{
		_eventBus.post(evt);

	}

	@Override
	public void handleCanActCmnEvent(final CantActCmnEvent evt)
	{
		_eventBus.post(evt);
	}

	@Override
	public void handleUnsupportedActionCmnEvent(
			final UnsupportedActionCmnEvent evt)
	{
		_eventBus.post(evt);
	}

	/**
	 * Handle a {@link ColumnPlayedConnectFourGameEvent}.
	 * 
	 * @param evt
	 *            the {@link ColumnPlayedConnectFourGameEvent} to handle.
	 */
	private void handleColumnPlayedConnectFourGameEvent(
			final ColumnPlayedConnectFourGameEvent evt)
	{
		_eventBus.post(evt);

	}
}
