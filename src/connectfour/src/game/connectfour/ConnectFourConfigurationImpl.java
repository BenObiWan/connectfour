package game.connectfour;

import game.config.AbstractGameConfiguration;

import javax.management.MBeanServer;

import common.config.IConfiguration;
import common.config.InvalidConfigurationException;
import common.config.display.IntegerDisplayType;
import common.config.leaf.ConfigurationInteger;

/**
 * An implementation of the {@link IConnectFourConfiguration} interface.
 * 
 * @author benobiwan
 * 
 */
public final class ConnectFourConfigurationImpl extends
		AbstractGameConfiguration<IConnectFourPlayerConfiguration> implements
		IConnectFourConfiguration
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 3043668041114951242L;

	/**
	 * Leaf configuring the number of rows.
	 */
	private final ConfigurationInteger _leafNumberOfRows;

	/**
	 * Leaf configuring the number of columns.
	 */
	private final ConfigurationInteger _leafNumberOfColumns;

	/**
	 * Creates a new {@link ConnectFourConfigurationImpl} using default values
	 * for every elements.
	 * 
	 * @param parent
	 *            the parent of this AbstractConfigurationNode.
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 */
	public ConnectFourConfigurationImpl(final IConfiguration parent,
			final MBeanServer mBeanServer)
	{
		super(parent, CONNECT_FOUR_CONFIGURATION_TAG, mBeanServer);
		_leafNumberOfRows = new ConfigurationInteger(this, NUMBER_OF_ROW_TAG,
				"Number of rows", "Number of rows.", "Invalid Number of rows",
				true, IntegerDisplayType.SPINNER, Integer.valueOf(1),
				Integer.valueOf(10), Integer.valueOf(6));
		_leafNumberOfColumns = new ConfigurationInteger(this,
				NUMBER_OF_COLUMN_TAG, "Number of columns",
				"Number of columns.", "Invalid Number of columns", true,
				IntegerDisplayType.SPINNER, Integer.valueOf(1),
				Integer.valueOf(10), Integer.valueOf(7));
		addLeaf(_leafNumberOfRows);
		addLeaf(_leafNumberOfColumns);
	}

	/**
	 * Creates a new {@link ConnectFourConfigurationImpl} and sets the command
	 * line values.
	 * 
	 * @param parent
	 *            the parent of this AbstractConfigurationNode.
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 * @param iCommandLineNumberOfRows
	 *            the value specified on the command line for the number of
	 *            rows.
	 * @param iCommandLineNumberOfColumns
	 *            the value specified on the command line for the number of
	 *            columns.
	 * @throws InvalidConfigurationException
	 *             one of the given value is invalid.
	 */
	public ConnectFourConfigurationImpl(final IConfiguration parent,
			final MBeanServer mBeanServer,
			final Integer iCommandLineNumberOfRows,
			final Integer iCommandLineNumberOfColumns)
			throws InvalidConfigurationException
	{
		super(parent, CONNECT_FOUR_CONFIGURATION_TAG, mBeanServer);
		_leafNumberOfRows = new ConfigurationInteger(this, NUMBER_OF_ROW_TAG,
				"Number of rows", "Number of rows.", "Invalid Number of rows",
				true, IntegerDisplayType.SPINNER, Integer.valueOf(1),
				Integer.valueOf(10), Integer.valueOf(6),
				iCommandLineNumberOfRows);
		_leafNumberOfColumns = new ConfigurationInteger(this,
				NUMBER_OF_COLUMN_TAG, "Number of columns",
				"Number of columns.", "Invalid Number of columns", true,
				IntegerDisplayType.SPINNER, Integer.valueOf(1),
				Integer.valueOf(10), Integer.valueOf(7),
				iCommandLineNumberOfColumns);
		addLeaf(_leafNumberOfRows);
		addLeaf(_leafNumberOfColumns);
	}

	/**
	 * Creates a new {@link ConnectFourConfigurationImpl} and sets the command
	 * line and configuration values.
	 * 
	 * @param parent
	 *            the parent of this AbstractConfigurationNode.
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 * @param iCommandLineNumberOfRows
	 *            the value specified on the command line for the number of
	 *            rows.
	 * @param iCommandLineNumberOfColumns
	 *            the value specified on the command line for the number of
	 *            columns.
	 * @param iConfigurationNumberOfRows
	 *            the value specified in the configuration for the number of
	 *            rows.
	 * @param iConfigurationNumberOfColumns
	 *            the value specified in the configuration for the number of
	 *            columns.
	 * @throws InvalidConfigurationException
	 *             one of the given value is invalid.
	 */
	public ConnectFourConfigurationImpl(final IConfiguration parent,
			final MBeanServer mBeanServer,
			final Integer iCommandLineNumberOfRows,
			final Integer iCommandLineNumberOfColumns,
			final Integer iConfigurationNumberOfRows,
			final Integer iConfigurationNumberOfColumns)
			throws InvalidConfigurationException
	{
		this(parent, mBeanServer, iCommandLineNumberOfRows,
				iCommandLineNumberOfColumns);
		_leafNumberOfRows.setConfigurationValue(iConfigurationNumberOfRows);
		_leafNumberOfColumns
				.setConfigurationValue(iConfigurationNumberOfColumns);
	}

	@Override
	public int getMaxNumberOfPlayers()
	{
		return 2;
	}

	@Override
	public int getMinNumberOfPlayers()
	{
		return 2;
	}

	@Override
	public String getDescription()
	{
		return "Connect Four Configuration";
	}

	@Override
	public int getNumberOfRows()
	{
		return _leafNumberOfRows.getCurrentValue().intValue();
	}

	@Override
	public int getNumberOfColumns()
	{
		return _leafNumberOfColumns.getCurrentValue().intValue();
	}

}
