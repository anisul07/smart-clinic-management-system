# Smart Clinic Management System - Database Schema

## Database

Database Name: smart_clinic

## Tables

### Doctors

| Column | Type | Description |
|---|---|---|
| id | BIGINT | Primary key |
| name | VARCHAR(100) | Doctor name |
| speciality | VARCHAR(100) | Medical speciality |
| available_time | VARCHAR(50) | Doctor availability |

### Patients

| Column | Type | Description |
|---|---|---|
| patient_id | BIGINT | Primary key |
| name | VARCHAR(100) | Patient name |
| email | VARCHAR(150) | Patient email |
| phone | VARCHAR(20) | Patient phone |

### Appointments

| Column | Type | Description |
|---|---|---|
| id | BIGINT | Primary key |
| doctor_id | BIGINT | Doctor reference |
| patient_id | BIGINT | Patient reference |
| appointment_time | DATETIME | Appointment date and time |
| status | VARCHAR(50) | Appointment status |

### Prescriptions

| Column | Type | Description |
|---|---|---|
| id | BIGINT | Primary key |
| doctor_id | BIGINT | Doctor reference |
| patient_id | BIGINT | Patient reference |
| medicine | VARCHAR(255) | Medicine details |
| instructions | TEXT | Prescription instructions |

## Relationships

- One doctor can have many appointments.
- One patient can have many appointments.
- An appointment belongs to one doctor and one patient.
- A doctor can create prescriptions for patients.
