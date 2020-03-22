package com.tenten.checkinternetconnectionanderrors;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;

import java.util.HashMap;

public class ErrorDialog extends Dialog {
    public Activity activity;
    private final View.OnClickListener retryListner, cancellistner;
    private String lblHeading = null, lblSubtext = null, lottie = "nonet.json";

    private String nonetLblHeading = null, nonetlblSubtext = null, nonetlottie = "error1.json";
    private TextView heading, subtext;
    private MaterialButton retryButton, canclButton;
    private LottieAnimationView lottieAnimationView;
    private RelativeLayout relativeLayout;
    private int gradientStart, gradientEnd;
    private boolean check = false;
    private int cancelStrokeColor, retryBtnColor, retrybtnTextColor, canclBtnTextColor;


    private ErrorDialog(Activity activity, int gradientStart, int gradientEnd, int cancelStrokeColor, int canclBtnTextColor, int retryBtnColor, int retryBtnTextColor, String lblHeading, String lblSubtext, String nonetLblHeading, String nonetlblSubtext
            , View.OnClickListener retryListner, View.OnClickListener cancellistner) {
        super(activity);
        this.activity = activity;
        this.gradientStart = gradientStart == 0 ? Color.parseColor("#FFAB00") : gradientStart;
        this.gradientEnd = gradientEnd == 0 ? Color.parseColor("#FFD600") : gradientEnd;
        this.cancelStrokeColor = cancelStrokeColor == 0 ? Color.parseColor("#ffffff") : cancelStrokeColor;
        this.canclBtnTextColor = canclBtnTextColor == 0 ? Color.parseColor("#ffffff") : canclBtnTextColor;

        this.retryBtnColor = retryBtnColor == 0 ? Color.parseColor("#000000") : retryBtnColor;
        this.retrybtnTextColor = retryBtnTextColor == 0 ? Color.parseColor("#ffffff") : retryBtnTextColor;
        this.lblHeading = lblHeading == null ? "NO INTERNET" : lblHeading;
        this.lblSubtext = lblSubtext == null ? "It seem's that you are not connected" : lblSubtext;

        this.nonetLblHeading = nonetLblHeading == null ? "ERROR OCCURRED" : nonetLblHeading;
        this.nonetlblSubtext = nonetlblSubtext == null ? "It seem's that some error have been occurred" : nonetlblSubtext;
        this.retryListner = retryListner;
        this.cancellistner = cancellistner;
    }


