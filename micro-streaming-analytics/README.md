# SPRING BOOT MICROSERVICES USING RABBITMQ AND MONGODB

### MAVEN PROJECT
<ol>
<li>
First, we need to create the maven project following the documentation: 
<a href="https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html">maven</a>
</li>
<li>
<p>Then, we need to create our parent POM</p>
</li>
<li>
<p>Last but not least, we should create a .gitignore file if we plan to upload the project to an online repo.</p>
</li>
</ol>

### PRODUCER MICROSERVICE
<p>This microservice will receive a POST http request and send the message as a JSON to an exchange</p>
<p>Rabbitmq provides us 3 main features: exchange, queues and bindings</p>
<p>All messages go to the exchange, and we will use a binding key to link the messages to the corresponding queue</p>
<ol>
<li>
<p>With this in mind, first, we need to create a new module for this project, called producer.</p>
</li>
<li>
<p>Then, we need to create our main class with @SpringBootApplication</p>
</li>
<li>
<p>After that, we need to create our application.properties or yml under resources package.</p>
</li>
<li>
<p>After that, we'll create our application.properties or yml under resources package, and specify the port, queue, exchange and binding.</p>
</li>
<li>
<p>Once we are finished, we are going to define what do we want to send as a JSON, in my case it won't be just 1 java class, but 4 nested classes.</p>
</li>
<li>
<p>Then, we'll define our config file, where we will declare our @Bean methods.</p>
</li>
<li>
<p>Finally, we'll create our controller class.</p>
</li>
</ol>

### CONSUMER MICROSERVICE
<p>This microservice will receive the message from the message queue, and will use it to calculate some stuff.</p>
<ol>
<li>
<p>First, we will define our model class with some attributes: average, median, minimum... and annotate it with @Document</p>
</li>
<li>
<p>Then, we'll define our mongo repository.</p>
</li>
</ol>