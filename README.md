# Email Scheduling App
Quartz email scheduling example based on https://www.callicoder.com/spring-boot-quartz-scheduler-email-scheduling-example/

REST API to scheduler email Jobs in Quartz dynamically. All the Jobs will be persisted in the database and executed at the specified schedule.

**Schedule an Email**
----
  Returns json data about a single user.

* **URL**

  /scheduleEmail

* **Method:**

  `POST`
  
* **Data Params**

    - `email : String`
    - `subject : String`
    - `body : String`
    - `dateTime : LocalDateTime`
    - `timeZone : ZoneId`
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ success : true, message : "E-mail scheduled succesfully" }`
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{  success : false, message : "dateTime must be after current time" }`
    
* **Curl Example:**

    `curl --request POST \
       --url http://localhost:8080/scheduleEmail \
       --header 'content-type: application/json' \
       --data '{
     	"email": "rodrigo@gmail.com",
     	"subject": "Email Subject",
     	"body": "Body Test",
     	"dateTime": "2019-04-19T04:46:23",
     	"timeZone": "America/Sao_Paulo"
     }'`