package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.utils.DBUtils;

public class OrderlineDAO implements Dao<Orderline> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Orderline modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long item_id = resultSet.getLong("item_id");
		int amount = resultSet.getInt("amount");
		float line_total = resultSet.getFloat("line_total");
		Long order_id = resultSet.getLong("order_id");
		return new Orderline(id, item_id, amount, line_total, order_id);
	}

	/**
	 * Reads all orderlines from the database
	 * 
	 * @return A list of orderlines
	 */
	@Override
	public List<Orderline> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderlines");) {
			List<Orderline> orderlines = new ArrayList<>();
			while (resultSet.next()) {
				orderlines.add(modelFromResultSet(resultSet));
			}
			return orderlines;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orderline readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderlines ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a orderline in the database
	 * 
	 * @param orderline - takes in a orderline object. id will be ignored
	 */
	@Override
	public Orderline create(Orderline orderline) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orderlines(item_id, amount, line_total, order_id) VALUES (?, ?, ?, ?)");) {
			statement.setLong(1, orderline.getItemId());
			statement.setInt(2, orderline.getAmount());
			statement.setFloat(3, orderline.getLineTotal());
			statement.setLong(4, orderline.getOrderId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orderline read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderlines WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a orderline in the database
	 * 
	 * @param orderline - takes in a orderline object, the id field will be used to
	 *                 update that orderline in the database
	 * @return
	 */
	@Override
	public Orderline update(Orderline orderline) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orderlines SET amount = ?, line_total = ? WHERE id = ?");) {
			statement.setInt(1, orderline.getAmount());
			statement.setFloat(2, orderline.getLineTotal());
			statement.setLong(3, orderline.getId());
			statement.executeUpdate();
			return read(orderline.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a orderline in the database
	 * 
	 * @param id - id of the orderline
	 */
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orderlines WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
