package com.fssa.hnm.product;

import java.util.regex.Pattern;

/**
 *
 * @author HemanathMuralikrishn
 *
 */

public class ProductValidator {

  //	the below three are basic validation for maximum inputs

  // validate the object is not equal to null

  public static void ValidateObject(Object object, String errorMessage)
    throws IllegalArgumentException {
    // if object is null then throw an expection

    if (object == null) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  //	checking the string is null or empty

  public static void validateNull(String input, String attribute)
    throws IllegalArgumentException {
    if (input == null || "".equals(input.trim())) {
      throw new IllegalArgumentException(
        "Invalid " + attribute + ". It cannot be null or empty."
      );
    }
  }

  //	for pattern checking

  public static void validateRegex(
    String input,
    String attribute,
    String pattern
  ) throws IllegalArgumentException {
    Boolean isMatch = Pattern.matches(pattern, input);

    //		if isMatch holds false value throw new error
    if (Boolean.FALSE.equals(isMatch)) {
      throw new IllegalArgumentException(
        "Invalid " +
        attribute +
        ". Given input doesn't match the requested format."
      );
    }
  }

  //	main method which will validate the inputs

  public static boolean validateAll(Product product)
    throws IllegalArgumentException {
    //		   checking the object not equal to null

    ValidateObject(product, "Invalid product. Product cannot be null");

    //		validate the name obj

    validateNameObj(product.getName());

    //		validate the image obj

    validateImageObj(product.getImage());

    //		validate the desc

    validateDesc(product.getDesc());

    //		validate the nutritions obj

    validateNutrObj(product.getNutritions());

    //		validate the available stock

    validateAvailStockObj(product.getAvailablestock());

    //		validate the quantity

    validateQuantityObj(product.getQuantity());

    //		if there is no exception then return true
    return true;
  }

  //	product name validation starts

  //		validate the product name object not equal to null

  public static boolean validateNameObj(Name name)
    throws IllegalArgumentException {
    //		checking the object is not equal to null
    ValidateObject(name, "Invalid product name. Product name cannot be null.");

    //		validate the product english name

    validateEngName(name.getEng());

    //		validate the product tamil name

    validateTamName(name.getTam());

    //		if there is no exception then return true

    return true;
  }

  //	product english name validation

  public static boolean validateEngName(String name)
    throws IllegalArgumentException {
    //		attr to throw error message

    String attr = "Product English Name";

    //		pattern to check the input with regex match

    String pattern = "^[a-zA-Z ]{1,50}$";

    //		checking the string null or empty

    validateNull(name, attr);

    //		checking the name with regex pattern

    validateRegex(name, attr, pattern);

    //		if there is no exception then return ture

    return true;
  }

  //	product tamil name validation

  public static boolean validateTamName(String name)
    throws IllegalArgumentException {
    //		attr to throw error message

    String attr = "Product Tamil Name";

    //		pattern to check the input with regex match

    String pattern = "^[\\u0B80-\\u0BFF\\u0020]{1,50}$";

    //		checking the string null or empty

    validateNull(name, attr);

    //		checking the name with regex pattern

    validateRegex(name, attr, pattern);

    //		if there is no exception then return true

    return true;
  }

  //	product name validation ends

  //	product image validation starts

  //		validate the product image not equal to null

  public static boolean validateImageObj(Image image)
    throws IllegalArgumentException {
    //		checking the object not equal to null

    ValidateObject(
      image,
      "Invalid product image. Product image cannot be null."
    );

    //		validate the image url

    validateImageUrl(image.getImgUrl());

    //		validate the image alt

    validateImageAlt(image.getImgAlt());

    //		if there is no exception then return true

    return true;
  }

  //	validate the product image url

  public static boolean validateImageUrl(String url)
    throws IllegalArgumentException {
    //		attr to throw error message

    String attr = "Product Image URL";

    //		regex pattern to validate the url

    String pattern =
      "(?i)\\b((https?|ftp)://)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?\\.(jpg|jpeg|gif|png|bmp)\\b";

    //		checking the url is null or empty

    validateNull(url, attr);

    //		checking the url with regex pattern

    validateRegex(url, attr, pattern);

    //		if there is no exception then return true

    return true;
  }

  //	validate the product image alt

  public static boolean validateImageAlt(String alt)
    throws IllegalArgumentException {
    //		attr to throw error message

    String attr = "Product Image Alternative text";

    //		regex pattern to validate the image alt

    String pattern = "^[a-zA-Z0-9]+(?:_[a-zA-Z0-9]+)*$";

    //		checking the alt is null or empty

    validateNull(alt, attr);

    //		checking the alt with regex pattern

    validateRegex(alt, attr, pattern);

    //		if there is no exception then return true

    return true;
  }

  //	product image validation ends

  //	product description validation starts

  public static boolean validateDesc(String desc)
    throws IllegalArgumentException {
    //		attr to throw error message

    String attr = "Product Description";

    //		regex pattern to validate the description

    String pattern = "^[a-zA-Z0-9!@#$%^&*()\\-+=_.,\\s]{1,500}$";

    //		checking the description is null or empty

    validateNull(desc, attr);

    //		checking the desc with regex pattern

    validateRegex(desc, attr, pattern);

    //		if there is no exception then return true

    return true;
  }

  //	product description validation ends

  //	product nutritions validation starts

  //	basic validation no nutiritons cannot be less than zero

  public static void validateNutrNum(double num, String attr)
    throws IllegalArgumentException {
    if (num < 0) {
      throw new IllegalArgumentException(
        "Invalid " + attr + ". Nutritions value cannot be less than zero."
      );
    }
  }

  //	validate the product nutritions object

  public static boolean validateNutrObj(Nutritions nutr)
    throws IllegalArgumentException {
    //		checking the nutr is null

    ValidateObject(
      nutr,
      "Invalid product nutritions. Nutritions cannot be null."
    );

    //		validate the product protein nutritions

    validateProteinObj(nutr.getProtein());

    //		validate the product carbo hydrates nutritions

    validateCarboObj(nutr.getCarbo());

    //		validate the product kcal nutritions

    validateCaloriesNum(nutr.getKcal());

    //		if there no exception then return true

    return true;
  }

  //	validate the protein obj

  public static boolean validateProteinObj(Protein protein)
    throws IllegalArgumentException {
    //		checking the protein is object is null or not

    ValidateObject(
      protein,
      "Invalid protein nutritions. Protein nutritions cannot be null."
    );

    //		validate the protein num

    validateProteinNum(protein.getNum());

    //		if there is no exception then return true

    return true;
  }

  //	validate the carbo hydrates obj

  public static boolean validateCarboObj(Carbohydrates carbo)
    throws IllegalArgumentException {
    //		checking the carbohydrates is object is null or not
    ValidateObject(
      carbo,
      "Invalid carbohydrates nutritions. Protein nutritions cannot be null"
    );

    //		validate the carbo hydrates num

    validateCarbohydrateNum(carbo.getNum());

    //		if there is no exception then return true

    return true;
  }

  //	validate the protein num

  public static boolean validateProteinNum(double num) {
    //		attr to throw new error

    String attr = "Product protein nutrition";

    //		validate the num

    validateNutrNum(num, attr);

    //		if there is no exception then return true

    return true;
  }

  //	validate the carbo hydrates num

  public static boolean validateCarbohydrateNum(double num) {
    //		attr to throw new error

    String attr = "Product Carbohydrates nutritions";

    //		validate the num

    validateNutrNum(num, attr);

    //		if there is no exception then return true
    return true;
  }

  //	validate the calories num

  public static boolean validateCaloriesNum(double num) {
    //		attr to throw new error

    String attr = "Product calories";

    //		validate the num

    validateNutrNum(num, attr);

    //		if there is no exception then return true

    return true;
  }

  //	product nutritions validation ends

  //	product available stock validation starts

  public static boolean validateAvailStockObj(AvailableStock avail)
    throws IllegalArgumentException {
    //		if avail obj is null throw new error

    ValidateObject(
      avail,
      "Invalid available stock. Available stock cannote be null."
    );

    //		validate the avail stock unit

    validateAvailStockUnit(avail.getUnit());

    //		validate the avail stock num

    validateAvailStockNum(avail.getNum(), avail.getUnit());

    //		if there is no exception then return true

    return true;
  }

  //	validate the stock unit

  public static boolean validateAvailStockUnit(String unit)
    throws IllegalArgumentException {
    // declaring array of string with different available units
    String[] units = { "kg", "nos", "pkt" };

    //		attr to throw new error

    String attr = "Available stock unit";

    //		checking null or empty

    validateNull(unit, attr);

    //		checking the given input unit is valid

    for (String units_arr : units) {
      if (units_arr.equals(unit)) {
        // if there is match then return true
        return true;
      }
    }
    // if the given unit is not matched with unit throw an error

    throw new IllegalArgumentException(
      "Invalid available stock unit. Requested unit is not given."
    );
  }

  //	validate the given available stock
  //	minimum is 20 for all types of weight

  public static boolean validateAvailStockNum(float num, String unit)
    throws IllegalArgumentException {
    if (num <= 20) {
      throw new IllegalArgumentException(
        "Invalid available stock. Available stock must be greater than 20 " +
        unit +
        "."
      );
    }

    //		if there is no exception then return true

    return true;
  }

  //	product available stock validation ends

  //	product quantity validation starts

  public static boolean validateQuantityObj(Quantity qty)
    throws IllegalArgumentException {
    //		checking the obj is null

    ValidateObject(qty, "Invalid product qty. It cannot be null.");

    //		validate the qty rs

    validateRs(qty.getRs());

    //		validate the unit

    validateQtyUnit(qty.getUnit());

    //		validate the weight

    validateQtyWeight(qty.getWeight(), qty.getUnit());

    //		if there is no exception then return true

    return true;
  }

  //	validate the qty rs

  public static boolean validateRs(double num) throws IllegalArgumentException {
    if (num <= 0) {
      throw new IllegalArgumentException(
        "Invalid product price. Price cannot be lesser than zero."
      );
    }

    //		if there is no exception then return true
    return true;
  }

  public static boolean validateQtyUnit(String unit)
    throws IllegalArgumentException {
    // declaring of array of string with different units

    String[] units = { "kg", "nos", "pkt", "gm" };

    //		attr to throw error

    String attr = "Product price unit";

    //		validate null or emtpy

    validateNull(unit, attr);

    //		checking the given input unit is valid

    for (String unit_arr : units) {
      if (unit_arr.equals(unit)) {
        // if there is match then return true
        return true;
      }
    }

    //		if there is no match then throw an error
    throw new IllegalArgumentException(
      "Invalid product weight unit. Requested unit is not given."
    );
  }

  public static boolean validateQtyWeight(double num, String unit)
    throws IllegalArgumentException {
    //		if the weight is lesser than zero throw new error

    if (num <= 0) {
      throw new IllegalArgumentException(
        "Invalid weight. Weight cannot be lesser than zero."
      );
    }

    //		if unit equals to gm the weight must be higher than 250 gm

    if (unit.equals("gm")) {
      if (num < 250) {
        throw new IllegalArgumentException(
          "Invalid weight for unit grams. The weight must be greather than 250 grams."
        );
      }
    }

    //		if there is no exception then return true
    return true;
  }
  //	product quantity validation ends

}
