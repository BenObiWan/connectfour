package game.connectfour.client;

import game.connectfour.event.ColumnPlayedConnectFourGameEvent;
import game.gameclient.IClientSidePlayerChangeListener;

import com.google.common.eventbus.Subscribe;

public interface IConnectFourClientSidePlayerChangeListener extends
		IClientSidePlayerChangeListener
{
	/**
	 * Handle a {@link ColumnPlayedConnectFourGameEvent}.
	 * 
	 * @param evt
	 *            the {@link ColumnPlayedConnectFourGameEvent} to handle.
	 */
	@Subscribe
	void handleColumnPlayedConnectFourGameEvent(
			ColumnPlayedConnectFourGameEvent evt);
}
