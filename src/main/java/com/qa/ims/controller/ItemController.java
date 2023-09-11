package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

    public static final Logger LOGGER = LogManager.getLogger();

    private ItemDAO itemDAO;
    private Utils utils;

    public ItemController(ItemDAO itemDAO, Utils utils) {
        super();
        this.itemDAO = itemDAO;
        this.utils = utils;
    }

    /**
     * Reads all items to the logger
     */
    @Override
    public List<Item> readAll() {
        List<Item> items = itemDAO.readAll();
        for (Item item : items) {
            LOGGER.info(item);
        }
        return items;
    }

    /**
     * Creates a item by taking in user input
     */
    @Override
    public Item create() {
        LOGGER.info("Please enter a variety");
        String variety = utils.getString();
        LOGGER.info("Please enter an origin");
        String origin = utils.getString();
        LOGGER.info("Please enter a price");
        float price = utils.getFloat();
        LOGGER.info("Please enter a value for calories per 100g");
        float caloriesPer100g = utils.getFloat();
        LOGGER.info("Please enter the vibe");
        String vibe = utils.getString();
        Item item = itemDAO.create(new Item(variety, origin, price, caloriesPer100g, vibe));
        LOGGER.info("Item created");
        return item;
    }

    /**
     * Updates an existing item by taking in user input
     */
    @Override
    public Item update() {
        LOGGER.info("Please enter the id of the item you would like to update");
        Long id = utils.getLong();
        LOGGER.info("Please enter a variety");
        String variety = utils.getString();
        LOGGER.info("Please enter an origin");
        String origin = utils.getString();
        LOGGER.info("Please enter a price");
        float price = utils.getFloat();
        LOGGER.info("Please enter a value for calories per 100g");
        float caloriesPer100g = utils.getFloat();
        LOGGER.info("Please enter the vibe");
        String vibe = utils.getString();
        Item item = itemDAO.update(new Item(id, variety, origin, price, caloriesPer100g, vibe));
        LOGGER.info("Item Updated");
        return item;
    }

    /**
     * Deletes an existing item by the id of the item
     * 
     * @return
     */
    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the item you would like to delete");
        Long id = utils.getLong();
        return itemDAO.delete(id);
    }

}
