package com.movie;

import java.util.*;

class Movie {
    private int id;
    private String title;
    private Set<String> genres;
    private double averageRating;
    private List<Rating> ratings;

    public Movie(int id, String title, Set<String> genres, double averageRating, List<Rating> ratings) {
		super();
		this.id = id;
		this.title = title;
		this.genres = genres;
		this.averageRating = averageRating;
		this.ratings = ratings;
	}

	public Movie(int i, String string, HashSet<String> hashSet) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<String> getGenres() {
		return genres;
	}

	public void setGenres(Set<String> genres) {
		this.genres = genres;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public void addRating(Rating rating) {
        ratings.add(rating);
        calculateAverageRating();
    }

    private void calculateAverageRating() {
        if (ratings.isEmpty()) {
            averageRating = 0.0;
            return;
        }
        double totalRating = 0.0;
        for (Rating rating : ratings) {
            totalRating += rating.getValue();
        }
        averageRating = totalRating / ratings.size();
    }
}

class User {
    private int id;
    private List<Rating> ratings;
    private Set<String> preferences;

   

    public User(int id, List<Rating> ratings, Set<String> preferences) {
		super();
		this.id = id;
		this.ratings = ratings;
		this.preferences = preferences;
	}

	public User(int i) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Set<String> getPreferences() {
		return preferences;
	}

	public void setPreferences(Set<String> preferences) {
		this.preferences = preferences;
	}

	public void rateMovie(Movie movie, int ratingValue) {
        Rating rating = new Rating(this, movie, ratingValue);
        ratings.add(rating);
        movie.addRating(rating);
    }

    public void updatePreferences(Set<String> newPreferences) {
        preferences = newPreferences;
    }
}

class Rating {
    private User user;
    private Movie movie;
    private int value;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Rating(User user, Movie movie, int value) {
		super();
		this.user = user;
		this.movie = movie;
		this.value = value;
	}

    // Constructor, getters for user, movie, and value
    
}

class MovieRecommendationSystem {
    private List<Movie> movies;
    private List<User> users;

    public MovieRecommendationSystem(List<Movie> movies, List<User> users) {
		super();
		this.movies = movies;
		this.users = users;
	}

	// Constructor, methods for adding movies and users

    public MovieRecommendationSystem() {
		// TODO Auto-generated constructor stub
	}

	public List<Movie> getRecommendedMovies(User user) {
        // Implement recommendation algorithms (collaborative/content-based)
        // Return a list of recommended movies
        return new ArrayList<>();
    }

    public List<Movie> searchMoviesByGenre(String genre) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getGenres().contains(genre)) {
                result.add(movie);
            }
        }
        return result;
    }

	public void addMovie(Movie movie1) {
		// TODO Auto-generated method stub
		
	}

	public void addUser(User user1) {
		// TODO Auto-generated method stub
		
	}

    // Other methods for handling user interactions, feedback, etc.
}

public class MovieRecommendationApp {
    public static void main(String[] args) {
        MovieRecommendationSystem recommendationSystem = new MovieRecommendationSystem();

        // Create and add movies
        Movie movie1 = new Movie(1, "HONDISI BAREYIRI", new HashSet<>(Arrays.asList("Action", "Adventure")));
        Movie movie2 = new Movie(2, "OLAVE MANDARA", new HashSet<>(Arrays.asList("Drama", "Romance")));
        recommendationSystem.addMovie(movie1);
        recommendationSystem.addMovie(movie2);

        // Create and add users
        User user1 = new User(1);
        User user2 = new User(2);
        recommendationSystem.addUser(user1);
        recommendationSystem.addUser(user2);

        // Sample interactions
        user1.rateMovie(movie1, 4);
        user2.rateMovie(movie1, 5);
        user2.rateMovie(movie2, 3);

        List<Movie> recommendedMovies = recommendationSystem.getRecommendedMovies(user1);
        System.out.println("Recommended Movies for User 1:");
        for (Movie movie : recommendedMovies) {
            System.out.println(movie.getTitle());
        }
    }
}
