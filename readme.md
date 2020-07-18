# LIBRARY MANAGEMENT SYSTEM

library management system which simplifies book management.The app has two views: user and librarian.
Everyone can search the book ,but only librarian is allowed to add the book.

## FOR LICENCE  VISIT:
[licence](https://github.com/sparrowV/library_management_system/blob/master/LICENCE)

##FOR CONTRIBUTING GUIDES:
[guides](https://github.com/sparrowV/library_management_system/blob/master/CONTRIBUTING.md)


## how to run:
In order to run the app you need to have installed:

1)java 8 or later 

2)postgres database 9.5 or later

3)maven

cd into the frontend directory:
```javaScript
npm build
```
cd into root directory:
```javaScript
mvn clean install
```
jar file will be generate at target folder,you can run it via:
```javaScript
java -jar <name of the jar file>
```

last step is to initialize database and run the scripts,
which are located at : src/main/resources/patches

##  used technologies:
* spring boot
* reactjs
* postgres
* docker





