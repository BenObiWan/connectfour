package game.connectfour.client;

import game.communication.IGameServer;
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
import game.connectfour.IConnectFourPlayerConfiguration;
import game.connectfour.event.AbstractConnectFourGameEvent;
import game.connectfour.event.ColumnPlayedConnectFourGameEvent;
import game.connectfour.event.ConnectFourGameEventType;
import game.gameclient.AbstractClientSidePlayer;
import game.gameclient.LocalGameClient;

public final class ConnectFourClientSidePlayerImpl
		extends
		AbstractClientSidePlayer<IConnectFourConfiguration, AbstractConnectFourGameEvent, ConnectFourClientSideGame, IConnectFourClientSidePlayer, IConnectFourPlayerConfiguration, IConnectFourClientSidePlayerObserver>
		implements IConnectFourClientSidePlayer
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
	protected ConnectFourClientSidePlayerImpl(final int iPlayerId,
			final String strName, final IGameServer server,
			final LocalGameClient localGameClient)
	{
		super(iPlayerId, strName, server, localGameClient);
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
				handleTurnTimeoutCmnEvent((UnauthorizedActionCmnEvent) evt);
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

	/**
	 * Handle a {@link YourTurnCmnEvent}.
	 * 
	 * @param evt
	 *            the {@link YourTurnCmnEvent} to handle.
	 */
	private void handleYourTurnCmnEvent(final YourTurnCmnEvent evt)
	{
		for (final IConnectFourClientSidePlayerObserver observer : _observerList)
		{
			observer.handleYourTurnCmnEvent(evt);
		}
	}

	/**
	 * Handle a {@link TurnTimeoutCmnEvent}.
	 * 
	 * @param evt
	 *            the {@link TurnTimeoutCmnEvent} to handle.
	 */
	private void handleTurnTimeoutCmnEvent(final TurnTimeoutCmnEvent evt)
	{
		for (final IConnectFourClientSidePlayerObserver observer : _observerList)
		{
			observer.handleTurnTimeoutCmnEvent(evt);
		}
	}

	/**
	 * Handle a {@link UnauthorizedActionCmnEvent}.
	 * 
	 * @param evt
	 *            the {@link UnauthorizedActionCmnEvent} to handle.
	 */
	private void handleTurnTimeoutCmnEvent(final UnauthorizedActionCmnEvent evt)
	{
		for (final IConnectFourClientSidePlayerObserver observer : _observerList)
		{
			observer.handleUnauthorizedActionCmnEvent(evt);
		}
	}

	/**
	 * Handle a {@link CantActCmnEvent}.
	 * 
	 * @param evt
	 *            the {@link CantActCmnEvent} to handle.
	 */
	private void handleCanActCmnEvent(final CantActCmnEvent evt)
	{
		for (final IConnectFourClientSidePlayerObserver observer : _observerList)
		{
			observer.handleCanActCmnEvent(evt);
		}
	}

	/**
	 * Handle a {@link UnsupportedActionCmnEvent}.
	 * 
	 * @param evt
	 *            the {@link UnsupportedActionCmnEvent} to handle.
	 */
	private void handleUnsupportedActionCmnEvent(
			final UnsupportedActionCmnEvent evt)
	{
		for (final IConnectFourClientSidePlayerObserver observer : _observerList)
		{
			observer.handleUnsupportedActionCmnEvent(evt);
		}
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
		for (final IConnectFourClientSidePlayerObserver observer : _observerList)
		{
			observer.handleColumnPlayedConnectFourGameEvent(evt);
		}
	}
}
