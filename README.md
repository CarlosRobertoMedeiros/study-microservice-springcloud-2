# Study-Microservice-SpringCloud-2

# Environment
  - Execute the Stack Using 
    - docker-compose -f local-stack.yml -up

  KeyCloak
	- In case of problems with the login
	
	::::::SEE WITH ATTENTION:::::::
	Open other terminal and make the follow codes:
		1 - create the user and the password admin 
		docker exec -it keycloak_microservices /opt/jboss/keycloak/bin/add-user-keycloak.sh -u admin -p admin
		
		2 - make a reload in the jboss-cli
		docker exec -it keycloak_microservices /opt/jboss/keycloak/bin/jboss-cli.sh --connect --command=:reload
	
	- Import the "realm-export.json" inside the KeyCloak

# MicroServices

	Created Config-Server
		- hr-config-server with github

	Created Naming Server
		- hr-naming-server-eureka

	Created Gateway
	  - hr-api-gateway  
  
	Applying a CircuitBreaker
		- hr-payroll with Resilience4j

	Microservices
	- hr-worker
	- hr-payroll
	- hr-user

