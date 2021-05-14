package DTOs;

import java.util.Objects;

public class Customer {
    private int id;

    public int getId(){
        return this.id;
    }

    private Identification identification;

    public Identification getIdentification(){
        return this.identification;
    }

    private String name;

    public String getName() {
        return this.name;
    }

    private String address;

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public Customer(Identification identification, String name, String address){
        this.identification = identification;
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return identification.equals(customer.identification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identification);
    }
}
