package game.connectfour.gui;

import game.communication.IGameListDescription;
import game.communication.IGameSwingLauncher;
import game.connectfour.ConnectFourGameListDescription;
import game.connectfour.client.ConnectFourClientGameCreator;
import game.connectfour.server.ConnectFourServerGameCreator;
import game.gameclient.IClientGameCreator;
import game.gameserver.IServerGameCreator;

import javax.swing.JInternalFrame;

/**
 * Object used to create the graphical component of the connect four game.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourGameSwingLauncher implements IGameSwingLauncher
{
	/**
	 * Game description associated with this {@link IGameSwingLauncher}.
	 */
	private final ConnectFourGameListDescription _desc = new ConnectFourGameListDescription();

	@Override
	public IServerGameCreator<?, ?, ?, ?, ?> createServerGameCreator()
	{
		return new ConnectFourServerGameCreator();
	}

	@Override
	public JInternalFrame createGameUI(
			final IClientGameCreator<?, ?, ?, ?, ?> creator)
	{
		// TODO createGameUI
		return null;
	}

	@Override
	public IGameListDescription getGameListDescription()
	{
		return _desc;
	}

	@Override
	public Class<? extends IClientGameCreator<?, ?, ?, ?, ?>> getIClientGameCreatorClass()
	{
		return ConnectFourClientGameCreator.class;
	}

	@Override
	public String toString()
	{
		return _desc.getName();
	}

	@Override
	public int compareTo(final IGameSwingLauncher launcher)
	{
		return getGameListDescription().compareTo(
				launcher.getGameListDescription());
	}
}
