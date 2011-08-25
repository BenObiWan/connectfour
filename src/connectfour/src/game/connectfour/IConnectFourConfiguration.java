package game.connectfour;

import common.config.IConfigurationBranch;
import game.config.IGameConfiguration;

/**
 * Configuration for the connect four game.
 * 
 * @author benobiwan
 * 
 */
public interface IConnectFourConfiguration extends
		IGameConfiguration<IConnectFourPlayerConfiguration>,
		IConfigurationBranch
{
	/**
	 * Number of rows of this connect four game.
	 * 
	 * @return the number of rows of this connect four game.
	 */
	int getNumberOfRows();

	/**
	 * Number of columns of this connect four game.
	 * 
	 * @return the number of columns of this connect four game.
	 */
	int getNumberOfColumns();
}
