package entities;

import java.util.Objects;

public class Product {
    private String name;
    private String pictureName;
    private Double dimension;
    private Integer numOfSofa;
    private String material;
    private String specialTreatment;
    private Category category;
    private SizeOfCover cover;
    private Double cost;
    private int orderId;
    public Product() {

    }
    private Product(Builder builder) {
        setName(builder.name);
        setPictureName(builder.pictureName);
        setDimension(builder.dimension);
        setNumOfSofa(builder.numOfSofa);
        setMaterial(builder.material);
        setSpecialTreatment(builder.specialTreatment);
        setCategory(builder.category);
        setCover(builder.cover);
        setCost(builder.cost);
        setOrderId(builder.orderId);

    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public Integer getNumOfSofa() {
        return numOfSofa;
    }
    public void setNumOfSofa(Integer numOfSofa) {
        this.numOfSofa = numOfSofa;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public SizeOfCover getCover() {
        return cover;
    }
    public void setCover(SizeOfCover cover) {
        this.cover = cover;
    }
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getPictureName() {
        return pictureName;
    }
    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
    public Double getDimension() {
        return dimension;
    }
    public void setDimension(Double dimension) {
        this.dimension = dimension;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getSpecialTreatment() {
        return specialTreatment;
    }
    public void setSpecialTreatment(String specialTreatment) {
        this.specialTreatment = specialTreatment;
    }
    public Double getCost() {return cost;}
    public void setCost(Double cost) {this.cost = cost;}
    @Override
    public String toString() {

        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", name, pictureName, dimension==null?"":dimension,numOfSofa==null?"":numOfSofa,cover==null?"":cover, material, specialTreatment, category, cost, orderId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return orderId == product.orderId && Objects.equals(name, product.name) && Objects.equals(pictureName, product.pictureName) && Objects.equals(dimension, product.dimension) && Objects.equals(numOfSofa, product.numOfSofa) && Objects.equals(material, product.material) && Objects.equals(specialTreatment, product.specialTreatment) && category == product.category && cover == product.cover && Objects.equals(cost, product.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pictureName, dimension, numOfSofa, material, specialTreatment, category, cover, cost, orderId);
    }

    public static double carpetCost(Double dimension){
        double []costCat = ProductFile.getCostOfCategory();
        return dimension * costCat[0];
    }
    public static double sofaCost(Integer numOfSofa){
        double []costCat = ProductFile.getCostOfCategory();
        return numOfSofa * costCat[1];
    }
    public static double coverCost(String sizeOfCover){
        double costOfProduct ;
        double []costCat = ProductFile.getCostOfCategory();
        if(sizeOfCover.equalsIgnoreCase("KING")){
            costOfProduct=costCat[2];
        }else if (sizeOfCover.equalsIgnoreCase("QUEEN")) {
            costOfProduct=costCat[3];
        }else if (sizeOfCover.equalsIgnoreCase("TWIN_XL")) {
            costOfProduct=costCat[4];
        }else if (sizeOfCover.equalsIgnoreCase("TWIN")) {
            costOfProduct=costCat[5];
        }else{
            costOfProduct=costCat[6];
        }
        return costOfProduct;
    }
    public static Builder builder(){
        return new Builder();
    }
    /**
     * {@code Product} builder static inner class.
     */
    public static final class Builder {
        int orderId;
        private String name;
        private String pictureName;
        private Double dimension;
        private Integer numOfSofa;
        private String material;
        private String specialTreatment;
        private Category category;
        private SizeOfCover cover;
        private Double cost;
        private Builder() {
            name=null;
            pictureName=null;
            dimension=null;
            numOfSofa=null;
            material=null;
            specialTreatment=null;
            category=null;
            cover=null;

        }
        /**
         * Sets the {@code name} and returns a reference to this Builder enabling method chaining.
         *
         * @param name the {@code name} to set
         * @return a reference to this Builder
         */
        public Builder setName(String name) {
            this.name = name;
            return this;
        }


        public Builder setOrderId(int orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Sets the {@code pictureName} and returns a reference to this Builder enabling method chaining.
         *
         * @param pictureName the {@code pictureName} to set
         * @return a reference to this Builder
         */
        public Builder setPictureName(String pictureName) {
            this.pictureName = pictureName;
            return this;
        }
        /**
         * Sets the {@code dimension} and returns a reference to this Builder enabling method chaining.
         *
         * @param dimension the {@code dimension} to set
         * @return a reference to this Builder
         */
        public Builder setDimension(Double dimension) {
            this.dimension = dimension;
            return this;
        }
        /**
         * Sets the {@code numOfSofa} and returns a reference to this Builder enabling method chaining.
         *
         * @param numOfSofa the {@code numOfSofa} to set
         * @return a reference to this Builder
         */
        public Builder setNumOfSofa(Integer numOfSofa) {
            this.numOfSofa = numOfSofa;
            return this;
        }
        /**
         * Sets the {@code material} and returns a reference to this Builder enabling method chaining.
         *
         * @param material the {@code material} to set
         * @return a reference to this Builder
         */
        public Builder setMaterial(String material) {
            this.material = material;
            return this;
        }
        /**
         * Sets the {@code specialTreatment} and returns a reference to this Builder enabling method chaining.
         *
         * @param specialTreatment the {@code specialTreatment} to set
         * @return a reference to this Builder
         */
        public Builder setSpecialTreatment(String specialTreatment) {
            this.specialTreatment = specialTreatment;
            return this;
        }
        /**
         * Sets the {@code category} and returns a reference to this Builder enabling method chaining.
         *
         * @param category the {@code category} to set
         * @return a reference to this Builder
         */
        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }
        /**
         * Sets the {@code cover} and returns a reference to this Builder enabling method chaining.
         *
         * @param cover the {@code cover} to set
         * @return a reference to this Builder
         */
        public Builder setCover(SizeOfCover cover) {
            this.cover = cover;
            return this;
        }
        /**
         * Returns a {@code Product} built from the parameters previously set.
         *
         * @return a {@code Product} built with parameters of this {@code Product.Builder}
         */
        public Builder setCost(Double cost) {
            this.cost = cost;
            return this;
        }
        public Product build() {
            return new Product(this);
        }
    }
}