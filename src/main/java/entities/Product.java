package entities;
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
    private int workerId;
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
        setWorkerId(builder.workerId);

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

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
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

        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", name, pictureName, dimension==null?"":dimension,numOfSofa==null?"":numOfSofa,cover==null?"":cover, material, specialTreatment, category, cost, orderId,workerId);
    }
    public static double carpetCost(Double dimension){
        return dimension * 8.0;
    }
    public static double sofaCost(Integer numOfSofa){
        return numOfSofa * 25.0;
    }
    public static double coverCost(String sizeOfCover){
        double costOfProduct = 0.0;
        if(sizeOfCover.equalsIgnoreCase("KING")){
            costOfProduct=20.0;
        }else if (sizeOfCover.equalsIgnoreCase("QUEEN")) {
            costOfProduct=18.0;
        }else if (sizeOfCover.equalsIgnoreCase("TWIN_XL")) {
            costOfProduct=12.0;
        }else if (sizeOfCover.equalsIgnoreCase("TWIN")) {
            costOfProduct=10.0;
        }else if (sizeOfCover.equalsIgnoreCase("CRIB")) {
            costOfProduct=8.0;
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
        public int orderId;
        private String name;
        private String pictureName;
        private Double dimension;
        private Integer numOfSofa;
        private String material;
        private String specialTreatment;
        private Category category;
        private SizeOfCover cover;
        private Double cost;
        private int workerId;

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
        public Builder setWorkerId(int workerId) {
            this.workerId = workerId;
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