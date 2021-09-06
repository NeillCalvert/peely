<h1>Project Peely</h1>

<p>This is a simple CRUD application using Java with Spring Boot. The project utilises Spring aspect logging for generic logs using a single annotation and the DTO model. Simply clone the project, setup a local MySQL DB and use the environment variables below that are applicable to your machine.</p>

<p>A neat feature of this project is the aspect logging annotation @GenericLogger which cuts through the method and logs method parameters and execution time if requested. I started using this during a project that used Kibana and I needed a quick way of standardising log messages</p>

<h2>Environment Variables</h2>
<ul>
	<li>SCHEMA_DDL - update, create etc</li>
	<li>PORT - DB port number</li>
	<li>DB_NAME - DB name</li>
	<li>DB_USER - DB username</li>
	<li>DB_PASSWORD - DB password</li>
</ul>