@import com.bootiful.frontend.web.WebController.SpringResources
@param SpringResources springResources


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