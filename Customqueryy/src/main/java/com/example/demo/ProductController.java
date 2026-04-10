package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation. PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import edu.jfs.app.entity.Product;
import edu.jfs.app.service.ProductService;

@RestController

public class ProductController {

        @Autowired

        ProductService service;

        @GetMapping("/getProducts")

        public List<Product> getProducts() {

return service.getProducts();

}