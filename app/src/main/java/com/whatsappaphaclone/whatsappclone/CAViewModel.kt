package com.whatsappaphaclone.whatsappclone

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CAViewModel @Inject constructor(
    val auth: FirebaseAuth,
    val adb: FirebaseFirestore,
    val storage: FirebaseFirestore
    ): ViewModel() {
}