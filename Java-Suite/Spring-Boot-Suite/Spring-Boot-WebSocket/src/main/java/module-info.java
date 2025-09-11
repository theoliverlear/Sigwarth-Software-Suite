open module com.sigwarthsoftware.springboot.websocket {
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires spring.beans;
    requires spring.context;
    requires spring.websocket;
    requires org.slf4j;
    
    exports com.sigwarthsoftware.springboot.websocket;
}