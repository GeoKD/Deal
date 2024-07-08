МС Сделка

API:
POST: /deal/application - расчёт возможных условий кредита. Request - LoanApplicationRequestDTO, response - List<LoanOfferDTO>
PUT: /deal/offer - Выбор одного из предложений. Request LoanOfferDTO, response void.
PUT: /deal/calculate/{applicationId} - завершение регистрации + полный подсчёт кредита. Request - FinishRegistrationRequestDTO, param - Long, response void.

Примеры запросов:

1. POST: http://localhost:8081/deal/application
{
  "amount": 100000,
  "term": 12,
  "firstName": "Иван",
  "lastName": "Иванов",
  "middleName": "Иванович",
  "email": "ivanov@example.com",
  "birthdate": "1990-01-01",
  "passportSeries": "1234",
  "passportNumber": "567890"
}

Вывод:
[
    {
        "applicationId": 1,
        "requestedAmount": 100000,
        "totalAmount": 100000,
        "term": 12,
        "monthlyPayment": 9166.6667,
        "rate": 0.10,
        "insuranceEnabled": false,
        "salaryClient": false
    },
    {
        "applicationId": 1,
        "requestedAmount": 100000,
        "totalAmount": 100000,
        "term": 12,
        "monthlyPayment": 9083.3333,
        "rate": 0.09,
        "insuranceEnabled": false,
        "salaryClient": true
    },
    {
        "applicationId": 1,
        "requestedAmount": 100000,
        "totalAmount": 200000,
        "term": 12,
        "monthlyPayment": 17833.3333,
        "rate": 0.07,
        "insuranceEnabled": true,
        "salaryClient": false
    },
    {
        "applicationId": 1,
        "requestedAmount": 100000,
        "totalAmount": 200000,
        "term": 12,
        "monthlyPayment": 17666.6667,
        "rate": 0.06,
        "insuranceEnabled": true,
        "salaryClient": true
    }
]

2. PUT: http://localhost:8081/deal/offer
{
        "applicationId": 1,
        "requestedAmount": 100000,
        "totalAmount": 100000,
        "term": 12,
        "monthlyPayment": 9166.6667,
        "rate": 0.10,
        "insuranceEnabled": false,
        "salaryClient": false
}

3. PUT: http://localhost:8081/deal/calculate/1
{
    "gender" : "MALE",
    "martialStatus" : "SINGLE",
    "dependentAmount" : 0,
    "passportIssueDate" : "2030-05-07",
    "passportIssueBranch" : "^_^",
    "employment" : {
        "employmentStatus" : "EMPLOYED",
        "employerINN" : "123456789012",
        "salary" : 35000,
        "position" : "MID_MANAGER",
        "workExperienceTotal" : 10,
        "workExperienceCurrent" : 1
    },
    "account" : "123123123123"
}
