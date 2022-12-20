package htl.steyr.bestellungsaufnahme_ad.web;


import htl.steyr.bestellungsaufnahme_ad.application.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BestellungsaufnahmeRestController {

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    Ordering_Product_IngredientsRepository orderingProduct_ingredientsRepository;
    @Autowired
    Ordering_ProdcutRepository ordering_prodcutRepository;
    @Autowired
    OrderingRepository orderingRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    //-------------------------Category------------------------------------------
    @GetMapping("/category/get")
    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }

    @PostMapping(value = "/category/create")
    public void createCategory(@RequestBody Category category) {

        //Category savedCategory = categoryRepository.save(category);
        categoryRepository.save(category);
    }

    @PostMapping("/category/delete/{categoryId}")
    public void deleteCategory(@PathVariable(name = "categoryId") int id) {

        categoryRepository.delete(categoryRepository.findById(id));
    }

    @PostMapping("/category/update/{categoryId}")
    public void updateCategory(@PathVariable(name = "categoryId") int id, @RequestBody Category category) {

        Category c = categoryRepository.findById(id);
        c.setName(category.getName());
        categoryRepository.save(c);
    }
//      Man könnte eine Liste von Products einfügen
//    @PostMapping("/category/addToProduct/{categoryId}/{productId}")
//    public void addProductToCatgeory(@PathVariable(name = "categoryId") int categoryId,@PathVariable(name = "productId") int productId) {
//        Product product = productRepository.findById(productId);
//        Category category = categoryRepository.findById(categoryId);
//        category.setProducts(productRepository.findAll(productId));
//        categoryRepository.save(category);
//
//    }

//-------------------------Ingredients------------------------------------------

    @GetMapping("/ingredient/get")
    public List<Ingredient> ingredientList() {
        return ingredientRepository.findAll();
    }

    @PostMapping("/ingredient/create")
    public void createIngredient(@RequestBody Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    @PostMapping("/ingredient/update/{ingredientId}")
    public void updateIngredient(@PathVariable(name = "ingredientId") int id, @RequestBody Ingredient ingredient) {
        //headers.toString();

        Ingredient i = ingredientRepository.findById(id);
        i.setName(ingredient.getName());
        i.setPrice(ingredient.getPrice());
        ingredientRepository.save(i);
    }

    @PostMapping("/ingredient/delete/{ingredientId}")
    public void deleteIngredient(@PathVariable(name = "ingredientId") int id) {

        ingredientRepository.delete(ingredientRepository.findById(id));
    }
    //-------------------------Product------------------------------------------

    @GetMapping("/product/get")
    public List<Product> productList() {
        return productRepository.findAll();
    }

    @PostMapping("/product/create")
    public void createProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @PostMapping("/product/createAndAddToCategory/{categoryId}")
    public void addToCategory(@PathVariable(name = "categoryId") int id, @RequestBody Product product) {
        if (categoryRepository.findById(id)!= null){
            product.setCategory(categoryRepository.findById(id));
        }
        productRepository.save(product);

    }

    @PostMapping("/product/addToCategorybyID/{categoryId}")
    public void addToCategorybyId(@PathVariable(name = "categoryId") int id, @RequestParam int product_Id) {
        Product product = productRepository.findById(product_Id);
        if (categoryRepository.findById(id)!= null){
            product.setCategory(categoryRepository.findById(id));
        }
        productRepository.save(product);

    }

    @PostMapping("/product/delete/{productId}")
    public void deleteProduct(@PathVariable(name = "productId") int id) {

        productRepository.delete(productRepository.findById(id));
    }

    @PostMapping("/product/update/{productId}")
    public void updateProduct(@PathVariable(name = "productId") int id, @RequestBody Product product) {

        Product p = productRepository.findById(id);
        p.setCategory(product.getCategory());
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        productRepository.save(p);

        //productRepository.update(p.getCategory(), p.getName(), p.getPrice(), p.getId());
    }

    //-------------------------Ordering------------------------------------------

    @GetMapping("/ordering/get")
    public List<Ordering> orderingList() {
        return orderingRepository.findAll();
    }

    @PostMapping("/ordering/create")
    public void createOrdering(@RequestParam Boolean delivery, @RequestParam LocalDate timestamp,
                               @RequestParam LocalDate confirmed_time, @RequestParam Float price,
                               @RequestBody Product[] productArrayList) {
        //vllt noch eine Arrayliste von ingredient, welche dann hinzugefügt werden
        LocalDateTime localDateTime = LocalDateTime.now();
        Ordering o = new Ordering();
        o.setTimestamp(localDateTime);
        o.setDelivery(delivery);
        o.setPrice(price);
        o.setConfirmed_time(localDateTime.plusHours(1));

        for (Product p : productArrayList) {
            Ordering_Product op = new Ordering_Product();
            op.setOrdering(o);
            op.setProduct(p);
            op.setQuantitiy(1);
            op.setProduct_price(13);
            ordering_prodcutRepository.save(op);
        }

        orderingRepository.save(o);
        //orderingRepository.save(ordering);
    }

    @PostMapping("/ordering/update/{orderingId}")
    public void updateOrdering(@PathVariable(name = "orderingId") int id, @RequestBody Ordering ordering) {

        Ordering o = orderingRepository.findById(id);
        o.setPrice(ordering.getPrice());

        o.setConfirmed_time(ordering.getConfirmed_time());
        o.setDelivery(ordering.getDelivery());
        orderingRepository.save(o);
    }


    @PostMapping("/ordering/delete/{orderingId}")
    public void deleteOrdering(@PathVariable(name = "orderingId") int id) {

        orderingRepository.delete(orderingRepository.findById(id));
    }


}
