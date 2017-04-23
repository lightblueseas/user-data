# Overview

Parent project that holds module projects for the persistence of user data.

The project holds backend data for simple user management.


# ERD-Diagramm

The erd-diagramm for this database looks as follows: ![here](https://github.com/lightblueseas/user-data/blob/develop/user-init/src/main/resources/erd/erd-diagramm-users.png)

## License

The source code comes under the liberal MIT License, making user-data great for all types of applications with users or accounts.

# Build status
[![Build Status](https://travis-ci.org/lightblueseas/user-data.svg?branch=master)](https://travis-ci.org/lightblueseas/user-data)

## Maven Central

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/user-data/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/user-data)

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~user-data~~~) for latest snapshots and releases.

Add the following maven dependencies to your project `pom.xml` if you want to import the core functionality:

You can first define the version properties:

	<properties>
			...
		<!-- user-data version -->
		<user-data.version>3.11.0</user-data.version>
		<user-business.version>${user-data.version}</user-business.version>
		<user-domain.version>${user-data.version}</user-domain.version>
		<user-entities.version>${user-data.version}</user-entities.version>
		<user-init.version>${user-data.version}</user-init.version>
		<user-rest-api.version>${user-data.version}</user-rest-api.version>
		<user-rest-client.version>${user-data.version}</user-rest-client.version>
		<user-rest-web.version>${user-data.version}</user-rest-web.version>
			...
	</properties>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-business:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-business</artifactId>
				<version>${user-business.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-domain:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-domain</artifactId>
				<version>${user-domain.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-entities:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-entities</artifactId>
				<version>${user-entities.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-init:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-init</artifactId>
				<version>${user-init.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-rest-api:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-rest-api</artifactId>
				<version>${user-rest-api.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-rest-client:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-rest-client</artifactId>
				<version>${user-rest-client.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-rest-web:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-rest-web</artifactId>
				<version>${user-rest-web.version}</version>
			</dependency>
			...
		</dependencies>
		 
## Open Issues
[![Open Issues](https://img.shields.io/github/issues/astrapi69/user-data.svg?style=flat)](https://github.com/astrapi69/user-data/issues) 

## Want to Help and improve it? ###

The source code for user-data are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [lightblueseas/user-data/fork](https://github.com/lightblueseas/user-data/fork)

To share your changes, [submit a pull request](https://github.com/lightblueseas/user-data/pull/new/master).

Don't forget to add new units tests on your changes.

## Contacting the Developer

Do not hesitate to contact the user-data developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/lightblueseas/user-data/issues).

## Note

No animals were harmed in the making of this library.

# Donate

If you like this library, please consider a donation through 
<a href="https://flattr.com/submit/auto?fid=r7vp62&url=https%3A%2F%2Fgithub.com%2Flightblueseas%2Fuser-data" target="_blank">
<img src="http://button.flattr.com/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0">
</a>