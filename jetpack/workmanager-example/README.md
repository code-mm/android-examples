
## 依赖地址



[https://developer.android.google.cn/jetpack/androidx/releases/work#declaring_dependencies](https://developer.android.google.cn/jetpack/androidx/releases/work#declaring_dependencies)





    Worker
    任务的执行者，是一个抽象类，需要继承它实现要执行的任务。

    WorkRequest
    指定让哪个 Woker 执行任务，指定执行的环境，执行的顺序等。
    要使用它的子类 OneTimeWorkRequest 或 PeriodicWorkRequest。

    WorkManager
    管理任务请求和任务队列，发起的 WorkRequest 会进入它的任务队列。

    WorkStatus
    包含有任务的状态和任务的信息，以 LiveData 的形式提供给观察者。



## Example



-----

    import android.content.Context;
    import android.os.SystemClock;
    import android.util.Log;

    import androidx.annotation.NonNull;
    import androidx.work.Data;
    import androidx.work.Worker;
    import androidx.work.WorkerParameters;

    public class ExampleWorker extends Worker {


        private static final String TAG = "ExampleWorker";


        public ExampleWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
            super(context, workerParams);
        }


        @NonNull
        @Override
        public Result doWork() {


            String k = getInputData().getString("k");

            Log.e(TAG, "doWork: " + k);

            for (int i = 0; i <= 5; i++) {
                SystemClock.sleep(1000);
                Log.e(TAG, "doWork: " + i);
            }

            return Result.success(new Data.Builder().putString("k", "World ").build());

        }
    }



-----

    import android.os.Bundle;
    import android.util.Log;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.lifecycle.Observer;
    import androidx.work.Constraints;
    import androidx.work.Data;
    import androidx.work.NetworkType;
    import androidx.work.OneTimeWorkRequest;
    import androidx.work.WorkInfo;
    import androidx.work.WorkManager;

-----



        Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)

                // 不在电量不足时执行
                .setRequiresBatteryNotLow(true)
                // 在充电时执行
                .setRequiresCharging(true)
                // 不在存储容量不足时执行
                .setRequiresStorageNotLow(true)

                // 在待机状态下执行，需要 API 23
                // .setRequiresDeviceIdle(true)
                .build();

        //意味着这个任务只需执行一遍
        final OneTimeWorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(ExampleWorker.class)
                .setConstraints(constraints)
                .setInputData(new Data.Builder().putString("k", "Hello").build())
                .build();
        //将 WorkRequest 加入任务队列

        WorkManager.getInstance(this).enqueue(uploadWorkRequest);

        //获取LiveData 观察数据
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(uploadWorkRequest.getId()).observeForever(new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {

                String v = workInfo.getOutputData().getString("k");

                Log.e(TAG, "onChanged: " + v);
                if (v != null) {
                    Toast.makeText(MainActivity.this, "" + v, Toast.LENGTH_SHORT).show();
                }

            }
        });



