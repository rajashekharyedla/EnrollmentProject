FROM java:8
ADD target/EnrollmentJpaProject.jar EnrollmentJpaProject.jar
ENTRYPOINT ["java","-jar","EnrollmentJpaProject.jar"]
