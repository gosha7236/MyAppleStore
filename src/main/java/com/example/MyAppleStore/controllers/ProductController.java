package com.example.MyAppleStore.controllers;

import com.example.MyAppleStore.models.Product;
import com.example.MyAppleStore.services.ProductService;
import jakarta.mail.Multipart;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor // TODO добавляет автоматически все обязательные конструкторы
public class ProductController {
    private final ProductService productService;
    @GetMapping("/") // TODO получаем данные с помощью такой команды
    public String products(@RequestParam(name="title", required = false)String title, Model model) {
        model.addAttribute("products",productService.listProducts(title)); // добавляем список с товарами на главную страницу сайта
        return "products";
    }
    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, Product product) throws IOException {
        productService.SaveProduct(product, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.DeleteProduct(id);
        return "redirect:/";
    }

}
