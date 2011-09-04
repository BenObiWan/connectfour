package game.connectfour.client;

import game.communication.event.game.CantActCmnEvent;
import game.communication.event.game.TurnTimeoutCmnEvent;
import game.communication.event.game.UnauthorizedActionCmnEvent;
import game.communication.event.game.UnsupportedActionCmnEvent;
import game.communication.event.game.YourTurnCmnEvent;
import game.connectfour.event.ColumnPlayedConnectFourGameEvent;
import game.gameclient.IClientSidePlayerObserver;

public interface IConnectFourClientSidePlayerObserver extends
		IClientSidePlayerObserver
{
	/**
	 * Handle a {@link YourTurnCmnEvent}.
	 * 
	 * @param evt
	 *            the {@link YourTurnCmnEvent} to handle.
	 */
	void handleYourTurnCmnEvent(final YourTurnCmnEvent evt);

	/**
	 * Handle a {@link TurnTimeoutCmnEvent}.
	 * 
	 * @param evt
	 *            the {@link TurnTimeoutCmnEvent} to handle.
	 */
	void handleTurnTimeoutCmnEvent(TurnTimeoutCmnEvent evt);

	/**
	 * Handle a {@link UnauthorizedActionCmnEvent}.
	 * 
	 * @param evt
	 *            the {@link UnauthorizedActionCmnEvent} to handle.
	 */
	void handleTurnTimeoutCmnEvent(UnauthorizedActionCmnEvent evt);

	/**
	 * Handle a {@link CantActCmnEvent}.
	 * 
	 * @param evt
	 *            the {@link CantActCmnEvent} to handle.
	 */
	void handleCanActCmnEvent(CantActCmnEvent evt);

	/**
	 * Handle a {@link UnsupportedActionCmnEvent}.
	 * 
	 * @param evt
	 *            the {@link UnsupportedActionCmnEvent} to handle.
	 */
	void handleUnsupportedActionCmnEvent(UnsupportedActionCmnEvent evt);

	/**
	 * Handle a {@link ColumnPlayedConnectFourGameEvent}.
	 * 
	 * @param evt
	 *            the {@link ColumnPlayedConnectFourGameEvent} to handle.
	 */
	void handleColumnPlayedConnectFourGameEvent(
			ColumnPlayedConnectFourGameEvent evt);
}
