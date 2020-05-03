package com.uca.capas.tareaLabo3.controller;

import com.uca.capas.tareaLabo3.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private List<Product> productos = new ArrayList<Product>();

    @GetMapping("/compraProducto")
    public ModelAndView compraProducto() {
        ModelAndView mav = new ModelAndView();

        productos.add(new Product(0, 40, "Te helado"));
        productos.add(new Product(1, 60, "Agua"));
        productos.add(new Product(2, 30, "Jugo de naranja"));
        productos.add(new Product(3, 12, "Limonada"));
        productos.add(new Product(4, 35, "Agua de coco"));

        mav.setViewName("productos");
        mav.addObject("product", new Product());
        mav.addObject("producto", productos);
        
        return mav;
    }

    @PostMapping("/validar")
    public ModelAndView validar(Product product) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("nombre", productos.get(product.getId()).getNombre());

        if(productos.get(product.getId()).getCantidad() >= product.getCantidad()) mav.setViewName("compra");
        else mav.setViewName("error");

        return mav;
    }
}
