@import com.bootiful.frontend.web.WebController.SpringResources
@param SpringResources springResources

<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sakura.css/css/sakura.css" type="text/css">
</head>

<h1>
    Resources for Learning Spring
</h1>

@for(var resource: springResources.topics().entrySet())
    <h2>
        ${resource.getKey()}
    </h2>
    <ul>
        @for(var link: resource.getValue())
            <li>
                <a href="${link.hrefValue()}">${link.displayValue()}</a>
            </li>
        @endfor
    </ul>
@endfor