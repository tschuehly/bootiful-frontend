package gg.jte.generated.ondemand;
import static java.util.stream.Collectors.groupingBy;
import com.bootiful.frontend.web.WebController.Link;
import com.bootiful.frontend.web.WebController.SpringResources;
public final class JtespringGenerated {
	public static final String JTE_NAME = "spring.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,13,13,13,15,15,15,18,18,20,20,20,20,20,20,20,20,20,20,20,20,22,22,24,24,24,24,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, SpringResources springResources) {
		jteOutput.writeContent("\r\n<head>\r\n    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/sakura.css/css/sakura.css\" type=\"text/css\">\r\n</head>\r\n\r\n<h1>\r\n    Resources for Learning Spring\r\n</h1>\r\n\r\n");
		for (var resource: springResources.topics().entrySet()) {
			jteOutput.writeContent("\r\n    <h2>\r\n        ");
			jteOutput.setContext("h2", null);
			jteOutput.writeUserContent(resource.getKey());
			jteOutput.writeContent("\r\n    </h2>\r\n    <ul>\r\n        ");
			for (var link: resource.getValue()) {
				jteOutput.writeContent("\r\n            <li>\r\n                <a");
				var __jte_html_attribute_0 = link.hrefValue();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(link.displayValue());
				jteOutput.writeContent("</a>\r\n            </li>\r\n        ");
			}
			jteOutput.writeContent("\r\n    </ul>\r\n");
		}
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		SpringResources springResources = (SpringResources)params.get("springResources");
		render(jteOutput, jteHtmlInterceptor, springResources);
	}
}
