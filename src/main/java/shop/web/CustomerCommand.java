package shop.web;

import shop.domain.Customer;

/**
 * Created by Enibeni on 02.12.2014.
 */
public class CustomerCommand {
    private int id;
    private String name;
    private String email;
    private String address;

    public CustomerCommand() {
    }

    public CustomerCommand(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Customer toCustomer(){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);

        return customer;
    }

    public static CustomerCommand fromCustomer(Customer c){
        return new CustomerCommand(c.getId(), c.getName(), c.getEmail(), c.getAddress());
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + "\n" + email + "\n" + address;
    }
}
