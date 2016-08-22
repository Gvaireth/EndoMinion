package org.gvaireth;

import org.gvaireth.endominion.core.EndoMinionApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EndoMinionApplication.class)
@WebAppConfiguration
public class EndostatApplicationTests {

	@Test
	public void contextLoads() {
	}

}
