package boot.rest.inmemory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import boot.rest.inmemory.models.BrandGroup;
import boot.rest.inmemory.models.ColorGroup;
import boot.rest.inmemory.models.Product;
import boot.rest.inmemory.models.SizeGroup;

public interface ProductRepository extends CrudRepository<Product, Long> {
   @Query("select new boot.rest.inmemory.models.BrandGroup(count(p.sku) as brandCount, " + "p.brand as brandName) " 
         + "from Product p " + "group by brand")
   public List<BrandGroup> groupByBrand();

   @Query("select new boot.rest.inmemory.models.ColorGroup(count(p.sku) as colorCount, " + "p.color as color) " 
         + "from Product p " + "group by color")
   public List<ColorGroup> groupByColor();

   @Query("select new boot.rest.inmemory.models.SizeGroup(count(p.sku) as sizeCount, " + "p.size as size) "
         + "from Product p " + "group by size")
   public List<SizeGroup> groupBySize();

   public List<Product> findBySellar(String sellarName);

   public Product findBySku(Long sku);

   public void deleteBySku(Long sku);
}