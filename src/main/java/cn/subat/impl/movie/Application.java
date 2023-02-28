package cn.subat.impl.movie;

import cn.subat.impl.spdoc.annotation.SPDocDefine;
import cn.subat.impl.spdoc.annotation.SPDocSecurity;
import io.micronaut.runtime.Micronaut;


@SPDocDefine(
        title = "Movie",
        key = "movie",
        version = "1.0.0",
        url = "https://backend.uchur.net/api/",
        securitySchema = @SPDocSecurity(scheme = "ApiKey", type = "apiKey")
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}