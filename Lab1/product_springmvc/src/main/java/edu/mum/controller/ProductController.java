package edu.mum.controller;

import edu.mum.domain.Category;
import edu.mum.domain.Product;
import edu.mum.service.CategoryService;
import edu.mum.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getProductForm(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "ProductForm";
    }

    @PostMapping
    public String saveProduct(Product product) {
        Category category = categoryService.getCategory(product.getCategory().getId());
        product.setCategory(category);
        productService.save(product);
        return "ProductDetails";
    }

    @GetMapping("/listproducts")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "ListProducts";
    }


    @GetMapping("/productfind")
    public String findProduct(Model model, @RequestParam(value = "id", required = false) Integer id) {
        if (null != id) {
            Product product = productService.getById(id);
            if (null != product) {
                model.addAttribute("product", productService.getById(id));
                return "SingleProduct";
            }
        }
        return "Find";
    }

}
