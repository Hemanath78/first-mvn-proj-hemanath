package com.fssa.hnm.product;

public class Product {

  //	declaring the blue prints of the product object

  private String id;
  private Name name;
  private Image image;
  private Category category;
  private String description;
  private Nutritions nutritions;
  private AvailableStock availablestock;
  private Quantity quantity;
  private boolean status;

  //   default consturctor

  public Product() {}

  // Parameterized constructor
  public Product(
    String id,
    Name name,
    Image image,
    Category category,
    String description,
    Nutritions nutritions,
    AvailableStock availStock,
    Quantity quantity,
    boolean status
  ) {
    this.id = id;
    this.setName(name);
    this.setImage(image);
    this.setCategory(category);
    this.description = description;
    this.setNutritions(nutritions);
    this.setAvailablestock(availStock);
    this.setQuantity(quantity);
    this.status = status;
  }

  //	get and set for id

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  //	get and set for name

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  //	get and set for image

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  //	get and set for category

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  //	get and set for description

  public String getDesc() {
    return description;
  }

  public void setDesc(String desc) {
    this.description = desc;
  }

  //	get and set for nutrition's

  public Nutritions getNutritions() {
    return nutritions;
  }

  public void setNutritions(Nutritions nutritions) {
    this.nutritions = nutritions;
  }

  //	get and set for available stock

  public AvailableStock getAvailablestock() {
    return availablestock;
  }

  public void setAvailablestock(AvailableStock availablestock) {
    this.availablestock = availablestock;
  }

  //	get and set for quantity

  public Quantity getQuantity() {
    return quantity;
  }

  public void setQuantity(Quantity quantity) {
    this.quantity = quantity;
  }

  //	get and set for product status

  public boolean getStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
