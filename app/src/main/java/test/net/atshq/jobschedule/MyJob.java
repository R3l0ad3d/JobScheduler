package test.net.atshq.jobschedule;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;


public class MyJob extends JobService {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("My Job : ","Create ....");
    }

    @Override
    public boolean onStartJob(JobParameters params) {

        NotificationClass noti = new NotificationClass(getApplicationContext());
        noti.showNotification();

        Log.wtf("My Job : ","Started ...");
        Toast.makeText(this, "Job start ...", Toast.LENGTH_SHORT).show();

        //if Periodic time less than 15 min then use this [jobFinished(params,true);]
        jobFinished(params,true);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.wtf("My Job : ","Stop ...");
        return false;
    }
}
