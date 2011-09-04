package game.connectfour.client;

import game.communication.IGameServer;
import game.communication.event.game.CantActCmnEvent;
import game.communication.event.game.TurnTimeoutCmnEvent;
import game.communication.event.game.UnauthorizedActionCmnEvent;
import game.communication.event.game.UnsupportedActionCmnEvent;
import game.communication.event.game.YourTurnCmnEvent;
import game.connectfour.event.ColumnPlayedConnectFourGameEvent;
import game.gameclient.LocalGameClient;

public final class InteractivePlayerConnectFourClientSidePlayer extends
		AbstractConnectFourClientSidePlayer
{

	public InteractivePlayerConnectFourClientSidePlayer(final int iPlayerId,
			final String strName, final IGameServer server,
			final LocalGameClient localGameClient)
	{
		super(iPlayerId, strName, server, localGameClient);
	}

	@Override
	protected void handleYourTurnCmnEvent(final YourTurnCmnEvent evt)
	{
		for (final IConnectFourClientSidePlayerObserver observer : _observerList)
		{

		}
	}

	@Override
	protected void handleTurnTimeoutCmnEvent(final TurnTimeoutCmnEvent evt)
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void handleTurnTimeoutCmnEvent(
			final UnauthorizedActionCmnEvent evt)
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void handleCanActCmnEvent(final CantActCmnEvent evt)
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void handleUnsupportedActionCmnEvent(
			final UnsupportedActionCmnEvent evt)
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void handleColumnPlayedConnectFourGameEvent(
			final ColumnPlayedConnectFourGameEvent evt)
	{
		// TODO Auto-generated method stub

	}

}
