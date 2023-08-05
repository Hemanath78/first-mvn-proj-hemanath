package com.fssa.hnm.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 *
 * @author HemanathMuralikrishn
 *
 */

class TestObjectProduct {

  //	creating new product object with all attributes and values

  public Product getProduct() {
    // creating new instance of product class
    Product product = new Product();

    // set the product id
    product.setId("demo001");

    // set the proudct name by creating instance of name class
    Name productName = new Name();
    productName.setEng("Demo product name");
    productName.setTam("டெமோ தயாரிப்பு பெயர்");

    // set the name object to the product object
    product.setName(productName);

    // set the proudct image by creating instance of image class
    Image productImage = new Image();
    productImage.setImgUrl(
      "https://freeimghost.net/images/2023/03/01/apple-green.jpeg"
    );
    productImage.setImgAlt("apple_green_fruit_image");

    // set the image object to the product object
    product.setImage(productImage);

    // set the product category by creating instance of category class
    Category productCategory = new Category();
    productCategory.setCatId("cat001");
    productCategory.setCatName("Exotic fruits");

    // set the category object to the product object
    product.setCategory(productCategory);

    // set the product description
    product.setDesc("This is a product description");

    // set the nutritions by creating instance of nutritions class
    Nutritions productNutritions = new Nutritions();
    // set the protein nutritions by creating instance of protein class
    Protein protein = new Protein();
    protein.setNum(2.0);
    protein.setUnit("gm");

    // set the carbohydrates nutritions by creating instace of carbohydrates class
    Carbohydrates carbo = new Carbohydrates();
    carbo.setNum(4.0);
    carbo.setUnit("gm");

    // set the protein object to the nutrition's object
    productNutritions.setProtein(protein);
    // set the carbohydrates object to the nutritions object
    productNutritions.setCarbo(carbo);
    // set the calories
    productNutritions.setKcal(70);

    // set the nutiritions object to the product object
    product.setNutritions(productNutritions);

    // set the available stock by creating instance of availablestock class
    AvailableStock availablestock = new AvailableStock();
    availablestock.setNum(25);
    availablestock.setUnit("kg");

    // set the available stock object to the product object
    product.setAvailablestock(availablestock);

    // set the quantity by creating instance of quantity class
    Quantity qty = new Quantity();
    qty.setWeight(1);
    qty.setUnit("kg");
    qty.setRs(200);

    // set the quantity object to the product object
    product.setQuantity(qty);

    product.setStatus(true);

    return product;
  }

  //	main method validation test cases starts

  @Test // checking the main validation method with object
  void testMainValidation() {
    Product product = getProduct();

    assertTrue(ProductValidator.validateAll(product));
  }

