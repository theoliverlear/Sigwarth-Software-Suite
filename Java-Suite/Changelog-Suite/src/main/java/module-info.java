module com.sigwarthsoftware.changelog {
    requires com.sigwarthsoftware.openai;
    requires com.sigwarthsoftware.promo;
    requires static lombok;
    requires org.apache.commons.io;
    requires org.apache.httpcomponents.httpclient;
    requires org.jdom2;
    requires org.slf4j;
    requires org.apache.httpcomponents.httpcore;

    exports com.sigwarthsoftware.changelog;
    exports com.sigwarthsoftware.changelog.prompt;
    exports com.sigwarthsoftware.changelog.version;
    exports com.sigwarthsoftware.changelog.version.models.config;
    exports com.sigwarthsoftware.changelog.version.models.dependency;
    exports com.sigwarthsoftware.changelog.version.models.dependency.type;
    exports com.sigwarthsoftware.changelog.version.models.element;
    exports com.sigwarthsoftware.changelog.version.models.module;
    exports com.sigwarthsoftware.changelog.version.models.module.type;
}