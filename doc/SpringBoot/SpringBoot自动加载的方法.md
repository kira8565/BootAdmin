修改`application.properties`文件下的配置

    spring.freemarker.cache=false

修改POM文件

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>springloaded</artifactId>
        <version>1.2.3.RELEASE</version>
    </dependency>

    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
      <version>${spring-boot.version}</version>
      <executions>
        <execution>
          <goals>
            <goal>repackage</goal>
          </goals>
        </execution>
      </executions>
      <dependencies>
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>springloaded</artifactId>
          <version>1.2.3.RELEASE</version>
        </dependency>
      </dependencies>
    </plugin>

下载`springloaded-1.2.3.RELEASE.jar`，启动的时候加入VM参数

    -javaagent:.\lib\springloaded-1.2.3.RELEASE.jar -noverify
    
修改完后按一下ctrl+f9就可以了

