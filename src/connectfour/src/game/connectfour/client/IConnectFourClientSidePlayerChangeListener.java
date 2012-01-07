package game.connectfour.client;

import game.connectfour.event.ColumnPlayedConnectFourGameEvent;
import game.gameclient.IClientSidePlayerChangeListener;

import com.google.common.eventbus.Subscribe;

/**
 * Interface describing a change listener for connect four client side player.
 * 
 * @author benobiwan
 * 
 */
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
