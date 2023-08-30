package com.bookstore;

import java.util.*;

class Book {
    private String title;
    private String author;
    private double price;
    private List<Review> reviews = new ArrayList<>();

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        if (reviews.isEmpty()) {
            return 0.0;
        }
        double totalRating = 0.0;
        for (Review review : reviews) {
            totalRating += review.getRating();
        }
        return totalRating / reviews.size();
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

    
}

class Review {
    private String user;
    private int rating;
    private String comment;

    public Review(String user, int rating, String comment) {
        this.user = user;
        this.rating = rating;
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

   
}

class User {
    private String username;
    private String password;
    private List<Book> shoppingCart = new ArrayList<>();
    private List<Order> orderHistory = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addToCart(Book book) {
        shoppingCart.add(book);
    }

    public void placeOrder() {
        Order order = new Order(shoppingCart);
        orderHistory.add(order);
        shoppingCart.clear();
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Book> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(List<Book> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<Order> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(List<Order> orderHistory) {
		this.orderHistory = orderHistory;
	}


}

class Order {
    private List<Book> items = new ArrayList<>();
    private Date orderDate;
    private String status;

    public Order(List<Book> items) {
        this.items.addAll(items);
        this.orderDate = new Date();
        this.status = "Pending";
    }

	public List<Book> getItems() {
		return items;
	}

	public void setItems(List<Book> items) {
		this.items = items;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

   
}

public class OnlineBookStore {
    public static void main(String[] args) {
        Book book1 = new Book("MAHABHARATH", "VYASA", 1009.99);
        Book book2 = new Book("NADI", "NANU", 164.99);

        User user = new User("GOURI", "goura");

        user.addToCart(book1);
        user.addToCart(book2);
        user.placeOrder();

        // Display user's order history
        for (Order order : user.getOrderHistory()) {
            System.out.println("Order Date: " + order.getOrderDate());
            System.out.println("Status: " + order.getStatus());
            System.out.println("Items:");
            for (Book item : order.getItems()) {
                System.out.println("- " + item.getTitle());
            }
            System.out.println();
        }
    }
}
