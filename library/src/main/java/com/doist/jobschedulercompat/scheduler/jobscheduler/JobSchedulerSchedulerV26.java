package com.doist.jobschedulercompat.scheduler.jobscheduler;

import com.doist.jobschedulercompat.JobInfo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@TargetApi(Build.VERSION_CODES.O)
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class JobSchedulerSchedulerV26 extends JobSchedulerSchedulerV24 {
    public static final String TAG = "PlatformSchedulerV26";

    public JobSchedulerSchedulerV26(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public String getTag() {
        return TAG;
    }

    protected android.app.job.JobInfo.Builder toPlatformJob(JobInfo job) {
        android.app.job.JobInfo.Builder builder = super.toPlatformJob(job);

        builder.setTransientExtras(job.getTransientExtras());
        builder.setClipData(job.getClipData(), job.getClipGrantFlags());
        builder.setRequiresBatteryNotLow(job.isRequireBatteryNotLow());
        builder.setRequiresStorageNotLow(job.isRequireStorageNotLow());

        return builder;
    }
}
