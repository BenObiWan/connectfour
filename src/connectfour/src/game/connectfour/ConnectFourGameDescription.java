package game.connectfour;

import game.common.IGameDescription;

/**
 * Description of the connect four in the list of game available in the
 * application.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourGameDescription implements IGameDescription
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
	public int compareTo(final IGameDescription description)
	{
		int iRes = getName().compareTo(description.getName());
		if (iRes == 0)
		{
			iRes = getVersion().compareTo(description.getVersion());
		}
		return iRes;
	}
}
