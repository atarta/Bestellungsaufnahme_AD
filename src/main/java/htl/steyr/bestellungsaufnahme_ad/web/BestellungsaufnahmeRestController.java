package htl.steyr.bestellungsaufnahme_ad.web;


import htl.steyr.bestellungsaufnahme_ad.application.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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



}
