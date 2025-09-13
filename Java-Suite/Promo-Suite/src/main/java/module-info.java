module com.sigwarthsoftware.promo {
    requires com.sigwarthsoftware.twitter;
    requires com.sigwarthsoftware.openai;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires static annotations;
    requires com.fasterxml.jackson.databind;
    requires static lombok;
    requires org.slf4j;
    
    exports com.sigwarthsoftware.promo;
    exports com.sigwarthsoftware.promo.github.commit;
    exports com.sigwarthsoftware.promo.github.issue;
    exports com.sigwarthsoftware.promo.github.release;
    exports com.sigwarthsoftware.promo.openai;
    exports com.sigwarthsoftware.promo.openai.prompt;
}