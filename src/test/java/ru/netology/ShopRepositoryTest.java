package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {

    private ShopRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new ShopRepository();
        repository.add(new Product(1, "Product 1", 100));
        repository.add(new Product(2, "Product 2", 200));
        repository.add(new Product(3, "Product 3", 300));
    }

    @Test
    public void removeById_ShouldRemoveExistingProduct() {
        repository.removeById(2);
        Product[] products = repository.findAll();
        assertEquals(2, products.length);
        assertNull(repository.findById(2));
    }

    @Test
    public void removeById_ShouldThrowNotFoundException_WhenIdNotExists() {
        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            repository.removeById(999);
        });
        assertEquals("Element with id: 999 not found", thrown.getMessage());
    }
}

