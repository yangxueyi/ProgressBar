package com.example.zhang.progressbar;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.yanzhikai.pictureprogressbar.PictureProgressBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private Button btn;
    private PictureProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (PictureProgressBar) findViewById(R.id.progressBar);
        //设置动画效果
        progressBar.setDrawableIds(new int[]{R.drawable.i00,R.drawable.i01,R.drawable.i02,R.drawable.i03,R.drawable.i04,R.drawable.i05,R.drawable.i06});
        //设置progressbar最大值
        progressBar.setMax(100);

        iv = (ImageView) findViewById(R.id.iv);
        btn = (Button) findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                progressBar.setAnimRun(true);
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
                DownloadUtil.get().download(url,"progressbar" ,new DownloadUtil.OnDownloadListener() {
                    @Override
                    public void onDownloadSuccess(final String filePath) throws IOException {
                        //下载结束后，停止动画
                        progressBar.setAnimRun(false);
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
