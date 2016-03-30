# Proof of Concept: Soy Templates in JSF Renderers

This repo is a proof of concept for using [Google's Closure/Soy
templates](https://developers.google.com/closure/templates/) in JSF renderers.

I used the tutorial here to come up with this POC:

https://developers.google.com/closure/templates/docs/helloworld_java#hellonames

The renderer which specifically proves this concept is
[**`SoyTemplateRenderer.java`**](https://github.com/stiemannkj1/jsf-soy-renderer-proof-concept/blob/master/jsf-soy-component/src/main/java/com/liferay/faces/soy/poc/SoyTemplateRenderer.java).

The Soy template used is
[**`hello.soy`**](https://github.com/stiemannkj1/jsf-soy-renderer-proof-concept/blob/master/jsf-soy-component/src/main/resources/jsf/soy/poc/hello.soy).

## Building the Project

To build the project do:

    mvn clean install

## Running the Test Webapp

To run the test webapp, build the project and then copy the test war to **`$TOMCAT_HOME/webapps`**.

    cp jsf-soy-test-webapp/target/jsf-soy-test-webapp-1.0.0-SNAPSHOT.war $TOMCAT_HOME/webapps/

### Notes:

- Java classes with metadata about Soy templates can be generated (See the [*Using SoyParseInfoGenerator*
article](https://developers.google.com/closure/templates/docs/helloworld_java#soyparseinfogenerator)). 
- Still not sure if Soy templates can be compiled to a **`.class`** file. It seems like this feature is experimental and
not fully implemented:

    - https://groups.google.com/forum/#!topic/closure-templates-discuss/TOaEYd0-g-g

- Liferay uses Soy templates on the server side in the following classes:

    - https://github.com/brunobasto/liferay-portal/blob/master/modules/apps/foundation/portal-template/portal-template-soy/src/main/java/com/liferay/portal/template/soy/SoyTemplate.java
    - https://github.com/brunobasto/liferay-portal/blob/master/modules/apps/foundation/portal-portlet-bridge/portal-portlet-bridge-soy/src/main/java/com/liferay/portal/portlet/bridge/soy/SoyPortlet.java
	- https://github.com/jbalsas/liferay-portal/pull/488
    - https://github.com/jbalsas/liferay-portal/commit/65881832a3da31e24c4625b1d72b6ad080ace426
    - https://github.com/ligasm/soy-example

