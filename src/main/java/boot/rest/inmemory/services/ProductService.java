package boot.rest.inmemory.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.rest.inmemory.models.BrandGroup;
import boot.rest.inmemory.models.ColorGroup;
import boot.rest.inmemory.models.Product;
import boot.rest.inmemory.models.SizeGroup;
import boot.rest.inmemory.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired 
    ProductRepository repo;

    public List<Product> getAllProducts() {
        final List<Product> products = new ArrayList<>();
        repo.findAll().forEach(product -> products.add(product));
        return products;
    }

    public List<BrandGroup> groupByBrand() {
        final List<BrandGroup> brandGroups = new ArrayList<>();
        repo.groupByBrand().forEach(brandGroup -> brandGroups.add(brandGroup));
        return brandGroups;
    }

    public List<ColorGroup> groupByColor() {
        final List<ColorGroup> colorGroups = new ArrayList<>();
        repo.groupByColor().forEach(colorGroup -> colorGroups.add(colorGroup));
        return colorGroups;
    }

    public List<SizeGroup> groupBySize() {
        final List<SizeGroup> sizeGroups = new ArrayList<>();
        repo.groupBySize().forEach(sizeGroup -> sizeGroups.add(sizeGroup));
        return sizeGroups;
    }
    
    public Product getBySku(Long sku) {
       return repo.findBySku(sku); 
    }

    public void saveOrUpdate(Product product) {
       repo.save(product);
    }

    public void delete(Long sku) {
        repo.deleteBySku(sku);
    }


}