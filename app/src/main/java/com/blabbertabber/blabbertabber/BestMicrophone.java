package com.blabbertabber.blabbertabber;

import android.media.MediaRecorder;
import android.util.Log;

/**
 * Created by cunnie on 10/6/15.
 * <p/>
 * Determines the best Microphone (MediaRecorder.AudioSource.XXX) to use
 */

public class BestMicrophone {
    private static final String TAG = "BestMicrophone()";
    // Different mics work better for different models
    // e.g. Nexus 5 == MIC; Nexus 6 == VOICE_RECOGNITION
    // http://stackoverflow.com/questions/1995439/get-android-phone-model-programmatically
    //
    // NEXUS 6            MediaRecorder.AudioSource.
    //
    // kinda works:       CAMCORDER
    //                    VOICE_RECOGNITION
    // terrible:          DEFAULT
    //                    MIC
    //                    VOICE_COMMUNICATION
    // RuntimeException:  VOICE_UPLINK
    //                    REMOTE_SUBMIX
    //                    VOICE_CALL
    //                    VOICE_DOWNLINK

    public static int getBestMicrophone() {
        return getBestMicrophone(new BuildMODEL());
    }

    // method
    public static int getBestMicrophone(BuildMODEL buildModel) {
        String model = buildModel.model();
        Log.v(TAG, "getBestMicrophone() Build.MODEL == " + model);
        switch (model) {
            case "Nexus 4":
            case "Nexus 5":
                return (MediaRecorder.AudioSource.MIC);
            case "Nexus 6":
                return (MediaRecorder.AudioSource.VOICE_RECOGNITION);
            case "Nexus 5X":
            default:
                Log.v(TAG, "getBestMicrophone() FIXME new model: " + model);
                return (MediaRecorder.AudioSource.DEFAULT);
        }

    }
}
