package ru.kuklin.partslist.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.kuklin.partslist.model.Item;

import java.util.List;

@Repository
public class ItemDAOImpl implements ItemDAO {
    private static final Logger logger = LoggerFactory.getLogger(ItemDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addItem(Item item) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(item);
        logger.info("Successfully writen, Item details = " + item);
    }

    @Override
    public void updateItem(Item item) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(item);
        logger.info("Successfully update, Item details = " + item);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Item> listItem() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Item> listItem = session.createQuery("from Item").list();
        for(Item item:listItem){
            logger.info("Items list:" + item);
        }
        return listItem;
    }

    @Override
    public Item getItemById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Item item = (Item) session.load(Item.class, new Integer(id));
        logger.info("Item loaded: " + item);
        return item;
    }

    @Override
    public void removeItem(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Item item = (Item) session.load(Item.class, new Integer(id));
        if(item != null){
            session.delete(item);
            logger.info("Removing items: " + item);
        }else {
            logger.info("Removing items error, items not found");
        }
    }
}
