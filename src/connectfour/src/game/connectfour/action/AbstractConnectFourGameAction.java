package game.connectfour.action;

import game.communication.action.AbstractGameAction;
import game.communication.action.IGameAction;

/**
 * Abstract {@link IGameAction} for the Connect Four game.
 * 
 * @author benobiwan
 * 
 */
public abstract class AbstractConnectFourGameAction extends AbstractGameAction
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 292687860829261252L;

	/**
	 * Type of the {@link IGameAction}.
	 */
	private final ConnectFourGameActionType _actionType;

	/**
	 * Creates a new AbstractConnectFourGameAction.
	 * 
	 * @param type
	 *            the type of {@link IGameAction}.
	 * @param iGameId
	 *            the id of the game concerned by the {@link IGameAction}.
	 * @param iPlayerId
	 *            id of the player doing the action.
	 */
	public AbstractConnectFourGameAction(final ConnectFourGameActionType type,
			final int iGameId, final int iPlayerId)
	{
		super(iGameId, iPlayerId);
		_actionType = type;
	}

	/**
	 * Get the type of the {@link IGameAction}.
	 * 
	 * @return the type of the {@link IGameAction}.
	 */
	public ConnectFourGameActionType getType()
	{
		return _actionType;
	}

}