    private ErrorDialog(Activity activity, int gradientStart, int gradientEnd, int cancelStrokeColor, int canclBtnTextColor, int retryBtnColor, int retryBtnTextColor, String lblHeading, String lblSubtext, String nonetLblHeading, String nonetlblSubtext
            , View.OnClickListener retryListner, View.OnClickListener cancellistner, boolean check) {
        super(activity);
        this.activity = activity;
        this.gradientStart = gradientStart == 0 ? Color.parseColor("#FFAB00") : gradientStart;
        this.gradientEnd = gradientEnd == 0 ? Color.parseColor("#FFD600") : gradientEnd;
        this.cancelStrokeColor = cancelStrokeColor == 0 ? Color.parseColor("#ffffff") : cancelStrokeColor;
        this.canclBtnTextColor = canclBtnTextColor == 0 ? Color.parseColor("#ffffff") : canclBtnTextColor;

        this.retryBtnColor = retryBtnColor == 0 ? Color.parseColor("#000000") : retryBtnColor;
        this.retrybtnTextColor = retryBtnTextColor == 0 ? Color.parseColor("#ffffff") : retryBtnTextColor;
        this.lblHeading = lblHeading == null ? "ERROR OCCURRED" : lblHeading;
        this.lblSubtext = lblSubtext == null ? "It seem's that some error have been occurred" : lblSubtext;

        this.nonetLblHeading = nonetLblHeading == null ? "NO INTERNET" : nonetLblHeading;
        this.nonetlblSubtext = nonetlblSubtext == null ? "It seem's that you are not connected" : nonetlblSubtext;
        this.retryListner = retryListner;
        this.cancellistner = cancellistner;
        this.check = check;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        initViews();
        setBackground();
        setButtonBackgroundColor();

        checkConnectAndSetText();
        setCancelButtonTextColor();
        setRetryButtonBackgroundColor();
        setRetryButtonTextColor();


//        if (!onlyInternet()) {
//            heading.setText(nonetLblHeading);
//            subtext.setText(nonetlblSubtext);
//            lottieAnimationView.setAnimation(nonetlottie);
//        }


        canclButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cancellistner == null) {
                    dismiss();
                    activity.finish();
                } else {
                    cancellistner.onClick(view);
                }

            }
        });


        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (retryListner == null) {
                    dismiss();

                    activity.finish();
                    activity.overridePendingTransition(0, 0);
                    activity.startActivity(activity.getIntent());
                    activity.overridePendingTransition(0, 0);
                } else {
                    retryListner.onClick(view);
                }

            }
        });


    }

    public void setBackground() {
        relativeLayout = findViewById(R.id.relativeLayout);
        int[] colors = {gradientStart, gradientEnd};
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, colors);
        gd.setCornerRadius(20);
        relativeLayout.setBackground(gd);

    }

    public void setButtonBackgroundColor() {
        canclButton.setStrokeColor(ColorStateList.valueOf(cancelStrokeColor));

    }

    public void setCancelButtonTextColor() {
        canclButton.setTextColor(canclBtnTextColor);

    }


    public void setRetryButtonBackgroundColor() {
        retryButton.setBackgroundColor(retryBtnColor);

    }

    public void setRetryButtonTextColor() {
        retryButton.setTextColor(retrybtnTextColor);

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    private void checkConnectAndSetText() {
        if (!isNetworkConnected()) {
            heading.setText(lblHeading);
            subtext.setText(lblSubtext);
            lottieAnimationView.setAnimation(lottie);
        } else {
            heading.setText(nonetLblHeading);
            subtext.setText(nonetlblSubtext);
            lottieAnimationView.setAnimation(nonetlottie);
        }
    }

    private boolean onlyInternet() {
        if (!isNetworkConnected()) {
            return false;
        } else {
           return true;
        }
    }

    private void initViews() {
        relativeLayout = findViewById(R.id.relativeLayout);
        heading = findViewById(R.id.dialogHeading);
        subtext = findViewById(R.id.dialogSubtext);
        lottieAnimationView = findViewById(R.id.lottieDialog);
        retryButton = findViewById(R.id.retry);
        canclButton = findViewById(R.id.Cancel);
    }

    public static class Builder {
        private int startgradient, endgradient, strokecolor, canclBtnTextColor, retryBtnColor, retrybtnTextColor;
        private Activity activity;
        private String lblHeading, lblSubtext, nonetLblHeading, nonetlblSubtext;
        private View.OnClickListener onClickListener, cancellistner;

        public Builder(Activity activity) {
            this.activity = activity;

        }

        /**
         * @param startgradient
         * @param endgradient
         * @return
         */
        public Builder setBackgroundGradient(int startgradient, int endgradient) {
            this.startgradient = startgradient;
            this.endgradient = endgradient;
            return this;
        }

        public Builder setCancelButtonStrokeColor(int strokecolor) {
            this.strokecolor = strokecolor;
            return this;
        }

        public Builder setCancelButtonTextColor(int canclBtnTextColor) {
            this.canclBtnTextColor = canclBtnTextColor;
            return this;
        }


        public Builder setReryButtonTextColor(int retrybtnTextColor) {
            this.retrybtnTextColor = retrybtnTextColor;
            return this;
        }

        public Builder setReryButtonColor(int retryBtnColor) {
            this.retryBtnColor = retryBtnColor;
            return this;
        }


        public Builder setErrorOccuredHeading(String lblHeading) {
            this.lblHeading = lblHeading;
            return this;
        }

        public Builder setErrorOccuredSubText(String lblSubtext) {
            this.lblSubtext = lblSubtext;
            return this;
        }


        public Builder setNoInternetHeading(String nonetLblHeading) {
            this.nonetLblHeading = nonetLblHeading;
            return this;
        }

        public Builder setNoInternetSubText(String nonetlblSubtext) {
            this.nonetlblSubtext = nonetlblSubtext;
            return this;
        }

        public Builder setRetryButtonClickListner(View.OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
            return this;
        }


        public Builder setCancelButtonClickListner(View.OnClickListener cancellistner) {
            this.cancellistner = cancellistner;
            return this;
        }


        public ErrorDialog build() {
            ErrorDialog errorDialog = new ErrorDialog(activity, startgradient, endgradient, strokecolor, canclBtnTextColor, retryBtnColor, retrybtnTextColor, lblHeading, lblSubtext, nonetLblHeading, nonetlblSubtext,
                    onClickListener, cancellistner);
            errorDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            errorDialog.setCanceledOnTouchOutside(true);
            errorDialog.setCancelable(false);
            errorDialog.show();
            return errorDialog;
        }

        public boolean buildCheckInternetOnly() {

            ErrorDialog errorDialog = new ErrorDialog(activity, startgradient, endgradient, strokecolor, canclBtnTextColor, retryBtnColor, retrybtnTextColor, "NO INTERNET", "It seem's that you are not connected", nonetLblHeading, nonetlblSubtext,
                    onClickListener, cancellistner, true);
            errorDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            errorDialog.setCanceledOnTouchOutside(true);
            errorDialog.setCancelable(false);
            if (!errorDialog.onlyInternet()) {
                errorDialog.show();
                return false;
            } else {
                return true;
            }


        }

    }
}

