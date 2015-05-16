package test.by.itechart.flowerty.persistence.repository;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.by.itechart.flowerty.config.aware.JpaConfigurationAware;
import by.itechart.flowerty.persistence.model.Item;
import by.itechart.flowerty.persistence.repository.ItemRepository;

/**
 * Created by Rostislav on 13-May-15
 */

public class ItemRepositoryTest extends JpaConfigurationAware {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void findOne_ShouldReturnAItem() {

        Item actual = itemRepository.findOne(1L);

        Assert.assertNotNull(actual);
        assertThat(actual.getId(), equalTo(1L));
    }
}
