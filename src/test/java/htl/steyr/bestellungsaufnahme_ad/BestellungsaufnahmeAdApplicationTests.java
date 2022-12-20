package htl.steyr.bestellungsaufnahme_ad;

import htl.steyr.bestellungsaufnahme_ad.application.model.*;
import htl.steyr.bestellungsaufnahme_ad.web.BestellungsaufnahmeRestController;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = BestellungsaufnahmeAdApplication.class)
class BestellungsaufnahmeAdApplicationTests {

    Category category = new Category();
    Ingredient ingredient = new Ingredient();
    Product product = new Product();
    Ordering ordering = new Ordering();


    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderingRepository orderingRepository;


    @Test
    @Order(1)
    void createCategory() {

        category.setName("Pizza");

        Assertions.assertDoesNotThrow(() -> {
            categoryRepository.save(category);
        });

    }

    @Test
    @Order(2)
    void updateCategory() {
        Assertions.assertDoesNotThrow(() -> {
            category.setName("Pizza");

            Assertions.assertDoesNotThrow(() -> {
                categoryRepository.save(category);
            });
        });
    }

    @Test
    @Order(3)
    void deleteCategory() {
        Assertions.assertDoesNotThrow(() -> {
            categoryRepository.delete(category);
        });
    }

    @Test
    @Order(4)
    void categoryList() {
        Assertions.assertDoesNotThrow(() -> {
            categoryRepository.findAll();
        });
    }

    @Test
    @Order(5)
    void createIngredient() {

        ingredient.setName("Salami");
        ingredient.setPrice(0.70f);

        Assertions.assertDoesNotThrow(() -> {
            ingredientRepository.save(ingredient);
        });

    }

    @Test
    @Order(6)
    void updateIngredient() {
        Assertions.assertDoesNotThrow(() -> {
            ingredient.setName("Mais");
            ingredient.setPrice(0.90f);

            Assertions.assertDoesNotThrow(() -> {
                ingredientRepository.save(ingredient);
            });
        });
    }

    @Test
    @Order(7)
    void deleteIngredient() {
        Assertions.assertDoesNotThrow(() -> {
            ingredientRepository.delete(ingredient);
        });
    }

    @Test
    @Order(8)
    void ingredientList() {
        Assertions.assertDoesNotThrow(() -> {
            ingredientRepository.findAll();
        });
    }

    @Test
    @Order(9)
    void createProduct() {


        product.setPrice(13.90f);
        product.setName("Schnitzel");

        Assertions.assertDoesNotThrow(() -> {
            productRepository.save(product);
        });

    }

    @Test
    @Order(10)
    void updateProduct() {
        Category c = new Category();
        c.setName("Dessert");
        categoryRepository.save(c);

        Assertions.assertDoesNotThrow(() -> {
            product.setPrice(14.90f);
            product.setName("Gyros");
            product.setCategory(c);

            Assertions.assertDoesNotThrow(() -> {
                productRepository.save(product);
            });
        });
    }

    @Test
    @Order(11)
    void deleteProduct() {
        Assertions.assertDoesNotThrow(() -> {
            productRepository.delete(product);
        });
    }

    @Test
    @Order(12)
    void productList() {
        Assertions.assertDoesNotThrow(() -> {
            productRepository.findAll();
        });
    }

    @Test
    @Order(13)
    void addToCategory() {
        Category c = new Category();
        c.setName("Dessert");
        categoryRepository.save(c);


        product.setCategory(c);
        product.setPrice(13.90f);
        product.setName("Schnitzel");

        Assertions.assertDoesNotThrow(() -> {
            productRepository.save(product);
        });
    }

    @Test
    @Order(14)
    void addToCategorybyId() {
        Category c = new Category();
        c.setName("Dessert");
        categoryRepository.save(c);

        product.setCategory(c);
        product.setPrice(13.90f);
        product.setName("Schnitzel");

        Assertions.assertDoesNotThrow(() -> {
            productRepository.save(product);
        });

    }

    @Test
    @Order(15)
    void createOrdering() {

        ordering.setConfirmed_time(LocalDateTime.of(2021, 12, 18, 12, 45));
        ordering.setTimestamp(LocalDateTime.now());
        ordering.setDelivery(false);
        ordering.setPrice(88.88f);


        Assertions.assertDoesNotThrow(() -> {
            orderingRepository.save(ordering);
        });


    }

    @Test
    @Order(16)
    void updateOrdering() {
        Assertions.assertDoesNotThrow(() -> {
            ordering.setConfirmed_time(LocalDateTime.of(2022, 12, 18, 12, 55));
            ordering.setTimestamp(LocalDateTime.of(2022, 12, 18, 11, 55));
            ordering.setDelivery(true);
            ordering.setPrice(44.44f);


            Assertions.assertDoesNotThrow(() -> {
                orderingRepository.save(ordering);
            });
        });
    }

    @Test
    @Order(17)
    void deleteOrdering() {
        Assertions.assertDoesNotThrow(() -> {
            orderingRepository.delete(ordering);
        });

    }

    @Test
    @Order(18)
    void orderingList() {
        Assertions.assertDoesNotThrow(() -> {
            orderingRepository.findAll();
        });

    }


    @Test
    void contextLoads() {
    }

}
