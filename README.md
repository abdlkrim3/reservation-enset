# Reservation and Resource Management with Microservices

This project aims to develop an application based on a microservices architecture to manage resource reservations. Each reservation is tied to a single resource, and each resource is defined by an ID, a name, and a type (MATERIEL_INFO, MATERIEL_AUDIO_VISUEL). Reservations, made by individuals, are defined by an ID, a name, a context, a date, and a duration.

## Technical Architecture of the Project

<img src="images/11.png" alt="Logo de l'achtecture"><br>
<img src="images/10.png" ><br>


The project consists of the following microservices:

1. **Resources-Service (Resource Management Microservice)**
   - Responsible for managing resources, including CRUD (Create, Read, Update, Delete) operations.
   - Uses Spring Boot with a DAO (Data Access Object) architecture, Service, DTO (Data Transfer Object), and a REST controller.

2. **Reservation-Service (Reservation Management Microservice)**
   - Manages reservations, including create, read, update, and delete operations.
   - Integrates with the Resources-Service microservice to retrieve information about resources.
   - Uses Feign Client for communication between microservices.

3. **Gateway-Service (Gateway Service)**
   - Based on Spring Cloud Gateway to route requests to the corresponding microservices.
   - Integrates with Eureka Server or Consul Discovery for service discovery.

4. **Discovery-Service (Discovery Microservice)**
   - Uses Eureka Server or Consul Discovery for microservices discovery in the architecture.

5. **Config-Service (Configuration Microservice)**
   - Uses Spring Cloud Config or Consul Config for centralized configuration management.

6. **Angular-Front-App (Angular-based Frontend Application)**
   - Develops a user-friendly interface for viewing, creating, updating, and deleting reservations.
   - Secures the application with authentication based on Keycloak.

## Development and Testing of Microservices

- Microservices development includes configuring entities, DAO, services, DTO, REST controllers, Feign clients, and necessary configurations.

- Application security is implemented using Oauth2 and OIDC, with Keycloak as the identity provider.

- Unit and integration tests are conducted to ensure the reliability of microservices.

## Documentation Generation and Error Handling

- Utilizes OpenAPIDoc (Swagger) specification to generate RESTful services documentation.

- Implements circuit breakers based on Resilience4J to ensure fault tolerance and resilience of microservices.

## Deployment with Docker and Docker Compose

- Utilizes Docker and Docker Compose for easy deployment and management of containers.

# Installation and Execution Instructions

1. Clone the Git repository.

    ```bash
    git clone https://github.com/abdlkrim3/reservation-enset.git
    ```

2. Navigate to the project directory.

    ```bash
    cd reservation-enset
    ```

3. Configuring and deploying microservices and frontend application.

4. Run the services with Docker Compose.

    ```bash
    docker-compose up
    ```

5. Access the application via the browser at [http://localhost:8083].

    **Note:** Before accessing the application, ensure that Keycloak is properly configured. Follow the steps below:

    a. Configure Keycloak:
        - Install and run Keycloak.
        - Set up a new realm and configure the necessary settings.

    b. Create a Client:
        - Within your Keycloak realm, create a new client for your application.
        - Configure the client settings, such as the redirect URI.

    c. Add Users:
        - Create users in Keycloak and assign them to the appropriate roles.
        - Ensure that the roles align with the permissions required by your application.


6. Customize the application as needed and explore additional configuration options.

## Application Testing

1. Regestration interface:
<img src="images/2.png" ><br>

2. Access the login interface:
   - Open your web browser.
   - Visit [http://localhost:port/login](http://localhost:port/login).

<img src="images/1.png" ><br>

   - Log in with user using  Keycloak credentials.

3. Access the user interface:
<img src="images/3.png" ><br>

4. Resource Management:
<img src="images/4.png" ><br>

5. Access the Admin login interface:
   - Open your web browser.
   - Visit [http://localhost:port/login](http://localhost:port/login).

<img src="images/5.png" ><br>

   - Log in with Admin using  Keycloak credentials.

6. Access the Admin interface:
<img src="images/6.png" ><br>

7. Resource Management:
<img src="images/7.png" ><br>

8. Reservation Management:
<img src="images/8.png" ><br>

9. Users Management:
<img src="images/9.png" ><br>

