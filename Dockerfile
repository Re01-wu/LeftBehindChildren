# 使用官方Java 17基础镜像
FROM eclipse-temurin:17-jdk-jammy

# 设置工作目录
WORKDIR /app

# 复制Maven构建文件
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# 复制源代码
COPY src src

# 构建应用
RUN ./mvnw clean package -DskipTests

# 暴露端口
EXPOSE 8080

# 运行应用
ENTRYPOINT ["java", "-jar", "target/LeftBehindChildren-0.0.1-SNAPSHOT.jar"]