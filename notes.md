# NOTES
### How to get method
``` java
System.out.println(request.getMethod());
```

### How to get headers/parameters
* [Print http content](https://stackoverflow.com/questions/18944302/how-do-i-print-the-content-of-httprequest-request/18944328)
``` java
Enumeration<String> headerNames = request.getHeaderNames();
while(headerNames.hasMoreElements()) {
    String headerName = headerNames.nextElement();
    System.out.println("Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
}


Enumeration<String> params = request.getParameterNames();
while(params.hasMoreElements()){
String paramName = params.nextElement();
System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));

```

### Check if parameter exists
* [Check if param exists](https://kodejava.org/how-do-i-check-if-parameter-is-exists-in-servlet-request/)