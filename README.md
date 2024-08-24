# Makersharks Search API

This project is a Spring Boot REST API that allows buyers to search for manufacturers based on customized requirements such as location, nature of business, and manufacturing processes.
## Prerequisites
- Java 17
- spring 3.3.3
- mySql 8.0.28
- Maven 3.6+
## How to Run the Application
# Build the Application
mvn clean install
## Example cURL Commands
curl -X POST http://localhost:8080/api/supplier/query \
-H "Content-Type: application/json" \
-d '{
      "location": "Los Angeles",
      "natureOfBusiness": "MEDIUM_SCALE",
      "manufacturingProcesses": ["COATING"],
      "page": 0,
      "size": 10
    }'

    
# Example responce we get
{
    "content": [
        {
            "supplierId": 21,
            "companyName": "Supplier 21",
            "website": "https://supplier21.com",
            "location": "Los Angeles",
            "natureOfBusiness": "MEDIUM_SCALE",
            "manufacturingProcesses": [
                "MOULDING",
                "CASTING",
                "COATING",
                "3D_PRINTING"
            ]
        },
        {
            "supplierId": 22,
            "companyName": "Supplier 22",
            "website": "https://supplier22.com",
            "location": "Los Angeles",
            "natureOfBusiness": "MEDIUM_SCALE",
            "manufacturingProcesses": [
                "MOULDING",
                "CASTING",
                "COATING",
                "3D_PRINTING"
            ]
        },
        {
            "supplierId": 23,
            "companyName": "Supplier 23",
            "website": "https://supplier23.com",
            "location": "Los Angeles",
            "natureOfBusiness": "MEDIUM_SCALE",
            "manufacturingProcesses": [
                "MOULDING",
                "CASTING",
                "COATING",
                "3D_PRINTING"
            ]
        },
        {
            "supplierId": 24,
            "companyName": "Supplier 24",
            "website": "https://supplier24.com",
            "location": "Los Angeles",
            "natureOfBusiness": "MEDIUM_SCALE",
            "manufacturingProcesses": [
                "MOULDING",
                "CASTING",
                "COATING",
                "3D_PRINTING"
            ]
        },
        {
            "supplierId": 25,
            "companyName": "Supplier 25",
            "website": "https://supplier25.com",
            "location": "Los Angeles",
            "natureOfBusiness": "MEDIUM_SCALE",
            "manufacturingProcesses": [
                "MOULDING",
                "CASTING",
                "COATING",
                "3D_PRINTING"
            ]
        },
        {
            "supplierId": 26,
            "companyName": "Supplier 26",
            "website": "https://supplier26.com",
            "location": "Los Angeles",
            "natureOfBusiness": "MEDIUM_SCALE",
            "manufacturingProcesses": [
                "MOULDING",
                "CASTING",
                "COATING",
                "3D_PRINTING"
            ]
        },
        {
            "supplierId": 27,
            "companyName": "Supplier 27",
            "website": "https://supplier27.com",
            "location": "Los Angeles",
            "natureOfBusiness": "MEDIUM_SCALE",
            "manufacturingProcesses": [
                "MOULDING",
                "CASTING",
                "COATING",
                "3D_PRINTING"
            ]
        },
        {
            "supplierId": 28,
            "companyName": "Supplier 28",
            "website": "https://supplier28.com",
            "location": "Los Angeles",
            "natureOfBusiness": "MEDIUM_SCALE",
            "manufacturingProcesses": [
                "MOULDING",
                "CASTING",
                "COATING",
                "3D_PRINTING"
            ]
        },
        {
            "supplierId": 29,
            "companyName": "Supplier 29",
            "website": "https://supplier29.com",
            "location": "Los Angeles",
            "natureOfBusiness": "MEDIUM_SCALE",
            "manufacturingProcesses": [
                "MOULDING",
                "CASTING",
                "COATING",
                "3D_PRINTING"
            ]
        },
        {
            "supplierId": 30,
            "companyName": "Supplier 30",
            "website": "https://supplier30.com",
            "location": "Los Angeles",
            "natureOfBusiness": "MEDIUM_SCALE",
            "manufacturingProcesses": [
                "MOULDING",
                "CASTING",
                "COATING",
                "3D_PRINTING"
            ]
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalElements": 20,
    "totalPages": 2,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 10,
    "empty": false
}
