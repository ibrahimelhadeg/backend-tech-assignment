# VEHICLE ADVERTISING

a REST service for managing listings for online advertising service.

## Terminology

 - **Listing** - a vehicle ad, usually consists of information about a vehicle and some other information, like who is selling a car, price, posting date, etc. Listing can be in one of two possible states:
   - published - available online or
   - draft - not available online.
 - **Car Dealer** - a business that sells new or used cars.
 - **Tier Limit** - a number of published listings a dealer can have online.

## Requirements

Service should implement following functionality:

 - Create a listing. All the created listings should have state `draft` by default;
 - Update a listing;
 - Get all listings of a dealer with a given state;
 - Publish a listing;
 - Unpublish a listing.

Please note that the number of published listings for a dealer should be less or equal to the dealer's tier limit. When publishing a listing, client should be able to choose how to deal with situation when tier limit is reached - either
  - return an error to the client, or
  - publish a listing, but unpublish the oldest listing of a dealer to conform to the tier limit.

Come up with an additional functionality of your choice that could give value to the service.

# INSTRUCTIONS

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Building or running this project requires that [Java 16 or newer](https://jdk.java.net/java-se-ri/16) be available on your machine.

## Development

### Setup

After installing Java, you should be able to run the following command to install project dependencies.

    ./mvnw dependency:resolve

You will only need run this command when dependencies change in [pom.xml](pom.xml).

To compile the sources, use :

    ./mvnw clean install

Run the following command in a terminal to start the application on the development mode.

    ./mvnw spring-boot:run -Dspring-boot.run.profiles=local -pl api

## Testing

To compile then run the tests, use :

    ./mvnw clean test

## Building for production

To prepare the splitter application for production, run:

    ./mvnw clean package

This will produce a JAR file on the `target` directory. To ensure everything worked, run:

    java -jar target/*.jar

Then you can use the program from your terminal.


## Deployment

TODO

## Troubleshooting

If you get the message `permission denied: ./mvnw`, when trying to run the commands,
execute the following command (to ask your system to attribute the permission to the file [mvnw](mvnw)):

    chmod +x mvnw

In case of error when running the provided commands, try to add the arguments `-e` or `-X` to get detailed error messages

If your Java version is older than 16, and you've encountered problems running any of the commands, try to run it by appending at beginning `export JAVA_HOME="/path/to/java/16/jdk" && `

    export JAVA_HOME="/path/to/java/16/jdk" && ./mvnw clean test

## Built with

* [Java](https://jdk.java.net/) - The programming language
* [JUnit](https://junit.org/) and [Mockito](https://site.mockito.org/) - Used to create tests
* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Framework
* [Maven](https://maven.apache.org/) and [Maven Wrapper](https://github.com/takari/maven-wrapper) - Dependency Management
* [Git](https://git-scm.com/) - as version-control system

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/#build-image)

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Author

* **Ibrahim El Hadeg**

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
