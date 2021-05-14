package DTOs;

import java.util.Objects;

public class Identification {
    private int id;
    private String shopId;
    private String customerId;

    public Identification(String shopId, String customerId) {
        this.shopId = shopId;
        this.customerId = customerId;
    }

    public int getId(){
        return this.id;
    }

    public String getShopId(){
        return this.shopId;
    }

    public void setShopId(String shopId){
        this.shopId = shopId;
    }

    public String getCustomerId(){
        return this.customerId;
    }

    public void setCustomerId(String customerId){
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identification identification = (Identification) o;
        return shopId.equals(identification.shopId) && customerId.equals(identification.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, customerId);
    }
}
