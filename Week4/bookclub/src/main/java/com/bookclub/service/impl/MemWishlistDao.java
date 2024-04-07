package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

import java.util.ArrayList;
import java.util.List;

public class MemWishlistDao implements WishlistDao {
    List<WishlistItem> wishlist;

    public MemWishlistDao() {
        this.wishlist = new ArrayList<WishlistItem>();
        this.wishlist.add(new WishlistItem("1508475318", "The Adventures of Sherlock Holmes"));
        this.wishlist.add(new WishlistItem("0439136350", "Harry Potter and the Prisoner of Azkaban"));
        this.wishlist.add(new WishlistItem("1338878956", "Harry Potter and the Goblet of Fire"));
        this.wishlist.add(new WishlistItem("9780439358064", "Harry Potter and the Order of the Phoenix"));
    }

    @Override
    public List<WishlistItem> list() {
        return this.wishlist;
    }

    @Override
    public WishlistItem find(String key) {
        for (WishlistItem item : wishlist) {
            if (item.getIsbn().equals(key)) {
                return item;
            }
        }
        return new WishlistItem();
    }
}
