package pepclass.com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pepclass.com.example.demo.Product;
import pepclass.com.example.demo.service.GreetingService;

import java.util.List;

@RestController
public class hellocontroller {
    @GetMapping("/getProduct")
    public List<Product> getProduct (){
        return List.of(
                new Product(1,"Product",20)
        );
    }
    private final GreetingService service;
    public hellocontroller(GreetingService service){
        this.service=service;
    }
    @Value("${server.port}")
    private String port;
    @GetMapping("/")
    public String Hello(){
        return "hello World";
    }
    @GetMapping("/hello")
    public String hello(){
        return service.greet(port);
    }
    @GetMapping("/products/{id}")
    public String getProduct (@PathVariable int id){
        return "Request For " + id;
    }
    @GetMapping("/search")
    public String search(@RequestParam String keyword, @RequestParam(defaultValue = "19") int limit){
        return "Searching for "+keyword+" with limit "+limit;
    }
    @PostMapping("/products")
    public Product create(@RequestBody Product product){
        System.out.println("Got: "+product.getName());
        return product;
    }
}
