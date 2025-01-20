package com.example.sistem_pakar_beanexpert;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class daftar_penyakit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_penyakit);
        ImageView anthracnoseImageView = findViewById(R.id.anthracnose);
        anthracnoseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Memanggil fungsi untuk menampilkan dialog penjelasan tentang Virus Kuning
                showExplanationDialog("Virus Kuning",
                        "Penyakit kuning pada tanaman kacang panjang sering disebabkan oleh infeksi virus, seperti Virus Kuning Kacang (Bean Yellow Mosaic Virus) atau oleh faktor lain seperti kekurangan nutrisi. Gejala yang muncul meliputi:\n\n" +
                                "1. Daun Menguning:\n" +
                                "- Daun tanaman menunjukkan perubahan warna menjadi kuning, terutama pada bagian atas tanaman. Penguningan ini dapat merata atau muncul dalam bentuk bercak.\n\n" +
                                "2. Pertumbuhan Terhambat:\n" +
                                "- Tanaman mengalami pertumbuhan yang terhambat, dengan ukuran daun yang lebih kecil dan batang yang lemah. Tanaman mungkin tampak kerdil dibandingkan dengan tanaman sehat.\n\n" +
                                "3. Deformasi Daun:\n" +
                                "- Daun dapat mengalami deformasi, seperti keriting atau menggulung, yang mengindikasikan adanya infeksi virus.\n\n" +
                                "4. Kehilangan Produksi:\n" +
                                "- Infeksi yang parah dapat menyebabkan penurunan hasil panen karena gangguan pada proses fotosintesis dan kesehatan tanaman secara keseluruhan.\n\n" +
                                "5. Penyebaran Gejala:\n" +
                                "- Gejala dapat menyebar dengan cepat, terutama jika ada vektor seperti kutu daun yang menghisap getah tanaman.\n\n" +
                                "Pencegahan dan Pengendalian:\n\n" +
                                "- Pengendalian Vektor: Mengendalikan serangga penghisap, seperti kutu daun, yang dapat menyebarkan virus.\n" +
                                "- Praktik Budidaya yang Baik: Melakukan rotasi tanaman dan memilih lokasi tanam yang tidak terinfeksi.\n" +
                                "- Sanitasi: Membersihkan sisa-sisa tanaman yang terinfeksi dan menjaga kebersihan alat pertanian untuk mencegah penyebaran virus.\n" +
                                "- Penggunaan Varietas Tahan: Memilih varietas kacang panjang yang telah terbukti tahan terhadap infeksi virus.\n" +
                                "- Monitoring dan Tindakan Cepat: Melakukan pemantauan rutin terhadap gejala penyakit dan segera mengambil tindakan jika ditemukan infeksi."
                );
            }

        });
        ImageView downyMildewImageView = findViewById(R.id.downymildew);
        downyMildewImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Memanggil fungsi untuk menampilkan dialog penjelasan tentang Karat Daun
                showExplanationDialog("Bercak Daun",
                        "Bercak Daun pada tanaman kacang panjang adalah penyakit yang disebabkan oleh berbagai patogen, termasuk jamur dan bakteri. Salah satu penyebab umum bercak daun adalah infeksi oleh jamur seperti Corynespora cassiicola atau Alternaria spp.. Gejala yang muncul meliputi:\n\n" +
                                "1. Bercak Cokelat atau Hitam pada Daun:\n" +
                                "- Daun tanaman menunjukkan bercak berwarna cokelat atau hitam yang dapat bervariasi dalam ukuran. Bercak ini biasanya muncul di bagian tengah atau tepi daun.\n\n" +
                                "2. Bercak dengan Pusat yang Terang:\n" +
                                "- Bercak dapat memiliki pusat yang lebih terang atau kuning di sekelilingnya, memberikan tampilan kontras yang jelas.\n\n" +
                                "3. Penyebaran Bercak:\n" +
                                "- Seiring waktu, bercak dapat menyebar dan bergabung, menyebabkan area yang lebih besar dari daun menjadi terinfeksi.\n\n" +
                                "4. Daun Menguning dan Layu:\n" +
                                "- Daun yang terinfeksi dapat mengalami penguningan dan layu, yang dapat mengakibatkan penurunan fotosintesis dan pertumbuhan tanaman.\n\n" +
                                "5. Penurunan Hasil:\n" +
                                "- Infeksi yang parah dapat menyebabkan penurunan hasil panen karena gangguan pada proses fotosintesis dan kesehatan tanaman secara keseluruhan.\n\n" +
                                "Pencegahan dan Pengendalian:\n\n" +
                                "- Pilih Varietas Tahan: Menggunakan varietas kacang panjang yang telah terbukti tahan terhadap bercak daun.\n" +
                                "- Praktik Budidaya yang Baik: Melakukan rotasi tanaman dan menjaga jarak tanam yang cukup untuk meningkatkan sirkulasi udara.\n" +
                                "- Sanitasi: Membersihkan sisa-sisa tanaman yang terinfeksi dan menjaga kebersihan alat pertanian untuk mencegah penyebaran patogen.\n" +
                                "- Kontrol Kelembaban: Menghindari genangan air dan menjaga kelembaban tanah yang seimbang untuk mencegah kondisi yang mendukung pertumbuhan jamur.\n" +
                                "- Penggunaan Fungisida: Jika penyakit muncul, gunakan fungisida yang direkomendasikan untuk mengendalikan infeksi."
                );

            }
        });

        ImageView mosaicVirusImageView = findViewById(R.id.mosaicvirus);
        mosaicVirusImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Memanggil fungsi untuk menampilkan dialog penjelasan tentang Bercak Daun
                // Memanggil fungsi untuk menampilkan dialog penjelasan tentang Karat Daun
                showExplanationDialog("Karat Daun",
                        "Karat Daun pada tanaman kacang panjang disebabkan oleh jamur Uromyces sp. Gejala yang muncul meliputi:\n\n" +
                                "1. Bercak Kecil Berwarna Cokelat:\n" +
                                "- Bercak ini muncul di bawah daun dan dapat berkembang menjadi bintik yang lebih besar seiring waktu.\n\n" +
                                "2. Bintik Berkarat di Permukaan Atas:\n" +
                                "- Bintik-bintik ini dapat terlihat di permukaan atas daun, memberikan tampilan berkarat yang khas.\n\n" +
                                "3. Daun Menguning dan Layu:\n" +
                                "- Daun yang terinfeksi dapat menguning dan layu, yang mengakibatkan kerontokan daun.\n\n" +
                                "4. Kerugian Hasil:\n" +
                                "- Infeksi yang parah dapat menyebabkan penurunan hasil panen yang signifikan karena gangguan pada fotosintesis.\n\n" +
                                "Pencegahan dan Pengendalian:\n\n" +
                                "- Gunakan Benih Sehat: Pastikan untuk menggunakan benih dari tanaman yang sehat atau bersertifikat.\n" +
                                "- Tanam Varietas Tahan: Pilih varietas kacang panjang yang tahan terhadap karat daun.\n" +
                                "- Kontrol Kelembaban: Jaga jarak tanam untuk mengurangi kelembaban di antara tanaman.\n" +
                                "- Sanitasi: Singkirkan sisa-sisa tanaman yang terinfeksi dan gulma di sekitar lahan.\n" +
                                "- Rotasi Tanaman: Lakukan rotasi tanaman dengan tanaman non-inang setiap tiga hingga empat tahun.\n" +
                                "- Penggunaan Fungisida: Jika diperlukan, gunakan fungisida yang mengandung mankozeb atau propikonazol untuk mengendalikan infeksi."
                );

            }
        });
    }
    private void showExplanationDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogCustom);
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
}