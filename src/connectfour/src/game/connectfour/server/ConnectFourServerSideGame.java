package game.connectfour.server;

import game.common.IGameInstanceDescription;
import game.common.IGameServer;
import game.communication.action.ICommonGameAction;
import game.communication.action.IGameAction;
import game.communication.action.IGameCtrlAction;
import game.communication.action.InconsistentActionTypeException;
import game.communication.action.game.EndTurnCmnAction;
import game.connectfour.IConnectFourConfiguration;
import game.connectfour.IConnectFourPlayerConfiguration;
import game.connectfour.action.AbstractConnectFourGameAction;
import game.connectfour.action.ConnectFourGameActionType;
import game.connectfour.action.PlayColumnConnectFourGameAction;
import game.gameserver.AbstractServerSideGame;
import game.gameserver.IServerSidePlayer;

import org.apache.log4j.Logger;

/**
 * Server side ConnectFour game.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourServerSideGame
		extends
		AbstractServerSideGame<AbstractConnectFourGameAction, IConnectFourConfiguration, IConnectFourPlayerConfiguration, IConnectFourServerSidePlayer>
{
	/**
	 * Logger object.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(ConnectFourServerSideGame.class);

	/**
	 * Configuration of this game.
	 */
	private final IConnectFourConfiguration _conf;

	/**
	 * Create a new ConnectFourServerSideGame.
	 * 
	 * @param locGameServer
	 *            the localGameServer.
	 * @param iGameId
	 *            the id of the game.
	 * @param conf
	 *            the configuration to use on this game.
	 */
	protected ConnectFourServerSideGame(final IGameServer locGameServer,
			final int iGameId, final IConnectFourConfiguration conf)
	{
		super(locGameServer, iGameId);
		_conf = conf;
	}

	@Override
	public IConnectFourConfiguration getGameConfiguration()
	{
		return _conf;
	}

	@Override
	public void handleGameAction(final IServerSidePlayer<?> player,
			final IGameAction act) throws InconsistentActionTypeException
	{
		if (player instanceof IConnectFourServerSidePlayer)
		{
			final IConnectFourServerSidePlayer connectFourPlayer = (IConnectFourServerSidePlayer) player;
			if (act instanceof AbstractConnectFourGameAction)
			{
				handleAction(connectFourPlayer,
						(AbstractConnectFourGameAction) act);
			}

			else if (act instanceof ICommonGameAction)
			{
				handleCommonGameAction(connectFourPlayer,
						(ICommonGameAction) act);
			}
			else
			{
				throw new InconsistentActionTypeException(
						AbstractConnectFourGameAction.class, act.getClass());
			}
		}
		else
		{
			// TODO
		}
	}

	@Override
	public IGameInstanceDescription getDescription()
	{
		// TODO ConnectFourServerSideGame getDescription
		return null;
	}

	@Override
	public boolean isJoinable()
	{
		// TODO ConnectFourServerSideGame isJoinable
		return false;
	}

	/**
	 * Handle a {@link AbstractConnectFourGameAction}.
	 * 
	 * @param player
	 *            the client from which the game action is coming.
	 * @param act
	 *            the event to handle.
	 * @throws InconsistentActionTypeException
	 *             if the action type field and the class of the action object
	 *             are inconsistent.
	 */
	private void handleAction(final IConnectFourServerSidePlayer player,
			final AbstractConnectFourGameAction act)
			throws InconsistentActionTypeException
	{
		switch (act.getType())
		{
		case PLAY_COLUMN:
			if (act instanceof PlayColumnConnectFourGameAction)
			{
				handleAction(player, (PlayColumnConnectFourGameAction) act);
			}
			else
			{
				throw new InconsistentActionTypeException(
						ConnectFourGameActionType.PLAY_COLUMN, act.getClass());
			}
			break;
		}
	}

	/**
	 * Handle a {@link PlayColumnConnectFourGameAction}.
	 * 
	 * @param player
	 *            the client from which the game action is coming.
	 * @param act
	 *            the event to handle.
	 */
	@SuppressWarnings("unused")
	private void handleAction(final IConnectFourServerSidePlayer player,
			final PlayColumnConnectFourGameAction act)
	{
		synchronized (_lockAction)
		{
			// TODO ConnectFourServerSideGame handleAction
			// PlayColumnConnectFourGameAction
		}
	}

	@Override
	public void handleAction(final IServerSidePlayer<?> player,
			final EndTurnCmnAction act)
	{
		// TODO ConnectFourServerSideGame handleAction
	}

	@Override
	public void timeoutReached()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void handleGameCtrlAction(final IServerSidePlayer<?> player,
			final IGameCtrlAction act) throws InconsistentActionTypeException
	{
		// TODO Auto-generated method stub

	}
}
