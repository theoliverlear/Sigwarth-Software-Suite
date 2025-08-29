module com.sigwarthsoftware.twitter {
    requires annotations;
    requires com.fasterxml.jackson.databind;
    requires static lombok;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires scribejava.apis;
    requires scribejava.core;
    requires com.sigwarthsoftware.openai;

    exports com.sigwarthsoftware.twitter;
    exports com.sigwarthsoftware.twitter.models;
    exports com.sigwarthsoftware.twitter.publish;
}