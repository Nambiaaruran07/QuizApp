
# Quiz App using Spring Boot

This project is a quiz application built with Spring Boot, featuring two roles: Admin and End User. The Admin can create and manage questions, while the End User can create quizzes from the questions provided by the Admin, take the quizzes, and view their scores. The backend is fully developed and tested using Postman. Technologies used include PostgreSQL for the database, Spring Data JPA and Hibernate for ORM (Object-Relational Mapping).


## API Endpoints

### Admin

#### Get all Questions

```
  GET /question/allQuestions
```

#### Get Questions based on Category

```
  GET /question/category/{language}
```

#### Get Specific question

```
  GET /question/{id}
```

#### Post Create questions

```
  POST /question/add
```

#### Put Update questions

```
  PUT /question/update/{id}
```

#### Delete questions

```
  DELETE /question/delete/{id}
```

### User

#### Create Quiz

```
  POST /quiz/create?category={Java/Python}&numQ={no_of_questions}&title={quiz_title}
```

#### Get Quizzies

```
  GET /quiz/get/{id}
```

#### Get Score

```
  POST /quiz/submit/{id}
```



