package game.connectfour;

import game.communication.IGameListDescription;

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
	public int compareTo(final IGameListDescription description)
	{
		int iRes = getName().compareTo(description.getName());
		if (iRes == 0)
		{
			iRes = getVersion().compareTo(description.getVersion());
		}
		return iRes;
	}
}
