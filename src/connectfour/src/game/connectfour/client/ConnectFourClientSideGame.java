package game.connectfour.client;

import game.common.IGameClient;
import game.common.IGameServer;
import game.communication.event.ICommonGameEvent;
import game.communication.event.IGameEvent;
import game.communication.event.InconsistentEventTypeException;
import game.communication.event.game.CantActCmnEvent;
import game.communication.event.game.TurnTimeoutCmnEvent;
import game.communication.event.game.UnauthorizedActionCmnEvent;
import game.communication.event.game.UnsupportedActionCmnEvent;
import game.communication.event.game.YourTurnCmnEvent;
import game.connectfour.IConnectFourConfiguration;
import game.connectfour.IConnectFourPlayerConfiguration;
import game.connectfour.event.AbstractConnectFourGameEvent;
import game.connectfour.event.ColumnPlayedConnectFourGameEvent;
import game.connectfour.event.ConnectFourGameEventType;
import game.gameclient.AbstractClientSideGame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client side of the Connect Four game.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourClientSideGame
		extends
		AbstractClientSideGame<AbstractConnectFourGameEvent, IConnectFourPlayerConfiguration, IConnectFourConfiguration>
{
	/**
	 * Logger object.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConnectFourClientSideGame.class);

	/**
	 * Configuration of this game.
	 */
	private final IConnectFourConfiguration _conf;

	/**
	 * Creates a new ConnectFourClientSideGame.
	 * 
	 * @param locGameClient
	 *            The local game client.
	 * @param distantGameServer
	 *            the game server hosting this game.
	 * @param iGameId
	 *            id of the game.
	 * @param conf
	 *            the configuration to use on this game.
	 */
	protected ConnectFourClientSideGame(final IGameClient locGameClient,
			final IGameServer distantGameServer, final int iGameId,
			final IConnectFourConfiguration conf)
	{
		super(locGameClient, distantGameServer, iGameId);
		_conf = conf;
	}

	@Override
	public IConnectFourConfiguration getGameConfiguration()
	{
		return _conf;
	}

	@Override
	public void handleEvent(final IGameEvent evt)
			throws InconsistentEventTypeException
	{
		if (evt instanceof AbstractConnectFourGameEvent)
		{
			handleEvent((AbstractConnectFourGameEvent) evt);
		}
		else if (evt instanceof ICommonGameEvent)
		{
			handleEvent((ICommonGameEvent) evt);
		}
		else
		{
			throw new InconsistentEventTypeException(
					AbstractConnectFourGameEvent.class, evt.getClass());
		}
	}

	/**
	 * Handle a {@link AbstractConnectFourGameEvent}.
	 * 
	 * @param evt
	 *            the event to handle.
	 * @throws InconsistentEventTypeException
	 *             the type field of the {@link AbstractConnectFourGameEvent}
	 *             and it's class are inconsistent.
	 */
	private void handleEvent(final AbstractConnectFourGameEvent evt)
			throws InconsistentEventTypeException
	{
		switch (evt.getType())
		{
		case COLUMN_PLAYED:
			if (evt instanceof ColumnPlayedConnectFourGameEvent)
			{
				handleEvent((ColumnPlayedConnectFourGameEvent) evt);
			}
			else
			{
				throw new InconsistentEventTypeException(
						ConnectFourGameEventType.COLUMN_PLAYED, evt.getClass());
			}
			break;
		}
	}

	/**
	 * Handle a {@link ColumnPlayedConnectFourGameEvent}.
	 * 
	 * @param evt
	 *            the event to handle.
	 */
	@SuppressWarnings("unused")
	private void handleEvent(final ColumnPlayedConnectFourGameEvent evt)
	{
		// TODO ConnectFourClientSideGame handleEvent
		// ColumnPlayedConnectFourGameEvent
	}

	@Override
	public void handleEvent(final YourTurnCmnEvent evt)
	{
		// TODO ConnectFourClientSideGame handleEvent YourTurnCommonGameEvent
	}

	@Override
	public void handleEvent(final TurnTimeoutCmnEvent evt)
	{
		// TODO ConnectFourClientSideGame handleEvent TurnTimeoutCommonGameEvent
	}

	@Override
	public void handleEvent(final UnauthorizedActionCmnEvent evt)
	{
		// TODO ConnectFourClientSideGame handleEvent
		// UnauthorizedActionCommonGameEvent
	}

	@Override
	public void handleEvent(final CantActCmnEvent evt)
	{
		// TODO ConnectFourClientSideGame handleEvent CantActCommonGameEvent
	}

	@Override
	public void handleEvent(final UnsupportedActionCmnEvent evt)
	{
		// TODO ConnectFourClientSideGame handleEvent
		// UnsupportedActionCommonGameEvent
	}

}
