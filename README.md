# Doctor API Application


## Built With
* `Java 17`
* `Maven 4.0.0`
* `MySql Ver 8.0.32`
* `Spring Boot 3.0.5`
* `IntelliJ IDEA 2023.1 (Community Edition)`

## Data Flow

### 1. Model:
* It consists of **Doctor** ,**Patient**, **Appointment**  and **AuthToken** entity classes along with their data members and member functions
* Used **_@Table_** and **_@Entity_** annotations inside the entity class.
* Used Lombok to reduce boilerplate code for pojo class.By using Lombok annotations like _**@Data,**_ **@_NoArgsConstructor_**, **_@AllArgsConstructor_** getters and setters for those object generate automatically.
* Used **_@OneToOne_**, **_@OneToMany_** and **_@ManyToOne_**  annotation to perform one to one mapping between entities.

### 2. Controller:
* It consists of  **DoctorController** ,**PatientController** and **AppointmentController** classes in which used the annotations like **@RestController** to annotate the class as Controller.
* Used annotation **_@GetMapping_** , **_@PostMapping_** , **_@PutMapping_** , **_@DeleteMapping_** to map the HTTP web requests to the specific handler methods.

<br>

### API Reference:

<br>

>Patient's API References:

<br>

*  Patient SigUp:
```*.sh-session
  http://localhost:8080/patient/signup
```

* Patient SignIn:
```*.sh-session
  http://localhost:8080/patient/signin
```

* Patient SignOut:
```*.sh-session
  http://localhost:8080/patient/sign-out
```

* Check Doctors
```*.sh-session
  http://localhost:8080/patient/doctors
```

* Book Appointments :
```*.sh-session
  http://localhost:8080/patient/appointments
```

* Cancel Appointments:
```*.sh-session
  http://localhost:8080/patient /appointments
```
<br>

>Doctor's API References

<br>

* Add Doctor:
```*.sh-session
  http://localhost:8080/doctor
```

* Check Appointments via Doctor's id:
```*.sh-session
  http://localhost:8080/doctor/{doctorId}/appointments/
```

<br>


### 3. Service:
* It consists of **DoctorService** ,**PatientService**, **AppointmentService** and  **AuthTokenService** classes in which provide some business functionalities of every handler methods.
* Used _**@Service**_ annotation to indicate that a class belongs to the service layer.
* Used **_@Transactional_** annotation to separate transaction management code from the code for business logic on the update and delete methods.

### 4. Repository:
* It consists of **DoctorDao** ,**PatientDao**, **AppointmentDao**, **FoodDao**, **OrderDao** and **AuthTokenDao** interfaces that extends CrudRepository which is interface for generic inbuilt CRUD operations on a repository for a specific type. Usually represent the database access layer in an application.
* Used **Iterable** to manage the data of entity classes by performing CRUD operations.
* Used _**@Repository**_ annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
* Used _**@Modifying**_ annotation wrote named parameters query using @Query annotation to insert, update, or delete an entity.

## Data Structure Used
Used `Iterable<T>` to store objects for entity classes.

## Project Summary
* In this project I performed CRUD operation like add,get,delete and update.<br/>
* The aim of this project to perform **_one to one_**, **_one-to-many_**, and **_many-to-one_** relationships mapping between entity classes.
* Used interface classJpaRepository  for generic CRUD inbuilt operations like save,saveAll,updateById, etc.
* Used our own custom finder methods and wrote operations using custom queries.
* Implemented authentication for patient doctor, and their handler methods so every time we use their mappings it is required to authenticate.
