module com.sigwarthsoftware.openai {
    requires java.net.http;
    requires static lombok;
    requires openai.java.client.okhttp;
    requires openai.java.core;
    
    exports com.sigwarthsoftware.openai;
}