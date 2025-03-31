/*
 * Copyright (c) 2025.
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package practices.practice_4.data;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * {@code Product} class represents properties and behaviors of product objects in the Product Management System.
 * <br>
 * Each product has an id, name, and price
 * <br>
 * Each product can have a discount, calculated based on a
 * {@link DISCOUNT_RATE discount rate}
 *
 * @author yelyzavetalubenets
 * @version 4.0
 **/
public class Product {
    /**
     * A constant that defines a
     * {@link java.math.BigDecimal BigDecimal} value of the discount rate
     * <br>
     * Discount rate is 10%
     **/
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private final int id;
    private final String name;
    private final BigDecimal price;
    private Rating rating;

    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(int id, String name, BigDecimal price) {
        this(id, name, price, Rating.NOT_RATED);
    }

    public Product() {
        this(0, "no name", BigDecimal.ZERO);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Calculate discount based on a product price and
     * {@link DISCOUNT_RATE discount rate}
     *
     * @return a {@link java.math.BigDecimal BigDecimal}
     * value of the discount
     **/

    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
    }

    public Rating getRating() {
        return rating;
    }

    public Product applyRating(Rating newRating) {
        return new Product(id, name, price, newRating);
    }
}
