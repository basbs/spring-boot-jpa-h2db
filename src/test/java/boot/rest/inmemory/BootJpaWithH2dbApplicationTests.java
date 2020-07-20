package boot.rest.inmemory;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import boot.rest.inmemory.controllers.ProductController;

@SpringBootTest
class BootJpaWithH2dbApplicationTests {

	@Autowired
	private ProductController controller;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
