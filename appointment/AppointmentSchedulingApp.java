package com.appointment;

import java.util.*;

class User {
    private int id;
    private String username;
    private String email;
    private List<Appointment> appointments;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

	public User(int id, String username, String email, List<Appointment> appointments) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.appointments = appointments;
	}
}

class ServiceProvider {
    private int id;
    private String name;
    private List<Appointment> appointments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public ServiceProvider(int id, String name, List<Appointment> appointments) {
		super();
		this.id = id;
		this.name = name;
		this.appointments = appointments;
	}
	public ServiceProvider(int i, String string) {
		// TODO Auto-generated constructor stub
	}
	
}

class Appointment {
    private int id;
    private ServiceProvider serviceProvider;
    private Date dateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Appointment(int id, ServiceProvider serviceProvider, Date dateTime) {
		super();
		this.id = id;
		this.serviceProvider = serviceProvider;
		this.dateTime = dateTime;
	}
	
}

class AppointmentSchedulingSystem {
    private List<User> users;
    private List<ServiceProvider> serviceProviders;
    private List<Appointment> appointments;

    public AppointmentSchedulingSystem(List<User> users, List<ServiceProvider> serviceProviders,
			List<Appointment> appointments) {
		super();
		this.users = users;
		this.serviceProviders = serviceProviders;
		this.appointments = appointments;
	}

	// Constructor, methods for adding users, providers, appointments

    public AppointmentSchedulingSystem() {
		// TODO Auto-generated constructor stub
	}

	public List<Appointment> getAvailableAppointments(ServiceProvider provider, Date date) {
        // Implement logic to fetch available appointments for the given provider and date
        return new ArrayList<>();
    }

    public void bookAppointment(User user, Appointment appointment) {
        user.bookAppointment(appointment);
        appointment.getServiceProvider().getAppointments().add(appointment);
    }

    public void cancelAppointment(User user, Appointment appointment) {
        user.cancelAppointment(appointment);
        appointment.getServiceProvider().getAppointments().remove(appointment);
    }

	public void addUser(User user1) {
		// TODO Auto-generated method stub
		
	}

	public void addServiceProvider(ServiceProvider provider1) {
		// TODO Auto-generated method stub
		
	}

	public void addAppointment(Appointment appointment1) {
		// TODO Auto-generated method stub
		
	}


    // Other methods for email notifications, user management, etc.
}

public class AppointmentSchedulingApp {
    public static void main(String[] args) {
        AppointmentSchedulingSystem schedulingSystem = new AppointmentSchedulingSystem();

        // Create and add users, service providers, and appointments
        User user1 = new User(1, "user1", "user1@example.com", null);
        ServiceProvider provider1 = new ServiceProvider(1, "Provider 1");
        Appointment appointment1 = new Appointment(1, provider1, new Date());

        schedulingSystem.addUser(user1);
        schedulingSystem.addServiceProvider(provider1);
        schedulingSystem.addAppointment(appointment1);

        // Sample interactions
        Date selectedDate = new Date();
        List<Appointment> availableAppointments = schedulingSystem.getAvailableAppointments(provider1, selectedDate);

        if (!availableAppointments.isEmpty()) {
            Appointment selectedAppointment = availableAppointments.get(0);
            schedulingSystem.bookAppointment(user1, selectedAppointment);
            System.out.println("Appointment booked!");
        }
    }
}
