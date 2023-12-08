package com.example.steamsaleapp.data

import com.google.firebase.firestore.FirebaseFirestore

object FireStoreInstance {
    private var instance: FirebaseFirestore? = null

    fun getInstance(): FirebaseFirestore{
        synchronized(this){
            if (instance == null){
                instance = FirebaseFirestore.getInstance()
            }
        }
        return instance!!
    }
}

//Button(onClick = {
//    isIconChanged = !isIconChanged
//
//    val beerDocRef =
//        fsInstance.collection("favorites").document(beerItem.id.toString())
//
//    // adding a beer to firestore document collection
//    if (isIconChanged) {
//        beerDocRef.set(beerItem)
//            .addOnSuccessListener {
//                Log.d("MJB", "Inserted ${beerItem.name}")
//            }
//            .addOnFailureListener { e ->
//                Log.d("Error", "${e.message}")
//            }
//    }else{
//        beerDocRef.delete()
//            .addOnSuccessListener {
//                Log.d("MJB", "Deleted ${beerItem.name}")
//            }
//            .addOnFailureListener{ e->
//                Log.d("Error", "${e.message}")
//            }
//    }
//}
//) {
//    Icon(
//        modifier = Modifier
//            .size(24.dp)
//            .scale(2.5f),
//        imageVector = if (isIconChanged) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
//        contentDescription = "Add a farvoite"
//    )
//}