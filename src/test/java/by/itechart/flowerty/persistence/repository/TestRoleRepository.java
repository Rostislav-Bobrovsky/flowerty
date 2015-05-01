package by.itechart.flowerty.persistence.repository;

import by.itechart.flowerty.config.aware.JpaConfigurationAware;
import by.itechart.flowerty.persistence.repository.model.Role;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author  Мария 02.04.15
 */
@Ignore
public class TestRoleRepository extends JpaConfigurationAware {
    @Autowired
    private RoleRepository roleRepository;
    @Ignore
    @Test
    public void findAll_ReturnsListOfAllRoles() {
        List<Role> list = roleRepository.findAll();
        Assert.assertEquals(list.size(), 5);
    }
}
