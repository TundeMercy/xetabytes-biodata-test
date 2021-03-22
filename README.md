###XETABYTES Biodata RESTful Application

Edit the database configuration file at `resources/application.yml` file to suit your database credentials before running

Defined endpoints:
    *baseurl/api/v1/persons*
    POST: */api/v1/persons* Post new person to the DB
    GET: */api/v1/persons* Get All person in the DB
    GET: */api/v1/persons/{id}* Get person by id
    PUT: */api/v1/persons/{id}* Edit person by an id
    DELETE: */api/v1/persons/{id}* DELETE person by id

Example request body schema for POST and PUT
{
    "name": "Ajagbe Tunde",
    "gender": "Male",
    "email": "example@example.com",
    "phoneNumber": "+2348106887783",
    "about": "Software Developer"
}