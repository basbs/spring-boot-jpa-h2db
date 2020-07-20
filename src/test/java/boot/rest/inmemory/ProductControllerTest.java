package boot.rest.inmemory;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import boot.rest.inmemory.controllers.ProductController;
import boot.rest.inmemory.services.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMVC;

     @MockBean
     private ProductService productService;

    @Test
    public void givenProducts_whenGetProducts_thenReturnProductArray() throws Exception {
        this.mockMVC.perform(get("/api/v1/products")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("[]")));
    }
    
}