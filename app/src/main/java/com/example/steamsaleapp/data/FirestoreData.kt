package com.example.steamsaleapp.data

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

//// Access a Cloud Firestore instance from your Activity
//val db = Firebase.firestore

//// Create a new user with a first and last name
//val user = hashMapOf(
//    "first" to "Ada",
//    "last" to "Lovelace",
//    "born" to 1815,
//)
//
//// Add a new document with a generated ID
//db.collection("users")
//.add(user)
//.addOnSuccessListener { documentReference ->
//    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
//}
//.addOnFailureListener { e ->
//    Log.w(TAG, "Error adding document", e)
//}

//// Now add another document to the users collection.
//// Notice that this document includes a key-value pair (middle name) that does not appear in the first document.
//// Documents in a collection can contain different sets of information.

//// Create a new user with a first, middle, and last name
//val user = hashMapOf(
//    "first" to "Alan",
//    "middle" to "Mathison",
//    "last" to "Turing",
//    "born" to 1912,
//)
//
//// Add a new document with a generated ID
//db.collection("users")
//.add(user)
//.addOnSuccessListener { documentReference ->
//    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
//}
//.addOnFailureListener { e ->
//    Log.w(TAG, "Error adding document", e)
//}

//// Read data
//db.collection("users")
//.get()
//.addOnSuccessListener { result ->
//    for (document in result) {
//        Log.d(TAG, "${document.id} => ${document.data}")
//    }
//}
//.addOnFailureListener { exception ->
//    Log.w(TAG, "Error getting documents.", exception)
//}