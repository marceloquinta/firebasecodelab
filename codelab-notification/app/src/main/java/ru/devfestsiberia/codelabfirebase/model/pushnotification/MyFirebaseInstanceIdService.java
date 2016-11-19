package ru.devfestsiberia.codelabfirebase.model.pushnotification;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;


public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private static final String FRIENDLY_ENGAGE_TOPIC = "friendly_engage";


    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        Log.d("PUSH", "Refreshed token: " + refreshedToken);
        FirebaseMessaging.getInstance().subscribeToTopic(FRIENDLY_ENGAGE_TOPIC);

    }
}
