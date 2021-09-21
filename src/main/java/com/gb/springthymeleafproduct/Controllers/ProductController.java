package com.gb.springthymeleafproduct.Controllers;

import com.gb.springthymeleafproduct.Product.Product;
import com.gb.springthymeleafproduct.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @Value("${welcome.message}")
    private String message;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping("/productList")
    public String showProducts(Model uiModel, @PageableDefault()Pageable pageable){
        Page<Product> page = service.getProducts(pageable);
        uiModel.addAttribute("products", page);
        uiModel.addAttribute("page", page);
        return "productList";
    }

    @RequestMapping(path = "/delete/{id}/{page}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, @PathVariable("page") Integer page) {
        service.deleteProduct(id);
        return "redirect:/productList?page=" + page;
    }

    @RequestMapping(value = { "/addProduct" }, method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("product", service.getProduct ());
        return "productForm";
    }

    @RequestMapping(value = { "/saveProduct" }, method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.saveProduct (product);
        return "redirect:/productList";
    }





}
