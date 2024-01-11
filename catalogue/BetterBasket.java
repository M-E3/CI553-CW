package catalogue;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/**
 * BetterBasket extends the class of basket, to allow products ordered to be merged when bought in multiple
 * quantities as well as sorting them by order number. This class is then implemented in betterCashier to 
 * ensure betterBasket is returned instead of the original basket.
 * 
 * @Max Emery
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Override
  public boolean add(Product p1) {                                 
	  
	  for(Product p2:this){                                           //Merging logic, if item is found in basket increment accordingly      
		  if(p1.getProductNum().equals(p2.getProductNum())) {         
			  
		    
			p2.setQuantity(p2.getQuantity()+ p1.getQuantity());
		  
		  return (true);
	  }
		  
	  
	  
  }
  
  super.add(p1);                                                //If item is not in basket use superclass add method
  
  
  Collections.sort(this, new ProductComparator());
  return (true);
}
  
private static class ProductComparator implements Comparator<Product> {        //Comparing product numbers to order numerically
  @Override
public int compare(Product p1, Product p2) {
	
	return p1.getProductNum().compareTo(p2.getProductNum());
}
}

  
}
