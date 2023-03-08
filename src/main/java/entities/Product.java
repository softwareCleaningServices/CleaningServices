package entities;

public class Product {
    private String category;

    public Product() {
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    private String name;
    private String description;
    private int coast;

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    public Product(String category, String name, String description) {
        this.category = category;
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return
                "category=" + category +
                ", name='" + name + '\'' +
                ", description='" + description ;
    }
    /*
        private String picturePath = "";
    BufferedImage picture;

    {
        try {
            picture = ImageIO.read(new File(picturePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    */
}
