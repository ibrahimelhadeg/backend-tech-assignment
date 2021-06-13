module me.ibra.advertiser.vehicle {

    requires java.base;
    requires lombok;
    requires org.apache.commons.lang3;

    requires spring.boot;
    requires spring.boot.autoconfigure;

    requires spring.beans;
    requires spring.context;
    requires spring.web;

    exports me.ibra.advertiser.vehicle.domain;
}