package com.geekbrains.geekmarket.services;

import com.geekbrains.geekmarket.entities.ItemCart;
import com.geekbrains.geekmarket.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;

import static java.util.Objects.isNull;


@Service
public class СartService {

    @Autowired
    private ProductService productService;
    private LinkedHashMap<Long, ItemCart> items;

    public Collection<ItemCart> getItemsCollection () {
        return getItems ().values ();
    }

    private LinkedHashMap<Long, ItemCart> getItems(){
        if (isNull (items)) items = new LinkedHashMap<> ();
        return items;
    }

    public void add (Long id) {
        Product product = productService.getProductById (id);
        if (isNull (product)) return;
        add (product);
    }

    private void add(Product product){
        if (getItems ().containsKey (product.getId ())){
            ItemCart item = getItems ().get (product.getId ());
            item.getProduct ().setPrice (item.getProduct ().getPrice () + product.getPrice ());
            item.setNum (item.getNum () + 1);
        } else {
            getItems ().put (product.getId (), new ItemCart (product));
        };
    }

    public void remove (Long id) {
        Product product = productService.getProductById (id);
        if (isNull (product) || !getItems ().containsKey (id)) return;
        remove(product);
    }

    public void remove(Product product){
        ItemCart item = getItems ().get (product.getId ());

        if (item.getNum () <= 1){
            getItems ().remove (product.getId ());
        } else {
            item.setNum (item.getNum () - 1);
            item.getProduct ().setPrice (item.getProduct ().getPrice () - product.getPrice ());
        }
    }

    public void removeItem (Long id) {
        getItems ().remove (id);
    }

    public int getNumProducts(){
        return getItemsCollection ().stream().mapToInt(ItemCart::getNum).sum ();
    }

    public double getSum(){
        return getItemsCollection ().stream().mapToDouble (items -> items.getProduct ().getPrice ()).sum ();
    }

    public boolean isEmpty () {
        return getItems ().isEmpty ();
    }

    public void clear () {
        getItems ().clear ();
    }

    public String getTitle(){
        if (isEmpty ()) return "The shopping cart is empty";
        return "Shopping cart";
    }
}
