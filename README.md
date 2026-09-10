# Student Voice – Course Feedback

## 1. Experiment Title

Student Voice – Course Feedback

## 2. Aim

To develop an Android application called Student Voice to collect student feedback about a course using different Android UI components, Intent, Toast, Notification and Activity Lifecycle methods.

## 3. Scenario

A university wants to collect student feedback about its courses through an Android application called Student Voice.

The application allows students to enter their name and course name, select a course rating, choose whether they recommend the course, agree to submit the feedback, and submit the feedback.

After submission, the application navigates to the Feedback Summary screen and displays the entered information. A success Toast message and Android notification are also generated.

## 4. Technologies Used

- Android Studio
- Kotlin
- XML
- Android SDK
- Activities
- Intent
- EditText
- RadioGroup
- RadioButton
- Switch
- CheckBox
- Button
- Toast
- Android Notification
- Activity Lifecycle
- Logcat

## 5. Concepts Used

### EditText

Used to enter Student Name and Course Name.

### RadioGroup and RadioButton

Used to select one course rating:

- Excellent
- Good
- Average
- Poor

### Switch

Used to select whether the student recommends the course.

### CheckBox

Used to confirm that the student agrees to submit the feedback.

### Button

Used to submit the feedback.

### Intent

Used to transfer feedback details from MainActivity to SummaryActivity.

### Toast

Displays a success message after feedback submission.

### Notification

Generates an Android notification after successful submission.

### Activity Lifecycle

The application demonstrates:

- onCreate()
- onStart()
- onResume()
- onPause()
- onStop()
- onDestroy()

Lifecycle messages can be viewed in Android Studio Logcat.

## 6. Application Flow

```text
Start Application
       |
       v
Student Voice Screen
       |
       v
Enter Student Details
       |
       v
Select Course Rating
       |
       v
Select Recommendation
       |
       v
Accept Agreement
       |
       v
Submit Feedback
       |
       v
Feedback Summary Screen
       |
       v
Toast + Notification
