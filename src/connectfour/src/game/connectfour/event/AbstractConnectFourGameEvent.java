package game.connectfour.event;

import game.communication.event.AbstractGameEvent;
import game.communication.event.IUniCastGameEvent;

/**
 * Abstract {@link IUniCastGameEvent} for the Connect Four game.
 * 
 * @author benobiwan
 * 
 */
public abstract class AbstractConnectFourGameEvent extends AbstractGameEvent
{

	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 946503448041843767L;

	/**
	 * Type of the {@link IUniCastGameEvent}.
	 */
	private final ConnectFourGameEventType _eventType;

	/**
	 * Create a new AbstractConnectFourGameEvent.
	 * 
	 * @param type
	 *            the type of {@link IUniCastGameEvent}.
	 * @param iGameId
	 *            the id of the game concerned by the {@link IUniCastGameEvent}.
	 * @param iPlayerId
	 *            id of the player concerned by the event.
	 */
	public AbstractConnectFourGameEvent(final ConnectFourGameEventType type,
			final int iGameId, final int iPlayerId)
	{
		super(iGameId, iPlayerId);
		_eventType = type;
	}

	/**
	 * Get the type of the {@link IUniCastGameEvent}.
	 * 
	 * @return the type of the {@link IUniCastGameEvent}.
	 */
	public ConnectFourGameEventType getType()
	{
		return _eventType;
	}

}
