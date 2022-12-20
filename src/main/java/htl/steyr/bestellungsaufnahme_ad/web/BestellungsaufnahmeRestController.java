package htl.steyr.bestellungsaufnahme_ad.web;


import htl.steyr.bestellungsaufnahme_ad.application.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class BestellungsaufnahmeRestController {

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    OrderingProductIngredientsRepository orderingProductIngredientsRepository;
    @Autowired
    OrderingProdcutRepository orderingProdcutRepository;
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
        if (categoryRepository.findById(id) != null) {
            product.setCategory(categoryRepository.findById(id));
        }
        productRepository.save(product);

    }

    @PostMapping("/product/addToCategorybyID/{categoryId}")
    public void addToCategorybyId(@PathVariable(name = "categoryId") int id, @RequestParam int productId) {
        Product product = productRepository.findById(productId);
        if (categoryRepository.findById(id) != null) {
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
    public void createOrdering(@RequestBody String pib) {

        try {

            JSONObject object = new JSONObject(pib);
            Ordering ordering = new Ordering();
            ordering.setDelivery(object.getBoolean("delivery"));

            //LocalDateTime orderDate = LocalDateTime.parse(object.getString("orderDate"));
            //ordering.setConfirmedTime(orderDate);//man könnte confirmed time auch als String machen;

            ordering.setConfirmedTime(LocalDateTime.now());
            ordering.setTimestamp(LocalDateTime.now());

            ordering.setPrice(13.9f);
            //es fehlt noch der preis
            orderingRepository.save(ordering);

            JSONArray products = object.getJSONArray("orderProduct");


            for (int i = 0; i < products.length(); ++i) {
                OrderingProduct orderingProduct = new OrderingProduct();
                JSONObject product = products.getJSONObject(i);
                orderingProduct.setQuantitiy(product.getInt("quantity"));
                orderingProduct.setProduct(productRepository.findById(product.getInt("id")));
                orderingProduct.setOrdering(ordering);
                orderingProduct.setProductPrice(13.9f);

                orderingProdcutRepository.save(orderingProduct);

                JSONArray ingredients = object.getJSONArray("productIngredients");

                for (int j = 0; j < ingredients.length(); ++j) {
                    OrderingProductIngredients orderingProductIngredients = new OrderingProductIngredients();
                    JSONObject ingredient = ingredients.getJSONObject(i);
                    orderingProductIngredients.setIngredient(ingredientRepository.findById(ingredient.getInt("id")));
                    orderingProductIngredients.setOrderingProduct(orderingProduct);
                    orderingProductIngredients.setOntop(ingredient.getBoolean("onTop"));

                    orderingProductIngredientsRepository.save(orderingProductIngredients);
                }
            }

        } catch (JSONException e) {

        }



        //vllt noch eine Arrayliste von ingredient, welche dann hinzugefügt werden
//        LocalDateTime localDateTime = LocalDateTime.now();
//        Ordering o = new Ordering();
//        o.setTimestamp(localDateTime);
//        o.setDelivery(delivery);
//        o.setPrice(price);
//        o.setConfirmed_time(localDateTime.plusHours(1));
//        for (Product p : productArrayList) {
//            OrderingProduct op = new OrderingProduct();
//            op.setOrdering(o);
//            op.setProduct(p);
//            op.setQuantitiy(1);
//            op.setProduct_price(13);
//            ordering_prodcutRepository.save(op);
//        }
//        orderingRepository.save(o);
        //orderingRepository.save(ordering);
    }


    @PostMapping("/ordering/delete/{orderingId}")
    public void deleteOrdering(@PathVariable(name = "orderingId") int id) {

        orderingRepository.delete(orderingRepository.findById(id));
    }


}
