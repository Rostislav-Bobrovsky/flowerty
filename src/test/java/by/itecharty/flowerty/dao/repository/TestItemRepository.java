package by.itecharty.flowerty.dao.repository;

import by.itechart.flowerty.dao.repository.ItemRepository;
import by.itechart.flowerty.model.Goods;
import by.itechart.flowerty.model.Item;
import by.itechart.flowerty.model.Order;
import by.itecharty.flowerty.config.JpaConfigurationAware;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Мария
 * Date: 30.03.15
 * Time: 7:00
 * To change this template use File | Settings | File Templates.
 */
@Ignore
public class TestItemRepository extends JpaConfigurationAware {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void findItem_ValidId_ReturnsItem() {
        Item item = itemRepository.findOne(1l);
        Assert.assertEquals(item.getQuantity(), 10);
        Assert.assertEquals(item.getFlower().getFlower().getName(), "Yellow Tulip");
    }

    @Test
    public void findItem_InValidId_ReturnsNull() {
        Item item = itemRepository.findOne(1000l);
        Assert.assertNull(item);
    }
    @Test
    public void saveItem_ValidItem_ReturnsSameItem() {
        Goods goods = new Goods();
        goods.setId(1l);
        Item item = new Item();
        item.setFlower(goods);
        item.setQuantity(10);
        Order order = new Order();
        order.setId(1l);
        item.setOrder(order);
        item = itemRepository.save(item);
        Assert.assertEquals(10, item.getQuantity());
        Assert.assertEquals(goods, item.getFlower());
    }
    @Test
    public void findItemsByOrder_ValidOrder_ReturnsPageOfItems() {
        Order order = new Order();
        order.setId(1l);
        Page page = itemRepository.findByOrder(order, new PageRequest(0, 10));
        Assert.assertNotEquals(page.getContent().size(), 0);
        Assert.assertEquals(((Item)(page.getContent().get(0))).getQuantity() , 10);
    }

    @Test
    public void findItemsByOrder_NullOrder_ReturnsEmptyPage() {
        Order order = null;
        Page page = itemRepository.findByOrder(order, new PageRequest(1, 10));
        Assert.assertEquals(page.getContent().size(), 0);
    }
@Test
public void findItemsByOrder_InvalidOrder_ReturnsEmptyPage() {
     Order order = new Order();
     order.setId(1000l);
     Page page = itemRepository.findByOrder(order, new PageRequest(1, 10));
     Assert.assertEquals(page.getContent().size(), 0);
}
}
