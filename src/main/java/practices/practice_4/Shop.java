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

package practices.practice_4;

import practices.practice_4.data.Product;
import practices.practice_4.data.Rating;

import java.math.BigDecimal;

/**
 * {@code Shop} class represents an application that manages Products
 *
 * @author yelyzavetalubenets
 * @version 4.0
 **/
public class Shop {

    public static void main(String[] args) {
        Product tea = createProduct(101, "Tea", BigDecimal.valueOf(1.99), null);
        printProduct(tea);
        Product coffee = createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
        printProduct(coffee);
        Product cake = createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR);
        printProduct(cake);
        Product product = createProduct(0, null, null, null);
        printProduct(product);

        Product cakeWithChangedRating = cake.applyRating(Rating.THREE_STAR);
        printProduct(cakeWithChangedRating);
    }

    public static Product createProduct(final int id, final String name, final BigDecimal price, final Rating rating) {
        Product p = new Product();
        if (rating != null) {
            return new Product(id, name, price, rating);
        } else if (id != 0 && name != null && price != null) {
            return new Product(id, name, price);
        }
        return p;
    }

    public static void printProduct(final Product p) {
        System.out.println(p.getId() + " " +
                p.getName() + " " +
                p.getPrice() + " " +
                p.getDiscount() + " " + p.getRating().getStars());
    }
}
