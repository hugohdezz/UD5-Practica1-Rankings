package net.salesianos.element;

public class Motorbike {
    private String brand;
    private float price;
    private int ranking;
    private int cv;

    public Motorbike(String brand, float price, int ranking, int cv) {
        this.brand = brand;
        this.price = price;
        this.ranking = ranking;
        this.cv = cv;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", ranking=" + ranking +
                ", cv=" + cv +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Motorbike)) return false;

        Motorbike motorbike = (Motorbike) o;

        if (Float.compare(motorbike.price, price) != 0) return false;
        if (ranking != motorbike.ranking) return false;
        if (cv != motorbike.cv) return false;
        return brand != null ? brand.equals(motorbike.brand) : motorbike.brand == null;
    }

    
}
