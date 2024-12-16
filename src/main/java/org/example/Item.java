package org.example;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Item {
    private int id;
    private int total;
    private String name;
    private Set<Cart> carts = new HashSet<>();

    public Item(){}

    public Item(int total, String name) {
        this.total = total;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && total == item.total && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, name);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", total=" + total +
                ", name='" + name + '\'' +
                ", carts=" + carts +
                '}';
    }
}
