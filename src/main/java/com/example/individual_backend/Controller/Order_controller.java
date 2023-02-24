package com.example.individual_backend.Controller;

import com.example.individual_backend.Entity.Customer;
import com.example.individual_backend.Entity.Order;
import com.example.individual_backend.Entity.Product;
import com.example.individual_backend.Pojo.Customer_pojo;
import com.example.individual_backend.Pojo.Order_pojo;
import com.example.individual_backend.Pojo.Product_pojo;
import com.example.individual_backend.Services.Customer_service;
import com.example.individual_backend.Services.Order_service;
import com.example.individual_backend.Services.Product_service;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Builder
@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class Order_controller {
    private final Product_service product_service;
    private final Customer_service customer_service;
    private final Order_service order_service;
    @GetMapping("/open/{P_id}")
    public String open(@PathVariable("P_id") Integer id, Model model, Principal principal){
        Product product=product_service.fetchById(id);
//        model.addAttribute("product",product);
//        model.addAttribute("logged",customer_service.findByUsername(principal.getName()));
        Order order=new Order();
        order.setPrice(product.getPrice());
        order.setPname(product.getProductname());
        order.setCname(customer_service.findByUsername(principal.getName()).getFullname());
        model.addAttribute("obj",new Order_pojo(order));
        return "Order";
    }
    @PostMapping("/save")
    public String saveProduct(Order_pojo order_pojo) throws IOException {
        order_service.saveProduct(order_pojo);
        return "redirect:/admin/open";   //Write the pop box of sucess message
    }
    @GetMapping("/view")
    public String view(Model model){
        List<Order> orders=order_service.fetchAll();
        model.addAttribute("orderlist",orders);
        return "adminorder";
    }
    @GetMapping("/delete/{O_id}")
    public String deleteById(@PathVariable("O_id") Integer id){
        order_service.delteById(id);
        return "redirect:/order/view";
    }

}
