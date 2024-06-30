package com.Elisa.biz.Controller;

import com.Elisa.biz.Customer;
import com.Elisa.biz.OrderClass;
import com.Elisa.biz.OrderItem;
import com.Elisa.biz.Product;
import com.Elisa.biz.Repositories.CustomerRepository;
import com.Elisa.biz.Repositories.OrderItemRepository;
import com.Elisa.biz.Repositories.OrderRepository;
import com.Elisa.biz.Repositories.ProductRepository;
import com.Elisa.biz.dto.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@RestController
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RequestMapping("/elisa")
public class RestControl {
    @Autowired
    private  CustomerRepository customRep;
    @Autowired
    private  ProductRepository prodRep;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRep;

    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public Product findProdWithId(Long id){
        Product product = prodRep.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return product;
    }
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public Customer findCustomerWithId(Long id){
        Customer customer = customRep.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.getOrders();
        return customer;
    }



    @PostMapping("/order")
    public ResponseEntity<String> order(@RequestBody OrderRequest orderReq){
        Customer customer = findCustomerWithId(orderReq.getCustomerId());
        OrderClass order = new OrderClass();
        order.setCustomer(customer);
       List<OrderItem> items= new ArrayList<>();
        for (Detail i:
                orderReq.getDetail()) {
            try{
                Product product = findProdWithId(i.getProductId());
                OrderItem orderItem = new OrderItem();
                orderItem.setProduct(product);
                orderItem.setQuantity(i.getQty());
                orderItem.setOrder(order);
                items.add(orderItem);

            }catch ( Exception e){
                System.out.println(e.getMessage());
            }

        }

        order.setSelected(items);
        order.setOrderDate(LocalDateTime.now());
        customer.getOrders().add(order);
        orderRepository.save(order);
        return ResponseEntity.ok("order saved successfully");
    }
    @PostMapping("/addCustomer")
    public ResponseEntity<String> newCustomer(@RequestBody CustomerDto customerdto){
        try{
            Customer customer = new Customer();
            customer.setEmail(customerdto.getEmail());
            customer.setFirstName(customerdto.getFirstName());
            customer.setLastName(customerdto.getLastName());
            customer.setPassword(customerdto.getPassword());
            customer.setOrders(new ArrayList<>());
            customRep.save(customer);
            return ResponseEntity.ok("account saved successfully");}
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("saving account failed: " + e.getMessage());
        }
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> newProduct(@RequestBody ProductDto productdto){
        try{
            Product product = new Product();
            product.setCategory(productdto.getCategory());
            product.setDescription(productdto.getDescription());
            product.setPrice(productdto.getPrice());
            product.setQuantity(productdto.getQuantity());
            product.setLocation(productdto.getLocation());
            prodRep.save(product);
            return ResponseEntity.ok("new product saved successfully");}
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("saving new product failed: " + e.getMessage());
        }
    }
    @GetMapping("/allProd")
    public List<Product> getAllProducts(){
        return prodRep.findAll();
    }

    @GetMapping("/allOrder")
    public List<OrderDto> getAllOrders(){
        return orderRepository.findAllOrdersWithDetails();
    }
    @GetMapping("/allCust")
    public List<Customer> getAll(){
        return customRep.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete( @PathVariable Long id){
         customRep.deleteById(id);
    }
}
