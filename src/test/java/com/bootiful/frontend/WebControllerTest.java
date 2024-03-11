package com.bootiful.frontend;

import com.bootiful.frontend.web.WebController;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WebControllerTest {
  @Autowired
  WebController webController;

  @Test
  void start() {
    System.out.println(webController.springResources);
  }
}
