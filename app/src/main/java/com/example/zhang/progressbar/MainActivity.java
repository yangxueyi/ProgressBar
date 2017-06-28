package com.example.zhang.progressbar;

import android.os.Environment;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ImageView iv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        iv = (ImageView) findViewById(R.id.iv);
        btn = (Button) findViewById(R.id.btn);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initListener();
            }
        });
    }


    private void initListener() {

//        String  url = "http://img0.imgtn.bdimg.com/it/u=1533131918,1872074056&fm=26&gp=0.jpg";
        final String  url = "http://192.168.200.225:6868/222.jpg";
        new Thread(new Runnable() {
            @Override
            public void run() {
                DownloadUtil.get().download(url, "progressbar", new DownloadUtil.OnDownloadListener() {

                    @Override
                    public void onDownloadSuccess(final String filePath) throws IOException {

                        //下载完成显示到imageview上面
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Glide.with(MainActivity.this)
                                        .load(filePath)
                                        .into(iv);
                            }
                        });

                        Looper.prepare();
                        Toast.makeText(MainActivity.this, "下载完成", Toast.LENGTH_LONG).show();
                        Looper.loop();


                    }

                    @Override
                    public void onDownloading(int progress) {
                        //设置进度条进度
                        progressBar.setProgress(progress);
                    }

                    @Override
                    public void onDownloadFailed() {
                        Looper.prepare();
                        Toast.makeText(MainActivity.this,"下载失败",Toast.LENGTH_LONG).show();
                        Looper.loop();
                    }
                });
            }
        }).start();

    }

}
