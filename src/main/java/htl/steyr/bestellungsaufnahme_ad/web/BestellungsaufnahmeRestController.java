package htl.steyr.bestellungsaufnahme_ad.web;


import htl.steyr.bestellungsaufnahme_ad.application.model.*;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BestellungsaufnahmeRestController {

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    Order_IngredientsRepository order_ingredientsRepository;
    @Autowired
    Order_ProdcutRepository order_prodcutRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

//-------------------------Category------------------------------------------
    @GetMapping("/category/get")
    public List<Category>categoryListlist(){return categoryRepository.findAll();    }

    @PostMapping(value = "/category/create")
    public void createCategory(@RequestBody Category category){
        //hier wäre ein if noch schön
        //Category savedCategory = categoryRepository.save(category);
        categoryRepository.save(category);
    }

//-------------------------Ingredients------------------------------------------

    @GetMapping("/ingredient/get")
    public List<Ingredient>ingredientListlist(){return ingredientRepository.findAll();}

    @PostMapping("/ingredient/create")
    public void createIngredient(@RequestBody Ingredient ingredient){
        //hier wäre ein if noch schön
        ingredientRepository.save(ingredient);
    }
    //-------------------------Product------------------------------------------

    @GetMapping("/product/get")
    public List<Product>productListlist(){return productRepository.findAll();}

    @PostMapping("/product/create")
    public void createProduct(@RequestBody Product product){
        //hier wäre ein if noch schön
        productRepository.save(product);
    }

    @PostMapping("/product/addToCategory/{categoryId}")
    public void addToCategory(@PathVariable(name = "categoryId") int id,@RequestBody Product product) {
        product.setCategory(categoryRepository.findById(id));
        productRepository.save(product);

    }

    @PostMapping("/product/delete/{productId}")
    public void deleteProduct(@PathVariable(name = "productId") int id){
        //hier wäre ein if noch schön
        productRepository.delete(productRepository.findById(id));
    }


    //-------------------------Order------------------------------------------

}
