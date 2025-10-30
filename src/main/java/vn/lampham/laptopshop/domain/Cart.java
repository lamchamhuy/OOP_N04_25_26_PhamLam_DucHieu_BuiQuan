package vn.lampham.laptopshop.domain;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(value = 0)
    private int sum;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartDetail> cartDetails;

    // ==== Thông tin người nhận (đã thêm) ====
    private String receiverName;
    private String receiverAddress;
    private String receiverPhone;
    // =======================================

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<CartDetail> getCartDetails() { return cartDetails; }
    public void setCartDetails(List<CartDetail> cartDetails) { this.cartDetails = cartDetails; }

    // getters / setters cho receiver fields
    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }

    public String getReceiverAddress() { return receiverAddress; }
    public void setReceiverAddress(String receiverAddress) { this.receiverAddress = receiverAddress; }

    public String getReceiverPhone() { return receiverPhone; }
    public void setReceiverPhone(String receiverPhone) { this.receiverPhone = receiverPhone; }

    @Override
    public String toString() {
        return "Cart [id=" + id + ", sum=" + sum + ", user=" + 
               (user != null ? user.getEmail() : "null") + 
               ", cartDetails=" + (cartDetails != null ? cartDetails.size() + " items" : "null") + "]";
    }
}