  @Test // checking the main validation method with null
  void testMainValidationWithNull() {
    Product product = null;

    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateAll(product);
      }
    );

    assertEquals(
      "Invalid product. Product cannot be null",
      exception.getMessage()
    );
  }

  //	main method validation test cases ends

  //	test cases to validate the main validation method

  //	test cases for product names start

  //		test cases start for product name english

  @Test // checking the product name object validator with validate inputs
  void testProNameValidate() {
    Name name = getProduct().getName();
    assertTrue(ProductValidator.validateNameObj(name));
  }

  @Test // checking the product name object validator with null
  void testProNameValidateWithNull() {
    Name name = null;

    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateNameObj(name);
      }
    );

    assertEquals(
      "Invalid product name. Product name cannot be null.",
      exception.getMessage()
    );
  }

  @Test // checking the product name with correct input
  void testproEngNameCorrect() {
    assertTrue(ProductValidator.validateEngName("Demo product name"));
  }

  @Test // checking the product name with null
  void proEngNameWithNull() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateEngName(null);
      }
    );

    assertEquals(
      "Invalid Product English Name. It cannot be null or empty.",
      exception.getMessage()
    );
  }

  @Test // checking with empty string
  void testproEngNameWithEmpty() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateEngName("    ");
      }
    );

    assertEquals(
      "Invalid Product English Name. It cannot be null or empty.",
      exception.getMessage()
    );
  }

  @Test // checking with wrong product name pattern
  void testproEngNameRegex() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateEngName("demoProduct1234");
      }
    );

    assertEquals(
      "Invalid Product English Name. Given input doesn't match the requested format.",
      exception.getMessage()
    );
  }

  //		test cases end for product name english

  //		test cases start for product tamil name

  @Test // checking the product name with correct input
  void testTamNameCorrect() {
    assertTrue(ProductValidator.validateTamName("டெமோ தயாரிப்பு பெயர்"));
  }

  @Test // checking the product name with null
  void testTamNameWithNull() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateTamName(null);
      }
    );

    assertEquals(
      "Invalid Product Tamil Name. It cannot be null or empty.",
      exception.getMessage()
    );
  }

  @Test // checking with empty string
  void testTamNameWithEmpty() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateTamName("    ");
      }
    );

    assertEquals(
      "Invalid Product Tamil Name. It cannot be null or empty.",
      exception.getMessage()
    );
  }

  @Test // checking with wrong product name pattern
  void testproTamNameRegex() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateTamName("டெமோதயாரிப்புபெயர்abc1234");
      }
    );

    assertEquals(
      "Invalid Product Tamil Name. Given input doesn't match the requested format.",
      exception.getMessage()
    );
  }

  //		test cases end for product tamil name

  //	test cases for product names end

  //	test cases for product image start

  //		test cases for product image url starts

  @Test // checking the image object validator with valid input
  void testImageObjValidate() {
    Image image = getProduct().getImage();
    assertTrue(ProductValidator.validateImageObj(image));
  }

  @Test // checking the image object validator with null input
  void testImageObjValidateWithNull() {
    Image image = null;

    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateImageObj(image);
      }
    );

    assertEquals(
      "Invalid product image. Product image cannot be null.",
      exception.getMessage()
    );
  }

  @Test // checking the image url with correct input
  void testImageUrlWithCorrect() {
    assertTrue(
      ProductValidator.validateImageUrl(
        "https://freeimghost.net/images/2023/03/01/apple-green.jpeg"
      )
    );
  }

  @Test // checking the image url with null
  void testImageUrlWithNull() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateImageUrl(null);
      }
    );

    assertEquals(
      "Invalid Product Image URL. It cannot be null or empty.",
      exception.getMessage()
    );
  }

  @Test // checking the image url with null
  void testImageUrlWithEmpty() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateImageUrl("    ");
      }
    );

    assertEquals(
      "Invalid Product Image URL. It cannot be null or empty.",
      exception.getMessage()
    );
  }

  @Test // checking the image ulr with regex pattern
  void testImagUrlWithRegex() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateImageUrl("http://example.com/image.txt");
      }
    );

    assertEquals(
      "Invalid Product Image URL. Given input doesn't match the requested format.",
      exception.getMessage()
    );
  }

  //		test cases for product image url ends

  //		test cases for product image alt starts

  @Test // checking the image url with correct input
  void testImageAltWithCorrect() {
    assertTrue(ProductValidator.validateImageAlt("Demo_alternative_text"));
  }

  @Test // checking the image url with null
  void testImageAltWithNull() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateImageAlt(null);
      }
    );

    assertEquals(
      "Invalid Product Image Alternative text. It cannot be null or empty.",
      exception.getMessage()
    );
  }

  @Test // checking the image url with null
  void testImageAltWithEmpty() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateImageAlt("    ");
      }
    );

    assertEquals(
      "Invalid Product Image Alternative text. It cannot be null or empty.",
      exception.getMessage()
    );
  }

  @Test // checking the image ulr with regex pattern
  void testImageAltWithRegex() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateImageAlt("   78672_demo");
      }
    );

    assertEquals(
      "Invalid Product Image Alternative text. Given input doesn't match the requested format.",
      exception.getMessage()
    );
  }

  //		test cases for proudct image alt ends

  //	test cases for product image end

  //	test cases for product description starts

  @Test // checking the product description with correct input
  void testProDesc() {
    assertTrue(ProductValidator.validateDesc("This is a product description."));
  }

  @Test // checking the product description with null
  void testProDescWithNull() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateDesc(null);
      }
    );

    assertEquals(
      "Invalid Product Description. It cannot be null or empty.",
      exception.getMessage()
    );
  }

  @Test // checking the product description with empty
  void testProDescWithEmpty() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateDesc("     ");
      }
    );

    assertEquals(
      "Invalid Product Description. It cannot be null or empty.",
      exception.getMessage()
    );
  }

  @Test // checking the product description with regex pattern
  void testProDescWithRegex() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateDesc(
          "This description contains invalid characters: { } [ ]"
        );
      }
    );

    assertEquals(
      "Invalid Product Description. Given input doesn't match the requested format.",
      exception.getMessage()
    );
  }

  //	test cases for product description ends

  //	test cases for nutritions starts

  @Test // checking the nutritions object validate with valid input
  void testNutrObjValidate() {
    Nutritions nutritions = getProduct().getNutritions();
    assertTrue(ProductValidator.validateNutrObj(nutritions));
  }

  @Test // checking the nutritions object with null input
  void testNutrObjValidateWithNll() {
    Nutritions nutritions = null;

    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateNutrObj(nutritions);
      }
    );

    assertEquals(
      "Invalid product nutritions. Nutritions cannot be null.",
      exception.getMessage()
    );
  }

  //		test cases for protein starts

  @Test // checking the protein object validate with valid input
  void testProteinObjValidate() {
    Protein protein = getProduct().getNutritions().getProtein();

    assertTrue(ProductValidator.validateProteinObj(protein));
  }

  @Test // checking the protein object validate with null input
  void testProteinObjValidateWithNull() {
    Protein protein = null;

    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateProteinObj(protein);
      }
    );

    assertEquals(
      "Invalid protein nutritions. Protein nutritions cannot be null.",
      exception.getMessage()
    );
  }

  @Test // checking the protein num with correct input
  void testNutrProteinWithCorrect() {
    assertTrue(ProductValidator.validateProteinNum(5.03));
  }

  @Test // checking the protein num with lesser than zero
  void testNutrProteinWithNeg() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateProteinNum(-5.03);
      }
    );

    assertEquals(
      "Invalid Product protein nutrition. Nutritions value cannot be less than zero.",
      exception.getMessage()
    );
  }

  //		test cases for protein ends

  //		test cases for carbo hydrates starts

  @Test // checking the carbo hydrates object validate with valid input
  void testCarboObjValidate() {
    Carbohydrates carbo = getProduct().getNutritions().getCarbo();

    assertTrue(ProductValidator.validateCarboObj(carbo));
  }

  @Test // checking the carbo hydrates object validate with null input
  void testCarboObjValidateWithNull() {
    Carbohydrates carbo = null;

    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateCarboObj(carbo);
      }
    );

    assertEquals(
      "Invalid carbohydrates nutritions. Protein nutritions cannot be null",
      exception.getMessage()
    );
  }

  @Test // checking the protein num with correct input
  void testNutrCarboWithCorrect() {
    assertTrue(ProductValidator.validateCarbohydrateNum(5.03));
  }

  @Test // checking the protein num with lesser than zero
  void testNutrCarboWithNeg() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateCarbohydrateNum(-5.03);
      }
    );

    assertEquals(
      "Invalid Product Carbohydrates nutritions. Nutritions value cannot be less than zero.",
      exception.getMessage()
    );
  }

  //		test cases for carbo hydrates ends

  //		test cases for calories starts

  @Test // checking the protein num with correct input
  void testNutrKcalWithCorrect() {
    assertTrue(ProductValidator.validateCaloriesNum(123));
  }

  @Test // checking the protein num with lesser than zero
  void testNutrKcalWithNeg() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateCaloriesNum(-123);
      }
    );

    assertEquals(
      "Invalid Product calories. Nutritions value cannot be less than zero.",
      exception.getMessage()
    );
  }

  //		test cases for calories ends

  //	test cases for nutritions ends

  //	test cases for available stock starts

  @Test // checking the available stock object validate with valid input
  void testAvailableStockValidate() {
    AvailableStock availableStock = getProduct().getAvailablestock();

    assertTrue(ProductValidator.validateAvailStockObj(availableStock));
  }

  @Test // checking the available stock object validate with null
  void testAvailableStockValidateWithNull() {
    AvailableStock availableStock = null;

    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateAvailStockObj(availableStock);
      }
    );

    assertEquals(
      "Invalid available stock. Available stock cannote be null.",
      exception.getMessage()
    );
  }

  //		test cases for available stock unit starts

  @Test // checking the unit with correct input
  void testAvailStockUnitCorrect() {
    assertTrue(ProductValidator.validateAvailStockUnit("kg"));
    assertTrue(ProductValidator.validateAvailStockUnit("nos"));
    assertTrue(ProductValidator.validateAvailStockUnit("pkt"));
  }

  @Test // checking the unit with null
  void testAvailStockUnitWithNull() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateAvailStockUnit(null);
      }
    );

    assertEquals(
      "Invalid Available stock unit. It cannot be null or empty.",
      exception.getMessage()
    );
  }

  @Test // checking the unit with empty string
  void testAvailStockUnitWithEmpty() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateAvailStockUnit("     ");
      }
    );

    assertEquals(
      "Invalid Available stock unit. It cannot be null or empty.",
      exception.getMessage()
    );
  }

  @Test // checking the unit without available units
  void testAvailStockUnitWithUnit() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateAvailStockUnit("gm");
      }
    );

    assertEquals(
      "Invalid available stock unit. Requested unit is not given.",
      exception.getMessage()
    );
  }

  //		test cases for available stock unit ends

  //		test cases for available stock num

  @Test // checking the num with correct input kg
  void testAvailStockNumWithCorrectUnitKg() {
    assertTrue(ProductValidator.validateAvailStockNum(22, "kg"));
  }

  @Test // checking the num with correct input nos
  void testAvailStockNumWithCorrectUnitNos() {
    assertTrue(ProductValidator.validateAvailStockNum(22, "nos"));
  }

  @Test // checking the num with correct input pkt
  void testAvailStockNumWithCorrectUnitPkt() {
    assertTrue(ProductValidator.validateAvailStockNum(22, "pkt"));
  }

  @Test // checking the num with lesser than zero in kg
  void testAvailStockNumWithLesserthanZeroWithKg() {
    //		checking with kg
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateAvailStockNum(-2, "kg");
      }
    );

    assertEquals(
      "Invalid available stock. Available stock must be greater than 20 kg.",
      exception.getMessage()
    );
  }

  @Test // checking the num with lesser than zero in nos
  void testAvailStockNumWithLesserthanZeroWithNos() {
    //		checking with nos

    Exception exception1 = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateAvailStockNum(4, "nos");
      }
    );

    assertEquals(
      "Invalid available stock. Available stock must be greater than 20 nos.",
      exception1.getMessage()
    );
  }

  @Test // checking with num with leseer than zero in pkt
  void testAvailStockNumWithLesserthanZeroWithPkt() {
    //		checking with pkt

    Exception exception2 = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateAvailStockNum(10, "pkt");
      }
    );

    assertEquals(
      "Invalid available stock. Available stock must be greater than 20 pkt.",
      exception2.getMessage()
    );
  }

  //		test cases for available stock num

  //	test cases for available stock ends

  //	test cases for quantity starts

  @Test // checking the quantity object validate with valid input
  void testQuantityObjValidate() {
    Quantity quantity = getProduct().getQuantity();
    assertTrue(ProductValidator.validateQuantityObj(quantity));
  }

  @Test // checking the quantity object validate with null input
  void testQuantityObjValidateWithNull() {
    Quantity quantity = null;
    Exception exception2 = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateQuantityObj(quantity);
      }
    );

    assertEquals(
      "Invalid product qty. It cannot be null.",
      exception2.getMessage()
    );
  }

  @Test // checking the product price with right input
  void testProPrice() {
    assertTrue(ProductValidator.validateRs(150));
  }

  @Test // checking the product price with lesser than zero
  void testProPriceWithZero() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateRs(0);
      }
    );

    assertEquals(
      "Invalid product price. Price cannot be lesser than zero.",
      exception.getMessage()
    );
  }

  @Test // checking the product weight unit with right inputs
  void testProductWeightUnitWithKg() {
    assertTrue(ProductValidator.validateQtyUnit("kg"));
  }

  @Test // checking the product weight unit with gm input
  void testProductWeightUnitWithGm() {
    assertTrue(ProductValidator.validateQtyUnit("gm"));
  }

  @Test // checking the product weight unit with nos input
  void testProductWeightUnitWithNos() {
    assertTrue(ProductValidator.validateQtyUnit("nos"));
  }

  @Test // checking the product weight unit with pkt input
  void testProductWeightUnitWithPkt() {
    assertTrue(ProductValidator.validateQtyUnit("pkt"));
  }

  @Test // checking the product weight unit with wrong input
  void testProductWeightUnitWrong() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateQtyUnit("li");
      }
    );

    assertEquals(
      "Invalid product weight unit. Requested unit is not given.",
      exception.getMessage()
    );
  }

  @Test // checking the product weight with right num and kg
  void testProductWeight() {
    assertTrue(ProductValidator.validateQtyWeight(1.0, "kg"));
  }

  @Test // checking the proudct weight with right num and nos
  void testProductWeightWithNos() {
    assertTrue(ProductValidator.validateQtyWeight(1, "nos"));
  }

  @Test // checking the product weight right num and pkt
  void testProductWeightPkt() {
    assertTrue(ProductValidator.validateQtyWeight(1, "pkt"));
  }

  @Test // checking the proudct weight right num and gm
  void testProductWeightGm() {
    assertTrue(ProductValidator.validateQtyWeight(250, "gm"));
  }

  @Test // checking the product weight with wrong input
  void testProductWeightWrong() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateQtyWeight(0, "kg");
      }
    );

    assertEquals(
      "Invalid weight. Weight cannot be lesser than zero.",
      exception.getMessage()
    );
  }

  @Test // checking the product weight with gm with lesser than 250 gram
  void testProudctWeightWithGm() {
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        ProductValidator.validateQtyWeight(240, "gm");
      }
    );

    assertEquals(
      "Invalid weight for unit grams. The weight must be greather than 250 grams.",
      exception.getMessage()
    );
  }
  //	test cases for quantity ends

}
