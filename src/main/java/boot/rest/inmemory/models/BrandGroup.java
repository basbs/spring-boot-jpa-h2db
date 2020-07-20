package boot.rest.inmemory.models;

import lombok.Getter;

@Getter
public class BrandGroup extends Group {
   private String brandName;
   public BrandGroup(Long count, String brandName) {
      super(count);
      this.brandName = brandName;
   }
}