package week8.class_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface PaymentMethod {
    String getMethodName();
    boolean processPayment(double amount);

    class Customer extends ShoppingCustomer {
        public Customer(String name) {
            super(name);
        }
    }

    class Order extends ShoppingOrder {
        public Order(String orderId, ShoppingCustomer customer) {
            super(orderId, customer);
        }
    }

    class Product extends ShoppingProduct {
        public Product(String name, double price) {
            super(name, price);
        }
    }
}

class CreditCardPayment implements PaymentMethod {
    private final boolean successful;

    public CreditCardPayment() {
        this(true);
    }

    public CreditCardPayment(boolean successful) {
        this.successful = successful;
    }

    @Override
    public String getMethodName() {
        return "Credit Card";
    }

    @Override
    public boolean processPayment(double amount) {
        return successful;
    }
}

class PayPalPayment implements PaymentMethod {
    private final boolean successful;

    public PayPalPayment() {
        this(false);
    }

    public PayPalPayment(boolean successful) {
        this.successful = successful;
    }

    @Override
    public String getMethodName() {
        return "PayPal";
    }

    @Override
    public boolean processPayment(double amount) {
        return successful;
    }
}

class BankTransferPayment implements PaymentMethod {
    private final boolean successful;

    public BankTransferPayment() {
        this(true);
    }

    public BankTransferPayment(boolean successful) {
        this.successful = successful;
    }

    @Override
    public String getMethodName() {
        return "Bank Transfer";
    }

    @Override
    public boolean processPayment(double amount) {
        return successful;
    }
}

class ShoppingProduct {
    private final String name;
    private final double price;

    public ShoppingProduct(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCustomer {
    private final String name;

    public ShoppingCustomer(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

enum OrderStatus {
    Pending, Paid, Failed
}

class OrderItem {
    private final ShoppingProduct product;
    private final int quantity;

    public OrderItem(ShoppingProduct product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public ShoppingProduct getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
}

class ShoppingOrder {
    private final String orderId;
    private final ShoppingCustomer customer;
    private final List<OrderItem> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.Pending;

    public ShoppingOrder(String orderId, ShoppingCustomer customer) {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("orderId cannot be blank");
        }
        if (customer == null) {
            throw new IllegalArgumentException("customer cannot be null");
        }
        this.orderId = orderId;
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public ShoppingCustomer getCustomer() {
        return customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addProduct(ShoppingProduct product, int quantity) {
        items.add(new OrderItem(product, quantity));
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getTotalAmount() {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }
}

class PaymentProcessor {
    public static List<String> processPayment(ShoppingOrder order, PaymentMethod paymentMethod) {
        List<String> output = new ArrayList<>();
        if (order.isEmpty()) {
            output.add("Cannot process payment for an empty order.");
            return output;
        }
        output.add("Payment initiated via " + paymentMethod.getMethodName() + " for " + order.getOrderId() + ".");
        boolean success = paymentMethod.processPayment(order.getTotalAmount());
        if (success) {
            order.setStatus(OrderStatus.Paid);
            output.add("Payment for " + order.getOrderId() + " successful. Order status: Paid.");
        } else {
            order.setStatus(OrderStatus.Pending);
            output.add("Payment for " + order.getOrderId() + " failed. Order status: Pending.");
        }
        return output;
    }
}
