package com.lockwood.automata.intent

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract
import com.lockwood.automata.android.buildIntent
import com.lockwood.automata.android.safeLaunchActivity
import com.lockwood.automata.android.safeLaunchActivityForResult

fun Activity.selectContact(
    requestCode: Int,
    onFailure: () -> Unit = {}
) {
    val intent = buildIntent(Intent.ACTION_PICK) {
        type = ContactsContract.Contacts.CONTENT_TYPE
    }

    safeLaunchActivityForResult(
        intent = intent,
        requestCode = requestCode,
        onNoActivityToResolve = onFailure
    )
}

fun Activity.selectContactByPhone(
    requestCode: Int,
    onFailure: () -> Unit = {}
) {
    val intent = Intent(Intent.ACTION_PICK).apply {
        type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
    }

    safeLaunchActivityForResult(
        intent = intent,
        requestCode = requestCode,
        onNoActivityToResolve = onFailure
    )
}

fun Context.viewContact(
    contactUri: Uri,
    onFailure: () -> Unit = {}
) {
    val intent = buildIntent(Intent.ACTION_VIEW, contactUri)

    safeLaunchActivity(
        intent = intent,
        onNoActivityToResolve = onFailure
    )
}

fun Context.editContactMail(
    contactUri: Uri,
    email: String,
    onFailure: () -> Unit = {}
) {
    val mailExtra = Pair(ContactsContract.Intents.Insert.EMAIL, email)

    editContact(
        contactUri = contactUri,
        extraToPut = mailExtra,
        onFailure = onFailure
    )
}

fun Context.editContact(
    contactUri: Uri,
    extraToPut: Pair<String, String>,
    onFailure: () -> Unit = {}
) {
    val (name, value) = extraToPut

    val intent = buildIntent(Intent.ACTION_EDIT, contactUri) {
        putExtra(name, value)
    }

    safeLaunchActivity(
        intent = intent,
        onNoActivityToResolve = onFailure
    )
}

fun Context.insertContact(
    name: String,
    email: String,
    onFailure: () -> Unit = {}
) {
    val intent = buildIntent(Intent.ACTION_INSERT) {
        type = ContactsContract.Contacts.CONTENT_TYPE
        putExtra(ContactsContract.Intents.Insert.NAME, name)
        putExtra(ContactsContract.Intents.Insert.EMAIL, email)
    }

    safeLaunchActivity(
        intent = intent,
        onNoActivityToResolve = onFailure
    )
}