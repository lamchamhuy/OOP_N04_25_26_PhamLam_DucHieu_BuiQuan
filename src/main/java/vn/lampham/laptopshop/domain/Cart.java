package vn.lampham.laptopshop.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(0)
    private int sum;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CartDetail> cartDetails;

    private String receiverName;
    private String receiverAddress;
    private String receiverPhone;

    // ===== Getters/Setters =====
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<CartDetail> getCartDetails() { return cartDetails; }
    public void setCartDetails(List<CartDetail> cartDetails) { this.cartDetails = cartDetails; }

    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }

    public String getReceiverAddress() { return receiverAddress; }
    public void setReceiverAddress(String receiverAddress) { this.receiverAddress = receiverAddress; }

    public String getReceiverPhone() { return receiverPhone; }
    public void setReceiverPhone(String receiverPhone) { this.receiverPhone = receiverPhone; }

    @Override
    public String toString() {
        return "Cart{id=" + id + ", sum=" + sum + ", user=" +
                (user != null ? user.getEmail() : "null") + "}";
    }
}
