package game.connectfour;

import game.connectfour.server.ConnectFourServerGameCreator;
import game.communication.IGameListDescription;
import game.gameserver.IServerGameCreator;

/**
 * Description of the connect four in the list of game available in the
 * application.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourGameListDescription implements
		IGameListDescription
{
	@Override
	public String toString()
	{
		return getName();
	}

	@Override
	public String getName()
	{
		return "Connect Four";
	}

	@Override
	public String getVersion()
	{
		return "0.1";
	}

	@Override
	public IServerGameCreator<?, ?, ?, ?, ?> createServerGameCreator()
	{
		return new ConnectFourServerGameCreator();
	}

}
