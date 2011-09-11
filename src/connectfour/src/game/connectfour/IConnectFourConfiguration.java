package game.connectfour;

import game.config.IGameConfiguration;

import common.config.IConfigurationBranch;

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
	 * Tag of this configuration node.
	 */
	String CONNECT_FOUR_CONFIGURATION_TAG = "ConnectFour";

	/**
	 * Tag for the period between KeepAlive requests.
	 */
	String NUMBER_OF_ROW_TAG = "NumberOfRows";

	/**
	 * Tag for the KeepAlive request timeout before closing the connection.
	 */
	String NUMBER_OF_COLUMN_TAG = "NumberOfColumns";

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
