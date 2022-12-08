package com.example.flutter_segment;

import android.os.Bundle;

import java.util.HashMap;

public class FlutterSegmentOptions {
    private final String writeKey;
    private final String apiHost;
    private final Boolean trackApplicationLifecycleEvents;
    private final Boolean amplitudeIntegrationEnabled;
    private final Boolean appsflyerIntegrationEnabled;
    private final Boolean debug;

    public  FlutterSegmentOptions(
            String writeKey,
            String apiHost,
            Boolean trackApplicationLifecycleEvents,
            Boolean amplitudeIntegrationEnabled,
            Boolean appsflyerIntegrationEnabled,
            Boolean debug
    ) {
        this.writeKey = writeKey;
        this.apiHost = apiHost;
        this.trackApplicationLifecycleEvents = trackApplicationLifecycleEvents;
        this.amplitudeIntegrationEnabled = amplitudeIntegrationEnabled;
        this.appsflyerIntegrationEnabled = appsflyerIntegrationEnabled;
        this.debug = debug;
    }

    public String getWriteKey() {
        return writeKey;
    }

    public String getApiHost() {
        return apiHost;
    }

    public Boolean getTrackApplicationLifecycleEvents() {
        return trackApplicationLifecycleEvents;
    }

    public Boolean isAmplitudeIntegrationEnabled() {
        return amplitudeIntegrationEnabled;
    }

    public Boolean isAppsflyerIntegrationEnabled() {
        return appsflyerIntegrationEnabled;
    }

    public Boolean getDebug() {
        return debug;
    }

    static FlutterSegmentOptions create(Bundle bundle) {
        String writeKey = bundle.getString("com.claimsforce.segment.WRITE_KEY");
        String apiHost = bundle.getString("com.claimsforce.segment.API_HOST");
        Boolean trackApplicationLifecycleEvents = bundle.getBoolean("com.claimsforce.segment.TRACK_APPLICATION_LIFECYCLE_EVENTS");
        Boolean isAmplitudeIntegrationEnabled = bundle.getBoolean("com.claimsforce.segment.ENABLE_AMPLITUDE_INTEGRATION", false);
        Boolean isAppsflyerIntegrationEnabled = bundle.getBoolean("com.claimsforce.segment.ENABLE_APPSFLYER_INTEGRATION", false);
        Boolean debug = bundle.getBoolean("com.claimsforce.segment.DEBUG", false);
        return new FlutterSegmentOptions(writeKey, apiHost, trackApplicationLifecycleEvents, isAmplitudeIntegrationEnabled, isAppsflyerIntegrationEnabled, debug);
    }

    static FlutterSegmentOptions create(HashMap<String, Object> options) {
        String writeKey = (String) options.get("writeKey");
        String apiHost = (String) options.get("apiHost");
        Boolean trackApplicationLifecycleEvents = (Boolean) options.get("trackApplicationLifecycleEvents");
        Boolean isAmplitudeIntegrationEnabled = orFalse((Boolean) options.get("amplitudeIntegrationEnabled"));
        Boolean isAppsflyerIntegrationEnabled = orFalse((Boolean) options.get("appsflyerIntegrationEnabled"));
        Boolean debug = orFalse((Boolean) options.get("debug"));
        return new FlutterSegmentOptions(writeKey, apiHost, trackApplicationLifecycleEvents, isAmplitudeIntegrationEnabled, isAppsflyerIntegrationEnabled, debug);
    }

    private static Boolean orFalse(Boolean value) {
        return value == null ? false : value;
    }
}
