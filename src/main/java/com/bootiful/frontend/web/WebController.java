package com.bootiful.frontend.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClient;

@Controller
public class WebController {

  public SpringResources springResources = new SpringResources(new HashMap<>());

  @GetMapping("/")
  public String index(Model model) {
    //model.addAttribute("springResources", this.springResources);
    model.addAttribute("springResources", new SpringResources(new HashMap<>(
        Map.of("Spring",List.of(
            new Link("Spring","https://spring.io"),
            new Link("Spring Academy","https://spring.academy")

        ))
    )));
    return "spring";
  }

  public record SpringResources(HashMap<String, List<Link>> topics) {

  }

  public record Link(String displayValue, String hrefValue) {

  }

  @Scheduled(fixedDelay = 30, timeUnit = TimeUnit.MINUTES)
  public void refresh() {
    System.out.println("Refreshing...");
    String readme = RestClient.create()
        .get()
        .uri("https://raw.githubusercontent.com/spring-office-hours/resources-learning-spring/main/README.md")
        .retrieve()
        .body(String.class);

    Matcher matcher = Pattern.compile("## (.*?)\n").matcher(readme);
    while (matcher.find()) {
      var topic = matcher.group(1);
      var end = matcher.end();
      matcher.find();
      var linksString = readme.substring(end, matcher.start());
      Matcher matcher2 = Pattern.compile("\\[(.*?)]\\((.*?)\\)").matcher(linksString);
      ArrayList<Link> links = new ArrayList<>();
      while (matcher2.find()) {
        links.add(new Link(matcher2.group(1), matcher2.group(2)));
      }
      springResources.topics.put(topic, links);
    }
  }

}
