package game.connectfour.client;

import game.connectfour.event.ColumnPlayedConnectFourGameEvent;
import game.gameclient.IClientSidePlayerObserver;

public interface IConnectFourClientSidePlayerObserver extends
		IClientSidePlayerObserver
{
	/**
	 * Handle a {@link ColumnPlayedConnectFourGameEvent}.
	 * 
	 * @param evt
	 *            the {@link ColumnPlayedConnectFourGameEvent} to handle.
	 */
	void handleColumnPlayedConnectFourGameEvent(
			ColumnPlayedConnectFourGameEvent evt);
}
