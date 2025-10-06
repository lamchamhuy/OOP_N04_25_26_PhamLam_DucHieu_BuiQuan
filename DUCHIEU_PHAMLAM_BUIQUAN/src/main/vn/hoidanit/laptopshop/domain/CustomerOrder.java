package vn.hoidanit.laptopshop.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")
public class CustomerOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne private User user;
    @ManyToOne private Product product;
    private int quantity;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;
    public CustomerOrder(){ this.createdAt = LocalDateTime.now(); }
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public User getUser(){return user;}
    public void setUser(User user){this.user=user;}
    public Product getProduct(){return product;}
    public void setProduct(Product product){this.product=product;}
    public int getQuantity(){return quantity;}
    public void setQuantity(int quantity){this.quantity=quantity;}
    public BigDecimal getTotalPrice(){return totalPrice;}
    public void setTotalPrice(BigDecimal totalPrice){this.totalPrice=totalPrice;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
}
