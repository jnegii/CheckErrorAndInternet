package com.tenten.checkinternetconnectionanderrors;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ErrorDialog extends Dialog {
    public Activity activity;
    private String lblHeading = "ERROR OCCURRED", lblSubtext = "It seem's that some error have been occurred", lottie = "error1.json";
    private TextView heading, subtext;
    private Button retryButton, canclButton;
    private LottieAnimationView lottieAnimationView;


    public ErrorDialog(Activity activity) {
        super(activity);
        this.activity = activity;
        this.lblHeading = lblHeading;
        this.lblSubtext = lblSubtext;
        this.lottie = lottie;

    }

    public void retryButtonSetColor(ColorStateList colorStateList) {
        retryButton = findViewById(R.id.retry);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            retryButton.setBackgroundTintList(colorStateList);
        }

    }

    public void cancelButtonSetColor(ColorStateList colorStateList) {
        canclButton = findViewById(R.id.Cancel);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canclButton.setBackgroundTintList(colorStateList);
        }

    }

    public ErrorDialog(Activity activity, String lblHeading, String lblSubtext, String lottie) {
        super(activity);
        this.activity = activity;
        this.lblHeading = lblHeading;
        this.lblSubtext = lblSubtext;
        this.lottie = lottie;

    }

    public void setBackground(int start,int end){
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.BR_TL,
                new int[] {start,end});
        gd.setCornerRadius(0f);
        RelativeLayout relativeLayout=findViewById(R.id.relativeLayout);
        relativeLayout.setBackground(gd);

    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_layout);
        heading = findViewById(R.id.dialogHeading);
        subtext = findViewById(R.id.dialogSubtext);
        lottieAnimationView = findViewById(R.id.lottieDialog);
        retryButton = findViewById(R.id.retry);
        canclButton = findViewById(R.id.Cancel);
        canclButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                activity.finish();
            }
        });

        if (isNetworkConnected()) {
            heading.setText(lblHeading);
            subtext.setText(lblSubtext);
            lottieAnimationView.setAnimation(lottie);
        } else {
            heading.setText("NO INTERNET");
            subtext.setText("It seem's that you are not connected");
            lottieAnimationView.setAnimation("nonet.json");
        }


        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();

                activity.finish();
                activity.overridePendingTransition(0, 0);
                activity.startActivity(activity.getIntent());
                activity.overridePendingTransition(0, 0);

            }
        });


    }
}