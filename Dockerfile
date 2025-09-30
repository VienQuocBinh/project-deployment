# ---- Stage 1: Build ----
FROM gradle:8.10.2-jdk21 AS builder
WORKDIR /app
COPY --chown=gradle:gradle . .
RUN gradle clean bootJar --no-daemon

# ---- Stage 2: Run ----
FROM amazoncorretto:21.0.6-alpine AS runtime
WORKDIR /app

# Copy built jar from builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose app port
EXPOSE 8080

# Run Spring Boot app
ENTRYPOINT ["java","-jar","/app/app.jar"]
