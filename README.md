# covid-center'




## Api

### user   url->api/user

#### readAll[get]
#### readSingle[get] url->api/user/ID
#### create[post]

{
* "cprNumber": "1212902020,
* "name": "username",
* "surname": "surname",
* "Age": 12,
* "email": "email@email.com",
* "password": "1234",

##### Error response in body
[{"field":"Name","message":"Field can not be empty"},{"field":"Password","message":"Minimum 6 characters"},{"field":"Surname","message":"Field can not be empty"},{"field":"Email","message":"Incorrect email"},{"field":"CPR number","message":"Incorrect CPR"}]
}
#### update[PUT]   url->api/user/ID

{
* "cprNumber": "1212902020,
* "name": "username",
* "surname": "surname",
* "Age": 12,
* "email": "email@email.com",
* "password": "1234",

}

### user login[POST]

url->api/user/login 

##### request data
{
* "password":"123456",
* "email": "koko@yahoo.com"
}
##### response save as cookie  
  {
  * "idUser":44,
  * "cprNumber":"1212904667",
  * "name":"Carol",
  * "surname":"testurnem",
  * "userType":{"Type":"user","idUserType":3},
  * "email":"koko@yahoo.com",
  * "password":"",
  * "token":"ab604a18-b3f6-4562-ab7b-5f580bc6ab55"
    }

### user logout[POST]

url->api/user/logout

##### Request Data 

{
* "idUser":45
}

##### response 
 OK


## Api

### Booking   url->api/booking

#### readAll[get]
#### readSingle[get] url->api/booking/ID
#### create booking[post]

######headers 
* token bull
* userID 1

######body
{
* "time": "time",
* "endTime": "endtime",
* "bookingStatus_idbookingStatus": 1,
* "bookingType_idbookingType": 1
}
  
####delete booking[delete]

######headers
* token gigi
* userID 1

######body

* {   
* "idbookings": 5
* }

####readSingle[get] url->api/booking/ID


######headers
* token gigi
* userID 1

