FROM openjdk:11
LABEL maintainer="Matthew.Crowell@Smoothstack.com"
RUN adduser --system --group transactionservice
USER transactionservice:transactionservice
ADD target/TransactionService-0.0.1-SNAPSHOT.jar transactionservice.jar
EXPOSE 7775
ENTRYPOINT ["java", "-jar", "transactionservice.jar", "--spring.profiles.active=dev"]