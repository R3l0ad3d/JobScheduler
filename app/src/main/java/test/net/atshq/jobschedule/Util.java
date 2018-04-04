package test.net.atshq.jobschedule;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;

public class Util {
    private static int count=0;

    private static JobInfo builder;
    private static JobScheduler scheduler;
    public static void scheduleJob(Context context){

        Log.wtf("Util class :"," here ....");

        ComponentName serviceComponent = new ComponentName(context.getPackageName(),MyJob.class.getName());


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            builder = new JobInfo.Builder(count++, serviceComponent)
                    .setMinimumLatency(3000)
                    .build();

            Log.wtf("Noughat : ","here");
        } else {
            builder = new JobInfo.Builder(count++, serviceComponent)
                    .setPeriodic(3000).build();
            Log.wtf("below Noughat : ","here");
        }
        scheduler = (JobScheduler)context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        if(scheduler.schedule(builder)==JobScheduler.RESULT_SUCCESS){
            Log.wtf("Success  : ","Job Create Success ...");

            for(int i=0;i<scheduler.getAllPendingJobs().size();i++){
                Log.wtf("Job List : ",scheduler.getAllPendingJobs().get(i).toString());
            }

        }else {
            Log.wtf("Error  : ","Job error ...");
        }
    }

    public static void clearJob(){
        if(scheduler!=null){
            for(int i=0;i<scheduler.getAllPendingJobs().size();i++){
                Log.wtf("Job List : ",scheduler.getAllPendingJobs().get(i).toString());
            }
            scheduler.cancelAll();
        }else {
            Log.wtf("cancel : ","null found ...");
        }
    }
}
