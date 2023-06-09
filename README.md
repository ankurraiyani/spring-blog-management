# Sample Project - Spring Blog Management
Demo project for the Blog Management

It has H2 database.

There are following APIs available

  (1) `/api/blog/save` - To create or edit the API.

  (2) `/api/get/<id>` - To get a blog details.
  
  (3) `/api/delete/<id>` - To delete a blog. Please note that it would be soft delete.

  (4) `/api/get/all-active/<pageNo>/<pageSize>` - To get all the active blog list with pagination

  (5) `/api/get/all` - To get all the blogs stored into the system
  
Postman Collection `Blog Management.postman_collection.json` is also committed and available at root location

## Build With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Ankur Raiyani**
