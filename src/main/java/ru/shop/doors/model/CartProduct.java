package ru.shop.doors.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_product")
public class CartProduct {

    @Data
    @Embeddable
    public static class CartId implements Serializable {

        private Long order_id;

        private Long door_id;
    }



    @EmbeddedId
    private CartId cartId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "door_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    private Door door;


    @Column(name = "count")
    private int count;

    public CartId getCartId() {
        return cartId;
    }

    public void setCartId(CartId cartId) {
        this.cartId = cartId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}




//@Table(name = "cart_product")
//public class CartProduct {
//
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//    @ManyToOne
//    @JoinColumn(name = "door_id")
//    private Door door;
//
//    public Order getOrder_id() {
//        return order;
//    }
//
//    public void setOrder_id(Order order) {
//        this.order = order;
//    }
//
//    public Door getDoor() {
//        return door;
//    }
//
//    public void setDoor(Door door) {
//        this.door = door;
//    }
//}
