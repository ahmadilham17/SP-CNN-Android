package com.example.sistem_pakar_beanexpert;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sistem_pakar_beanexpert.ml.Sazara;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
public class deteksi extends AppCompatActivity {
    ImageView imageView;
    ImageButton button1, button2;
    int imageSize = 128;
    TextView confidence, solusi, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deteksi);
        ImageButton button = (ImageButton) findViewById(R.id.button2);
        this.button2 = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.example.imageclassifier.MainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent cameraIntent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                deteksi.this.startActivityForResult(cameraIntent, 1);
            }
        });

        result = findViewById(R.id.hasilprediksi);
        confidence = findViewById(R.id.hasilklasifikasi);
        solusi = findViewById(R.id.solusi);
        imageView = findViewById(R.id.imageView);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (deteksi.this.checkSelfPermission("android.permission.CAMERA") == PackageManager.PERMISSION_GRANTED) {
                    Intent cameraIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                    deteksi.this.startActivityForResult(cameraIntent, 3);
//                    return;
//                }
//                deteksi.this.requestPermissions(new String[]{"android.permission.CAMERA"}, 100);
            }
        });
    }
    public void classifyImage(Bitmap image) {
        try {
            Sazara model = Sazara.newInstance(this);

            int imageSize = 128; // Sesuaikan dengan ukuran input model

            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, imageSize, imageSize, 3}, DataType.FLOAT32);

            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(imageSize * imageSize * 3 * 4); // 4 bytes per float
            byteBuffer.order(ByteOrder.nativeOrder());

            int[] intValues = new int[imageSize * imageSize];
            image.getPixels(intValues, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
            int pixel = 0;
            for (int i = 0; i < imageSize; ++i) {
                for (int j = 0; j < imageSize; ++j) {
                    int val = intValues[pixel++];
                    byteBuffer.putFloat(((val >> 16) & 0xFF) * 0.003921569f);
                    byteBuffer.putFloat(((val >> 8) & 0xFF) * 0.003921569f);
                    byteBuffer.putFloat((val & 0xFF) * 0.003921569f);
                }
            }
            inputFeature0.loadBuffer(byteBuffer);
            Sazara.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
            float[] confidences = outputFeature0.getFloatArray();

            int maxPos = 0;
            float maxConfidence = 0.0f;
            for (int i = 0; i < confidences.length; ++i) {
                if (confidences[i] > maxConfidence) {
                    maxConfidence = confidences[i];
                    maxPos = i;
                }
            }

            String[] classes = {"Kuning", "Bercak_daun", "Karat_daun"};

            result.setText(classes[maxPos]);
            if (classes[maxPos].equals("Kuning")) {
                String more = "Selengkapnya";
                String solutionText = getString(R.string.solution_text_kuning);
                // Underline and make it clickable
                SpannableString content = new SpannableString(solutionText + "\n " + more);

                content.setSpan(new UnderlineSpan(), solutionText.length() + 1, content.length(), 0);
                content.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        showExplanationDialog("Penyakit_Kuning",
                                getString(R.string.message_penyakit_kuning));
                    }
                }, solutionText.length() + 1, content.length(), 0);

                // Set the styled text to the TextView
                solusi.setText(content);
                solusi.setMovementMethod(LinkMovementMethod.getInstance());
            }else if(classes[maxPos].equals("Bercak_Daun")){
                String more = "Selengkapnya";
                String solutionText = getString(R.string.solution_text_bercak_daun);

                // Underline and make it clickable
                SpannableString content = new SpannableString(solutionText + " " + more);

                content.setSpan(new UnderlineSpan(), solutionText.length() + 1, content.length(), 0);
                content.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        showExplanationDialog("Bercak_Daun",
                                getString(R.string.solution_text_bercak_daun));
                    }
                }, solutionText.length() + 1, content.length(), 0);

                // Set the styled text to the TextView
                solusi.setText(content);
                solusi.setMovementMethod(LinkMovementMethod.getInstance());
            }else if(classes[maxPos].equals("Karat_Daun")){
                String more = "Selengkapnya";
                String solutionText = getString(R.string.solution_text_karat_daun);

                // Underline and make it clickable
                SpannableString content = new SpannableString(solutionText + "\n " + more);

                content.setSpan(new UnderlineSpan(), solutionText.length() + 1, content.length(), 0);
                content.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        showExplanationDialog("Karat Daun",
                                getString(R.string.solution_text_karat_daun));
                    }
                }, solutionText.length() + 1, content.length(), 0);

                // Set the styled text to the TextView
                solusi.setText(content);
                solusi.setMovementMethod(LinkMovementMethod.getInstance());
            }

            String s = "";
            for (int i = 0; i < classes.length; ++i) {
                s = s + String.format("%s: %.1f%%\n", classes[i], confidences[i] * 100.0f);
            }
            confidence.setText(s);

            model.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showExplanationDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User mengklik tombol OK.
                        dialog.dismiss();
                    }
                })
                .show();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 3) { // Handle camera result
                Bitmap image = (Bitmap) data.getExtras().get("data");
                int dimension = Math.min(image.getWidth(), image.getHeight());
                Bitmap image2 = ThumbnailUtils.extractThumbnail(image, dimension, dimension);
                this.imageView.setImageBitmap(image2);
                int i = this.imageSize;
                classifyImage(Bitmap.createScaledBitmap(image2, i, i, false));
            } else if (requestCode == 1) { // Handle gallery result
                Uri dat = data.getData();
                if (dat != null) {
                    Bitmap image3 = null;
                    try {
                        image3 = MediaStore.Images.Media.getBitmap(getContentResolver(), dat);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (image3 != null) {
                        this.imageView.setImageBitmap(image3);
                        int i2 = this.imageSize;
                        classifyImage(Bitmap.createScaledBitmap(image3, i2, i2, false));
                    }
                }
            }
        } else if (resultCode == RESULT_CANCELED) {
            Intent backIntent = new Intent(this, deteksi.class);
            startActivity(backIntent);
            finish(); // Optional: finish the current activity
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
