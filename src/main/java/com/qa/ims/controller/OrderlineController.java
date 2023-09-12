package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.dao.OrderlineDAO;
import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.utils.Utils;

public class OrderlineController implements CrudController<Orderline> {

    public static final Logger LOGGER = LogManager.getLogger();

    private OrderlineDAO orderlineDAO;
    private Utils utils;

    public OrderlineController(OrderlineDAO orderlineDAO, Utils utils) {
        super();
        this.orderlineDAO = orderlineDAO;
        this.utils = utils;
    }

    /**
     * Reads all orderlines to the logger
     */
    @Override
    public List<Orderline> readAll() {
        List<Orderline> orderlines = orderlineDAO.readAll();
        for (Orderline orderline : orderlines) {
            LOGGER.info(orderline);
        }
        return orderlines;
    }

    /**
     * Creates a orderline by taking in user input
     */
    @Override
    public Orderline create() {
        ItemDAO itemDAO = new ItemDAO();
        LOGGER.info("Please enter an item_id");
        Long item_id = utils.getLong();
        LOGGER.info("Please enter an amount");
        int amount = utils.getInt();
        Item item = itemDAO.read(item_id);
        float line_total = (item.getPrice()) * amount;
        LOGGER.info("Please enter an order_id");
        Long order_id = utils.getLong();
        Orderline orderline = orderlineDAO.create(new Orderline(item_id, amount, line_total, order_id));
        LOGGER.info("Orderline created");
        return orderline;
    }

    /**
     * Updates an existing orderline by taking in user input
     */
    @Override
    public Orderline update() {
        ItemDAO itemDAO = new ItemDAO();
        OrderlineDAO orderlineDAO = new OrderlineDAO();
        LOGGER.info("Please enter the id of the orderline you would like to update");
        Long id = utils.getLong();
        LOGGER.info("Please enter an amount");
        int amount = utils.getInt();
        Long item_id = orderlineDAO.read(id).getItemId();
        Item item = itemDAO.read(item_id);
        float line_total = (item.getPrice()) * amount;
        Long order_id = orderlineDAO.read(id).getOrderId();
        Orderline orderline = orderlineDAO.update(new Orderline(id, item_id, amount, line_total, order_id));
        LOGGER.info("Orderline Updated");
        return orderline;
    }

    /**
     * Deletes an existing orderline by the id of the orderline
     * 
     * @return
     */
    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the orderline you would like to delete");
        Long id = utils.getLong();
        return orderlineDAO.delete(id);
    }

}
