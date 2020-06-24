package kerkro.bc.business;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloWorldBL {
        public String getMessage() {
            return "<h1>Hello from CDI</h1>";
        }
}
